package com.example.a1027.app160924.Member;

import android.content.Context;
import android.util.Log;

import com.example.a1027.app160924.util.Retval;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberServiceImpl implements MemberService{
/*    MemberDAO dao = new MemberDAO();
//db 생성을 위해 컨스트럭터를 생성 하기 루틴으로 분할

    MemberDAO dao;

    public MemberServiceImpl(MemberDAO dao) {
        this.dao = dao;
    }
*/
    MemberDAO dao;

    public MemberServiceImpl(Context context) {
        this.dao = new MemberDAO(context);
    }
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
/*    public MemberDTO join(MemberDTO param) {
        Log.i("** SERVICE 받은 id : ",param.getId());
        Log.i("** SERVICE 받은 pw : ",param.getPw());
        Log.i("** SERVICE 받은 name : ",param.getPw());
        Log.i("** SERVICE 받은 email : ",param.getPw());
        Log.i("** SERVICE 받은 addr : ",param.getPw());
        Log.i("** SERVICE 받은 phone : ",param.getPw());
        return dao.insert(param);
    }*/
    public Retval join(MemberDTO param) {
        Log.i("** SERVICE 받은 id : ",param.getId());
        Log.i("** SERVICE 받은 pw : ",param.getPw());
        Log.i("** SERVICE 받은 name : ",param.getPw());
        Log.i("** SERVICE 받은 email : ",param.getPw());
        Log.i("** SERVICE 받은 addr : ",param.getPw());
        Log.i("** SERVICE 받은 phone : ",param.getPw());
        return dao.insert(param);
    }
}
