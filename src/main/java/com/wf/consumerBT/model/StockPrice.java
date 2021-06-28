package com.wf.consumerBT.model;

import org.springframework.stereotype.Component;

@Component
public class StockPrice {

    public  double callPrice(double initialIndexPrice,double strickPrice,double risk,double sigma,double timeToMatuirty){
        double  a = (Math.log(initialIndexPrice/strickPrice) + (risk + sigma * sigma/2.0) * timeToMatuirty) /  (sigma * Math.sqrt(timeToMatuirty));
        double b = a - sigma * Math.sqrt(timeToMatuirty);
        return initialIndexPrice * cdf(a,0.0,1.0) - strickPrice * Math.exp(-risk * timeToMatuirty) * cdf(b,0.0,1.0);
    }


    private  double cdf(double z,double mu,double sigma){
        return   Phi((z - mu) / sigma);
    }



    private  double Phi(double z){
        if (z < -8.0) return 0.0;
        if (z >  8.0) return 1.0;
        double total = 0.0;
        double term = z;
        int i = 3;
        while (total != total + term){
            total += term;
            term *= z * z /  i;
            i += 2;
        }
        return 0.5 + total * phi(z);
    }

    private  double phi(double x){
        return Math.exp(-x * x / 2.0) / Math.sqrt(2.0 * Math.PI);
    }


}
