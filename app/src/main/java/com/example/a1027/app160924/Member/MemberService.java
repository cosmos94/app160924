package com.example.a1027.app160924.Member;

import com.example.a1027.app160924.util.Retval;

/**
 * Created by 1027 on 2016-10-01.
 */

public interface MemberService {
    public MemberDTO login(MemberDTO member);
//    public MemberDTO join(MemberDTO member);
    //추상
    public Retval join(MemberDTO member);
}
