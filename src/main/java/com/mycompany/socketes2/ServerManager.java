package com.mycompany.socketes2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerManager {
    public static void main(String[] args){
        try {
            Server s = new Server();
            s.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
