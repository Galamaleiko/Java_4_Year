import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends Component{
    JButton sendButton = new JButton("Надіслати");
    JButton cancelButton = new JButton("Скасувати");
    JTextField emailInput = new JTextField();
    JTextField nameInput = new JTextField();
    JTextField cityInput = new JTextField();
    JTextField addressInput = new JTextField();
    JTextField personInput = new JTextField();
    JTextField phoneInput = new JTextField();
    KeyListener listener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (!(emailInput.getText().isEmpty() || nameInput.getText().isEmpty() || cityInput.getText().isEmpty()
                    || addressInput.getText().isEmpty() || personInput.getText().isEmpty() || phoneInput.getText().isEmpty())){
                sendButton.setEnabled(true);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };

    private void run() {
        JFrame frame = createFrame();
        frame.setVisible(true);
    }

    private JFrame createFrame() {
        JFrame frame = new JFrame("Main Frame");
        frame.getContentPane().add(createPanel());
        frame.pack();
        frame.setBounds(500,200,650,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }


    private JPanel createPanel() {
        JPanel panel = new JPanel(new GridBagLayout());

        Color textColor = new Color(7, 155, 197, 255);
        JLabel infoLabel = new JLabel("Інформація про організацію");
        infoLabel.setBounds(20, 10, 500, 50);
        infoLabel.setForeground(textColor);
        infoLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        panel.add(infoLabel);

        JLabel nameLabel = new JLabel("Назва *");
        nameLabel.setBounds(20, 60, 200, 50);
        nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        panel.add(nameLabel);


        nameInput.setBounds(200,68,250,30);
        nameInput.addKeyListener(listener);
        panel.add(nameInput);

        JLabel cityLabel = new JLabel("Місто *");
        cityLabel.setBounds(20, 100, 200, 50);
        cityLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        panel.add(cityLabel);

        cityInput.setBounds(200,108,250,30);
        cityInput.addKeyListener(listener);
        panel.add(cityInput);


        JLabel addressLabel = new JLabel("Адреса *");
        addressLabel.setBounds(20, 140, 200, 50);
        addressLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        panel.add(addressLabel);

        addressInput.setBounds(200,148,250,30);
        addressInput.addKeyListener(listener);
        panel.add(addressInput);


        JLabel contactInfo = new JLabel("Контактна особа");
        contactInfo.setBounds(20, 200, 500, 50);
        contactInfo.setForeground(textColor);
        contactInfo.setFont(new Font("Times New Roman", Font.BOLD, 24));
        panel.add(contactInfo);


        JLabel personLabel = new JLabel("Контактна особа *");
        personLabel.setBounds(20, 240, 200, 50);
        personLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        panel.add(personLabel);

        personInput.setBounds(200,248,250,30);
        personInput.addKeyListener(listener);
        panel.add(personInput);

        JLabel phoneLabel = new JLabel("Телефон *");
        phoneLabel.setBounds(20, 280, 200, 50);
        phoneLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        panel.add(phoneLabel);

        phoneInput.setBounds(200,288,250,30);
        phoneInput.addKeyListener(listener);
        panel.add(phoneInput);


        JLabel emailLabel = new JLabel("E-mail *");
        emailLabel.setBounds(20, 320, 200, 50);
        emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        panel.add(emailLabel);



        emailInput.setBounds(200,328,250,30);
        emailInput.addKeyListener(listener);
        panel.add(emailInput);

        JCheckBox down = new JCheckBox("Хочу отримувати розсилку", false);
        down.setBounds(25,400,200,30);
        down.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        panel.add(down);

        Color colorRed = new Color(232, 39, 39, 255);
        cancelButton.setBounds(325,400,120, 40);
        cancelButton.setBackground(colorRed);
        cancelButton.addActionListener(e -> {
            sendButton.setEnabled(false);
            cancelButton.setEnabled(false);
            emailInput.setEnabled(false);
            nameInput.setEnabled(false);
            cityInput.setEnabled(false);
            addressInput.setEnabled(false);
            personInput.setEnabled(false);
            phoneInput.setEnabled(false);
            down.setEnabled(false);

            JFrame f = new JFrame();
            f.setBounds(600,300,300,200);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);

            JPanel p = new JPanel(new GridBagLayout());
            f.add(p);

            JLabel l = new JLabel("Нам шкода, що ви не надали інформацію!");
            l.setBounds(20,20,500,50);
            p.add(l);

            JButton b = new JButton("Закрити!");
            b.setBounds(20,100,110,25);
            b.setBackground(colorRed);
            p.add(b);
            b.addActionListener(e12 -> System.exit(0));
            p.setLayout(null);
        });
        panel.add(cancelButton);

        Color colorGreen = new Color(116, 232, 39, 255);
        sendButton.setBounds(490,400,120, 40);
        sendButton.setBackground(colorGreen);
        sendButton.setEnabled(false);


        sendButton.addActionListener(e -> {
            sendButton.setEnabled(false);
            cancelButton.setEnabled(false);
            emailInput.setEnabled(false);
            nameInput.setEnabled(false);
            cityInput.setEnabled(false);
            addressInput.setEnabled(false);
            personInput.setEnabled(false);
            phoneInput.setEnabled(false);
            down.setEnabled(false);

            JFrame f = new JFrame();
            f.setBounds(600,300,300,200);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);

            JPanel p = new JPanel(new GridBagLayout());
            p.setVisible(true);
            f.add(p);

            JLabel l = new JLabel("Дякуємо, ми oбробляємо вашу інформацію");
            l.setBounds(20,20,500,50);
            p.add(l);

            JButton b = new JButton("Закрити!");
            b.setBounds(20,100,110,25);
            b.setBackground(colorGreen);
            p.add(b);
            b.addActionListener(e1 -> System.exit(0));
            p.setLayout(null);
        });

        panel.add(sendButton);


        ImageIcon iconLogo = new ImageIcon("C:\\Users\\sergi\\Downloads\\java.png");
        JLabel logo = new JLabel("");
        logo.setIcon(iconLogo);
        logo.setBounds(450, 0, iconLogo.getIconWidth(), iconLogo.getIconHeight());
        panel.add(logo);

        panel.setLayout(null);
        return panel;
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Main().run());
    }
}