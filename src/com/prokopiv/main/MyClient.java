package com.prokopiv.main;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ClientEndpoint
public class MyClient {

	@OnOpen
	public void onOpen(Session session) {
		System.out.println("Client: send message \"hello\" to the server");
		session.getAsyncRemote().sendText("hello");
	}

	@OnMessage
	public void onMessage(String message) {
		System.out.println("Client: recived message: " + message);
	}

	@OnError
	public void onError(Throwable t) {
		t.printStackTrace();
	}
}
