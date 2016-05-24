/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class Menu extends AbstractDataFromServer{
    
    private ArrayList<Dish> dishes;

    public Menu() {
        super();
        dishes = mainSocket.getMenu();
    }
    
    public Dish getDish(int i) throws IndexOutOfBoundsException{
        try {
            return dishes.get(i);
        } catch (Exception IndexOutOfBoundsException) {
            throw IndexOutOfBoundsException;
        }
    }
    
    public int getMenuSize(){
        return dishes.size();
    }
    
    
}
