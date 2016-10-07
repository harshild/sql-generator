package com.harshild.fluent;

import static com.harshild.fluent.sql.SQL.Statics.*;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TestSQLFieldsComma {
	
	@Test
	public void testFieldsAutoComma() {
		String expected = "" +
				" SELECT Customers.CustomerName , Orders.OrderID "+
				" FROM Customers ";
		
		String actual = SELECT()
					.FIELD("Customers.CustomerName")
					.FIELD("Orders.OrderID")
					.FROM("Customers").build().getSql();
		
		CTest.cassertEquals(expected, actual);
	}
	
	
	@Test
	public void testFieldsAutoCommaGroupBy() {
		String expected = "" +
				" SELECT Customers.CustomerName , Orders.OrderID "+
				" FROM Customers "
				+ " GROUP BY CustomerName , Date";
		
		String actual = SELECT()
					.FIELD("Customers.CustomerName")
					.FIELD("Orders.OrderID")
					.FROM("Customers")
					.GROUP_BY("CustomerName", "Date")
					.build().getSql();
		
		CTest.cassertEquals(expected, actual);
	}

}
