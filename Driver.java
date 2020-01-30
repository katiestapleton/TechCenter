
package cruiseshipproject;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Driver {

    // class variables (add more as needed)
    private static ArrayList<Ship> shipList = new ArrayList();
    private static ArrayList<Cruise> cruiseList = new ArrayList();
    private static ArrayList<Passenger> passengerList = new ArrayList();
    //added varibles
    static String menuItem;      
    
    public static void main(String[] args) {
    
        initializeShipList();       // initial ships
        initializeCruiseList();     // initial cruises
        initializePassengerList();  // initial passengers

        // Part 5: COMPLETED/no errors
        // add loop and code here that accepts and validates user input
        // and takes the appropriate action. include appropriate
        // user feedback and redisplay the menu as needed
        menuItem = "0"; 
        
        while(!menuItem.equalsIgnoreCase("x")) {
            // diplays menu by calling on the display Menu method
            displayMenu();
            // obtains and assigns user input
            Scanner menuInput = new Scanner(System.in);
            menuItem = menuInput.nextLine(); 
            menuItem = menuItem.toUpperCase();
            // assigns additional variables as needed
            int menuLength = menuItem.length();
            
            // menu selection: executes methods the correspond to A to F.
            if(Character.isLetter(menuItem.charAt(0)) && (menuLength == 1)) {
                switch (menuItem) {
                    case "A":
                        printShipList("name");
                        break;
                    case "B":
                        printShipList("active");
                        break;
                    case "C":
                        printShipList("full");
                        break;
                    case "D":
                        printCruiseList("list");
                        break;                    
                    case "E":
                        printCruiseList("details");
                        break;
                    case "F":
                        printPassengerList();
                        break;                    
                    case "X":
                        System.exit(0);
                    default:
                        System.out.println("Error: Selection invalid. Please try again.");
                        break;
                }
            // menu selection: executes methods corresponding to 1-6
            } else if(isANumber(menuItem) && (menuLength == 1)) {
                switch (menuItem) {
                    case "1":
                        addShip();
                        break;
                    case "2":
                        editShip();
                        break;
                    case "3":
                        addCruise();
                        break;
                    case "4":
                        editCruise();
                        break;
                    case "5":
                        addPassenger();
                        break;
                    case "6":
                        editPassenger();
                        break;
                    default:
                        break;                        
                }
            // menu selection: addresses invalid input          
            } else  {
                System.out.println("Error: Selection invalid. Please try again.");
            }
        }        
    }

    // hardcoded ship data for testing
    // Initialize ship list
    public static void initializeShipList() {
        add("Candy Cane", 20, 40, 10, 60, true);
        add("Peppermint Stick", 10, 20, 5, 40, true);
        add("Bon Bon", 12, 18, 2, 24, false);
        add("Candy Corn", 12, 18, 2, 24, false);
    }

    // hardcoded cruise data for testing
    // Initialize cruise list
    public static void initializeCruiseList() {
        Cruise newCruise = new Cruise("Southern Swirl", "Candy Cane", "Miami", "Cuba", "Miami");
        cruiseList.add(newCruise);
    }

    // hardcoded cruise data for testing
    // Initialize passenger list
    public static void initializePassengerList() {
        Passenger newPassenger1 = new Passenger("Neo Anderson", "Southern Swirl", "STE");
        passengerList.add(newPassenger1);

        Passenger newPassenger2 = new Passenger("Trinity", "Southern Swirl", "STE");
        passengerList.add(newPassenger2);

        Passenger newPassenger3 = new Passenger("Morpheus", "Southern Swirl", "BAL");
        passengerList.add(newPassenger3);
    }

    // custom method to add ships to the shipList ArrayList
    public static void add(String tName, int tBalcony, int tOceanView,
                           int tSuite, int tInterior, boolean tInService) {
        Ship newShip = new Ship(tName, tBalcony, tOceanView, tSuite, tInterior, tInService);
        shipList.add(newShip);
    }


    public static void printShipList(String listType) {
        // printShipList() method prints list of ships from the
        // shipList ArrayList. There are three different outputs
        // based on the listType String parameter:
        // name - prints a list of ship names only
        // active - prints a list of ship names that are "in service"
        // full - prints tabbed data on all ships

        if (shipList.size() < 1) {
            System.out.println("\nThere are no ships to print.");
            return;
        }
        if (listType == "name") {
            System.out.println("\n\nSHIP LIST - Name");
            for (int i = 0; i < shipList.size(); i++) {
                System.out.println(shipList.get(i));
            }
        } else if (listType == "active") {
            System.out.println("\n\nSHIP LIST - Active");
            // PART  2: COMPLETED/no errors
            // complete this code block            
            // printing the heading of the ship's details list
            System.out.println("-----------------------------------------------");
            System.out.println("                    Number of Rooms     In");
            System.out.print("SHIP NAME           Bal OV  Ste Int     Service");
            System.out.println("\n-----------------------------------------------");            
            // method to print all active ships
            for (int i = 0; i < shipList.size(); i++) {
                if(shipList.get(i).getInService() == true) {
                    //assign array elements to variables (to be printed w/in loop)
                    String shipName = shipList.get(i).getShipName();
                    int roomBal =shipList.get(i).getRoomBalcony();
                    int roomOV = shipList.get(i).getRoomOceanView();
                    int roomSte = shipList.get(i).getRoomSuite();
                    int roomInt = shipList.get(i).getRoomInterior();
                    boolean serviceStatus = shipList.get(i).getInService();
                    // print info/details about the active ship
                    System.out.printf("%-20s", shipName);
                    System.out.println(roomBal + "\t" + roomOV + "\t" + roomSte 
                        + "\t" + roomInt + "\t" + serviceStatus);
                }
            }

        } else if (listType == "full") {
            System.out.println("\n\nSHIP LIST - Full");
            System.out.println("-----------------------------------------------");
            System.out.println("                    Number of Rooms     In");
            System.out.print("SHIP NAME           Bal OV  Ste Int     Service");
            System.out.println("\n-----------------------------------------------");
            for (Ship eachShip: shipList)
                eachShip.printShipData();

        } else
            System.out.println("\n\nError: List type not defined.");
    }

    public static void printCruiseList(String listType) {
        if (cruiseList.size() < 1) {
            System.out.println("\nThere are no cruises to print.");
            return;
        }
        if (listType == "list") {
            System.out.println("\n\nCRUISE LIST");
            for (int i=0; i < cruiseList.size(); i++) {
                System.out.println(cruiseList.get(i));
            }
        } else if (listType == "details") {
            System.out.println("\n\nCRUISE LIST - Details");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("                                      |----------------------PORTS-----------------------|");
            System.out.print("CRUISE NAME         SHIP NAME           DEPARTURE           DESTINATION         RETURN");
            System.out.println("\n-----------------------------------------------------------------------------------------");
            for (Cruise eachCruise: cruiseList)
                eachCruise.printCruiseDetails();
        } else
            System.out.println("\n\nError: List type not defined.");
    }

    public static void printPassengerList() {
        if (passengerList.size() < 1) {
            System.out.println("\nThere are no passengers to print.");
            return;
        }
        System.out.println("\n\nPASSENGER LIST");
        System.out.println("-----------------------------------------------------");
        System.out.print("PASSENGER NAME      CRUISE              ROOM TYPE");
        System.out.println("\n-----------------------------------------------------");
        for (Passenger eachPassenger: passengerList)
            eachPassenger.printPassenger();
    }

    // display text-based menu
    public static void displayMenu() {
        //Modify: The menu title was badly aligned with the options. Too many tabs
        System.out.println("\n\n");
        System.out.println("\t\tLuxury Ocean Cruise Outings");
        System.out.println("\t\t\tSystem Menu\n");
        System.out.println("[1] Add Ship            [A] Print Ship Names");
        System.out.println("[2] Edit Ship           [B] Print Ship In Service List");
        System.out.println("[3] Add Cruise          [C] Print Ship Full List");
        System.out.println("[4] Edit Cruise         [D] Print Cruise List");
        System.out.println("[5] Add Passenger       [E] Print Cruise Details");
        System.out.println("[6] Edit Passenger      [F] Print Passenger List");
        System.out.println("[x] Exit System");
        System.out.println("\nEnter a menu selection: ");
    }

    // Add a New Ship
    public static void addShip() {
        // PART 3 - COMPLETE/no errors
        // complete this method
        // establish variables
        String newShipName;
        String shipDetails;
        int roomBal;
        int roomOV;
        int roomSte;
        int roomInt;
        boolean inService;
        
        // obtains ship name from user and checks if ship is already in the system
        Scanner newShipInput = new Scanner(System.in);
        System.out.println("New ship's name?");
        newShipName = newShipInput.nextLine();
        newShipName = newShipName.trim();
        // checks if ship is already in system and alerts user if ship is already in the database
        for(Ship eachShip: shipList) {
            if(eachShip.getShipName().equalsIgnoreCase(newShipName)) {
                System.out.println("That ship is already in the system. Exiting to menu...");
                return;            
            }
        }
        
        // retrieve and validate user input about ship details
        Scanner newShipInfo = new Scanner(System.in); 
        // input/valid: baloncy rooms
        System.out.println("How many Baloncy rooms? ");
        shipDetails = newShipInfo.next();
            while(isANumber(shipDetails) == false) {
                System.out.println("Error: Numbers only. \nHow many Baloncy rooms?");
                shipDetails = newShipInfo.next();
            }
            roomBal = Integer.parseInt(shipDetails);
        // input/valid: oceanview rooms count
        System.out.println("How many Ocean view rooms? ");
        shipDetails = newShipInfo.next();
            while(isANumber(shipDetails) == false) {
                System.out.println("Error: Numbers only. \nHow many Ocean View rooms?");
                shipDetails = newShipInfo.next();
            }
            roomOV = Integer.parseInt(shipDetails);
        // input/valid: suite rooms count
        System.out.println("How many Suite rooms? ");
        shipDetails = newShipInfo.next();
            while(isANumber(shipDetails) == false) {
                System.out.println("Error: Numbers only. \nHow many Suite rooms?");
                shipDetails = newShipInfo.next();
            }
            roomSte = Integer.parseInt(shipDetails);        
        // input/valid: interior rooms count
        System.out.println("How many Interior rooms? ");  
        shipDetails = newShipInfo.next();
            while(isANumber(shipDetails) == false) {
                System.out.println("Error: Numbers only. \nHow many Interior rooms?");
                shipDetails = newShipInfo.next();
            }
            roomInt = Integer.parseInt(shipDetails);
        // input/valid: active service status check
        System.out.println("Is the ship in active service? true or false?");
        shipDetails = newShipInfo.next();
            while(!shipDetails.equalsIgnoreCase("true")) {
                if(shipDetails.equalsIgnoreCase("false")) {
                    inService = Boolean.parseBoolean(shipDetails);
                    break;
                } else {
                    System.out.println("Error: Valid entry. \nIs the ship in active service? true or false?");
                    shipDetails = newShipInfo.next();
                }
            }
            inService = Boolean.parseBoolean(shipDetails);
       
        // store all new information into the ship array list using preexisting method    
        add(newShipName, roomBal, roomOV, roomSte, roomInt, inService); 


    }
    

    // Edit an existing ship
    public static void editShip() {

        // This method does not need to be completed
        System.out.println("The \"Edit Ship\" feature is not yet implemented.");

    }

    // Add a New Cruise
    public static void addCruise() {
        // PART 4
        // complete this method
        // establish variables
        String newCruiseName;
        String newCruiseShip;
        String cruiseShipName = "";
        String departurePort;
        String destination;
        String returnPort;
        boolean activeShip = false;
        
        // obtain cruise name from user and ensure is it not blank
        Scanner newCruiseInput = new Scanner(System.in);
        System.out.println("New Cruise name?");
        newCruiseName = newCruiseInput.nextLine();
        // checks if cruise is already in system and alerts user if cruise is already in the database
        for(Cruise eachCruise: cruiseList) {
            if(eachCruise.getCruiseName().equalsIgnoreCase(newCruiseName)) {
                System.out.println("That cruise is already in the system. Exiting to menu...");
                return;       
            }
        }

        Scanner newCruiseInfo = new Scanner(System.in);
        // input
        System.out.println("Cruise ship name?"); 
        newCruiseShip = newCruiseInfo.next();
        newCruiseShip = newCruiseShip.trim();

       // check if inputted cruise ship is within the shipList
        for(Ship eachShip: shipList) {
            if(!eachShip.getShipName().equalsIgnoreCase(newCruiseShip)) {
                System.out.println("No matching ship. Exiting to menu...");
                return;  
            }
        } 
        // checks if inputted ship is already assigned to cruise
        for(Cruise eachCruise: cruiseList) {
            if(eachCruise.getCruiseShipName().equalsIgnoreCase(newCruiseShip)) {
                System.out.println("That ship is already assigned to a cruise. Exiting to menu...");
                return;
            }
        }        
        // validates that ship is in service
            // boolean statement to ac
        for (int i = 0; i < shipList.size(); i++) {
            if(shipList.get(i).getInService() == true) {
                String shipName = shipList.get(i).getShipName();
                if (shipName.equals(newCruiseShip)) {
                    cruiseShipName = newCruiseShip;
                    activeShip = true;
                } 
            }
        }    
        // exiting to main menu if no active ships match the cruise ship name input
        if (activeShip = false) {
            System.out.println("Ship is not active. Exiting to menu...");
            return;
        }
        
        // input: Departure port. Invalid if blank
        System.out.println("Departure port?");
        departurePort = newCruiseInfo.next();
        // input/valid: Destintion. Invalid if blank
        System.out.println("Destination?");
        destination = newCruiseInfo.next();
        // input: Return port. Invalid if blank
        System.out.println("Return port?");
        returnPort = newCruiseInfo.next();

        // adds new cruise to the cruise array list
        Cruise newCruise = new Cruise(newCruiseName, cruiseShipName, departurePort, destination, returnPort);
        cruiseList.add(newCruise);
    }   

    // Edit an existing cruise
    public static void editCruise() {

        // This method does not need to be completed
        System.out.println("The \"Edit Cruise\" feature is not yet implemented.");

    }

    // Add a New Passenger
    public static void addPassenger() {

        Scanner newPassengerInput = new Scanner(System.in);
        System.out.println("Enter the new passenger's name: ");
        String newPassengerName = newPassengerInput.nextLine();

        // ensure new passenger name does not already exist
        for (Passenger eachPassenger: passengerList) {
            if (eachPassenger.getPassengerName().equalsIgnoreCase(newPassengerName)) {
                System.out.println("That passenger is already in the system. Exiting to menu...");
                return; // quits addPassenger() method processing
            }
        }

        // get cruise name for passenger
        System.out.println("Enter cruise name: ");
        String newCruiseName = newPassengerInput.nextLine();

        // ensure cruise exists
        for (Cruise eachCruise: cruiseList) {
            if (eachCruise.getCruiseName().equalsIgnoreCase(newCruiseName)) {
                // cruise does exist
            } else {
                System.out.println("That cruise does not exist in the system. Exiting to menu...");
                return; // quits addPassenger() method processing
            }
        }

        // get room type
        System.out.println("Enter Room Type (BAL, OV, STE, or INT: ");
        String room = newPassengerInput.nextLine();
        // validate room type
        if ((room.equalsIgnoreCase("BAL")) || (room.equalsIgnoreCase("OV")) ||
                (room.equalsIgnoreCase("STE")) || (room.equalsIgnoreCase("INT"))) {
            // validation passed - add passenger
            Passenger newPassenger = new Passenger(newPassengerName, newCruiseName, room.toUpperCase());
            passengerList.add(newPassenger);
        } else {
            System.out.println("Invalid input. Exiting to menu...");
            return; // quits addPassenger() method processing
        }
    }

    // Edit an existing passenger
    public static void editPassenger() {

        // This method does not need to be completed
        System.out.println("The \"Edit Passenger\" feature is not yet implemented.");

    }

    // Method to check if input is a number
    public static boolean isANumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) == false)
                return false;
        }
        return true;
    }
    
}

