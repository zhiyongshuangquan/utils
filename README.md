# utils
android 常用工具类使用
一：首先进行配置操作
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 2. Add the dependency
	dependencies {
	        compile 'com.github.zhiyongshuangquan:utils:v1.0'
	}
  
  二：如果出现资源未找到的情况下进行配置
  在项目gradle.properties文件中添加，双击进去直接添加如下代码
  android.enableAapt2=false
  如有任何问题可以直接发送邮箱13007625621@163.com,欢迎批评指正，谢谢
  
  
