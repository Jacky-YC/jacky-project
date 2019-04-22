package com.fastone.test.dao;

import com.fastone.test.domain.User;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User,Integer> , QuerydslPredicateExecutor<User> {



}
