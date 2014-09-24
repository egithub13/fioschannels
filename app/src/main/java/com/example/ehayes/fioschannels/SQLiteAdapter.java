package com.example.ehayes.fioschannels;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ehayes on 9/24/2014.
 */
public class SQLiteAdapter extends SQLiteOpenHelper {

    //Channels Table Name
    private static final String TABLE_CHANNELS = "Channels";

    //Channels Table Column Names
    private static final String UID = "_id";
    private static final String KEY_CHANNEL_NAME = "Name";
    private static final String KEY_CHANNEL_NUMBER = "Number";

    private static final String[] COLUMNS = {UID,KEY_CHANNEL_NAME,KEY_CHANNEL_NUMBER};

    //Database Version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "ChannelDB";
    //Table Name
    private static final String TABLE_NAME = "CHANNEL TABLE";
    //Create Channel Table
    private static final String CREATE_CHANNEL_TABLE = "CREATE TABLE "+ TABLE_NAME + " ( "+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
            KEY_CHANNEL_NAME+ " TEXT, "+KEY_CHANNEL_NUMBER+" TEXT )";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+ TABLE_NAME;
    private Context context;
    public SQLiteAdapter(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
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
        //Drop Older Channel Table if Exists
        db.execSQL(DROP_TABLE);

        //Create Fresh Table
        try {
            this.onCreate(db);
            Message.message(context,"onUpgrade() Called");
        } catch (Exception e) {
            Message.message(context,""+e);
        }


    }
}
