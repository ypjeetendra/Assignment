
package com.online.pointofsale.dao.impl;

import com.online.pointofsale.dao.ProductDao;
import com.online.pointofsale.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductDaoImpl implements ProductDao {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Product getProduct(int productId) throws Exception {
        
        Session session = sessionFactory.openSession();
        
        Product product = (Product)session.load(Product.class, productId);
        
        return product;
    }
    
    
}
