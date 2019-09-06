package edu.whut.tomasyao;

/**
 * Created by zouy on 19-3-18.
 */
public class MyException extends RuntimeException{//dubbo会封装RuntimeException（可以理解为捕获）
    public MyException(String message){
        super(message);
    }
}
