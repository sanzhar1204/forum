package kz.attractorschool.forum.domain.topic;

import com.fasterxml.jackson.annotation.JsonBackReference;
import kz.attractorschool.forum.domain.comment.Comment;
import kz.attractorschool.forum.domain.user.User;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "topics")
@Accessors(chain = true)
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User createdBy;

    private LocalDateTime createdAt;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "topic_id")
    @JsonBackReference
    private List<Comment> comments;
}
