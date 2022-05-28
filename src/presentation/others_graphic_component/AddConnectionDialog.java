package presentation.others_graphic_component;

import presentation.MainFrame;
import presentation.chart_rappresentation.Rappresentation;
import presentation.chart_rappresentation.RappresentationPanel;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class AddConnectionDialog extends JOptionPane {

    private JList<Rappresentation> list;
    private JButton submit;
    private Rappresentation raps;
    private final Font myFont = new Font("Times Romans",Font.BOLD,15);
    public AddConnectionDialog(){
        removeAll();
        raps = null;
    }

    public void config(RappresentationPanel pan, MainFrame p,String label){
        setLayout(new BorderLayout());
        List<Rappresentation> rps = new LinkedList<Rappresentation>();
        for(Component c: pan.getComponents())
            if(c instanceof Rappresentation)
                rps.add((Rappresentation) c);
        Rappresentation[] arr = new Rappresentation[rps.size()];
        int i = 0;
        for(Rappresentation rappresentation: rps){
            arr[i] = rappresentation;
            i++;
        }
        JPanel pannelloNord = new JPanel();
        pannelloNord.setLayout(new GridLayout(2,1));
        JButton back = new JButton("<-");
        back.addActionListener((e)->{
            p.show("pannello tabs");
        });
        JPanel pannelloBottone = new JPanel();
        pannelloBottone.setLayout(new BorderLayout());
        pannelloBottone.add(back,BorderLayout.WEST);
        pannelloNord.add(pannelloBottone);
        JPanel pannelloLabel = new JPanel();
        JLabel title = new JLabel(label);
        title.setFont(myFont);
        title.setForeground(Color.RED);
        pannelloLabel.add(title);
        pannelloNord.add(pannelloLabel);
        add(pannelloNord,BorderLayout.NORTH);
        JPanel aux = new JPanel();
        aux.add(submit = new JButton("SUBMIT"));
        add(aux,BorderLayout.SOUTH);
        add(list = new JList<Rappresentation>(arr), BorderLayout.CENTER);
        list.setFont(myFont);
        submit.addActionListener((e) -> {
            List<Rappresentation> res = list.getSelectedValuesList();
            if(res.size() == 1){
                this.raps = list.getSelectedValue();
            }
            Container c = getParent();
            for(; !(c instanceof JDialog); c = c.getParent());
            c.setVisible(false);

        });

        createDialog(label).setVisible(true);
    }

    public Rappresentation getRappresentation(){
        return raps;
    }

}
