package com.hangzhu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hangzhu.po.Cargo;
import com.hangzhu.service.CargoService;

@Controller
@RequestMapping("/cargo/")
public class CargoController
{
	@Resource
	private CargoService cs;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("mycargos.do")
	@ResponseBody
	public Map getMyCargos(String ono)
	{	
		List<Cargo> cargos = cs.getMyCargos(ono);
		Map map = new HashMap<>();
		map.put("rows", cargos);
		map.put("total", cargos.size());
		return map;
	}
	
	/**
	 * 
	 * @param ono
	 * @return
	 * @description:获取待运输状态的货物
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("getcargo1.do")
	@ResponseBody
	public Map getCargo1(String ono)
	{	
		List<Cargo> cargos = cs.getCargo1(ono);
		Map map = new HashMap<>();
		map.put("rows", cargos);
		map.put("total", cargos.size());
		return map;
	}
	
	/**
	 * 
	 * @param ono
	 * @return
	 * @description:获取已接单状态的货物
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("getcargo2.do")
	@ResponseBody
	public Map getCargo2(String ono)
	{	
		List<Cargo> cargos = cs.getCargo2(ono);
		Map map = new HashMap<>();
		map.put("rows", cargos);
		map.put("total", cargos.size());
		return map;
	}
	
	/**
	 * 
	 * @param ono
	 * @return
	 * @description:获取运输中状态的货物
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("getcargo3.do")
	@ResponseBody
	public Map getCargo3(String ono)
	{	
		List<Cargo> cargos = cs.getCargo3(ono);
		Map map = new HashMap<>();
		map.put("rows", cargos);
		map.put("total", cargos.size());
		return map;
	}
	
	/**
	 * 
	 * @param ono
	 * @return
	 * @description:获取已完成状态的货物
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("getcargo4.do")
	@ResponseBody
	public Map getCargo4(String ono)
	{	
		List<Cargo> cargos = cs.getCargo4(ono);
		Map map = new HashMap<>();
		map.put("rows", cargos);
		map.put("total", cargos.size());
		return map;
	}
	
	@RequestMapping("addcargo.do")
	@ResponseBody
	public String addCargo(Cargo cargo)
	{
		cs.addCargo(cargo);
		return "{\"success\":true}";
	}
	
	@RequestMapping("removecargo.do")
	@ResponseBody
	public String removeCargo(String ono ,int cno)
	{
		cs.deleteCargo(ono, cno);
		return "{\"success\":true}";
	}
	
	@RequestMapping("editcargo.do")
	@ResponseBody
	public String editCargo(Cargo cargo)
	{
		System.out.println(cargo);
		cs.deleteCargo(cargo.getOno(), cargo.getCno());
		cs.addCargo(cargo);
		return "{\"success\":true}";
	}
	
	
	
}
