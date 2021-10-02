package com.example.foodorder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.foodorder.Models.ordersModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    final static String DBname="maydatabase.db";
    final static int DBVersion=7;
    public DBHelper(@Nullable Context context) {

        super(context, DBname, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "Create Table orders"+
                        "(id INTEGER primary key autoincrement,"+
                        "name TEXT,"+
                        "Phone text,"+
                        "Email text,"+
                        "price int,"+
                        "Image int,"+
                        "foodName text,"+
                        "quantity int,"+
                        "description text)"

        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table if exists orders");
        onCreate(db);//droping table and adding new item with new table



    }
    public boolean insertOrder(String name, String phone, String email,int price,int image,String foodName,String desc,int quantity){

        SQLiteDatabase database = getReadableDatabase();// helper database's to data read
        /*
        id=0
        name=1
        phone=2
        email=3
        price=4
        image=5
        foodName=6
        desc=7
        quantity=8
        */

        ContentValues values=new ContentValues();//key pass
        values.put("name",name);
        values.put("phone",phone);
        values.put("email",email);
        values.put("price",price);
        values.put("image",image);
        values.put("foodName",foodName);
        values.put("description",desc);
        values.put("quantity",quantity);
        long id= database.insert("orders",null,values);
        if(id<=0){
            return false;
        }
        else{
            return true;
        }
    }
    public ArrayList<ordersModel> getOrders(){

        ArrayList<ordersModel> orders=new ArrayList<>();
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery("Select id,foodname,image,price from orders",null);
        if (cursor.moveToFirst()){
            while(cursor.moveToNext()){
                ordersModel model=new ordersModel();
                model.setOrderNumber(cursor.getInt(0)+"");
                model.setSoldItemName(cursor.getString(1));
                model.setOrderImage(cursor.getInt(2));
                model.setPrice(cursor.getInt(3)+"");
                orders.add(model);
            }
        }
        cursor.close();
        database.close();
        return orders;

    }

    public Cursor getOrderById(int id){

        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery("Select * from orders where id="+id,null);
        if(cursor!=null)
            cursor.moveToFirst();


        return cursor;



    }
    public boolean updateOrder(String name, String phone, String email,int price,int image,String foodName,String desc,int quantity,int id){

        SQLiteDatabase database = getReadableDatabase();// helper database's to data read
        /*
        id=0
        name=1
        phone=2
        email=3
        price=4
        image=5
        foodName=6
        desc=7
        quantity=8
        */

        ContentValues values=new ContentValues();//key pass
        values.put("name",name);
        values.put("phone",phone);
        values.put("email",email);
        values.put("price",price);
        values.put("image",image);
        values.put("foodName",foodName);
        values.put("description",desc);
        values.put("quantity",quantity);
        long row= database.update("orders", values,"id="+id,null);
        if(row<=0){
            return false;
        }
        else{
            return true;
        }
    }
    public int deleteOrder(String id){SQLiteDatabase database= this.getWritableDatabase();
    return database.delete("orders","id="+id,null);

    }

}
