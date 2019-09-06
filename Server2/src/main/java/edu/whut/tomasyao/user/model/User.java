package edu.whut.tomasyao.user.model;
/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-02-11 20:39
 */

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dd_product")
public class User {
    @Id
    @GeneratedValue
    private int id;
    private int num;
    @Column(name = "create_time")
    private Date createTime;


    public User() {
    }

    public User(int num) {
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
}
