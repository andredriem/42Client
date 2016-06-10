/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Ana
 */
public class Message extends AbstractDataFromServer{
   
    //Atributes not final.
    private String message;
    
    public Message(String message) {
        
        super();
        this.message = message; 
    }
    
     /**
     * @return client's message
     */
    public String getMessage(){
        return message;
    }   
}
