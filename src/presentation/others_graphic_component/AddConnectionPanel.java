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
    private Font myFont ;

    public AddConnectionPanel(MainFrame p) {
        this.p = p;
        raps = null;
        myFont = new Font("Times Romans",Font.BOLD,17);
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
        pannelloBottone.setBackground(Color.WHITE);
        JPanel pannelloLabel = new JPanel();
        pannelloLabel.setBackground(Color.WHITE);
        JLabel title = new JLabel(label);
        title.setFont(myFont);
        title.setForeground(Color.RED);
        pannelloLabel.add(title);
        pannelloNord.add(pannelloLabel);
        add(pannelloNord,BorderLayout.NORTH);
        JPanel aux = new JPanel();
        aux.setBackground(Color.WHITE);
        aux.add(submit = new JButton("SUBMIT"));
        add(aux,BorderLayout.SOUTH);
        add(list = new JList<Rappresentation>(arr), BorderLayout.CENTER);
        list.setFont(myFont);
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
