package kz.attractorschool.forum.domain.topic;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class TopicController {

  private final TopicService topicService;

  @GetMapping("/api/topics")
  @ResponseBody
  public Page<TopicDto> getAll(Pageable pageable){
    return topicService.getAll(pageable).map(topic -> new TopicDto()
        .setTopic(topic)
        .setCommentsCount(topic.getComments().size())
    );
  }

  @GetMapping("/topics/{id}")
  public String getBy(@PathVariable("id") Integer id, Model model){
    model.addAttribute("topic", topicService.getBy(id));
    return "topic";
  }


  @GetMapping("/topics/create")
  public String showCreateForm(){
    return "topic-create";
  }

  @PostMapping("/topics")
  public String create(@ModelAttribute TopicFormDto topicFormDto){
    Topic topic = topicService.create(topicFormDto.getTopicName());
    return "redirect:/topics/" + topic.getId();
  }
}


