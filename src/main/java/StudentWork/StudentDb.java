package StudentWork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

public class StudentDb {

    private DataSource dataSource;

    public StudentDb(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // إضافة طالب جديد
    public void addStudent(Student theStudent) throws SQLException {
        Connection myConn = null;
        PreparedStatement myStmt = null;
        try {
            myConn = dataSource.getConnection();
            String sql = "INSERT INTO student (first_name, last_name, email) VALUES (?, ?, ?)";
            myStmt = myConn.prepareStatement(sql);

            // تعيين القيم
            myStmt.setString(1, theStudent.getFirstName());
            myStmt.setString(2, theStudent.getLastName());
            myStmt.setString(3, theStudent.getEmail());

            // تنفيذ الاستعلام
            myStmt.execute();
        } finally {
            // إغلاق الموارد
            close(myConn , myStmt);
        }
    }

    // إغلاق الاتصال والمصادر
    private void close(Connection myConn, Statement myStmt) {
        try {
           
            if (myStmt != null) {
                myStmt.close();
            }
            if (myConn != null) {
                myConn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}