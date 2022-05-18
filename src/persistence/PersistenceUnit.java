package persistence;

import logical_unit.organizzation_charts.OrganizzationChart;

import java.io.*;

public enum PersistenceUnit implements Persistence{
    MANAGER;

    @Override
    public void save(OrganizzationChart element) {
            if(element == null)
                throw new IllegalArgumentException("non posso salvare elementi null");
            File dir = new File(Persistence.orgChartDyrectory);
            if(!dir.isDirectory())
                dir.mkdirs();
            File file = new File(dir.getAbsolutePath()+"/"+element.getName());
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
    public OrganizzationChart read(File f) {
        try{
            return (OrganizzationChart) new ObjectInputStream(new FileInputStream(f)).readObject();
        }catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
