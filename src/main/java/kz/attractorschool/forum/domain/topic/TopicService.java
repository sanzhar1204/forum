package kz.attractorschool.forum.domain.topic;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TopicService {

  private final TopicRepository topicRepository;

  public Page<Topic> getAll(Pageable pageable){
    return topicRepository.findAll(pageable);
  }

}
