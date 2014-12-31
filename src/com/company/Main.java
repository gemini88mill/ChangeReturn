package com.company;


import java.util.Arrays;

/**
 * Change Return program:
 *
 * The user enters a cost and then the amount of money given.
 * The program will figure out the change and the number of
 * quarters, dimes, nickels, pennies needed for the change.
 *
 * @author Raphael Miller
 */
public class Main {

    //variables in constructor
    private double amountTendered;
    private double productVal;

    //all other variables without constructor
    private double changeVal;
    private int[] change = new int[8];

    //finals
    private final String[] changeTitle = {"Twenty(s)", "Ten(s)  ", "Five(s)  ", "One(s)  ", "Quarter(s)", "Dime(s)  ", "Nickel(s)", "Penny(s)"};
    private final double[] TENDER_VAL = {20.00, 10.00, 5.00, 1.00, 0.25, 0.10, 0.05, 0.01};


    /**
     * main method
     *
     * starts program, executes two values within the constructor and proceeds
     * to calculate the amount of change needed to make correct change.
     * @param args
     */
    public static void main(String[] args) {
        Main main = new Main(51.00, 47.89);

        main.figureChange();
       // main.roundChange();
        System.out.println("Change Amount: " + main.getChangeVal());

        main.giveChange();
        main.changePrintOut();
    }


    /**
     * simple change print out
     */
    private void changePrintOut() {
        for (int x = 0; x < getChange().length; x++){
            System.out.println(changeTitle[x] + "\t\t\t " + getChange()[x]);
        }
    }

    /**
     * giveChange()
     *
     * change calculated and counts the tender amount needed to give back
     * the correct amount of change
     */
    private void giveChange() {
        double change = getChangeVal();
        double holder = 0;
        double newChange;
        int[] changeLocal = new int[8];

        for (int x = 0; x < TENDER_VAL.length; x++){
            if (change >= TENDER_VAL[x]){
                holder = change / TENDER_VAL[x];
                changeLocal[x] = (int) holder;
                holder = change - (changeLocal[x] * TENDER_VAL[x]);
                change = holder;
            }
        }

        System.out.println(holder + " " + change);
        System.out.println(changeLocal[3]);

        setChange(changeLocal);


    }

    /**
     * calculates change needed from perams
     */
    private void figureChange() {
        setChangeVal(getAmountTendered() - getProductVal());

    }



    //---------- Constructor------------------------------------

    public Main(double amountTendered, double productVal) {
        this.amountTendered = amountTendered;
        this.productVal = productVal;
    }

    //----------------------------------------------------------

    //--------------getters and setters-------------------------

    public double getAmountTendered() {
        return amountTendered;
    }

    public void setAmountTendered(double amountTendered) {
        this.amountTendered = amountTendered;
    }

    public double getProductVal() {
        return productVal;
    }

    public void setProductVal(double productVal) {
        this.productVal = productVal;
    }

    public double getChangeVal() {
        return changeVal;
    }

    public void setChangeVal(double changeVal) {
        this.changeVal = changeVal;
    }

    public int[] getChange() {
        return change;
    }

    public void setChange(int[] change) {
        this.change = change;
    }
    //---------------------------------------------------------
}
