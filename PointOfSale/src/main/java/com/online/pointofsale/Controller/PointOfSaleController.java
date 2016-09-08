package com.online.pointofsale.Controller;

import com.online.pointofsale.Service.BillService;
import com.online.pointofsale.model.ItemizedBill;
import com.online.pointofsale.model.OrderItem;
import java.util.List;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
  @Path("/bill")
public class PointOfSaleController {

    @Autowired
    private BillService billService;

  
    @RequestMapping(value = "/bill", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
    public ItemizedBill processOrder(@RequestBody List<OrderItem> orderItems)
            throws Exception {
         ItemizedBill itemizedBill = null;
        try {
        itemizedBill = billService.getItemizedBill(orderItems);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemizedBill;
    }
}
