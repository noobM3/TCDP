package com.hangzhu.mapper;

import org.apache.ibatis.annotations.Param;

import com.hangzhu.po.Logistics;

public interface LogisticsServiceMapper
{
	/**
	 * 
	 * @param lname
	 * @return Logistics
	 * @description:��ȡָ��������˾����
	 */
	public Logistics display(String lname);
	
	/**
	 * 
	 * @param lno
	 * @description:�޸Ĺ�˾��ϵ�绰
	 */
	public void updateLogisticsPhone(@Param("lno")String lno,@Param("n_phone")String n_phone);
	
	/**
	 * 
	 * @param lno
	 * @description:�޸Ĺ�˾���������ַ
	 */
	public void updateLogisticsEmail(@Param("lno")String lno,@Param("n_email")String n_email);	
	
	/**
	 * 
	 * @param lno
	 * @description:�޸Ĺ�˾��ַ
	 */
	public void updateLogisticsAddress(@Param("lno")String lno,@Param("n_address")String n_address);
	
	public int getCount();
}
