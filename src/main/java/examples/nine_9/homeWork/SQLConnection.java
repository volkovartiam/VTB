package examples.nine_9.homeWork;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.Properties;

public class SQLConnection {

    static String url;
    static Properties authorization;

    static {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());

            authorization = new Properties();
            authorization.put("user", "postgres");
            authorization.put("password", "129fghSQL");
            url = "jdbc:postgresql://localhost:5432/avecoder_2";

        } catch (SQLException e) {
            throw new RuntimeException("Can't register driver!");
        }
    }

    public static void main(String[] args) {

        Author author = new Author("Artem", "Volkov");
        Class claz = author.getClass();
        StringBuilder sb = new StringBuilder();

        if(claz.isAnnotationPresent(Table.class)){
            Table tableAnn = (Table)claz.getAnnotation(Table.class);
            String tableName = tableAnn.title();
            String schema = "ave.";

            sb.append("CREATE TABLE IF NOT EXISTS ");
            sb.append(schema + tableName  + "( \n");

            for (Field filed : claz.getDeclaredFields() ) {
                if(filed.isAnnotationPresent(Column.class )) {
                 sb.append(filed.getName() + " VARCHAR(50), " );
                }
            }
            sb.replace(sb.length() - 2, sb.length(), ");\n");
            System.out.println(sb);

        }

        try(
                Connection connection = DriverManager.getConnection(url, authorization);
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                                 ResultSet.CONCUR_UPDATABLE);
                ResultSet table = statement.executeQuery(sb.toString());                        ) {

            /*
            table.first();
            for (int i=0; i<table.getMetaData().getColumnCount(); i++){
                System.out.println(table.getMetaData().getColumnName(i));
            }*/

        } catch (Exception e) {
            System.err.println("Error accessing database!");
            e.printStackTrace();
        }
    }

}

