package com.zfy.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.zfy.pojo.Users;



public interface UsersRepositoryPagingAndSorting extends PagingAndSortingRepository<Users, Integer> {

}
