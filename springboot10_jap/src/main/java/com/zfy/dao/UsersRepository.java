package com.zfy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zfy.pojo.Users;

/**
 *参数T：当前需要映射的实体；
 *参数ID：当前映射实体的OID的类型； 
 */

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
