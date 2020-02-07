package com.example.rydeapp;

public abstract class trip {
    private final double baseFare = 2.5;
    private final double serviceFare = 1.75;
    private final double mininumFare = 6.25;
    private final double pricePerKmBase = 0.81;
    private double pricePerKm;
    private double distanceCharge;
    private double distance;
    private double totalPrice;


    public void surgePriceCaculate(){

    }

    public double getBaseFare() {
        return baseFare;
    }

    public double getServiceFare() {
        return serviceFare;
    }

    public double getMininumFare() {
        return mininumFare;
    }

    public double getPricePerKmBase() {
        return pricePerKmBase;
    }
    public double getDistanceCharge() {
        return distanceCharge;
    }

    public double getDistance() {
        return distance;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setDistanceCharge(double distanceCharge) {
        this.distanceCharge = distanceCharge;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setPricePerKm(double pricePerKm) {
        this.pricePerKm = pricePerKm;
    }

    public void TotalPriceCalculator(){
        double tPrice;
        tPrice = baseFare + distanceCharge + serviceFare;

        if(tPrice < mininumFare) {
            totalPrice = mininumFare;
        } else {
            totalPrice = tPrice;
        }
    }

    public abstract void PricePerKmCalculate();

    public void DistanceChargeCalculate() {
        distanceCharge = pricePerKm * distance;
    }

}
