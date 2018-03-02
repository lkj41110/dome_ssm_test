package com.lk.dome.service;

/**
 * @author luokai
 * @date 2018/1/8
 */
public interface TransactionalService {

    int test1(boolean hasException);

    int test2(boolean hasException) throws Exception;

    int test3(boolean hasException) throws Exception;

    int test4(boolean hasException);

    int test5(boolean hasException);
}
