package com.harshild.parser.stringparser;

import com.harshild.fluent.sql.SQL;
import com.harshild.parser.Parser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by harshild on 10/7/2016.
 */
public class StringReaderTest {
    Parser stringParser;

    @Before
    public void setUp() throws Exception {
        stringParser = new StringReader();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void itShouldParseBlankText() throws Exception {
        SQL parsed = stringParser.parse("");

        String actual = parsed.build().getSql().toLowerCase();
        String expected = "";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void itShouldParseStringToIdentifySelectStatement(){
        SQL parsed = stringParser.parse("");

        String actual = parsed.build().getSql().toLowerCase();
        String expected = "SELECT * FROM TABLE";
        Assert.assertEquals(actual, expected);


    }

}