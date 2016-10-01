package com.example.a1027.app160924.Member;

import android.util.Log;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberServiceImpl implements MemberService{
    MemberDAO dao = new MemberDAO();

    @Override
    public MemberDTO login(MemberDTO param) {
        Log.i(">> SERVICE 받은 id : ",param.getId());
        Log.i(">> SERVICE 받은 pw : ",param.getPw());

        MemberDTO member = new MemberDTO();
        member = dao.select(param);
        if( member == null ) {
            member.setId("NONE");
            member.setId(param.getId()+"는 존재하지 않는 아이디입니다.");
            return member;
        }
        else if(member.getPw().equals(param.getPw())){
            return member;
        }
        else{
            member.setId("NO_MATCH");
            member.setId(param.getId()+"의 비밀번호가 일치하지 않습니다.");
            return member;
        }

    }

    @Override
    public MemberDTO join(MemberDTO param) {
        return null;
    }
}
