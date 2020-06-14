import java.util.Scanner;
public class Source {    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, index, temp;
        n = in.nextInt();
        if (n < 1 || n > 20) {
            System.out.println("INVALID_INPUT");
            return;
        }
        int[] arr;
        arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        
        if (n % 2 == 0) {
            for (int i = 0; i < n-1; i++) {
                index = i;
                for (int j = i+1; j < n; j++) {
                    if (arr[index] > arr[j]) {
                        index = j;
                    }
                }
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
        else {
            for (int i = 0; i < n-1; i++) {
                index = i;
                for (int j = i+1; j < n; j++) {
                    if (arr[index] < arr[j]) {
                        index = j;
                    }
                }
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
                System.out.print(arr[i]+" ");
            }
    }
}

################################################################################################

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Source {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr;
        arr = new int[3];
        
        for (int i = 0; i < 3; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 1; i < 3; i++) {
            if (arr[i] > arr[i-1]) {
                System.out.println("INVALID_INPUT");
                return;
            }
        }
        
        int a = arr[0], b = arr[1], c = arr[2];
        if (a*a == b*b + c*c) {
            System.out.println("RIGHT ANGLE");
        }
        else {
            System.out.println("NOT RIGHT ANGLE");
        }
   }
}

##################################################################################

import java.util.Scanner;
public class Source {    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = 0;
        int[] arr;
        arr = new int[3];
        
        for (int i = 0; i < 3; i++) {
            arr[i] = in.nextInt();
            if (arr[i] < 0 || arr[i] > 100) {
                System.out.println("INVALIDMARKS");
                return;
            }
            sum += arr[i];
        }
        int avg = sum/3;
        if (avg < 40) {
            System.out.println("FAIL");
        }
        else if (avg < 50) {
            System.out.println("THIRD");
        }
        else if (avg < 60) {
            System.out.println("SECOND");
        }
        else if (avg < 70) {
            System.out.println("FIRST");
        }
        else {
            System.out.println("DISTINCTION");
        }
    }
}

################################################################################


import java.util.Scanner;

public class Source {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        if (n < 1 || n > 999) {
            System.out.println("INVALID_INPUT");
            return;
        }
        
        int[] arr;
        arr = new int[10];
        int i = 0;
        while (n != 0)
        {
            arr[i] = n%2;
            n /= 2;
            i++;
        }
        int len = i;
        for (i = len-1; i >= 0; i--){
            System.out.print(arr[i]);
        }
    }
}

#################################################################################


import java.util.Scanner;

public class Source {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, b;
        a = in.nextInt();
        b = in.nextInt();
        if (a > b) {
            System.out.println("INVALID_INPUT");
            return;
        }
        if (a < 3 || b > 1000) {
            System.out.println("INVALID_INPUT");
            return;
        }
        
        int sum = 0;
        int flag;
        for (int i = a; i <= b; i++) {
            flag = 0;
            for (int j = 2; j < i/2; j++) {
                if (i%j == 0)
                    flag = 1;
            }
            if (flag == 0)
                sum += i;
        }
        System.out.println(sum);
    }
}

#################################################################################################

import java.util.Scanner;

public class Source {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, temp;
        n = in.nextInt();
        int[] arr;
        arr = new int[10];
        int i = 0;
        temp = n;
        while (temp != 0) {
            arr[i] = temp%10;
            temp /= 10;
            i++;
        }
        if (i != 3) {
            System.out.println("INVALID_INPUT");
            return;
        }
        
        int a, b, c;
        a = arr[0];
        b = arr[1];
        c = arr[2];
        a = a*a*a;
        b = b*b*b;
        c = c*c*c;
        
        if (a+b+c == n) {
            System.out.println("ARMSTRONG");
        }
        else {
            System.out.println("NOT ARMSTRONG");
        }
    }
}

####################################################################################


import java.util.*;
import java.util.Scanner;

public class Source {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();
        
        for (int i = 0; i < 5; i++) {
            n = in.nextInt();
            a.add(n);
        }
        for (int i = 0; i < 5; i++) {
            n = in.nextInt();
            b.add(n);
        }
        
        List<Integer> c = mergeAndSort (a, b);
        System.out.println(c);
    }

    public static List<Integer> mergeAndSort(List<Integer> al1, List<Integer> al2) 
    {
        List<Integer> r = new ArrayList<Integer>();
        if(al1.size() != 5)
            throw new IllegalArgumentException("Size should be 5");
        if(al2.size() != 5)
            throw new IllegalArgumentException("Size should be 5");
        int i = 0, j = 0;
        Collections.sort(al1); 
        Collections.sort(al2); 
        while (i < 5 && j < 5) {
            if (al1.get(i) < al2.get(j)) {
                r.add(al1.get(i));
                i++;
            }
           else {
               r.add(al2.get(j));
               j++;
           }
        }
        for (int k = i; k < 5; k++)
            r.add(al1.get(k));
        for (int k = j; k < 5; k++)
            r.add(al2.get(k));
       
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(r.get(2));
        ans.add(r.get(6));
        ans.add(r.get(8));
        return ans;
    }
    
}

