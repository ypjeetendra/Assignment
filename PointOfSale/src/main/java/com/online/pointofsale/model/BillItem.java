package com.online.pointofsale.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;


public class BillItem implements Serializable {

    private BigInteger quantity;
    
    private Product product;
    
    private BigDecimal totalCost;
    
    private BigDecimal totalCostAfterSalesTax;

    public Product getProduct() {
        return product;
    }

    public BigDecimal getTotalCostAfterSalesTax() {
        this.totalCostAfterSalesTax  = product.getPriceAfterSalesTax().multiply(new BigDecimal(quantity));
        return this.totalCostAfterSalesTax;
    }
    
    public BigDecimal getTotalCost() {
        this.totalCost =  product.getPrice().multiply(new BigDecimal(quantity));
        return this.totalCost;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
    
    
    
}
