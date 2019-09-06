package edu.whut.tomasyao.user.model;
/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-02-11 20:39
 */

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dd_order")
public class Order {
    @Id
    @GeneratedValue
    private int id;
    private int num;
    private int thread_id;
    @Column(name = "create_time")
    private Date createTime;


    public Order() {
    }

    public Order(int thread_id, int num) {
        this.thread_id = thread_id;
        this.num = num;
        this.createTime = new Date();
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

    public int getThread_id() {
        return thread_id;
    }

    public void setThread_id(int thread_id) {
        this.thread_id = thread_id;
    }
}
