package com.example.demo.calc;

public class LoanPayment {

    //-----------------------------Рассчеты переменных:

    // Рассчитываем ежемесячную процентную ставку:
    public static float getEveryMonthProcents(float yearProcents){
        return yearProcents/100/12;
    }

    // Рассчет  аннуитетнного коэффициента
    public static float getAnnuitantPaymentSum(float yearProcent, float month){
        float result = 0f;
        float everyMonthProcent = getEveryMonthProcents(yearProcent);

        result = (float) (everyMonthProcent*Math.pow((1+everyMonthProcent),(month*12))/
                (Math.pow((1+everyMonthProcent),(month*12))-1));
        return result;
    }

    // Рассчет ежемесячного аннуитетного платежа
    public static float getPercentPayments(float summ,float yearProcent, float month){
        return summ * getAnnuitantPaymentSum(yearProcent,month);
    }

    // Переплата:
    public static float getBodyPayments(float summ, float yearProcent,float month){
        return (getPercentPayments(summ, yearProcent, month)*12*month) - summ;
    }

}
