package hotel;
import java.util.*;
import java.io.*;

public class Hotel {

	public static void main(String[] args) throws Exception {
            employee emp1 = new employee();
            manager mng1 = new manager();
            receptionist rcp1 = new receptionist();
            
            String Ch,id,password;
            Scanner SC1 = new Scanner (System.in);
            boolean Try = false;
            do{
                System.out.printf("LogIn As \n1. Manager  \n2. Receiptiontist \n3. Customer Service Employee\npress any key to Exit..\n");
                Ch = SC1.next();
                int resCh;
                
                switch (Ch){
                    case "1":
                        System.out.print("Enter your id : ");
                        id=SC1.next();
                        
                        System.out.print("\nEnter your password :");
                        password=SC1.next();
                        
                        if( emp1.login(id ,password) ){
                            Try = false;
                            System.out.println("\nWelcome");
                            System.out.println();
                            boolean cont=true;
                            do{
                                System.out.printf("1.Record Complain\n2.Add Employee\n3.Fire Employee\n4.Log Out\n");
                                resCh=SC1.nextInt();
                                switch (resCh){
                                    case 2:
                                        System.out.println("Enter His ID ,Salary ,Position ,Password and Shift");
                                        String empID,Salary,Position,Password,Shift;
                                        empID = SC1.next();
                                        Salary = SC1.next();
                                        Position = SC1.next();
                                        Password = SC1.next();
                                        Shift = SC1.next();
                                        
                                        emp1.setNID(empID);
                                        emp1.setPosition(Position);
                                        emp1.setSalary(Salary);
                                        emp1.setShift(Shift);
                                        
                                        mng1.addHash(empID, Password);
                                        mng1.addEmployee(emp1);
                                        break;
                                        
                                    case 3:
                                        System.out.println("Enter The ID Of The Employee You Wanna Fire");
                                        String empID2;
                                        empID2 = SC1.next();
                                        mng1.fireEmployee(empID2);
                                        break;
                                        
                                    case 4:
                                        Try = true;
                                        cont = false;
                                }
                            }while (cont);
                        }
                        else{
                            System.out.println("Id OR password isn't correct....Try Again");
                            Try = true;
                        }
                        break ;
                        
                    case "2":
                        System.out.print("Enter your id : ");
                        id=SC1.next();
                        
                        System.out.print("\nEnter your password : ");
                        password=SC1.next();
                        
                        if( emp1.login(id,password) ){
                            Try = false;
                            System.out.println("\nWelcome");
                            System.out.println();
                            boolean cont=true;
                            do{
                                System.out.printf("1.Check In\n2.Show Bill\n3.Check Out\n4.Search Guest\n5.Log Out\n");
                                resCh = SC1.nextInt();
                                switch(resCh){
                                    case 1:
                                        guest g = new guest ();
                                        System.out.println("Enter The Guest's CCNo ,Check In Date ,Check Out Date ,Number Of The Rooms He Wants ,Number Of His Company and The Deposite He Left");
                                        String CCNo,check_inDate,check_outDate,Deposite;
                                        int NoOfRooms,NoOfComp;
                                        
                                        CCNo = SC1.next();
                                        check_inDate = SC1.next();
                                        check_outDate = SC1.next();
                                        NoOfRooms = SC1.nextInt();
                                        NoOfComp = SC1.nextInt();
                                        Deposite = SC1.next();
                                        
                                        g.setCCNo(CCNo);
                                        g.setCheckIn(check_inDate);
                                        g.setCheckOut(check_outDate);
                                        g.NoOfRooms = NoOfRooms;
                                        g.NoOfComp = NoOfComp;
                                        g.Deposite = Deposite;
                                        
                                        rcp1.checkIn(g);
                                        
                                        System.out.println("Guest Added To The System!");
                                        break;
                                        
                                    case 3:
                                        System.out.println("Enter The ID Of The Checking Out Guest");
                                        String gID;
                                        gID = SC1.next();
                                        
                                        rcp1.checkOut(gID);
                                        
                                        System.out.println("The Guest Has Been Deleted From The System!");
                                        break;
                                        
                                    case 4:
                                        guest tempG = new guest ();
                                        System.out.println("Enter The ID Of The Guest");
                                        String gID2 = SC1.next();
                                        tempG = rcp1.searchGuest(gID2);
                                        System.out.println("His CCNo Is : " + tempG.getCCNo() + "\n" + " Check In Date : " + tempG.getCheckIn() + "\n" + " Check Out Date : " + tempG.getCheckOut() + "\n" + " Number Of Rooms : " + tempG.NoOfRooms + "\n" + " Number Of Company : " + tempG.NoOfComp + "\n" + " The Amount Of The Deposite : " + tempG.Deposite);
                                        
                                        break ;
                                        
                                    case 5:
                                        Try = true;
                                        cont = false;
                                }
                            }while (cont);
                            
                        }
                        else {
                            System.out.println("Id OR password isn't correct....Try Again");
                            Try = true;
                        }
                        break ;
                        
                    case "3":
                        System.out.print("Enter your id : ");
                        id=SC1.next();
                        
                        System.out.print("\nEnter your password : ");
                        password=SC1.next();
                        
                        if( emp1.login(id,password) ){
                            Try = false;
                            System.out.println("\nWelcome");
                            System.out.println();
                            boolean cont=true;
                            do{
                                System.out.printf("1.Add Service\n2.Make Order\n3.Receive Complaint\n4.log Out\n");
                                resCh = SC1.nextInt();
                                
                                switch (resCh){
                                    case 1:
                                        service Serv1 = new service ();
                                        guest tempG2 = new guest ();
                                        String gID3;
                                        
                                        System.out.println("Enter The ID Of The Guest That Wants A Service Then Enter The ID ,Name and Price Of The Service");
                                        gID3 = SC1.next();
                                        Serv1.id = SC1.nextInt();
                                        Serv1.name = SC1.next();
                                        Serv1.price = SC1.nextDouble();
                                        
                                        tempG2 = rcp1.searchGuest(gID3);
                                        tempG2.servArr.add(Serv1);
                                        
                                        rcp1.updateGuest(tempG2);
                                        
                                        System.out.println("Service Has Been Added");
                                        break;
                                        
                                }
                                
                            }while(cont);
                        }
                        else {
                            System.out.println("Id OR password isn't correct....Try Again");
                            Try = true;
                        }
                        break;
                        
                    default :
                        Try = false;
                }//End Switch Ch
            }while (Try);
            SC1.close();
	}
}
