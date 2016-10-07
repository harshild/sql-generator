package com.harshild.parser;

import com.harshild.fluent.sql.SQL;

/**
 * Created by harshild on 10/7/2016.
 */
public interface Parser {
    SQL parse(String statement);
}
