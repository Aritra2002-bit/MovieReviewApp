package movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connectivity {
    Connection c;
    Statement s;

    public Connectivity() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/movieDB", "root", "Aritra@2002");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
