package com.zfy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.zfy.pojo.Users;

public interface UsersRepositoryQueryAnnotation extends Repository<Users, Integer>{
	
	//查询,底层使用的是HQL;
	@Query("from Users where name=?")
	List<Users> queryByNameUseHQL(String name);
	
	//查询，使用原生态的SQL;
	@Query(value="select * from t_users where name=?",nativeQuery=true)
	List<Users> queryByNameUseSQL(String name);
	
	//更新，query本来是应该应用于查询的；
	@Query("update Users set name=? where id=?")
	@Modifying //需要执行一个更新操作；
	void updateUserNameById(String name,Integer id);
	
}
