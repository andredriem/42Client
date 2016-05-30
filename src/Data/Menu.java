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
    private static final int DISH_CSV = 8;

    public Menu() {
        super();
        String dish_csv = mainSocket.getMenu();
        dishes = this.CSVtoDishes(dish_csv);
    }
    
    public Dish getDish(int i) throws IndexOutOfBoundsException{
        try {
            return getDishes().get(i);
        } catch (Exception IndexOutOfBoundsException) {
            throw IndexOutOfBoundsException;
        }
    }
    
    public int getMenuSize(){
        return getDishes().size();
    }
    
    private ArrayList<Dish>  CSVtoDishes(String CSV){  
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

    /**
     * @return the dishes
     */
    public ArrayList<Dish> getDishes() {
        return dishes;
    }
    
}
