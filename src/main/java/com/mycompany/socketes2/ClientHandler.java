package com.mycompany.socketes2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{
    
    private Socket client;
    
    public ClientHandler(Socket client){
        this.client = client;
    }
    
    @Override
    public void run() {
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            out = new PrintWriter(client.getOutputStream(), true);

            in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));

            String line;
            while ((line = in.readLine()) != null) {
                String answer;
                System.out.printf("Client: %s\n", line);
                Scanner sc = new Scanner(System.in);
                answer = sc.nextLine();
                out.println(answer);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                    client.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
