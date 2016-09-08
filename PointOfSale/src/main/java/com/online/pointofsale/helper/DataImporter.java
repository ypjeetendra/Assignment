package com.online.pointofsale.helper;

import com.online.pointofsale.model.Category;
import com.online.pointofsale.model.Product;
import java.math.BigDecimal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class DataImporter implements InitializingBean {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void afterPropertiesSet() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Category categoryA = new Category();
        categoryA.setCategoryName("A");
        categoryA.setSalesTaxPercent(new BigDecimal(10));

        session.saveOrUpdate(categoryA);


        Category categoryB = new Category();
        categoryB.setCategoryName("B");
        categoryB.setSalesTaxPercent(new BigDecimal(20));

        session.saveOrUpdate(categoryB);


        Category categoryC = new Category();
        categoryC.setCategoryName("C");
        categoryC.setSalesTaxPercent(new BigDecimal(0));

        session.saveOrUpdate(categoryC);


        Product p1 = new Product();
        p1.setProductName("P1");
        p1.setPrice(new BigDecimal(100));
        p1.setCategory(categoryA);

        Product p2 = new Product();
        p2.setProductName("P2");
        p2.setPrice(new BigDecimal(200));
        p2.setCategory(categoryB);

        Product p3 = new Product();
        p3.setProductName("P3");
        p3.setPrice(new BigDecimal(150));
        p3.setCategory(categoryC);

        session.saveOrUpdate(p1);

        session.saveOrUpdate(p2);

        session.saveOrUpdate(p3);

        session.getTransaction().commit();
        session.close();

    }
}
