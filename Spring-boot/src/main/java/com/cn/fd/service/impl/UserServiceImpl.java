/**
 * 
 */
package com.cn.fd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.fd.domain.User;
import com.cn.fd.domain.UserRespository;
import com.cn.fd.service.UserService;

/**
 * <p> Description: </p>
 * @author fengda
 * @date 2017年3月13日 下午6:10:59
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRespository userRespository;
	/**
	 * 添加用户
	 */
	@Override
	public String createUser(User user) {
		try {
			userRespository.save(user);
			return "添加成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "添加失败";
		}
	}
	
	
	/**
	 * 查询用户列表
	 */
	@Override
	public List<User> usetList() {
		List<User> list = userRespository.findAll();
		return list;
	}


	/**
	 * 查询用户详细信息
	 */
	@Override
	public User detailUser(Integer id) {
		User user = userRespository.findOne(id);
		return user;
	}


	/**
	 * 根据名称查询，根据id排序，取出前两条
	 */
	@Override
	public List<User> findFirst2ByUsername(String username) {
		Sort sort = new Sort(Direction.ASC, "id");
		List<User> list = userRespository.findFirst2ByUsername(username, sort);
		return list;
	}


	/* (non-Javadoc)
	 * @see com.cn.fd.service.UserService#updateUser(java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public void updateUser(String username, String password) {
		userRespository.updateUser(username, password);
	}

}
