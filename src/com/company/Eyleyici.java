package com.company;

import java.util.Random;

public class Eyleyici implements IEyleyici {

    @Override
    public void sogutucuAc() {

        Ekran ekran=new Ekran();
        CihazBilgiSistemi cbz =new CihazBilgiSistemi();


        ekran.mesajGoruntule("İstek Gönderildi...Soğutucu Açılıyor...");
        Araclar.bekle();
        boolean deger;
        deger=cbz.sogutucuSorgu();
        if(deger)
        {
            cbz.closeConnection();
            ekran.mesajGoruntule("Soğutucu Açılamadı..");
            ekran.mesajGoruntule("\n***Soğutucu zaten açık***");
        }
        else{
            cbz.veriEkle("isOpen",true);
            cbz.closeConnection();
            ekran.mesajGoruntule("Soğutucu Açıldı..");

        }
    }

    @Override
    public void sogutucuKapat() {
        Ekran ekran=new Ekran();
        Random random=new Random();
        CihazBilgiSistemi cbz =new CihazBilgiSistemi();

        ekran.mesajGoruntule("İstek Gönderildi...Soğutucu Kapatılıyor....");
        Araclar.bekle();

        boolean deger2;
        deger2= cbz.sogutucuSorgu();
        if(!deger2)
        {
            cbz.closeConnection();

            ekran.mesajGoruntule("Soğutucu Kapatılamadı..");
            ekran.mesajGoruntule("\n***Soğutucu zaten kapalı***");

        }
        else{
            cbz.veriEkle("isOpen",false);
            cbz.closeConnection();
            ekran.mesajGoruntule("Soğutucu Kapatıldı..");

        }
    }
}
