package com.example.rydeapp;

public class pool extends trip {

    public void PricePerKmCalculate(){
        setDistanceCharge(getPricePerKmBase() * 0.9);
        surgePriceCaculate();
    }
}
