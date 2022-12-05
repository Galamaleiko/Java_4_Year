import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public class Main {

    public static boolean checkForTriangle(double x, double y, double z) {
        double[] array = {x, y, z};
        Arrays.sort(array);
        return array[0] * array[0] + array[1] * array[1] == array[2] * array[2];
    }

    public static void main(String[] args) throws IOException {

        String blueTrianglePath = "C:\\Users\\sergi\\IdeaProjects\\JavaLab1\\src\\images\\blue_triangle.png";
        String trianglePath = "C:\\Users\\sergi\\IdeaProjects\\JavaLab1\\src\\images\\triangle.png";
        String blueTriangleOPath = "C:\\Users\\sergi\\IdeaProjects\\JavaLab1\\src\\images\\blue_triangle_with_o.png";
        String triangleOPath = "C:\\Users\\sergi\\IdeaProjects\\JavaLab1\\src\\images\\triangle_with_o.png";

        final String[] imgSelector = {"black"};

        File file = new File(trianglePath);
        BufferedImage bufferedImage = ImageIO.read(file);

        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        JFrame jFrame = new JFrame();
        jFrame.setBounds(300,0,800,800);
        jFrame.setVisible(true);

        JPanel jPanel = new JPanel(new FlowLayout());
        jFrame.add(jPanel);
        jPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));

        jPanel.add(Box.createVerticalStrut(30));

        JLabel jLabel = new JLabel();

        JMenuBar jMenuBar = new JMenuBar();
        JMenu programMenu = new JMenu("Програма");
        JMenu editMenu = new JMenu("Правка");
        jMenuBar.add(programMenu);
        jMenuBar.add(editMenu);
        jFrame.setJMenuBar(jMenuBar);
        JMenuItem check = programMenu.add(new JMenuItem("Перевірка"));

        JMenuItem calculate = programMenu.add(new JMenuItem("Обчислити"));


        programMenu.add(new JSeparator());
        JMenuItem quit = programMenu.add(new JMenuItem("Вийти"));
        quit.addActionListener(actionEvent -> System.exit(0));

        editMenu.add(new JMenuItem("Копіювати"));
        editMenu.add(new JMenuItem("Вставити"));


        jLabel.setIcon(imageIcon);
        jLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JPopupMenu contextMenu = new JPopupMenu();
                JMenuItem paintButton = new JMenuItem("Пофарбувати");
                JMenuItem circleButton = new JMenuItem("Вписане і Описане коло");
                JMenuItem deleteButton = new JMenuItem("Видалити");

                paintButton.addActionListener(e12 -> {
                    switch (imgSelector[0]) {
                        case "black" -> {
                            jLabel.setIcon(new ImageIcon(blueTrianglePath));
                            imgSelector[0] = "blue";
                        }
                        case "blue" -> {
                            jLabel.setIcon(new ImageIcon(trianglePath));
                            imgSelector[0] = "black";
                        }
                        case "blackO" -> {
                            jLabel.setIcon(new ImageIcon(blueTriangleOPath));
                            imgSelector[0] = "blueO";
                        }

                        default -> {
                            jLabel.setIcon(new ImageIcon(triangleOPath));
                            imgSelector[0] = "blackO";
                        }
                    }
                });

                circleButton.addActionListener(e1 -> {
                    if (imgSelector[0].equals("black")) {
                        jLabel.setIcon(new ImageIcon(triangleOPath));
                        imgSelector[0] = "blackO";
                    } else if (imgSelector[0].equals("blue")) {
                        jLabel.setIcon(new ImageIcon(blueTriangleOPath));
                        imgSelector[0] = "blueO";
                    }
                });

                deleteButton.addActionListener(e13 -> {
                    jLabel.setIcon(null);
                });

                contextMenu.add(paintButton);
                contextMenu.add(circleButton);
                contextMenu.add(deleteButton);

                contextMenu.show(e.getComponent(), e.getX(), e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        jPanel.add(jLabel);
        JPanel inputPanel = new JPanel();
        JLabel aLabel = new JLabel("A:");
        JTextField aInput = new JTextField("", 10);
        JLabel bLabel = new JLabel("B:");
        JTextField bInput = new JTextField("", 10);
        JLabel cLabel = new JLabel("C:");
        JTextField cInput = new JTextField("", 10);

        inputPanel.add(aLabel);
        inputPanel.add(aInput);
        inputPanel.add(bLabel);
        inputPanel.add(bInput);
        inputPanel.add(cLabel);
        inputPanel.add(cInput);

        jPanel.add(inputPanel);

        check.addActionListener(actionEvent -> {
            try {

                double typedA = Integer.parseInt(aInput.getText());
                double typedB = Integer.parseInt(bInput.getText());
                double typedC = Integer.parseInt(cInput.getText());

                boolean isTriangle = checkForTriangle(typedA, typedB, typedC);
                if (!isTriangle) {
                    JOptionPane.showMessageDialog(null, "Трикутник не є прямокутним.");
                } else {
                    JOptionPane.showMessageDialog(null, "Трикутник Прямокутний.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Некоректний формат вводу.");
            }
        });


        calculate.addActionListener(actionEvent -> {
            try {

                double typedA = Integer.parseInt(aInput.getText());
                double typedB = Integer.parseInt(bInput.getText());
                double typedC = Integer.parseInt(cInput.getText());

                boolean isTriangle = checkForTriangle(typedA, typedB, typedC);

                if (!isTriangle) {
                    JOptionPane.showMessageDialog(null, "Трикутник не є прямокутним.");
                } else {
                    double[] array = {typedA, typedB, typedC};
                    Arrays.sort(array);

                    String sqr = Double.toString(array[0] * array[1] / 2);
                    double outRad = array[2]/2;
                    double inRad = (array[0] + array[1] - array[2])/2;

                    JFrame jFrame2 = new JFrame();
                    jFrame2.setBounds(400, 100, 500, 200);
                    jFrame2.setVisible(true);
                    JPanel jPanel2 = new JPanel(new FlowLayout());
                    jPanel2.add(new JLabel("Площа трикутника - " + sqr + ", радіус описаного кола - " + outRad
                            + ", радіус вписаного кола - " + inRad));
                    jFrame2.add(jPanel2);
                    jPanel2.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));
                    JButton exitButton = new JButton("Вихід");

                    jPanel2.add(exitButton);
                    exitButton.addActionListener(actionEvent1 -> System.exit(0));
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Некоректний формат вводу.");
            }

        });

        JButton nextButton = new JButton("Продовжити");
        jPanel.add(nextButton);

        nextButton.addActionListener(actionEvent -> {
            try {

                double typedA = Integer.parseInt(aInput.getText());
                double typedB = Integer.parseInt(bInput.getText());
                double typedC = Integer.parseInt(cInput.getText());

                boolean isTriangle = checkForTriangle(typedA, typedB, typedC);

                if (!isTriangle) {
                    JOptionPane.showMessageDialog(null, "Трикутник не є прямокутним.");
                } else {
                    double[] array = {typedA, typedB, typedC};
                    Arrays.sort(array);

                    String sqr = Double.toString(array[0] * array[1] / 2);
                    double outRad = array[2]/2;
                    double inRad = (array[0] + array[1] - array[2])/2;

                    JFrame jFrame2 = new JFrame();
                    jFrame2.setBounds(400, 100, 500, 200);
                    jFrame2.setVisible(true);
                    JPanel jPanel2 = new JPanel(new FlowLayout());
                    jPanel2.add(new JLabel("Площа трикутника - " + sqr + ", радіус описаного кола - " + outRad
                            + ", радіус вписаного кола - " + inRad));
                    jFrame2.add(jPanel2);
                    jPanel2.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));
                    JButton exitButton = new JButton("Вихід");

                    jPanel2.add(exitButton);
                    exitButton.addActionListener(actionEvent1 -> System.exit(0));
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Некоректний формат вводу.");
            }

        });


        jPanel.revalidate();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
