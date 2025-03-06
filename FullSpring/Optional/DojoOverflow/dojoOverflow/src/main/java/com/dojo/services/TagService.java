package com.dojo.services;

import org.springframework.stereotype.Service;

import com.dojo.models.Tag;
import com.dojo.repositories.TagRepo;

@Service
public class TagService {
	
	private final TagRepo tagRepo;

	public TagService(TagRepo tagRepo) {
		this.tagRepo = tagRepo;
	}
	
	public Tag addTag(Tag tag) {
		return tagRepo.save(tag);
	}
	
	public Tag findBySubject(String subject) {
		return tagRepo.findBySubjectIs(subject);
	}
	

	
	
	

}
