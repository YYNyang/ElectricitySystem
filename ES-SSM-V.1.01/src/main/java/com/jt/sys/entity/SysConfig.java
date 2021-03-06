package com.jt.sys.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * pojo
 * @author we are young
 */
public class SysConfig implements Serializable{
	private static final long serialVersionUID = 6787816067025596323L;
	private Integer id;
	/**参数名*/
	private String name;
	/**参数值*/
	private String value;
	/**参数备注*/
	private String note;
	/**创建时间*/
	private Date createdTime;
	/**修改时间*/
	private Date modifiedTime;
	/**创建用户*/
	private String createdUser;
	/**修改用户*/
	private String modifiedUser;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	@Override
	public String toString() {
		return "SysConfig [id=" + id + ", name=" + name + ", value=" + value + ", note=" + note + ", createdTime="
				+ createdTime + ", modifiedTime=" + modifiedTime + ", createdUser=" + createdUser + ", modifiedUser="
				+ modifiedUser + "]";
	}
     
	
}
