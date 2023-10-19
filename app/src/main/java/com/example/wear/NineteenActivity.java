package com.example.wear;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wear.databinding.ActivityNineteenBinding;

import dao.DatabaseHelper;
/**
 * SQLite
 * */
public class NineteenActivity extends Activity {

    private EditText editTextCreateDatabase;
    private EditText editTextQueryDatabase;
    private EditText editTextInsertDatabase;
    private EditText editTextDeleteDatabase;
    private EditText editTextUpdateDatabase;
    private Button buttonCreateDatabase;
    private Button buttonQueryDatabase;
    private Button buttonDeleteDatabase;
    private Button buttonInsertDatabase;
    private Button buttonUpdateDatabase;
    private Button buttonTransactionDatabase;
    private ActivityNineteenBinding binding;
    private SQLiteDatabase database;
    private Cursor cursor;

    @SuppressLint(value = "Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNineteenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // 获取元素对象
        editTextCreateDatabase = binding.editTextCreateDatabase;
        editTextQueryDatabase = binding.editTextQueryDatabase;
        editTextDeleteDatabase = binding.editTextDeleteDatabase;
        editTextInsertDatabase = binding.editTextInsertDatabase;
        editTextUpdateDatabase = binding.editTextUpdateDatabase;
        buttonCreateDatabase = binding.buttonCreateDatabase;
        buttonQueryDatabase = binding.buttonQueryDatabase;
        buttonInsertDatabase = binding.buttonInsertDatabase;
        buttonDeleteDatabase = binding.buttonDeleteDatabase;
        buttonUpdateDatabase = binding.buttonUpdateDatabase;
        buttonTransactionDatabase = binding.buttonTransactionDatabase;
        //  设置输入框默认值
        editTextCreateDatabase.setText("create table user(id integer primary key, name text,username text,password text)");
        editTextQueryDatabase.setText("select * from user");
        editTextDeleteDatabase.setText("drop table user");
        editTextInsertDatabase.setText("insert into user values(1, 'zhangsan', 20)");
        editTextUpdateDatabase.setText("update user set name='lisi',username='wangwwu' where id=2");

        // 创建数据库实例
        DatabaseHelper dbHelper = new DatabaseHelper(NineteenActivity.this);
        database = dbHelper.getWritableDatabase();

        /**
         * 按钮监听 创建数据库表
         * */
        binding.buttonCreateDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 判断数据库是否创建成功或已创建
                if (database != null) {
                    Toast.makeText(NineteenActivity.this, "数据库创建成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(NineteenActivity.this, "数据库创建失败", Toast.LENGTH_SHORT).show();
                }

            }
        });
        /**
         * 按钮监听 插入数据库表
         * */
        binding.buttonInsertDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建要插入的数据
                ContentValues values = new ContentValues();
                values.put("name", "John");
                values.put("username", "liyinchi");
                values.put("password", "123456");
                // 执行插入操作
                long newRowId = database.insert("mytable", null, values);
                // 检查插入是否成功
                if (newRowId != -1) {
                    Log.d("MainActivity", "插入成功，新行ID为: " + newRowId);
                } else {
                    Log.d("MainActivity", "插入失败");
                }
            }
        });
        /**
         * 按钮监听 更新数据库表
         * */
        binding.buttonUpdateDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues updateValues = new ContentValues();
                updateValues.put("name", "Jane");
                int rowsAffected = database.update("mytable", updateValues, "id=?", new String[]{"1"});
                Log.d("TAG", "rowsAffected=" + rowsAffected);
            }
        });
        /**
         * 按钮监听 删除数据库表
         * */
        binding.buttonDeleteDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 查询数据
                int rowsDeleted = database.delete("mytable", "id=?", new String[]{binding.editTextDeleteDatabase.getText().toString()});
                Log.d("MainActivity", "rowsDeleted=" + rowsDeleted);
            }
        });
        /**
         * 按钮监听
         * 查询数据库表
         * */
        binding.buttonQueryDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 查询数据
                String[] projection = {"id", "name", "username"};//
                String selection = "id > ?";// 查询条件
                String[] selectionArgs = {"1"};// 条件参数
                cursor = database.query("mytable", projection, selection, selectionArgs, null, null, null);
                // 游标
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(cursor.getColumnIndex("id"));
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    int username = cursor.getInt(cursor.getColumnIndex("username"));
                    Log.d("Database", "ID: " + id + ", Name: " + name + ", username: " + username);
                }
            }
        });

        /**
         * 事务
         * */
        binding.buttonTransactionDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 开始事务
                database.beginTransaction();

                try {
                    // 删除数据
                    int rowsDeleted = database.delete("mytable", "id=?", new String[]{"1"});
                    Log.d("MainActivity", "rowsDeleted=" + rowsDeleted);

                    // 插入数据
                    ContentValues values = new ContentValues();
                    values.put("name", "lisi");
                    values.put("username", "lisi");
                    values.put("password", "123456");
                    long newRowId = database.insert("mytable", null, values);
                    Log.d("MainActivity", "newRowId=" + newRowId);

                    // 标记事务成功
                    database.setTransactionSuccessful();
                } finally {
                    // 结束事务
                    database.endTransaction();
                }
            }
        });
    }

    ;
}