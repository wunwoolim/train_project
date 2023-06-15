package com.korail.dao;

import java.util.List;

public interface MyktxDao {
	/* int insert(Object obj); */
	List<Object> select(int startCount, int endCount);

}

