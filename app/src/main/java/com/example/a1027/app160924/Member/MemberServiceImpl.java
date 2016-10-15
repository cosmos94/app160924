package com.example.a1027.app160924.Member;

import android.content.Context;

import java.util.ArrayList;

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
    public void regist(MemberDTO member) {
        dao.insert(member);
    }

    @Override
    public ArrayList<MemberDTO> getList() {
        return dao.selectList();
    }

    @Override
    public ArrayList<MemberDTO> getListByName(MemberDTO member) {
        return dao.selectListByName(member);
    }

    @Override
    public MemberDTO getOne(MemberDTO member) {
        return dao.selectOne(member);
    }

    @Override
    public int count() {
        return dao.count();
    }

    @Override
    public void update(MemberDTO member) {
        dao.update(member);
    }

    @Override
    public void unregist(MemberDTO member) {
        dao.delete(member);
    }
}
