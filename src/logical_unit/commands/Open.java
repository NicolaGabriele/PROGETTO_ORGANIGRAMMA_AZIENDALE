package logical_unit.commands;

import logical_unit.organizzation_charts.Connection;
import persistence.ConnectionRecord;
import persistence.PersistenceUnit;
import persistence.Record;
import presentation.MainFrame;
import presentation.chart_rappresentation.Rappresentation;
import presentation.chart_rappresentation.RappresentationPanel;
import presentation.chart_rappresentation.SimpleChartRappresentation;

import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Open implements Command{


    private MainFrame mainFrame;

    public Open(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void execute() {
        JFileChooser fileChooser = new JFileChooser("./organizzationChart");
        fileChooser.setDialogTitle("scegli il file");
        fileChooser.showDialog(null,"select");
        File f = fileChooser.getSelectedFile();
        List<Record> rappresentations = new LinkedList<>();
        List<ConnectionRecord> connections = new LinkedList<>();
        PersistenceUnit.MANAGER.read(f,rappresentations,connections);
        RappresentationPanel p = new RappresentationPanel(mainFrame.getUserDetailsPanel(),
                                                          mainFrame.getAddConnectionPanel(),
                                                          f.getName());
        List<Rappresentation> aux = new LinkedList<>();
        for(Record r: rappresentations){
            Rappresentation rap = new SimpleChartRappresentation(r.getElement(),
                                                                 mainFrame);
            rap.setPosition(r.getPosition());
            rap.setLocation(r.getLocation());
            aux.add(rap);
            p.add(rap);
        }

        for(ConnectionRecord cr: connections){
            Rappresentation head = null, tail = null;
            for(Rappresentation rappresentation: aux) {
                if (cr.getC1().equals(rappresentation.getSubject().getName()))
                    head = rappresentation;
                else if (cr.getC2().equals(rappresentation.getSubject().getName()))
                    tail = rappresentation;
            }
            if(head != null && tail != null) {
                p.addConnection(new Connection(head, tail, cr.getStartX(), cr.getStartY(), cr.getEndX(), cr.getEndY()));
                head.setMovable(false);tail.setMovable(false);
            }
        }

        mainFrame.tab().addTab(p.getFileName(), new JScrollPane(p));
        p.repaint();
    }
}
