package com.ax.manager.service;

import com.ax.manager.dto.UserSearchDTO;
import com.ax.manager.pojo.BaseAdminUser;
import com.ax.manager.response.PageDataResult;

import java.util.Map;


/**
 * @Title: AdminUserService
 */
public interface AdminUserService {

    PageDataResult getUserList(UserSearchDTO userSearch, Integer pageNum, Integer pageSize);

    Map<String, Object> addUser(BaseAdminUser user);

    Map<String, Object> updateUser(BaseAdminUser user);

    BaseAdminUser getUserById(Integer id);

    BaseAdminUser findByUserName(String userName);

    int updatePwd(String userName, String password);

    Map<String, Object> delUser(Integer id, Integer status);

    Map<String, Object> recoverUser(Integer id, Integer status);
}
