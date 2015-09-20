package com.example.zheey.kilasi.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.zheey.kilasi.database.DataBaseHelper;

/**
 * Created by Adewale_MAC on 9/20/15.
 */
public class RegisterDataBaseAdapter {


    final String TAG = this.getClass().getSimpleName();
    static final String DATABASE_NAME = "kilasi.db";
    static final int DATABASE_VERSION = 1;

    public static final String DATABASE_CREATE = "create table "+"STUDENT_USER"+
            "( " +"MATRIC_NO"+" text primary key,"+ "SURNAME  text, FIRST_NAME text, EMAIL text, LEVEL text, PHONE_NO text, USERNAME text,PASSWORD text, SECURITY_ANSWER text); ";

    public SQLiteDatabase db;

    private final Context context;
    private DataBaseHelper dbHelper;
    public  RegisterDataBaseAdapter(Context context)
    {
        this.context = context;
        dbHelper = new DataBaseHelper(this.context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public  RegisterDataBaseAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        db.close();
    }

    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }

    public void insertEntry(String matricNo, String surname, String firstname, String email, String level, String phoneNo, String username, String password, String securityAnswer)
    {
        ContentValues newValues = new ContentValues();
        newValues.put("MATRIC_NO",matricNo);
        newValues.put("SURNAME", surname);
        newValues.put("FIRSTNAME",firstname);
        newValues.put("EMAIL", email);
        newValues.put("LEVEL",level);
        newValues.put("PHONE_NO",phoneNo);
        newValues.put("USERNAME",username);
        newValues.put("PASSWORD",password);
        newValues.put("SECURITY_ANSWER",securityAnswer);



        db.insert("STUDENT_USER", null, newValues);
        Toast.makeText(context, "User Info was Successfully Saved", Toast.LENGTH_LONG).show();
        Log.d(TAG, "User Info was Successfully Saved");
    }
    public int deleteEntry(String matricNo)
    {
        String where="MATRIC_NO=?";
        int numberOFEntriesDeleted= db.delete("STUDENT_USER", where, new String[]{matricNo}) ;
        Toast.makeText(context, "Number of Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
        Log.d(TAG, "Number of Entry Deleted Successfully : "+numberOFEntriesDeleted);
        return numberOFEntriesDeleted;
    }
    public String getSinlgeEntry(String matricNo)
    {
        Cursor cursor=db.query("STUDENT_USER", null, " MATRIC_NO=?", new String[]{matricNo}, null, null, null);
        if(cursor.getCount()<1)
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }
    public void  updateEntry(String username,String password)
    {
        ContentValues updatedValues = new ContentValues();
        updatedValues.put("USERNAME", username);
        updatedValues.put("PASSWORD",password);

        String where="USERNAME = ?";
        db.update("USER",updatedValues, where, new String[]{username});
    }
}
