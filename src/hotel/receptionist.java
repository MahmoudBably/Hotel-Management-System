package hotel;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
public class receptionist extends employee implements Serializable{
    public void checkIn(guest elm) throws IOException, ClassNotFoundException
    {add(elm,"guest.bin");
    }
    public guest searchGuest(String id) throws IOException, FileNotFoundException, ClassNotFoundException
    {guest elm=new guest();
    elm=Search(elm,id,"guest.bin");
    return elm;
    }
    public void checkOut(String id)throws IOException, FileNotFoundException, ClassNotFoundException
    { guest elm=new guest();
      bill bil=new bill();
      bil.generte_bill(id);
    delete(elm,id,"guest.bin");
    }
    public void updateGuest(guest elm)throws IOException, FileNotFoundException, ClassNotFoundException
    {
    update(elm,elm.id,"guest.bin");
    }
}
