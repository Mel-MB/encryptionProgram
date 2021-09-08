package gui;

import javax.swing.*;
import java.awt.*;

public class TextArea extends JScrollPane{
    private JTextArea textArea;

    TextArea(){
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("MV Boli",Font.PLAIN,12));

        this.setViewportView(textArea);
        this.setPreferredSize(new Dimension(400,550));
        this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    }

    protected String getTextContent(){
        return textArea.getText();
    }
    protected void setTextContent(String text){
        textArea.setText(text);
    }

}
