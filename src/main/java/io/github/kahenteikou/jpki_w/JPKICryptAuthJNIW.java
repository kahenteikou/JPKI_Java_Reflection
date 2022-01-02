package io.github.kahenteikou.jpki_w;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class JPKICryptAuthJNIW {
    private static Class class_target;
    private static Class JPKICryptAuthJNIException_class;
    private Object target_class;
    private static Method cryptAcquireContext_m;
    private static Method getErrorCode_m;
    private static Method getWinErrorCode_m;
    private static Method getMessage_m;
    private static Method cryptReleaseContext_m;
    private static Method certCreateCertificateContext_m;
    private static Method certFreeCertificateContext_m;
    private static Method certGetPublicKeyInfo_m;
    private static Method cryptImportPublicKey_m;
    private static Method cryptGetUserKey_m;

    public static void Load_E(String JPKIJar_Path) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        File jpkijarfile=new File(JPKIJar_Path);
        URLClassLoader loader= URLClassLoader.newInstance(new URL[]{jpkijarfile.toURI().toURL()});
        class_target=loader.loadClass("jp.go.jpki.appli.JPKICryptAuthJNI");
        JPKICryptAuthJNIException_class=loader.loadClass("jp.go.jpki.appli.JPKICryptAuthJNIException");
        cryptAcquireContext_m=class_target.getMethod("cryptAcquireContext",int.class);
        getErrorCode_m=JPKICryptAuthJNIException_class.getMethod("getErrorCode");
        getWinErrorCode_m=JPKICryptAuthJNIException_class.getMethod("getWinErrorCode");
        getMessage_m=JPKICryptAuthJNIException_class.getMethod("getMessage");
        cryptReleaseContext_m=class_target.getMethod("cryptReleaseContext",long.class);
        certCreateCertificateContext_m=class_target.getMethod("certCreateCertificateContext",byte[].class);
        certFreeCertificateContext_m=class_target.getMethod("certFreeCertificateContext",long.class);
        certGetPublicKeyInfo_m=class_target.getMethod("certGetPublicKeyInfo",long.class);
        cryptImportPublicKey_m=class_target.getMethod("cryptImportPublicKey",long.class,byte[].class);
        cryptGetUserKey_m=class_target.getMethod("cryptGetUserKey",long.class);
    }
    public static void Load_E() throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Load_E(System.getenv("ProgramFiles")+"\\JPKILib\\Javalib64\\JPKICryptAuthJNI.jar");
    }
    public JPKICryptAuthJNIW() throws InstantiationException, IllegalAccessException {
        target_class=class_target.newInstance();
    }
    public static E_JPKICryptAuthJNIException JPKICryptAuthJNIExceptionConverter(Throwable t) throws IllegalAccessException, InvocationTargetException {
        return new E_JPKICryptAuthJNIException((int)getErrorCode_m.invoke(t),(int)getWinErrorCode_m.invoke(t),(String)getMessage_m.invoke(t));
    }
    public long cryptAcquireContext(int flag) throws IllegalAccessException, E_JPKICryptAuthJNIException, InvocationTargetException {
        try {
            return (long)cryptAcquireContext_m.invoke(target_class,flag);
        } catch (InvocationTargetException e) {
            throw JPKICryptAuthJNIExceptionConverter(e.getCause());
        }
    }
    public void cryptReleaseContext(long hProv) throws InvocationTargetException, IllegalAccessException, E_JPKICryptAuthJNIException {
        try{
            cryptReleaseContext_m.invoke(target_class,hProv);
        } catch (InvocationTargetException e) {
            throw JPKICryptAuthJNIExceptionConverter(e.getCause());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public long certCreateCertificateContext(byte[] certValue) throws InvocationTargetException, IllegalAccessException, E_JPKICryptAuthJNIException {
        try{
            return (long) certCreateCertificateContext_m.invoke(target_class,certValue);
        } catch (InvocationTargetException e) {
            throw JPKICryptAuthJNIExceptionConverter(e.getCause());
        }
    }
    public void certFreeCertificateContext(long hCert) throws InvocationTargetException, IllegalAccessException, E_JPKICryptAuthJNIException {
        try{
            certFreeCertificateContext_m.invoke(target_class,hCert);
        } catch (InvocationTargetException e) {
            throw JPKICryptAuthJNIExceptionConverter(e.getCause());
        }
    }
    public byte[] certGetPublicKeyInfo(long hCert)throws InvocationTargetException, IllegalAccessException, E_JPKICryptAuthJNIException {
        try{
            return (byte[])certGetPublicKeyInfo_m.invoke(target_class,hCert);
        }catch (InvocationTargetException e) {
            throw JPKICryptAuthJNIExceptionConverter(e.getCause());
        }
    }
    public long cryptImportPublicKey(long hProv,byte[] publicKeyInfo)throws InvocationTargetException, IllegalAccessException, E_JPKICryptAuthJNIException {
        try{
            return (long)cryptImportPublicKey_m.invoke(target_class,hProv,publicKeyInfo);
        }catch (InvocationTargetException e) {
            throw JPKICryptAuthJNIExceptionConverter(e.getCause());
        }
    }
    public long cryptGetUserKey(long hProv) throws InvocationTargetException, IllegalAccessException, E_JPKICryptAuthJNIException {
        try{
            return (long)cryptGetUserKey_m.invoke(target_class,hProv);
        }catch (InvocationTargetException | IllegalAccessException e) {
            throw JPKICryptAuthJNIExceptionConverter(e.getCause());
        }
    }


}
