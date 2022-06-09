package com.hb.capentreprise.service;

import java.util.List;

import com.hb.capentreprise.entities.Classification;

public interface IClassificationService {
	
	public Classification getClassification(Long id);

	public List<Classification> getClassifications();

	public Classification save(Classification classification);

	public void delete(Long id);
}
