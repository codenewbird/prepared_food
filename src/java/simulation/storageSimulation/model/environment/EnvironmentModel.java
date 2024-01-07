package model.environment;

import java.math.BigDecimal;
import java.util.Random;

/*
    环境模型
    对于环境中的每一个数值都应该有一个模型
    具有模拟的具体值
    以及波动的区间值
*/
public class EnvironmentModel {

    /*
        环境某一属性的具体值
        该属性的随机波动区间
        以及波动的时间片
    */
    private BigDecimal value;
    private BigDecimal randMin;
    private BigDecimal randMax;

    /*
        构造函数
    */
    public EnvironmentModel(double randMin,double randMax) {
        this.randMin = new BigDecimal(randMin);
        this.randMax = new BigDecimal(randMax);

        this.value = this.randMin.add(this.randMax).divide(new BigDecimal(2));
    }

    /*
        获取模型当前值
    */
    public double getValue() {
        return value.doubleValue();
    }

    /*
        模拟环境值随机波动
        随机波动，概率均等
    */
    public void valRand() {
        Random rand = new Random();
        /*
            state有-1、0、1三种状态，正好表示上下波动或不变
        */
        int state = rand.nextInt(3) - 1;
        value = value.add(new BigDecimal(state).multiply(new BigDecimal(0.1)));

        value = max(randMin,value);
        value = min(randMax,value);
    }

    
    

    BigDecimal max(BigDecimal a,BigDecimal b) {
        if(a.compareTo(b) == -1)return b;
        return a;
    }

    BigDecimal min(BigDecimal a,BigDecimal b) {
        if(a.compareTo(b) == -1) return a;
        return b;
    }

}