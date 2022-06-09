package com.hb.capentreprise.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.hb.capentreprise.entities.Editor;

public interface IEditorService {
	
	public Editor getEditor(Long id)throws NotFoundException;
	
	public List<Editor> getEditors();
	
	public Editor save(Editor editor);
	
	public void delete(Long id) throws NotFoundException;
	
	
}
