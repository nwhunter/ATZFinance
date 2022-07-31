package com.example.atz.service;

import com.example.atz.model.Application;
import com.example.atz.model.User;
import com.example.atz.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public List<Application> getAllApplications(){return applicationRepository.findAll();}

    @Override
    public void saveApplication(Application application){this.applicationRepository.save(application);}

    @Override
    public Application getAppById(long appId){
        Optional<Application> optional = applicationRepository.findById(appId);
        Application app = null;
        if (optional.isPresent()){
            app = optional.get();
        } else {
            throw new RuntimeException(" Student not found for id :: " + appId);
        }
        return app;
    }


    @Override
    public Page<Application> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection){
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.applicationRepository.findAll(pageable);
    }
}
