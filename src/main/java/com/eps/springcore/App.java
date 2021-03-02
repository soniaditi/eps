package com.eps.springcore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.eps.springcore.db.DoctorDao;
import com.eps.springcore.db.DoctorDaoImpl;
import com.eps.springcore.db.DrugDao;
import com.eps.springcore.db.DrugDaoImpl;
import com.eps.springcore.db.OrderDao;
import com.eps.springcore.db.OrderDaoImpl;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NumberFormatException, IOException
    {
    	AbstractApplicationContext context =new ClassPathXmlApplicationContext("com/eps/springcore/epsconfig.xml");
    	DoctorDao doctor= (DoctorDaoImpl)context.getBean("doctor1");
    	DrugDao drug=(DrugDaoImpl)context.getBean("drug1");
    	OrderDao order=context.getBean("order1",OrderDaoImpl.class);
    	Pharmacy pharma=context.getBean("pharmacy", Pharmacy.class);
    	int choice=0;
   		Scanner sc= new Scanner(System.in);
   		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Doctors doc= new Doctors();
       // int result=doctor.update(doc);
////        doc.getDocDetails();
////        int result=doctor.insert(doc);
////        System.out.println("doctor updated "+result);
       // doc=doctor.SearchByFname("moto");
        
       
//        Drug  drugs= new Drug();
//        drugs= drug.SearchByName("metformin");
////        drugs.getDrugDetails();
////        int result=drug.insert(drugs);
//       List<Drug> drugList= drug.getOutOfStockDrugList();
//       for(Drug d:drugList) {
//    	   System.out.println(d);
//       }
//      int rs=drug.totalOrderCount();
//      System.out.println(rs);
      
      
  		
  		
  		
  		
  		
  		do {
  			System.out.println("**************Welcome to Pharmacy Records********************");
  			System.out.println("Enter 1 to see menu for Drug Table");
  			System.out.println("Enter 2 to see menu for Doctor table");
  			System.out.println("Enter 3 to see menu for Order table");
  			System.out.println("Enter 4 to see pharmacy details");
  			System.out.println("Enter 5 to EXIT");
  			System.out.println("Enter your choice");
  			choice=sc.nextInt();
  			switch(choice) {
  			case 1:
  				System.out.println("**************Welcome to Drug Table Menu********************");
  				System.out.println("Enter 1 to add a Drug to the table");
  				System.out.println("Enter 2 to update a Drug record using id");
  				System.out.println("Enter 3 to Delete a Drug");
  				System.out.println("Enter 4 to know the list of out of stock drugs");
  				System.out.println("Enter 5 to search a drug by name");
  				System.out.println("Enter 6 search a drug by its brand");
  				System.out.println("Enter 7 to Exit the drug table menu");
  				System.out.println("Enter your choice: ");
  				int drugChoice = sc.nextInt();
  				switch(drugChoice) {
  				case 1:
  					Drug drugobj1=new Drug();
  			        drugobj1.getDrugDetails();
  			        int result=drug.insert(drugobj1);
  			        System.out.println("no of rows affected "+result);
  					break;
  				
  				case 2:
  					Drug drugobj2=new Drug();
  			       drug.updateById(drugobj2);
  			       System.out.println("Drug updated successfuly!!");
  			       System.out.println(drugobj2);
  				break;
  				case 3:
  					System.out.println("enter the drug id you want to delete");
  					int id=sc.nextInt();
  					int res=drug.delete(id);
  					System.out.println("no of rows effected "+res);
  					System.out.println("Record deleted succesfully");
  				break;
  					
  				case 4:
  					List<Drug> outOfStockdrugList= drug.getOutOfStockDrugList();
   			        for(Drug d:outOfStockdrugList) {
   			    	   System.out.println(d);
   			       }
  					break;
  				case 5:
  					System.out.println("Enter the Drug name you want to search");
  					String dName= br.readLine();
  					Drug drugobj3=drug.SearchByName(dName);
  					
  					break;
  				case 6: 
  					System.out.println("Enter the Drug brand you want to search");
  					String bName=  br.readLine();
  					Drug drugobj4=drug.SearchByBrand(bName);
  					break;
  				case 7: 
					System.out.println("Exiting Drug Table menu....");
					break;
  				default:
  					System.out.println("WRONG CHOICE");
  					break;
  				}
  				break;
  			
  			case 2:
  				System.out.println("**************Welcome to Doctor's Menu********************");
  				System.out.println("Enter 1 to add Doctors in the databse");
  				System.out.println("Enter 2 to update Doctors record in the database");
  				System.out.println("Enter 3 to Delete a Doctors record");
  				System.out.println("Enter 4 to search a Doctor by First name");
  				System.out.println("Enter 5 to search a Doctor by Last name");
  				System.out.println("Enter 6 to EXIT this menu");
  				System.out.println("Enter your choice: ");
  				int DoctorChoice = sc.nextInt();
  				switch(DoctorChoice) {
  					case 1:
  						Doctors doc1= new Doctors();
  						doc1.getDocDetails();
  	  			        int result=doctor.insert(doc1);
  	  			        System.out.println("no of rows affected "+result);
  						
  						break;
  					case 2:
  						Doctors doc2= new Doctors();
  	  			        int res=doctor.update(doc2);
  	  			        List<Doctors> docList= doctor.getAllDoctorsRecord();
  	  			        for(Doctors dr:docList) {
  	  			    	   System.out.println(dr);
  	  			        }
  						break;
  					case 3:
  						System.out.println("enter the doctor Id you want to delete");
  	  					int id=sc.nextInt();
  	  					int rs=doctor.delete(id);
  	  					System.out.println("no of rows effected "+rs);
  	  					System.out.println("Record deleted succesfully");
  						break;
  					case 4:
  						System.out.println("Enter the Doctor First name you want to search");
  	  					String fName= br.readLine();
  	  					Doctors doc3=doctor.SearchByFname(fName);
  	  					System.out.println(doc3);
  						break;
  					case 5: 
  						System.out.println("Enter the Doctor Last name you want to search");
  	  					String lName= br.readLine();
  	  					Doctors doc4=doctor.SearchByLname(lName);
  	  					System.out.println(doc4);
  						break;
  					case 6: 
  						System.out.println("Exiting Doctor Table menu....");
  						break;
  					default:
  						System.out.println("WRONG CHOICE");
  						break;
  				}
  				break;
  			case 3:
  				System.out.println("**************Welcome to Order's Menu********************");
  				System.out.println("Enter 1 to Place order");
  				System.out.println("Enter 2 to see all orders");
  				System.out.println("Enter 3 to see all pending orders");
  				System.out.println("Enter 4 to update order status");
  				System.out.println("Enter 5 to EXIT this menu");
  				System.out.println("Enter your choice: ");
  				int OrderChoice = sc.nextInt();
  				switch(OrderChoice) {
  					case 1:
  						List<Drug> outOfStockdrugList= drug.getOutOfStockDrugList();
  	   			        for(Drug d:outOfStockdrugList) {
  	   			    	   System.out.println(d);
  	   			        }
  						order.placeOrder();
  						break;
  					case 2:
  	  			        List<Order> orderlist= order.getAllOrders();
  	  			        for(Order o:orderlist) {
  	  			    	   System.out.println(o);
  	  			        }
  						break;
  					case 3:
  						List<Order> orderlist1= order.getPendingOrdersList();
  						if(orderlist1!=null) {
  						
  							for(Order o:orderlist1) {
  								System.out.println(o);
  							}
  						}
  						break;
  					case 4:
  						System.out.println("Enter the drug name whose order status you want to update");
  						String name=br.readLine();
  						System.out.println("Enter the order status (complete or pending)");
  						String status=br.readLine();
  						order.updateOrderStatus(name, status);
  						break;
  						
  					case 5: 
  						System.out.println("Exiting Order Table menu....");
  						break;
  					default:
  						System.out.println("WRONG CHOICE");
  						break;
  				}
  				break;
  			case 4:
  				System.out.println(pharma);
  				System.out.println();
  				break;
  				
  			case 5:
  				System.out.println("Thank you");
  				break;
  			default:
  				System.out.println("oopss!!you have entered the wrong choice. Please try again!");
  				break;
  			}
  		}while(choice!=5);
  	
    
	}
}
