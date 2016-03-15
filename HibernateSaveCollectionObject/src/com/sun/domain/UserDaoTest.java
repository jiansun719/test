package com.sun.domain;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class UserDaoTest {

	UserDao userDao = new UserDao();
	@Test
	public void testSave() {
		User user = new User();
		user.setName("zhangsan");
		Set<String> addressSet = new HashSet<String>();
		addressSet.add("xxx");
		addressSet.add("yyy");
		user.setAddressSet(addressSet);
		userDao.save(user);;
	}

	@Test
	public void testGetById() {
		User user = userDao.getById(3);
		System.out.println(user);
	}
}
