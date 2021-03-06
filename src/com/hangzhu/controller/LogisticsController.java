package com.hangzhu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hangzhu.mapper.LogisticsServiceMapper;
import com.hangzhu.po.Logistics;
import com.hangzhu.service.LogisticsService;

@Controller
@RequestMapping("/logistics/")
public class LogisticsController
{
	@Resource
	private LogisticsService ls;
	
	@RequestMapping("display.do")
	public String display(String lname,Model model)
	{
		Logistics logistics = ls.display(lname);
		model.addAttribute("logistics", logistics);
		return "logisticsdisplay";
	}
	
    /**
     * 
     * @return
     * @description:获取当前平台物流公司总数
     */
    @RequestMapping("count.do")
    @ResponseBody
    public String getCount()
    {
    	int count = ls.getCount();
    	return "{\"count\":\"" + count + "\"}";
    }
}
