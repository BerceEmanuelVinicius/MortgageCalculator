package com.company;

public class MortgageCalculator {
    private final static byte MONTHS_IN_YEARS = 12;
    private final static byte PERCENT = 100;
    private int principal;
    private float anualInterest;
    private byte years;

    public MortgageCalculator(int principal, float anualInterest, byte years) {
        this.principal = principal;
        this.anualInterest = anualInterest;
        this.years = years;
    }


    public double calculateBalance(short numberOfPaymentsMade) {

        float monthlyInrest = getMonthlyInrest();
        float numberOfPaymanets = getNumberOfPaymanets();

        double balace = principal * (Math.pow(1 + monthlyInrest, numberOfPaymanets) - Math.pow(1 + monthlyInrest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInrest, numberOfPaymanets) - 1);

        return balace;
    }


    public double caluculateMortage() {

        float monthlyInrest = getMonthlyInrest();
        short numberOfPaymanets = (short) (getNumberOfPaymanets());
        double mortage = principal * (monthlyInrest * Math.pow(1 + monthlyInrest, numberOfPaymanets))
                / (Math.pow(1 + monthlyInrest, numberOfPaymanets) - 1);
        return mortage;
    }

    public double[] gerRemainingBalances() {
        var balances = new double[getNumberOfPaymanets()];
        for (short month = 1; month <= balances.length; month++)
            balances[month - 1] = calculateBalance(month);
        return balances;
    }

    private float getMonthlyInrest() {
        return anualInterest / PERCENT / MONTHS_IN_YEARS;
    }

    private int getNumberOfPaymanets() {
        return years * MONTHS_IN_YEARS;
    }
}