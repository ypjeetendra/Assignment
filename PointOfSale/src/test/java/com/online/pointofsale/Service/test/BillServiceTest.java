
package com.online.pointofsale.Service.test;

import com.online.pointofsale.Service.impl.BillServiceImpl;
import com.online.pointofsale.model.BillItem;
import com.online.pointofsale.model.ItemizedBill;
import com.online.pointofsale.model.OrderItem;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
public class BillServiceTest {
    
    @Autowired
    private BillServiceImpl billService;
      
    @Test
    public void testGetItemizedBill() throws Exception {
        
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(2);
        orderItem.setProductId(1);
        
        OrderItem orderItem2 = new OrderItem();
        orderItem2.setQuantity(2);
        orderItem2.setProductId(2);
        
        orderItems.add(orderItem);
        orderItems.add(orderItem2);
        
        ItemizedBill itemizedBill = billService.getItemizedBill(orderItems);
        
        System.out.println(itemizedBill.getTotalCost());
        System.out.println(itemizedBill.getTotalCostAfterTax());
        
        for(BillItem billItem : itemizedBill.getBillItems()) {
            System.out.println("Price per unit" + billItem.getProduct().getPrice());
            System.out.println("Price per unit after sales tax" + billItem.getProduct().getPriceAfterSalesTax());
            System.out.println("Sales Tax" + billItem.getProduct().getCategory().getSalesTaxPercent());
                     
        }
        
        Assert.assertNotNull(itemizedBill);
    }

}
