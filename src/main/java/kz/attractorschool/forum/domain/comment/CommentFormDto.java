package kz.attractorschool.forum.domain.comment;

import lombok.Data;

@Data
public class CommentFormDto {

  private String content;
  private Integer topicId;
}
