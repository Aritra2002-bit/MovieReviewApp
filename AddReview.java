package movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddReview extends JFrame implements ActionListener {
    JTextField tfMovieName, tfReviewerName, tfRating;
    JTextArea taReview;
    JButton submit, reset;

    public AddReview() {
        setLayout(null);
        setTitle("Add Review");

        JLabel lblMovieName = new JLabel("Movie Name:");
        lblMovieName.setBounds(50, 50, 100, 30);
        add(lblMovieName);

        tfMovieName = new JTextField();
        tfMovieName.setBounds(200, 50, 200, 30);
        add(tfMovieName);

        JLabel lblReviewerName = new JLabel("Reviewer Name:");
        lblReviewerName.setBounds(50, 100, 120, 30);
        add(lblReviewerName);

        tfReviewerName = new JTextField();
        tfReviewerName.setBounds(200, 100, 200, 30);
        add(tfReviewerName);

        JLabel lblRating = new JLabel("Rating:");
        lblRating.setBounds(50, 150, 100, 30);
        add(lblRating);

        tfRating = new JTextField();
        tfRating.setBounds(200, 150, 200, 30);
        add(tfRating);

        JLabel lblReview = new JLabel("Review:");
        lblReview.setBounds(50, 200, 100, 30);
        add(lblReview);

        taReview = new JTextArea();
        taReview.setBounds(200, 200, 200, 100);
        add(taReview);

        submit = new JButton("Submit");
        submit.setBounds(100, 350, 100, 30);
        submit.addActionListener(this);
        add(submit);

        reset = new JButton("Reset");
        reset.setBounds(250, 350, 100, 30);
        reset.addActionListener(this);
        add(reset);

        setSize(500, 500);
        setLocation(500, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String movieName = tfMovieName.getText();
            String reviewerName = tfReviewerName.getText();
            String rating = tfRating.getText();
            String review = taReview.getText();

            try {
                Connectivity conn = new Connectivity();
                String query = "INSERT INTO reviews (movie_name, reviewer_name, rating, review) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = conn.c.prepareStatement(query);
                pstmt.setString(1, movieName);
                pstmt.setString(2, reviewerName);
                pstmt.setString(3, rating);
                pstmt.setString(4, review);
                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Review Added Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == reset) {
            tfMovieName.setText("");
            tfReviewerName.setText("");
            tfRating.setText("");
            taReview.setText("");
        }
    }

    public static void main(String[] args) {
        new AddReview();
    }
}
