package com.example.wear;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

public class SixthActivity extends Activity {
    // 常量
    // 同步适配器的内容提供者的权限
    public static final String AUTHORITY = "com.example.android.datasync.provider";
    // 以域名形式的账户类型
    public static final String ACCOUNT_TYPE = "com.example.android.datasync";
    // 账户名称
    public static final String ACCOUNT = "dummyaccount";
    // 实例字段
    Account mAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 创建虚拟账户
        mAccount = createSyncAccount(this);
    }

    /**
     * 为同步适配器创建一个新的虚拟账户
     *
     * @param context 应用程序上下文
     */
    public static Account createSyncAccount(Context context) {
        // 创建账户类型和默认账户
        Account newAccount = new Account(ACCOUNT, ACCOUNT_TYPE);
        // 获取Android账户管理器的实例
        AccountManager accountManager = (AccountManager) context.getSystemService(ACCOUNT_SERVICE);
        /*
         * 添加账户和账户类型，无密码或用户数据
         * 如果成功，返回Account对象，否则报告错误。
         */
        if (accountManager.addAccountExplicitly(newAccount, null, null)) {
            /*
             * 如果你没有在manifest文件中的<provider>元素中设置android:syncable="true"，
             * 那么在这里调用ContentResolver.setIsSyncable(account, AUTHORITY, 1)。
             */
            ContentResolver.setIsSyncable(newAccount, AUTHORITY, 1);


        } else {
            /*
             * 账户已存在或发生其他错误。记录这个，报告它，
             * 或在内部处理它。
             */
        }
        return newAccount;
    }

    /**
     * 往SixthActivity页面添加一个文本
     * */
    public void addText(View view) {
        // 通过 Bundle 对象传递字符串数据
        Bundle bundle = new Bundle();
        bundle.putString("textSixthActivityToMainActivity1", "SixthActivity");
        // 通过 Intent 对象实现
        // 第一个参数是上下文，第二个参数是��
        // 第一个参数是上下文，第二个参数是要跳转的页面
        Intent intent = new Intent(this, MainActivity.class);
        // 通过 Intent 对象传递 Bundle 对象
        intent.putExtras(bundle);
        // 启动 MainActivity
        startActivity(intent);
    }
}