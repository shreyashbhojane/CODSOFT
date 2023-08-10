import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class codesoftinternp1 extends JFrame {
    private JLabel inputLabel;
    private JTextField inputField;
    private JButton countButton;
    private JTextArea resultArea;

    public codesoftinternp1() {
        setTitle("Word Counter");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        inputLabel = new JLabel("Enter your text:");
        inputField = new JTextField();
        countButton = new JButton("Count Words");
        resultArea = new JTextArea();

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(inputLabel, BorderLayout.NORTH);
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(countButton, BorderLayout.SOUTH);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText();
                int wordCount = countWords(text);
                resultArea.setText("Word Count: " + wordCount);
            }
        });
    }

    private int countWords(String text) {
        if (text.isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                codesoftinternp1 wordCounterGUI = new codesoftinternp1();
                wordCounterGUI.setVisible(true);
            }
        });
    }
}