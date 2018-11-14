package hotel;

import java.io.*;
import java.util.*;

public class customer_services implements Serializable {

    public void add_service(String id, service elm) throws IOException {
        int i = 0;
        ArrayList<guest> al = new ArrayList<guest>();
        try {
            ObjectInputStream saver = new ObjectInputStream(new FileInputStream("guest.bin"));
            al = (ArrayList) saver.readObject();
            saver.close();
        } catch (Exception e) {
            al = new ArrayList<guest>();
        }

        for (guest l : al) {
            l = al.get(i);
            if (l.id.equals(id)) {
                l.servArr.set(i, elm);
            }
            i++;
        }
        ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("guest.bin"));
        save.writeObject(al);
        save.close();

    }
     public void add_service(String id, food elm) throws IOException {
        int i = 0;
        ArrayList<guest> al = new ArrayList<guest>();
        try {
            ObjectInputStream saver = new ObjectInputStream(new FileInputStream("guest.bin"));
            al = (ArrayList) saver.readObject();
            saver.close();
        } catch (Exception e) {
            al = new ArrayList<guest>();
        }

        for (guest l : al) {
            l = al.get(i);
            if (l.id.equals(id)) {
                l.foodArr.set(i, elm);
            }
            i++;
        }
 ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("guest.bin"));
        save.writeObject(al);
        save.close();
    }
      
     
}
