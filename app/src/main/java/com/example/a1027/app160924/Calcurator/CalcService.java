package com.example.a1027.app160924.Calcurator;

/**
 * Created by 1027 on 2016-09-24.
 */

public interface CalcService {
    public CalcDTO plus(CalcDTO calc);
    public CalcDTO minus(CalcDTO calc);
    public CalcDTO multi(CalcDTO calc);
    public CalcDTO div(CalcDTO calc);
    public CalcDTO remain(CalcDTO calc);
}
