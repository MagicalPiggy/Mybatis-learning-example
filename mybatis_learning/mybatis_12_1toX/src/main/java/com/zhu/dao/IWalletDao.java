package com.zhu.dao;

import com.zhu.domain.Wallet;
import com.zhu.domain.WalletUser;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IWalletDao {

    /**
     * 查询所有钱包，同时还要获取到当前钱包的所属用户信息
     * @return
     */
    @Select("select * from wallet")
    @Results(id="walletMap",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(property = "user",column = "uid",one=@One(select="com.zhu.dao.IUserDao.findById",fetchType= FetchType.EAGER))
    })
    List<Wallet> findAll();

    /**
     * 根据用户id查询钱包信息
     * @return
     */
    @Select("select * from wallet where uid = #{Uid}")
    List<WalletUser> findWalletByUid();
}
