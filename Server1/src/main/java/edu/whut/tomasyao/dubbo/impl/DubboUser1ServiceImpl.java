package edu.whut.tomasyao.dubbo.impl;

import edu.whut.tomasyao.MyException;
import edu.whut.tomasyao.dubbo.IDubboUser1Service;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-14 09:06
 */

public class DubboUser1ServiceImpl implements IDubboUser1Service {

    @Override
    public String user1Func() throws Exception {
        throw new MyException(" 11 ");
        //return "Hello I am User1!";
    }
}
