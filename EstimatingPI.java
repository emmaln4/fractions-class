public class EstimatingPI {
    public static void main(String[]args) {
        Fraction MILU = new Fraction(355, 113);
        final double EPSILON = Math.abs(Math.PI - MILU.toDouble());
        int a = 355;
        int b = 113;
        Fraction APP = new Fraction(a, b);
       
        System.out.println("MILU: " + MILU.toDouble());
        System.out.println("EPSILON: " + EPSILON);
        
        while (Math.abs(Math.PI - APP.toDouble() ) >= EPSILON) {
            if (APP.toDouble() < Math.PI) {
               a++;
            } else {
               b++; 
            }
            APP = new Fraction(a,b);
        }
        System.out.println("new approximation: " + APP);
    }
}