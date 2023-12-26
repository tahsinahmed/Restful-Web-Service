package com.tahsin.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDaoService {
    private final static List<User> users = new ArrayList<>();
    private static int userIdCount = 0;
    static {
        users.add(new User(++userIdCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++userIdCount, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++userIdCount, "Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(Integer id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElseThrow(() -> new UserNotFoundException("Id: " + id));
    }

    public User save(User user) {
        user.setId(++userIdCount);
        users.add(user);
        return user;
    }
}
