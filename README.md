# PressureOfElementByIdealGasEquation
 This program is calculating the pressure of  element by using the  ideal gas equation and Van der Waals Equation

  This program is calculating the pressure of  element by using the
  ideal gas equation and Van der Waals Equation, then the program calculate
  percent error of two pressures. To calculate ideal gas I used method 
  idealPressure. The method receive the temperature from the main and then 
  calculating the pressure by using  pressure=(numOfMols*R*temp)/volume;
  where numofMols and volume is equal to 1 and the R is constant. Then, method 
  return pressure to main. Next, to calculate Van der Waals Equation, I used
  vanDerWaalsPressure method. The method receive temperature, "a" and "b"
  from the main. Then the method calculate pressure by using next equation
            pressure=((numOfMols*R*temp)/(volume-numOfMols*b))
                -((Math.sqrt(numOfMols)*a)/Math.sqrt(volume));
  where numofMols and volume is equal to 1 and the R is constant, "a" and "b"
  are the values from text file. Then, method return pressure to the main.
  My last method is percentError, which is calculating percent error of two
  previous pressures by using next equation 
          percentError =((P_ideal-P_vanderWaals)/P_vanderWaals)*100;
  where P_ideal and P_vanderWaals are values of pressure. The main of program 
  can reed the data from a file and send the output to the file. Main also 
  has a for loop which is increment the temperature from 100 to 500 by 25 K 
  degree. And sending this values to methods. Also, method has a while loop
  with hasNext method to reed string and two doubles from the file. 
