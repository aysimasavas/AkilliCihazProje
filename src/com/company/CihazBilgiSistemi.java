package com.company;

import java.sql.*;

public class CihazBilgiSistemi {

    Connection conn; //baglanti
    ResultSet rs; //sonuc sorgulama
    Statement stmt; //durum

    public void openConnection()
    {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AkilliCihazDB",
            "postgres", "aysisava");//veri tabanına bağlantı yapıyoruz
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public boolean UserSorgu(String username,String password)
    {

        String username1= " ";
        String password1= " ";
        String sql="SELECT * FROM public.\"Kullanici\"";

        try {
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);

            while(rs.next())
            {
                username1=rs.getString("userName");
                password1=rs.getString("password");

                if(username.equals(username1) && password.equals(password1))
                    return true;
            }
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    public boolean sorguBoolean(String table,String column)
    {
        boolean result = false;
        String sql = "Select * From public.\"" + table + "\""; //Sql sorgusu
        try {
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                result = rs.getBoolean(column);
            }
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public void veriEkle(String table, String column, boolean Value) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO  public.\"" + table + "\" (\"" + column + "\") VALUES (?)");
            st.setBoolean(1, Value);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public Double sicaklikSorgu(String table,String column)
    {
        Double result=0.0;
        String sql = "Select * From public.\"" + table + "\""; //Sql sorgusu
        try {
            stmt = conn.createStatement(); //Yeni bir kanal açıyor
            rs = stmt.executeQuery(sql);//Sorguyu databasede çalıştırıyor rs dönüyo
            while (rs.next()) {

                result = rs.getDouble(column);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public void sicaklikEkle(String table,String column,double Value)
    {
        PreparedStatement st=null;
        try {
            st=conn.prepareStatement("INSERT INTO public.\"" +table + "\" (\""+ column + "\") VALUES (?)");
            st.setDouble(1,Value);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void closeConnection()
    {
        try {
            if (rs != null)
                rs.close();
            conn.close();
            if (stmt != null)
                stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
