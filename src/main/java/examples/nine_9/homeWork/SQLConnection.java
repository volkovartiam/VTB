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
            url = "jdbc:postgresql://localhost:5432/avecoder";

        } catch (SQLException e) {
            throw new RuntimeException("Can't register driver!");
        }
    }

    public static void main(String[] args) {

        Author author = new Author("Artem", "Volkov");
        Author author_2 = new Author("Artem_2", "Volkov_2");
        Class claz = author.getClass();
        StringBuilder sb = new StringBuilder();

        if(claz.isAnnotationPresent(Table.class)){
            Table tableAnn = (Table)claz.getAnnotation(Table.class);
            String tableName = tableAnn.title();
            System.out.println(tableName);

            String schema = "ave.";

            sb.append("CREATE TABLE IF NOT EXISTS ");
            sb.append(schema + tableName  + "( \n");

            for (Field filed : claz.getDeclaredFields() ) {
                if(filed.isAnnotationPresent(Column.class )) {
                 sb.append(filed.getName() + " VARCHAR(50), " );
                }
            }
            sb.replace(sb.length() - 2, sb.length(), ");\n");

            sb.append("INSERT INTO " + schema + tableName + " VALUES");
            sb.append("('" + author.getName() + "',");
            sb.append("'" + author.getSurName() + "');\n");

            sb.append("INSERT INTO " + schema + tableName + " VALUES");
            sb.append("('" + author_2.getName() + "',");
            sb.append("'" + author_2.getSurName() + "');\n");

            System.out.println(sb);
        }

        try(
            Connection connection = DriverManager.getConnection(url, authorization);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                             ResultSet.CONCUR_UPDATABLE);

                                                                                              ) {
            statement.execute(sb.toString());
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ave.authors;");
            //resultSet.first();
            for (int i=1; i <= resultSet.getMetaData().getColumnCount(); i++){
                System.out.print(resultSet.getMetaData().getColumnName(i) + " ");
            }
            System.out.println();
            while(resultSet.next()){
                String name = resultSet.getString(1);
                String surname = resultSet.getString(2);
                System.out.printf("%s %s\n", name, surname);
            }

        } catch (Exception e) {
            System.err.println("Error accessing database!");
            e.printStackTrace();
        }
    }

}
