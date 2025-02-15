package movie;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    public Home() {
        setLayout(null);

        ImageIcon i1 = new ImageIcon("C:\\Users\\aritr\\OneDrive\\Documents\\NetBeansProjects\\Movie\\src\\movie\\icons\\home1.jpg");

        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1600, 800);
        add(image);
        
        JLabel heading = new JLabel("WELCOME TO MOVIE REVIEW APP");
        heading.setBounds(500, 40, 1000, 490);
        heading.setForeground(Color.white);
        heading.setFont(new Font("TAHOMA", Font.BOLD, 36));
        image.add(heading);
        
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details = new JMenu("Details");
        menubar.add(details);
        
        JMenuItem topratedMovies = new JMenuItem("Top Rated Movies");
        topratedMovies.addActionListener(this);
        details.add(topratedMovies);
        
        JMenuItem addReview = new JMenuItem("Add Review");
        addReview.addActionListener(this);
        details.add(addReview);
        
        JMenuItem viewReviews = new JMenuItem("View Reviews");
        viewReviews.addActionListener(this);
        details.add(viewReviews);
        
        JMenuItem updateReviews = new JMenuItem("Update Reviews");
        updateReviews.addActionListener(this);
        details.add(updateReviews);
        
        JMenuItem deleteReviews = new JMenuItem("Delete Reviews");
        deleteReviews.addActionListener(this);
        details.add(deleteReviews);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();
        
        if (text.equals("Top Rated Movies")) {
            new TopRatedMovies(); // Assuming this is a class to be defined
        } 
        
        else if (text.equals("Add Review")) {
            new AddReview(); // Assuming this is a class to be defined
        }
        else if (text.equals("View Reviews")) {
            new ViewReviews(); // Assuming this is a class to be defined
         }
        else if (text.equals("Update Reviews")) {
            new UpdateReview(); // Assuming this is a class to be defined
        }
        else if (text.equals("Delete Reviews")) {
            new DeleteReviews(); // Assuming this is a class to be defined
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
