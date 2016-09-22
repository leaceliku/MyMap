package com.example.pcadministrator.mymap;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String Database_Name="History_Location.db";
    public static final String Table_Name="History_Table";
    public static final String Col_1="ID";
    public static final String Col_2="Latitude";
    public static final String Col_3="Longitude";
    public static final String Col_4="Temperature";
    SQLiteDatabase db;
    Cursor res;

    public DatabaseHelper(Context context) {
        super(context, Database_Name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table " + Table_Name + " ( " +
                Col_1 + " integer primary key autoincrement , " +
                Col_2 + " double , " +
                Col_3 + " double , " + " ) ";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void InsertData(double Latitude,double Longitude){
        ContentValues contentValues=new ContentValues();
        contentValues.put(Col_2,Latitude);
        contentValues.put(Col_3,Longitude);
        long newRowId = db.insert(Table_Name, null, contentValues);
        this.db = getReadableDatabase();
    }

    public String viewAll() {

        String data = null;
        while (res.moveToNext()) {
            String key = "Key is:"+ res.getString(0) + "\n";
            String Latitude = "Latitude is:"+res.getString(1) + "\n";
            String Longitude = "Longitude is:" + res.getString(2) + "\n";
            data = key + Latitude + Longitude;

        }
        return data;
    }
}
