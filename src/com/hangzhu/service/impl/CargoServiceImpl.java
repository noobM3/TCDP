package com.hangzhu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hangzhu.mapper.CargoServiceMapper;
import com.hangzhu.po.Cargo;
import com.hangzhu.service.CargoService;

@Service
public class CargoServiceImpl implements CargoService
{
	@Resource
	private CargoServiceMapper csm;
	
	@Override
	public List<Cargo> getMyCargos(String ono)
	{
		return csm.getCargos(ono);
	}

	@Override
	public void addCargo(Cargo cargo)
	{
		csm.addCargo(cargo);
	}

	@Override
	public void deleteCargo(String ono, int cno)
	{
		csm.deleteCargo(ono, cno);
	}

	@Override
	public List<Cargo> getCargo1(String ono)
	{
		return csm.getCargo1(ono);
	}

	@Override
	public List<Cargo> getCargo2(String ono)
	{
		return csm.getCargo2(ono);
	}

	@Override
	public List<Cargo> getCargo3(String ono)
	{
		return csm.getCargo3(ono);
	}

	@Override
	public List<Cargo> getCargo4(String ono)
	{
		return csm.getCargo4(ono);
	}

}
