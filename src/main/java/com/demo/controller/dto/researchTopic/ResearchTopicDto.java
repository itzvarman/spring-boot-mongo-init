package com.demo.controller.dto.researchTopic;

import com.demo.persistence.model.ResearchTopic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(builderMethodName = "researchTopicBuilder")
public class ResearchTopicDto {
  private String _id;
  private String name;
  private String reference;

  public static ResearchTopicDto convertToDto(ResearchTopic researchTopic) {
    ResearchTopicDto dto =
        ResearchTopicDto.researchTopicBuilder()
            ._id(researchTopic.get_id())
            .name(researchTopic.getName())
            .reference(researchTopic.getReference())
            .build();
    return dto;
  }
}
