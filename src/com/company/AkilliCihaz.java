package com.company;

import java.util.Random;

public class AkilliCihaz {

    public static void main(String[] args) {

        Random random = new Random();
        Ekran ekran = new Ekran();
        AgArayuzu agArayuzu = new AgArayuzu();
        TusTakimi tusTakimi = new TusTakimi();
        Kullanici kullanici = new Kullanici();
        Algilayici sicaklik = new Algilayici();
        CihazBilgiSistemi cbz=new CihazBilgiSistemi();
        boolean control=true;

        IEyleyici eyleyici=new Eyleyici(); //Dependency inversion örneği
        Buton buton=new Buton(eyleyici);



        Cihaz cihaz=new Cihaz.CihazBuilder(1.2F)
                .renk("siyah")
                .model("MMV-120")
                .build();


        cbz.openConnection();
        cbz.sicaklikEkle("Sogutucu","sicaklik",Double.valueOf(random.nextInt(40)));
        cbz.closeConnection();

        ekran.mesajGoruntule("username : ");
        String username = tusTakimi.veriAl();
        ekran.mesajGoruntule("password :");
        String password = tusTakimi.veriAl();


            if (kullanici.girisYap(username,password))
            {
                ekran.mesajGoruntule("--------------------------------------------- \n");
                System.out.println("Cihaz Bilgileri:\n" + "model:"+cihaz.getModel()
                        +"\n"+"Ağırlık:"+cihaz.getAgirlik()+"kg"
                        +"\n"+"Renk:"+cihaz.getRenk());
                ekran.mesajGoruntule("\n--------------------------------------------- \n");

                Araclar.bekle();
                while (control) {

                    for (String mesaj : agArayuzu.getMenuList()
                    ) {
                        ekran.mesajGoruntule(mesaj);
                    }
                    String secim = tusTakimi.veriAl();
                    switch (secim) {
                        case "1":
                            sicaklik.sicaklikGoruntule();
                            break;
                        case "2":
                            buton.ac();
                            break;
                        case "3":
                            buton.kapat();
                            break;
                        case "4":
                            control = false;
                            break;
                        default:
                            ekran.mesajGoruntule("GEÇERSİZ SEÇİM....");
                            break;
                    }
                    ekran.mesajGoruntule("\n--------------------------------------------------- \n");
                }
            }
            else{
                ekran.mesajGoruntule("Giriş başarısız.Kullanıcı adı veya şifre hatalı.....");
            }


    }

}
