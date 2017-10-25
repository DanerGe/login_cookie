package com.aaa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author danerge
 * */
@RestController
public class Demo1 {
	@RequestMapping("/")
	public String test(){
		return "HelloWord";
	}
	@RequestMapping("/test2")
	public String test2(){
		return "NewFile";
	}
}
