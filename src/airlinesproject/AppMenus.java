package airlinesproject;

import static Printers.BoxPrinter.BoxPrinter;
import static airlinesproject.DatabaseAccess.DataBaser;
import static airlinesproject.DatabaseAccess.DataBaserInsert;
import static airlinesproject.DatabaseAccess.GetMaxId;
import static airlinesproject.DatabaseAccess.GetMaxIdCustomer;
import static airlinesproject.DatabaseAccess.GetMaxIdFlight;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AppMenus {

    public static void Menu() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, InterruptedException, IOException {
        java.util.Date date = new java.util.Date();
        System.out.println("               +----------------------------------------+\n"
                + "               |             CONTROL PANEL              | \n"
                + "+--------------------------------------------------------------------------+\n"
                + "| (1) Insert something into the database                                   |\n"
                + "| (2) Get flight by company name                                           |\n"
                + "| (3) Get all fully booked flights                                         |\n"
                + "| (4) Get flights from YYZ to JFK                                          |\n"
                + "| (5) Insert reservation                                                   |\n"
                + "| (6) Pay and updated reservation                                          |\n"
                + "| (7) Delete cancelled reservations                                        |\n"
                + "|                                                                          |\n"
                + "|                                                         (EXIT) - LOGOUT  |\n"
                + "+--------------------------------------------------------------------------+");

        System.out.println("\nSELECT YOUR OPTION:   (BY TYPING:1,2,3,4,5,6,7) -- TYPE \"EXIT\" TO LOGOUT\n");
        Scanner rec = new Scanner(System.in);
        String selection = rec.nextLine();

        while (!"1".equalsIgnoreCase(selection) && !"2".equalsIgnoreCase(selection) && !"3".equalsIgnoreCase(selection) && !"4".equalsIgnoreCase(selection) && !"5".equalsIgnoreCase(selection) 
                && !"EXIT".equalsIgnoreCase(selection) && !"6".equalsIgnoreCase(selection) && !"7".equalsIgnoreCase(selection)) {
            BoxPrinter("INVALID CHOICE");
            System.out.println("PLEASE SELECT ONE OF THE ABOVE OPTIONS");
            selection = rec.nextLine();

        }
        if ("EXIT".equalsIgnoreCase(selection)) {
            System.exit(0);
        }

        if ("1".equals(selection)) {
            BoxPrinter("Please select what to insert (1=flight, 2=customer)");
            String ch = rec.nextLine();
            
            if (ch.equalsIgnoreCase("1")) {

                int flight_id = GetMaxIdFlight("flights") + 1;

                BoxPrinter("Please enter flight number.");
                String flight_number = rec.nextLine();

                BoxPrinter("Please enter company ID.");
                String company_id = rec.nextLine();

                BoxPrinter("Please enter if smoking (0,1).");
                String has_smoking = rec.nextLine();

                BoxPrinter("Please enter num business seats.");
                String buss = rec.nextLine();
                
                BoxPrinter("Please enter num economy seats.");
                String econ = rec.nextLine();

                BoxPrinter("Please enter from airport");
                String fr = rec.nextLine();
                        
                BoxPrinter("Please enter to airport");
                String to = rec.nextLine();

                BoxPrinter("Please enter departure time");
                String departure = rec.nextLine();
                
                BoxPrinter("Please enter flight duration");
                String duration = rec.nextLine();

                
                DataBaserInsert("INSERT INTO flights (flight_id,flight_number,company_id,has_smoking,num_business_class,num_business_reserved,"
                        + "num_economy,num_economy_reserved,from_airport,to_airport,departure_time,flight_duration) VALUES (" + flight_id + "," + 
                        flight_number + "," + company_id + "," + has_smoking + "," 
                        + buss + ",'" + 0 + "'," + econ + "," + 0 + "," + fr + "," + to +",'" + departure + "'," + duration + ");");

                System.out.println("Flight Added ! WOULD YOU LIKE TO RETURN TO THE MAIN MENU?(Y/N)");
                Scanner scanner = new Scanner(System.in);
                String CHOICE = scanner.nextLine();

                if ("Y".equalsIgnoreCase(CHOICE) || "YES".equalsIgnoreCase(CHOICE)) {
                    Menu();            
                }
            }
            
            if (ch.equalsIgnoreCase("2")) {

                int customer_id = GetMaxIdCustomer("customers") + 1;

                BoxPrinter("Please enter customer firstname.");
                String firstname = rec.nextLine();

                BoxPrinter("Please enter customer lastname ID.");
                String lastname = rec.nextLine();

                BoxPrinter("Please enter customer email.");
                String email = rec.nextLine();
                
                BoxPrinter("Please enter customer address.");
                String address = rec.nextLine();

                DataBaserInsert("INSERT INTO customers (customer_id,firstname,lastname,email,address) VALUES (" + customer_id + ",'" + 
                        firstname + "','" + lastname + "','" + email + "','" 
                        + address + "');");

                System.out.println("Customer Added ! WOULD YOU LIKE TO RETURN TO THE MAIN MENU?(Y/N)");
                Scanner scanner = new Scanner(System.in);
                String CHOICE = scanner.nextLine();

                if ("Y".equalsIgnoreCase(CHOICE) || "YES".equalsIgnoreCase(CHOICE)) {
                    Menu();            
                }
            }
        }
        


        if ("2".equals(selection)) {
            BoxPrinter("Please enter company name to get flights  Options: [AirCan, USAir, BritAir, AirFrance, LuftAir, ItalAir].");
            String company_name = rec.nextLine();
            
            ResultSet flights = DataBaser("SELECT * from flights where company_id='" + company_name + "';");
            Printers.LoadingScreens.LoadingDatabase();
            Printers.DBTablePrinter.printResultSet(flights);          

            System.out.println("WOULD YOU LIKE TO RETURN TO THE MAIN MENU?(Y/N)");
            Scanner scanner = new Scanner(System.in);
            String CHOICE = scanner.nextLine();

            if ("Y".equalsIgnoreCase(CHOICE) || "YES".equalsIgnoreCase(CHOICE)) {
                Menu();
            }
        }
        
        if ("3".equals(selection)) {
            BoxPrinter("Getting fully booked flights");
            
            ResultSet flights = DataBaser("SELECT * from flights where num_business_class-num_business_reserved=0 AND num_economy-num_economy_reserved=0;");
            Printers.LoadingScreens.LoadingDatabase();
            Printers.DBTablePrinter.printResultSet(flights);          

            System.out.println("WOULD YOU LIKE TO RETURN TO THE MAIN MENU?(Y/N)");
            Scanner scanner = new Scanner(System.in);
            String CHOICE = scanner.nextLine();

            if ("Y".equalsIgnoreCase(CHOICE) || "YES".equalsIgnoreCase(CHOICE)) {
                Menu();
            }
        }
                
        
        if ("4".equals(selection)) {
            BoxPrinter("Getting flights from Toronto to JFK.");
            
            ResultSet flights = DataBaser("SELECT * from flights where from_airport='YYZ' AND to_airport='JFK' AND num_business_class-num_business_reserved>0 AND num_economy-num_economy_reserved>0 ;");
            Printers.LoadingScreens.LoadingDatabase();
            Printers.DBTablePrinter.printResultSet(flights);          

            System.out.println("WOULD YOU LIKE TO RETURN TO THE MAIN MENU?(Y/N)");
            Scanner scanner = new Scanner(System.in);
            String CHOICE = scanner.nextLine();

            if ("Y".equalsIgnoreCase(CHOICE) || "YES".equalsIgnoreCase(CHOICE)) {
                Menu();
            }
        }
        
        if ("5".equalsIgnoreCase(selection)) {
            
            int reservation_id = GetMaxId("reservations") + 1;
            
            BoxPrinter("Please enter flight ID.");
            String flight_id = rec.nextLine();

            BoxPrinter("Please enter customer ID.");
            String customer_id = rec.nextLine();

            BoxPrinter("Please enter city.");
            String city = rec.nextLine();
            
            BoxPrinter("Please enter reservation type [0=business,1=economy].");
            String type = rec.nextLine();

            BoxPrinter("Please enter reservation status [0=kratimeni,1=akirwmeni,2=prokatavoli].");
            String status = rec.nextLine();

            BoxPrinter("Please enter prepayment (0 if no prepayment).");
            String prepayment = rec.nextLine();
            
           
            DataBaserInsert("INSERT INTO reservations (reservation_id,customer_id,flight_id,reservation_type,reservation_city,"
                    + "reservation_status,prepayment) VALUES (" + reservation_id + "," + customer_id + "," + flight_id + "," + type + ",'" + city + "'," + status + "," + prepayment + ");");            

            System.out.println("Reservation Added ! WOULD YOU LIKE TO RETURN TO THE MAIN MENU?(Y/N)");
            Scanner scanner = new Scanner(System.in);
            String CHOICE = scanner.nextLine();

            if ("Y".equalsIgnoreCase(CHOICE) || "YES".equalsIgnoreCase(CHOICE)) {
                Menu();
            }
        }
        
        if ("6".equals(selection)) {
            BoxPrinter("Please enter reservation ID to pay and update.");
            String reservation_id = rec.nextLine();
            
            DataBaserInsert("UPDATE reservations SET prepayment=price_total,reservation_status=0 where reservation_id=" + reservation_id+";");

            System.out.println("Reservation Updated ! WOULD YOU LIKE TO RETURN TO THE MAIN MENU?(Y/N)");
            Scanner scanner = new Scanner(System.in);
            String CHOICE = scanner.nextLine();

            if ("Y".equalsIgnoreCase(CHOICE) || "YES".equalsIgnoreCase(CHOICE)) {
                Menu();
            }
        }        
        
        if ("7".equals(selection)) {
            
            BoxPrinter("Please enter company name to delete cancelled reservations. Options: [AirCan, USAir, BritAir, AirFrance, LuftAir, ItalAir].");
            String company_name = rec.nextLine();
            
            ResultSet flights = DataBaser("SELECT r.* from reservations as r INNER JOIN flights AS fl ON r.reservation_id=fl.flight_id AND r.reservation_status=1 AND fl.company_id='"+company_name+"';");
            Printers.LoadingScreens.LoadingDatabase();
            Printers.DBTablePrinter.printResultSet(flights);
            
            BoxPrinter("Deleting canceled reservations.");

            DataBaserInsert("DELETE r.* from reservations as r INNER JOIN flights AS fl ON r.reservation_id=fl.flight_id AND r.reservation_status=1 AND fl.company_id='"+company_name+"';");
            
            System.out.println("Cancelled reservations deleted! WOULD YOU LIKE TO RETURN TO THE MAIN MENU?(Y/N)");
            Scanner scanner = new Scanner(System.in);
            String CHOICE = scanner.nextLine();

            if ("Y".equalsIgnoreCase(CHOICE) || "YES".equalsIgnoreCase(CHOICE)) {
                Menu();
            }
        }
        
        

    }

}
