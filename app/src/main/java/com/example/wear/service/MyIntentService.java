package com.example.wear.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

/**
 * 一个用于在单独的处理程序线程上处理异步任务请求的{@link IntentService}子类。
 * <p>
 * <p>
 * TODO: 自定义类 - 更新意图操作、额外参数和静态辅助方法。
 */
public class MyIntentService extends IntentService {

    // TODO: 重命名操作，选择描述此IntentService可以执行的任务的操作名称，例如ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.example.wear.service.action.FOO";
    private static final String ACTION_BAZ = "com.example.wear.service.action.BAZ";

    // TODO: 重命名参数
    private static final String EXTRA_PARAM1 = "com.example.wear.service.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.example.wear.service.extra.PARAM2";

    public MyIntentService() {
        super("MyIntentService");
    }

    /**
     * 使用给定参数启动此服务以执行Foo操作。如果服务已经执行任务，则此操作将被排队。
     *
     * @see IntentService
     */
    // TODO: 自定义辅助方法
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * 使用给定参数启动此服务以执行Baz操作。如果服务已经执行任务，则此操作将被排队。
     *
     * @see IntentService
     */
    // TODO: 自定义辅助方法
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }
        }
    }

    /**
     * 在提供的后台线程中处理Foo操作的参数。
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: 处理Foo操作
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * 在提供的后台线程中处理Baz操作的参数。
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: 处理Baz操作
        throw new UnsupportedOperationException("Not yet implemented");
    }
}