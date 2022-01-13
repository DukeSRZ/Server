package com.ax.manager.service;

import com.ax.manager.dto.PermissionDTO;
import com.ax.manager.pojo.BaseAdminPermission;
import com.ax.manager.pojo.BaseAdminUser;
import com.ax.manager.response.PageDataResult;

import java.util.List;
import java.util.Map;

/**
 * @Title: PermissionService
 */
public interface AdminPermissionService {

    /**
     * 功能描述: 添加权限
     */
    Map<String, Object> addPermission(BaseAdminPermission permission);

    /**
     * 功能描述: 修改权限
     */
    Map<String, Object> updatePermission(BaseAdminPermission permission);

    /**
     * 功能描述: 获取权限菜单列表
     */
    PageDataResult getPermissionList(Integer pageNum, Integer pageSize);

    /**
     * 功能描述: 获取根权限菜单列表
     */
    List<PermissionDTO> parentPermissionList();

    /**
     * 功能描述: 删除权限菜单
     */
    Map<String, Object> del(long id);

    /**
     * 功能描述: 根据id获取权限
     */
    BaseAdminPermission getById(Object id);


    /**
     * 功能描述: 获取当前登陆用户的权限
     */
    Map<String, Object> getUserPerms(BaseAdminUser user);

}
