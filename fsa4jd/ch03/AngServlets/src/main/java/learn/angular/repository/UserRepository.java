package learn.angular.repository;

import learn.angular.model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    void save(User user);
}
