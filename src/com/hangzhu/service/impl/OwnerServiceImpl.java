package com.hangzhu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hangzhu.mapper.OwnerServiceMapper;
import com.hangzhu.po.Owner;
import com.hangzhu.service.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService
{
	@Resource
	private OwnerServiceMapper osm;

	@Override
	public boolean addOwner(Owner owner)
	{
//		if(osm.checkOwner(owner.getOno()) != null)
//			return false;
		osm.addOwner(owner);
		return true;
	}

	@Override
	public void updatePone(String ono, String n_phone)
	{
		osm.updatePhone(ono, n_phone);
	}

	@Override
	public Owner checkOwner(String ono, String password)
	{
		return osm.checkOwner(ono, password);
	}
	
	@Override
	public String checkOno(String ono)
	{
		return osm.checkOno(ono);
	}

	@Override
	public void updatePw(String ono, String n_pw)
	{
		osm.updatePw(ono, n_pw);
	}

	@Override
	public boolean getOwner(String ono, String oname)
	{
		if(osm.getOwner(ono, oname) == null) return false;
		return true;
	}

	@Override
	public int getCount()
	{
		return osm.getCount();
	}

	@Override
	public int getCer(String ono)
	{
		if(osm.getCer(ono) == null) return 0;
		return (int)osm.getCer(ono);
	}

	@Override
	public void updateCer(String ono)
	{
		osm.updateCer(ono);
	}

}
