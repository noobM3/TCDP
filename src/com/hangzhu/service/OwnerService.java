package com.hangzhu.service;

import com.hangzhu.po.Owner;

public interface OwnerService
{	
	/**
	 * 
	 * @param owner
	 * @description:添加货主
	 */
	public boolean addOwner(Owner owner);
	
	/**
	 * 
	 * @param ono
	 * @param n_phone
	 * @description:修改电话
	 */
	public void updatePone(String ono,String n_phone);
	
	/**
	 * 
	 * @param ono
	 * @param n_pw
	 * @description:修改密码
	 */
	public void updatePw(String ono,String n_pw);
	
	/**
	 * 
	 * @param ono
	 * @param password
	 * @return
	 * @description:登录检测
	 */
	public Owner checkOwner(String ono,String password);
	
	/**
	 * 
	 * @param ono
	 * @return
	 * @description:检测用户编号是否被使用
	 */
	public String checkOno(String ono);
	
	/**
	 * 
	 * @param ono
	 * @param oname
	 * @return
	 * @description:检测是否存在该货主
	 */
	public boolean getOwner(String ono,String oname);
	
	/**
	 * 
	 * @return
	 * @description:获取货主数
	 */
	public int getCount();
	
	/**
	 * 
	 * @param ono
	 * @return
	 * @description:获取货主的认证状态
	 */
	public int getCer(String ono);
	
	/**
	 * 
	 * @param ono
	 * @description:更新货主的认证状态
	 */
	public void updateCer(String ono);
}
