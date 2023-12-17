import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException {
       
        String url = "jdbc:mysql://localhost:3306/friends";
        String user = "root";
        String password = "viswanathan@38";
        try {Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM members");

            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("age"));
                System.out.println(rs.getDouble("GPA"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
