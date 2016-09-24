package com.example.a1027.app160924;

/**
 * Created by 1027 on 2016-09-24.
 */

public class CalcDTO {
    //은닉화
    private int cal;

    public int getNum1() {
        return cal;
    }

    public CalcDTO(int num1) {
        this.cal = cal;
    }

    public int getNum2() {
        return num2;
    }

    public int getResult() {
        return result;
    }

    public CalcDTO(int num1, int num2, int result) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
    }
}
