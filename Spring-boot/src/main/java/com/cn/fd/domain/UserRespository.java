/**
 * 
 */
package com.cn.fd.domain;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p> Description: </p>
 * @author fengda
 * @date 2017年3月13日 下午6:08:47
 */
public interface UserRespository extends JpaRepository<User, Integer>{
	
	public  List<User> findFirst2ByUsername(String username, Sort sort); 

	public User findByusername(String username);
	
	
	/**
	 * 在SQL的查询方法上面使用@Query注解，
	 * 如涉及到删除和修改在需要加上@Modifying.
	 * 也可以根据需要添加 @Transactional 对事物的支持，查询超时的设置等
	 * 修改方法如果不添加	@Transactional就会报错，可以直接加载dao上，也可以写在service上 
	 * 
	 * UPDATE 或 DELETE 操作需要使用事务，此时需要定义 Service 层，在 Service 层的方法上添加事务操作； 
	 * 默认情况下， SpringData 的每个方法上有事务， 但都是一个只读事务。 他们不能完成修改操作。
	 * @param username
	 * @param password
	 */
	@Modifying
	//@Transactional
	@Query("update User set password = :password where username = :username")
	public void updateUser(@Param("username")String username,@Param("password")String password);
	
	
	/**
	 * 使用sql语句直接将返回值映射到对象中
	 * @return
	 */
	@Query(value="select * from tb_user",nativeQuery=true)			
	public List<User> selectAll();
}
