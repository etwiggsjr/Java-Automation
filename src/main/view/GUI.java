package src.main.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// https://www.w3schools.com/java/java_hashset.asp
// https://www.geeksforgeeks.org/set-in-java/
public class GUI extends JFrame {

public void startApp() {
        WelcomeScreen();
    }

    public void WelcomeScreen() {
        setTitle("Welcome to Ellis Tech");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame on the screen
        
        // Create components
        JLabel titleLabel = new JLabel("Ellis Tech", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
        JLabel subtitleLabel = new JLabel("Ellis Automation", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        
        JButton continueButton = new JButton("Continue");
        continueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to handle continue button click
                // For example, open a new window or perform some action
                JOptionPane.showMessageDialog(null, "Continue button clicked");
            }
        });
        
        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to handle quit button click
                // For example, exit the application
                System.exit(0);
            }
        });
        
        // Create panel and add components
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(subtitleLabel, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(continueButton);
        buttonPanel.add(quitButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Add panel to the frame
        add(panel);
    }

}