package kz.attractorschool.forum.domain.comment;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
  Page<Comment> findByTopic_id(Long topicId, Pageable pageable);
}
