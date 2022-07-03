package com.zeal.mall.service;

import com.zeal.mall.exception.ImoocMallException;
import com.zeal.mall.model.pojo.User;

import java.security.NoSuchAlgorithmException;

/**
 * @version: java version 1.8
 * @author: zeal
 * @description: UserService
 * @date: 2022-06-11 15:56
 */

public interface UserService {
     User getUser();
     void register(String username,String password) throws ImoocMallException, NoSuchAlgorithmException;

     User login(String username, String password) throws ImoocMallException;

     void updateInformation(User user) throws ImoocMallException;

     boolean checkAdminRole(User user);
}
