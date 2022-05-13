package com.example.a7_min_workout_app

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import java.sql.SQLDataException
import java.sql.Time

class DataHandler(context: Context):SQLiteOpenHelper(context,DB_NAME,null,DB_VERSION) {
    companion object{
        private const val DB_NAME="WORKOUTDATA"
        private const val DB_VERSION=1
        private const val DB_TABLE_NAME="HISTORY"

        private const val Sno="SNO"
        private const val TIME="TIME"
    }
//    CREATE HISTORY(Sno INTEGER PRIMARY KEY,TIME TEXT);
    override fun onCreate(db: SQLiteDatabase?) {
    val create_database=("CREATE TABLE " + DB_TABLE_NAME + "(" + Sno + " INTEGER PRIMARY KEY," + TIME + " TEXT)")
    db?.execSQL(create_database)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS"+ DB_TABLE_NAME)
        onCreate(db)
    }

    fun additem(time:String){
        val contextval=ContentValues()
        contextval.put(TIME,time)
        val db=this.writableDatabase
        db.insert(DB_TABLE_NAME,null,contextval)
        db.close()
    }

    fun viewhis():ArrayList<datacls>{
        var hist=ArrayList<datacls>()
        val db=readableDatabase
        var cursor=db.rawQuery("SELECT * FROM $DB_TABLE_NAME",null)

            while (cursor.moveToNext()) {
                val time=cursor.getString(cursor.getColumnIndex(TIME))
                val id=cursor.getInt(cursor.getColumnIndex(Sno))
                hist.add(datacls(id,time))
            }
        cursor.close()
        return hist
    }

    fun delhis(id: Int){
        val db=writableDatabase
        db.delete(DB_TABLE_NAME, "$Sno  =  $id",null)
        db.close()
    }

}