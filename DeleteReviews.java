package movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteReviews extends JFrame implements ActionListener {
    JTextField tfReviewID;
    JButton delete;

    public DeleteReviews() {
        setLayout(null);
        setTitle("Delete Review");

        JLabel lblReviewID = new JLabel("Review ID:");
        lblReviewID.setBounds(50, 50, 100, 30);
        add(lblReviewID);

        tfReviewID = new JTextField();
        tfReviewID.setBounds(200, 50, 200, 30);
        add(tfReviewID);

        delete = new JButton("Delete");
        delete.setBounds(150, 100, 100, 30);
        delete.addActionListener(this);
        add(delete);

        setSize(500, 200);
        setLocation(500, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            String reviewID = tfReviewID.getText();

            try {
                Connectivity conn = new Connectivity();
                String query = "DELETE FROM reviews WHERE review_id = ?";
                PreparedStatement pstmt = conn.c.prepareStatement(query);
                pstmt.setString(1, reviewID);
                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Review Deleted Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Review not found");
                }
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new DeleteReviews();
    }
}
