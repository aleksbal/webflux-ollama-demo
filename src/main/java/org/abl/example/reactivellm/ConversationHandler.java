package org.abl.example.reactivellm;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ConversationHandler implements WebSocketHandler {
	private final WebClient webClient = WebClient.builder()
			.baseUrl("http://localhost:11434")
			.build();

	@Override
	public Mono<Void> handle(WebSocketSession session) {
		// Listen to WebSocket messages and forward streamed response chunks
		return session.receive()
				.flatMap(message -> {
					String prompt = message.getPayloadAsText();
					return session.send(
							sendToOllamaStreaming(prompt)
									.map(session::textMessage)
					);
				})
				.then(); // Ensure Mono<Void> is returned
	}

	private Flux<String> sendToOllamaStreaming(String prompt) {
		return webClient.post()
				.uri("/api/generate")
				.bodyValue(new OllamaRequest("llama3.2", true, prompt))
				.retrieve()
				.bodyToFlux(OllamaChunk.class)
				.map(OllamaChunk::response) // Extract the "response" field from each chunk
				.onErrorResume(error -> Flux.just("Error: " + error.getMessage())); // Handle errors gracefully
	}

	// Record for the request payload
	record OllamaRequest(String model, boolean stream, String prompt) { }

	// Record for a single chunk in the streaming response
	record OllamaChunk(String response) { }
}
