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

}
