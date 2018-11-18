package com.wxw.sdweb.vo;

import java.sql.Date;
import java.sql.Time;

public class Program {

	private int id;
	private Date pdate;
	private Time pstime;
	private String pname;
	private int plength;
	private String purl;
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public Time getPstime() {
		return pstime;
	}

	public void setPstime(Time pstime) {
		this.pstime = pstime;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPlength() {
		return plength;
	}

	public void setPlength(int plength) {
		this.plength = plength;
	}

	public String getPurl() {
		return purl;
	}

	public void setPurl(String purl) {
		this.purl = purl;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
