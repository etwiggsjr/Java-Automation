package src.main.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Sources I used to help
// https://www.w3schools.com/java/java_hashset.asp
// https://www.geeksforgeeks.org/set-in-java/
//https://youtu.be/dFOIoX3fXpQ?feature=shared

public class GUI extends JFrame {

    public void startApp() {
        welcomeScreen(); // Calling WelcomeScreen method
        setVisible(true); // Making the frame visible
    }

    public void welcomeScreen() {
        setTitle("Ellis Technologies");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380, 400); // Increased height to accommodate the logo

        setLocationRelativeTo(null); // Center the frame on the screen
        // Create components
        JLabel welcomeTitleLabel = new JLabel("Adding Services Automation", SwingConstants.CENTER);
        welcomeTitleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        // Set title label text color to black
        welcomeTitleLabel.setForeground(Color.BLACK);

        // Load and resize the logo
        ImageIcon logoIcon = new ImageIcon("src/main/view/Adding Services Automation Logo.png");
        Image logoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedLogoIcon = new ImageIcon(logoImage);
        JLabel logoLabel = new JLabel(resizedLogoIcon);

        JButton loginButton = new JButton("Login");
        JButton quitButton = new JButton("Quit");

        // Create text fields for username and password
        JTextField usernameField = new JTextField();
        JTextField passwordField = new JTextField();

        // Set preferred size for text fields
        usernameField.setPreferredSize(new Dimension(200, 25));
        passwordField.setPreferredSize(new Dimension(200, 25));

        // Create panel and add components
        JPanel welcomePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        welcomePanel.setBackground(new Color(0, 0, 102)); // Dark blue color

        // Add components to the panel with GridBagConstraints
        gbc.gridx = 1; // Shifted the logo to the right
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0); // Adjust spacing as needed
        welcomePanel.add(logoLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1; // Reset grid width
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 10);

        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setForeground(Color.WHITE); // Set username label text color to white
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setForeground(Color.WHITE); // Set password label text color to white

        gbc.gridx = 0;
        welcomePanel.add(usernameLabel, gbc);
        gbc.gridx = 1;
        welcomePanel.add(usernameField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        welcomePanel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        welcomePanel.add(passwordField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Align buttons to the right
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 75, 0, 0)); // Add empty border to push buttons to the right
        buttonPanel.setBackground(new Color(0, 0, 102));
        buttonPanel.add(loginButton);
        buttonPanel.add(quitButton);
        welcomePanel.add(buttonPanel, gbc);

        // Add panel to the frame
        add(welcomePanel);

        // Action listeners for buttons
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(welcomePanel);
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

        // Create text fields for ticket number, sub-memo, bulk master, and short description
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
        JButton ticketTypeTimeMachineButton = new JButton("Time Machine");
        JButton ticketTypeQuitButton = new JButton("Quit");
        JButton ticketTypeLogOutButton = new JButton("Logout");

// Create button panel and add buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(ticketTypeContinueButton);
        buttonPanel.add(ticketTypeTimeMachineButton);
        buttonPanel.add(ticketTypeQuitButton);
// Add button panel for logout button
        JPanel logOutButtonPanel = new JPanel();
        logOutButtonPanel.add(ticketTypeLogOutButton);
// Add button panel to the main panel
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER; // Center the buttons horizontally
        tickettypepanel.add(buttonPanel, gbc);

        buttonPanel.add(ticketTypeContinueButton);
        buttonPanel.add(ticketTypeTimeMachineButton);
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