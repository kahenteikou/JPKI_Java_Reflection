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
    private static Method cryptDestroyKey_m;
    private static Method cryptGetCertificateValue_m;
    private static Method cryptGetRootCertificateValue_m;
    private static Method cryptCreateHash_m;
    private static Method cryptCreateHash_2_m;
    private  static  Method cryptHashData_m;
    private static Method cryptGetHashValue_m;
    private static Method cryptSetHashValue_m;
    private static Method cryptSignHash_m;
    private static Method cryptDestroyHash_m;
    private static Method cryptVerifySignature_m;
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
        cryptDestroyKey_m=class_target.getMethod("cryptDestroyKey",long.class);
        cryptGetCertificateValue_m=class_target.getMethod("cryptGetCertificateValue",long.class);
        cryptGetRootCertificateValue_m=class_target.getMethod("cryptGetRootCertificateValue",long.class);
        cryptCreateHash_m=class_target.getMethod("cryptCreateHash",long.class);
        cryptCreateHash_2_m=class_target.getMethod("cryptCreateHash",long.class,int.class);
        cryptHashData_m=class_target.getMethod("cryptHashData",long.class,byte[].class);
        cryptGetHashValue_m=class_target.getMethod("cryptGetHashValue",long.class);
        cryptSetHashValue_m=class_target.getMethod("cryptSetHashValue",long.class,byte[].class);
        cryptSignHash_m=class_target.getMethod("cryptSignHash",long.class);
        cryptDestroyHash_m=class_target.getMethod("cryptDestroyHash",long.class);
        cryptVerifySignature_m=class_target.getMethod("cryptVerifySignature",long.class,byte[].class,long.class);
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
        }catch (InvocationTargetException e) {
            throw JPKICryptAuthJNIExceptionConverter(e.getCause());
        }
    }
    public void cryptDestroyKey(long hKey) throws InvocationTargetException, IllegalAccessException, E_JPKICryptAuthJNIException {
        try{
            cryptDestroyKey_m.invoke(target_class,hKey);
        }catch (InvocationTargetException e) {
            throw JPKICryptAuthJNIExceptionConverter(e.getCause());
        }
    }
    public byte[] cryptGetCertificateValue(long hKey) throws InvocationTargetException, IllegalAccessException, E_JPKICryptAuthJNIException {
        try{
            return (byte[])cryptGetCertificateValue_m.invoke(target_class,hKey);
        }catch (InvocationTargetException e) {
            throw JPKICryptAuthJNIExceptionConverter(e.getCause());
        }
    }
    public byte[] cryptGetRootCertificateValue(long hProv) throws InvocationTargetException, IllegalAccessException, E_JPKICryptAuthJNIException {
        try{
            return (byte[]) cryptGetRootCertificateValue_m.invoke(target_class,hProv);
        }catch (InvocationTargetException e) {
            throw JPKICryptAuthJNIExceptionConverter(e.getCause());
        }
    }
    public long cryptCreateHash(long hProv) throws InvocationTargetException, IllegalAccessException, E_JPKICryptAuthJNIException {
        try{
            return (long)cryptCreateHash_m.invoke(target_class,hProv);
        }catch (InvocationTargetException e) {
            throw JPKICryptAuthJNIExceptionConverter(e.getCause());
        }
    }
    public long cryptCreateHash(long hProv,int algid) throws InvocationTargetException, IllegalAccessException, E_JPKICryptAuthJNIException {
        try{
            return (long)cryptCreateHash_2_m.invoke(target_class,hProv,algid);
        }catch (InvocationTargetException e) {
            throw JPKICryptAuthJNIExceptionConverter(e.getCause());
        }
    }
    public void cryptHashData(long hHash,byte[] data) throws InvocationTargetException, IllegalAccessException, E_JPKICryptAuthJNIException {
        try{
            cryptHashData_m.invoke(target_class,hHash,data);
        }catch (InvocationTargetException e) {
            throw JPKICryptAuthJNIExceptionConverter(e.getCause());
        }
    }
    public byte[] cryptGetHashValue(long hHash) throws InvocationTargetException, IllegalAccessException, E_JPKICryptAuthJNIException {
        try{
            return (byte[]) cryptGetHashValue_m.invoke(target_class,hHash);
        }catch (InvocationTargetException e) {
            throw JPKICryptAuthJNIExceptionConverter(e.getCause());
        }
    }
    public void cryptSetHashValue(long hHash,byte[] data) throws InvocationTargetException, IllegalAccessException, E_JPKICryptAuthJNIException {
        try{
            cryptSetHashValue_m.invoke(target_class,hHash,data);
        }catch (InvocationTargetException e) {
            throw JPKICryptAuthJNIExceptionConverter(e.getCause());
        }
    }
    public byte[] cryptSignHash(long hHash) throws InvocationTargetException, IllegalAccessException, E_JPKICryptAuthJNIException {
        try{
            return (byte[]) cryptSignHash_m.invoke(target_class,hHash);
        }catch (InvocationTargetException e) {
            throw JPKICryptAuthJNIExceptionConverter(e.getCause());
        }
    }
    public void cryptDestroyHash(long hHash) throws InvocationTargetException, IllegalAccessException, E_JPKICryptAuthJNIException {
        try{
            cryptDestroyHash_m.invoke(target_class,hHash);
        }catch (InvocationTargetException e) {
            throw JPKICryptAuthJNIExceptionConverter(e.getCause());
        }
    }
    public boolean cryptVerifySignature(long hHash,byte[] signature,long hPubkey) throws InvocationTargetException, IllegalAccessException, E_JPKICryptAuthJNIException {
        try{
            return (boolean) cryptVerifySignature_m.invoke(target_class,hHash,signature,hPubkey);
        }catch (InvocationTargetException e) {
            throw JPKICryptAuthJNIExceptionConverter(e.getCause());
        }
    }

}
