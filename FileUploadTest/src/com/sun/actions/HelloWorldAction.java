package com.sun.actions;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date birthday;
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		System.out.println(birthday);
		this.birthday = birthday;
	}

	public String excute() throws UnsupportedEncodingException{
		return "parampost";
	}
}
