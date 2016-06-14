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
public class Order extends AbstractDataFromServer{
   //Atributtes
    private int id_order;
    private int table_no;
    private String status;
    
    public Order(int table_no, String status){
        this.table_no = table_no;
        this.status = status; 
        this.id_order = openOrder();
        addDish((new Menu()).getDish(0), 33, true);
        reset();
    }
    
    public int getId_order(){
        return id_order;
    }
        
    public int getTable_no(){
        return table_no;
    }
    
    public String getStatus(){
        return status;
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
        String return_string = mainSocket.sendToServer(csv);
        if(return_string.equals("false")) throw new SecurityException("invalid CSV (dish name is probably incorrect)");
    }
    
    public void reset(){
        String csv = REQUEST_RESET_ORDER_STR + "[" +
                     id_order + "]";
        String return_string = mainSocket.sendToServer(csv);
        if(return_string.equals("false")) throw new SecurityException("cannot reset order");
    }
    
    public ArrayList<Dish> getOrderDishes(){
        String csv = REQUEST_GET_ORDER_STR + "[" +
                     id_order + "]";        
        String return_string = mainSocket.sendToServer(csv);
        return null;
    }
        
}
    
    