/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg42client;

import Data.Dish;
import Data.Message;
import Data.Menu;
import Data.Order;
import java.util.ArrayList;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *This class handles all the comunication with the server.
 *For this first version only getMenu() and login() will be implemented. 
 * @author aacdriemeyer
 */
public class ClientSocket {
    
    
    public static final String REQUEST_MENU_STR = "getMenu@";
    public static final String REQUEST_SEND_DISH_STR = "insertDish@";
    public static final String REQUEST_SEND_MESSAGE_STR = "sendMessage@";
    public static final String REQUEST_GET_DISH_STR = "getDish@";
    public static final String REQUEST_DELETE_DISH_STR = "deleteDish@";
    public static final String REQUEST_SEND_ORDER_STR = "sendOrder@";
    public static final String REQUEST_ADD_DISH_ORDER_STR = "addDishToOrder@";
    public static final String REQUEST_RESET_ORDER_STR = "ressetOrder@";
    public static final String REQUEST_GET_ORDER_STR = "getOrder@";
    public static final String REQUEST_CHANGE_ORDER_STATUS_STR = "changeOrderStatus@";
    public static final String REQUEST_ORDER_INFO_STR = "getOrderInfo@";
    public static final String REQUEST_ORDER_PRICE_STR = "getOrderPrice@";
    
    //CONSTANTS
    private static final int DISH_CSV = 9;
    
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
    
    public String sendToServer(String csv){
        try{
        connectServer();
        toServer.writeBytes(csv+"\n");
        return fromServer.readLine();
        
        } catch (IOException e) {
            e.printStackTrace();
            throw new SecurityException("invalid CSV");
        }
        
        
    }
    
    
    
    /**
     * @return gets All dishes from the server
     */
    public  String getMenu() {     
        //Try to connect with server in case if connection is lost
        try{
            connectServer();
            String dishes_csv;      
            toServer.writeBytes(REQUEST_MENU_STR+'\n'); 
            dishes_csv = fromServer.readLine();
            return dishes_csv; 
            
        }catch(IOException e){
            e.printStackTrace();
        }

        return null;
    }
    
    public String addDishtoOrder(String csv){
        return sendToServer(csv);
    }
    
    public String requestOrderInfo(String csv){
        return sendToServer(csv);
    }
    
    public String openOrder(String csv){
        return sendToServer(csv);
    }  
    
    public String resetOrder(String csv){
        return sendToServer(csv);
    }  

    public String getOrderDishes(String csv){
        return sendToServer(csv);
    }      
    
    public String getOrderDishesSTR(String csv){
        return sendToServer(csv);
    }      
    
    public String setStatus(String csv){
        return sendToServer(csv);
    }      
    
    public String getOrderPrice(String csv){
        return sendToServer(csv);
    }
    
    public String getOrderInfo(String csv){
        return sendToServer(csv);
    }
    
 
    
    public void sendDish(Dish dish){
        connectServer();
        try{
            toServer.writeBytes(REQUEST_SEND_DISH_STR+"['"+
                    dish.getName().toString()+"','"+
                    dish.getDescription().toString()+"','"+
                    dish.isGluten()+"','"+
                    dish.isVegan()+"','"+
                    dish.isVegetarian()+"','"+
                    dish.isLactose()+"','"+
                    dish.getType().toString()+"',"+
                    (Float) dish.getDiscount()+","+
                    (Float) dish.getPrice()+"]\n"
                    );
            System.out.println(REQUEST_SEND_DISH_STR+"['"+
                    dish.getName().toString()+"','"+
                    dish.getDescription().toString()+"','"+
                    dish.isGluten()+"','"+
                    dish.isVegan()+"','"+
                    dish.isVegetarian()+"','"+
                    dish.isLactose()+"','"+
                    dish.getType().toString()+"',"+
                    (Float) dish.getDiscount()+","+
                    (Float) dish.getPrice()+"]\n");
            String serverResponse = fromServer.readLine();
            if(!(serverResponse.equals("true"))) throw new SecurityException("invalid CSV");
            System.out.println(serverResponse);
            
            client.close();
        }catch(IOException e){
            e.printStackTrace();
            
        }
        
        
    } 
    /**
     * @param message 
     * Descrição: manda mensagem para o servidor
     */
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
    

    public Dish getSpecifcDish(String dishName){
            Dish dish = null;
            connectServer();
        try{
            String dishes_csv;
            toServer.writeBytes(REQUEST_MENU_STR+'\n');
            //...
            //.... 
        }catch(IOException e){
            e.printStackTrace();
        } 
        
        return dish;
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
