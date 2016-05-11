/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg42client;

import java.util.ArrayList;

/**
 *This class handles all the comunication with the server.
 *For this first version only getMenu() and login() will be implemented. 
 * @author aacdriemeyer
 */
public abstract class MainSocket {
    
    private String ip;
    private int port;

    
    /**
     * Class constructor
     * @param ip string containing a ip adress where server is
     * located ex: "127.0.0.1".
     * @param port port choosen for communication with server.
     */
    public MainSocket(String ip, int port){
        this.ip = ip;
        this.port = port;
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
    public  ArrayList<Dish> getMenu(){
        //Try to connect with server in case if connection is lost
         connectServer();
        
        ArrayList<Dish> dishes = new ArrayList<>();
        
        //TODO
        /**Recives information from the server while creating a list os Dishes.
         * The protocol is yet to be decided by the group.
         */

        return dishes;
    }
    
    
    /**
     * Checks if client is connected to server, if not: connects to server.
     */
    private void connectServer(){
        //TODO
    }
    
    
    /**
     * 
     * @param user
     * @param password
     * @return User type ex:"Maneger","Costumer","Waitress".
     */
    public abstract String login(String user, String password);
    
    /**
     * sends a dish to server to be added to the menu.
     * @param dish 
     */
    public abstract void addDish(Dish dish);
    
    
     
    
    
}
