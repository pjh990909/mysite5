package com.javaex.vo;

public class BoardVo {

	private int no;
	private String title;
	private String content;
	private int hit;
	private String reg_date;
	private int user_no;
	private String name;
	
	public BoardVo() {
	}

	

	public BoardVo(int no, String title, String content, int hit, String reg_date, String name) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.reg_date = reg_date;
		this.name = name;
	}



	public BoardVo(int no, String title, String name, int hit, String reg_date) {
		this.no = no;
		this.title = title;
		this.name = name;
		this.hit = hit;
		this.reg_date = reg_date;
	}

	public BoardVo(int no, String title, String content, int hit, String reg_date, int user_no, String name) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.reg_date = reg_date;
		this.user_no = user_no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", content=" + content + ", hit=" + hit + ", reg_date="
				+ reg_date + ", user_no=" + user_no + ", name=" + name + "]";
	}

	
	
}
