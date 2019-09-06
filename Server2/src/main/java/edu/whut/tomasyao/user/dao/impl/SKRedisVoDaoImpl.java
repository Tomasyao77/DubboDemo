package edu.whut.tomasyao.user.dao.impl;

import edu.whut.tomasyao.user.dao.ISKRedisVoDao;
import edu.whut.tomasyao.base.dao.impl.RedisDaoImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Component;

@Component
public class SKRedisVoDaoImpl extends RedisDaoImpl<String, String> implements ISKRedisVoDao {

    @Override
    public String skill(String key, int count, int rest) {
        RedisTemplate redisTemplate = getTemplate();

        /**
         *
         */
        Object result = redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.watch(key);
                redisOperations.multi();
                if(rest > 0 && rest >= count){
                    redisOperations.opsForValue().set(key, String.valueOf(rest-count));
                }else {
                    return "抢完了";
                }
                return redisOperations.exec();
            }
        });
        /*System.out.println(result);
        return "";*/
        if(result == null){
            return "系统繁忙";
        }
        if(result.equals("抢完了")){
            return "抢完了";
        }else{
            return "抢购成功";
        }
    }
}
