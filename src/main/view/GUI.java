package src.main.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// https://www.w3schools.com/java/java_hashset.asp
// https://www.geeksforgeeks.org/set-in-java/
public class GUI extends JFrame {

    public void startApp() {
        welcomeScreen(); // Calling WelcomeScreen method
        setVisible(true); // Making the frame visible
    }

    public void welcomeScreen() {
        setTitle("Ellis Technologies");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame on the screen
        // Create components
        JLabel welcometitleLabel = new JLabel("Adding Services Automation", SwingConstants.CENTER);
        welcometitleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JButton loginButton = new JButton("Login");
        JButton quitButton = new JButton("Quit");

        // Create text fields for username and password
        JTextField usernameField = new JTextField();
        JTextField passwordField = new JTextField();

        // Set preferred size for text fields
        usernameField.setPreferredSize(new Dimension(200, 25));
        passwordField.setPreferredSize(new Dimension(200, 25));

        // Create panel and add components
        JPanel welcomepanel = new JPanel(new BorderLayout());
        welcomepanel.add(welcometitleLabel, BorderLayout.NORTH);

        // Panel for login fields
        // GridBagLayout for more precise control
        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 10);

        loginPanel.add(new JLabel("Username: "), gbc);
        gbc.gridy++;
        loginPanel.add(usernameField, gbc);
        gbc.gridy++;
        loginPanel.add(new JLabel("Password: "), gbc);
        gbc.gridy++;
        loginPanel.add(passwordField, gbc);

        welcomepanel.add(loginPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(loginButton);
        buttonPanel.add(quitButton);
        welcomepanel.add(buttonPanel, BorderLayout.SOUTH);
        // Add panel to the frame
        add(welcomepanel);
        // Action listeners for buttons
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(welcomepanel);
                // Code to handle continue button click
                // Call method ticket type
                ticketType();
            }
        });
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to handle quit button click
                System.exit(0);
            }
        });

    }

    public void ticketType() {
        setTitle("Ellis's Adding Services Automation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame on the screen

        JLabel tickettitleLabel = new JLabel("Ticket Type and Services:", SwingConstants.CENTER);
        tickettitleLabel.setFont(new Font("Arial", Font.BOLD, 36));

        // Create a choice box with options
        Choice choiceBox = new Choice();
        choiceBox.add("New Bulk");
        choiceBox.add("Renewal");
        choiceBox.add("Debulk");
        choiceBox.add("Termination");

        // Create text fields for ticket number, sub-memo, bulk master, and short decription
        JTextField ticketNumberField = new JTextField(10);
        JTextField subMemoField = new JTextField(10);
        JTextField shortDescriptionField = new JTextField(10);
        JTextField bulkMasterField = new JTextField(10);



        // Create panel and add components
        JPanel tickettypepanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Adding the label and choice box
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        // Allow the label to expand horizontally
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        tickettypepanel.add(tickettitleLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        tickettypepanel.add(choiceBox, gbc);

        // Adding the labels and text fields
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        tickettypepanel.add(new JLabel("Bulk Master #:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        tickettypepanel.add(bulkMasterField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        tickettypepanel.add(new JLabel("Ticket Number:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        tickettypepanel.add(ticketNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        tickettypepanel.add(new JLabel("Sub-Memo:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        tickettypepanel.add(subMemoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        tickettypepanel.add(new JLabel("Short description:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        tickettypepanel.add(shortDescriptionField, gbc);
// Create buttons
        JButton ticketTypeContinueButton = new JButton("Continue");
        JButton ticketTypeQuitButton = new JButton("Quit");

// Create button panel and add buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(ticketTypeContinueButton);
        buttonPanel.add(ticketTypeQuitButton);


// Add button panel to the main panel
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER; // Center the buttons horizontally
        tickettypepanel.add(buttonPanel, gbc);

        buttonPanel.add(ticketTypeContinueButton);
        buttonPanel.add(ticketTypeQuitButton);
        ticketTypeContinueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to handle continue button click
                // Call method ticket type
                ticketType();
            }
        });
        ticketTypeQuitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to handle quit button click
                System.exit(0);
            }
        });
        // Add panel to the frame
        add(tickettypepanel);
    }
    }