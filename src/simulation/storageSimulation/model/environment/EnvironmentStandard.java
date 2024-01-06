package model.environment;


/*
    环境标准
    对某一环境属性值的区间作出要求
*/
public class EnvironmentStandard {
    double maximum;
    double minimum;

    public EnvironmentStandard(double minimum,double maximum) {
        this.maximum = maximum;
        this.minimum = minimum;
    }

    public double getMinimum() {
        return minimum;
    }

    public double getMaximum() {
        return maximum;
    }
}