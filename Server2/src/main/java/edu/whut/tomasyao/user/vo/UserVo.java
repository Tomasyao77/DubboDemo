package edu.whut.tomasyao.user.vo;

import java.util.Date;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-06-29 14:49
 */

public class UserVo {
    private int id;
    private int num;
    private Date createTime;

    public UserVo() {//要有空的构造方法,mybatis查询需要
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}