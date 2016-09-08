package com.online.pointofsale.Service.impl;

import com.online.pointofsale.Service.BillService;
import com.online.pointofsale.dao.ProductDao;
import com.online.pointofsale.model.BillItem;
import com.online.pointofsale.model.ItemizedBill;
import com.online.pointofsale.model.OrderItem;
import com.online.pointofsale.model.Product;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private ProductDao productDao;

    @Override
    public ItemizedBill getItemizedBill(List<OrderItem> orderItems) throws Exception {

        List<BillItem> billItems = convertToBillItem(orderItems);

        ItemizedBill itemizedBill = new ItemizedBill(billItems);

        return itemizedBill;
    }

    private List<BillItem> convertToBillItem(List<OrderItem> orderItems) throws Exception {

        List<BillItem> billItems = new ArrayList<BillItem>();

        if (orderItems != null) {
            for (OrderItem orderItem : orderItems) {
                BillItem billItem = new BillItem();
                Product product = productDao.getProduct(orderItem.getProductId());
                product = initializeAndUnproxy(product);
                billItem.setProduct(product);
                billItem.setQuantity(BigInteger.valueOf(orderItem.getQuantity()));
                billItems.add(billItem);
            }
        }

        return billItems;

    }
    
    private <T> T initializeAndUnproxy(T entity) {
        if (entity == null) {
            throw new NullPointerException("Entity passed for initialization is null");
        }

        Hibernate.initialize(entity);
        if (entity instanceof HibernateProxy) {
            entity = (T) ((HibernateProxy) entity).getHibernateLazyInitializer().getImplementation();
        }
        return entity;
    }
}
