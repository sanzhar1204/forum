package kz.attractorschool.forum.domain.comment;

import kz.attractorschool.forum.domain.topic.Topic;
import kz.attractorschool.forum.domain.topic.TopicRepository;
import kz.attractorschool.forum.domain.user.AuthUserService;
import kz.attractorschool.forum.domain.user.User;
import kz.attractorschool.forum.domain.user.UserRepository;
import kz.attractorschool.forum.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class CommentService {

  private final CommentRepository commentRepository;
  private final UserRepository userRepository;
  private final TopicRepository topicRepository;

  public Page<Comment> getAllByTopicId(Integer topicId, Pageable pageable){
    return commentRepository.findByTopic_id(topicId, pageable);
  }

  public Comment create(Integer topicId, String content){
    String currentUsername = AuthUserService.getCurrentUsername();
    User user = userRepository.findByEmail(currentUsername).orElseThrow(ResourceNotFoundException::new);
    Topic topic = topicRepository.findById(topicId).orElseThrow(ResourceNotFoundException::new);

    Comment comment = new Comment()
        .setCreatedBy(user)
        .setCreatedAt(LocalDateTime.now())
        .setTopic(topic)
        .setContent(content);

    return commentRepository.save(comment);
  }

}
