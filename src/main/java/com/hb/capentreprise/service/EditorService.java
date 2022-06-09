package com.hb.capentreprise.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.hb.capentreprise.entities.Editor;
import com.hb.capentreprise.repositories.EditorRepository;

@Service
@Transactional
public class EditorService implements IEditorService{

	@Autowired
	private EditorRepository editorRepository;
	
	//READ
	@Override
	public Editor getEditor(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return editorRepository.findById(id).get();
	}

	@Override
	public List<Editor> getEditors() {
		// TODO Auto-generated method stub
		return editorRepository.findAll();
	}

	//CREATE
	@Override
	public Editor save(Editor editor) {
		// TODO Auto-generated method stub
		return editorRepository.save(editor);
	}

	//DELETE
	@Override
	public void delete(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		try {
			editorRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new NotFoundException();
		}
	}
	
	

}
