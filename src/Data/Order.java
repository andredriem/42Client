/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;
import Data.Dish;
import java.util.ArrayList;
import pkg42client.ClientSocket;
/**
 *
 * @author ana.sanchotene
 */
public final class Order extends AbstractDataFromServer{
   //Atributtes
    private int id_order;
    private int table_no;
    private String status;

    
    public Order(int table_no, String status){
        this.table_no = table_no;
        this.status = status; 
        this.id_order = openOrder();
        System.out.println(getStatus());
    }
    
    public Order(int table_no, String status, int id_order){
        this.id_order = id_order;
        this.table_no = getTable_no();
        this.status = getStatus(); 
    }
    
    public int getId_order(){
        return id_order;
    }
        
    public int getTable_no(){
        String csv = REQUEST_ORDER_INFO_STR + "[" +
                     id_order + "]"; 
        String return_string = mainSocket.sendToServer(csv);
        String[] return_list = return_string.split(",");
        return Integer.parseInt(return_list[1].substring(1));
    }
    
    public String getStatus(){
        String csv = REQUEST_ORDER_INFO_STR + "[" +
                     id_order + "]"; 
        String return_string = mainSocket.sendToServer(csv);
        String[] return_list = return_string.split(",");
        return return_list[2].substring(3,return_list[2].length()-2);
    }
    
    
    //Returns order Id
    private int openOrder(){
        String csv = REQUEST_SEND_ORDER_STR + "[" + Integer.toString(this.table_no) + "]";
        String return_string = mainSocket.sendToServer(csv);
        return new Integer(return_string);
    }
    
    public void addDish(Dish dish,int quantity,boolean half_portion){
        String csv = REQUEST_ADD_DISH_ORDER_STR + "[" +
                     id_order + "," +
                     dish.getName().substring(1) + "," +
                     quantity + "," +
                     ((half_portion) ? "1" : "0") + "]";
        String return_string = mainSocket.addDishtoOrder(csv);
        if(return_string.equals("false")) throw new SecurityException("invalid CSV (dish name is probably incorrect)");
    }
    
    public void reset(){
        String csv = REQUEST_RESET_ORDER_STR + "[" +
                     id_order + "]";
        String return_string = mainSocket.sendToServer(csv);
        if(return_string.equals("false")) throw new SecurityException("cannot reset order");
    }
    
    
    //TODO
    public ArrayList<Dish> getOrderDishes(){
        String csv = REQUEST_GET_ORDER_STR + "[" +
                     id_order + "]";        
        String return_string = mainSocket.sendToServer(csv);
        return null;
    }
    
    
    
    public String getOrderDishesSTR(){
        String csv = REQUEST_GET_ORDER_STR + "[" +
                     id_order + "]";        
        String return_string = mainSocket.sendToServer(csv);
        return return_string;
    }
    
    public void setStatus(String status){
        String csv = REQUEST_CHANGE_ORDER_STATUS_STR + "[" +
                     id_order + ",'" + status + "']";
        String return_string = mainSocket.sendToServer(csv);
        if(return_string.equals("false")) throw new SecurityException("CSV ERROR! Order Status not altered");        
    }
        
}
    
    