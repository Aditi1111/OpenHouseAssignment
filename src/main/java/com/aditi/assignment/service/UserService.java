package com.aditi.assignment.service;

import com.aditi.assignment.dao.UserRepository;
import com.aditi.assignment.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public void addUser(UserData userData){
        userRepo.save(userData);
    }

    public List<UserData> getAllUser(){
        List<UserData> uData = new ArrayList<>();
        userRepo.findAll().forEach(uData::add);
        return uData;
    }

    public UserData getUserByUserId(String userId){
        return userRepo.findById(userId).orElse(null);
    }

    public UserData getUserByUserIdAndActionType(String userId, String type){
        return userRepo.findByUserIdAndActionsType(userId, type);
    }

    public List<UserData> getUserByActionType(String type){
        return userRepo.findAllByActionsType(type);
    }

    public UserData getUserByUserIdAndActionTypeAndDate(String userId, String type, String dateParam){
        return userRepo.findByUserIdAndActionsTypeAndActionsTime(userId, type, dateParam);
    }

    public List<UserData> getUserbyDateAndType(String dateParam, String type){
        return userRepo.findByActionsTimeAndActionsType(dateParam, type);
    }

    public List<UserData> getAllUserByDate(String dateParam){
        return userRepo.findAllByActionsTime(dateParam);
    }
}