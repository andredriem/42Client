/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;
import Data.Dish;
import java.util.ArrayList;
/**
 *
 * @author ana.sanchotene
 */
public class Order {
   //Atributtes
    private int id_order;
    private int table_no;
    private String status;
    private ArrayList<Dish> dishes;
    
    public Order(int id_order, int table_no, String status, ArrayList<Dish> dishes){
        this.id_order= id_order;
        this.table_no = table_no;
        this.status = status;
        this.dishes = dishes;    
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
    
    public ArrayList<Dish> getDishes(){
        return dishes;
    }
    
    public void sendOrder(){
        /*função de envio ainda vai ser feita*/
        //
    }
    
    
}
