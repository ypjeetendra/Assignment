
package com.online.pointofsale.Dao.test;

import com.online.pointofsale.dao.ProductDao;
import com.online.pointofsale.model.Product;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
public class ProductDaoTest {
   
    @Autowired
    private ProductDao productDao;
    
    @Test
    public void testGetProduct() throws Exception {
        
        Product product = productDao.getProduct(1);
        Assert.assertNotNull(product);
        Assert.assertEquals(new BigDecimal(100.00).doubleValue(), product.getPrice().doubleValue(),0);
        Assert.assertEquals(new BigDecimal(110.00).doubleValue(), product.getPriceAfterSalesTax().doubleValue(),0);
    }
    
    
}
