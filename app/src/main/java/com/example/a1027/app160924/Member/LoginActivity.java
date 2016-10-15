package com.example.a1027.app160924.Member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a1027.app160924.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt_login,bt_join;
    EditText et_id,et_pw;
    MemberService service;    // MemberServiceImpl의 변수 로딩

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        service = new MemberServiceImpl(this.getApplicationContext());

        bt_login = (Button) findViewById(R.id.bt_login);
        bt_join = (Button) findViewById(R.id.bt_join);
        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);

        bt_login.setOnClickListener(this);
        bt_join.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String  id = et_id.getText().toString(),
                pw = et_pw.getText().toString();
        MemberDTO param = new MemberDTO();

        switch (v.getId()) {
            case R.id.bt_login:
                Toast.makeText(LoginActivity.this,
                        "ID : "+id+"PASS : "+ pw,
                        Toast.LENGTH_LONG).show();
                param.setId(id);
                param.setPw(pw);
                //1015 수정
                MemberDTO result = service.getOne(param);

                if (result == null){
                    Toast.makeText(LoginActivity.this,
                            "존재하지 않는 아이디입니다.",
                            Toast.LENGTH_LONG).show();
                }
                else if(result.getId().equals(param.getPw())){
                    startActivity(new Intent(LoginActivity.this, ListActivity.class));
                }
                else{
                    Toast.makeText(LoginActivity.this,
                            "비밀번호가 일치하지 않습니다.",
                            Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.bt_join:
                startActivity(new Intent(LoginActivity.this, JoinActivity.class));
                break;
        }

    }
}
