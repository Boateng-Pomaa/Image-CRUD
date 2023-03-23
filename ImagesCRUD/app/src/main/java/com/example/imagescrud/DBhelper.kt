package layout

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBhelper (context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {
    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "ImageDB"
        const val TABLE_NAME = "Images"
        const val KEY_IMAGE = "image"
        const val KEY_IMAGE_NAME = "image_name"
        const val KEY_ID = "id"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val newTable = ("CREATE TABLE " + TABLE_NAME + "("
                + " TEXT," + KEY_ID + " TEXT,"
                + KEY_IMAGE_NAME + " TEXT," + KEY_IMAGE+"BLOB"+ ")")
        db?.execSQL(newTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

}