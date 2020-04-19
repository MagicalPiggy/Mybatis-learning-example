package com.zhu.dao;

import com.zhu.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * <p>
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有用户，同时获取到用户下所有账户的信息
     * @return
     */
    @Select("select * from user")
    @Results(id="userMap",value={
            @Result(property = "wallets",column = "id",
                    many = @Many(select = "com.zhu.dao.IWalletDao.findWalletByUid",
                            fetchType = FetchType.LAZY))
    })
    List<User> findAll();


    /**
     * 根据id查询用户信息
     *
     * @param userId
     * @return
     */
    @Select("select * from user  where id=#{id} ")
    User findById(Integer userId);
}
