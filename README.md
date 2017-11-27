# utils
android 常用工具类使用

一：首先进行配置操作

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
Step 2. Add the dependency

	dependencies {
		compile 'com.github.User:Repo:Tag'
	}
	
 二：案例简单使用在主Mainactivity有进行讲解，比如进行跳转
IntentUtil.startActivity(MainActivity.this, TextActivity.class);
存储数据   SharedPreferencesUtil.saveData(MainActivity.this, "name", "xfc");
还有其他简单的工具类使用

 三：如果出现资源未找到的情况下进行配置
  在项目gradle.properties文件中添加，双击进去直接添加如下代码
  android.enableAapt2=false
  如有任何问题可以直接发送邮箱13007625621@163.com,欢迎批评指正，谢谢
  
  
