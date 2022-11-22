package com.example.app_multiactivity;

import android.text.InputFilter;
import android.text.Spanned;

public class MinMax implements InputFilter {

    private double min, max;

    public MinMax(double min, double max){
        this.min = min;
        this.max = max;
    }

    public MinMax (String min, String max){
        this.min = Double.parseDouble(min);
        this.max = Double.parseDouble(max);
    }

    private boolean isInRange(double a, double b, double c){
        return b > a ? c >= a && c <= b : c >= b && c <= a;
    }

    @Override
    public CharSequence filter(CharSequence charSequence, int i, int i1, Spanned spanned, int i2, int i3) {
        try {
            int input = Integer.parseInt(spanned.toString() + charSequence.toString());
            if (isInRange(min, max, input))
                return null;
        } catch (NumberFormatException nfe) { }
        return "";
    }
}