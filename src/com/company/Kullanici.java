package com.company;

public class Kullanici {
    private String userName;
    private String sifre;

    CihazBilgiSistemi cbz;

    public boolean girisYap(String userName,String password){
        System.out.println("Kullanıcı Doğrulanıyor....Lütfen bekleyiniz..");
        Araclar.bekle();
        cbz=new CihazBilgiSistemi();

        cbz.openConnection();
        if(cbz.UserSorgu(userName,password)){
            cbz.closeConnection();
            System.out.println("Giriş Başarılı..");
            return true;
        }
        cbz.closeConnection();
        System.out.println("Giriş Başarısız..");
        return false;
    }
}
