package com.example.zheey.kilasi.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.zheey.kilasi.adapter.RegisterDataBaseAdapter;

/**
 * Created by Adewale_MAC on 9/20/15.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    final String TAG = this.getClass().getSimpleName();

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(RegisterDataBaseAdapter.DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion)
    {

        Log.d(TAG, "Upgrading from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");


        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "TEMPLATE");

        onCreate(sqLiteDatabase);
    }
}
