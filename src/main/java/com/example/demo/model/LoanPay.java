package com.example.demo.model;

import com.example.demo.calc.LoanPayment;

public class LoanPay {

    private float everyMonthProcents;
    private float annuitantPaymentSum;
    private float percentPayments;
    private float bodyPayments;

    public LoanPay(){

    }

    public LoanPay(float everyMonthProcents, float annuitantPaymentSum, float percentPayments, float bodyPayments) {
        this.everyMonthProcents = everyMonthProcents;
        this.annuitantPaymentSum = annuitantPaymentSum;
        this.percentPayments = percentPayments;
        this.bodyPayments = bodyPayments;
    }

    public float getEveryMonthProcents() {
        return everyMonthProcents;
    }

    public void setEveryMonthProcents(float everyMonthProcents) {
        this.everyMonthProcents = everyMonthProcents;
    }

    public float getAnnuitantPaymentSum() {
        return annuitantPaymentSum;
    }

    public void setAnnuitantPaymentSum(float annuitantPaymentSum) {
        this.annuitantPaymentSum = annuitantPaymentSum;
    }

    public float getPercentPayments() {
        return percentPayments;
    }

    public void setPercentPayments(float percentPayments) {
        this.percentPayments = percentPayments;
    }

    public float getBodyPayments() {
        return bodyPayments;
    }

    public void setBodyPayments(float bodyPayments) {
        this.bodyPayments = bodyPayments;
    }
}
