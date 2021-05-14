package com.company;

public class Buton {

    private IEyleyici cihaz;


    public Buton(IEyleyici cihaz) {
        this.cihaz = cihaz;
    }
    public void ac(){ cihaz.sogutucuAc();}
    public void kapat(){
        cihaz.sogutucuKapat();
    }
}
