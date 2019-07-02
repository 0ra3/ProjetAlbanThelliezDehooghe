package com.joseway.ngspringsec.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseway.ngspringsec.model.Don;
import com.joseway.ngspringsec.repository.DonRepository;
import com.joseway.ngspringsec.services.DonService;

@Service
public class DonServiceImpl implements DonService{
	
	@Autowired
	private DonRepository donRepository;

	
	@Override
	public Don findById(Long id) {
		return donRepository.findById(id).get();
	}

	@Override
	public Don save(Don don) {
		return donRepository.save(don);
	}

	@Override
	public List<Don> findAll() {
		return donRepository.findAll();
	}

}
