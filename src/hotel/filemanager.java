package hotel;
import java.io.*;
import java.util.*;
public class filemanager {

    public static <t> void update(t x, String id, String name) throws IOException, ClassNotFoundException {
        int i = 0;
        ArrayList<t> al = new ArrayList<t>();
        t temp;
        ObjectInputStream saver = new ObjectInputStream(new FileInputStream(name));
        al = (ArrayList) saver.readObject();
        saver.close();

        for (t l : al) {
            l = al.get(i);

            if (is_person(l) == 1) {
                person qw = (person) l;
                if (qw.id.equals(id)) {
                    al.set(i, x);
                }
            } else if (is_person(l) == 2) {
                room qw = (room) l;
                
                if (qw.id.equals(id)) {
                    al.set(i, x);
                }
            }

            {
                System.out.println("error");
            }
            i++;

        }

        ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(name));
        save.writeObject(al);
        save.close();
    }

    public static <t> void add(t x, String name) throws IOException, ClassNotFoundException {
        ArrayList<t> al = new ArrayList<t>();
       try{ ObjectInputStream saver = new ObjectInputStream(new FileInputStream(name));
        al = (ArrayList)saver.readObject();
        saver.close();}
       catch(Exception e){al=new ArrayList<t>();}
        al.add(x);
        ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(name));
        save.writeObject(al);
        save.close();

    }

    public static <t> void delete(t x, String id, String name) throws IOException, ClassNotFoundException {
        int i = 0;
        ArrayList<t> al = new ArrayList<t>();
        t temp;
        ObjectInputStream saver = new ObjectInputStream(new FileInputStream(name));
        al = (ArrayList) saver.readObject();
        saver.close();

        for (t l : al) {
            l = al.get(i);

            if (is_person(l) == 1) {
                person qw = (person) l;
                if (qw.id.equals(id)) {
                    al.remove(i);
                }
            } else if (is_person(l) == 2) {
                room qw = (room) l;
                if (qw.id.equals(id)) {
                    al.remove(i);
                }
            } else {
                System.out.println("error");
            }
            i++;

        }

        ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(name));
        save.writeObject(al);
        save.close();

    }

    public <T> T Search(T A, String id, String Name) throws  IOException, ClassNotFoundException {
        int i = 0;
        ObjectInputStream reader;
        reader = new ObjectInputStream(new FileInputStream(Name));
        ArrayList<T> read = (ArrayList<T>) reader.readObject();
        reader.close();
        for (T e : read) {
            e = read.get(i);

            if (is_person(e) == 1) {
                person qw = (person) e;
                if (qw.id.equalsIgnoreCase(id)) {
                    A = e;
                    return A;
                }
            } else if (is_person(e) == 2) {
                room qw = (room) e;
                if (qw.id.equalsIgnoreCase(id)) {
                    A = e;
                    return A;
                }
            } else {
                System.out.println("error");
            }
            i++;
        }
        return null;
    }

    private static <t> int is_person(t k) {
        if (k.getClass().getName() == "guest"||k.getClass().getName() == "manger"||k.getClass().getName() == "receptionist"||k.getClass().getName() == "customer_services"||k.getClass().getName() == "employee") {
            return 1;
        } else if (k.getClass().getName() == "room") {
            return 2;
        }

        return 0;
    }

}