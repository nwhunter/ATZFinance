package com.example.atz.service;

import com.example.atz.model.Application;
import com.example.atz.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

//Methods to handle actions for User data
public interface ApplicationService {
    List<Application> getAllApplications();
    void saveApplication(Application application);
    Application getAppById(long appId);
    Page<Application> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
