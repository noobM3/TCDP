package com.hangzhu.service;

import java.util.List;

import com.hangzhu.po.Transport;

public interface TransportService
{
	public List<Object> getTransports(String lno);
	
	public List<Transport> getTransport(String ono);
	
	public Transport checkTransport(String trackingno);

	public void deleteTransport(String trackingno);

	public boolean addTransport(Transport transport);

	public void updateTransport(String trackingno);
	
	public List<Transport> getUndo(String ono);
	
	public List<Transport> getDone(String ono);
}
