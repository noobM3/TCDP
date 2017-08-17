package com.hangzhu.service;

import java.util.List;

import com.hangzhu.po.Cargo;

public interface CargoService
{
	public List<Cargo> getMyCargos(String ono);
	
	public void addCargo(Cargo cargo);
	
	public void deleteCargo(String ono,int cno);
	
	public List<Cargo> getCargo1(String ono);
	
	public List<Cargo> getCargo2(String ono);
	
	public List<Cargo> getCargo3(String ono);
	
	public List<Cargo> getCargo4(String ono);
}
