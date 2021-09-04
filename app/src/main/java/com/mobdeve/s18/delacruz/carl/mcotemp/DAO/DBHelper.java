package com.mobdeve.s18.delacruz.carl.mcotemp.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "mapdata.db";
    private static final int DB_VERSION = 1;

    public String tableName;
    public static String blockNum = "blockNum";
    public static String blockType = "blockType";
    public static String isConnected = "isConnected";
    public static String pBlockNum = "pBlockNum";
    public static String isHead = "isHead";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tableName + " ( " + blockNum + " integer primary key, " + blockType + " integer, " + isConnected + " integer, " +  pBlockNum + " integer, " + isHead + " integer );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(db);
    }
}
