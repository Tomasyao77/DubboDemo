package edu.whut.tomasyao.dubbo;

/**
 * Created by zouy on 18-9-14.
 */
public interface IDubboUser1Service {
    //User2这边声明接口//具体实现在User1那边
    String user1Func() throws Exception;
}
