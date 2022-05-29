package presentation.others_graphic_component;

import javax.swing.*;
import java.awt.*;

public class HelpView extends JOptionPane {

    private JTabbedPane tab;
    private Font myFont = new Font("Times Romans", Font.ITALIC, 15);
    private JTextArea textArea1, textArea2;
    public HelpView(){
        removeAll();
    }

    public HelpView config(){
        add(tab = new JTabbedPane());
        tab.setTabPlacement(JTabbedPane.LEFT);
        addTab("GENERALI",contents[GENERAL]);
        addTab("GESTIONE ORGANI", contents[CHART]);
        return this;
    }

    public void addTab(String title, String content){
        JTextArea area = new JTextArea(content);
        area.setEditable(false);
        area.setFont(myFont);
        tab.addTab(title, area);
    }

    public static void main(String...args){
        HelpView hv = new HelpView();
        hv.config();
        hv.createDialog("prova").setVisible(true);
    }


    private String[] contents = {"Clicca col tasto destro sul pannello bianco per:\n     -> Creare un nuovo organo\n" +
                                 "     -> Aggiungere connessioni tra organi\n" +
                                 "     -> Rimuovere connessioni tra gli organi\n" +
                                 "     -> Chiudere il pannello","Clicca col tasto destro su un organo per:\n" +
                                 "     -> Aggiungere ruoli\n" +
                                 "     -> Rimuovere ruoli\n" +
                                 "     -> Visualizzare dettagli sui ruoli supportati\n" +
                                 "     -> Aggiungere dipendenti\n" +
                                 "     -> Rimuovere dipendenti\n" +
                                 "     -> Visualizzare dettagli sui dipendenti\n" +
                                 "     -> eliminare l'organo e tutte le sue connessioni"};
    private static final int GENERAL = 0, CHART = 1;
}
