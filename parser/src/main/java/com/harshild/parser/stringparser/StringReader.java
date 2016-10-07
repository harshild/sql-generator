package com.harshild.parser.stringparser;

import com.harshild.fluent.sql.SQL;
import com.harshild.parser.Parser;
/**
 * Created by harshild on 10/7/2016.
 */
public class StringReader implements Parser {
    @Override
    public SQL parse(String statement) {
        return new SQL();
    }
}
