package xy.commer.cloud.main.service.impl;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;

import xy.commer.cloud.entity.User;
import xy.commer.cloud.main.mapper.UserMapper;
import xy.commer.cloud.service.UserService;

//因为作为一个dubbo服务提供者，启动时需要知道发布的服务是在哪，不使用dubbo提供的@service注解会出现问题的。
//注意这里是service要引dubbo的  
@Service
public class UserServiceImpl implements UserService {

	@Resource
	UserMapper userMapper;

	@Override
	public User findUserById(long id) {
		return this.userMapper.findUserById(id);
	}

}
