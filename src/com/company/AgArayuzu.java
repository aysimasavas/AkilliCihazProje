package com.company;

import java.util.ArrayList;

public class AgArayuzu implements IAgArayuzu {
    @Override
    public int secim() {
        return 0;
    }

    @Override
    public ArrayList<String> getMenuList() {
        return menuList2;
    }

    @Override
    public void setMenuList(ArrayList<String> menuList) {

        menuList2=menuList;
    }

    ArrayList<String> menuList2;

    AgArayuzu() {
        this.menuList2 = new ArrayList<>();
        menuList2.add("1) Sıcaklık Görüntüle");
        menuList2.add("2) Soğutucuyu Aç");
        menuList2.add("3) Soğutucuyu Kapat");
        menuList2.add("4) Çıkış");

    }
}
