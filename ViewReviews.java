package movie;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewReviews extends JFrame {
    public ViewReviews() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JTable table = new JTable();

        try {
            Connectivity conn = new Connectivity();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM reviews");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 0, 800, 500);
        add(jsp);

        setSize(800, 500);
        setLocation(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ViewReviews();
    }
}
