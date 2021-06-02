# Retrofit
-dontnote retrofit2.Platform
-dontnote retrofit2.Platform$IOS$MainThreadExecutor
-dontwarn retrofit2.Platform$Java8
-keepattributes Signature
-keepattributes Exceptions

# okhttp
#不混淆类名和子类名
-dontwarn okio.**

# Gson
#不混淆类名和子类名，且不混淆类中的变量名
-keep class com.heyingguai.sunnyweather.login.model.**{*;} # 自定义数据模型的bean目录