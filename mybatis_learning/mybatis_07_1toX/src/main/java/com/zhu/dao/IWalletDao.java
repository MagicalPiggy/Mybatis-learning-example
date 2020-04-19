package com.zhu.dao;

import com.zhu.domain.Wallet;
import com.zhu.domain.WalletUser;

import java.util.List;

public interface IWalletDao {

    /**
     * 查询所有钱包，同时还要获取到当前钱包的所属用户信息
     * @return
     */
    List<Wallet> findAll();

    /**
     * 查询所有钱包，并且带有用户名称和地址信息
     * @return
     */
    List<WalletUser> findAllWallet();
}
