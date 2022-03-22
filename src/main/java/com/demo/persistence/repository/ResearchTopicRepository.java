package com.demo.persistence.repository;

import com.demo.persistence.model.ResearchTopic;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResearchTopicRepository extends MongoRepository<ResearchTopic, String> {}
