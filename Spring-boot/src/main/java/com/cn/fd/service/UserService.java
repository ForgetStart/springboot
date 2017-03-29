/**
 * 
 */
package com.cn.fd.service;

import java.util.List;

import com.cn.fd.domain.User;

/**
 * <p> Description: </p>
 * @author fengda
 * @date 2017年3月13日 下午6:10:19
 */
public interface UserService {

	public String createUser(User user);
	
	public List<User> usetList();
	
	public User detailUser(Integer id);
	
	public List<User> findFirst2ByUsername(String username);
	
	public void updateUser(String username, String password);
}
