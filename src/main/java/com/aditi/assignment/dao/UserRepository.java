package com.aditi.assignment.dao;

import com.aditi.assignment.model.UserData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserData, String> {

    //UserData findByUserId(String id);

    List<UserData> findAllByActionsType(String type);

    UserData findByUserIdAndActionsType(String id, String type);

    UserData findByUserIdAndActionsTypeAndActionsTime(String userId, String type, String time);

    List<UserData> findByActionsTimeAndActionsType(String time, String type);

    List<UserData> findAllByActionsTime(String time);

}
