package edu.whut.tomasyao.user.dao.impl;
/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-02-11 20:39
 */

import edu.whut.tomasyao.base.dao.impl.BaseDaoImpl;
import edu.whut.tomasyao.user.dao.IUserDao;
import edu.whut.tomasyao.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {
    public UserDaoImpl() {
        super(User.class);
    }
}
