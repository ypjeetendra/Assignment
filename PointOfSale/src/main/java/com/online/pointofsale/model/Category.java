package com.online.pointofsale.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jeetendra yelekar
 */
@Entity
@Table(name="category")
public class Category implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int categoryId;
    
    @Column(name="categoryName")
    private String categoryName;
    
    @Column(name="salesTaxPercent")
    private BigDecimal salesTaxPercent;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BigDecimal getSalesTaxPercent() {
        return salesTaxPercent;
    }

    public void setSalesTaxPercent(BigDecimal salesTaxPercent) {
        this.salesTaxPercent = salesTaxPercent;
    } 
}
