package com.company;

public class Araclar {

    private static final int sure=1000;

    public static void bekle(){
        try
        {
            Thread.sleep(sure);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
