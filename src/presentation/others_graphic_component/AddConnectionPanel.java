package presentation.others_graphic_component;

import presentation.MainFrame;
import presentation.chart_rappresentation.Rappresentation;
import presentation.chart_rappresentation.RappresentationPanel;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;
public class AddConnectionPanel extends JPanel {

    private JList<Rappresentation> list;
    private JButton submit;
    private MainFrame p;
    private Rappresentation raps;

    public AddConnectionPanel(MainFrame p) {
        this.p = p;
        raps = null;
    }

    public void config(RappresentationPanel pan, String label){
        for(Component comp: getComponents())
            remove(comp);
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
        add(new JLabel(label),BorderLayout.NORTH);
        JPanel aux = new JPanel();
        aux.add(submit = new JButton("SUBMIT"));
        add(aux,BorderLayout.SOUTH);
        add(list = new JList<Rappresentation>(arr), BorderLayout.CENTER);
        submit.addActionListener((e) -> {
            List<Rappresentation> res = list.getSelectedValuesList();
            if(res.size() == 1){
               this.raps = list.getSelectedValue();
            }
        });
        p.show("add connection panel");
    }

    public Rappresentation getSelection(){
        Rappresentation r = raps;
        raps = null;
        return r;
    }

    public MainFrame getMainFrame(){
        return p;
    }
}
