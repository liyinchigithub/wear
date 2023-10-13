# wear

智能手表 wear OS

![20231007143744_rec_](https://github.com/liyinchigithub/wear/assets/19643260/0cc30a7e-2d05-41fe-9da5-1eba92cfe74d)

![image](https://github.com/liyinchigithub/wear/assets/19643260/a972dd23-949c-4f4d-82e5-88b13ae95128)

![image](https://github.com/liyinchigithub/wear/assets/19643260/a3a89214-2e82-44ee-aaf1-b8193126cbd5)


# 环境
JDK >=11
SDK >=29


# 编译
```shell
./gradlew clean assembleDebug   
```

# 运行
```shell
./gradlew installDebug
```

# 打包
```shell
./gradlew clean assembleRelease
```


# 打包apk
```shell
./gradlew assembleDebug
```    


# 启动sdk 模拟器

```
cd /Users/liyinchi/TestTool/android-sdk-macosx/emulator/emulator -avd Wear_OS_Square_API_28

# Wear_OS_Square_API_28 模拟器名称
# sdk路径local.properties文件中查看
```

冷启动
当提示avd删除.lock文件时，把模拟器启动模式改为cold boot

快启动
每次启动没有再进入系统，直接进入应用



