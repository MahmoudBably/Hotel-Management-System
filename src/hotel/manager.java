package hotel;

import java.io.*;
import java.util.HashMap;

public class manager extends employee implements Serializable{
	 public  static HashMap<String,String> table;
    public void addEmployee(employee elm)throws IOException, FileNotFoundException, ClassNotFoundException
    {add(elm,"employee.bin");
    //addHash(elm.id,elm.password);
    }
     public void fireEmployee(String id)throws IOException, FileNotFoundException, ClassNotFoundException
    {
employee elm=new employee();
        delete(elm,id,"employee.bin");
}
     void addHash(String i, String pass) throws FileNotFoundException, IOException
     {

    	 HashMap<String,String> temp=new HashMap<String,String>();
    	 try{
    	 ObjectInputStream bin=new ObjectInputStream(new FileInputStream("hash.bin"));
    	temp=(HashMap<String,String>) bin.readObject();
    	bin.close();
    	 }
    	 catch(Exception e1)
    	 {
    		 temp=new HashMap<String,String>();
    	 }
    	 temp.put(i, pass);
    	 ObjectOutputStream save=new ObjectOutputStream(new FileOutputStream("hash.bin"));
    	 save.writeObject(temp);
    	 save.close();

     }
      public static <t> void update_person(t x, String id, String name) throws IOException, ClassNotFoundException 
     {update(x,id,name);
     }
      public <T> T Search_person(T A, String id, String Name) throws  IOException, ClassNotFoundException {
          return   Search(A,id,Name);
      }
      public void update_room(room elm,String id) throws IOException, ClassNotFoundException
      {update(elm,id,"room.bin");
      }
       public room Search_room(room A, String id) throws  IOException, ClassNotFoundException {
          
          return   Search(A,id,"room.bin");
      }
         public void update_service(service elm,String id) throws IOException, ClassNotFoundException
      {
     update(elm,id,"service.bin");
      }
       public service Search_service(service A, String id) throws  IOException, ClassNotFoundException {
          
          return   Search(A,id,"service.bin");
      }
         public void update_food(food elm,String id) throws IOException, ClassNotFoundException
      {update(elm,id,"food.bin");
      }
       public food Search_room(food A, String id) throws  IOException, ClassNotFoundException {
          
          return   Search(A,id,"food.bin");
      }
       
}
