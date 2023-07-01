package com.example.budgetapp.controllers;

import com.example.budgetapp.model.CategoryData;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ExpMovingAverage {

    DecimalFormat currency = new DecimalFormat("###,###.00");

    //m1, m2, m3 zijn de totaal bedragen van de afgelopen 2 maanden en de maand waarin de reset plaats vindt.
    public double m1;
    public double m2;
    public double m3;
    public double budget;
    public double Alpha;
    public double aPercent;
    public double pDiff;

    public ExpMovingAverage(ArrayList<CategoryData> arrayData, double budget) {
        this.m1 = arrayData.get(2).getAmount();
        this.m2 = arrayData.get(1).getAmount();
        this.m3 = arrayData.get(0).getAmount();
        this.budget = budget;

        //Percentage uitrekenen waarop de alpha waarde wordt bepaald
        //Er wordt gekeken hoever de afgelopen maand boven/onder het budget uitkomt.
        //Hoe groter het verschil, hoe zwaarder het mee zal wegen
        aPercent = Math.round(((budget - m1) / budget) * 100);

        if (aPercent < 0) {
            if (aPercent <= -1 & aPercent >= -10) {
                Alpha = 0.1;
            }
            if (aPercent <= -10 & aPercent >= -15) {
                Alpha = 0.15;
            }
            if (aPercent <= -16 & aPercent >= -20) {
                Alpha = 0.2;
            }
            if (aPercent <= -21 & aPercent >= -25) {
                Alpha = 0.25;
            }
            if (aPercent <= -26 & aPercent >= -30) {
                Alpha = 0.3;
            }
            if (aPercent <= -31 & aPercent >= -35) {
                Alpha = 0.35;
            }
            if (aPercent <= -36 & aPercent >= -40) {
                Alpha = 0.4;
            }
            if (aPercent <= -41 & aPercent >= -45) {
                Alpha = 0.45;
            }
            if (Alpha >= -46) {
                Alpha = 0.5;
            }
            } else if (aPercent > 0 & aPercent <= 10) {
                Alpha = 0.1;
            }
            if (aPercent >= 10 & aPercent <= 15) {
                Alpha = 0.15;
            }
            if (aPercent >= 16 & aPercent <= 20) {
                Alpha = 0.2;
            }
            if (aPercent >= 21 & aPercent <= 25) {
                Alpha = 0.25;
            }
            if (aPercent >= 26 & aPercent <= 30) {
                Alpha = 0.3;
            }
            if (aPercent >= 31 & aPercent <= 35) {
                Alpha = 0.35;
            }
            if (aPercent >= 36 & aPercent <= 40) {
                Alpha = 0.4;
            }
            if (aPercent >= 41 & aPercent <= 45) {
                Alpha = 0.45;
            }
            if (aPercent >= 46) {
                Alpha = 0.5;
            }

            Difference();

    }
        //Methode aangemaakt om aan te ze zorgen dat de return gebruikt kan worden in andere classes
        public double Difference(){

            double forecasted = ((m1 + m2 + m3) / 3);
            System.out.println("Forecasted: " + forecasted);

            double smoothed = Alpha * m1 + (1 - Alpha) * forecasted;
            System.out.println("Smoothed: " + smoothed);

            pDiff = Math.round((budget - smoothed) / budget * 100);
            System.out.println("Difference in percent: " + pDiff);

            return pDiff;
        }

}

