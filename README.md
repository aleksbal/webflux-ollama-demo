# Reactive Web Application with Spring WebFlux and Ollama

This project is a showcase of a reactive web application built with **Spring Boot** and **WebFlux**, demonstrating real-time streaming using a WebSocket and Ollama as the source for streamed content.

## Project Overview

The application features:
- A WebSocket server that streams real-time responses to the client.
- Integration with Ollama for generating and streaming text tokens.
- A minimalistic frontend to display streaming responses dynamically.

## Requirements

- **Java 21** or higher.
- **Spring Boot** with WebFlux support.
- **Ollama** installed and running locally.

## How It Works

1. The server uses **Spring WebFlux** to create a reactive WebSocket handler.
2. Incoming WebSocket messages are sent to the Ollama API, which streams text tokens back to the server.
3. The server forwards these tokens in real-time to the WebSocket client.
4. The client dynamically displays the streamed text on the frontend.

### Setting Up Ollama

To use this application, **Ollama** must be installed and running locally. Follow these steps:

1. Install Ollama from the [official website](https://ollama.ai).
2. Start the Ollama service by running:
   ```bash
   ollama serve
    ```
3. Verify that the service is running on http://localhost:11434.

### Running the Application

Clone the repository:

```bash
git clone https://github.com/aleksbal/reactive-webflux-ollama.git
cd reactive-webflux-ollama
```

Build and run the application:

```bash

./gradlew bootRun
```

Open the client in your browser (port 8080) and establish a WebSocket connection to see the streaming in action.

