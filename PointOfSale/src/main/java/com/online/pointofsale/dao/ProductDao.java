
package com.online.pointofsale.dao;

import com.online.pointofsale.model.Product;


public interface ProductDao {
 
    public Product getProduct(int productId) throws Exception;
}
