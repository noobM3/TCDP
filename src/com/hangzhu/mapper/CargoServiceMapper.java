package com.hangzhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hangzhu.po.Cargo;

public interface CargoServiceMapper
{
	public List<Cargo> getCargos(String ono);
	
	public void addCargo(Cargo cargo);
	
	public void deleteCargo(@Param("ono")String ono,@Param("cno")int cno);
	
	public List<Cargo> getCargo1(String ono);

	public List<Cargo> getCargo2(String ono);
	
	public List<Cargo> getCargo3(String ono);
	
	public List<Cargo> getCargo4(String ono);
}
