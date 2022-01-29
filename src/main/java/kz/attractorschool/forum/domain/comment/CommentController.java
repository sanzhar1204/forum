package kz.attractorschool.forum.domain.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class CommentController {

  private final CommentService commentService;

  @GetMapping("/api/comments")
  @ResponseBody
  public Page<Comment> getCommentsBy(Integer topicId, Pageable pageable) {
    return commentService.getAllByTopicId(topicId, pageable);
  }

  @PostMapping("/comments")
  public String createNew(@ModelAttribute CommentFormDto commentFormDto){
    Comment comment = commentService.create(commentFormDto.getTopicId(), commentFormDto.getContent());
    return "redirect:/topics/" + comment.getTopic().getId();
  }
}


