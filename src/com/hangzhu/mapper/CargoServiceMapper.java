package com.hangzhu.mapper;

import java.util.List;

import com.hangzhu.po.Cargo;

public interface CargoServiceMapper
{
	public List<Cargo> getCargos(String ono);
	
	public void addCargo(Cargo cargo);
}
