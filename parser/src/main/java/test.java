import com.harshild.fluent.sql.Breakdown;
import com.harshild.fluent.sql.SQL;

import static com.harshild.fluent.sql.SQL.Statics.*;

/**
 * Created by harshild on 10/7/2016.
 */
public class test {
    public static void main(String[] args) {
        SQL sql = WITH("LatestOrders" ,
                SELECT("CustomerName")
                        .FN(SUM(COUNT("ID")))
                        .FN(COUNT(MAX("n_items")))
                        .FIELD("Red").AS("color")
                        .FROM("dbo.Orders")
                        .RIGHT_JOIN("Customers")
                        .ON("Orders.customer_ID" , "Customers.ID")
                        .LEFT_JOIN("Persons")
                        .ON("Persons.name" , "Customer.name")
                        .AND_ON("Persons.lastName" , "Customer.lastName")
                        .GROUP_BY("CustomerID")
        ).append(SELECT()
                .FIELD("Customers.*")
                .FIELD("Orders.OrderTime").AS("LatestOrderTime")
                .FIELD(SELECT(COUNT("*"))
                        .FROM("dbo.OrderItems")
                        .WHERE("OrderID").IN(
                                SELECT("ID")
                                        .FROM("dbo.Orders")
                                        .WHERE("CustomerID").EQUAL_TO_FIELD("Customers.ID"))

                ).AS("TotalItemsPurchased")
                .FROM("dbo.Customers")
                .INNER_JOIN("dbo.Orders")
                .USING("ID")
                .WHERE("Orders.ID").IN(SELECT("ID").FROM("LatestOrders"))
                .AND("Orders.n_items").GREATER_THAN(0)
        );

        Breakdown actual = sql.build();

        System.out.println(actual.getSql());
    }
}
