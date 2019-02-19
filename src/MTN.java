
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import java.util.logging.Logger;
import javax.swing.JOptionPane;



class MTN{
 String meter_type,hrs ="yyyy/mm/dd";
int confirm,option;       
     long pin,userID,month,meter_no;
long Account_num,bank,Card_No,transit;

long tran,Transpin;
   long Amount;
    long phone,phonenum,phoney;


     
    Scanner sc = new Scanner(System.in);
public void start(){
 String ussd;
 String a;
 a="*555#";
      Scanner sc = new Scanner(System.in);
 System.out.print("Enter USSD:");
 ussd =(String) sc.nextLine();
 if("*555#".equals(ussd)){
        menu();
 }else {
     System.out.println("Invalid MMI code");
 }
 

     
}
public void menu(){
int option;
System.out.println("Welcoome to Quickteller");
    System.out.println("---------------------------");
    System.out.println("Choose the options:");
  System.out.println("1. Create Transaction Pin" );
   System.out.println("2. Transfer funds");
   System.out.println("3. Bill payment");
   System.out.println("4. Mobile Recharge");
 System.out.println("5. SportsBet payment");
 System.out.println("6. Exit Transaction");
 System.out.println("");
   System.out.print("choose the option: ");
  option = sc.nextInt();

switch(option){

    case 1: Createpin();
        break;
    case 2: transFund();
    break;
    case 3:billpay();
    break;
    case 4:mobilerech();
    break;
    // case 5:bet9ja();
//    break;
     case 6:exit();
    break;
    default:System.out.print("invalid MMI code");
    menu();
    break;
   
}
}

     void Createpin() {
           System.out.print("Enter your Transaction pin:");
          tran = sc.nextLong();
          System.out.print("Confirm your Transaction pin:");
          Transpin =sc.nextLong();
          if( tran == Transpin){
              
       phonenumb();
          }else{
              
                  System.out.println("Transaction pin not valid");
          }
    }

  
       void phonenumb(){
            
                 try {
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
          Statement st = con.createStatement();
          
          
 
  System.out.print("Enter your phone Number:");
             phoney = sc.nextLong();
             System.out.println("");
             
             
             
             
              System.out.println("Confirm your phone Number:");
              phone =sc.nextLong();
              
              String sql= "SELECT * from secure where phone ='"+phone+"'";
              
            ResultSet rs = st.executeQuery(sql);
                      
             
        if ( rs.next() )
        {
            
                    System.out.println("this device already has a Transaction pin");
                    phonenumb();
                } else {
                db();
             menu();
                }
        
            
        con.close();
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
     }
       }
       
       
    

     
          void transFund() { 
              Scanner sc = new Scanner(System.in);
              System.out.print("Enter Amount:");
              Amount = sc.nextLong();
              System.out.println("");
                               try {
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
          Statement st = con.createStatement();
          
          
 
 System.out.print("Enter Account No:");
                Account_num=sc.nextLong();
              
              String sql= "SELECT * from Bankdetails where Account_num ='"+Account_num+"'";
              
            ResultSet rs = st.executeQuery(sql);
                      
             
        if ( rs.next() )
        {
beneficiary();
                } else {
                                    System.out.println("This Account number does not Exist"); 
               transFund();
                }
        
            
        con.close();
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
                     System.out.println("");
     }
       
          }
          
      
                  void beneficiary(){
 System.out.println("Choose Beneficiary Bank");
 System.out.println("----------------------------");
 System.out.println("1. Access Bank");
 System.out.println("2. GT Bank");
 System.out.println("3. First Bank");
 System.out.println("4. Diamond Bank");
 System.out.println("5. Fidelity Bank");
 System.out.println("6. FCMB");
 System.out.println("7. UBA Bank");
 System.out.println("8. Eco Bank");
 System.out.println("9. Standard Chartered Bank");
 System.out.println("10. Sun Bank");
  System.out.println("11.Keystone Bank");
   System.out.println("");
   System.out.print("choose the option: ");
  option = sc.nextInt();

    switch(option){
    case 1: bacc();
        break;
    case 2: bgtb();
    break;
    case 3:bfirst();
    break;
     case 4: bdiamond();
    break;
     case 5: bfidel();
    break;
      case 6: bfcmb();
        break;
          case 7: buba();
        break;
          case 8: beco ();
        break;
          case 9: bscb();
        break;
          case 10: bsun();
          break;
          case 11: bkey();
          break;
     case 12:exit();
    break;
    default:System.out.print("invalid MMI code");
    menu();
    }
          }
          
