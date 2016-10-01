package com.example.a1027.app160924.Member;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.a1027.app160924.util.Retval;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberDAO extends SQLiteOpenHelper {

    //DAO의 기능을 갖기위해 상속 (EXTENDS)하고 SQLiteOpenHelper에서 받는다.
    public MemberDAO(Context context) {
        super(context, "hanbit db",null,1);
        //위치값, 만드려는 디비명칭, 팩토리, 버전
        this.getWritableDatabase(); //입력가능한 db로 생성
        Log.d("db가 생성완료시 표시하라","성공 !!");
    }

    public MemberDTO select(MemberDTO param){
        Log.i(">> DAO 받은 id : ",param.getId());
        Log.i(">> DAO 받은 pw : ",param.getPw());
        MemberDTO member = new MemberDTO();
        member.setId("Kim");
        member.setPw("1234");
        member.setName("홍길동");
        return member;
    }
/*    public MemberDTO insert(MemberDTO param){
        MemberDTO member = new MemberDTO();
        return member;
    }*/
    public Retval insert(MemberDTO param){
        Retval val = new Retval();
        if(true){
            val.setMessage("SUCCESS");
        }else{
            val.setMessage("FAIL");
        }
        return val;
    }
    public MemberDTO update(MemberDTO param){
        MemberDTO member = new MemberDTO();
        return member;
    }
    public MemberDTO delete(MemberDTO param){
        MemberDTO member = new MemberDTO();
        return member;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
