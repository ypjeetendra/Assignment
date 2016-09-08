package com.online.pointofsale.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


public class ItemizedBill implements Serializable {
    
    private List<BillItem> billItems;
    
    private BigDecimal totalCost;
        
    private BigDecimal totalCostAfterTax;

    public ItemizedBill(List<BillItem> billItems) {
        this.billItems = billItems;
        this.totalCost = new BigDecimal(0);
        this.totalCostAfterTax = new BigDecimal(0);
        calculateBill();
    }

    public List<BillItem> getBillItems() {
        return billItems;
    }
    
    

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public BigDecimal getTotalCostAfterTax() {
        return totalCostAfterTax;
    }
    
    private void calculateBill() {
        for(BillItem billItem : billItems) {
            totalCost = totalCost.add(billItem.getTotalCost());
            totalCostAfterTax = totalCostAfterTax.add(billItem.getTotalCostAfterSalesTax());
        }
    }
    
}
