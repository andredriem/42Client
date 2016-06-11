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
    private static final int DISH_CSV = 9;

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
        // Divide CSV em uma lista de csvs, baseado na expressão regular em split()
        String[] list_of_csvs = CSV.split("\\)\\,\\(|\\(|\\)");
        // Primeiro e ultimo são nulos, por causa do split
        //      o melhor seria começar a partir do 2º, então:
            System.err.println(list_of_csvs[0].toString());
        int i;

        for(i=1;i<list_of_csvs.length-1;i++){

            String[] a_csv = list_of_csvs[i].split("[ ]*,[ ]*");
            if(a_csv.length != DISH_CSV) throw new SecurityException("invalid CSV");
            Dish tempDish = new Dish(
                    a_csv[0], //name
                    a_csv[1], //description
                    Boolean.valueOf(a_csv[2]), //gluten
                    Boolean.valueOf(a_csv[3]), //vegan
                    Boolean.valueOf(a_csv[4]), //vegetarian
                    Boolean.valueOf(a_csv[5]), //lactose
                    a_csv[6], //type
                    Float.parseFloat(a_csv[7]), //discount
                    Float.parseFloat(a_csv[8]) //price
            );
            listDishes.add(tempDish);
            listDishes.get(i-1).toString(); //IndexOutOfBounds caso seja pos i
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
