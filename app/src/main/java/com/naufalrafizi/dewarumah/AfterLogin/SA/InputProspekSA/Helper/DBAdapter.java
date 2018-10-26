package com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Helper;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Model.MInputProspek;

public class DBAdapter {

    Context c;
    SQLiteDatabase db;
    DataHelper helper;

    public DBAdapter(Context c){
        this.c = c;
        helper = new DataHelper(c);
    }
    public void openDB()
    {

        try
        {
            db=helper.getWritableDatabase();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //CLOSE
    public void closeDB()
    {
        try
        {
            helper.close();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public Cursor retrieve(String searchTerm)
    {
        String[] columns={MInputProspek.COLUMN_ID,MInputProspek.COLUMN_NAME};
        Cursor c=null;

        if(searchTerm != null && searchTerm.length()>=0)
        {
            String sql="SELECT * FROM "+MInputProspek.TABLE_NAME+" WHERE "+MInputProspek.COLUMN_NAME+" LIKE '%"+searchTerm+"%'";
            c=db.rawQuery(sql,null);
            return c;
        }

        c=db.query(MInputProspek.TABLE_NAME,columns,null,null,null,null,null);
        return c;

    }
}
