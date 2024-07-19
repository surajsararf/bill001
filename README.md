# Grocery Store Billing Application
### Description
You need to write an application for a grocery store that calculates the total bill amount after applying various promotions and taxes. The promotions can apply to specific items or the total bill.

### Requirements
The application should handle various promotions, such as buy one get one free or percentage discounts.
Taxes should be applied to the subtotal after promotions.
The promotions can apply to specific items or the entire bill.
### Input
The application should accept multiple inputs representing different shopping scenarios. Each input includes item details (name, quantity, price), promotion details, and tax rate.

### Output
The application should output the breakdown of costs for each shopping scenario, including the subtotal before promotions, the total discounts applied, the tax amount, and the final total.

Example Inputs and Outputs
#### Input 1:

```vbnet
Item: "Milk", Quantity: 2, Price: 1.50
Item: "Bread", Quantity: 3, Price: 2.00
Promotions:
- Buy one get one free on Milk
- 10% off on Bread if quantity > 2
  Tax: 5%
  
```
#### Output 1:
```vbnet

Milk: 1.50
Bread: 5.40 (10% off)
Subtotal: 6.90
Tax: 0.35
Total: 7.25
Input 2:
```
#### Input 2:
```vbnet
Item: "Eggs", Quantity: 12, Price: 0.10
Item: "Cheese", Quantity: 1, Price: 5.00
Promotions:
- 20% off on Cheese
  Tax: 5%
  Output 2:
```
#### Output 2:
```vbnet
Eggs: 1.20
Cheese: 4.00 (20% off)
Subtotal: 5.20
Tax: 0.26
Total: 5.46
```
## Instructions
Prerequisites
Java Development Kit (JDK) installed.
Apache Maven installed.
Setup
Clone the repository or download the source code.
Navigate to the project directory.
Project Structure
```css
.
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── Main.java
│   │   │   ├── Item.java
│   │   │   ├── Promotion.java
│   │   │   ├── BuyOneGetOneFree.java
│   │   │   ├── PercentageDiscount.java
│   │   │   └── GroceryStore.java
│   │   └── resources
│   │       └── input.txt
│   ├── test
│   │   └── java
│   │       ├── ItemTest.java
│   │       ├── BuyOneGetOneFreeTest.java
│   │       ├── PercentageDiscountTest.java
│   │       └── GroceryStoreTest.java
├── pom.xml
└── README.md
```

### Input File
Place the input details in the src/main/resources/input.txt file. The format of the input file should match the example provided above.

Build and Run
Build the project using Maven:

```sh
mvn clean install
```
#### Run the application:

```sh
mvn exec:java -Dexec.mainClass="Main"
```
#### Testing
To run the tests, use the following command:
```sh
mvn test
```
### Dependencies
Ensure you have the following dependencies in your pom.xml:
```xml
<dependency>
<groupId>org.junit.jupiter</groupId>
<artifactId>junit-jupiter-engine</artifactId>
<version>5.8.2</version>
<scope>test</scope>
</dependency>
```
### Additional Notes
The application reads the input from a file named input.txt in the resources folder of a Maven project.
It processes the input, applies the specified promotions, calculates the taxes, and then prints the detailed breakdown and the total amount to the console.
Adjust the input file as needed to test different shopping scenarios and promotions.
