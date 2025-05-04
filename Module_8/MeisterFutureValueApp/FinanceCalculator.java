/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
package MeisterFutureValueApp;

public class FinanceCalculator {
    private static int MONTHS_IN_YEAR;

    /*Default constructor*/
    public FinanceCalculator()
    {
        /*Default value of months in year.*/
        MONTHS_IN_YEAR = 12;
    }
    double calculateFutureValue(double monthlyPayment, double rate, Integer years)
    {
        /*Calculate the months.*/
        int months = years * MONTHS_IN_YEAR;
        /*Calculate the interest rate.*/
        double interest_rate = (1 + rate / 100);
        /*Calculate the present value */
        double presentValue = monthlyPayment * months;
        /*Calculate the future value.*/
        double futurevalue = presentValue * (Math.pow(interest_rate, months));
        /*Return the future value.*/
        return futurevalue;

    }


}
