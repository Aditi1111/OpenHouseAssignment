package com.aditi.assignment.controller;

import com.aditi.assignment.model.UserData;
import com.aditi.assignment.requests.UserRequest;
import com.aditi.assignment.response.UserDataResponse;
import com.aditi.assignment.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserOperations {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @PostMapping(path = "/createNewUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserDataResponse> createNewUSer(@RequestBody @Validated UserData request,
                                                          BindingResult validationResult){
        try{
            if(validationResult.hasFieldErrors()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new UserDataResponse(validationResult));//add more response details with the validation message
            }else{
                userService.addUser(request);
                return ResponseEntity.status(HttpStatus.OK).body(new UserDataResponse(UserDataResponse.Status.OK));
            }
        }catch (Exception ex){
            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new UserDataResponse(UserDataResponse.Status.ERROR));
        }
    }


    @GetMapping(path = "/getUser")
    public ResponseEntity<UserDataResponse> getUser(@RequestParam (value = "userId", required = false) String userId,
                                                    @RequestParam (value = "time", required = false) String dateParam,
                                                    @RequestParam (value = "type", required = false) String type
                                                    ){
        try{
            List<UserData> uData = new ArrayList<>();

            if(userId != null && type != null && dateParam !=null){
                uData.add(userService.getUserByUserIdAndActionType(userId,type));

            }else if(userId != null && type == null && dateParam == null){
                uData.add(userService.getUserByUserId(userId));

            }else if(type != null && userId == null && dateParam == null){
                uData = userService.getUserByActionType(type);

            }else if(dateParam!=null && userId==null && type==null){
                uData = userService.getAllUserByDate(dateParam);
            }else if(dateParam!=null && userId==null && type!=null){
                uData = userService.getUserbyDateAndType(dateParam,type);
            }else{//if everything null then return all
                uData = userService.getAllUser();

            }

            if(uData.get(0)==null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UserDataResponse(UserDataResponse.Status.ERROR));
            return ResponseEntity.status(HttpStatus.OK).body(new UserDataResponse(UserDataResponse.Status.OK, uData));
        }catch (Exception ex){
            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new UserDataResponse(UserDataResponse.Status.ERROR));
        }
    }
}
