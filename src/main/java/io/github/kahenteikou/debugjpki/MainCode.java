package io.github.kahenteikou.debugjpki;

import io.github.kahenteikou.jpki_w.E_JPKICryptAuthJNIException;
import io.github.kahenteikou.jpki_w.JPKICryptAuthJNIW;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;

public class MainCode {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        JPKICryptAuthJNIW.Load_E();
        JPKICryptAuthJNIW jpkiCryptAuthJNIW=new JPKICryptAuthJNIW();
        long hProvider = 0;
        try {
            hProvider = jpkiCryptAuthJNIW.cryptAcquireContext(0);
        } catch (E_JPKICryptAuthJNIException e) {
            System.out.println(e.getWinErrCode().name());
            System.out.println(e.getErrCode().name());
        }
        try {
            jpkiCryptAuthJNIW.cryptReleaseContext(hProvider);
        }catch (E_JPKICryptAuthJNIException e){
            e.printStackTrace();
        }

    }
}
