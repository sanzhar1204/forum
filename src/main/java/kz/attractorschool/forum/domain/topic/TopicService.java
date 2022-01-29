package kz.attractorschool.forum.domain.topic;

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
public class TopicService {

  private final TopicRepository topicRepository;
  private final UserRepository userRepository;

  public Page<Topic> getAll(Pageable pageable){
    return topicRepository.findAll(pageable);
  }

  public Topic getBy(Integer id) {
    return topicRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
  }

  public Topic create(String topicName){
    String currentUsername = AuthUserService.getCurrentUsername();
    User user = userRepository.findByEmail(currentUsername).orElseThrow(ResourceNotFoundException::new);
    Topic topicToCreate = new Topic()
        .setName(topicName)
        .setCreatedAt(LocalDateTime.now())
        .setCreatedBy(user);
    return topicRepository.save(topicToCreate);
  }
}
