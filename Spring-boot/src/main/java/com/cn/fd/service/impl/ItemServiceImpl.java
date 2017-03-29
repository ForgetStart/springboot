/**
 * 
 */
package com.cn.fd.service.impl;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.fd.domain.Item;
import com.cn.fd.domain.ItemRepository;
import com.cn.fd.service.ItemService;

/**
 * <p> Description: </p>
 * @author fengda
 * @date 2017年3月13日 下午2:40:01
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	/**
	 * 添加商品
	 */
	@Override
	public String saveItem() {
		Item item = new Item();
		item.setId(getItemId());
		item.setTitle("aaa");
		item.setSellPoint("4544");
		item.setPrice(20);
		item.setNum(10);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		item.setCid(getItemId());
		item.setStatus(1);
		
		try {
			itemRepository.save(item);
			return "添加成功";
		} catch (Exception e) {
			return "添加失败";
		}
	}
	
	
	

	private static long getItemId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		//如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}
}
