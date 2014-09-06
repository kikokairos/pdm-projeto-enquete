package com.firstandroidapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConnectionFactory extends SQLiteOpenHelper{
 
	    private static final String NOME_BANCO = "enquetes.db";
	    private static final int VERSAO_SCHEMA = 1;
	 
	    public ConnectionFactory(Context context) {
	        super(context, NOME_BANCO, null, VERSAO_SCHEMA);
	    }
	 
	    @Override
	    public void onCreate(SQLiteDatabase db) {
	        db.execSQL("(id INTEGER PRIMARY KEY AUTOINCREMENT, pergunta VARCHAR(255) not null," +
	        		"data VARCHAR(255) not null, nova int not null, resp1 VARCHAR(255)," +
	        		"vresp1 int not null, resp2 VARCHAR(255), vresp2 int not null," +
	        		"resp3 VARCHAR(255), vresp3 int null);");	 
	    }
	 
	    @Override
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	 
	    }
	    
	    public void inserir(String resp) {
	        ContentValues dados = new ContentValues();
	     //imcompletoooooooooooooooooo
	        dados.put("vresp1", resp);
	     
	        getWritableDatabase().insert("enquetes", "vresp1", dados);
	    }
	    
	    public Cursor getAll() {
	        return getReadableDatabase().rawQuery("select id, pergunta, data, nova, resp1, " +
	        		"vresp1, resp2, vresp2, resp3, vresp3 FROM enquetes ORDER BY id", null);
	    }
	    
	    public String getPergunta(Cursor c) {
	        return c.getString(1);
	    }
	     
	    public String getData(Cursor c) {
	        return c.getString(2);
	    }
	    
	    public String getNova(Cursor c) {
	        return c.getString(3);
	    }
	    
	    public String getResp1(Cursor c) {
	        return c.getString(4);
	    }
	    
	    public String getVresp1(Cursor c) {
	        return c.getString(5);
	    }
	    
	    public String getResp2(Cursor c) {
	        return c.getString(6);
	    }
	    
	    public String getVresp2(Cursor c) {
	        return c.getString(7);
	    }
	     
	    public String getResp3(Cursor c) {
	        return c.getString(8);
	    }
	    
	    public String getVresp3(Cursor c) {
	        return c.getString(9);
	    }

}
