package com.mycompany.socketes2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    private int PORT = 2000;
    ServerSocket serverSocket;
    private int counter = 0;
    
    public Server() throws IOException{
        this.serverSocket = new ServerSocket(this.PORT);
        this.serverSocket.setReuseAddress(true);
    }
    
    public void start() throws IOException{
        while(true){
            Socket client = this.serverSocket.accept();
            System.out.printf("Client connected \n");
            
            ClientHandler ch = new ClientHandler(client, this.counter++);
            
            Thread t = new Thread(ch);
            t.start();
        }
    }
}
