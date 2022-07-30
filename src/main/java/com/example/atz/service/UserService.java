package com.example.atz.service;

import com.example.atz.model.User;
import org.springframework.data.domain.Page;

import java.util.List;


public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(long sid);
    Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
