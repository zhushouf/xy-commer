package xy.commer.cloud.main.mapper;

import org.springframework.stereotype.Component;

import xy.commer.cloud.entity.User;

/**
 * mybatis操作db mapper接口
 * 
 */

@Component
public interface UserMapper {

	User findUserById(long id);

}
