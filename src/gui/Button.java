package gui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Button extends JButton {

    Button(String text, String actionCommand, ActionListener actionListenner){
        super(text);
        this.setActionCommand(actionCommand);
        this.addActionListener(actionListenner);
    }
}
