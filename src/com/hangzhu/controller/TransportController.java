package com.hangzhu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hangzhu.po.Transport;
import com.hangzhu.service.TransportService;

@Controller
@RequestMapping("/transport/")
public class TransportController
{
	@Resource
	private TransportService ts;
	
	@RequestMapping("search.do")
	public String search(String trackingno,Model model)
	{
		Transport result = ts.checkTransport(trackingno);
		if(result == null) return "transportsearchfail";//跳转到     /fail.jsp
		model.addAttribute("transport", result);
		return "transportinfo";//跳转到      /transportinfo.jsp
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("gmts.do")
	@ResponseBody
	public Map getMyTransports(String ono)
	{	
		List<Transport> transports = ts.getTransport(ono);
		Map map = new HashMap<>();
		map.put("rows", transports);
		map.put("total", transports.size());
		return map;
	}
	
	@RequestMapping("delete.do")
	@ResponseBody
	public String deleteTransport(String trackingno)
	{
		ts.deleteTransport(trackingno);
		return "{\"success\":true}";
	}
}
