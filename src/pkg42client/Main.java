/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg42client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkg42client.GUI.LoginJFrame;


/**
 * Class main probably will only open the login GUI.
 * @author andre
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //LoginJFrame login_frame = new LoginJFrame();
        //login_frame.setVisible(true);
        
        MainSocket test = new MainSocket("localhost",8888);
        test.getMenu();
        System.out.println("finished");
        test.getMenu();
        System.out.println("finished2");
        
        

    }
    
}
