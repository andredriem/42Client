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
    private static final String REQUEST_MENU_STR = "getMenu()";
     private static final String REQUEST_SEND_DISH_STR = "sendDish:";
    
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
    public  ArrayList<Dish> getMenu() {     
        //Try to connect with server in case if connection is lost
        try{
            connectServer();
            String dishes_csv;      
            toServer.writeBytes(REQUEST_MENU_STR); 
            dishes_csv = fromServer.readLine();
            ArrayList<Dish> dishes =  CSVtoDishes(dishes_csv);
            return dishes; 
            
        }catch(IOException e){
            e.printStackTrace();
        }

        return null;
    }
    
    public void sendDish(Dish dish){
        connectServer();
        try{
            toServer.writeBytes(REQUEST_SEND_DISH_STR+
                    dish.getName()+","+
                    dish.getId()+","+
                    dish.getPrice()+","+
                    dish.getDescription()+","+
                    dish.isGluten()+","+
                    dish.isVegan()+","+
                    dish.isVegetarian()+","+
                    dish.isLactose()    
                    );
            if(fromServer.readLine()!="sent") throw new SecurityException("invalid CSV");
        }catch(IOException e){
            e.printStackTrace();
        }
        
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
     * CSV_DISHES_PADRÃO = "name[STRING],id[INT],price[INT],description[STRING],
     * gluten[BOOL],vegan[BOOL],vegetarian[BOOL],lactose[BOOL]"
     * @param CSV
     * @return Dish class with information given by CSV
     */
    public ArrayList<Dish>  CSVtoDishes(String CSV){  
        ArrayList<Dish> listDishes = new ArrayList<>();
        String[] list_of_csvs = CSV.split(";");
        int i;
        
        for(i=0;i<list_of_csvs.length;i++){
            
            String[] a_csv = list_of_csvs[i].split(",");
            if(a_csv.length != DISH_CSV) throw new SecurityException("invalid CSV");
            Dish tempDish = new Dish(
                    a_csv[0], //name
                    Integer.parseInt(a_csv[1]), //id
                    Float.parseFloat(a_csv[2]), //price
                    a_csv[3], //description
                    Boolean.valueOf(a_csv[4]), //gluten
                    Boolean.valueOf(a_csv[5]), //vegan
                    Boolean.valueOf(a_csv[6]), //vegetarian
                    Boolean.valueOf(a_csv[7]) //lactose
            );
            listDishes.add(tempDish);
        }
        return listDishes; 
    }
            
    
    
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
