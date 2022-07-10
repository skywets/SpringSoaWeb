package spring.soa.web.service;

import spring.soa.web.entity.User;

public interface UserService {

    void save(User user);

    User findByUserName(String userName);
}
