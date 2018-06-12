/*
 * JavaClassExecuter只有一个execute（）方法，用输入的符合Class文件格式的byte[]数组替换掉java.lang.System的符号引用后，使用HotSwapClassLoader加载生成一个Class对象，由于每次执行execute()方法都会生成一个新的类加载器实例，因此同一个类可以实现重复加载。然后反射调用这个Class对象的main（）方法，如果期间出现任何异常，将异常信息打印到HackSystem.out中，最后把缓冲区中的信息作为方法的结果来返回。
 * */

package org.jvm;

import java.lang.reflect.Method;

/**
 * java class 执行工具
 */
public class JavaClassExecute {

    public static String execute(byte[] classByte) {
        HackSystem.clearBuffer();
        ClassModifier cm = new ClassModifier(classByte);
        byte[] modiBytes = cm.modifyUTF8Constant("java/lang/System", "org/jvm/HackSystem");
        HotSwapClassLoader loader = new HotSwapClassLoader();
        Class clazz = loader.loadByte(modiBytes);
        try {
            Method method = clazz.getMethod("main", new Class[] {String[].class});
            method.invoke(null, new String[] {null});
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return HackSystem.getBufferString();
    }

}
