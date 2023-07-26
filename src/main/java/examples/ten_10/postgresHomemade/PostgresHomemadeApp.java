package examples.ten_10.postgresHomemade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class PostgresHomemadeApp {

    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
        try {
            connect();
            showAllStudents();
            showAllSubjects();

            //addSubjects(8, "French");
            //addStudent(11, "Petr Ivanov", 7878, 787878);
            showAllStudents();
            //setProgress(125, 1, 1, 5);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }


    private static void setProgress(int id, int student_id, int subject_id, int score) throws SQLException {
        PreparedStatement prepStatementProgresses =
                connection.prepareStatement("insert INTO ave.progress (id, student_id, subject_id, score) " +
                        "VALUES (?, ?, ?, ?)" );
        prepStatementProgresses.setInt(1, id);
        prepStatementProgresses.setInt(2, student_id);
        prepStatementProgresses.setInt(3, subject_id);
        prepStatementProgresses.setInt(4, score);
        prepStatementProgresses.executeUpdate();
    }


    private static void showAllSubjects() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM ave.subjects ORDER BY id ASC;");
        while (rs.next()) {
            System.out.println(   rs.getInt("id") + " "
                    + rs.getString("name" )  );
        }
        System.out.println();
    }


    private static void addSubjects(int id, String name) throws SQLException {
        PreparedStatement prepStatementSubjects = connection.prepareStatement("insert INTO ave.subjects (id, name) VALUES (?, ?)");
        prepStatementSubjects.setInt(1,  id )   ;
        prepStatementSubjects.setString(2, name);
        prepStatementSubjects.addBatch();
        prepStatementSubjects.executeBatch();
    }


    private static void showAllStudents() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM ave.students ORDER BY ID ASC;");
        while (rs.next()) {
            System.out.println(   rs.getInt("id") + " "
                    + rs.getString("name") + " "
                    + rs.getString("pass_series" ) + " "
                    + rs.getString("pass_number" )  );
        }
        System.out.println();
    }


    private static void addStudent(int id, String name_surname,
                                   int pass_series, int pass_number) throws SQLException {
        PreparedStatement prepStatementStudents = connection.prepareStatement("insert INTO ave.students " +
                "(id, name, pass_series, pass_number) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        prepStatementStudents.setInt(1,  id )   ;
        prepStatementStudents.setString(2, name_surname);
        prepStatementStudents.setInt(3, pass_series);
        prepStatementStudents.setInt(4, pass_number);
        prepStatementStudents.executeUpdate();
    }


    public static void connect() throws SQLException{
        try {
            Class.forName("org.postgresql.Driver");
            Properties authProperties = new Properties();
            authProperties.put("user", "postgres"); // Зададим имя пользователя БД
            authProperties.put("password", "129fghSQL"); // Зададим пароль доступа в БД

            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/avecoder_2", authProperties);
            statement = connection.createStatement();

        } catch (ClassNotFoundException|SQLException e) {
            throw new SQLException("Unable to connect");
        }
    }


    public static void disconnect() {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}


