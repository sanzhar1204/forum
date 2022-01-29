package kz.attractorschool.forum.domain.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CommentService {

  private final CommentRepository commentRepository;

  public Page<Comment> getAllByTopicId(Long topicId, Pageable pageable){
    return commentRepository.findByTopic_id(topicId, pageable);
  }

}
