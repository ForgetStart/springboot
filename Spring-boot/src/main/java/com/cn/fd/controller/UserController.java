/**
 * 
 */
package com.cn.fd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.fd.domain.User;
import com.cn.fd.domain.UserRespository;
import com.cn.fd.rabbitmq_OneToOne.HelloSender;
import com.cn.fd.service.UserService;

/**
 * <p> Description: </p>
 * @author fengda
 * @date 2017年3月13日 下午6:10:09
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@Autowired
	private HelloSender helloSender;

	
	@Autowired
	private UserRespository userRespository;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@RequestMapping("/user/save")
	@ResponseBody
	public String createUser(User user){
		String result = userService.createUser(user);
		return result;
	}
	
	
	@RequestMapping("/user/list")
	public String userList(Model model){
		List<User> list = userService.usetList();
		model.addAttribute("userlist", list);
		return "userList";
	}
	
	
	@RequestMapping("/user/detail")
	public String userDetail(Integer id, Model model){
		User user = userService.detailUser(id);
		System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
		model.addAttribute("user", user);
		return "detail";
	}
	
	/**
	 * 根据名称查询，根据id排序，取出前两条
	 * @param username
	 * @return
	 */
	@RequestMapping("/user/findUser")
	@ResponseBody
	public String findFirst2ByUsername(String username){
		List<User> list = userService.findFirst2ByUsername(username);
		return list.toString();
	}
	
	/**
	 * 用户修改
	 * 示例		http://localhost:8080/user/update?username=789&password=456
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/user/update")
	@ResponseBody
	public String updateUser(String username, String password){
		try {
			userService.updateUser(username, password);
			return "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "修改失败";
		}
	} 
	
	@RequestMapping("/index")
	public String index(){
		return "useradd";
	}
	
	
	/**
	 * 测试将数据放到redis缓存中 
	 * @return
	 */
 	@RequestMapping("/getUser")
    public User getUser() {
    	User user=userRespository.findByusername("fd");
    	redisTemplate.opsForValue().set("user", user);
        return user;
    }
 	
 	
 	/**
 	 * 测试一对多发送消息
 	 * 结果
 	 * 	例如发送者发送四条消息 1，2，3，4，
 	 * 	   当有两个接收者  receiver1和receiver2
 	 * 		接收情况	receiver1 接收到1	receiver2	接收到2
 	 * 				receiver1接收到3	receiver2	接收到4
 	 * @return
 	 */
 	@RequestMapping("/mq")
 	@ResponseBody
 	public String mq(){
 		try {
 			for(int i = 0;i<5; i++){
 				helloSender.send(i);
 			}
			return "成功";
		} catch (Exception e) {
			return "失败";
		}
 	}
 	
 	
 	@RequestMapping("/user/sel")
 	public void selectAll(){
 		List<User> list = userRespository.selectAll();
 		System.out.println(list);
 	}
}
