package hotel;
public class person extends filemanager{
	protected String id;
	protected String PhoneNo;
	protected String Name;
	protected String Email;
	protected String Age;
	
	public void setID (String id)throws InvalidInputException
    {
         if (!id.matches("[0-9]{1,}"))
         {
        	 throw (new InvalidInputException("Invalid ID!"));
         }
         else{
            this.id = id;
         }
    }
	public void setPhoneNo (String PhoneNo)throws InvalidInputException
    {
         if (!PhoneNo.matches("[0-9]{8}|[0-9]{11}"))
         {
        	 throw (new InvalidInputException("Invalid Phone Number!"));
         }
         else{
            this.PhoneNo = PhoneNo;
         }
    }
	public void setName (String Name)throws InvalidInputException
    {
         if (!Name.matches("[a-zA-Z- ]+"))
         {
        	 throw (new InvalidInputException("Invalid Name!"));
         }
         else{
            this.Name = Name;
         }
    }
	public void setEmail (String Email)throws InvalidInputException
    {
		 if (!Email.contains("@") || !Email.contains("."))
         {
        	 throw (new InvalidInputException("Invalid E-Mail!"));
         }
         else{
            this.Email = Email;
         }
    }
	public void setAge (String Age)throws InvalidInputException
    {	
         if (!Age.matches("1[6-9]|[2-8][0-9]|9[0-9]"))
         {
        	 throw (new InvalidInputException("Invalid Age!"));
         }
         else{
            this.Age = Age;
         }
    }
	
	
	public String get_id()
	{
		return id;
	}
	public String get_PhoneNo()
	{
		return PhoneNo;
	}
	public String get_Name()
	{
		return Name;
	}
	public String get_Email()
	{
		return Email;
	}
	public String get_age()
	{
		return Age;
	}
}