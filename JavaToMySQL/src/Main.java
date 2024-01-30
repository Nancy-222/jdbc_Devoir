import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String username = "root";
        String password = "1@3$5^";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established");
            Statement statement = connection.createStatement();

            // Queries
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next()) {
                String nom = resultSet.getString("nom");
                int age = resultSet.getInt("age");
                System.out.println( nom + " a " + age + " ans" );
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}