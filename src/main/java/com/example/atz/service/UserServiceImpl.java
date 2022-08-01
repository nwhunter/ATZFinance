package com.example.atz.service;

import com.example.atz.model.User;
import com.example.atz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//User handling methods
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers(){return userRepository.findAll();}

    @Override
    public void saveUser(User user){this.userRepository.save(user);}

    @Override
    public User getUserById(long sid){
        Optional<User> optional = userRepository.findById(sid);
        User user = null;
        if (optional.isPresent()){
            user = optional.get();
        } else {
            throw new RuntimeException(" Student not found for id :: " + sid);
        }
        return user;
    }

    @Override
    public Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection){
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.userRepository.findAll(pageable);
    }
}
