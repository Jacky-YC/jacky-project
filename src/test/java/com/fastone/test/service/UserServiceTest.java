package com.fastone.test.service;

import com.fastone.test.JackyProjectApplication;
import com.fastone.test.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
@ContextConfiguration(classes = JackyProjectApplication.class)
public class UserServiceTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private UserService userService;

	@Test
	public void testFindOne() {
	}

	private User user = new User();
	private User user2 = new User();

	@BeforeClass
	public void before() {
		user.setUsername("jacky");
		user.setPassword("jacky123456");
		user2.setUsername("jacky.ye");
		user2.setPassword("jacky123456");
	}

	@Test(priority = 1, groups = {"findAll", "like"})
	public void testAddUser() {
		Assert.assertNotNull(userService.addUser(user).getId(), "添加失败");
		Assert.assertNotNull(userService.addUser(user2).getId(), "添加失败");
	}

	@Test(priority = 2, groups = "findAll")
	public void testFindAll() {
		System.out.println(userService.findAll());
	}

	@Test
	public void testDeleteById() {
	}

	@Test
	public void testFindByUsername() {
	}

	@Test
	public void testFindByUsernameAndAge() {
	}

	@Test(priority = 3, groups = "like")
	public void testCountByUsernameLike() {
		System.out.println(userService.countByUsernameLike("Jacky"));
	}

	@Test(dependsOnGroups = "like")
	public void testGroup(){

	}
}