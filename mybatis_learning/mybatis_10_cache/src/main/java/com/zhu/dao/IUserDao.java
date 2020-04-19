package com.zhu.dao;

import com.zhu.domain.User;

import java.util.List;

/**
 * <p>
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有用户，同时获取到用户所属的所有角色信息
     * @return
     */
    List<User> findAll();


    /**
     * 根据id查询用户信息
     *
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);
}
