package persistence;

import presentation.chart_rappresentation.RappresentationPanel;

import javax.swing.*;
import java.io.*;

public enum PersistenceUnit implements Persistence{
    MANAGER;

    @Override
    public void save(RappresentationPanel element) {
            if(element == null)
                throw new IllegalArgumentException("non posso salvare elementi null");
            File dir = new File(Persistence.orgChartDyrectory);
            if(!dir.isDirectory())
                dir.mkdirs();
            File file = new File(dir.getAbsolutePath()+"/"+element.getFileName());
        try {
            file.createNewFile();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(element);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public RappresentationPanel read(File f) {
        try{
            if(!f.exists())
                return null;

            return (RappresentationPanel) (
                    new ObjectInputStream(new FileInputStream(f)).readObject()
                    );
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"errore nella lettura del file");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
