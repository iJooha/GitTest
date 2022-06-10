package com.it.dao;

import java.util.*;

/*create table jspBoard(
	no int auto_increment,
    name varchar(34) not null,
    subject varchar(1000) not null,
    content text not null,
    pwd varchar(10) not null,
    regdate datetime,
    hit int default 0,
    
    primary key(no)
); 
 */

public class BoardVO {

	private int no, hit;
	private String name, subject, content, pwd, dbday;
	private Date regdate;

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * @return the dbday
	 */
	public String getDbday() {
		return dbday;
	}
	/**
	 * @param dbday the dbday to set
	 */
	public void setDbday(String dbday) {
		this.dbday = dbday;
	}
	/**
	 * @return the regdate
	 */
	public Date getRegdate() {
		return regdate;
	}
	/**
	 * @param regdate the regdate to set
	 */
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
		
}
