/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
package MeisterFutureValueApp;

public class FinanceCalculator {
    private static int MONTHS_IN_YEAR;

    public FinanceCalculator()
    {
        MONTHS_IN_YEAR = 12;
    }
    double calculateFutureValue(double monthlyPayment, double rate, Integer years)
    {
        int months = years * MONTHS_IN_YEAR;
        double interest_rate = (1 + rate / 100);
        double presentValue = monthlyPayment * months;
        double futurevalue = presentValue * (Math.pow(interest_rate, months));
        return futurevalue;

    }


}
