package com.hb.capentreprise.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hb.capentreprise.entities.Classification;

import com.hb.capentreprise.repositories.ClassificationRepository;


@Service
@Transactional
public class ClassificationService implements IClassificationService {
	
	@Autowired
	private ClassificationRepository classificationRepository;

	@Override
	public Classification getClassification(Long id) {
		Classification classification = classificationRepository.findById(id).get();
		return classification;
	}

	@Override
	public List<Classification> getClassifications() {
		Iterable<Classification> classifications = classificationRepository.findAll();
		return (List<Classification>) classifications;
	}

	@Override
	public Classification save(Classification classification) {
		classification = classificationRepository.save(classification);
		return classification;
	}

	@Override
	public void delete(Long id) {
		classificationRepository.deleteById(id);
	}

}
