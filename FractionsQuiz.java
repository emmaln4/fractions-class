import java.util.Scanner;
import java.util.Random;
public class FractionsQuiz {
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        
        int win = 0;
        int lose = 0;
        
        System.out.println("let the fraction quiz begin! answers should be in lowest terms");

     while (true) {
        Fraction f = new Fraction();
        Fraction g = new Fraction();
        
        String opp = "";
        Fraction correctAns = null;
        
        //random operators
        int randomOpp = random.nextInt(4);
       if (randomOpp == 0) {
            opp = " + ";
            correctAns = Fraction.add(f, g);
        } else if (randomOpp == 1) {
            opp = " - ";
            correctAns = Fraction.subtract(f, g);
        } else if (randomOpp == 2) {
            opp = " * ";
            correctAns = Fraction.multiply(f, g);
        } else   {
            opp = " / ";
            correctAns = Fraction.divide(f, g);
        }
        
        System.out.println(f + opp + g + " = ");
        String n = in.nextLine();
         
      if (n.equalsIgnoreCase("quit")) {
        break;
      }
        
      Fraction userAnswer = new Fraction(n);

      if (userAnswer.equals(correctAns)) {
        System.out.println("correct!");
        win++;
      } else {
        System.out.println("wrong, the answer was " + correctAns);
        lose++;
      }
    }
      if (win + lose > 0) {
          Fraction ratio = new Fraction(win, win + lose);
          int percent = (int) (win * 100/ (win + lose));
          System.out.println("your win/lose was " + ratio + ", for a score of " + percent + " percent!");
      }
        
        
        }
    }