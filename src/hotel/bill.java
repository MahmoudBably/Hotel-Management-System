
package hotel;

import java.io.*;
import java.util.*;


public class bill implements Serializable{
     public float total_cash(String id) throws IOException, ClassNotFoundException {
     float total_cash=0; int i=0;
     filemanager mange=new filemanager();
     guest per=new guest();
     per=mange.Search(per,id,"guest.bin");
    
for(food el:per.foodArr)
{   el = per.foodArr.get(i);
    total_cash+=el.price;
    i++;
}
i=0;
for(service el:per.servArr)
{   el=per.servArr.get(i);
    total_cash+=el.price;
i++;
}
StringTokenizer tookchIn=new StringTokenizer(per.check_inDate,"-");
           int inDay,inMon,inYear;long nights;
           inDay =Integer.parseInt((String)tookchIn.nextElement());
           inMon =Integer.parseInt((String)tookchIn.nextElement());
           inYear =Integer.parseInt((String)tookchIn.nextElement());
           StringTokenizer tookchOut=new StringTokenizer(per.check_outDate,"-");
            int outDay,outMon,outYear;
           outDay =Integer.parseInt((String)tookchOut.nextElement());
           outMon =Integer.parseInt((String)tookchOut.nextElement());
           outYear =Integer.parseInt((String)tookchOut.nextElement());
    
           Calendar calendar1 = Calendar.getInstance();
    Calendar calendar2 = Calendar.getInstance();
    calendar1.set(inYear,inMon,inDay);
    calendar2.set(outYear,outMon,outDay);
    long milliseconds1 = calendar1.getTimeInMillis();
    long milliseconds2 = calendar2.getTimeInMillis();
    long diff = milliseconds2 - milliseconds1;
     nights = diff / (24 * 60 * 60 * 1000);
     i=0;
        for(room elm :per.roomArr)
        { elm=per.roomArr.get(i);
        total_cash+=(nights*elm.price);
        i++;
        }
          

     return total_cash;}

public void generte_bill(String id) throws IOException, ClassNotFoundException
{float total_cash=0;
total_cash=total_cash(id);
filemanager mange=new filemanager();
     guest per=new guest();
     per=mange.Search(per,id,"guest.bin");

}

}