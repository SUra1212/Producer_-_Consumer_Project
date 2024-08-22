package storekeeperproducer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

class SK{
	  private int Bno;
	  private String Bname;
	  private String BPname;
	  private String Bquantity;
	  private String Bprice;
	  private String r;
	  

	  SK(int Bno, String Bname, String BPname, String Bquantity,String Bprice, String r){
		 this.Bno = Bno;
	     this.Bname = Bname;
	     this.BPname = BPname;
	     this.Bquantity = Bquantity;
	     this.Bprice = Bprice;
	     this.r = r;
	  }
	  public int getBno(){
		     return Bno;
		  }

	  public String getBname(){
	     return Bname;
	  }
	  public String getBPname(){
	     return BPname;
	  }
	  public String getBquantity(){
	     return Bquantity;
	  }
	  public String getBprice(){
		     return Bprice;
		  }
	  

	  public String toString(){
	     return Bno+" "+Bname+" "+BPname+" "+Bquantity+" "+Bprice+" "+r;
	  }
	}


public class StoreKeeperImpl implements StoreKeeperInterface {
	  ArrayList<SK> c = new ArrayList<SK>();
	     Scanner S = new Scanner(System.in);
	     Scanner S1 = new Scanner(System.in);

	@Override
	public  void SellProducts(){
		 System.out.print("Enter Buyer Number: ");
		   int Bno = S.nextInt();
		   System.out.print("Enter Buyer Name : ");
		   String Bname = S1.nextLine();
           System.out.print("Enter Product Name : ");
           String BPname = S1.nextLine();
           System.out.print("Enter Quantity (KG) : ");
           String Bquantity = S.next();
           double q = Double.parseDouble(Bquantity);
           System.out.print("Enter The Price of 1KG : ");
           String Bprice = S.next();
           double w = Double.parseDouble(Bprice);
           double A = q;
           double B = w;
           double Bamount = A * B;
           String r = Double.toString(Bamount);
   		c.add(new SK(Bno,"\n"+"01- Buyert Name : \t"+Bname,"\n"+"02- Product Name :\t"+BPname,"\n"+"03- Quantity :\t \t"+Bquantity,"KG"+"\n"+"04- Price of 1KG :\t"+"RS."+Bprice,"\n"+"05- Amount :\t \t"+"RS."+ r));
		System.out.println("\n----------Successfully added!!!-------------\n");
	}
	
	@Override
	public void DisplayList() {
		  System.out.println("------------------------------------------------");
          Iterator<SK> i = c.iterator();
          while(i.hasNext()){
        	  SK e = i.next(); 
             System.out.println(e+"\n");
             
          }
          System.out.println("------------------------------------------------\n");
	}
	public void Search() {
		   boolean found = false;
           System.out.print("Enter Buyer Number to Search :");
           int Bno = S.nextInt();
           Iterator<SK> i = c.iterator();
           System.out.println("--------------------------------------------");
           i = c.iterator();
           while(i.hasNext()){
        	   SK e = i.next();
              if(e.getBno() == Bno)  {
                 System.out.println(e);
                 found = true;
              }
           }
           
           if(!found){
              System.out.println("Record Not Found");
           }
           System.out.println("-------------------------------------------");
	}
	public void Delete() {
        boolean found = false;
        System.out.print("Enter Buyer Number to Delete :");
        int Bno = S.nextInt();
        Iterator<SK> i = c.iterator();
        System.out.println("----------------------------");
        i = c.iterator();
        while(i.hasNext()){
        	SK e = i.next();
           if(e.getBno() == Bno)  {
              i.remove();
              found = true;
           }
        }
        
        if(!found){
           System.out.println("Record Not Found");
        }else{
           System.out.println("\n----Record is Deleted Successfully...!----\n");
        }

        System.out.println("----------------------------");
	}
	public void Update() {
        boolean found = false;
        System.out.print("Enter Buyer Number to Update :");
        int Bno = S.nextInt();
        ListIterator<SK> li = c.listIterator();
        while(li.hasNext()){
        	SK e = li.next();
           if(e.getBno() == Bno)  {
              System.out.print("Enter new Name : ");
              String Bname = S1.next();
              System.out.print("Enter new Product : ");
              String BPname = S1.next();
              System.out.print("Enter new Quantity : ");
              String Bquantity = S.next();
              double q = Double.parseDouble(Bquantity);
              System.out.print("Enter new Price : ");
              String Bprice = S.next();
              double w = Double.parseDouble(Bprice);
              double A = q;
              double B = w;
              double Bamount = A * B;
              String r = Double.toString(Bamount);
              li.set(new SK(Bno,"\n"+"01- Buyert Name : \t"+Bname,"\n"+"02- Product Name :\t"+BPname,"\n"+"03- Quantity :\t \t"+Bquantity,"KG"+"\n"+"04- Price of 1KG :\t"+"RS."+Bprice,"\n"+"05- Amount :\t \t"+"RS."+ r));
              found = true;
           }
        }
        
        if(!found){
           System.out.println("Record Not Found");
        }else{
           System.out.println("\n"+"-----Record is Updated Successfully...!-----"+"\n");
        }
	}
}

