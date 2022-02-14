package com.company;

import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-----------------");
        for (double balance : calculator.gerRemainingBalances())
            System.out.println(currency.format(balance));
    }

    public void printMortgage() {
        double mortage = calculator.caluculateMortage();
        String mortageFormatted = currency.format(mortage);
        System.out.println();
        System.out.println("MORTAGE");
        System.out.println("--------");
        System.out.println("Mortage: " + mortageFormatted);
    }
}
