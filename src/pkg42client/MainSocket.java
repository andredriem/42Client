/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg42client;

import java.util.ArrayList;
import java.net.*;
import java.io.*;

/**
 *This class handles all the comunication with the server.
 *For this first version only getMenu() and login() will be implemented. 
 * @author aacdriemeyer
 */
public class MainSocket {
    
    
    //COMMAND STRINGS
    private static final String REQUEST_MENU_STR = "getmenu";
    
    private String ip;
    private int port;
    private Socket client;
    private DataOutputStream toServer;
    private BufferedReader fromServer;

    
    /**
     * Class constructor
     * @param ip string containing a ip adress where server is
     * located ex: "127.0.0.1".
     * @param port port choosen for communication with server.
     */
    public MainSocket(String ip, int port){
        this.ip = ip;
        this.port = port;
        client = new Socket();
        connectServer();
    }
    
    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }
    
    
    /**
     * 
     * @return gets All dishes from the server
     */
    public  ArrayList<Dish> getMenu() throws IOException{     
        //Try to connect with server in case if connection is lost
        connectServer();
        String dishes_csv;      
        toServer.writeBytes(REQUEST_MENU_STR+'\n');  
        dishes_csv = fromServer.readLine();
        ArrayList<Dish> dishes =  CSVtoDishes(dishes_csv);
        return dishes;
    }
    
    
    /**
     * Checks if client is connected to server, if not: connects to server.
     */
    private void connectServer(){
        if(!client.isConnected()){
            try{
                client = new Socket(ip,port);
                toServer = new DataOutputStream(client.getOutputStream());
                fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    
    
    
    //TODO
    /**
     * Given a CSV string returns a Dish class it represents
     * @param CSV
     * @return Dish class with information given by CSV
     */
    private ArrayList<Dish>  CSVtoDishes(String CSV){return new ArrayList<>();};
            
    
    
    //TODO
    /**
     * 
     * @param user
     * @param password
     * @return User type ex:"Maneger","Costumer","Waitress".
     */
    //public String login(String user, String password);
    
    
    //TODO
    /**
     * sends a dish to server to be added to the menu.
     * @param dish 
     */
    //public void addDish(Dish dish); 
    
}
