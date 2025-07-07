# Online_Auction_System
Overview
This Java project simulates an auction system where sellers can list items and bidders can participate in auctions to purchase those items. The system includes features for managing bidders, items, and the auction process itself.

Features
User Management:

Sellers can add/remove products for auction

Bidders can participate in auctions

Auction Process:

Items are displayed with their base prices

Bidders can place bids by increasing the item value

Auction continues until only one bidder remains or all drop out

Data Persistence:

Bidders' information is read from bidder.txt

Products' information is read from products.txt

Reporting:

Displays auction results showing which items were sold and to whom

File Structure
text
AuctionSystem/
├── AuctionSystem.java        # Main application file
├── bidder.txt               # Contains bidder information (name,age,gender,country)
├── products.txt             # Contains product information (name,basePrice)
└── README.md                # This file
Classes
Information: Base class storing common attributes (name, age, gender, country)

Item: Represents an item for auction (extends Information)

Bid: Represents a bid on an item

Bidder: Represents a participant in the auction (extends Information)

Seller: Represents the auction seller (extends Information)

AuctionSystem: Main class containing the auction logic

Requirements
Java JDK 8 or later

Two input files (bidder.txt and products.txt) in the same directory as the Java file

Input File Formats
bidder.txt:

text
Name,Age,Gender,Country
John Doe,30,Male,USA
Jane Smith,25,Female,Canada
products.txt:

text
ProductName,BasePrice
Painting,200.00
Antique Vase,500.00
How to Run
Compile the program:

bash
javac AuctionSystem.java
Run the program:

bash
java AuctionSystem
Usage
The program will display all bidders and available items

For each item:

The system asks if anyone wants to bid

Interested bidders can increase the item value

Bidders can drop out by choosing not to increase the bid

The auction continues until:

Only one bidder remains (they win the item)

All bidders drop out (item goes unsold)

After all items are processed, the system displays the sold items and their buyers

Notes
The auction process includes simulated delays for better user experience

All interactions are done through the console

The system handles basic error cases like invalid product names

Example Output
text
Namaste everyone welcome to the auction.
Ourselves Nand and Vishvam. We are the hosts of this auction.
The information of the bidders are listed below:

Name: John Doe
Age: 30
Country: USA
Gender: Male

Available Items:
Painting: $200.00
Antique Vase: $500.00
Which product do you want to sell?
