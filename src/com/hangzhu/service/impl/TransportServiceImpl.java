package com.hangzhu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hangzhu.mapper.TransportServiceMapper;
import com.hangzhu.po.Transport;
import com.hangzhu.service.TransportService;

@Service
public class TransportServiceImpl implements TransportService
{
	@Resource
	private TransportServiceMapper tsm;
	
	@Override
	public List<Object> getTransports(String lno)
	{
		return tsm.getTransports(lno);
	}

	@Override
	public Transport checkTransport(String trackingno)
	{
		return tsm.checkTransport(trackingno);
	}

	@Override
	public void deleteTransport(String trackingno)
	{
		tsm.deleteTransport(trackingno);
	}

	@Override
	public boolean addTransport(Transport transport)
	{
		tsm.addTransport(transport);
		return true;
	}

	@Override
	public void updateTransport(String trackingno)
	{
		
	}

	@Override
	public List<Transport> getTransport(String ono)
	{
		return tsm.getTransport(ono);
	}

	@Override
	public List<Transport> getUndo(String ono)
	{
		return tsm.getUndo(ono);
	}

	@Override
	public List<Transport> getDone(String ono)
	{
		return tsm.getDone(ono);
	}

	@Override
	public void backup(String ono)
	{
		tsm.backupTransport(ono);
	}

}
