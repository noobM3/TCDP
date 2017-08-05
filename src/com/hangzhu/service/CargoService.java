package com.hangzhu.service;

import java.util.List;

import com.hangzhu.po.Cargo;

public interface CargoService
{
	public List<Cargo> getMyCargos(String ono);
	
	public void addCargo(Cargo cargo);
}
