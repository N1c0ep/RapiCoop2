package co.edu.unipiloto.rapicoop2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseProcto extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Productos.db";
    public static final String TABLE_NAME="Registros_RapiCoop";
    public static final String COL1="ID";
    public static final String COL2="PRODUCTOSNAME";
    public static final String COL3="IMAGEN_64";
    public static final String COL4="STOCK";
    public static final String COL5="PRECIO";

    private static final String DB_NAME="RapiCoop";
    private static final int DB_VERSION=1;

    public DatabaseProcto (@Nullable Context context){
        super(context, DATABASE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db2){
        db2.execSQL("create table "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "PRODUCTOSNAME,IMAGEN64, STOCK, PRECIO) ");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean insertData(Producto producto){
        SQLiteDatabase db2=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL2,producto.getNombreProducto());
        contentValues.put(COL3,producto.getImagen_64());
        contentValues.put(COL4,producto.getStock());
        contentValues.put(COL5,producto.getPrecio());
        long result=db2.insert(TABLE_NAME, null, contentValues);
        if(result==1)
            return false;
        else
            return true;
    }
}
