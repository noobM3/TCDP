package com.hangzhu.po;

import java.util.List;

public class Owner
{
	private String	ono;		// �������
	private String	oname;		// ��������
	private String	sex;		// �Ա�
	private String	phone;		// �绰
	private String	password;	// ����
	private int		cer;		// ��֤״̬--0��δ��֤ 1������֤
	
	public Owner()
	{
		// TODO Auto-generated constructor stub
	}

	public Owner(String ono, String oname, String sex, String phone, String password, int cer)
	{
		super();
		this.ono = ono;
		this.oname = oname;
		this.sex = sex;
		this.phone = phone;
		this.password = password;
		this.cer = cer;
	}

	public String getOno()
	{
		return ono;
	}

	public void setOno(String ono)
	{
		this.ono = ono;
	}

	public String getOname()
	{
		return oname;
	}

	public void setOname(String oname)
	{
		this.oname = oname;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public int getCer()
	{
		return cer;
	}

	public void setCer(int cer)
	{
		this.cer = cer;
	}

	@Override
	public String toString()
	{
		return "Owner [ono=" + ono + ", oname=" + oname + ", sex=" + sex + ", phone=" + phone + ", password=" + password
				+ ", cer=" + cer + "]";
	}

	
	
}
