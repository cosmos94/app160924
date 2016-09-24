package com.example.a1027.app160924;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//1
//public class CalcActivity extends AppCompatActivity {
//extends 상속 ( AppCompatActivity가 가지는 모든기능을 CalcActivity가 상속한다.
//동작에 관한 기능은 포함하지 않는다.

//2
//public class CalcActivity extends AppCompatActivity implements View.OnClickListener{
//동작에 관한 기능은 포함 할때 implements View.OnClickListener 추가한다.

//3
public class CalcActivity extends AppCompatActivity implements View.OnClickListener{

    // 속성 또는 변수 정의
    //전역변수 선언
    EditText et_num_1;
    EditText et_num_2;
    Button bt_cal_1,bt_cal_2,bt_cal_3,bt_cal_4,bt_cal_5,bt_cal_6;
    TextView tv_1;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        //정의된 속성을 연계 ( 인스턴스 할당 )
        et_num_1 = (EditText) findViewById(R.id.et_num_1);
        // edit text1 박스의 값의 모든 속성과 개체를 받아 들인다.
        et_num_2 = (EditText) findViewById(R.id.et_num_2);
        // edit text2 박스의 값의 모든 속성과 개체를 받아 들인다.

        bt_cal_1 = (Button) findViewById(R.id.bt_cal_1); //+
        bt_cal_2 = (Button) findViewById(R.id.bt_cal_2); //-
        bt_cal_3 = (Button) findViewById(R.id.bt_cal_3); //*
        bt_cal_4 = (Button) findViewById(R.id.bt_cal_4); ///
        bt_cal_5 = (Button) findViewById(R.id.bt_cal_5); //%
        bt_cal_6 = (Button) findViewById(R.id.bt_cal_6); //=

        bt_cal_1.setOnClickListener(this);
        bt_cal_2.setOnClickListener(this);
        bt_cal_3.setOnClickListener(this);
        bt_cal_4.setOnClickListener(this);
        bt_cal_5.setOnClickListener(this);
        bt_cal_6.setOnClickListener(this);

        tv_1 = (TextView) findViewById(R.id.tv_1); //결과값값
    }

    @Override
    public void onClick(View v) {
        //지역변수 선언
        int num1 = Integer.parseInt (et_num_1.getText().toString());
        //텍스트 박스에서 가져온 스트링을 정수로 변경
        int num2 = Integer.parseInt (et_num_2.getText().toString());
   //원 표현
 //       String s = et_num_1.getText().toString();
 //       int num1 = Integer.parseInt (s);

        switch(v.getId()){
            // 가져올때 get 내보낼때 set
            case R.id.bt_cal_1 :
                result = num1 + num2;
                break;  // +
            case R.id.bt_cal_2 :
                result = num1 - num2;
                break;  // -
            case R.id.bt_cal_3 :
                result = num1 * num2;
                break;  // *
            case R.id.bt_cal_4 :
                result = num1 / num2;
                break;  // /
            case R.id.bt_cal_5 :
                result = num1 % num2;
                break;  // %
            case R.id.bt_cal_6 :
//                tv_1.setText(result);
                tv_1.setText("결과 :" + result);
                break;  // =
        }
    }
}
