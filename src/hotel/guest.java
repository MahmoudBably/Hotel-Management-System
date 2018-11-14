package hotel;
import java.util.*;
import java.io.*;
public class guest extends person implements Serializable {
    private String CCNo ;
    public  String check_inDate ;
    public  String check_outDate ;
    private String complaint ;
    public  int    NoOfRooms;
    public  String Deposite;
    public  int    NoOfComp;
    ArrayList <room> roomArr = new ArrayList <room>(); 
    ArrayList <person> persArr = new ArrayList <person>();
    ArrayList <service> servArr=new ArrayList<service>();
    ArrayList <food> foodArr = new ArrayList<food>();
    
    
    public void setCCNo (String CCNo) throws InvalidInputException
    {
         if (!CCNo.matches("[0-9]{15,15}") )
         {
        	 throw (new InvalidInputException("Invalid Credit Card Number!"));
         }
         else{
            this.CCNo = CCNo;
         }
    }
    public String getCCNo (){
         return CCNo ;
    }
    public void setCheckIn(String Check_inDate) throws InvalidInputException
    {
    	if(!Check_inDate.matches("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/((18|19|20|21)\\d\\d)"))
    	{
    		throw (new InvalidInputException("Invalid Date Format!"));
    	}
    	else{
    		this.check_inDate = Check_inDate;
    	}
    }
    public String getCheckIn(){
    	return check_inDate;
    }
    public void setCheckOut(String Check_OutDate) throws InvalidInputException
    {
    	if(!Check_OutDate.matches("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/((18|19|20|21)\\d\\d)"))
    	{
    		throw (new InvalidInputException("Invalid Date Format!"));
    	}
    	else{
    		this.check_outDate = Check_OutDate;
    	}
    }
    public String getCheckOut(){
    	return check_inDate;
    }


	public String getComplaint(){
		return complaint;
	}
}
