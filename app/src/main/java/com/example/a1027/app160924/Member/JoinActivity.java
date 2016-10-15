package com.example.a1027.app160924.Member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a1027.app160924.MainActivity;
import com.example.a1027.app160924.R;

public class JoinActivity extends AppCompatActivity implements View.OnClickListener{
    Button bt_submit,bt_cancel;
    EditText et_id,et_pw,et_name,et_email,et_addr,et_phone;
//    MemberService service = new MemberServiceImpl();    // MemberServiceImpl의 변수 로딩
    MemberService service;    // MemberServiceImpl의 변수 로딩

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        service = new MemberServiceImpl(this.getApplicationContext());

        bt_submit = (Button) findViewById(R.id.bt_submit);
        bt_cancel = (Button) findViewById(R.id.bt_cancel);

        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        et_name = (EditText) findViewById(R.id.et_name);
        et_email = (EditText) findViewById(R.id.et_email);
        et_addr = (EditText) findViewById(R.id.et_addr);
        et_phone = (EditText) findViewById(R.id.et_phone);

        bt_submit.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
/*순서대로
//        String id = et_id.getText().toString();
//        String pw = et_pw.getText().toString();
//        String name = et_name.getText().toString();
        String email = et_email.getText().toString();
        String addr = et_addr.getText().toString();
        String phone = et_phone.getText().toString();
*/
        MemberDTO member = new MemberDTO();
/*        member.setId(id);
        member.setId(pw);
        member.setId(name);
        member.setEmail(email);
        member.setPhone(phone);
        member.setAddr(addr);
*/
        member.setId(et_id.getText().toString());
        member.setPw(et_pw.getText().toString());
        member.setName(et_name.getText().toString());
        member.setEmail(et_email.getText().toString());
        member.setPhone(et_addr.getText().toString());
        member.setAddr(et_phone.getText().toString());

        switch (v.getId()){
            case R.id.bt_submit:
                service.regist(member);
                /* 1015 리턴이 없으므로 삭제
                if(val.getMessage().equals("SUCCESS")){
                    Toast.makeText(JoinActivity.this,
                            "회원가입에 성공하였습니다. 로그인하여주십시요",
                            Toast.LENGTH_LONG).show();
                    startActivity(new Intent(JoinActivity.this, LoginActivity.class));
                }
                else{
                    Toast.makeText(JoinActivity.this,
                        "회원가입에 실패하였습니다. 다시 시도하여주십시요",
                        Toast.LENGTH_LONG).show();
                }*/
                startActivity(new Intent(JoinActivity.this, LoginActivity.class));
                break;
            case R.id.bt_cancel:
                startActivity(new Intent(JoinActivity.this, MainActivity.class));
                break;
        }
    }
}
