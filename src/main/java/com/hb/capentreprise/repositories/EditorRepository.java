package com.hb.capentreprise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hb.capentreprise.entities.Editor;

@Repository
public interface EditorRepository extends JpaRepository <Editor, Long>{

}
