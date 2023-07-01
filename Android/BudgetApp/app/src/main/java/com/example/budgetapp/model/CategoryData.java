package com.example.budgetapp.model;

import android.content.Context;

public class CategoryData {

        private double amount;
        private String category;

        public CategoryData(double amount, String category) {
            this.amount = amount;
            this.category = category;

        }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }
}
