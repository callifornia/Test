package com.prokopiv.main;

import java.io.IOException;
import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

public class App {
	
	public static Session session;
	private static String uri = "ws://localhost/api/v1/ws";
	
	public static void main(String[] args){
		start();
	}
	
	private static void start(){
		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		System.out.println("Client: Connect to the: " + uri + "<");
		try {
			session = container.connectToServer(MyClient.class, URI.create(uri));
			Thread.sleep(5000);
		} catch (DeploymentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
