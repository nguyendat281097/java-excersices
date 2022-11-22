package com.nvd.training.advanced.networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		String serverName = args[0];
		int port = Integer.parseInt(args[1]);

		try {
			System.out.println("Connecting to " + serverName + " on port " + port);
			// Initiate client socket and connect to server socket
			Socket client = new Socket(serverName, port);
			System.out.println("Just connected to " + client.getRemoteSocketAddress());
			
			// Send message to server
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			out.writeUTF("Hello from " + client.getLocalSocketAddress());

			// Receive message from server
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			System.out.println("Server says: \n" + in.readUTF());
			
			// Close socket
			client.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
