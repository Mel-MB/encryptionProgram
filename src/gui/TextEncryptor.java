package gui;
import model.EncryptionProgram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEncryptor extends JFrame implements ActionListener {
    EncryptionProgram model;

    TextArea decryptedTextArea;
    TextArea encryptedTextArea;

    JButton encryptButton;
    JButton decryptButton;


    public TextEncryptor(EncryptionProgram encryptionProgram){
        model = encryptionProgram;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Encryptor");
        this.setSize(1000, 700);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        this.setLocationRelativeTo(null);

        decryptedTextArea = new TextArea();
        encryptedTextArea = new TextArea();


        JPanel commandPanel = new JPanel(new GridLayout(2,1));
        encryptButton = new Button("Encrypt →", "encrypt", this);
        decryptButton = new Button("← Decrypt", "decrypt", this);
        commandPanel.add(encryptButton);
        commandPanel.add(decryptButton);

        this.add(decryptedTextArea);
        this.add(commandPanel);
        this.add(encryptedTextArea);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "encrypt":
                encryptedTextArea.setTextContent(model.encrypt(decryptedTextArea.getTextContent()));
                break;
            case "decrypt":
                decryptedTextArea.setTextContent(model.decrypt(encryptedTextArea.getTextContent()));
                break;
            default:
                break;
        }
    }
}
