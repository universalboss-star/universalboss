import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizApp extends JFrame implements ActionListener {
    String[] questions = {
        "Which planet is known as the Red Planet?",
        "Who wrote 'Romeo and Juliet'?",
        "What is the capital of India?"
    };

    String[][] options = {
        {"Earth", "Mars", "Jupiter", "Saturn"},
        {"Shakespeare", "Tagore", "Premchand", "Keats"},
        {"Mumbai", "Delhi", "Kolkata", "Chennai"}
    };

    int[] answers = {1, 0, 1}; // index of correct options
    int currentQuestion = 0;
    int score = 0;

    JLabel questionLabel;
    JRadioButton[] optionsButtons = new JRadioButton[4];
    ButtonGroup group = new ButtonGroup();
    JButton nextButton;

    public QuizApp() {
        setTitle("Quiz App");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        questionLabel = new JLabel();
        add(questionLabel);

        for (int i = 0; i < 4; i++) {
            optionsButtons[i] = new JRadioButton();
            group.add(optionsButtons[i]);
            add(optionsButtons[i]);
        }

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        add(nextButton);

        loadQuestion();
        setVisible(true);
    }

    public void loadQuestion() {
        if (currentQuestion < questions.length) {
            questionLabel.setText("Q" + (currentQuestion + 1) + ": " + questions[currentQuestion]);
            for (int i = 0; i < 4; i++) {
                optionsButtons[i].setText(options[currentQuestion][i]);
            }
            group.clearSelection();
        } else {
            showResult();
        }
    }

    public void showResult() {
        JOptionPane.showMessageDialog(this, "Quiz Over! 🎉\nYour score: " + score + "/" + questions.length);
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selected = -1;
        for (int i = 0; i < 4; i++) {
            if (optionsButtons[i].isSelected()) {
                selected = i;
            }
        }

        if (selected == answers[currentQuestion]) {
            score++;
        }

        currentQuestion++;
        loadQuestion();
    }

    public static void main(String[] args) {
        new QuizApp();
    }
}
