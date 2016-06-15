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
    
    public static final String REQUEST_MENU_STR = "getMenu@";
    public static final String REQUEST_SEND_DISH_STR = "insertDish@";
    public static final String REQUEST_SEND_MESSAGE_STR = "sendMessage@";
    public static final String REQUEST_GET_DISH_STR = "getDish@";
    public static final String REQUEST_DELETE_DISH_STR = "deleteDish@";
    public static final String REQUEST_SEND_ORDER_STR = "sendOrder@";
    public static final String REQUEST_ADD_DISH_ORDER_STR = "addDishToOrder@";
    public static final String REQUEST_RESET_ORDER_STR = "ressetOrder@";
    public static final String REQUEST_GET_ORDER_STR = "getOrder@";
    public static final String REQUEST_CHANGE_ORDER_STATUS_STR = "changeOrderStatus@";
    public static final String REQUEST_ORDER_INFO_STR = "getOrderInfo@";

    
    
    public AbstractDataFromServer() {
        mainSocket = new ClientSocket("localhost",8888);
    }
    
    
    
    
}
