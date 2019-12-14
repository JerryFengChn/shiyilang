package com.shiyilang.common.useful.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import com.shiyilang.common.useful.JDBC.JDBCUtil;
import org.junit.Test;

public class JdbcJunit {
    @Test
    public void jdbcTest(){
	List<List<Object>> users = new ArrayList<List<Object>>();
	for(int i=0;i<100000;i++){
	    List<Object> user = new ArrayList<Object>();
	    user.add("0");
	    user.add(new Timestamp(System.currentTimeMillis()));
	    users.add(user);
	}
	long start = System.currentTimeMillis();
	JDBCUtil.addOrUpdateBatch(users);
	System.out.println(System.currentTimeMillis()-start);
    }
}
