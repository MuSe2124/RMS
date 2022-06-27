/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.co.carols_boutique_pos.service;

import java.util.ArrayList;
import za.co.carols_boutique_pos.models.Exchange;
import za.co.carols_boutique_pos.models.ProdCat;
import za.co.carols_boutique_pos.models.Product;
import za.co.carols_boutique_pos.models.Refund;
import za.co.carols_boutique_pos.models.Stock;

/**
 *
 * @author muaad
 */
public interface ProductS {
    
    Product getProduct(String productID,String size);

    String addProductToInventory(Stock stock);
    String addNewProduct(ProdCat prodCat);

    String removeProductFromInventory(Stock stock);
    String deleteProduct(String productID, String catID);

    String refund(Refund refund);
}
