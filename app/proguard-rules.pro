# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\Eclipse\adt-bundle-windows-x86_64-20140702\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#系统混淆配置
-dontusemixedcaseclassnames          #混淆时不使用大小写混合类名
-dontskipnonpubliclibraryclasses     #不跳过library中的非public的类
-verbose                             #打印混淆的详细信息
-dontoptimize                        #不进行优化，建议使用此选项，
-dontpreverify                       #不进行预校验,Android不需要,可加快混淆速度。
-ignorewarnings                      #忽略警告
#-optimizationpasses 5               #指定代码的压缩级别

#retrofit2混淆
-dontnote retrofit2.Platform  # Platform calls Class.forName on types which do not exist on Android to determine platform.
-dontnote retrofit2.Platform$IOS$MainThreadExecutor
-dontwarn retrofit2.Platform$Java8  # Platform used when running on Java 8 VMs. Will not be used at runtime.
-keepattributes Signature   # Retain generic type information for use by reflection by converters and adapters.
-keepattributes Exceptions  # Retain declared checked exceptions for use by a Proxy instance.

#okhttp
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp3.** { *;}
-dontwarn okio.**

# Gson
-keep class com.google.gson.stream.** { *; }
-keepattributes EnclosingMethod
-keep class org.xz_sale.entity.**{*;}
-keep class com.google.gson.** {*;}
-keep class com.google.**{*;}
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.examples.android.model.** { *; }