  void bacc() {
      Scanner sc = new Scanner(System.in);
                                     try {
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
          Statement st = con.createStatement();
          
          
 
System.out.print("Enter card No:");
      Card_No =sc.nextLong();
              
              String sql= "SELECT * from Bankdetails where Card_No ='"+Card_No+"'";
              
            ResultSet rs = st.executeQuery(sql);
                      
             
        if ( rs.next() )
        {
            
               Confirm();
                } else {
                                    System.out.println("Your Card Number does not Exist"); 
                menu();
                }
        
            
        con.close();
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
                     System.out.println("");
                           System.out.println("");
     }
  }
          
            void Confirm(){
      System.out.println("Confirm Transaction");
       System.out.println("Amount-"+Amount);
        System.out.println("Account number-"+Account_num);
        System.out.println("");
        System.out.println("");
      System.out.println("1. Yes");
      System.out.println("2. No");
      confirm= sc.nextInt();
      
      switch(confirm){ 
          
          
          case 1: yes();
          break;
          case 2: No();
          break;
          default:System.out.print("invalid MMI code");
      }
  }
          void yes() {  
                        try {
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
          Statement st = con.createStatement();
          
        System.out.print("Please input Transaction pin:");
        Transpin = sc.nextLong();
             String sql= "SELECT * from secure where Transpin ='"+Transpin+"'";
              
            ResultSet rs = st.executeQuery(sql);
                      
             
        if ( rs.next() )
        {
          
            db2();  upbank();
               System.out.println("Transaction Successfull ");
        }else{
            System.out.println("please input correct Transaction pin");
            yes();
        }    
        con.close();
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
     }
       }
            
         
        
         void No() {
         transFund();
    }

    
    
     void bgtb() {
              Scanner sc = new Scanner(System.in);
                                        try {
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
          Statement st = con.createStatement();
          
          
 
System.out.print("Enter card No:");
      Card_No =sc.nextLong();
              
              String sql= "SELECT * from Bankdetails where Card_No ='"+Card_No+"'";
              
            ResultSet rs = st.executeQuery(sql);
                      
             
        if ( rs.next() )
        {
               Confirm();
                } else {
                                    System.out.println("Your Card Number does not Exist"); 
                menu();
                }
        
            
        con.close();
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
                     System.out.println("");
                           System.out.println("");
     }
  }

     void bfirst() {
              Scanner sc = new Scanner(System.in);
                                         try {
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
          Statement st = con.createStatement();
          
          
 
System.out.print("Enter card No:");
      Card_No =sc.nextLong();
              
              String sql= "SELECT * from Bankdetails where Card_No ='"+Card_No+"'";
              
            ResultSet rs = st.executeQuery(sql);
                      
             
        if ( rs.next() )
        {
               Confirm();
                } else {
                                    System.out.println("Your Card Number does not Exist"); 
                menu();
                }
        
            
        con.close();
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
                     System.out.println("");
                           System.out.println("");
     }
  }
          
     
 

     void bdiamond() {
           Scanner sc = new Scanner(System.in);
                                          try {
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
          Statement st = con.createStatement();
          
          
 
System.out.print("Enter card No:");
      Card_No =sc.nextLong();
              
              String sql= "SELECT * from Bankdetails where Card_No ='"+Card_No+"'";
              
            ResultSet rs = st.executeQuery(sql);
                      
             
        if ( rs.next() )
        {
               Confirm();
                } else {
                                    System.out.println("Your Card Number does not Exist"); 
                menu();
                }
        
            
        con.close();
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
                     System.out.println("");
                           System.out.println("");
     }
  }
     void bfcmb() {
             Scanner sc = new Scanner(System.in);
                                        try {
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
          Statement st = con.createStatement();
          
          
 
System.out.print("Enter card No:");
      Card_No =sc.nextLong();
              
              String sql= "SELECT * from Bankdetails where Card_No ='"+Card_No+"'";
              
            ResultSet rs = st.executeQuery(sql);
                      
             
        if ( rs.next() )
        {
               Confirm();
                } else {
                                    System.out.println("Your Card Number does not Exist"); 
                menu();
                }
        
            
        con.close();
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
                     System.out.println("");
                           System.out.println("");
     }
  }

