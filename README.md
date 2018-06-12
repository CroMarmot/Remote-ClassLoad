JavaClassExecuter 外部调用提供的入口，只提供一个excute(byte[]) 方法

HackSystem 劫持java.lang.System对out和err发回给 客户端，其它都交给System处理

HotSwapClassLoader 按双亲委派模型交给父类加载

ClassModifier 暂时只提供 修改常量池常量 功能也就是(CONSTANT_Utf8_info)， 把字节码中常量池部分换为 新的字符串，把byte[] 与int String互换,

ByteUtils 实现的一个 byte[] int string互相转换的工具库

# 验证

远程执行功能的编码到此就完成了，接下来就来校验一下我们的劳动成果。只是作为测试的话，任意写一个java类，内容无所谓，只要向System.out输出信息即可，取名为TestClass,放到服务器C盘的根目录中。然后建立一个JSP文件写上如`web/test.jsp`示的内容，就可以在浏览器中看到这个类的运行结果了。


