package examples.nine_9.sql;

import java.sql.*;
import java.util.Properties;

public class SimpleSQLConnection {

    static String url;
    static Properties authorization;

    static {
        try {
            java.sql.DriverManager.registerDriver(new org.postgresql.Driver());

            authorization = new Properties();
            authorization.put("user", "postgres");
            authorization.put("password", "129fghSQL");
            url = "jdbc:postgresql://localhost:5432/avecoder_2";

        } catch (SQLException e) {
            throw new RuntimeException("Can't register driver!");
        }
    }

    public static void main(String[] args) {
        //Class.forName("org.postgresql.Driver");
        try(
                Connection connection = DriverManager.getConnection(url, authorization);
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                                 ResultSet.CONCUR_UPDATABLE);
                ResultSet table = statement.executeQuery("SELECT * FROM ave.books");             ) {

            // Выведем имена полей
            table.first();
            int length = table.getMetaData().getColumnCount();
            for (int j = 1; j <= length; j++) {
                String colName = table.getMetaData().getColumnName(j);
                System.out.print( colName + "\t\t\t" );
            }
            System.out.println("\n" + "-----------------------------------");

            // Значение колонок
            table.beforeFirst();
            while (table.next()) {
                for (int j = 1; j <= length; j++) {
                    String entry = table.getString(j);
                    System.out.print( entry + "\t\t\t" );
                }
                System.out.println("\n" + "-----------------------------------");
            }


            // Тип данных колонок
            for (int j = 1; j <= length; j++) {
                String columnTypeName = table.getMetaData().getColumnTypeName(j);
                System.out.print( columnTypeName + "\t\t\t" );
            }
            System.out.println("\n" + "-----------------------------------");


            // Размер данных колонок
            for (int j = 1; j <= length; j++) {
                int columnTypeName = table.getMetaData().getPrecision(j);
                System.out.print( columnTypeName + "\t\t\t" );
            }
            System.out.println("\n" + "-----------------------------------");


        } catch (Exception e) {
            System.err.println("Error accessing database!");
            e.printStackTrace();
        }
    }

}

