package src.main.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Sources I used to help
// https://www.w3schools.com/java/java_hashset.asp
// https://www.geeksforgeeks.org/set-in-java/
// https://youtu.be/dFOIoX3fXpQ?feature=shared
// ChatGPT = OpenAi

public class GUI extends JFrame {

    public void startApp() {
        welcomeScreen(); // Calling WelcomeScreen method
        setVisible(true); // Making the frame visible
    }

    public void welcomeScreen() {
        setTitle("Ellis's Adding Services Automation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380, 400); // Increased height to accommodate the logo

        setLocationRelativeTo(null); // Center the frame on the screen
        // Create components
        JLabel welcomeTitleLabel = new JLabel("Adding Services Automation", SwingConstants.CENTER);
        welcomeTitleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        // Set title label text color to white
        welcomeTitleLabel.setForeground(Color.WHITE);

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

        // Add vertical space
        gbc.insets = new Insets(20, 0, 30, 0);
        welcomePanel.add(Box.createVerticalGlue(), gbc);

        // Add components to the panel with GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        welcomePanel.add(logoLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2; // Ensure the title spans across two columns
        welcomePanel.add(welcomeTitleLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1; // Reset grid width
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 10, 5, 10);

        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setForeground(Color.WHITE); // Set username label text color to white
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setForeground(Color.WHITE); // Set password label text color to white

        gbc.gridx = 0;
        welcomePanel.add(usernameLabel, gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        welcomePanel.add(usernameField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        welcomePanel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        welcomePanel.add(passwordField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        // Adding vertical space
        gbc.gridy++;
        gbc.insets = new Insets(20, 0, 10, 0); // Add extra vertical space
        welcomePanel.add(Box.createVerticalGlue(), gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Center the buttons
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
                // Clears all components from the content pane.
                getContentPane().removeAll();
                // Recalculates the layout of the container.
                revalidate();
                // Forces a repaint of the container to reflect the changes.
                repaint();
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

        // Set larger font for text fields and labels
        Font font = new Font("Arial", Font.PLAIN, 30);
        ticketNumberField.setFont(font);
        subMemoField.setFont(font);
        shortDescriptionField.setFont(font);
        bulkMasterField.setFont(font);

        // Set preferred size for text fields
        Dimension textFieldSize = new Dimension(200, 30);
        ticketNumberField.setPreferredSize(textFieldSize);
        subMemoField.setPreferredSize(textFieldSize);
        shortDescriptionField.setPreferredSize(textFieldSize);
        bulkMasterField.setPreferredSize(textFieldSize);

        // Create panel and add components
        JPanel tickettypepanel = new JPanel(new BorderLayout());
        tickettypepanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        // Adding the label and choice box to NORTH
        tickettypepanel.add(tickettitleLabel, BorderLayout.NORTH);
        JPanel ticketInputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        ticketInputPanel.add(new JLabel("Ticket Type:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        ticketInputPanel.add(choiceBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;  // Incremented to move to the next row
        gbc.anchor = GridBagConstraints.EAST;
        ticketInputPanel.add(new JLabel("Bulk Master #:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        ticketInputPanel.add(bulkMasterField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;  // Incremented to move to the next row
        gbc.anchor = GridBagConstraints.EAST;
        ticketInputPanel.add(new JLabel("Ticket Number:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        ticketInputPanel.add(ticketNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;  // Incremented to move to the next row
        gbc.anchor = GridBagConstraints.EAST;
        ticketInputPanel.add(new JLabel("Sub-Memo:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        ticketInputPanel.add(subMemoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;  // Incremented to move to the next row
        gbc.anchor = GridBagConstraints.EAST;
        ticketInputPanel.add(new JLabel("Short description:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        ticketInputPanel.add(shortDescriptionField, gbc);
        // Add input panel to CENTER
        tickettypepanel.add(ticketInputPanel, BorderLayout.CENTER);
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
        buttonPanel.add(ticketTypeLogOutButton);


        // Create logout button panel and add logout button
        JPanel logOutButtonPanel = new JPanel();
        logOutButtonPanel.add(ticketTypeLogOutButton);

        // Add button panel to SOUTH
        tickettypepanel.add(buttonPanel, BorderLayout.SOUTH);
        // Add logout button panel to NORTH
        tickettypepanel.add(logOutButtonPanel, BorderLayout.EAST);

        // Add action listeners for quit button
        ticketTypeQuitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to handle quit button click
                System.exit(0);
            }
        });


        // Add action listeners for time machine button
        ticketTypeTimeMachineButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to handle time machine button click
                // Clears all components from the content pane.
                getContentPane().removeAll();
                // Recalculates the layout of the container.
                revalidate();
                // Forces a repaint of the container to reflect the changes.
                repaint();
                // Call timeMachine method.
                timeMachine();
            }
        });


        // Add action listeners for logout button
        ticketTypeLogOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to handle logout button click
                // Clears all components from the content pane.
                getContentPane().removeAll();
                // Recalculates the layout of the container.
                revalidate();
                // Forces a repaint of the container to reflect the changes.
                repaint();
                // Call welcomeScreen method.
                welcomeScreen();
            }
        });
        // Add panel to the frame
        add(tickettypepanel);
    }
    public void timeMachine() {
        setTitle("Ellis's Adding Services Automation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create the JLabel
        JLabel timemachinetitleLabel = new JLabel("Time Machine:", SwingConstants.CENTER);
        timemachinetitleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        timemachinetitleLabel.setForeground(Color.WHITE);

        // Create the logout button
        JButton logoutButton = new JButton("Logout");
        JButton backButton = new JButton("Back");

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to handle logout button click
                // Clears all components from the content pane.
                getContentPane().removeAll();
                // Recalculates the layout of the container.
                revalidate();
                // Forces a repaint of the container to reflect the changes.
                repaint();
                // Call welcomeScreen method.
                welcomeScreen();
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to handle logout button click
                // Clears all components from the content pane.
                getContentPane().removeAll();
                // Recalculates the layout of the container.
                revalidate();
                // Forces a repaint of the container to reflect the changes.
                repaint();
                // Call welcomeScreen method.
                ticketType();
            }
        });

        // Create a panel for the top section
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(0, 0, 102)); // Dark blue color

        // Create a panel for the label and add it to the center of topPanel
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        labelPanel.setBackground(new Color(0, 0, 102));
        labelPanel.add(timemachinetitleLabel);
        topPanel.add(labelPanel, BorderLayout.CENTER);

        // Add the logout button to the top right
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(0, 0, 102));
        buttonPanel.add(logoutButton);
        topPanel.add(buttonPanel, BorderLayout.EAST);

        // Add the back button to the bottom
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(0, 0, 102));
        buttonPanel.add(backButton);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Create the main panel with GridBagLayout
        JPanel timemachinePanel = new JPanel(new GridBagLayout());
        timemachinePanel.setBackground(new Color(0, 0, 102));
        GridBagConstraints gbc = new GridBagConstraints();

        // Add the top panel to the main panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.anchor = GridBagConstraints.NORTH;
        timemachinePanel.add(topPanel, gbc);

        // Date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Add sections for the dates and text fields
        LocalDate today = LocalDate.now();
        for (int i = 0; i < 7; i++) {
            LocalDate date = today.minusDays(i);
            String dateString = date.format(formatter) + ": Twixter";

            // Create a panel for each section.
            JPanel sectionPanel = new JPanel(new BorderLayout());
            sectionPanel.setBackground(new Color(0, 0, 102));
            sectionPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE)); // Horizontal line

            // Create a label for the date
            JLabel dateLabel = new JLabel(dateString);
            dateLabel.setForeground(Color.WHITE);
            sectionPanel.add(dateLabel, BorderLayout.WEST);

            // Create a text field for the description
            JTextField descriptionField = new JTextField(20);
            sectionPanel.add(descriptionField, BorderLayout.CENTER);

            // Add the section panel to the main panel
            gbc.gridy++;
            gbc.insets = new Insets(10, 10, 10, 10);
            timemachinePanel.add(sectionPanel, gbc);
        }

        // Add vertical space at the bottom
        gbc.gridy++;
        gbc.weighty = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.SOUTH;
        timemachinePanel.add(Box.createVerticalGlue(), gbc);

        add(timemachinePanel);
    }
}