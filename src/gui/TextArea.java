package gui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class TextArea extends JScrollPane{
    private JTextArea textArea;

    TextArea(JButton dependantActionButton){
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("MV Boli",Font.PLAIN,12));
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                enableContentBasedAction(dependantActionButton);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                enableContentBasedAction(dependantActionButton);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                enableContentBasedAction(dependantActionButton);
            }
        });

        this.setViewportView(textArea);
        this.setPreferredSize(new Dimension(400,400));
        this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);


    }

    protected String getTextContent(){
        return textArea.getText();
    }
    protected void setTextContent(String text){
        textArea.setText(text);
    }

    private void enableContentBasedAction(JButton button){
        if(this.getTextContent() != null) button.setEnabled(true);
    };

}
