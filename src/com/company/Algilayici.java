package com.company;

import java.util.Random;

public class Algilayici implements IAlgilayici{
    @Override
    public void sicaklikGoruntule() {
        Ekran ekran = new Ekran();
        CihazBilgiSistemi cbz = new CihazBilgiSistemi();
        ekran.mesajGoruntule("SICAKLIK ÖLÇÜLÜYOR***");
        Araclar.bekle();

        Double veri = cbz.sicaklikSorgu("Sogutucu","sicaklik");
        ekran.mesajGoruntule(veri+" Derece");
    }

    @Override
    public void sicaklikOlc() {
        Random random=new Random();
        CihazBilgiSistemi cbz = new CihazBilgiSistemi();

        cbz.sicaklikEkle("Sogutucu","sicaklik",Double.valueOf(random.nextInt(40)));
        cbz.closeConnection();



    }
}
