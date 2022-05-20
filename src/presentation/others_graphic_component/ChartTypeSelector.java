package presentation.others_graphic_component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ChartTypeSelector extends JFrame implements ActionListener {

    private static final Dimension size= new Dimension(710,150);



    public enum Type{SIMPLE, COMPOSITE;}
    private JPanel pannello;
    private JRadioButton simple, composite;
    private ButtonGroup group;
    private JButton button;
    private Type selection;
    private Container parent;

    public ChartTypeSelector(Container parent){
        this.parent = parent;
    }
    public void config(){
        setTitle("scegli il tipo di organizzazione");
        setPreferredSize(size);
        setSize(size);
        add(pannello = new JPanel());
        pannello.setLayout(new GridLayout(2,1));
        pannello.add(new JLabel(" Scegli il tipo di organizzazione"));
        group = new ButtonGroup();
        group.add(simple = new JRadioButton("semplice (non ha organi ad un livello gerarchico inferiore)"));
        group.add(composite = new JRadioButton("complessa (può avere organi a livelli gerarchici inferiori)"));
        JPanel panel2 = new JPanel();
        pannello.add(panel2);
        panel2.setLayout(new GridLayout(1,2));
        JPanel panel3 = new JPanel();
        panel3.add(simple);panel3.add(composite);
        panel2.add(panel3);
        JPanel panel4 = new JPanel();
        panel4.setLayout(new BorderLayout());
        panel4.add(button = new JButton("SUBMIT"),BorderLayout.WEST);
        panel2.add(panel4);
        selection = null;
        addWindowListener(new MyListener());
        button.addActionListener(this);
        button.setSize(new Dimension(100,30));
        Point p = parent.getLocation();
        int x = parent.getSize().width;
        int y = parent.getSize().height;
        setLocation(p.x+x/2-300,p.y+y/2-100);
        setVisible(true);
    }
    public Type getSelection(){
        return selection;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        if(simple.isSelected())
            selection = Type.SIMPLE;
        else
            selection = Type.COMPOSITE;
    }


    public static void main(String[] args){
        //test
        //new ChartTypeSelector().config();
    }


    private class MyListener implements WindowListener{

        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {

        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {
        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            //default value
            if(selection == null)
                selection = Type.COMPOSITE;
            System.out.println(selection);
        }
    }
}//ChartTypeSelector
