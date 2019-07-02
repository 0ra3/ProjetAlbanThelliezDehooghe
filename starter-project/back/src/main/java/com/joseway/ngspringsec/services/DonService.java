package com.joseway.ngspringsec.services;

import java.util.List;

import com.joseway.ngspringsec.model.Don;

public interface DonService {

	public Don findById(Long id);
	
	public Don save(Don don);
	
	public List<Don> findAll();
}
