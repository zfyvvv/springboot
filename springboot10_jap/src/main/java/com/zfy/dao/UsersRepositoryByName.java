package com.zfy.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.zfy.pojo.Users;

public interface UsersRepositoryByName extends Repository<Users, Integer>{

	//方法的命名有要求；
	//驼峰式命名规则，findBy(关键字)+属性名称（首字母大写）+查询条件（首字母大写）
	List<Users> findByName(String name);
	
	//多条件，使用or也是可以的；
	List<Users> findByNameAndAge(String name,Integer age);
	//like
	List<Users> findByNameLike(String name);
}
