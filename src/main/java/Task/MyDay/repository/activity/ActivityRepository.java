package Task.MyDay.repository.activity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Task.MyDay.model.User;
import Task.MyDay.model.activity.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long>{
    List<Activity> findByUser_id(Long userId);
    Optional<Activity> findByUserAndId(User user , Long atividadeId);
}
