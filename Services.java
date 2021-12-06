package com.greatlearning.springDEMO.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.springDEMO.entity.Students;

@Service
public interface Services {

public List<Students> findAll();
	
	public  Students findById(int id);
	
	public void save(Students student);
	
	public void deletedById(int id);
	
}
