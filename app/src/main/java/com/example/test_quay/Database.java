package com.example.test_quay;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Truy vấn không trả kết quả : CREATE , INSERT , UPDATE, DELETE....
    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }


    //Truy vấn có trả kết quả :SELECT
    public Cursor GetData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }

    public Boolean Login(String Email,String Password){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM customer WHERE Email=? and PassWord=?",new String[] {Email,Password});
        if(cursor.getCount()>0) return  true;
        else return false;
    }

    public Cursor search(String text){
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT * FROM quay_hang WHERE TenQB LIKE '"+text+"' ";
        Cursor cursor = database.rawQuery(query,null);

        return cursor;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
