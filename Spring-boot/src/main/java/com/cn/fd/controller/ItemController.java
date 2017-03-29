/**
 * 
 */
package com.cn.fd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cn.fd.domain.Item;
import com.cn.fd.service.ItemService;

/**
 * <p> Description: </p>
 * @author fengda
 * @date 2017年3月13日 下午2:56:32
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/save")
	@ResponseBody
	public String saveItem(){
		String result = itemService.saveItem();
		return result;
	}
	
	@RequestMapping("/index/a")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
		return "hello word";
	}
}
