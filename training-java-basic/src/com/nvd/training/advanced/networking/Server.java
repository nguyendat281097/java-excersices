package com.nvd.training.advanced.networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server extends Thread {
	private ServerSocket serverSocket;

	public Server(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
	}

	public void run() {
		while (true) {
			try {
				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				// Initiate socket and listening ...
				Socket server = serverSocket.accept();
				System.out.println("Just connected to " + server.getRemoteSocketAddress());

				// Receive message from client and print
				DataInputStream in = new DataInputStream(server.getInputStream());
				System.out.println(in.readUTF());
				
				// Send message to client
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
				out.writeUTF("Say 'Hello' from "+ server.getLocalSocketAddress() + " to " + server.getRemoteSocketAddress());
				out.writeUTF("Thank you and Good bye!");
				
				// Close socket
				server.close();
			} catch (SocketTimeoutException e) {
				System.out.println("Time out! Reconnecting ...");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		int port = Integer.parseInt(args[0]);
		try {
			Thread t = new Server(port);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