     void bfidel() {
             Scanner sc = new Scanner(System.in);
                                           try {
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
          Statement st = con.createStatement();
          
          
 
System.out.print("Enter card No:");
      Card_No = sc.nextLong();
              
              String sql= "SELECT * from Bankdetails where Card_No ='"+Card_No+"'";
              
            ResultSet rs = st.executeQuery(sql);
                      
             
        if ( rs.next() )
        {
               Confirm();
                } else {
                                    System.out.println("Your Card Number does not Exist"); 
                menu();
                }
        
            
        con.close();
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
                     System.out.println("");
                           System.out.println("");
     }
  }

    void buba() {
              Scanner sc = new Scanner(System.in);
                                        try {
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
          Statement st = con.createStatement();
          
          
 
System.out.print("Enter card No:");
      Card_No =sc.nextLong();
              
              String sql= "SELECT * from Bankdetails where Card_No ='"+Card_No+"'";
              
            ResultSet rs = st.executeQuery(sql);
                      
             
        if ( rs.next() )
        {
               Confirm();
                } else {
                                    System.out.println("Your Card Number does not Exist"); 
                menu();
                }
        
            
        con.close();
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
                     System.out.println("");
                           System.out.println("");
     }
  }
     void beco() {
              Scanner sc = new Scanner(System.in);
                                           try {
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
          Statement st = con.createStatement();
          
          
 
System.out.print("Enter card No:");
      Card_No = sc.nextLong();
              
              String sql= "SELECT * from Bankdetails where Card_No ='"+Card_No+"'";
              
            ResultSet rs = st.executeQuery(sql);
                      
             
        if ( rs.next() )
        {
               Confirm();
                } else {
                                    System.out.println("Your Card Number does not Exist"); 
                menu();
                }
        
            
        con.close();
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
                     System.out.println("");
                           System.out.println("");
     }
  }
    void bscb() {
             Scanner sc = new Scanner(System.in);
                                        try {
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
          Statement st = con.createStatement();
          
          
 
System.out.print("Enter card No:");
      Card_No =sc.nextLong();
              
              String sql= "SELECT * from Bankdetails where Card_No ='"+Card_No+"'";
              
            ResultSet rs = st.executeQuery(sql);
                      
             
        if ( rs.next() )
        {
               Confirm();
                } else {
                                    System.out.println("Your Card Number does not Exist"); 
                menu();
                }
        
            
        con.close();
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
                     System.out.println("");
                           System.out.println("");
     }
  }

     void bsun() {
             Scanner sc = new Scanner(System.in);
                                            try {
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
          Statement st = con.createStatement();
          
          
 
System.out.print("Enter card No:");
      Card_No = sc.nextLong();
              
              String sql= "SELECT * from Bankdetails where Card_No ='"+Card_No+"'";
              
            ResultSet rs = st.executeQuery(sql);
                      
             
        if ( rs.next() )
        {
               Confirm();
                } else {
                                    System.out.println("Your Card Number does not Exist"); 
                menu();
                }
        
            
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
                     System.out.println("");
                           System.out.println("");
     }
  }

     void bkey() {
          Scanner sc = new Scanner(System.in);
                                        try {
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
          Statement st = con.createStatement();
          
          
 
System.out.print("Enter card No:");
      Card_No =sc.nextLong();
              
              String sql= "SELECT * from Bankdetails where Card_No ='"+Card_No+"'";
              
            ResultSet rs = st.executeQuery(sql);
                      
             
        if ( rs.next() )
        {
               Confirm();
                } else {
                                    System.out.println("Your Card Number does not Exist"); 
                menu();
                }
        
            
        con.close();
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
                     System.out.println("");
                           System.out.println("");
     }
  }
void success() {
       System.out.println(" successfull "); 
     }


