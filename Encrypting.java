import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Mesha on 07/06/2020
 * @project Encrypting
 **/
public class Encrypting extends JFrame implements ActionListener {

    private final JTextArea input;
    private final JTextArea output;

    public static void main(String[] args) {
        new Encrypting().setVisible(true);
    }

    public void encryptText() {
        int key = 5;
        String outputTxt = "";
        String text = input.getText().toLowerCase();
        System.out.println(text);

        char[] chars = text.toCharArray();
        for(char c : chars) {
            c += key;
            outputTxt = outputTxt.concat(String.valueOf(c));
            output.setText(outputTxt);
            System.out.print(c);
        }
    }

    public void decryptText() {
        int key = 5;
        String outputTxt = "";
        String text = input.getText().toLowerCase();
        System.out.println(text);

        char[] chars = text.toCharArray();
        for(char c : chars) {
            c -= key;
            outputTxt = outputTxt.concat(String.valueOf(c));
            output.setText(outputTxt);
            System.out.print(c);
        }
    }

    public Encrypting() {
        setTitle("Encrypting");
        setVisible(true);
        setResizable(false);
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container content = getContentPane();
        GridLayout layout = new GridLayout(3, 0, 0, 10);
        content.setLayout(layout);

        input = new JTextArea("Enter text here to encrypt or decrypt..", 5, 30);
        input.setLineWrap(true);
        input.setWrapStyleWord(true);
        input.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        JScrollPane scroller = new JScrollPane(input);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        content.add(scroller);

        output = new JTextArea("Output text..", 5, 30);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        JScrollPane scroller2 = new JScrollPane(output);
        scroller2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        content.add(scroller2);

        JPanel box = new JPanel();
        box.setLayout(new FlowLayout());
        JButton encryptBtn = new JButton("Encrypt");
        JButton decryptBtn = new JButton("Decrypt");
        encryptBtn.addActionListener(this);
        decryptBtn.addActionListener(this);
        box.add(encryptBtn);
        box.add(decryptBtn);
        content.add(box);

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Encrypt")) {
            encryptText();
        }
        if(e.getActionCommand().equals("Decrypt")) {
            decryptText();
        }
    }
}