package agent;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

public class MyProxyTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
        ProtectionDomain protectionDomain, byte[] classfileBuffer)
        throws IllegalClassFormatException {

        System.out.println(className);
        if (className.indexOf("HelloWorld") > 0) {
            //javassist的包名是用点分割的，需要转换下
            if (className != null && className.indexOf("/") != -1) {
                className = className.replaceAll("/", ".");
            }
            System.out.println("代理类："+className);
            try {
                //通过包名获取类文件
                CtClass cc = ClassPool.getDefault().get(className);
                //获得指定方法名的方法
                CtMethod m = cc.getDeclaredMethod("say");
                //在方法执行前插入代码
                m.insertBefore("{ System.out.println(\"记录日志\"); }");
                return cc.toBytecode();
            } catch (NotFoundException e) {
            } catch (CannotCompileException e) {
            } catch (IOException e) {
                //忽略异常处理
            }
        }

        return new byte[0];
    }

    /**
     * 在main函数执行前，执行的函数
     */
//    public static void premain(String options, Instrumentation ins) {
//        //注册我自己的字节码转换器
//        System.out.println("执行premain方法");
//        ins.addTransformer(new MyProxyTransformer());
//    }
}