     void billpay() {
          Scanner sc= new Scanner(System.in);
                int option;
    
               System.out.println("*Select Bill*");
               System.out.println();
               System.out.println("1. Dstv:");
               System.out.println("2. Gotv");
               System.out.println("3. power holding");
               System.out.println("4. custom duties");
               System.out.println("5. smile subsciption");
                System.out.println("6. spectranet subsciption");
                System.out.println("7. Nysc");
                System.out.println("8. Metro digital subsciption");
                System.out.println("9. Tstv subsciption");
                System.out.println("10. exit");
                option = sc.nextInt();
                
                 switch(option)        
                        {
                        case 1: dstv();
					break;
	  case 2: gotv();
					break;
                        case 3: powerHolding();
					break;
                        case 4: customDuties();
					break;
                        case 5: smileSubscription();
					break;  
                        case 6: spectranetSubsciption();
					break;
                        case 7: nysc();
					break; 
                        case 8: metroDigital();
					break;
                        case 9: tstv();
					break; 
                            
	  case 10: exit();
					break;
			default: System.out.println("Invalid Option. Press 1,2,3,4 or 5");
					System.out.println();
					menu();
                 
                 }
              
                 
              }
                     
               
                        
                         void dstv() {
                             System.out.println("Select package");
                             System.out.println("");
                             System.out.println("1.Access+1month-2000");
                             System.out.println("2.Family+1month-5000");
                             System.out.println("3.Compact+1month-8000");
                             System.out.println("4.Compact plus+1month-11000");
                             System.out.println("5.Premium+1month-14000");
                             System.out.println("6.Exit");
                             option = sc.nextInt();
                             switch(option){
                                 
                                 case 1: am();
                                 break;
                                 case 2: fm();
                                 break;
                                 case 3:cm();
                                 break;
                                 case 4: cpm();
                                 break;
                                 case 5: pm();
                                 break;
                                 case 6: exit();
                                 break;
                                 default:System.out.println("invalid option");
                             }
    }
                    
                        
                                            
                                              
                         void am() {
System.out.print("Enter Number of months:");
month=sc.nextLong();
System.out.println("");
System.out.println("Enter Amount:");
Amount =sc.nextLong();
    }

