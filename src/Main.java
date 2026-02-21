import java.sql.*;
import java.util.Scanner;

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


         inserting in = new inserting();
        int more =1;
        Scanner obj = new Scanner(System.in);
        do {
            System.out.println("enter id");
            int id= obj.nextInt();
            obj.nextLine();
            System.out.println("enter name ");
            String name = obj.nextLine();
            System.out.println("enter age ");
            int age = obj.nextInt();
            System.out.println("enetr the marks");
            float marks = obj.nextFloat();
            if(in.insert(statement,id,name,age,marks)>0){
                System.out.println("data entered successfully");
            }
            else {
                System.out.println("data not enterd ");
            }
            System.out.println("do you want to enter more data : press 1 , else any button");
             more = obj.nextInt();
        }while(more ==1);

         //loop to print
        String str = "SELECT * FROM student";
        System.out.println("do you wish to see your data press 1 ");
        ResultSet result = statement.executeQuery(str);
        int wish = obj.nextInt();
        if (wish==1) {
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                int age = result.getInt("age");
                float marks = result.getFloat("marks");
                System.out.println("id of the student: " + id + ", name : " + name + ", age : " + age + ", marks : " + marks);
            }
        }
        System.out.println("have a nice day");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

    }
}