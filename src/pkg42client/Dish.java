/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg42client;

/**
 *
 * @author andre
 */
public class Dish {
    
    
    
    //Atributes not final.
    private String name;
    private int id;
    private float price; 
    private String description;
    
    
    private boolean gluten;
    private boolean vegan;
    private boolean vegetarian;
    private boolean lactose;
    
  
    
    public Dish(String name, int id, float price, String description, boolean gluten, boolean vegan, boolean vegetarian, boolean lactose) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.description = description;
        this.gluten = gluten;
        this.vegan = vegan;
        this.vegetarian = vegetarian;
        this.lactose = lactose;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the gluten
     */
    public boolean isGluten() {
        return gluten;
    }

    /**
     * @return the vegan
     */
    public boolean isVegan() {
        return vegan;
    }

    /**
     * @return the vegetarian
     */
    public boolean isVegetarian() {
        return vegetarian;
    }

    /**
     * @return the lactose
     */
    public boolean isLactose() {
        return lactose;
    }
    
    
}
