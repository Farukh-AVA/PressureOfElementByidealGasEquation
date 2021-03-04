/**
 * @author Farukh Khassan Khojayev.
 * @since 10-30-2019
 * @vesion 1.0
 */ 
package homework4;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.File;


public class Homework4 {
   
    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(new File("vanDerWaalsConstants.txt"));
       PrintStream ps = new PrintStream("Homework4.txt");
       double a,b,temp;
       //Header of the Table.
       ps.println("         Name of Element.        Ideal Pressure.       V.D "
                        +    "Waals Pres.         %Error.");
       while(sc.hasNext()){/* while loop to reed the data from the file and 
            stop when the data will end. 
            */
            String gas = sc.next();
            a = sc.nextDouble();
            b = sc.nextDouble();
             for(temp=100; temp<=500; temp=temp+25){
             idealPressure(temp);
             vanDerWaalsPressure(a,b,temp);// giving values to method 
             percentError(idealPressure(temp),vanDerWaalsPressure(a,b,temp));
             ps.printf("%20S %20.2f  %20.2f  %20.2f%n",
             gas,idealPressure(temp),
             +vanDerWaalsPressure(a,b,temp),
            +percentError(idealPressure(temp),vanDerWaalsPressure(a,b,temp)));
                
       
            }
                ps.println();
                ps.println("         Name of Element.         Ideal Pressure."
                           +"        V.D  Waals Pres.       %Error.");
                ps.println();
        }
                ps.println("End of the Table.");
    }
    
    // Tne method will calculate pressure for ideal gas.
    public static double idealPressure(double temp) {
    final double volume=1.0, numOfMols=1.0, R=0.0821;
    double pressure;//locaL variable 
        
        pressure=(numOfMols*R*temp)/volume;
        
       return pressure;
    }
    
    // Tne method will calculate pressure for Vander der Waals Equation.
    public static double vanDerWaalsPressure(double a, double b, double temp){
    final double volume=1.0, numOfMols=1.0, R=0.0821;
    double pressure;
        
        pressure=((numOfMols*R*temp)/(volume-numOfMols*b))
                -((Math.sqrt(numOfMols)*a)/Math.sqrt(volume)); 
        
        return pressure;
    }
    
    // Tne method will calculate percent error. 
    public static double percentError(double P_ideal, double P_vanderWaals ){
        double percentError;
         percentError =((P_ideal-P_vanderWaals)/P_vanderWaals)*100;
         
         return percentError;
         
     }
}
 
