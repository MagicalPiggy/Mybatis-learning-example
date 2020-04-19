package com.zhu.dao;

import com.zhu.domain.Role;

import java.util.List;

/**
 * 操作Role表的接口
 */
public interface IRoleDao {

    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();
}
