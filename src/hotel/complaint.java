
package hotel;

import java.io.*;
import java.util.*;

public class complaint {
    public void recieve_complaint(String com,guest per) throws IOException {
        ArrayList<String> al = new ArrayList<String>();
        try {
            ObjectInputStream saver = new ObjectInputStream(new FileInputStream("complaint.bin"));
            al = (ArrayList) saver.readObject();
            saver.close();
        } catch (Exception e) {
            al = new ArrayList<String>();
        }
        String compe;
compe=per.id +"#"+per.Name+"#"+com;
      al.add(compe);
 ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("guest.bin"));
        save.writeObject(al);
        save.close();
    }
      public void show_complaint() throws IOException {
        ArrayList<String> al = new ArrayList<String>();
        try {
            ObjectInputStream saver = new ObjectInputStream(new FileInputStream("complaint.bin"));
            al = (ArrayList) saver.readObject();
            saver.close();
        } catch (Exception e) {
            al = new ArrayList<String>();
        }
String com=al.get(0);
al.remove(0);
 ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("guest.bin"));
        save.writeObject(al);
        save.close();
    }
    
}
