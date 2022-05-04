import java.io.*; 
        import java.util.*;
        //-----------Class Unit--------------------//
        class Units
        {
            private String Suburb;       
            private String Address;    
            private String BuildingName;   
            private String BuildingNumber; 
            private String PostCode; 
            private String Bathroom;    
            private String Photoes;    
            private String Parking;     
            private int Area;          
            private int Rate;           
            private boolean Booked;
            private boolean Cancel; 
            private String CXName;    
            private String CXAddress;     
            private String CXPhone;       
             private static int Count;   //Nu Units Added
        public Units ()  
            {
                Suburb        = null;
                Address    = null;
                BuildingName    = null;
               BuildingNumber  = null;
                PostCode         = null;
                Cancel      = false;
                Bathroom    = null;
                Photoes     = null;
                Parking     = null;
                Area        = 0;
                Rate        = 0;
                Booked      = false;
                CXName    = null;
                CXAddress     = null;
                CXPhone       = null;
              
                Count       = Count + 1;
            }
        
        public Units (String strSuburb, 
        		String strAddress, 
        		String strBuildingName, 
        		String strBuildingNumber, 
        		String strPostCode,
        		String strBathroom, 
        		String strParking,
        		String strPhotoes, int intArea, int intRate)
            {
                Suburb        = strSuburb;
                Address    = strAddress;
                BuildingName    = strBuildingName;
                BuildingNumber  = strBuildingNumber;
                PostCode         = strPostCode;
                Cancel      = false;
                Bathroom    = strBathroom;
                Photoes     = strPhotoes;
                Parking     = strParking;
                Area        = intArea;
                Rate        = intRate;
                Booked      = false;
                CXName    = null;
                CXAddress     = null;
                CXPhone       = null;
                
                Count       = Count + 1;        
            }
        
            public void SeeUnits()
            {
                Formatter fmt = new Formatter();
                System.out.println("Suburb          : " + Suburb);
                System.out.println("Unit Address  : " + Address);
                System.out.println("Building Name : " + BuildingName);
                System.out.println("Building Number   : " + BuildingNumber);
                System.out.println("Parking       : " + Parking);
                System.out.println("Building Area   : " + Area);
                System.out.println("Rate Rs./Square.Feet: " + Rate);
                System.out.println("Unit Cost:Rs " + fmt.format("%,.2f", (float)(Area*Rate)));
                System.out.print("Property Booked   : ");
                if(Booked==true) 
                    System.out.println(CXName+"; "+ CXAddress+"; "+ CXPhone); 
                else
                    System.out.println("No");
            }
        
            public static int getUnitsCount()
            {
                return Count;
            }
        
            public boolean getUnitBookingInfo()
            {
                return Booked;
            }
            public boolean getUnitCancelationInfo()
            {
                return Cancel;
            }
        
            public void CXInfo(String strCustomerName, String strCustomerAddress, String strPhone)
            {
                CXName    = strCustomerName;
                CXAddress     = strCustomerAddress;
                CXPhone       = strPhone;
                
                Booked      = true;
                Cancel = true; 
            }
        }
        //-----------------------------Class Real Estate  ------------------------------------------------
        public class Real_Estate
        {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader (isr);
        
            int MAXUnits=30;
                    
            Units UNITS[] = new Units[30];
            Scanner sc = new Scanner(System.in);
        
            public void main()throws IOException
            {
        
                    
                int choice = 0;    // get the user choice
                choice = sc.nextInt();
    			sc.nextLine();
                System.out.println();
        
                
                System.out.println("Welcome Real Estate Agency");

        
                
                System.out.println("\n\n");
                
                LoadUnitsInfo();
                
        ///Look Again/////////////////////////////////////////
                while(true)
                {
                    do
                    {
                        System.out.println( " **********  Menu  ********** ");
                        System.out.println("    1 Customer");
                        
                        System.out.println("    2 Exit ");
                        
                        try
                        {   
                            System.out.print("Enter your choice? ");
                            choice = Integer.parseInt(br.readLine());
                        }
                        catch(NumberFormatException e)
                        {
                            System.out.println("******************************");
                            System.out.println(" please enter a number only");
                            System.out.println("******************************");
                        }
                    }while(choice < 1 || choice > 2);
        
                    if(choice == 2) 
                    {
                        System.out.println("Good bye.");
                        System.exit(0);
                    }
        
                    if(choice == 1) 
                        Menu();
                   
                }
       }   
           //////////////////////////////// // Main Menu //////////////////////////////////////////////////
            
            
            
        
            void Menu() throws IOException
            {
                InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader (isr);
        
                int ch = 0;
                String pass ="realestate";
                
                
                while(true) /////////////////// what is the condition ///////////////
                {
        
                    do
                    {
                        System.out.println( "\t ********** Menu *********\n");
                        System.out.println();
                        System.out.println(" 1 Add New Unit Info");
                        System.out.println(" 2 Add the valuation of the price of a house");
                        System.out.println(" 3 Add a house as ready for inspection");
                        System.out.println(" 4 Add offer for buying a house by a potential buyer");
                        System.out.println();
                        System.out.println(" 5 Show list of all the newly recorded houses");
                        System.out.println(" 6 list of all the houses that are yet to have a photographer");
                        System.out.println(" 7 schedule a house “open for inspection” time");
                        System.out.println(" 8 cancel a scheduled “open for inspection” for a house");
                        System.out.println(" 9 Show a list of the scheduled inspections");
                        System.out.println(" 10 Show all the current Offers");
                        System.out.println(" 11 Add a house as contracted for sale");
                        System.out.println(" 12 Show a list of all houses that have been contracted for sale");
                        System.out.println();
                        try
                        {
                            System.out.print("Enter your choice? ");
                            ch = Integer.parseInt(br.readLine());
                        }
                        catch(NumberFormatException e)
                        {
                           
                            System.out.println("Number only  between 1 to 11 ");
                            
                        }
                    }while(ch < 1 || ch > 11);
        
                    switch(ch)
                    {
                        case 1: AddNewUnitInfo();
                        break;
                        case 2: AddPricevaluationInfo();
                        break;
                        case 3: AddReadyInspectionInfo();
                        break;
                        case 4: AddOfferInfo();
                        break;
        
                        case 5: ShowUnitsInfo();
                        break;
                        case 6: ShowHousenNoPhtotoesInfo();
                        break;
                        case 7: BookInspection();
                        break;
                        case 8: CancelInspection();
                        break;
                        case 9: ShowSchedualInfo();
                        break;
                        case 10: ShowOffersInfo();
                        break;
                        case 11: AddSaleHouseInfo();
                        break;
                        case 12: ShowSaleHouseInfo();
                        break;
                        case 13: return;
                    }
                }
            }
           
       }
        
            
            
            
        
            
            
            
           
            
        
            void LoadUnitsInfo() 
            {
                UNITS[0]=new Units("Frankston", "Whatley st", "EastlinkApartment", "A-1", "3", "1", "1", "No", "Common Parking only", 1000, 2500);
                UNITS[1]=new Units("Berwick", "McLoed Rd", "MonashApartment", "B-3", "1", "2", "1", "No", "Private 4 wheeter Parking + Common Parking", 800, 4000);
                UNITS[2]=new Units("Hallam", "Pricess Highway", "GippslandApartment", "C-5", "4", "1", "1", "No", "Common Parking only", 1200, 3500);
            }
        
            void ShowOneUnitInfo(int i)
            {
                System.out.println("------- Information about Unit: " + (i+1) + "---------------");
                Units[i].ShowUnit();   
                System.out.println("******* End of Information about Unit: " + (i+1) + "********\n");
       }
        /////////Case 5 ////////////// incomplete 
            void ShowUnitsInfo() throws IOException
            {
                int i,n;
                n=Units.getUnitsCount();
                System.out.print("Enter Unit Number: ");
                i = Integer.parseInt(br.readLine());
        
                if(i<0 || i>n)
                {
                    System.out.println("Incorrect number entered.");
                    return;
                }
        
                if(i == 0)
                {
                    for(i=0; i<n; i++)
                    {
                        ShowOneUnitInfo(i);   
                    }        
                }
                else
                {
                    ShowOneUnitInfo(i-1);   
                }
       }
        
            
            //////////////////////Case 1 ////////////////////////////
            void AddNewUnitInfo() throws IOException 
            {
                int n ,  int intArea = 0 , int intRate = 0 ;
                n=Units.getUnitsCount();
        
                try
                {
                    if(n<MAXUnits)
                    {
                        System.out.println("Enter Information for New Property: " + n);
                    }
                    else
                    {
                        System.out.println("Maximum No.of Properties.");
                        return;
                    }
                    System.out.print("Enter Suburb Name: ");
                    String strSuburb = br.readLine();
        
                    System.out.print("Enter  Address: ");
                    String strAddress = br.readLine();
        
                    System.out.print("Enter Building Name: ");
                    String strBuildingName  = br.readLine();
        
                    System.out.print("Enter Building tNumber: ");
                    String strBuildingNumber = br.readLine();
        
                    System.out.print("Enter PostCode: ");
                    String strPostCode = br.readLine();
        
                   
                    System.out.print("Enter No.of Bathroom: ");
                    String strBathroom =br.readLine();
        
                    System.out.print("Enter No.of Photoes: ");
                    String strPhotoes =br.readLine();
        
                    System.out.print("Enter Parking Description: ");
                    String strParking =br.readLine();
                    try
                    {
                        System.out.print("Enter Area(Square.Feet): ");
                        intArea = Integer.parseInt(br.readLine());
            
                        System.out.print("Enter Rate (Rs/Square.Feet): ");
                        intRate = Integer.parseInt(br.readLine());
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println("******************************");
                        System.out.println(" Number value only ");
                      
                    }
                
        
                    UNITS[n]=new Units(strSuburb, 
                    		 strAddress, 
                    		 strBuildingName, 
                    		 strBuildingNumber, 
                    	  strPostCode,
                     strBathroom, 
                    		 strParking,
                    		 strPhotoes,  intArea,  intRate);
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    System.out.println("******************************");
                    System.out.println("Max Units number is  30");
                  
                }
       }
        ////////////////////Case 7/////////////////////////// ADD DATES AND TIME //// j unit tests at least two 
            void BookInspection()throws IOException
            {
                int i, n , ;
                n=Units.getUnitsCount();
                try
                {
                    System.out.print("Enter Property Number for Booking: ");
                    i = Integer.parseInt(br.readLine());
                    i=i-1;
        
                    if(i<0 || i>=n)
                    {
                        System.out.println("Incoorect, Please Try again");
                        return;
                    }
                    if(UNITS[i].BookInspection()==true)
                    {
                        System.out.println("Sorry. Unit already booked");            
                    }
        
                    ShowOneUnitInfo(i);
        
                    System.out.print("Enter Customer Name   : ");
                    String strCustomerName = br.readLine();
        
                    System.out.print("Enter Customer Address: ");
                    String strCustomerAddress=br.readLine();
        
                    System.out.print("Enter Customer Phone  : ");
                    String strPhone = br.readLine();
                  
                    UNITS[i].saveCustInfo(strCustomerAddress, strCustomerName, strPhone);
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Enter number only: ");
                    return;
                }
        ///////////// case 8 /////////////
                
                void CancelInspection()throws IOException
                {
                    int i, n  ;
                    n=Units.getUnitsCount();
                    try
                    {
                        System.out.print("Enter Property Number for Cancelling: ");
                        i = Integer.parseInt(br.readLine());
                        i=i-1;
            
                        if(i<0 || i>=n)
                        {
                            System.out.println("Incoorect, Please Try again");
                            return;
                        }
                        if(UNITS[i].CancelInspection()==true)
                        {
                            System.out.println("Sorry. Unit already Cancelled");  } 
                            
                            else {  
                            
                            	ShowOneUnitInfo(i);
                            System.out.print("Enter the unit number ");
                            String strCustomerName = br.readLine();
                           UNITS[i].CancelInspection() = i - n ;
         



                            
                        }
            
                        
                        
                        
                        
                        
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println("Enter number only: ");
                        return;
                    }
            
                
       }
/////////////// Case 2////////////////////////
            
            void  AddPricevaluationInfo()throws IOException {
            	
            	
            	
            	
            }
            
           
            
            
           
                
                
                   
        }
}
