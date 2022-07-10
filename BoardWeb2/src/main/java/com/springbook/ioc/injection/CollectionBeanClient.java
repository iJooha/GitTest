package com.springbook.ioc.injection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean)factory.getBean("CollectionBean");
		List<String> list = bean.getAddressList();
		
		for(String st:list)
			System.out.println(st);
			System.out.println("-----------------set-----------------");
			
			Set<String> set = bean.getAddressSet();
			
			for(String st1:set)
				System.out.println(st1); //set은 중복된 값은 콘솔에 나오지 않는다.
				
			
			System.out.println("---------------Map-------------------");
		Map<String,String> map =  bean.getAddressMap();
		
		for(String key:map.keySet()) 
			System.out.println(key+","+ map.get(key));
			
			System.out.println("--------------Properties--------------------");
			Properties pro = bean.getAddressProperties();
		      for(String key : pro.stringPropertyNames()) {
		         System.out.println( String.format("key : %s , value:%s", key, pro.get(key)));
		      }
			
			
		factory.close();
		
	}
	
		}

