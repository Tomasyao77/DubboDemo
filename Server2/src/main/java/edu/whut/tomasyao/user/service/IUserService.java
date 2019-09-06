package edu.whut.tomasyao.user.service;

import edu.whut.tomasyao.user.model.Order;

/**
 * edu.whut.change.base.service
 * Created by YTY on 2016/6/14.
 */
public interface IUserService {
    void addOne(int num) throws Exception;
    void addOrder(int thread_id, int num) throws Exception;
    boolean addToQueue(Order order) throws Exception;
}
