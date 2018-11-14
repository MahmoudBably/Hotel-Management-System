package hotel;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;

public class employee extends person implements Serializable {
	public  String Position;
	private String Salary;
	private String NID;
	private String password;
	private String shift;

	public void setPosition(String Position)throws InvalidInputException
    {
         if (!Position.matches("Customerservice|Manager|Receptionist|customerservice|manager|receptionist"))
         {
        	 throw (new InvalidInputException("Invalid Position!"));
         }
         else{
            this.Position = Position;
         }
    }
	public void setSalary (String Salary) throws InvalidInputException
    {
         if (!Salary.matches("[1-9][0-9]{3,4}||100000"))
         {
        	 throw (new InvalidInputException("Invalid Salary Value!"));
         }
         else{
            this.Salary = Salary;
         }
    }
	public void setNID(String NID) throws InvalidInputException
	{
		if(!NID.matches("[0-9]{14,14}"))
		{
			throw (new InvalidInputException("Invalid National ID Number! (14 Digits)"));
		}
		else{
			this.NID = NID;
		}
	}
	public void setShift (String Shift) throws InvalidInputException
    {
         if (!Shift.matches("Morning|Night|morning|night") )
         {
        	 throw (new InvalidInputException("Invalid Shift Value!"));
         }
         else{
            this.shift = Shift;
         }
    }
public boolean login(String id,String p)
{
	boolean islog=false;
	HashMap<String,String> temp=new HashMap<String,String>();
	 try{
	 ObjectInputStream bin=new ObjectInputStream(new FileInputStream("hash.bin"));
	temp=(HashMap<String,String>) bin.readObject();
	bin.close();
	if(p.equalsIgnoreCase(temp.get(id)))islog=true;
	 }
	 catch(Exception e1)
	 {
         e1.getMessage();
	 }
	 return islog;
}

}
