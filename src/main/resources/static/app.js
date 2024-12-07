var ws = null;
var url = "ws://localhost:8080/llm";

function setConnected(connected) 
{
	document.getElementById('connect').disabled = connected;
	document.getElementById('disconnect').disabled = !connected;
	document.getElementById('ask').disabled = !connected;
}

function connect() 
{
	ws = new WebSocket(url);
	ws.onopen = function() {
		setConnected(true);
		log('Info: Connection Established.');
	};
	
	ws.onmessage = function(event) {
		log(event.data);
	};
	
	ws.onclose = function(event) {
		setConnected(false);
		log('Info: Closing Connection.');
	};
}

function disconnect() 
{
	if (ws != null) {
		ws.close();
		ws = null;
	}
	setConnected(false);
}

function askOllama()
{
	if (ws != null) 
	{
		var question = document.getElementById('question').value;
		log('Sent to LLM: ' + question);
		ws.send(question);
	} else {
		alert('connection not established, please connect.');
	}
}

function log(message) 
{
    var console = document.getElementById('logging');

    // Check if the last <p> already exists, if not, create one
    var lastParagraph = console.lastElementChild;
    if (!lastParagraph || lastParagraph.tagName !== 'P') {
        lastParagraph = document.createElement('p');
        console.appendChild(lastParagraph);
    }

    // Append the token to the existing text of the last <p>
    lastParagraph.textContent += message;
}
