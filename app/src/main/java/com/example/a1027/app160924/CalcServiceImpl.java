package com.example.a1027.app160924;

/**
 * Created by 1027 on 2016-09-24.
 */

public class CalcServiceImpl implements CalcService{

    @Override
    public CalcDTO plus(CalcDTO calc) {
        return null;
    }

    @Override
    public CalcDTO minus(CalcDTO calc) {
        int num1 = calc.getNum1();
        int num2 = calc.getNum2();
        int result = num1 - num2;
        calc.getResult(result);
        return null;
    }

    @Override
    public int multi() {
        return 0;
    }

    @Override
    public int divid() {
        return 0;
    }

    @Override
    public int remain() {
        return 0;
    }
}
