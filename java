#####################################################################################

## OOPS ##

## Fahrenheit to Celsius ##

import java.util.*;
import java.lang.Math;
import java.util.Scanner;

class Utility {
    public static int fahrenheitToCelcius(double f) {
        int c = (int)Math.round(((f-32)*5)/9);
        return c;
    }
    
    public static String getLevel(int [] A) {
        int sum = 0;
        String s;
        for (int i = 0; i < A.length; i++)
            sum += A[i];
        if (sum < 70)
            s = "LOW";
        else if (sum < 100)
            s = "MEDIUM";
        else
            s = "HIGH";
        return s;
    }
}

public class Source {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int op, n;
        double f;
        op = in.nextInt();
        if (op == 1)
        {
            f = in.nextDouble();
            Utility M = new Utility();
            System.out.println(M.fahrenheitToCelcius(f));
        }
        else if (op == 2)
        {
            n = in.nextInt();
            int[] arr;
            arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = in.nextInt();
            
            Utility M = new Utility();
            System.out.println(M.getLevel(arr));
        }
        else
            System.out.println("Invalid Option");
    }
}

############################################################################################

## Player Rating ##


import java.util.*;
import java.util.Scanner;

abstract class Player {
    String firstName;
    String lastName;
    String Player;
    
    Player(String f, String l)
    {
        this.firstName = f;
        this.lastName = l;
    }
    String getName()
    {
        Player = firstName + " " + lastName;
        return Player;
    }
    abstract int getRating();
}

class CricketPlayer extends Player {
    double averageRuns;
    String CricketPlayer;
    CricketPlayer(String f, String l, double r)
    {
        super(f, l);
        averageRuns = r;
    }
    int getRating()
    {
        if (averageRuns <= 20.0)
            return 1;
        else if (averageRuns <= 30.0)
            return 2;
        else if (averageRuns <= 40.0)
            return 3;
        else if (averageRuns <= 50.0)
            return 5;
        else if (averageRuns <= 55.0)
            return 6;
        else
            return 7;
    }
}

class FootballPlayer extends Player {
    int goals;
    String FootballPlayer;
    FootballPlayer(String f, String l, int g)
    {
        super(f, l);
        goals = g;
    }
    int getRating()
    {
        if (goals <= 5)
            return 1;
        else if (goals <= 10)
            return 2;
        else if (goals <= 15)
            return 3;
        else if (goals <= 20)
            return 4;
        else
            return 5;
    }
}

public class Source {
    public static void main(String[] args) {
    }
}


###############################################################################################

## Account Details ## partial ###

import java.util.*;
import java.util.Scanner;

class Account {
    int accountNo;
    double balance;
    String accountType;
    static int counter = 1;
    
    Account(double b, String ac)
    {
        this.balance = b;
        this.accountType = ac;
        this.accountNo = counter++;
    }
    
    void depositAmount(double amount)
    {
        balance += amount; 
    }
    
    void printAccountDetails()
    {
        System.out.println("[Acct No : " + accountNo + ", Type : " + accountType + ", Balance : "+ balance + "]");
    } 
}

class AccountDetails {
    void ac_main()
    {
        Scanner in = new Scanner(System.in);
        double b1, b2, a1, a2;
        String ac1, ac2;
        
        b1 = in.nextDouble();
        ac1 = in.next();
        a1 = in.nextDouble(); 
     
        Account fo = new Account(b1, ac1);
        fo.printAccountDetails();
        fo.depositAmount(a1);
        System.out.println("New Balance : " + fo.balance);
        
        b2 = in.nextDouble();
        ac2 = in.next();
        a2 = in.nextDouble(); 
        
        Account so = new Account(b2, ac2);
        so.printAccountDetails();
        so.balance = a2;
        System.out.println("New Balance : " + so.balance);
    }
}

public class Source {
    public static void main(String[] args) {
        AccountDetails ac = new AccountDetails();
        ac.ac_main();
    }
}


################################################################

### Product Analysis ### partial ###


import java.util.*;
import java.util.Scanner;

class Product {
    private int prodCode;
    private String prodName;
    private double price;
    private String category;
    
    public Product(int prodCode, String prodName, double price, String category) {
        this.prodCode = prodCode;
        this.prodName = prodName;
        this.price = price;
        this.category = category;
    }

    public int getProdCode() {
        return prodCode;
    }

