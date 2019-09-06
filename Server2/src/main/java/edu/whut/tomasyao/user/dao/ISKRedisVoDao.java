package edu.whut.tomasyao.user.dao;

import edu.whut.tomasyao.base.dao.IRedisDao;

public interface ISKRedisVoDao extends IRedisDao<String, String> {
    String skill(String key, int count, int rest);
}
