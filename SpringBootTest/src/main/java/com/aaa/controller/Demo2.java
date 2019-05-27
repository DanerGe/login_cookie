package com.aaa.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aaa.pojo.User;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Demo2 {
	@RequestMapping("/test3")
	public String test3(){
		return "/login";
	}
	
	@RequestMapping("/test1")
	public String test1(){
		return "/NewFile";
	}
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(User user,HttpServletRequest request,HttpServletResponse response){
		if(user.isRember()){
		Cookie cookie = new Cookie("loginUserCookie", user.getUsername()+","+user.getPassword());
		cookie.setMaxAge(60*60*24*365);
		cookie.setPath("/");
		response.addCookie(cookie);
		}
		return "/login";
	}
	@RequestMapping("/signout")
	public String signout(HttpServletResponse response){
		Cookie cookie = new Cookie("loginUserCookie", "");
		response.addCookie(cookie);
		try {
			response.getWriter().println("退出成功!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/NewFile";
	}
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	@ResponseBody
	public String login(String uname,String pwd){
		System.out.println(uname);
		System.out.println(pwd);
		return "ok";
	}
}
