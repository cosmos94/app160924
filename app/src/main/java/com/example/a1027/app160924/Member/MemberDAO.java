package com.example.a1027.app160924.Member;

import android.util.Log;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberDAO {
    public MemberDTO select(MemberDTO param){
        Log.i(">> DAO 받은 id : ",param.getId());
        Log.i(">> DAO 받은 pw : ",param.getPw());
        MemberDTO member = new MemberDTO();
        member.setId("Kim");
        member.setPw("1234");
        member.setName("홍길동");
        return member;
    }
    public MemberDTO insert(MemberDTO param){
        MemberDTO member = new MemberDTO();
        return member;
    }
    public MemberDTO update(MemberDTO param){
        MemberDTO member = new MemberDTO();
        return member;
    }
    public MemberDTO delete(MemberDTO param){
        MemberDTO member = new MemberDTO();
        return member;
    }

}
