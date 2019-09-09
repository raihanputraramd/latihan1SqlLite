package com.example.latihan1sqllite;

import android.app.Person;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "UserInfo";
    private static final String TABLE_NAME = "tbl_user";
    private static final String KEY_NAME = "name";
    private static final String KEY_AGE = "age";

    public DatabaseHelper( Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createUserTable = "Create Table "+TABLE_NAME+" ( "+KEY_NAME+" TEXT PRIMARY KEY , "+KEY_AGE+" INTEGER )";
        sqLiteDatabase.execSQL(createUserTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String sql = ("drop table if exists " +TABLE_NAME);
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public void insert(PersonBean personBean) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,personBean.getName());
        values.put(KEY_AGE,personBean.getAge());

        sqLiteDatabase.insert(TABLE_NAME,null, values);
    }

    public List<PersonBean> selectUserData() {
        ArrayList<PersonBean> userList=new ArrayList<PersonBean>();
        SQLiteDatabase db= getReadableDatabase();
        String[] columns={KEY_NAME,KEY_AGE};
        Cursor c =db.query(TABLE_NAME,columns,null,null,null,null,null);
        while (c.moveToNext()){
            String name=c.getString(0);
            int age=c.getInt(1);
            PersonBean personBean=new PersonBean();
            personBean.setName(name);
            personBean.setAge(age);
            userList.add(personBean);
        }
        return userList;
    }

    public void delete(String name) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String whereClause= KEY_NAME+"='"+name+"'";
        sqLiteDatabase.delete( TABLE_NAME, whereClause, null);
    }

    public void update(PersonBean personBean) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put ( KEY_AGE, personBean.getAge());
        String whereClause = KEY_NAME +" = '"+personBean.getName()+"'";
        sqLiteDatabase.update ( TABLE_NAME, values, whereClause, null);
    }

}
