/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg42client;

import Data.Dish;
import Data.Message;
import java.util.ArrayList;
import java.net.*;
import java.io.*;

/**
 *This class handles all the comunication with the server.
 *For this first version only getMenu() and login() will be implemented. 
 * @author aacdriemeyer
 */
public class ClientSocket {
    
    
    //COMMAND STRINGS
    private static final String REQUEST_MENU_STR = "getMenu@";
    private static final String REQUEST_SEND_DISH_STR = "sendDish@";
    private static final String REQUEST_SEND_MESSAGE_STR = "sendMessage@";
    
    //CONSTANTS
    private static final int DISH_CSV = 8;
    
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
    public ClientSocket(String ip, int port){
        this.ip = ip;
        this.port = port;
        client = new Socket();
        //connectServer();
    }
    
    
    
    /**
     * 
     * @return gets All dishes from the server
     */
    public  String getMenu() {     
        //Try to connect with server in case if connection is lost
        try{
            connectServer();
            String dishes_csv;      
            toServer.writeBytes(REQUEST_MENU_STR); 
            dishes_csv = fromServer.readLine();
            return dishes_csv; 
            
        }catch(IOException e){
            e.printStackTrace();
        }

        return null;
    }
    
    public void sendDish(Dish dish){
        connectServer();
        try{
            toServer.writeBytes(REQUEST_SEND_DISH_STR+
                    dish.getName()+":"+
                    dish.getId()+":"+
                    dish.getPrice()+":"+
                    dish.getDescription()+":"+
                    dish.isGluten()+":"+
                    dish.isVegan()+":"+
                    dish.isVegetarian()+":"+
                    dish.isLactose()+
                    "\n"
                    );
            if(fromServer.readLine()!="sent") throw new SecurityException("invalid CSV");
            client.close();
        }catch(IOException e){
            e.printStackTrace();
            
        }
        
        
    } 
    
    public void sendMessage(Message message){
        connectServer();
        try{
            toServer.writeBytes(REQUEST_SEND_MESSAGE_STR+
                    message.getMessage()+
                    "\n");
            if(fromServer.readLine()!="sent") throw new SecurityException("invalid CSV");
            client.close();
        }catch(IOException e){
            e.printStackTrace();
            
        }       
    }
    
    
    
    
    /**
     * Checks if client is connected to server, if not: connects to server.
     */
    private void connectServer(){

        try{
            client = new Socket(ip,port);
            toServer = new DataOutputStream(client.getOutputStream());
            fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    
    
    
    
    /**
     * Given a CSV string returns a Dish class it represents
     * CSV_DISHES_PADRÃO = "name[STRING],id[INT],price[INT],description[STRING],
     * gluten[BOOL],vegan[BOOL],vegetarian[BOOL],lactose[BOOL]"
     * @param CSV
     * @return Dish class with information given by CSV
     */
            

    

    
}