#############################################################################################


#### Sum of List Elements ####


import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Source {
    public static List<Integer> getSumOfListElements(List<Integer> first,List<Integer> second){
        int l1, l2;
        try {
           l1 = first.size();
        }
        catch(final NullPointerException e) {
           l1 = 0;
        }
        
        try {
           l2 = second.size();
        }
        catch(final NullPointerException e) {
            l2 = 0;
        }
        
        List<Integer> r = new ArrayList<Integer>();
        
        if (l1 < l2) {
            for (int i = 0; i < l1; i++)
                r.add(first.get(i)+second.get(i));
            for (int i = l1; i < l2; i++)
                r.add(second.get(i));
        }
        else {
            for (int i = 0; i < l2; i++)
                r.add(first.get(i)+second.get(i));
            for (int i = l2; i < l1; i++)
                r.add(first.get(i));
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1, s2;

        try {
           s1 = in.nextLine();
        }
        catch(final NoSuchElementException e) {
            s1 = null;
        }
        
        try {
           s2 = in.nextLine();
        }
        catch(final NoSuchElementException e) {
            s2 = null;
        }
        
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();
        
        if (s1 != null) {
            StringTokenizer st1 =  new StringTokenizer(s1, ", "); 
            while (st1.hasMoreTokens()) 
                a.add(Integer.parseInt(st1.nextToken()));   
        }
        if (s2 != null) {
            StringTokenizer st2 =  new StringTokenizer(s2, ", "); 
            while (st2.hasMoreTokens()) 
                b.add(Integer.parseInt(st2.nextToken()));
        }
            
        List<Integer> c = getSumOfListElements(a, b);
        System.out.println(c);
    }
}


################################################################

#####  Sort the List ####

import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Source {
    
    public static List<String> sort(String str){
        List<String> ans = new ArrayList<String>();
        if (str != null) {
            StringTokenizer st =  new StringTokenizer(str, " "); 
            while (st.hasMoreTokens()) 
                ans.add(st.nextToken()); 
            
            int len = ans.size();
            for (int i = 0; i < len-1; i++) {
                int ind = i;
                for (int j = i+1; j < len; j++) {
                    if (ans.get(j).length() <  ans.get(ind).length())
                        ind = j;
                }
                Collections.swap(ans, i, ind);
            }
            
            for (int i = 0; i < len-1; i++) {
                for (int j = i+1; j < len; j++) {
                    if (ans.get(j).length() ==  ans.get(j).length()) {
                        if (ans.get(i).compareTo(ans.get(j)) > 0)
                            Collections.swap(ans, i, j);
                    }
                }
            }
        }
        return ans;
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s;

        try {
           s = in.nextLine();
        }
        catch(final NoSuchElementException e) {
            s = null;
        }
    
        List<String> r = sort(s);
        System.out.println(r);
    }
}

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

### Max Digit in a String ###

import java.util.*;
import java.util.Scanner;

public class Source {
    public static int getMaxDigit(String s) {
        int m = -1;
        if (s == null)
            return m;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
            {
                if (m < s.charAt(i)-'0')
                m = s.charAt(i)-'0';
            }
        }
        return m;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int ans = getMaxDigit(s);
        if (ans == -1)
            System.out.println("No digits in string");
        else
            System.out.println("Max digit : " + ans);
    }
}

############################################################


### Count Unique Characters ###

import java.util.*;
import java.util.Scanner;

public class Source {
    public static int getUniqueCharacterCount(String s) {
        if (s == null)
            return -1;
        s = s.toLowerCase();
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>(); 
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) != ' ')
            {
                Integer c = hash.get(s.charAt(i));
                if (hash.get(s.charAt(i)) == null)
                    hash.put(s.charAt(i), 1);
                else
                    hash.put(s.charAt(i), ++c);
            }
        }
        int count = 0;
        Iterator hashit = hash.entrySet().iterator(); 

        while (hashit.hasNext()) { 
            Map.Entry mapElement = (Map.Entry)hashit.next(); 
            int c = ((int)mapElement.getValue()); 
            if (c == 1)
                count++;
        }
        if (count == 0)
            return -1;
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int ans = getUniqueCharacterCount(s);
        if (ans == -1)
            System.out.println("No unique character/s");
        else
            System.out.println(ans + " unique character/s");
    }
}

