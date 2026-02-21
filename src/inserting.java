import java.sql.SQLException;
import java.sql.Statement;

public class inserting {
   public int insert(Statement s, int id , String name , int age , float marks){
       try {
           String str = String.format("INSERT INTO student(id,name,age,marks) VALUES(%o,'%s',%o,%f)", id, name, age, marks);
           return s.executeUpdate(str);
       }
       catch (SQLException e){
           System.out.println(e.getMessage());
       }
       return 0;
   }


}
