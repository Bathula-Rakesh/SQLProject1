package com.example.sqlproject1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbManager  extends SQLiteOpenHelper {
    Context context;
    public static final String dbname="StudentDesc.db";
    public dbManager( @Nullable Context context) {
        super(context, dbname, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry ="create table tb1_student"+" (id integer primary key autoincrement,name text,phoneno text,email text,course text)";
        db.execSQL(qry);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS tb1_student");
//        onCreate(db);
    }
    public long addRecord(SQLiteDatabase db,int uid, String uname, String uno, String uemail, String ucourse){
//        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =  new ContentValues();
        cv.put("id",uid);
        cv.put("name",uname);
        cv.put("phoneno",uno);
        cv.put("email",uemail);
        cv.put("course",ucourse);
       long res =  db.insert("tb1_student",null,cv);
      return res;
    }


}
