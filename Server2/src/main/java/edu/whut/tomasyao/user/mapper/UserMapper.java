package edu.whut.tomasyao.user.mapper;

import edu.whut.tomasyao.user.vo.UserVo;
import org.springframework.stereotype.Repository;

/**
 * Created by zouy on 18-6-29.
 */
@Repository
public interface UserMapper {
    UserVo getUser(int id);

}
