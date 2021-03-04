/**
 * @author Farukh Khassan Khojayev.
 * @since 10-30-2019
 * @vesion 1.0
 * 
 * This program is calculating the pressure of  element by using the
 * ideal gas equation and Van der Waals Equation, then the program calculate
 * percent error of two pressures. To calculate ideal gas I used method 
 * idealPressure. The method receive the temperature from the main and then 
 * calculating the pressure by using  pressure=(numOfMols*R*temp)/volume;
 * where numofMols and volume is equal to 1 and the R is constant. Then, method 
 * return pressure to main. Next, to calculate Van der Waals Equation, I used
 * vanDerWaalsPressure method. The method receive temperature, "a" and "b"
 * from the main. Then the method calculate pressure by using next equation
 *           pressure=((numOfMols*R*temp)/(volume-numOfMols*b))
                -((Math.sqrt(numOfMols)*a)/Math.sqrt(volume));
 * where numofMols and volume is equal to 1 and the R is constant, "a" and "b"
 * are the values from text file. Then, method return pressure to the main.
 * My last method is percentError, which is calculating percent error of two
 * previous pressures by using next equation 
 *         percentError =((P_ideal-P_vanderWaals)/P_vanderWaals)*100;
 * where P_ideal and P_vanderWaals are values of pressure. The main of program 
 * can reed the data from a file and send the output to the file. Main also 
 * has a for loop which is increment the temperature from 100 to 500 by 25 K 
 * degree. And sending this values to methods. Also, method has a while loop
 * with hasNext method to reed string and two doubles from the file. 
 * 
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
 
