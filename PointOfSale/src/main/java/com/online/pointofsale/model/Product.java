package com.online.pointofsale.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int productId;
    
    @Column(name = "productName")
    private String productName;
    
    @Column(name = "price")
    private BigDecimal price;
    
    @OneToOne(fetch= FetchType.EAGER)
    private Category category;
    
    public Category getCategory() {
        return category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    
    public BigDecimal getPrice() {
        return price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public int getProductId() {
        return productId;
    }
    
    public void setProductId(int productId) {
        this.productId = productId;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public BigDecimal getPriceAfterSalesTax() {
        
        BigDecimal priceAfterSalesTax = this.price;
        
        priceAfterSalesTax = priceAfterSalesTax.add(category.getSalesTaxPercent().
                divide(new BigDecimal(100)).multiply(this.getPrice()));
        
        return priceAfterSalesTax;
        
    }
    
}
