package com.example.atz.service;

import com.example.atz.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

//Methods to handle actions for User data
public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(long sid);
    Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
