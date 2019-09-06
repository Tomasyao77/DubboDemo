package edu.whut.tomasyao.user.controller;
/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-14 09:15
 */

import edu.whut.tomasyao.dubbo.IDubboUser1Service;
import edu.whut.tomasyao.user.dao.ISKRedisVoDao;
import edu.whut.tomasyao.user.model.Order;
import edu.whut.tomasyao.user.service.IUserService;
import edu.whut.tomasyao.user.util.QueueUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/test")
public class User1TestController {

    @Autowired
    private IDubboUser1Service dubboUser1Service;
    @Autowired
    private ISKRedisVoDao skRedisVoDao;
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/dubbo", method = RequestMethod.POST)
    public Map dubbo(HttpServletRequest request, int id){
        HashMap<String, Object> map = new HashMap<>();
        String result = null;
        try {
            result = dubboUser1Service.user1Func();
        } catch (Exception e) {
            //e.printStackTrace();
            map.put("value", "error");
            return map;
        }
        map.put("value", result);
        return map;
    }

    @RequestMapping(value = "/skill", method = RequestMethod.POST)
    public Map skill(HttpServletRequest request, int id){
        HashMap<String, Object> map = new HashMap<>();
        String result = "ok";
        skRedisVoDao.put("pid-skill-rest", String.valueOf(10));

        ExecutorService executor = Executors.newFixedThreadPool(20);
        for(int i=0; i < 100; i++){
            executor.execute(new MyRunnable(i));
        }
        executor.shutdown();

        map.put("value", result);
        return map;
    }

    class MyRunnable implements Runnable{
        private int threadId;
        public MyRunnable(int threadId){
            this.threadId = threadId;
        }

        @Override
        public void run() {
            String num = skRedisVoDao.get("pid-skill-rest");
            Integer rest = num == null ? 0 : Integer.valueOf(num);
            String flag = skRedisVoDao.skill("pid-skill-rest", 1, rest);
            if(flag.equals("抢购成功")){
                System.out.println("当前线程："+threadId+" "+flag);
                QueueUtil.putToQueue(new Order(threadId, 1));
            }
        }
    }

    @RequestMapping(value = "/db", method = RequestMethod.POST)
    public Map db(HttpServletRequest request, int id){
        HashMap<String, Object> map = new HashMap<>();
        try {
            userService.addOne(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("value", "ok");
        return map;
    }

}