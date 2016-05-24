/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import pkg42client.MainSocket;

/**
 *
 * @author ana, andre, bharbara, moita
 */
public class AbstractDataFromServer {
    
    public MainSocket mainSocket;

    
    
    public AbstractDataFromServer() {
        mainSocket = new MainSocket("localhost",8888);
    }
    
    
    
    
}
