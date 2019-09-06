package edu.whut.tomasyao.user.dao.impl;
/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-02-11 20:39
 */

import edu.whut.tomasyao.base.dao.impl.BaseDaoImpl;
import edu.whut.tomasyao.user.dao.IOrderDao;
import edu.whut.tomasyao.user.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderDaoImpl extends BaseDaoImpl<Order> implements IOrderDao {
    public OrderDaoImpl() {
        super(Order.class);
    }
}
