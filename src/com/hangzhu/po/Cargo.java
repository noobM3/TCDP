package com.hangzhu.po;

public class Cargo
{
	private String	ono;		// �������
	private int		cno;		// �����ţ�1,2,3,4.������
	private String	cname;		// ������
	private double	weight;		// ��������λ����
	private String	price;		// �˵�����
	private String	starting;	// ������
	private String	ending;		// Ŀ�ĵ�
	private String	state;		// ����״̬�������䡢�����С��������
	private String	remark;		// ��ע
	
	public Cargo()
	{
		// TODO Auto-generated constructor stub
	}

	public Cargo(String ono, int cno, String cname, double weight,String price, String starting,
			String ending, String state, String remark)
	{
		super();
		this.ono = ono;
		this.cno = cno;
		this.cname = cname;
		this.weight = weight;
		this.price = price;
		this.starting = starting;
		this.ending = ending;
		this.state = state;
		this.remark = remark;
	}

	public String getOno()
	{
		return ono;
	}

	public void setOno(String ono)
	{
		this.ono = ono;
	}

	public int getCno()
	{
		return cno;
	}

	public void setCno(int cno)
	{
		this.cno = cno;
	}

	public String getCname()
	{
		return cname;
	}

	public void setCname(String cname)
	{
		this.cname = cname;
	}

	public double getWeight()
	{
		return weight;
	}

	public void setWeight(double weight)
	{
		this.weight = weight;
	}

	public String getPrice()
	{
		return price;
	}

	public void setPrice(String price)
	{
		this.price = price;
	}

	public String getStarting()
	{
		return starting;
	}

	public void setStarting(String starting)
	{
		this.starting = starting;
	}

	public String getEnding()
	{
		return ending;
	}

	public void setEnding(String ending)
	{
		this.ending = ending;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	@Override
	public String toString()
	{
		return "Cargo [ono=" + ono + ", cno=" + cno + ", cname=" + cname + ", weight=" + weight + ", price=" + price
				+ ", starting=" + starting + ", ending=" + ending + ", state=" + state + ", remark=" + remark + "]";
	}



	
}