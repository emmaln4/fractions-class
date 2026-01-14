import java.util.Random;

public class Fraction {

    //instance varibles
    private int numerator;
    private int denominator;

    //constructors
    
    public Fraction() {
        Random random = new Random();
        this.numerator = random.nextInt(9) + 1;
        this.denominator = random.nextInt(9) + 1;
    }
    
    public Fraction(int n, int d) {
        this.numerator = n;
        this.setDenom(d);
    }

    public Fraction(String f) {
        String[] numbers = f.split("/");
        int n = Integer.parseInt(numbers[0]);
        int d = Integer.parseInt(numbers[1]);
        
        this.numerator = n;
        this.setDenom(d);
    }
    
    public Fraction(Fraction f) {
        this.numerator = f.numerator;
        this.denominator = f.denominator;
    }
    
    //behavoir methods 
    
    //accessor methods
    public String toString() {
        return numerator + "/" + denominator;
    }
    
    public int getNum() {
        return numerator;
    }
    
    public int getDenom() {
        return denominator;
    }
    
    public double toDouble() {
        return (double) numerator/denominator;
    }
    
    public boolean equals(Fraction f) {
        if (f == null) {
            return false;
        }
        return this.numerator == f.numerator && this.denominator == f.denominator;
        
    }
    
    //mutator methods
    public void reduce() {
        int g = GCF(numerator, denominator);
        numerator /= g;
        denominator /= g;
    }
    
    private int GCF(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);
        
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
    
    public void setNum(int n) {
         numerator = n;
    }
    
    public void setDenom(int d) {
         if (d != 0) {
            this.denominator = d;
        } else {
            this.denominator = 1;
            System.out.println("Error: denominator cannot be zero");
        }
    }
    
    //class methods 
    
    //static methods 
    public static Fraction multiply (Fraction a, Fraction b) {
        int newNum = a.numerator * b.numerator;
        int newDenom = a.denominator * b.denominator;
        Fraction c = new Fraction(newNum, newDenom);
        c.reduce();
        return c;
    }
    
    public static Fraction divide (Fraction a, Fraction b) {
        if (b.numerator == 0) {
            System.out.println("Error: dividing by zero");
            return null;
        }
        
        int newNum = a.numerator * b.denominator;
        int newDenom = a.denominator * b.numerator;
        Fraction c = new Fraction(newNum, newDenom);
        c.reduce();
        return c;
    }
    
    public static Fraction add (Fraction a, Fraction b) {
        int  newNum = (a.numerator * b.denominator) + (b.numerator * a.denominator);
        int newDenom = a.denominator * b.denominator;
        Fraction c = new Fraction(newNum, newDenom);
        c.reduce();
        return c;
    }
    
    public static Fraction subtract (Fraction a, Fraction b) {
       int  newNum = (a.numerator * b.denominator) - (b.numerator * a.denominator);
        int newDenom = a.denominator * b.denominator;
        Fraction c = new Fraction(newNum, newDenom);
        c.reduce();
        return c; 
    }
}