    private void fm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cpm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void pm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
                         
                         }  
                                            
                        
                                            
                        
                        
                         public void gotv(){
                        
                        }
                         
                         public void powerHolding(){
                             System.out.println("choose meter type");
                             System.out.println("");
                             System.out.println("1.Prepaid meter");
                             System.out.println("");
                             System.out.println("2.Postpaid meter");
                             option = sc.nextInt();
                                               if(option == 1){
                                 meter_type="Prepaid";
                             }else{
                                 meter_type ="Postpaid";
                         }
                             switch(option){
             
                                 case 1:prem();
                                 break;
                                 case 2:posm();
                                 break;
                                 default:System.out.println("invalid choice");
                                 powerHolding();
                                 break;
                             }
}
                         
 void prem(){ 
       System.out.print("Enter meter number:");
                         meter_no =sc.nextLong();
                         System.out.println("");
          System.out.println("Enter Amount:");
                                       Amount =sc.nextLong();
                                       System.out.println("");
            System.out.print("Enter Card  No:");
                                          Card_No =sc.nextLong();
                                          Co();
 }
                                          
                                          
                                            void Co(){
      System.out.println("Confirm Transaction");
       System.out.println("Amount-"+Amount);
        System.out.println("Meter Number-"+meter_no);
        System.out.println("Meter type-"+meter_type);
        System.out.println("");
      System.out.println("1. Yes");
      System.out.println("2. No");
      confirm= sc.nextInt();
      
      switch(confirm){ 
          
          
          case 1: ye();
          break;
          case 2: Noo();
          break;
          default:System.out.print("invalid MMI code");
      }
                                            }

          void ye() {  
                        try {
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
          Statement st = con.createStatement();
          
        System.out.print("Please input Transaction pin:");
        Transpin = sc.nextLong();
             String sql= "SELECT * from secure where Transpin ='"+Transpin+"'";
              
            ResultSet rs = st.executeQuery(sql);
                      
             
        if ( rs.next() )
        {
          
       pn();
       upbank();
               System.out.println("Transaction Successfull ");
        }else{
            System.out.println("please input correct Transaction pin");
            yes();
        }    
        con.close();
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
     }
       
 
          
}
         void Noo() {
         Co();
    }

                  
                        void pn(){        
                                   try {
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
          Statement st = con.createStatement();
          
   
                                          
                                       
                                   
                                          
            
             String sql= "SELECT * from PHCN where meter_no ='"+meter_no+"'";
              
            ResultSet rs = st.executeQuery(sql);
            
            
             
        if ( rs.next() ) 
        {
            
            con();
            
        }else{
            System.out.println("Transaction failed ");
            
            System.out.println("please re-check details ");
            
        }
        con.close();
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
     }
       
                                               
                             }

                             
                             void con(){
                                  try {
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
          Statement st = con.createStatement();
                                          
            String sql= "SELECT * from Bankdetails where Card_No ='"+Card_No+"'";
            
              
            ResultSet rs = st.executeQuery(sql);
            
            
             
        if ( rs.next() ) 
        {
            phcnbank();
            phcn();
            System.out.println("Transaction successfully");
            
        }else{
            System.out.println("Transaction failed ");
            
            System.out.println("please re-check details-----and Try again ");
            
        }
        con.close();
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
     }
                                  
                                  
                             }     
                                  void posm(){
                                 prem();
                             }
       
                                     
                             
                             
                    
                         
                        
                        
                         
                         public void customDuties(){
                        
                        }
                         
                         public void smileSubscription(){
                        
                        }
                         
                         public void spectranetSubsciption(){
                        
                        }
                         
                         public void nysc(){
                        
                        }
                         
                         public void metroDigital(){
                        
                        }
                         
                         public void tstv(){
                        
                        } 
                         
                         void exit(){
                             
                         }
                         
                         
                         
                         

    
           
                         void mobilerech(){
                             int option;
                     
                         System.out.println("Select Mobile network");
                         System.out.println("");
                         System.out.println("1.MTN");
                         System.out.println("2.GLO");
                         System.out.println("3.AIRTEL");
                         System.out.println("4.9mobile");
                         System.out.println("5.Exit");
                         System.out.println("");
                         option = sc.nextInt();
                         
                         switch(option){
                             
                             case 1:mtn();
                             break;
                             case 2:glo();
                             break;
                             case 3:airtel();
                             break;
                             case 4: mobile();
                             break;
                             case 5:exit();
                             break;
                         }
                         }
                         
                           void mtn() {
                           
                        
                               System.out.print("Enter Amount:");
                                System.out.println("");
                               Amount =sc.nextLong();
                                   System.out.println("");
                                       System.out.print("Enter Mobile Number:");
                                           System.out.println("");
                                       phone =sc.nextLong();
                                           System.out.println("");
                                                try {
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
          Statement st = con.createStatement();
          
    System.out.print("Enter Card  No:");
                                               Card_No =sc.nextLong();
             String sql= "SELECT * from Bankdetails where Card_No ='"+Card_No+"'";
              
            ResultSet rs = st.executeQuery(sql);
                      
             
        if ( rs.next() )
        {
               Confirmtran();
        }else{
            System.out.println("Card number does not exist");
       
        }    
        con.close();
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
     }
                           }
       
       
       
       
       private void glo() {
      
                               System.out.print("Enter Amount:");
                                System.out.println("");
                               Amount = sc.nextLong();
                                   System.out.println("");
                                       System.out.print("Enter Mobile Number:");
                                           System.out.println("");
                                       phone = sc.nextLong();
                                           System.out.println("");
                                                try {
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
          Statement st = con.createStatement();
          
    System.out.print("Enter Card  No:");
                                               Card_No =sc.nextLong();
             String sql= "SELECT * from Bankdetails where Card_No ='"+Card_No+"'";
              
            ResultSet rs = st.executeQuery(sql);
                      
             
        if ( rs.next() )
        {
               Confirmtran();
        }else{
            System.out.println("Card number does not exist");
       
        }    
        con.close();
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
     }
                           
    }

    void mobile() {
        
                               System.out.print("Enter Amount:");
                                System.out.println("");
                               Amount =sc.nextLong();
                                   System.out.println("");
                                       System.out.print("Enter Mobile Number:");
                                           System.out.println("");
                                       phone =sc.nextLong();
                                           System.out.println("");
                                                try {
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
          Statement st = con.createStatement();
          
    System.out.print("Enter Card  No:");
                                               Card_No =sc.nextLong();
             String sql= "SELECT * from Bankdetails where Card_No ='"+Card_No+"'";
              
            ResultSet rs = st.executeQuery(sql);
                      
             
        if ( rs.next() )
        {
               Confirmtran();
        }else{
            System.out.println("Card number does not exist");
       
        }    
        con.close();
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
     }
                           
    }

 

    private void airtel() {
        
                               System.out.print("Enter Amount:");
                                System.out.println("");
                               Amount =sc.nextLong();
                                   System.out.println("");
                                       System.out.print("Enter Mobile Number:");
                                           System.out.println("");
                                       phone =sc.nextLong();
                                           System.out.println("");
                                                try {
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
          Statement st = con.createStatement();
          
    System.out.print("Enter Card  No:");
                                               Card_No =sc.nextLong();
             String sql= "SELECT * from Bankdetails where Card_No ='"+Card_No+"'";
              
            ResultSet rs = st.executeQuery(sql);
                      
             
        if ( rs.next() )
        {
               Confirmtran();
        }else{
            System.out.println("Card number does not exist");
       
        }    
        con.close();
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
     }
                           
    }
                            
                           
                           
                           
     void yesm(){
                                 try {
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
          Statement st = con.createStatement();
          
        System.out.print("Please input Transaction pin:");
        Transpin =sc.nextLong();
             String sql= "SELECT * from secure where Transpin ='"+Transpin+"'";
              
            ResultSet rs = st.executeQuery(sql);
                      
             
        if ( rs.next() )
        {
            upbank();
            dbm();
               System.out.println("Transaction Successfull ");
        }else{
            System.out.println("please input correct Transaction pin");
            yesm();
        }    
        con.close();
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
     }
       
     }                      
    void  db() {
    try{
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
           PreparedStatement ps = con.prepareStatement("INSERT INTO secure(Transpin,phone) VALUES(?,?)");
                
ps.setLong(1, Transpin);
ps.setLong(2,phone);

ps.executeUpdate();   
con.close();      
}catch(Exception e){
e.printStackTrace();
}
}
      void  db2() {
    try{
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
           PreparedStatement ps = con.prepareStatement("INSERT INTO Transfund(Transdate,Amount,Card_No) VALUES(?,?,?)");
           
 
           DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
           Date date = new Date();
        
           String Transdate = df.format(date);

ps.setString(1, Transdate);
ps.setLong(2,Amount);
ps.setLong(3,Card_No);


ps.executeUpdate();   
con.close();      
}catch(Exception e){
e.printStackTrace();
}
}
      void dbm(){
             try{
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
           PreparedStatement ps = con.prepareStatement("INSERT INTO mobile(Amount,phone) VALUES(?,?)");
           
 

ps.setLong(1, Amount);
ps.setLong(2,phone);


ps.executeUpdate();   
con.close();      
}catch(Exception e){
e.printStackTrace();
}
      }
      
 
            void Confirmtran(){
                                                System.out.println("Confirm Transaction");
       System.out.println(Amount);
        System.out.println("phone number"+phone);
        System.out.println("");
        System.out.println("");
      System.out.println("1. Yes");
      System.out.println("2. No");
      confirm= sc.nextInt();
      
      switch(confirm){
          
          
          case 1: yesm();
          break;
          case 2: No();
          break;
          default:System.out.print("invalid MMI code");
      }
                           }
            
            
            
                 void upbank(){
                         try{
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
 PreparedStatement ps = con.prepareStatement( "update Bankdetails "+ "set Current_Balance =Current_Balance-"+Amount+""+ " where Card_No="+Card_No+"");
                
ps.executeUpdate();   
con.close();      
}catch(Exception e){
e.printStackTrace();
}
                 }
                 
                 
                           void phcnbank(){
                         try{
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
 PreparedStatement ps = con.prepareStatement( "update Bankdetails "+ "set Current_Balance =Current_Balance+"+Amount+""+ " where Account_num=1234567888");
                
ps.executeUpdate();   
con.close();      
}catch(Exception e){
e.printStackTrace();
}
                 }
                 
                         
