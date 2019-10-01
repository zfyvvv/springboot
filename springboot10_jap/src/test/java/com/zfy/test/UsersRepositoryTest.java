package com.zfy.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.dialect.DB2390Dialect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zfy.App;
import com.zfy.dao.UsersRepository;
import com.zfy.dao.UsersRepositoryByName;
import com.zfy.dao.UsersRepositoryCurdRepository;
import com.zfy.dao.UsersRepositoryPagingAndSorting;
import com.zfy.dao.UsersRepositoryQueryAnnotation;
import com.zfy.dao.UsersRepositorySpecification;
import com.zfy.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={App.class})
public class UsersRepositoryTest {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private UsersRepositoryByName usersRepositoryByName;
	
	@Autowired
	private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;
	
	@Autowired
	private UsersRepositoryCurdRepository usersRepositoryCurdRepository;
	
	@Autowired
	private UsersRepositoryPagingAndSorting usersRepositoryPagingAndSorting;
	
	@Autowired
	private UsersRepositorySpecification usersRepositorySpecification;
	//add
	@Test
	public void testSave() {
		Users users=new Users();
		users.setName("小明");
		users.setAge(10);
		this.usersRepository.save(users);
	}
	
	//check
	@Test
	public void testFindByName() {
		List<Users> list=this.usersRepositoryByName.findByName("小红");
		for(Users u:list) {
			System.out.println(u.toString());
		}
	}
	@Test
	public void testFindByNameAndAge() {
		List<Users> list=this.usersRepositoryByName.findByNameAndAge("小刚", 20);
		for(Users u:list) {
			System.out.println(u.toString());
		}
	}
	//add
	@Test
	public void testFindByNameLike() {
		List<Users> list=this.usersRepositoryByName.findByNameLike("小%");
		for(Users u:list) {
			System.out.println(u.toString());
		}
	}
	
	//find by queryHQL
	@Test
	public void testQueryByNameUseHQL() {
		List<Users> list=this.usersRepositoryQueryAnnotation.queryByNameUseHQL("小明");
		for(Users u:list) {
			System.out.println(u.toString());
		}
	}
	//find by querySQL
	@Test
	public void testQueryByNameUseSQL() {
		List<Users> list=this.usersRepositoryQueryAnnotation.queryByNameUseSQL("小红");
		for(Users u:list) {
			System.out.println(u.toString());
		}
	}
	
	//update by query
	@Test
	@Transactional  //本该使用在service层的事务注解，由于测试，故提前到dao层；
					//当@Transactional和@Test一起使用时，事务是自动回滚的；
	@Rollback(false)//取消自动回滚；
	public void testUpdateUserNameById() {
		this.usersRepositoryQueryAnnotation.updateUserNameById("小明明", 1);
		
	}
	
	//add-UsersRepositoryCurdRepository
	//内部已经封装好了，直接调用即可；
	@Test
	public void testCurdUserReposity() {
		Users users=new Users();
		users.setName("小花");
		users.setAge(20);
		this.usersRepositoryCurdRepository.save(users);
	}
	
	//add-UsersRepositoryPagingAndSorting
	//sorting
	@Test
	public void testPageAndUserReposity1() {
		//order对象定义排序规则，降序排列；
		Order order=new Order(Direction.DESC,"age");
		//sort对象封装了排序规则
		Sort sort=new Sort(order);
		List<Users> list=(List<Users>) this.usersRepositoryPagingAndSorting.findAll(sort);
		for(Users u:list) {
			System.out.println(u.toString());
		}
	}
	
	//add-UsersRepositoryPagingAndSorting
	//paging
	@Test
	public void testPageAndUserReposity2() {
		//Pageable对象:封装了分页的参数，当前页，每页显示的条数，注意，当前页是从0开始的；
		//PageRequest(0, 3);当前页，每页显示的条数；
		Pageable pageable=new PageRequest(0, 3);
		//sort对象封装了排序规则
		Page<Users> page=this.usersRepositoryPagingAndSorting.findAll(pageable);
		System.out.println(page.getTotalElements()+"-->"+page.getTotalPages());
		for(Users u:page) {
			System.out.println(u.toString());
		}
	}
	
	//add-UsersRepositoryPagingAndSorting
	//paging+sort
	@Test
	public void testPageAndUserReposity3() {
		
		//order对象定义排序规则，降序排列；
		Order order=new Order(Direction.DESC,"age");
		//sort对象封装了排序规则
		Sort sort=new Sort(order);
		
		//Pageable对象:封装了分页的参数，当前页，每页显示的条数，注意，当前页是从0开始的；
		//PageRequest(0, 3);当前页，每页显示的条数；
		Pageable pageable=new PageRequest(0, 3,sort);
		//sort对象封装了排序规则
		Page<Users> page=this.usersRepositoryPagingAndSorting.findAll(pageable);
		System.out.println(page.getTotalElements()+"-->"+page.getTotalPages());
		for(Users u:page) {
			System.out.println(u.toString());
		}
	}
	
