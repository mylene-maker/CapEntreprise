package com.hb.capentreprise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hb.capentreprise.entities.InternalRole;

@Repository
public interface InternalRoleRepository extends JpaRepository <InternalRole, Integer>{

}