void  phcn() {
    try{
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
           PreparedStatement ps = con.prepareStatement("INSERT INTO PHCNcust(Transdate,meter_no,Amount,meter_type) VALUES(?,?,?,?)");
           
 
           DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
           Date date = new Date();
        
           String Transdate = df.format(date);

ps.setString(1, Transdate);
ps.setLong(2,meter_no);
ps.setLong(3,Amount);
ps.setString(4,meter_type);


ps.executeUpdate();   
con.close();      
}catch(Exception e){
e.printStackTrace();
}
                 }
                 
            
    
     public static void main(String[] args){
         MTN mn = new MTN();
         mn.start();
     }



  

}

  

  /* 
    private void backup() {                        try {
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=MTN; user=Francis;password=BLACCOP2000");
          Statement st = con.createStatement();
          
             String sql= "update Bankdetails "
                     + "set Current_Balance =Current_Balance-'"+Amount+"'"
                     + " where Card_No='"+Card_No+"'";
              
            ResultSet rs = st.executeQuery(sql);
                      
             
    
        con.close();
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
     }
       
     }  
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

   













void user(){
  
    Scanner sc = new Scanner(System.in);
    System.out.println("1.Enter UserID");
    System.out.println("2.create new UserID");
    System.out.println("");
    
    System.out.print("reply:");
    user=sc.nextInt();
    switch(user){
           case 1:use();
    break;
     case 2:notuse();
    break;
    default:System.out.println("invalid MMI code");
   start();
    break;
    }
}

void notuse(){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter new UserID:");
    newuser=sc.nextInt();
    System.out.println("");
    System.out.println("");
    System.out.println("Confirm UserID");
    userID=sc.nextInt();
    if(userID==newuser){
        dbu();
        menu();
    }else{
        System.out.println("Invalid UserID");
    }
}

            void use(){
    Scanner sc=new Scanner(System.in);
        System.out.print(" UserID:");
        userID=sc.nextInt();
        
        System.out.println("connection started");
           try {
  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=MTN; user=Francis;password=BLACCOP2000");
            System.out.println("conection succeeded");
            String qry ="SELECT * from userid ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(qry);
        while ( rs.next() )
        {
            System.out.println("READ  the table");
            int id = rs.getInt("userID");
            if ( userID== id ) {      
                    System.out.println("Welcome to Quikteller");
                    menu();
                
                } else {
                    System.out.println(" incorrect userID");
                }
        }
 
        con.close();
        } catch(ClassNotFoundException f) {
            System.out.println(f.toString());
        } catch (SQLException ex) {
         Logger.getAnonymousLogger();
     }
        

      
}
         


 void  db() {
    try{
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=MTN; user=Francis;password=BLACCOP2000");
           PreparedStatement ps = con.prepareStatement("INSERT INTO secure(Transpin,phone) VALUES(?,?,?)");
                
ps.setInt(1, Transpin);
ps.setInt(2,phone);

ps.executeUpdate();   
con.close();      
}catch(Exception e){
e.printStackTrace();
}
}
 
  void  phcn() {
    try{
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qteller; user=Francis;password=BLACCOP2000");
           PreparedStatement ps = con.prepareStatement("INSERT INTO PHCNcust(Transdate,meter_no,Amount,meter_type) VALUES(?,?)");
           
 
           DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
           Date date = new Date();
        
           String Transdate = df.format(date);

ps.setString(1, Transdate);
ps.setInt(2,meter_no);
ps.setLong(3,Amount);
ps.setString(4,meter_type);


ps.executeUpdate();   
con.close();      
}catch(Exception e){
e.printStackTrace();
}
}
  

void dbu () {
        try{
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=MTN; user=Francis;password=BLACCOP2000");
           PreparedStatement ps = con.prepareStatement("INSERT INTO userid(userID) VALUES(?)");
           
 


ps.setInt(1,userID);

ps.executeUpdate();   
con.close();      
}catch(Exception e){
e.printStackTrace();
}
}

  void db3() {
                       
        try {
  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=MTN; user=Francis;password=BLACCOP2000");
            Statement st = con.createStatement();
            ResultSet rec = st.executeQuery("SELECT  from secure where userID=' '");
 
        while (rec.next()) {
           rec.getInt( phone);
  
            if (phone== rec.getInt(phone)) {      
                    System.out.println("welcome");
                } else {
                    System.out.println(" incorrect userID");
                }
        }
 
        con.close();
        } catch(ClassNotFoundException f) {
            System.out.println(f.toString());
        } catch (SQLException ex) {
         Logger.getLogger(mtn2.class.getName()).log(Level.SEVERE, null, ex);
     }*/