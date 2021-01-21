package com.sbs.springboot.sbssb.service;

import java.util.List;

import com.sbs.springboot.sbssb.entities.Aarti;

public interface AartiService {

	public Aarti saveAarti(Aarti aarti);
	public Aarti getAarti(int id);
	public List<Aarti> getAarties();
	public int deleteAarti(int id);
	
}
