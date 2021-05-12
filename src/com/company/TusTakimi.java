package com.company;

import java.util.Scanner;

public class TusTakimi implements ITusTakimi{

    @Override
    public String veriAl() {

        Scanner girdi = new Scanner(System.in);
        String sonuc = girdi.next();
        return sonuc;
    }
}
