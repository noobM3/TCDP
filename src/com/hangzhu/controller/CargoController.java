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
	
	@RequestMapping("addcargo.do")
	@ResponseBody
	public String addCargo(Cargo cargo)
	{
		System.out.println("-----------" + cargo);
		cs.addCargo(cargo);
		System.out.println("!!!!!!!!!!!!");
		return "{\"success\":true}";
	}
}
