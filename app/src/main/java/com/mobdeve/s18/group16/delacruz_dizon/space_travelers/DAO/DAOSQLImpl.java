package com.mobdeve.s18.group16.delacruz_dizon.space_travelers.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;

import com.mobdeve.s18.group16.delacruz_dizon.space_travelers.model.Block;

public class DAOSQLImpl {
    private SQLiteDatabase database;
    private DBHelper dbhelper;

    public DAOSQLImpl(Context context) {
        dbhelper = new DBHelper(context);
    }

    public boolean addData(ArrayList<Block> blocks) {
        ContentValues cv = new ContentValues();
        long id = 0;
        database = dbhelper.getWritableDatabase();

        for(int i = 0; i < blocks.size(); i++) {
            cv.put(DBHelper.blockNum, blocks.get(i).getBlockNum());
            cv.put(DBHelper.blockType, blocks.get(i).getBlockType());
            cv.put(DBHelper.isConnected, blocks.get(i).getIsConnected());
            cv.put(DBHelper.pBlockNum, blocks.get(i).getpBlockNum());
            cv.put(DBHelper.isHead, blocks.get(i).getIsHead());
            cv.put(DBHelper.mapName, blocks.get(i).getMapName());

            id = database.insert(DBHelper.tableName, null, cv);
            cv.clear();
        }




        if(database != null) {
            dbhelper.close();
        }

        return id != -1;
    }

    public ArrayList<Block> getBlocks() {
        ArrayList<Block> result = new ArrayList<>();

        String[] columns = {DBHelper.blockNum,
                            DBHelper.blockType,
                            DBHelper.isConnected,
                            DBHelper.pBlockNum,
                            DBHelper.isHead,
                            DBHelper.mapName};

        database = dbhelper.getReadableDatabase();

        Cursor cursor = database.query(DBHelper.tableName,
                columns,
                null,
                null,
                null,
                null,
                null);

        cursor.moveToFirst();

        while(!cursor.isAfterLast()) {
            Block temp = new Block();
            temp.setBlockNum(cursor.getInt(0));
            temp.setBlockType(cursor.getInt(1));
            temp.setConnected(cursor.getInt(2));
            temp.setpBlockNum(cursor.getInt(3));
            temp.setHead(cursor.getInt(4));
            temp.setMapName(cursor.getString(5));
            result.add(temp);
            cursor.moveToNext();
        }

        if (cursor != null) {
            cursor.close();
        }

        if(database != null) {
            dbhelper.close();
        }

        return result;
    }

    public Block getBlock(int blockNum) {
        Block block = null;

        String query = "SELECT * FROM " + DBHelper.tableName + " WHERE " + DBHelper.blockNum + " = " + blockNum;

        Cursor cursor = null;

        database = dbhelper.getReadableDatabase();

        try {
            cursor = database.rawQuery(query, null);
            cursor.moveToFirst();

            while(!cursor.isAfterLast()) {
                block = new Block();
                block.setBlockNum(cursor.getInt(cursor.getColumnIndex(DBHelper.blockNum)));
                block.setBlockType(cursor.getInt(cursor.getColumnIndex(DBHelper.blockType)));
                block.setConnected(cursor.getInt(cursor.getColumnIndex(DBHelper.isConnected)));
                block.setpBlockNum(cursor.getInt(cursor.getColumnIndex(DBHelper.pBlockNum)));
                block.setHead(cursor.getInt(cursor.getColumnIndex(DBHelper.isHead)));
                block.setMapName(cursor.getString(cursor.getColumnIndex(DBHelper.mapName)));
            }
        } catch (SQLiteException e) {
            return null;
        }

        if (cursor != null) {
            cursor.close();
        }

        if(database != null) {
            dbhelper.close();
        }

        return block;
    }


}
