package kz.attractorschool.forum.domain.topic;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TopicDto {

  private Topic topic;
  private Integer commentsCount;

}
