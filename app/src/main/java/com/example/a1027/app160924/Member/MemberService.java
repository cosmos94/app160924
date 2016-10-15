package com.example.a1027.app160924.Member;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-10-01.
 */

public interface MemberService {
    //기본 회원관리 생성
    //create
//    public MemberDTO join(MemberDTO member);
    //추상화
    public void regist(MemberDTO member);

    //read
    public ArrayList<MemberDTO> getList();
    public ArrayList<MemberDTO> getListByName(MemberDTO member);
    public MemberDTO getOne(MemberDTO member);
    public int count();

    //update
    public void update(MemberDTO member);
    //delete
    public void unregist(MemberDTO member);
}
