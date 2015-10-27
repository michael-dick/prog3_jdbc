package package_student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by MichaelDick on 25/10/15.
 */
public class StudentDBRun {

    public static void main(String[] args){

        StudentDBConnection connection = new StudentDBConnection();

        connection.connect();

        Statement stmt = connection.mStatement;

        //TEST SELECT
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM student WHERE matnr = '1641518';");

            rs.next();
            System.out.println(rs.getInt("matnr"));
            System.out.println(rs.getString("email"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.disconnect();

        //TEST PERSIST

        Student mock = new Student(12345678 , "fu" , "bar" , "fubar@kit.edu");
        connection.persist(mock);



    }
}
