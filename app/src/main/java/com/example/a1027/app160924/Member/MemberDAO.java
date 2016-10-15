package com.example.a1027.app160924.Member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberDAO extends SQLiteOpenHelper {
    public static final String DB_NAME =  "testDB3";
    public static final int DB_VERSION =  1;

    public static final String ID =  "id";
    public static final String PW =  "pw";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String ADDR = "addr";
    public static final String PHONE = "phone";
    public static final String PHOTO = "profileImg";
    public static final String TABLE_NAME = "member";

    //DAO의 기능을 갖기위해 상속 (EXTENDS)하고 SQLiteOpenHelper에서 받는다.
    public MemberDAO(Context context) {
        super(context, DB_NAME,null,DB_VERSION);
        //위치값, 만드려는 디비명칭, 팩토리, 버전
        this.getWritableDatabase(); //입력가능한 db로 생성
        Log.d(DB_VERSION + "버전의 db가 생성","성공 !!");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //SQL 문법으로 db생성
/*        create table if not exists member( // 재생성 확인 -> table에서 대표하는 key가 필요
            id text primary key,    //	-> primary key 지정
            pw text
            name text,
            email text,
            addr text,
            phone text,
            profileImg text
        );*/

        //SQL 문법으로 java 화 진행
        db.execSQL(
            "create table if not exists member("
            + "id text primary key,"
            + "pw text,"
            + "name text,"
            + "email text,"
            + "addr text,"
            + "phone text,"
            + "profileImg text );"
        );

        db.execSQL(
                "insert into member(id,pw,name,email,addr,phone,profileImg)" +
                "values ('hong1','1','홍1','hong1@a.a','주소','010-1111-1111','기본.jpg')"
        );
        db.execSQL(
                "insert into member(id,pw,name,email,addr,phone,profileImg)"
                        + "values ('hong2','1','홍2','hong2@a.a','주소','010-1111-1111','기본.jpg')"
        );
        db.execSQL(
                "insert into member(id,pw,name,email,addr,phone,profileImg)"
                        + "values ('hong3','1','홍3','hong3@a.a','주소','010-1111-1111','기본.jpg')"
        );
        db.execSQL(
                "insert into member(id,pw,name,email,addr,phone,profileImg)"
                        + "values ('hong4','1','홍4','hong4@a.a','주소','010-1111-1111','기본.jpg')"
        );
        db.execSQL(
                "insert into member(id,pw,name,email,addr,phone,profileImg)"
                        + "values ('hong5','1','홍5','hong5@a.a','37.5577608,126.9366861','010-1111-1111','기본.jpg')"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("insert into Android values(null,'android_6.0.0',1);");
        db.execSQL("insert into Android values(null,'android_6.0.1',2);");
        this.onCreate(db);
    }
//DML ( Create)
    public void insert(MemberDTO param){
        //유효성 체크 코드 필요

        //선언
        Log.i(">> DAO 전체 조회 : ","insert() 진입");
        String sql = "insert into " + TABLE_NAME
                + String.format(" (%s,%s,%s,%s,%s,%s,%s)",ID,PW,NAME,EMAIL,ADDR,PHONE,PHOTO)
                + String.format(" values('%s','%s','%s','%s','%s','%s','%s')"
                    ,param.getId()
                    ,param.getPw()
                    ,param.getName()
                    ,param.getEmail()
                    ,param.getAddr()
                    ,param.getPhone()
                    ,param.getProfileImg());
        //권한부여
        SQLiteDatabase db = this.getWritableDatabase(); //db에 쓰는 권한 주기
        //데이터 삽입
        db.execSQL(sql);    //sql 실행
        db.close();
    }
//DML ( Read ) -> 경우 3가지 전체 가져오는것, 하나만 가져오는것, 카운트만 가져오는거등 3종의 결과만 가져옴
    //검색조건없이 전체 목록 조회
    public ArrayList<MemberDTO> selectList(){
        Log.i(">> DAO 전체 조회 : ","selectList() 진입");
        String sql = "select"
            + String.format(" (%s,%s,%s,%s,%s,%s,%s)",ID,PW,NAME,EMAIL,ADDR,PHONE,PHOTO)    //"*"가 들어가도 되나 디버깅상의 편의로 수정
            + "from member;";

        SQLiteDatabase db =  this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql,null);

        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

        if (cursor != null ){
            Log.i("------ DAO List 조회 : ","Sussess");
            cursor.moveToFirst();
        }

        do{
            MemberDTO temp = new MemberDTO();
            temp.setId(cursor.getString(0));    //id 가져오기
            temp.setPw(cursor.getString(1));    //pw 가져오기
            temp.setName(cursor.getString(2));    //name 가져오기
            temp.setEmail(cursor.getString(3));    //Email 가져오기
            temp.setAddr(cursor.getString(4));    //Addr 가져오기
            temp.setPhone(cursor.getString(5));    //Phone 가져오기
            temp.setProfileImg(cursor.getString(6));    //ProfileImg 가져오기
            list.add(temp);

        }while(cursor.moveToNext());

        return list;
    }
    //검색조건 목록 조회
    public ArrayList<MemberDTO> selectListByName(MemberDTO param){
        Log.i(">> DAO 전체 조회 : ","selectListByName() 진입");
        String sql = "select"
                + String.format("%s,%s,%s,%s,%s,%s,%s",ID,PW,NAME,EMAIL,ADDR,PHONE,PHOTO)    //"*"가 들어가도 되나 디버깅상의 편의로 수정
                + String.format("from %s where %s = '%s';", TABLE_NAME,NAME,param.getName());

        SQLiteDatabase db =  this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql,null);

        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

        if (cursor != null ){
            Log.i("DAO List Name 조회 결과: ","SUCCESS");
            cursor.moveToFirst();
        }

        do{
            MemberDTO temp = new MemberDTO();
            temp.setId(cursor.getString(0));    //id 가져오기
            temp.setPw(cursor.getString(1));    //pw 가져오기
            temp.setName(cursor.getString(2));    //name 가져오기
            temp.setEmail(cursor.getString(3));    //Email 가져오기
            temp.setAddr(cursor.getString(4));    //Addr 가져오기
            temp.setPhone(cursor.getString(5));    //Phone 가져오기
            temp.setProfileImg(cursor.getString(6));    //ProfileImg 가져오기
            list.add(temp);

        }while(cursor.moveToNext());

        return list;
    }
    //하나를 선택하는 것
    public MemberDTO selectOne(MemberDTO param){
        Log.i(">> DAO ID 조회 : ","selectOne() 진입");
        String sql = "select"
                + String.format(" %s,%s,%s,%s,%s,%s,%s",ID,PW,NAME,EMAIL,ADDR,PHONE,PHOTO)    //"*"가 들어가도 되나 디버깅상의 편의로 수정
                + String.format(" from %s where %s = '%s';", TABLE_NAME,ID,param.getId());

        SQLiteDatabase db =  this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql,null);

        MemberDTO temp = null;  //개체에대한 null체크하기 위해서 초기화 하지 않음

        if (cursor.moveToNext()){
            Log.i("DAO List ID 조회 결과: ","ID가 존재합니다");

            temp = new MemberDTO();

            temp.setId(cursor.getString(0));    //id 가져오기
            temp.setPw(cursor.getString(1));    //pw 가져오기
            temp.setName(cursor.getString(2));    //name 가져오기
            temp.setEmail(cursor.getString(3));    //Email 가져오기
            temp.setAddr(cursor.getString(4));    //Addr 가져오기
            temp.setPhone(cursor.getString(5));    //Phone 가져오기
            temp.setProfileImg(cursor.getString(6));    //ProfileImg 가져오기
        }
        return temp;
    }
    //레코드개수를 파악 예 읽지않은 메일수 파악하기
    public int count(){
        Log.i(">> DAO count() ","진입");
        String sql = "select count(*) as count from member;";
        SQLiteDatabase db = this.getReadableDatabase();
        int count = 0;
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor.moveToNext()){
            Log.i("DAO List ID 조회 결과: ","ID가 존재합니다");

            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        return count;
    }