	//testJpaReposity
	//paging+sort
	//UsersRepositoryPagingAndSorting返回的对象，为一个page<User>;
	//JpaReposity将page<User>自动转成一个List<Users>；
	@Test
	public void testJpaReposity() {
		
		Order order=new Order(Direction.DESC,"age");
		Sort sort=new Sort(order);
		Pageable pageable=new PageRequest(0,3,sort);
		List<Users> list=this.usersRepository.findAll(sort);
		for(Users u:list) {
			System.out.println(u.toString());
		}
	}
	
	//UsersRepositorySpecification
	//单条件查询
	@Test
	public void testUsersRepositorySpecification1() {
	
	/*
	 * Specification<Users> 用于封装查询条件；
	 * 内部类；
	 */
	Specification<Users> spec=new Specification<Users>() {
		/*
		 * Predicate 封装了单个的查询条件；
		 * 
		 * Root<Users> root 封装查询对象属性的
		 * CriteriaQuery<?> query  封装了要执行的查询中的各个部分的信息 select from order；
		 * CriteriaBuilder cb 查询条件的构造器，定义不同的查询条件；
		 */
		@Override
		public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
			//where name = "小花"
			Predicate pre=cb.equal(root.get("name"), "小花");
			return pre;
		}
	};
	List<Users> list=this.usersRepositorySpecification.findAll(spec);
	for(Users u:list) {
		System.out.println(u.toString());
	}
	}
	
	//UsersRepositorySpecification
	//多条件查询
	@Test
	public void testUsersRepositorySpecification2() {
	
	/*
	 * Specification<Users> 用于封装查询条件；
	 * 内部类；
	 */
	Specification<Users> spec=new Specification<Users>() {
		/*
		 * Predicate 封装了单个的查询条件；
		 * 
		 * Root<Users> root 封装查询对象属性的
		 * CriteriaQuery<?> query  封装了要执行的查询中的各个部分的信息 select from order；
		 * CriteriaBuilder cb 查询条件的构造器，定义不同的查询条件；
		 */
		@Override
		public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
			//where name = "小绿" and age =25;
			List<Predicate> list=new ArrayList<>();
			list.add(cb.equal(root.get("name"), "小绿"));
			list.add(cb.equal(root.get("age"), "25"));
			//需要一个Predicate[]类型的可变数组；
			Predicate[] arr=new Predicate[list.size()];
			return cb.and(list.toArray(arr));
		}
	};
	List<Users> list=this.usersRepositorySpecification.findAll(spec);
	for(Users u:list) {
		System.out.println(u.toString());
	}
}
	
	//UsersRepositorySpecification
	//多条件查询-简化-and
		@Test
		public void testUsersRepositorySpecification3() {
		Specification<Users> spec=new Specification<Users>() {
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				//where name = "小绿" and age =25;
				/*List<Predicate> list=new ArrayList<>();
				list.add(cb.equal(root.get("name"), "小绿"));
				list.add(cb.equal(root.get("age"), "25"));*/
				return cb.and(cb.equal(root.get("name"), "小绿"),cb.equal(root.get("age"), "25"));
			}
		};
		List<Users> list=this.usersRepositorySpecification.findAll(spec);
		for(Users u:list) {
			System.out.println(u.toString());
		}
	}
	
	//UsersRepositorySpecification
	//多条件查询-简化-or-and;
		@Test
		public void testUsersRepositorySpecification4() {
		Specification<Users> spec=new Specification<Users>() {
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				//where name = "小绿" and age =25 or id =1;
				/*List<Predicate> list=new ArrayList<>();
				list.add(cb.equal(root.get("name"), "小绿"));
				list.add(cb.equal(root.get("age"), "25"));*/
				return cb.or(cb.and(cb.equal(root.get("name"), "小绿"),cb.equal(root.get("age"), "25")),cb.equal(root.get("id"), 1));
			}
		};
		List<Users> list=this.usersRepositorySpecification.findAll(spec);
		for(Users u:list) {
			System.out.println(u.toString());
		}
	}
		
	//UsersRepositorySpecification
	//多条件查询-简化-or-and-sort;
		@Test
		public void testUsersRepositorySpecification5() {
		Specification<Users> spec=new Specification<Users>() {
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				//where name = "小绿" and age =25 or id =1;
				/*List<Predicate> list=new ArrayList<>();
				list.add(cb.equal(root.get("name"), "小绿"));
				list.add(cb.equal(root.get("age"), "25"));*/
				return cb.or(cb.and(cb.equal(root.get("name"), "小绿"),cb.equal(root.get("age"), "25")),cb.equal(root.get("id"), 1));
			}
		};
		Sort sort=new Sort(new Order(Direction.DESC,"id"));
		List<Users> list=this.usersRepositorySpecification.findAll(spec,sort);
		for(Users u:list) {
			System.out.println(u.toString());
		}
	}
	
}
