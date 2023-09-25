package com.example.wear.Provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
// 1. 创建一个类继承ContentProvider
public class Provider extends ContentProvider {
    // onCreate 用于初始化
    @Override
    public boolean onCreate() {
        // 创建一个数据库

        // 创建表

        return false;
    }
    //
    @Nullable
    @Override
    // query 用于查询数据
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        // 操作sqllite数据库

        return null;
    }



    @Nullable
    @Override
    // getType 用于获取数据类型
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    // insert 用于插入数据
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    // delete 用于删除数据
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    // update 用于更新数据
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
