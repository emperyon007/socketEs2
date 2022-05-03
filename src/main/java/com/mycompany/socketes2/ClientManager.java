package com.mycompany.socketes2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientManager {
    public static void main(String[] args){
        try {
            Client c = new Client();
            c.start();
        } catch (IOException ex) {
            Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
