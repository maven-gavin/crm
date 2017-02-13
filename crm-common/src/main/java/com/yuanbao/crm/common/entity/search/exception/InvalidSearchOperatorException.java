package com.yuanbao.crm.common.entity.search.exception;

import com.yuanbao.crm.common.entity.search.SearchOperator;

/**
 * Created by gewen on 2017/1/16.
 */
public final class InvalidSearchOperatorException extends SearchException {
    public InvalidSearchOperatorException(String searchProperty, String operatorStr) {
        this(searchProperty, operatorStr, null);
    }

    public InvalidSearchOperatorException(String searchProperty, String operatorStr, Throwable cause) {
        super("Invalid Search Operator searchProperty [" + searchProperty + "], " +
                "operator [" + operatorStr + "], must be one of " + SearchOperator.toStringAllOperator(), cause);
    }
}
