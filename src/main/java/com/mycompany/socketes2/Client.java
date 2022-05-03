package com.mycompany.socketes2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    
    private int PORT = 2000;
    private String IP = "localhost";
    private Socket socket;
    
    public Client() throws IOException{
        this.socket = new Socket(this.IP, this.PORT);
    }
    
    public void start(){
        try{
            PrintWriter out = new PrintWriter(
                    this.socket.getOutputStream(), true);

            BufferedReader in
                = new BufferedReader(new InputStreamReader(
                    this.socket.getInputStream()));

            Scanner sc = new Scanner(System.in);
            String line = null;
  
            while (!"exit".equalsIgnoreCase(line)) {

                line = sc.nextLine();

                out.println(line);
                out.flush();

                System.out.println("Server: " + in.readLine());
            }

            sc.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
