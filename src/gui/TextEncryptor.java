package gui;
import model.EncryptionProgram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextEncryptor extends JFrame implements ActionListener {
    EncryptionProgram model;

    TextArea decryptedTextArea;
    TextArea encryptedTextArea;

    JPanel commandPanel;
    JButton encryptButton = new Button("Encrypt →", "encrypt", this);;
    JButton decryptButton = new Button("← Decrypt", "decrypt", this);;


    public TextEncryptor(EncryptionProgram encryptionProgram){
        model = encryptionProgram;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Encryptor");
        this.setSize(1200, 700);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        this.setLocationRelativeTo(null);

        commandPanel = new JPanel(new GridLayout(2,1));
        setDefaultCommands(commandPanel);


        decryptedTextArea = new TextArea(encryptButton);
        encryptedTextArea = new TextArea(decryptButton);


        this.add(decryptedTextArea);
        this.add(commandPanel);
        this.add(encryptedTextArea);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "encrypt":
                encryptedTextArea.setTextContent(model.encrypt(decryptedTextArea.getTextContent()));
                changeActions(new Button("<html><center>"+"Save "+"<br>"+"encrypted data"+"</center></html>","save /\n encrypted",this));
                break;

            case "decrypt":
                decryptedTextArea.setTextContent(model.decrypt(encryptedTextArea.getTextContent()));
                changeActions(new Button("Save decrypted file","save /\n decrypted",this));
                break;

            case "save encrypted":
                model.save(encryptedTextArea.getTextContent());
                break;

            case "save decrypted":
                model.save(decryptedTextArea.getTextContent());
                break;

            case "refresh":
                decryptedTextArea.setTextContent("");
                encryptedTextArea.setTextContent("");
                setDefaultCommands(commandPanel);
                break;
            default:
                break;
        }

    }

    private void changeActions(JButton button){
        JButton refreshButton = new Button("Refresh","refresh",this);
        commandPanel.removeAll();

        commandPanel.add(button);
        commandPanel.add(refreshButton);

        commandPanel.validate();
        commandPanel.repaint();
    }

    private void setDefaultCommands(JPanel parentElement){
        parentElement.removeAll();

        parentElement.add(encryptButton);
        encryptButton.setEnabled(false);
        parentElement.add(decryptButton);
        decryptButton.setEnabled(false);

        parentElement.validate();
        parentElement.repaint();
    }
}
