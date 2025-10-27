import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonDemo extends JFrame implements ActionListener {
    private JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    private JLabel imageLabel;

    public RadioButtonDemo() {
        setTitle("RadioButtonDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLayout(new BorderLayout(10, 10));  // Use BorderLayout for better control

        // ===== Left side panel for radio buttons =====
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));  // vertical layout

        // Create radio buttons
        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");

        // Add buttons to a group
        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        // Add listeners
        birdButton.addActionListener(this);
        catButton.addActionListener(this);
        dogButton.addActionListener(this);
        rabbitButton.addActionListener(this);
        pigButton.addActionListener(this);

        // Add buttons to the panel
        buttonPanel.add(birdButton);
        buttonPanel.add(catButton);
        buttonPanel.add(dogButton);
        buttonPanel.add(rabbitButton);
        buttonPanel.add(pigButton);

        // ===== Image label (right side) =====
        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(200, 200));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        // 🐷 Default selection and image
        pigButton.setSelected(true);
        imageLabel.setIcon(resizeImage("images/pig.png"));

        // ===== Add to frame =====
        add(buttonPanel, BorderLayout.WEST);   // buttons on the left
        add(imageLabel, BorderLayout.CENTER);  // image in the middle

        // Center the window on screen
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == birdButton) {
            imageLabel.setIcon(resizeImage("images/bird.png"));
        } else if (e.getSource() == catButton) {
            imageLabel.setIcon(resizeImage("images/cat.png"));
        } else if (e.getSource() == dogButton) {
            imageLabel.setIcon(resizeImage("images/dog.png"));
        } else if (e.getSource() == rabbitButton) {
            imageLabel.setIcon(resizeImage("images/rabbit.png")); // double-check extension!
        } else if (e.getSource() == pigButton) {
            imageLabel.setIcon(resizeImage("images/pig.png"));
        }
    }

    // Resize images for neat display
    private ImageIcon resizeImage(String path) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

    public static void main(String[] args) {
        new RadioButtonDemo();
    }
}
