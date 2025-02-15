package movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField tfUsername;
    JPasswordField pfPassword;
    JButton btnLogin, btnCancel,close;

    public Login() {
        setLayout(null);
        setTitle("Login");

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(20, 20, 100, 20);
        add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(130, 20, 200, 20);
        add(tfUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(20, 60, 100, 20);
        add(lblPassword);

        pfPassword = new JPasswordField();
        pfPassword.setBounds(130, 60, 200, 20);
        add(pfPassword);
        
        

        btnLogin = new JButton("Login");
        btnLogin.setBounds(40, 120, 120, 20);
        btnLogin.addActionListener(this);
        add(btnLogin);

        btnCancel = new JButton("Reset");
        btnCancel.setBounds(190, 120, 120, 20);
        btnCancel.addActionListener(this);
        add(btnCancel);
        
        close = new JButton("Close");
        close.setBounds(120, 160, 120, 20);
        close.addActionListener(this);
        add(close);

        setSize(400, 250);
        setLocation(500, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnLogin) {
           String username = tfUsername.getText();
           String password = new String(pfPassword.getPassword());

           try {
                Connectivity c = new Connectivity();
                 String query = "SELECT * FROM users WHERE username = '"+username+"' AND password ='"+password+"' ";
                //PreparedStatement pstmt = c.conn.prepareStatement(query);
                //pstmt.setString(1, username);
               // pstmt.setString(2, password);
                  ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    new Home(); // Assuming Home is your main application window
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == close) {
            System.exit(0);
        }
        else if (ae.getSource() == btnCancel) {
            tfUsername.setText("");
            pfPassword.setText("");
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
