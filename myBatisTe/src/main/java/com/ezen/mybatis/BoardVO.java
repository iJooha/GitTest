package com.ezen.mybatis;

import lombok.Data;

/*create table board(
	    id NUMBER(5) PRIMARY KEY,
	    name VARCHAR(20),
	    phone VARCHAR2(20),
	    address VARCHAR2(50)
	);*/

@Data
public class BoardVO {
	private int id;
	private String name;
	private String phone;
	private String address;
	

}
