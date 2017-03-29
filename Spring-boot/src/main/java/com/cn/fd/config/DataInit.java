/**
 * 
 */
package com.cn.fd.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.fd.domain.User;
import com.cn.fd.domain.UserRespository;



/**
 * <p> Description: </p>
 * @author fengda
 * @date 2017年3月23日 下午5:56:11
 */
@Service
public class DataInit {
    
    @Autowired 
    private UserRespository userRepository;
    
    //@PostConstruct			程序已启动就会自动执行	项数据中添加数据
    public void dataInit(){
        User admin = new User();
        admin.setPassword("admin");
        admin.setUsername("admin");
        admin.setRole(User.ROLE.admin);
        userRepository.save(admin);
        
        User user = new User();
        user.setPassword("user");
        user.setUsername("user");
        user.setRole(User.ROLE.user);
        userRepository.save(user);
    }
}
