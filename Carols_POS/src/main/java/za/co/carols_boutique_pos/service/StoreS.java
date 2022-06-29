/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.co.carols_boutique_pos.service;

import za.co.carols_boutique_pos.models.Sale;
import za.co.carols_boutique_pos.models.Store;


/**
 *
 * @author muaad
 */
public interface StoreS {
    
    Store loginStore(Store store);
    
    String registerStore(Store store);
    
    String addSale(Sale sale);  
    
    String deleteStore(String storeID);
}
