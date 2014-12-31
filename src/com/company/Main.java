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

    double amountTendered;
    double productVal;


    double changeVal;
    int[] change = new int[8];
    String[] changeTitle = {"Twenty(s)", "Ten(s)", "Five(s)", "One(s)", "Quarter(s)", "Dime(s)", "Nickel(s)", "Penny(s)"};

    private final double TWENTY_VAL = 20.00;
    private final double TEN_VAL = 10.00;
    private final double FIVE_VAL = 5.00;
    private final double DOLLAR_VAL = 1.00;

    private final double QUARTER_VAL = 0.25;
    private final double DIME_VAL = 0.10;
    private final double NICKEL_VAL = 0.05;
    private final double PENNY_VAL = 0.01;


    public static void main(String[] args) {
        Main main = new Main(245.00, 47.02);

        main.figureChange();
        System.out.println("Change Amount: " + main.getChangeVal());

        main.giveChange();
        main.changePrintOut();
    }

    private void changePrintOut() {
        for (int x = 0; x < getChange().length; x++){
            System.out.println(changeTitle[x] + "\t\t\t " + getChange()[x]);
        }
    }

    private void giveChange() {
        double change = getChangeVal();
        double holder = 0;
        double newChange;
        int[] changeLocal = new int[8];

        //while (change != 0) {
            if (change >= TWENTY_VAL) {
                holder = change / TWENTY_VAL;
                changeLocal[0] = (int) holder;
                holder = change - (changeLocal[0] * TWENTY_VAL);
                change = holder;
            }
            if (change > TEN_VAL) {
                holder = change / TEN_VAL;
                changeLocal[1] = (int) holder;
                holder = change - (changeLocal[1] * TEN_VAL);
                change = holder;
            }
            if (change > FIVE_VAL) {
                holder = change / FIVE_VAL;
                changeLocal[2] = (int) holder;
                holder = change - (changeLocal[2] * FIVE_VAL);
                change = holder;
            }
            if (change > DOLLAR_VAL) {
                holder = change / DOLLAR_VAL;
                changeLocal[3] = (int) holder;
                holder = change - (changeLocal[3] * DOLLAR_VAL);
                change = holder;
            }
            if (change > QUARTER_VAL) {
                holder = change / QUARTER_VAL;
                changeLocal[4] = (int) holder;
                holder = change - (changeLocal[4] * QUARTER_VAL);
                change = holder;
            }
            if (change > DIME_VAL) {
                holder = change / DIME_VAL;
                changeLocal[5] = (int) holder;
                holder = change - (changeLocal[5] * DIME_VAL);
                change = holder;
            }
            if (change > NICKEL_VAL) {
                holder = change / NICKEL_VAL;
                changeLocal[6] = (int) holder;
                holder = change - (changeLocal[6] * NICKEL_VAL);
                change = holder;
            }
            if (change > PENNY_VAL) {
                holder = change / PENNY_VAL;
                changeLocal[7] = (int) holder;
                holder = change - (changeLocal[7] * PENNY_VAL);
                change = holder;
                if (change != 0) {
                    changeLocal[7]++;
                    change = 0;
                } if (changeLocal[7] == 5){
                    changeLocal[7] = 0;
                    changeLocal[6]++;
                }
            }
       // }


        System.out.println(holder + " " + change);
        System.out.println(changeLocal[3]);

        setChange(changeLocal);


    }

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
