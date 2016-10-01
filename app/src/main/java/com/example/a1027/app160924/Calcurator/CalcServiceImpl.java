package com.example.a1027.app160924.Calcurator;

/**
 * Created by 1027 on 2016-09-24.
 */

public class CalcServiceImpl implements CalcService{


    @Override
    public CalcDTO plus(CalcDTO calc) {
        int num1 = calc.getNum1();
        int num2 = calc.getNum2();
        int result = num1 + num2;
        calc.setResult(result);
        return calc;
//        return null;
    }

    @Override
    public CalcDTO minus(CalcDTO calc) {
        int num1 = calc.getNum1();
        int num2 = calc.getNum2();
        int result = num1 - num2;
        calc.setResult(result);
        return calc;
//        return null;
    }

    @Override
    public CalcDTO multi(CalcDTO calc) {
        int num1 = calc.getNum1();
        int num2 = calc.getNum2();
        int result = num1 * num2;
        calc.setResult(result);
        return calc;
//        return null;
    }

    @Override
    public CalcDTO div(CalcDTO calc){
        int num1 = calc.getNum1();
        int num2 = calc.getNum2();
        int result = num1 / num2;
        calc.setResult(result);
        return calc;
//        return null;
}

    @Override
    public CalcDTO remain(CalcDTO calc) {
        int num1 = calc.getNum1();
        int num2 = calc.getNum2();
        int result = num1 % num2;
        calc.setResult(result);
        return calc;
//        return null;
    }
}
