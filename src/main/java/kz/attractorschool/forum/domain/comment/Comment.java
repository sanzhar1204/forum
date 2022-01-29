package kz.attractorschool.forum.domain.comment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import kz.attractorschool.forum.domain.topic.Topic;
import kz.attractorschool.forum.domain.user.User;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "comments")
@Accessors(chain = true)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User createdBy;

    private LocalDateTime createdAt;

    @ManyToOne
    @ToString.Exclude
    @JsonBackReference
    private Topic topic;

    private String content;
}
