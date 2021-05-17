package com.company;

public interface ICihazBilgiSistemi {

    boolean userSorgu(String username,String password);
    Double sicaklikSorgu(String table,String column);
    void sicaklikEkle(String table,String column,double Value);
    void veriEkle(String column, boolean Value);
    boolean sogutucuSorgu();
    public void closeConnection();


}
