package com.cs50.electron3d.autocalc;

public class AutoCalculator {

    private int carPrice;
    private int timeOfOwnership;
    private int annualMileage;
    private float lostProfit;
    private float lossOfValue;
    private boolean isCredit;
    private int amountOfCredit;
    private int creditTerm;
    private float interestRate;
    private boolean isInsurance;
    private int vehiclePower;
    private float fuelConsumption;
    private float fuelPrice;
    private final int repair;
    public final int MTPL = 5398;
    public final int HULL_INSURANCE = 36500;

    public AutoCalculator(int carPrice, int timeOfOwnership, int annualMileage, float lostProfit,
                          float lossOfValue, boolean isCredit, int amountOfCredit, int creditTerm,
                          float interestRate, boolean isInsurance, int vehiclePower, float fuelConsumption, float fuelPrice, int repair) {
        this.carPrice = carPrice;
        this.timeOfOwnership = timeOfOwnership;
        this.annualMileage = annualMileage;
        this.lostProfit = lostProfit;
        this.lossOfValue = lossOfValue;
        this.isCredit = isCredit;
        this.amountOfCredit = amountOfCredit;
        this.creditTerm = creditTerm;
        this.interestRate = interestRate;
        this.isInsurance = isInsurance;
        this.vehiclePower = vehiclePower;
        this.fuelConsumption = fuelConsumption;
        this.fuelPrice = fuelPrice;
        this.repair = repair;
    }

    public int getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(int carPrice) {
        this.carPrice = carPrice;
    }

    public int getTimeOfOwnership() {
        return timeOfOwnership;
    }

    public void setTimeOfOwnership(int timeOfOwnership) {
        this.timeOfOwnership = timeOfOwnership;
    }

    public int getAnnualMileage() {
        return annualMileage;
    }

    public void setAnnualMileage(int annualMileage) {
        this.annualMileage = annualMileage;
    }

    public float getLostProfit() {
        return lostProfit;
    }

    public void setLostProfit(int lostProfit) {
        this.lostProfit = lostProfit;
    }

    public float getLossOfValue() {
        return lossOfValue;
    }

    public void setLossOfValue(int lossOfValue) {
        this.lossOfValue = lossOfValue;
    }

    public boolean isCredit() {
        return isCredit;
    }

    public void setCredit(boolean credit) {
        isCredit = credit;
    }

    public int getAmountOfCredit() {
        return amountOfCredit;
    }

    public void setAmountOfCredit(int amountOfCredit) {
        this.amountOfCredit = amountOfCredit;
    }

    public int getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(int creditTerm) {
        this.creditTerm = creditTerm;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public boolean isInsurance() {
        return isInsurance;
    }

    public void setInsurance(boolean insurance) {
        isInsurance = insurance;
    }

    public int getVehiclePower() {
        return vehiclePower;
    }

    public void setVehiclePower(int vehiclePower) {
        this.vehiclePower = vehiclePower;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public float getFuelPrice() {
        return fuelPrice;
    }

    public void setFuelPrice(int fuelPrice) {
        this.fuelPrice = fuelPrice;
    }

    public float fuelCostPerYear() {
        return fuelConsumption * annualMileage / 100 * fuelPrice;
    }

    public float fuelCostTotal() {
        return fuelCostPerYear() * timeOfOwnership;
    }

    public float taxPerYear() {
        int rate = 0;
        if (vehiclePower < 100) {
            rate = 12;
        } else if (vehiclePower < 125) {
            rate = 25;
        } else if (vehiclePower < 150) {
            rate = 35;
        } else if (vehiclePower < 175) {
            rate = 45;
        } else if (vehiclePower < 200) {
            rate = 50;
        } else if (vehiclePower < 225) {
            rate = 65;
        } else if (vehiclePower < 250) {
            rate = 75;
        } else {
            rate = 150;
        }
        return vehiclePower * rate;
    }

    public float taxTotal() {
        return taxPerYear() * timeOfOwnership;
    }

    public float lostProfitCalc() {
        float forMonth = (float) carPrice / 100 * lostProfit / 12;
        float deposit = carPrice + forMonth;
        for (int i = timeOfOwnership * 12; i > 1; i--) {
            forMonth = deposit / 100 * lostProfit / 12;
            deposit = deposit + forMonth;
        }
        return  deposit - carPrice;
    }

    public float lossOfValueCalc() {
        float sum = (float) carPrice / 100 * lossOfValue;
        for (int i = timeOfOwnership; i > 1; i--) {
            sum = sum + ((float)carPrice - sum) / 100 * lossOfValue;
        }
        return sum;
    }

    public float credit() {
        float i = interestRate / 1200;
        float creditPerMonth = (float) (((i * Math.pow((i + 1), creditTerm)) / ((Math.pow((i + 1), creditTerm)) - 1)) * amountOfCredit);
        return creditTerm * creditPerMonth - amountOfCredit;
    }

    public float carCostTotal() {
        float total = 0;
        if (isCredit) {
            if (isInsurance) {
                total = (taxPerYear() + fuelCostPerYear() + MTPL + repair + HULL_INSURANCE) * timeOfOwnership + credit() + lossOfValueCalc() + lostProfitCalc();
            } else {
                total = (taxPerYear() + fuelCostPerYear() + MTPL + repair) * timeOfOwnership + credit() + lossOfValueCalc() + lostProfitCalc();
            }
        } else {
            if (isInsurance) {
                total = (taxPerYear() + fuelCostPerYear() + MTPL + repair + HULL_INSURANCE) * timeOfOwnership + lossOfValueCalc() + lostProfitCalc();
            } else {
                total = (taxPerYear() + fuelCostPerYear() + MTPL + repair) * timeOfOwnership + lossOfValueCalc() + lostProfitCalc();
            }
        }
        return total;
    }

    public float carCostPerYear() {
        return carCostTotal() / timeOfOwnership;
    }

    public float carCostPerMonth() {
        return carCostPerYear() / 12;
    }

    public float carCostPerKm() {
        return  carCostPerYear() / annualMileage;
    }

    public float mtplTotal() {
        return MTPL * timeOfOwnership;
    }

    public float insuranceTotal() {
        return HULL_INSURANCE * timeOfOwnership;
    }
}