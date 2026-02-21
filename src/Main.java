import java.sql.*;
public class Main {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/school";
    private static final String user ="root";
    private static final String password ="root";
    public static void main(String[] args) {
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("run perfecrly");
    }
    catch(ClassNotFoundException e){
        System.out.println(e.getMessage());
    }
    try {
        Connection connection = DriverManager.getConnection(url, user,password);
        Statement statement = connection.createStatement();
         String str = "SELECT * FROM student";
         ResultSet result = statement.executeQuery(str);

         //loop to print

        while(result.next()){
            int id = result.getInt("id");
            String name = result.getString("name");
            int age = result.getInt("age");
            float marks = result.getFloat("marks");
            System.out.println("id of the student: " + id + ", name : " + name + ", age : " + age + ", marks : " + marks);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

    }
}