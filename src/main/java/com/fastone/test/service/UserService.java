package com.fastone.test.service;

import com.fastone.test.dao.UserDao;
import com.fastone.test.domain.QUser;
import com.fastone.test.domain.User;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	JPAQueryFactory jpaQueryFactory;

	// SpringDataJpa查询
	public Optional<User> findOne(Integer uid) {
		return userDao.findById(uid);
	}

	public User addUser(User user) {
		return userDao.save(user);
	}

	public List<User> findAll() {
		return (List<User>) userDao.findAll();
	}

	public void deleteById(Integer uid) {
		userDao.deleteById(uid);
	}

	// Querydsl原生查询
	public User findByUsername(String username) {
		QUser user = QUser.user;

		return jpaQueryFactory.selectFrom(user)
				.where(
						user.username.eq(username)
				)
				.fetchOne();
	}

	// SpringDataJPA + Querydsl 查询
	public List<User> findByUsernameAndAge(String username, Integer age) {
		QUser user = QUser.user;
		return (List<User>) userDao.findAll(
				user.username.eq(username)
						.and(user.age.eq(age))
				, user.uid.desc()
		);
	}

	public Long countByUsernameLike(String likeName) {
//        NumberExpression<Long> usernameLikeExpression = QUser.user.username.like(likeName).count();
		BooleanExpression like = QUser.user.username.like("%" + likeName + "%");
		return userDao.count(like);
	}
}
