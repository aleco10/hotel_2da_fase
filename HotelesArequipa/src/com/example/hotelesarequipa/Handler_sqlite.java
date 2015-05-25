package com.example.hotelesarequipa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;

public class Handler_sqlite extends SQLiteOpenHelper{
	
	public Handler_sqlite(Context ctx)
	{
		super(ctx, "MiBase", null, 1);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		String query = "CREATE TABLE usuarios ("+_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
				"user TEXT, email TEXT,password TEXT);";
		db.execSQL(query);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int version_ant, int version_nue)
	{
		db.execSQL("DROP TABLE IF EXISTS usuarios");
		onCreate(db);
	}
	
	public void insertarReg(String usr, String ema, String pass)
	{
		ContentValues valores = new ContentValues();
		valores.put("user", usr); //COLUMNA de usuario (user) un nombre de usuario
		valores.put("email", ema);//COLUMNA email, insertamos un valor que es ema
		valores.put("password", pass);//COLUMNA password, insertamos un valor que es pass
		this.getWritableDatabase().insert("usuarios",null, valores);
	}
	
	public String[] leer()
	{
		String result[] = new String [7];
		String columnas[]= {_ID,"user","email","password"};
		Cursor c = this.getReadableDatabase().query("usuarios", columnas, null, null,null, null, null);
		
		int id,iu,ie,ip;
		id = c.getColumnIndex(_ID);
		iu = c.getColumnIndex("user");
		ie = c.getColumnIndex("email");
		ip = c.getColumnIndex("password");
		
		int contador=0;		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
		{
			result[contador] = c.getString(iu)+" "+c.getString(ip);
			contador++;
		}
		
	    return result;
	    
	}
	
	public String[] leerUser()
	{
		String result[] = new String [7];
		String columnas[]= {_ID,"user","email","password"};
		Cursor c = this.getReadableDatabase().query("usuarios", columnas, null, null,null, null, null);
		
		int id,iu,ie,ip;
		id = c.getColumnIndex(_ID);
		iu = c.getColumnIndex("user");
		ie = c.getColumnIndex("email");
		ip = c.getColumnIndex("password");
		int contador=0;
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
		{
			result[contador] = c.getString(iu);
			contador++;
		}
	    return result;
	}
	
	public String[] leerPass()
	{
		String result[] = new String [7];
		String columnas[]= {_ID,"user","email","password"};
		Cursor c = this.getReadableDatabase().query("usuarios", columnas, null, null,null, null, null);
		
		int id,iu,ie,ip;
		id = c.getColumnIndex(_ID);
		iu = c.getColumnIndex("user");
		ie = c.getColumnIndex("email");
		ip = c.getColumnIndex("password");
		int contador=0;
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
		{
			result[contador] = c.getString(ip);
			contador++;
		}
	    return result;	    
	}
	
	public void abrir()
	{
		this.getWritableDatabase();
		
	}
	
	public void cerrar()
	{
		this.close();
	}
}
