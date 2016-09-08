/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.pointofsale.model;

import java.io.Serializable;

/**
 *
 * @author jeetendra yelekar
 */
public class OrderItem implements Serializable {
       
    private int productId;
    
    private int quantity;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
