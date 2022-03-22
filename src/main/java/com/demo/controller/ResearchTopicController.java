package com.demo.controller;

import com.demo.controller.dto.PageableDto;
import com.demo.controller.dto.researchTopic.ResearchTopicDto;
import com.demo.persistence.model.PageableEntityData;
import com.demo.persistence.model.ResearchTopic;
import com.demo.service.ResearchTopicService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/research-topics")
public class ResearchTopicController {

  @Autowired private ResearchTopicService researchTopicService;

  @GetMapping
  public PageableDto<ResearchTopicDto> getResearchTopics(
      @PageableDefault()
          @SortDefault.SortDefaults({@SortDefault(sort = "name", direction = Sort.Direction.ASC)})
          Pageable pageable) {

    PageableEntityData<ResearchTopic> serviceData =
        researchTopicService.getResearchTopics(pageable);

    List<ResearchTopicDto> dtoList =
        serviceData.getData().stream()
            .map(ResearchTopicDto::convertToDto)
            .collect(Collectors.toList());

    return new PageableDto<>(dtoList, serviceData.getTotalRecords());
  }
}
