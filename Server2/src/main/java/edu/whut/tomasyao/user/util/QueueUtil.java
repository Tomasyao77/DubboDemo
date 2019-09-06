package edu.whut.tomasyao.user.util;

import edu.whut.tomasyao.user.model.Order;
import edu.whut.tomasyao.user.service.IUserService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.*;

/**
 * Created by zouy on 19-3-24.
 */
public class QueueUtil {
    @Autowired
    private IUserService userService;

    private static LinkedBlockingQueue<Order> smsLinkedBlockingQueue = new LinkedBlockingQueue<>();
    private static ExecutorService executor = Executors.newFixedThreadPool(20);

    public static void putToQueue(Order order) {
        try {
            smsLinkedBlockingQueue.put(order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void init() {
        new Thread(new QueueUtil.queueRunnable()).start();
    }

    private class queueRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                Order order;
                try {
                    order = smsLinkedBlockingQueue.take();
                    boolean flag = userService.addToQueue(order);
                    if(!flag){//下单失败,表示没货了
                        System.out.println("卖完啦,线程"+order.getThread_id()+"最终没抢到");
                    }
                    //没必要用多线程
                    /*executor.execute(new Runnable() {
                             @Override
                             public void run() {
                                 try {
                                     userService.addToQueue(order);
                                 } catch (Exception e) {
                                     e.printStackTrace();
                                 }
                             }
                         }
                    );*/
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
