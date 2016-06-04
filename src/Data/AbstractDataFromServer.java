/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import pkg42client.ClientSocket;

/**
 *
 * @author ana, andre, bharbara, moita
 */
public class AbstractDataFromServer {
    
    public ClientSocket mainSocket;

    
    
    public AbstractDataFromServer() {
        mainSocket = new ClientSocket("localhost",8888);
    }
    
    
    
    
}
