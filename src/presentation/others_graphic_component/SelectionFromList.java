package presentation.others_graphic_component;

import presentation.chart_rappresentation.Rappresentation;

import javax.swing.*;
import java.awt.*;

public class SelectionFromList<T> extends JOptionPane {

    private JList<Object> list;
    private JButton submit;
    private JLabel label;
    private Font myFont = new Font("Times Romans", Font.BOLD, 13);
    private Rappresentation target;
    public SelectionFromList(){
        removeAll();
    }

    public void config(Object[] objects, String labelString){
        setLayout(new GridLayout(3,1));
        add(label = new JLabel(labelString));
        label.setFont(myFont);
        add(list = new JList<Object>(objects));
        JPanel submitPanel = new JPanel();
        submitPanel.add(submit = new JButton("SUBMIT"));
        add(submitPanel);
        submit.addActionListener((e)->{
            Container c = null;
            for(c = getParent(); !(c instanceof JDialog); c = c.getParent());
            if(c != null)
                c.setVisible(false);
        });
    }

    public T getSelected(){
        if(list.getSelectedValuesList().size() != 1){
            JOptionPane.showMessageDialog(target,"scegliere esattamente un elemento");
            return null;
        }
        return (T)list.getSelectedValue();
    }
}
