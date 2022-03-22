package com.demo.persistence.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageableEntityData<T> {
  private List<T> data;
  private int totalRecords;
}
