package com.dojo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.models.Tag;

@Repository
public interface TagRepo extends CrudRepository<Tag, Long>{
	
	Tag findBySubjectIs(String subject);

}
