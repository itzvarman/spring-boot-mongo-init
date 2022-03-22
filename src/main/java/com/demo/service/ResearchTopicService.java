package com.demo.service;

import com.demo.exception.NoContentException;
import com.demo.persistence.model.PageableEntityData;
import com.demo.persistence.model.ResearchTopic;
import com.demo.persistence.repository.ResearchTopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ResearchTopicService {

  @Autowired private ResearchTopicRepository researchTopicRepository;

  public PageableEntityData<ResearchTopic> getResearchTopics(Pageable pageable) {

    Page<ResearchTopic> pagedData = researchTopicRepository.findAll(pageable);

    if (pagedData.getContent().isEmpty()) throw new NoContentException();

    return new PageableEntityData<>(pagedData.getContent(), (int) pagedData.getTotalElements());
  }
}
