/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author andre
 */
public class Dish extends AbstractDataFromServer{
    
            
    
    //Atributes not final.
    private String name;
//    private int id;
    private float discount;
    private float price; 
    private String description;
    private String type;

    
    
    private boolean gluten;
    private boolean vegan;
    private boolean vegetarian;
    private boolean lactose;
    
  
    
    public Dish(String name, String description, boolean gluten, boolean vegan, boolean vegetarian, boolean lactose, String type, float discount, float price) {
        
        super();
        this.name = name;
//        this.id = id;
        this.price = price;
        this.discount = discount;
        this.description = description;
        this.gluten = gluten;
        this.vegan = vegan;
        this.vegetarian = vegetarian;
        this.lactose = lactose;
        this.type = type;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the id
     *
    public int getId() {
        return id;
    }
    */
    
    /**
     * @return the discount
     */
    public float getDiscount(){
        return discount;
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
    
    public String getType(){
        return type;
    }
    
    public void sendDish(){
        mainSocket.sendDish(this);
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param id the id to set
     *
    public void setId(int id) {
        this.id = id;
    }
    */
    
    /*
    * @param discount the discount to set
    */
    public void setDiscount(float discount){
        this.discount = discount;
    }
    
    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param gluten the gluten to set
     */
    public void setGluten(boolean gluten) {
        this.gluten = gluten;
    }

    /**
     * @param vegan the vegan to set
     */
    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    /**
     * @param vegetarian the vegetarian to set
     */
    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    /**
     * @param lactose the lactose to set
     */
    public void setLactose(boolean lactose) {
        this.lactose = lactose;
    }
    
    /*
    * @param type the type to set
    */
    public void setType(String type){
        this.type = type;
    }
    
}
