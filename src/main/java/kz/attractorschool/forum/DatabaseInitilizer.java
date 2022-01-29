package kz.attractorschool.forum;

import com.github.javafaker.Faker;
import kz.attractorschool.forum.domain.comment.Comment;
import kz.attractorschool.forum.domain.comment.CommentRepository;
import kz.attractorschool.forum.domain.topic.Topic;
import kz.attractorschool.forum.domain.topic.TopicRepository;
import kz.attractorschool.forum.domain.user.User;
import kz.attractorschool.forum.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
@RequiredArgsConstructor
public class DatabaseInitilizer {

  private final TopicRepository topicRepository;
  private final CommentRepository commentRepository;
  private final UserRepository userRepository;

  @Bean
  public CommandLineRunner init() {
    return (args -> {
      if (topicRepository.count() < 5) {
        commentRepository.deleteAll();
        topicRepository.deleteAll();
        userRepository.deleteAll();

        var faker = new Faker();
        List<User> users = generateUsers(faker);
        generateTopicsAndComments(faker, users);
      }
    });
  }

  private List<User> generateUsers(Faker faker) {
    var users = Stream.generate(() -> new User()
            .setEmail(faker.internet().emailAddress())
            .setPassword(faker.internet().password())
            .setEnabled(true))
        .limit(149)
        .collect(Collectors.toList());
    return userRepository.saveAll(users);
  }


  private void generateTopicsAndComments(Faker faker, List<User> users) {
    var topics = Stream.generate(() -> new Topic()
            .setCreatedAt(randomDateTime(faker))
            .setCreatedBy(getRandomUser(users, faker))
            .setName(faker.gameOfThrones().character())
        )
        .limit(149)
        .collect(Collectors.toList());

    topics.forEach(topic -> {
      List<Comment> comments = Stream.generate(() -> new Comment()
              .setCreatedBy(getRandomUser(users, faker))
              .setCreatedAt(randomDateTime(faker))
              .setContent(faker.gameOfThrones().quote())
              .setTopic(topic)
          )
          .limit(30)
          .collect(Collectors.toList());
      topic.setComments(comments);
    });
    topicRepository.saveAll(topics);
  }

  private User getRandomUser(List<User> users, Faker faker) {
    return users.get(faker.random().nextInt(0, 148));
  }

  private LocalDateTime randomDateTime(Faker faker) {
    return faker.date().birthday(0, 75).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
  }
}
