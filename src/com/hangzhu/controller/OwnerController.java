package com.hangzhu.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hangzhu.po.Owner;
import com.hangzhu.service.OwnerService;

import sun.tools.jar.resources.jar;

@Controller
@RequestMapping("/owner/")
public class OwnerController
{
	private HttpSession session;
	
	@Resource
	private OwnerService os;
	
	@RequestMapping("getsession.do")
	@ResponseBody
	public Owner getSession()
	{	
		if(session.getAttribute("owner") == null) return null;
//		System.out.println("-----------" + session.getAttribute("owner"));
		return (Owner)this.session.getAttribute("owner");
	}
	
	
	/**
	 * 
	 * @param owner
	 * @return
	 * @description:检测是否有符合条件的货主--角色判断
	 */
	@RequestMapping("getowner.do")
	@ResponseBody
	public String getOwner(String ono,String oname)
	{
//		System.out.println(ono);
//		System.out.println(oname);
		if(os.getOwner(ono, oname)) return "{\"success\":true}";
		return "{\"success\":false}";
	}
	
	@RequestMapping(value="register.do",method = RequestMethod.POST)
	public void register(Owner owner,HttpServletRequest request,HttpServletResponse response)
	{
		//System.out.println(owner);
		os.addOwner(owner);
		session = request.getSession();
		session.setAttribute("owner", owner);
		try
		{
			response.sendRedirect("../platform.html");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param owner
	 * @param request
	 * @param response
	 * @description:登录
	 */
	@RequestMapping(value="login.do")
	public void login(Owner owner,HttpServletRequest request,HttpServletResponse response)
	{
//		System.out.println(owner);
		if((owner=os.checkOwner(owner.getOno(), owner.getPassword())) == null)
		{
			try
			{
				request.getRequestDispatcher("/WEB-INF/jsp/loginfail.jsp").forward(request, response);
				return;
			} catch (ServletException | IOException e)
			{
				e.printStackTrace();
			}
		}
//		System.out.println(owner);
		session = request.getSession();
		session.setAttribute("owner", owner);
		try
		{
			response.sendRedirect("../platform.html");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@RequestMapping("cpw.do")
	@ResponseBody
	public String changPw(HttpServletRequest request)
	{
		String npw = request.getParameter("npw1");
		HttpSession session = request.getSession();
		Owner user = (Owner) session.getAttribute("owner");
		os.updatePw(user.getOno(), npw);
		return "Success!";
	}
	
    @RequestMapping("logoff.do")
    public void logoff(HttpSession session,HttpServletResponse response)
    {
        session.invalidate();
        try
		{
			response.sendRedirect("../login.html");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
    }
    
    @RequestMapping("info.do")
    public String getUserInfo()
    {
    	return "ownerinfo";
    }
	
    /**
     * 
     * @return
     * @description:获取当前平台货主总数
     */
    @RequestMapping("count.do")
    @ResponseBody
    public String getCount()
    {
    	int count = os.getCount();
    	return "{\"count\":\"" + count + "\"}";
    }
    
    /**
     * 
     * @param ono
     * @return
     * @description:获取货主认证状态
     */
    @RequestMapping("cerState.do")
    @ResponseBody
    public String getCerState(String ono)
    {
    	int cer = os.getCer(ono);
    	if(cer == 0) return "{\"cer\":\"" + cer + "\"}"; //未认证
    	if(cer == 1) return "{\"cer\":\"" + cer + "\"}"; //认证中
    	return "{\"cer\":\"" + cer + "\"}";                //已认证
    }
    
    @RequestMapping("updatecer.do")
    @ResponseBody
    public String updateCer(String ono)
    {
    	os.updateCer(ono);
    	return "{\"success\":true}";
    }
    
    /**
     * 
     * @param ono
     * @return JSON
     * @description:检测用户编号是否已被使用
     */
    @RequestMapping("checkono.do")
    @ResponseBody
    public String checkOno(String ono)
    {
    	if(os.checkOno(ono) == null) return "{\"success\":true}";
    	return "{\"fail\":true}";
    }
    
}
