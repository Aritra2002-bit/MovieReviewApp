package movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateReview extends JFrame implements ActionListener {
    JTextField tfReviewID, tfMovieName, tfReviewerName, tfRating;
    JTextArea taReview;
    JButton search, update;

    public UpdateReview() {
        setLayout(null);
        setTitle("Update Review");

        JLabel lblReviewID = new JLabel("Review ID:");
        lblReviewID.setBounds(50, 50, 100, 30);
        add(lblReviewID);

        tfReviewID = new JTextField();
        tfReviewID.setBounds(200, 50, 200, 30);
        add(tfReviewID);

        search = new JButton("Search");
        search.setBounds(420, 50, 100, 30);
        search.addActionListener(this);
        add(search);

        JLabel lblMovieName = new JLabel("Movie Name:");
        lblMovieName.setBounds(50, 100, 100, 30);
        add(lblMovieName);

        tfMovieName = new JTextField();
        tfMovieName.setBounds(200, 100, 200, 30);
        add(tfMovieName);

        JLabel lblReviewerName = new JLabel("Reviewer Name:");
        lblReviewerName.setBounds(50, 150, 120, 30);
        add(lblReviewerName);

        tfReviewerName = new JTextField();
        tfReviewerName.setBounds(200, 150, 200, 30);
        add(tfReviewerName);

        JLabel lblRating = new JLabel("Rating:");
        lblRating.setBounds(50, 200, 100, 30);
        add(lblRating);

        tfRating = new JTextField();
        tfRating.setBounds(200, 200, 200, 30);
        add(tfRating);

        JLabel lblReview = new JLabel("Review:");
        lblReview.setBounds(50, 250, 100, 30);
        add(lblReview);

        taReview = new JTextArea();
        taReview.setBounds(200, 250, 200, 100);
        add(taReview);

        update = new JButton("Update");
        update.setBounds(150, 400, 100, 30);
        update.addActionListener(this);
        add(update);

        setSize(600, 500);
        setLocation(500, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String reviewID = tfReviewID.getText();

            try {
                Connectivity conn = new Connectivity();
                String query = "SELECT * FROM reviews WHERE review_id = '"+tfReviewID.getText()+"'";
                //PreparedStatement pstmt = conn.c.prepareStatement(query);
                //pstmt.setString(1, reviewID);
                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    tfMovieName.setText(rs.getString("movie_name"));
                    tfReviewerName.setText(rs.getString("reviewer_name"));
                    tfRating.setText(rs.getString("rating"));
                    taReview.setText(rs.getString("review"));                } 
                else {
                    JOptionPane.showMessageDialog(null, "Review not found");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            String reviewID = tfReviewID.getText();
            String movieName = tfMovieName.getText();
            String reviewerName = tfReviewerName.getText();
            String rating = tfRating.getText();
            String review = taReview.getText();

            try {
                Connectivity conn = new Connectivity();
                String query = "UPDATE reviews SET movie_name = '"+movieName+"', reviewer_name = '"+reviewerName+"', rating = '"+rating+"', review = '"+review+"' WHERE review_id = '"+reviewID+"'";
//                PreparedStatement pstmt = conn.c.prepareStatement(query);
//                pstmt.setString(1, movieName);
//                pstmt.setString(2, reviewerName);
//                pstmt.setString(3, rating);
//                pstmt.setString(4, review);
//                pstmt.setString(5, reviewID);
//                pstmt.executeUpdate();
               conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Review Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
//    public void actionPerformed(ActionEvent ae) {
//    if (ae.getSource() == search) {
//        String reviewID = tfReviewID.getText();
//
//        try {
//            Connectivity conn = new Connectivity();
//            String query = "SELECT * FROM reviews WHERE review_id = '" + tfReviewID + "'";
//            ResultSet rs = conn.s.executeQuery(query);
//
//            if (rs.next()) {
//                tfMovieName.setText(rs.getString("movie_name"));
//                tfReviewerName.setText(rs.getString("reviewer_name"));
//                tfRating.setText(rs.getString("rating"));
//                taReview.setText(rs.getString("review"));
//            } else {
//                JOptionPane.showMessageDialog(null, "Review not found");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    } else if (ae.getSource() == update) {
//        String reviewID = tfReviewID.getText();
//        String movieName = tfMovieName.getText();
//        String reviewerName = tfReviewerName.getText();
//        String rating = tfRating.getText();
//        String review = taReview.getText();
//
//        try {
//            Connectivity conn = new Connectivity();
//            String query = "UPDATE reviews SET movie_name = '" + movieName + "', "
//                         + "reviewer_name = '" + reviewerName + "', "
//                         + "rating = '" + rating + "', "
//                         + "review = '" + review + "' "
//                         + "WHERE review_id = '" + reviewID + "'";
//
//            conn.s.executeUpdate(query);
//            JOptionPane.showMessageDialog(null, "Review Updated Successfully");
//            setVisible(false);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}


    public static void main(String[] args) {
        new UpdateReview();
    }
}
