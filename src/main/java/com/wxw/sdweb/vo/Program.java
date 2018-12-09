package com.wxw.sdweb.vo;

import java.sql.Date;

public class Program {

	private int id;
	private Date pdate;
	private String pstime;
	private String pname;
	private int plength;
	private String purl;
	private String ptype;
	private String isnew;
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

	public String getPstime() {
		return pstime;
	}

	public void setPstime(String pstime) {
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

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getIsnew() {
		return isnew;
	}

	public void setIsnew(String isnew) {
		this.isnew = isnew;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
