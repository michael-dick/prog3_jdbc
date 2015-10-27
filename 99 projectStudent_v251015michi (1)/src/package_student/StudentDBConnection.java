package package_student;

import java.sql.*;

public class StudentDBConnection implements DBConnection<Integer, Student> {

    Connection connection;

    Statement mStatement;

    PreparedStatement mPreparedStatement;


    @Override
    public void connect() {
        //load jdbc driver
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("driver loaded");
        } catch (Exception ex) {
            System.out.println("Driver: " + ex.getMessage());
            System.out.println("Error: " + ex.toString());
        }

        //Connection
        try {
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost/student", "root", "");
            //ein JDBC- URL übergeben
            mStatement = connection.createStatement();
            System.out.println("connection established");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("Error: " + ex.getErrorCode());
        }
    }

    @Override
    public void disconnect() {
        try {
            mStatement.close();
            connection.close();
            System.out.println("disconnected");
        } catch (SQLException err) {
            System.err.println(err);
        }
    }

    @Override
    public void persist(Student entity) {
        connect();

        try {
            mPreparedStatement = connection.prepareStatement("INSERT INTO student (matnr, firstname, lastname, email) VALUES (?,?,?,?)");
            mPreparedStatement.setInt(1, entity.getMatnr());
            mPreparedStatement.setString(2, entity.getFirstname());
            mPreparedStatement.setString(3, entity.getLastname());
            mPreparedStatement.setString(4, entity.getEmail());

            mPreparedStatement.executeUpdate();
        } catch (SQLException err) {
            System.err.print(err);
        }

        disconnect();
    }

    @Override
    public void update(Integer identifier, Student mock) {
        //MATRIKELNR stays alwas the same, since this attribute is the primary key
        String newFirstName = mock.getFirstname();
        String newLastName = mock.getLastname();
        String newEMail = mock.getEmail();

        connect();
        try {
            mPreparedStatement = connection.prepareStatement("UPDATE student SET firstname = ?, lastname = ?, email = ? WHERE matnr = ?");
            mPreparedStatement.setString(1, newFirstName);
            mPreparedStatement.setString(2, newLastName);
            mPreparedStatement.setString(3, newEMail);
            mPreparedStatement.setInt(4, identifier);

            mPreparedStatement.executeUpdate();

        } catch (SQLException err) {
            System.err.print(err);
        }


        disconnect();
    }

    @Override
    public void delete(Integer identifier) {
        connect();

        try {
            mPreparedStatement = connection.prepareStatement("DELETE FROM student WHERE matnr = ?");
            mPreparedStatement.setInt(1, identifier);

            mPreparedStatement.executeUpdate();

        } catch (SQLException err) {
            System.err.print(err);
        }

        disconnect();
    }
}
