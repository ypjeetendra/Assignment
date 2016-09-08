package com.online.pointofsale.Service;

import com.online.pointofsale.model.ItemizedBill;
import com.online.pointofsale.model.OrderItem;
import java.util.List;

public interface BillService {
    
    
    public ItemizedBill getItemizedBill(List<OrderItem> orderItems) throws Exception;
}
