package kz.attractorschool.forum.domain.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

  private final CommentService cartService;

  @GetMapping
  public Page<Comment> getCommentsBy(Integer topicId, Pageable pageable) {
    return cartService.getAllByTopicId(topicId, pageable);
  }
}


