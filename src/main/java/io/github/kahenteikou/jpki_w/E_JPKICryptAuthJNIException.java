package io.github.kahenteikou.jpki_w;

public class E_JPKICryptAuthJNIException  extends Exception{
    public enum JPKI_ERR{
        JPKI_ERR_JAVA_NOMEMORY(9),
        JPKI_ERR_NOMEMORY(8),
        JPKI_ERR_PARAM(1),
        JPKI_ERR_UNKNOWN(99),
        JPKI_ERR_WINDOWS(2),
        JPKI_WIN_CANCELLED_BY_USER(-2146434962),
        JPKI_WIN_CHV_BLOCKED(-2146434964),
        JPKI_WIN_ERR_BAD_HASH(-2146893822),
        JPKI_WIN_ERR_BAD_HASH_STATE(-2146893812),
        JPKI_WIN_ERR_BAD_KEY(-2146893821),
        JPKI_WIN_ERR_BAD_UID(-2146893823),
        JPKI_WIN_ERR_BAD_VER(-2146893817),
        JPKI_WIN_ERR_NO_MEMORY(-2146893810),
        JPKI_WIN_NOT_READY(-2146435056),
        JPKI_WIN_UNKNOWN_CARD(-2146435059);
        private final int valuekun;
        private JPKI_ERR(int value22){
            valuekun=value22;
        }
        public int getInt(){
            return valuekun;
        }
    }
    private static JPKI_ERR errcode = JPKI_ERR.JPKI_ERR_WINDOWS;
    private static JPKI_ERR werrcode = JPKI_ERR.JPKI_ERR_WINDOWS;
    public JPKI_ERR toJPKIErr(int vkun){
        for(JPKI_ERR e:JPKI_ERR.values()){
            if(e.getInt()==vkun){
                return e;
            }
        }
        return null;
    }
    public E_JPKICryptAuthJNIException() {
    }

    public E_JPKICryptAuthJNIException(JPKI_ERR errcodea, JPKI_ERR errcode_w, String strDetail) {
        super(strDetail);
        errcode = errcodea;
        werrcode = errcode_w;
    }
    public E_JPKICryptAuthJNIException(int errcodea, int errcode_w, String strDetail) {
        super(strDetail);
        errcode=toJPKIErr(errcodea);
        werrcode=toJPKIErr(errcode_w);
    }

    public JPKI_ERR getErrCode() {
        return errcode;
    }
    public JPKI_ERR getWinErrCode() {
        return werrcode;
    }
}