##############################################################

### Calculate Age ###

import java.util.*;
import java.util.Scanner;
import java.time.Period;
import java.time.LocalDate;

class AgeCalculator {
    public int[] calculateAge(String date) {
        if (date == null)
            return null;
        List<Integer> a = new ArrayList<Integer>();
        int[] ans = new int[2];
        if (date != null) {
            StringTokenizer st1 =  new StringTokenizer(date, "/"); 
            while (st1.hasMoreTokens()) 
                a.add(Integer.parseInt(st1.nextToken()));   
        }
        int day = a.get(0);
        int month = a.get(1);
        int year = a.get(2);
        
        LocalDate birth = LocalDate.of(year, month, 1);
        LocalDate cur = LocalDate.of(2019, 4, 1);
        
        if (birth.isAfter(cur) || birth.isEqual(cur))
            return null;
        else
        {
            Period p = Period.between(birth, cur);
            ans[0] = p.getYears();
            ans[1] = p.getMonths();
        }
        return ans;  
    }
}

public class Source {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String date = in.nextLine();
        AgeCalculator c = new AgeCalculator();
        int[] ans = c.calculateAge(date);
        if (ans == null)
            System.out.println("Invalid date of birth");
        else
        {
            if (ans[1] == 0)
                System.out.println("Years : " + ans[0]);
            else if (ans[0] == 0)
                System.out.println("Months : " + ans[1]);
            else
                System.out.println("Years : " + ans[0] + ", Months : " + ans[1]); 
        }
    }
}

##################################################################


### Color Code ###

import java.util.*;
import java.util.Scanner;

public class Source {
     public static int validateHexCode(String code) {
        if (code == null)
            return -1;
        int len = code.length();
        if (len != 7)
            return -1;
        if (code.charAt(0) != '#')
            return -1;
            
        for (int i = 1; i < len; i++)
        {
            if (Character.isDigit(code.charAt(i)))
                continue;
            else if (code.charAt(i) < 'A' || code.charAt(i) > 'F')
                return -1;
        }
        return 1;
    }
    
    public static int validateDecimalCode(String code) {
        if (code == null)
            return -1;
        int len = code.length();
        String rgb = code.substring(0, 4);
        if (!rgb.equals("rgb("))
            return -1;
        String dcode = code.substring(4, len-1);
        for (int i = 0; i < dcode.length(); i++)
        {
            if ((dcode.charAt(i) < '0' || dcode.charAt(i) > '9') && dcode.charAt(i) != ',')
                return -1;
        }
        List<Integer> a = new ArrayList<Integer>();
        if (dcode != null) {
            StringTokenizer st =  new StringTokenizer(dcode, ","); 
            while (st.hasMoreTokens()) 
                a.add(Integer.parseInt(st.nextToken()));   
        }
        for (int i = 0; i < 3; i++)
        {
            if (a.get(i) < 0 || a.get(i) > 255)
                return -1;
        }
        return 1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        String code = in.next();
        if (c == 1)
        {
            if (validateHexCode(code) == 1)
                System.out.println("Valid Code");
            else
                System.out.println("Invalid Code");
        }
        else if (c == 2)
        {
            if (validateDecimalCode(code) == 1)
                System.out.println("Valid Code");
            else
                System.out.println("Invalid Code");
        }
        else
            System.out.println("Invalid choice");
    }
}

##########################################################################

### Date Validation ###

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class Utility {
    private static boolean isValidDateFormat(String date) {
        int c1 = 0, c2 = 0, c3 = 0;
        String pattern = "";
        for (int i = 0; i < date.length(); i++)
        {
            if (date.charAt(i) == '/')
                c1++;
            if (date.charAt(i) == '-')
                c2++;
            if (date.charAt(i) == '.')
                c3++;
        }
        if (c1 == 2 && c2 == 0 && c3 == 0)
            pattern = "(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[0-2])\\/([0-9]{4})";
        else if (c1 == 0 && c2 == 2 && c3 == 0)
            pattern = "(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[0-2])-([0-9]{4})";
        else if (c1 == 0 && c2 == 0 && c3 == 2)
            pattern = "(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[0-2]).([0-9]{4})";
        else
            return false;
        boolean result = false;
        if (date.matches(pattern))
            result = true;
        return result;
    }
    static int checkDate(String date) {
        if (date == null)
            return -1;
        int result = -1;
        SimpleDateFormat dateFormat = null;
        if (isValidDateFormat(date)) {
            int c1 = 0, c2 = 0, c3 = 0;
            for (int i = 0; i < date.length(); i++)
            {
                if (date.charAt(i) == '/')
                    c1++;
                if (date.charAt(i) == '-')
                    c2++;
                if (date.charAt(i) == '.')
                    c3++;
            }
            if (c1 == 2)
                dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            if (c2 == 2)
                dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            if (c3 == 2)
                dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            dateFormat.setLenient(false);
            try {
                dateFormat.parse(date);
                result = 1;
            } catch (ParseException e) {
                result = -1;
            }
        }
        return result;
    }
}

