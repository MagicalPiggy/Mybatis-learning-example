package com.zhu.dao;

import com.zhu.domain.Wallet;

import java.util.List;

public interface IWalletDao {

    /**
     * 查询所有钱包，同时还要获取到当前钱包的所属用户信息
     * @return
     */
    List<Wallet> findAll();

    /**
     * 根据用户id查询钱包信息
     * @param uid
     * @return
     */
    List<Wallet> findWalletByUid(Integer uid);
}