    public void setProdCode(int prodCode) {
        this.prodCode = prodCode;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

class ProductData {
    
    private static Product[] products;
                
    static {
        products = new Product[8];
        products[0] = new Product(101, "keyboard", 300, "computers");
        products[1] = new Product(102, "mouse", 600, "computers");
        products[2] = new Product(103, "monitor", 5000, "computers");
        products[3] = new Product(104, "t-shirt", 500, "clothing");
        products[4] = new Product(105, "jeans", 2000, "clothing");
        products[5] = new Product(106, "sweater", 1000, "clothing");
        products[6] = new Product(107, "doll", 500, "toys");
        products[7] = new Product(108, "car", 1000, "toys");
    }

    public static Product[] getProducts() {
        return products;
    }
}

class ProductService 
{
    static String findNameByCode(int pcode) 
    {
        ProductData pdata = new ProductData();
        Product[] p = pdata.getProducts();
        for (int i = 0; i < 8; i++)
        {
            if (pcode == p[i].getProdCode())
                return p[i].getProdName();
        }
        return null;
    }
    
    static Product findMaxPriceProduct(String pcat)
    {
        if (pcat == null)
            return null;
        ProductData pdata = new ProductData();
        Product[] p = pdata.getProducts();
        double price = 0;
        int index = 0;
        int flag = 0;
        for (int i = 0; i < 8; i++)
        {
            if (pcat.equals(p[i].getCategory()))
            {
                if (p[i].getPrice() > price)
                {
                    price = p[i].getPrice();
                    index = i;
                    flag = 1;
                }
            }
        }
        if (flag == 1)
            return p[index];
        return null;
    }
}

public class Source{
    public static void main(String [] args){
        
        Scanner in = new Scanner(System.in);
        int choice;
        choice = in.nextInt();
        if (choice == 1)
        {
            int pcode;
            pcode = in.nextInt();
            ProductService p = new ProductService();
            String ans = p.findNameByCode(pcode);
            if (ans == null)
                System.out.println("Product Not Found");
            else
                System.out.println(ans);
        }
        else if (choice == 2)
        {
            String pcat;
            pcat = in.nextLine();
            pcat = in.nextLine();
            ProductService p = new ProductService();
            Product ans = p.findMaxPriceProduct(pcat);
            if (ans == null)
                System.out.println("No products in given category");
            else
                System.out.println(ans.getProdCode() + " | " + ans.getProdName() + " | " + ans.getPrice());
        }
        else
            System.out.println("Invalid choice");
    }
}


###################################################

### Customer Information ####

import java.util.*;
import java.util.Scanner;

class SimpleDate {
    private int day;
    private int month;
    private int year;
    
    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public int getDay() {
        return day;
    }
    
    public int getMonth() {
        return month;
    }
    
    public int getYear() {
        return year;
    }

    public void setDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString() { 
        return String.format(this.day + "/" + this.month + "/" + this.year); 
    }
    
    public static boolean validateDate(SimpleDate sd) {
        if (sd.year < 2000)
            return false;
        if (sd.month < 1 || sd.month > 12)
            return false;
        if (sd.day < 1)
            return false;
        if ((sd.month == 1 || sd.month == 3 || sd.month == 5 || sd.month == 7 || sd.month == 8 || sd.month == 10 || sd.month == 12) && sd.day > 31)
            return false;  
        if ((sd.month == 4 || sd.month == 6 || sd.month == 9 || sd.month == 11) && sd.day > 30)
            return false; 
        if (sd.month == 2 && sd.day > 28)
            return false; 
        return true;
    }
}

class Address {
    private String area;
    private String city;
    
    public Address(String area, String city) {
        this.area = area;
        this.city = city;
    }
    
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    
    public String toString() { 
        return String.format(this.area + ", " + this.city); 
    }
}

class Customer {
    private int custid;
    private String name;
    Address address;
    SimpleDate registrationDate;
    
    public Customer(int custid, String name, Address address, SimpleDate registrationDate) {
        this.custid = custid;
        this.name = name;
        this.address = address;
        if (registrationDate.validateDate(registrationDate))
            this.registrationDate = registrationDate;
        else
            this.registrationDate = null;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
    public SimpleDate getRegistrationDate() {
        return registrationDate;
    }
    
    public void setRegistrationDate(SimpleDate sd) {
        if (sd.validateDate(sd))
            this.registrationDate = sd;
        else
            this.registrationDate = null; 
    }
    
    public String toString() { 
        if (this.registrationDate == null)
            return String.format("ID : " + this.custid + ", Name : " + this.name + "\nAddress : " + this.address + "\nRegistered on : Unknown");
        return String.format("ID : " + this.custid + ", Name : " + this.name + "\nAddress : " + this.address + "\nRegistered on : " + this.registrationDate); 
    }
}

public class Source{
    public static void main(String [] args){
        
        Scanner in = new Scanner(System.in);
        int custid = in.nextInt();
        String name = in.next();
        String area = in.next();
        String city = in.next();
        int day, month, year;
        day = in.nextInt();
        month = in.nextInt();
        year = in.nextInt();
        
        SimpleDate sd = new SimpleDate(day, month, year);
        Address addr = new Address(area, city);
        Customer cust = new Customer(custid, name, addr, sd);
        System.out.println(cust);
    }
}


###################################################

### Equality Check ### 

import java.util.*;
class Customer {
    // STUDENT CODE BEGINS HERE
    public int custid;
    public String name;
    public String city;
    public String phone;
    public String email;
    
    // Default constructor
    public Customer()
    {
        this.custid = 0;
        this.name = null;
        this.city = null;
        this.phone = null;
        this.email = null;
    }
    
    //Parametrized constructor
    public Customer(int custid, String name, String city, String phone, String email)
    {
        this.custid = custid;
        this.name = name;
        this.city = city;
        this.phone = phone;
        this.email = email;
    }
    
    public int getCustomerId() {
        return custid;
    }
    
    public void setCustomerId(int custid) {
        this.custid = custid;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    //Equals method
    public boolean equals(Customer obj) {
        if (obj == null)
            return false;
        if (this.custid == obj.custid && this.name == obj.name && this.city == obj.city && this.phone == obj.phone && this.email == obj.email)
            return true;
        else
            return false;
    }
    // STUDENT CODE ENDS HERE
}

class Source {
    public static void main(String []args){
    //STUDENT CODE HERE
    Customer c1 = new Customer(1, "Vinod", "Bangalore", null, null);
    Customer c2 = new Customer(1, "Vinod", "Bangalore", null, null);
    
    //Equals
    if (c1.equals(c2))
        System.out.println("true");
    if (c2.equals(c1))
        System.out.println("true");
    
    //Setter and Equals
    c1.setEmail("vinod@mailinator.com");
    if (!c1.equals(c2))
        System.out.println("false");
    if (!c2.equals(c1))
        System.out.println("false");
    
    c2.setEmail("vinod@mailinator.com");
    if (c1.equals(c2))
        System.out.println("true");
    if (c2.equals(c1))
        System.out.println("true");
    
    //Default Constructor
    Customer c3 = new Customer();
    Customer c4 = new Customer();
    if (c3.equals(c4))
        System.out.println("true");
    if (c4.equals(c3))
        System.out.println("true");
    }
}


#####################################################

### Shape Hierarchy ####

import java.util.*;
import java.util.Scanner;
import java.lang.Math.*;

interface Shape {
    abstract double getArea();
    abstract double getPerimeter();
}

abstract class AbstractShape implements Shape {
    protected final String colour;
    
    public AbstractShape(String colour) {
        this.colour = colour;
    }
    
    public String toString() { 
        return String.format("colour=" + colour); 
    }
}

class Rectangle extends AbstractShape {
    private int length;
    private int breadth;
    
    public Rectangle(String colour, int length, int breadth) {
        super(colour);
        this.length = length;
        this.breadth = breadth;
    }
    
    public double getArea() {
        return length*breadth;
    }
    
    public double getPerimeter() {
        return 2*(length+breadth);
    }
    
    public String toString() { 
        return String.format("Rectangle [colour=" + this.colour + ", length=" + this.length + ", breadth=" + this.breadth + "]"); 
    }
}


class Circle extends AbstractShape {
    private int radius;
    
    public Circle(String colour, int radius) {
        super(colour);
        this.radius = radius;
    }
    public double getArea() {
        return Math.PI*radius*radius;
    }
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }
    
    public String toString() { 
        return String.format("Circle [colour=" + this.colour + ", radius=" + this.radius + "]"); 
    }
}

public class Source{
    static void printShape(Rectangle obj) {
        System.out.println("Area: " + Math.round(obj.getArea()) + ",Perimeter: " + Math.round(obj.getPerimeter()));
    }
    
    static void printShape(Circle obj) {
        System.out.println("Area: " + Math.round(obj.getArea()) + ",Perimeter: " + Math.round(obj.getPerimeter()));
    }
    
    public static void main(String [] args){
        
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        if (s.equals("CIRCLE"))
        {
            String c = in.next();
            int r = in.nextInt();
            Circle cr = new Circle(c, r);
            System.out.println(cr);
            printShape(cr);
        }
        else
        {
            String c = in.next();
            int l = in.nextInt();
            int b = in.nextInt();
            Rectangle re = new Rectangle(c, l, b);
            System.out.println(re);
            printShape(re);
        }
    }
}

####################################################