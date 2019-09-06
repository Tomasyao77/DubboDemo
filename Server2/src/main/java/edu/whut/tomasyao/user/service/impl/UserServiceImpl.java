package edu.whut.tomasyao.user.service.impl;

import edu.whut.tomasyao.user.dao.IOrderDao;
import edu.whut.tomasyao.user.dao.IUserDao;
import edu.whut.tomasyao.user.model.Order;
import edu.whut.tomasyao.user.model.User;
import edu.whut.tomasyao.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * edu.whut.change.base.service.impl
 * Created by YTY on 2016/6/14.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;
    @Autowired
    private IOrderDao orderDao;

    @Override
    public void addOne(int num) throws Exception {
        userDao.save(new User(num));
    }

    @Override
    public void addOrder(int thread_id, int num) throws Exception {
        orderDao.save(new Order(thread_id, num));
    }

    @Override
    public boolean addToQueue(Order order) throws Exception {
        User user = userDao.getOne(3);
        if(user == null){
            return false;
        }
        //防止超卖
        if(user.getNum()<=0){
            return false;
        }
        Order o = orderDao.save(order);
        userDao.update(" update User d set d.num=d.num-"+order.getNum()+" where d.id=3");
        return o != null;
    }
}