//DML ( Update )
    public void update(MemberDTO param){
        //id,pw,name,email,addr,phone,profileImg 입력 프로필중 변경가능한값을 지정
        //pw,name,email,addr,phone,profileImg 일반 웹에서는 번호변경 가능하나 앱은 변경불가능

        Log.i(">> DAO update() ","진입");
        String sql = String.format("update %s set",TABLE_NAME)
                + String.format("%s = '%s',",PW,param.getPw())
                + String.format("%s = %s',",EMAIL,param.getEmail())
                + String.format("%s = %s',",ADDR,param.getAddr())
                + String.format("%s = %s',",PHOTO,param.getProfileImg())
                + String.format("where %s = '%s';",ID,param.getId());

        //권한부여
        SQLiteDatabase db = this.getWritableDatabase(); //db에 쓰는 권한 주기
        //데이터 삽입
        db.execSQL(sql);    //sql 실행        MemberDTO member = new MemberDTO();
        db.close(); //data를 변경할가능성있는 db명령 getWritableDatabase 등은 반드시 닫을것 그리고 이런값은 리턴값이 없슴
    }
//DML ( Delete )
    public void delete(MemberDTO param){
        Log.i(">> DAO delete() ","진입");
        String sql = String.format("delete from %s",TABLE_NAME)
                + String.format("where %s = '%s';",ID,param.getId());

        //권한부여
        SQLiteDatabase db = this.getWritableDatabase(); //db에 쓰는 권한 주기
        //데이터 삽입
        db.execSQL(sql);    //sql 실행        MemberDTO member = new MemberDTO();
        db.close();
    }

/*    public MemberDTO insert(MemberDTO param){
        MemberDTO member = new MemberDTO();
        return member;
    }*/

}
