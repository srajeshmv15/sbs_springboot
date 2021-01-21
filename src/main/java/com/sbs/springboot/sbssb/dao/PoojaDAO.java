package com.sbs.springboot.sbssb.dao;

import java.util.Date;
import java.util.List;

import com.sbs.springboot.sbssb.entities.Pooja;

public interface PoojaDAO {

	public Pooja savePooja(Pooja pooja);
	public Pooja getPooja(int id);
	public List<Pooja> getPoojas();
	public int deletePooja(int id);
	public List<Pooja> getPoojas(String queryString, Date poojaDate);
	
}
