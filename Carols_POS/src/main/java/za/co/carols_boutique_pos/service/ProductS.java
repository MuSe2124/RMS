/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.co.carols_boutique_pos.service;


import java.util.ArrayList;
import za.co.carols_boutique.models.ProdCat;
import za.co.carols_boutique.models.Product;
import za.co.carols_boutique.models.Stock;
import java.util.List;
import za.co.carols_boutique_pos.models.Category;
import za.co.carols_boutique_pos.models.Refund;

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
    List<Category> getCategories();
    String refund(Refund refund);
}
