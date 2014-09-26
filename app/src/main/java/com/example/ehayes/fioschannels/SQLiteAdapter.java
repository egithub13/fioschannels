package com.example.ehayes.fioschannels;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ehayes on 9/24/2014.
 */
public class SQLiteAdapter {

    SQLiteHelper helper;
    public SQLiteAdapter(Context context){

        helper = new SQLiteHelper(context);
    }
    public long insertData(String name, String number){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLiteHelper.KEY_CHANNEL_NAME,name);
        contentValues.put(SQLiteHelper.KEY_CHANNEL_NUMBER,number);
        long id = db.insert(SQLiteHelper.TABLE_NAME,null,contentValues);
        return id;
    }

    public String getAllData(){
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query(SQLiteHelper.TABLE_NAME, SQLiteHelper.COLUMNS, null, null, null, null, null);

        StringBuffer buffer = new StringBuffer();
        while(cursor.moveToNext()){
            int cid = cursor.getInt(0);
            String name = cursor.getString(1);
            String number = cursor.getString(2);
            buffer.append(name+" "+number+"\n");
        }
        return buffer.toString();

    }

    static class SQLiteHelper extends SQLiteOpenHelper {

        //Channels Table Name
        private static final String TABLE_CHANNELS = "Channels";

        //Channels Table Column Names
        private static final String UID = "_id";
        private static final String KEY_CHANNEL_NAME = "Name";
        private static final String KEY_CHANNEL_NUMBER = "Number";

        private static final String[] COLUMNS = {UID,KEY_CHANNEL_NAME,KEY_CHANNEL_NUMBER};

        //Database Version
        private static final int DATABASE_VERSION = 3;
        //Database Name
        private static final String DATABASE_NAME = "ChannelDB";
        //Table Name
        private static final String TABLE_NAME = "CHANNELTABLE";
        //Create Channel Table
        private static final String CREATE_CHANNEL_TABLE = "CREATE TABLE "+ TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_CHANNEL_NAME + " TEXT, " + KEY_CHANNEL_NUMBER + " TEXT )";

        private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+ TABLE_NAME;
        private Context context;
        public SQLiteHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
            Message.message(context,"CONSTRUCTOR CALLED");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //SQL to Create Channel Table
            try {
                db.execSQL(CREATE_CHANNEL_TABLE);
                Message.message(context,"onCreate() Called");
            } catch (SQLException e) {
                Message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i2) {

            //Create Fresh Table
            try {
                //Drop Older Channel Table if Exists
                db.execSQL(DROP_TABLE);
                onCreate(db);
                Message.message(context,"onUpgrade() Called");
            } catch (Exception e) {
                Message.message(context,""+e);
            }


        }
    }

}
