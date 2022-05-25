package persistence;

import logical_unit.organizzation_charts.Connection;
import presentation.chart_rappresentation.Rappresentation;
import presentation.chart_rappresentation.RappresentationPanel;
import presentation.chart_rappresentation.SimpleChartRappresentation;

import java.awt.Component;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public enum PersistenceUnit implements Persistence{
    MANAGER;

    @Override
    public void save(RappresentationPanel p) {
        File dir = new File(Persistence.orgChartDyrectory);
        if(!dir.isDirectory())
            dir.mkdirs();
        File file = new File(dir.getAbsolutePath()+"/"+p.getFileName());
        try {
            file.createNewFile();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            for(Component c: p.getComponents())
                if(c instanceof Rappresentation){
                    Rappresentation r = (Rappresentation) c;
                    oos.writeObject(new Record(r.getSubject(),r.getPosition(), r.getLocation()));
                }
            for( Connection con: p.getConnections() )
                oos.writeObject(new ConnectionRecord(con.getHead().getSubject().getName(),
                                                     con.getTail().getSubject().getName(),
                                                     con.getStartX(),con.getStartY(),
                                                     con.getEndX(), con.getEndY()));
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void read(File f, List<Record> rappresentations, List<ConnectionRecord> connections) {
        try{
            if(f == null)
                return;
            if(rappresentations == null)
                rappresentations = new LinkedList<>();
            if(connections == null)
                rappresentations = new LinkedList<>();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            while(true){
                try{
                    Object o = ois.readObject();
                    if(o instanceof Record)
                        rappresentations.add((Record)o );
                    else
                        if(o instanceof ConnectionRecord)
                            connections.add((ConnectionRecord) o);
                }catch(EOFException e){
                    break;
                }
            }
            ois.close();
        }catch(IOException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"errore nella lettura del file");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



}
