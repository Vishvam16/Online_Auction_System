import java.util.*;
import java.io.*;
import java.lang.*;
class Information { //class representing general information
    private String name;
    private int age;
    private String gender;
    private String country;
    // getters and setters of the class
    public Information(String name, int age, String gender, String country) { 
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.country = country; }
    public String getName() {
        return name; }
    public int getAge() {
        return age;}
    public String getGender() {
        return gender;}
    public String getCountry() {
        return country; }
}
class Item extends Information { // Class to represent an item
        private String name;
    private double basePrice;
    public Item(String name, double basePrice) {
        super(name, 0, "", ""); // Item doesn't require age, gender, country
        this.name = name;
        this.basePrice = basePrice; }

    public String getName() {
        return name; }
    public double getBasePrice() {
        return basePrice; }
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;}
}
class Bid { // Class to represent a bid on an item
    private double amount;
    public Bid(double amount) { //
        this.amount = amount; }
    public double getAmount() {
        return amount;}
}
class Bidder extends Information { // Class representing a bidder
         private double money;
    private List<Item> items;
    public Bidder(String name, int age, String gender, String country) {
             super(name, age, gender, country);
        items = new ArrayList<>(); }
    public void addItem(Item item) {
        items.add(item); }
    //methos to bid on an item
    public static void increaseItemValue(Item item) {
        double increasedValue = item.getBasePrice() + 50;
        item.setBasePrice(increasedValue);}
    public List<Item> getItems() {
        return items;}
}
class Seller extends Information { // Class representing a seller
    private List<Item> products;
    private Map<Item, Bidder> soldItems; 
    public Seller(String name, int age, String gender, String country) {
        super(name, age, gender, country);
        products = new ArrayList<>();
        soldItems = new HashMap<>(); }
    public void addProduct(Item product) { // Method to add a product to sell
        products.add(product);}
    public void removeProduct(Item product) {  // Method to remove a product from selling list
        products.remove(product);}
    public void sellItem(Item item, Bidder buyer) { //Method to sell item
        products.remove(item);
        soldItems.put(item, buyer); }
    public List<Item> getProducts() {
        return products; }
    public Map<Item, Bidder> getSoldItems() { //to store item and bidder to whom it is sold
        return soldItems; }
}
public class AuctionSystem {
        public static void main(String[] args) {

        Seller seller = new Seller("Alice Smith", 35, "Female", "UK"); //Instantize seller

        try {
            System.out.println("Namaste everyone welcome to the auction.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Ourselves Nand and Vishvam. We are the hosts of this auction.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("The information of the bidders are listed below:");
            System.out.println();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // reads value from file and prints the information the bidders
        try (BufferedReader reader = new BufferedReader(new FileReader("bidder.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 4) {
                    System.out.println("Invalid data format: " + line);
                    continue;
                }
                String name = data[0].trim();
                int age = Integer.parseInt(data[1].trim());
                String gender = data[2].trim();
                String country = data[3].trim();

                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Country: " + country);
                System.out.println("Gender:" + gender);
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid age format: " + e.getMessage()); }
        //information of all the items
        try {
            System.out.println("The information about the items to be sold are given below:");
            System.out.println();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace(); }
        // System.out.println("");
        List<Bidder> bidder = new ArrayList<>();
        List<Item> availableItems = new ArrayList<>();
        availableItems.addAll(seller.getProducts());
        // Instantiate bidder
        try {
            BufferedReader reader = new BufferedReader(new FileReader("bidder.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String gender = data[2];
                String country = data[3];
                Bidder Bidder = new Bidder(name, age, gender, country);
                bidder.add(Bidder); }
            reader.close();
        } catch (IOException e) {
        }
        //Reads from file and print the information of products
                     try {
            BufferedReader reader = new BufferedReader(new FileReader("products.txt"));
            String line;
                     while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                double baseprice = Double.parseDouble(data[1]);
                Item item = new Item(name, baseprice);
                availableItems.add(item);}
 reader.close();
        } catch (IOException e) {
        }
                while (!availableItems.isEmpty()) {  //Auction will continue until all the item are considered for bidding 
            System.out.println("Available Items:");
                    for (Item item : availableItems) {
                System.out.println(item.getName() + ": $" + item.getBasePrice());
            }
                        System.out.println("Which product do you want to sell?");
            System.out.println();
            Scanner sc = new Scanner(System.in); 
            String productName = sc.nextLine();  //Takes input for the product name 

                    Item selectedItem = null;
                    for (Item item : availableItems) { // Product goes into auction if such product exists
            if (productName.equalsIgnoreCase(item.getName())) {
                    selectedItem = item;
                    break; }}
                        if (selectedItem == null) { //fails if no such product exists
                System.out.println("Product not found. Please enter a valid product name.");
                continue;
            }
                             System.out.println("Bidding on " + selectedItem.getName());
                    try (BufferedReader reader = new BufferedReader(new FileReader("bidder.txt"))) { //Starts bidding 
                String line;

            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.err.println("Invalid age format: "+ e.getMessage());
            }
                        try {
                boolean anyBidderInterested = false;
                    for (Bidder currentBidder : bidder) { //bid is asked in general if anyone wants to bid for the product 
                    System.out.println("Does anyone wants to bid on the item? (yes/no)");
                    Scanner scanner = new Scanner(System.in);
                    String choice = scanner.nextLine();
            
                if (choice.equalsIgnoreCase("yes")) { // product goes for auction if someone is interested 
                        anyBidderInterested = true;
                        break; 
                }else if(choice.equalsIgnoreCase("no")){ //product goes unsold if noone is interested
                        anyBidderInterested = false;
                        break;
                }
                }
                            if (anyBidderInterested) { //bidding process
                    List<Bidder> droppingOut = new ArrayList<>();
                    int nocounter;
                    while (bidder.size() > 1) {
                        nocounter=0;
                        for (Bidder currentBidder : bidder) {
                            System.out.println("Do you want to increase the value of the item " + currentBidder.getName() + "? (yes/no)");
                            Scanner scanner = new Scanner(System.in);
                            String choice = scanner.nextLine();
            
                    if (choice.equalsIgnoreCase("yes")) {
                                Bidder.increaseItemValue(selectedItem);
                                System.out.println("Item value increased: $" + selectedItem.getBasePrice());
                                System.out.println();
                    } else if (choice.equalsIgnoreCase("no")) {
                                System.out.println(currentBidder.getName() + " has dropped out of the bidding.");
                                nocounter++;
                                System.out.println();
                                droppingOut.add(currentBidder);
                    } else {
                                     System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    }
                    }
                        bidder.removeAll(droppingOut);
                    }
                    bidder.addAll(droppingOut);
                    // Print the winner
                    if (!bidder.isEmpty()) {
                        System.out.println(productName + " goes to " + bidder.get(0).getName() + " for " + (selectedItem.getBasePrice()- 50));
                          System.out.println();
                        seller.removeProduct(selectedItem);
                        availableItems.remove(selectedItem);
                        seller.sellItem(selectedItem, bidder.get(0));
                        
                    } else {
                        System.out.println("No winner. All bidders dropped out.");
                          System.out.println();
                        seller.removeProduct(selectedItem);
                        availableItems.remove(selectedItem);
                    }
                } else {
                    System.out.println("No bidder is interested. Product not sold.");
                       System.out.println();
                    seller.removeProduct(selectedItem);
                    availableItems.remove(selectedItem);
}
 } catch (Exception e) {
            }
    } // Prints the item sold and to whom it is sold
    System.out.println("The auction is over, Thank you.");
 System.out.println("Items Sold:");
for (Map.Entry<Item, Bidder> entry : seller.getSoldItems().entrySet()) {
    Item item = entry.getKey();
    Bidder buyer = entry.getValue();
    System.out.println("Item: " + item.getName() + ", Sold to: " + buyer.getName());
}
}
}




