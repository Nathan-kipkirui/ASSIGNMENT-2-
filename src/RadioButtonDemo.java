import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonDemo extends JFrame implements ActionListener {

    JRadioButton bird, cat, dog, rabbit, pig;
    JLabel imageLabel;

    public RadioButtonDemo() {

        setTitle("Animal Selector");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Radio buttons
        bird = new JRadioButton("Bird");
        cat = new JRadioButton("Cat");
        dog = new JRadioButton("Dog");
        rabbit = new JRadioButton("Rabbit");
        pig = new JRadioButton("Pig");

        ButtonGroup group = new ButtonGroup();
        group.add(bird);
        group.add(cat);
        group.add(dog);
        group.add(rabbit);
        group.add(pig);

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(5, 1));

        radioPanel.add(bird);
        radioPanel.add(cat);
        radioPanel.add(dog);
        radioPanel.add(rabbit);
        radioPanel.add(pig);

        imageLabel = new JLabel("", JLabel.CENTER);

        add(radioPanel, BorderLayout.WEST);
        add(imageLabel, BorderLayout.CENTER);

        bird.addActionListener(this);
        cat.addActionListener(this);
        dog.addActionListener(this);
        rabbit.addActionListener(this);
        pig.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String animal = "";
        String imagePath = "";

        if (bird.isSelected()) {
            animal = "Bird";
            imagePath = "images/bird.png";
        } else if (cat.isSelected()) {
            animal = "Cat";
            imagePath = "images/cat.png";
        } else if (dog.isSelected()) {
            animal = "Dog";
            imagePath = "images/dog.png";
        } else if (rabbit.isSelected()) {
            animal = "Rabbit";
            imagePath = "images/rabbit.png";
        } else if (pig.isSelected()) {
            animal = "Pig";
            imagePath = "images/pig.png";
        }

        ImageIcon icon = new ImageIcon(imagePath);

        Image img = icon.getImage().getScaledInstance(300, 250, Image.SCALE_SMOOTH);

        imageLabel.setIcon(new ImageIcon(img));

        JOptionPane.showMessageDialog(this,
                "You selected " + animal,
                "Selected Animal",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new RadioButtonDemo());

    }
}