package com.example.btvalidation.service;




import com.example.btvalidation.entity.User;

import java.util.List;

public interface IUserService {
    List<User>findAll();
    boolean save(User user);
}