public class Source {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String date = in.nextLine();
        Utility obj = new Utility();
        
        if (obj.checkDate(date) == 1)
            System.out.println("Valid");
        else
            System.out.println("Invalid");
    }
}

###############################################################################

### Multiple Catch ###

import java.util.*;
import java.util.Scanner;

class Sequence {
    static int sequences(String arr) {
        if (arr == null)
            return 0;
        List<Integer> a = new ArrayList<Integer>();
        if (arr != null) {
            StringTokenizer st =  new StringTokenizer(arr, ","); 
            while (st.hasMoreTokens()) 
                a.add(Integer.parseInt(st.nextToken()));   
        }
        
        int len = a.size();
        int l = len;
        for (int i = 0; i < len-1; i++)
        {
            for (int j = 0; j < l-1; j++)
                a.set(j, a.get(j+1)-a.get(j));
            l--;
        }
        return a.get(0);
    }
}

public class Source {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String arr = in.nextLine();
        Sequence obj = new Sequence();
        int ans = obj.sequences(arr);
        System.out.println(ans);
    }
}

#######################################################################

### Lucky registation ###

import java.io.*;
import java.util.*;
public class Source{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n=checkRegistrationNumber(s);
        if(n==0)
            System.out.println("Valid registration number");
        else if(n==1)
            System.out.println("Lucky registration number");
        else 
            System.out.println("Invalid registration number");
    }
    public static int checkRegistrationNumber(String st){
        if(st==null)
            return -1;
        StringBuffer sb = new StringBuffer(st);
        int l = sb.length();
        if(l>0)
        {
            if(sb.charAt(0) != 'K' && sb.charAt(0) != 'D')
            {
                 System.out.println("a");
                 return -1;
            }
            if(sb.charAt(1) != 'A' && sb.charAt(1) != 'L')
            {
                 System.out.println("a");
                 return -1;
            }
        String k = sb.substring(2,4);
        int j = Integer.parseInt(k);
        if(j<1 || j>10)
        {
            System.out.println("c");
            return -1;
        }
        String p = sb.substring(l-4,l);
        int i = Integer.parseInt(p);
        if(i>9999 || i<1000)
        {
            System.out.println("d");
            return -1;
        }
        int sum = 0;
        while(i>0 || sum>9)
        {
            if(i==0)
            {
                i = sum;
                sum=0;
            }
            sum += i% 10;
            i/=10;
        }
        if(sum==6)
            return 1;
        return 0;
        }
        return -1;
    }
}

#####################################################################

###  Message encryption  ###

import java.io.*;
import java.util.*;
public class Source {
    public static String encrypt(String message) {
        String str = message.toLowerCase();
        int size=str.length(); 
        char[] a=new char[size]; 
        for(int i = 0; i < size; i++)
        {
            a[i] = str.charAt(i); 
            if(a[i] == 'a')
                a[i] = 'e';
            else if(a[i] == 'e')
                a[i] = 'a';
            else if(a[i] == 'o') 
                a[i] = 'u';
            else if(a[i] == 'u')
                a[i] = 'o'; 
            else if(a[i] == 'i')
                a[i] = '!';
            else if(a[i] == ' ')
                a[i] ='+';
            else if(a[i] == '9')
                a[i] ='0';
            else if(a[i] == 'z')
                a[i] ='b';
            else if(a[i] == 'd')
                a[i] ='f'; 
            else if(a[i] == 'h') 
                a[i] ='j';
            else if(a[i] == 'n') 
                a[i] ='p';
            else if(a[i] == 't')
                a[i] ='v'; 
            else 
            {
                a[i] = (char) (a[i] + 1);
            }
        } 
        str = new String(a);
        return str;
        } 
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            System.out.println(encrypt(str)); 
        } 
    
}

####################################################################

###  Day of date  ###

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Source {
    public static void main(String[] args) throws ParseException {
        Scanner sc=new Scanner(System.in); 
        String input=sc.nextLine();
        System.out.println(getDayOfDate(input));
        }
    public static String getDayOfDate(String date) throws ParseException{
        Date dt=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/m/yyyy");
        dt=sdf.parse(date);
        String day=new SimpleDateFormat("EEEEE").format(dt);
        return day; 
        
    } 
    
}

#####################################################################





