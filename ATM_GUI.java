import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATM_GUI {
    public static void main(String[] args) {
        new LoginScreen();
    }
}

class LoginScreen extends JFrame implements ActionListener {
    private JPasswordField pinField;
    private JButton loginButton;

    public LoginScreen() {
        setTitle("ATM Login");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Load background image
        setContentPane(new JLabel(new ImageIcon("atmbg.jpg"))); // ← Replace with your image path
        setLayout(null); // absolute positioning

        JLabel label = new JLabel("Enter PIN:");
        label.setBounds(200, 150, 100, 30);
        label.setForeground(Color.WHITE);
        add(label);

        pinField = new JPasswordField();
        pinField.setBounds(280, 150, 100, 30);
        add(pinField);

        loginButton = new JButton("Login");
        loginButton.setBounds(250, 200, 100, 30);
        loginButton.addActionListener(this);
        add(loginButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pin = new String(pinField.getPassword());
        if (pin.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Access Granted ✅");
            dispose(); // Close login window
            new ATMMenuScreen(); // Open ATM Menu
        } else {
            JOptionPane.showMessageDialog(this, "Wrong PIN ❌");
        }
    }
}

class ATMMenuScreen extends JFrame implements ActionListener {
    private JButton balanceButton, withdrawButton, depositButton, exitButton;
    private double balance = 10000.0;

    public ATMMenuScreen() {
        setTitle("ATM Machine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        balanceButton = new JButton("Check Balance");
        withdrawButton = new JButton("Withdraw");
        depositButton = new JButton("Deposit");
        exitButton = new JButton("Exit");

        add(balanceButton);
        add(withdrawButton);
        add(depositButton);
        add(exitButton);

        balanceButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        depositButton.addActionListener(this);
        exitButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == balanceButton) {
            JOptionPane.showMessageDialog(this, "Your balance is ₹" + balance);
        } else if (e.getSource() == withdrawButton) {
            String amt = JOptionPane.showInputDialog(this, "Enter amount to withdraw:");
            double amount = Double.parseDouble(amt);
            if (amount <= balance) {
                balance -= amount;
                JOptionPane.showMessageDialog(this, "Withdrawn ₹" + amount);
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient Balance!");
            }
        } else if (e.getSource() == depositButton) {
            String amt = JOptionPane.showInputDialog(this, "Enter amount to deposit:");
            double amount = Double.parseDouble(amt);
            balance += amount;
            JOptionPane.showMessageDialog(this, "Deposited ₹" + amount);
        } else if (e.getSource() == exitButton) {
            JOptionPane.showMessageDialog(this, "Thank you for using ATM!");
            System.exit(0);
        }
    }
}
