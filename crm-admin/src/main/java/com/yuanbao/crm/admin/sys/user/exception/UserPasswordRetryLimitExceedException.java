package com.yuanbao.crm.admin.sys.user.exception;

/**
 * Created by gewen on 2017/1/21.
 */
public class UserPasswordRetryLimitExceedException extends UserException {
    public UserPasswordRetryLimitExceedException(int retryLimitCount) {
        super("user.password.retry.limit.exceed", new Object[]{retryLimitCount});
    }
}