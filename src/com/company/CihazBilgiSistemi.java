package com.company;

import java.sql.*;

public class CihazBilgiSistemi {

    Connection connection;
    ResultSet resultSet;
    Statement stmt;

    public void openConnection()
    {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AkilliCihazDB",
            "postgres", "aysisava");
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
            stmt=connection.createStatement();
            resultSet=stmt.executeQuery(sql);

            while(resultSet.next())
            {
                username1=resultSet.getString("userName");
                password1=resultSet.getString("password");

                if(username.equals(username1) && password.equals(password1))
                    return true;
            }
            resultSet.close();
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
            stmt=connection.createStatement();
            resultSet=stmt.executeQuery(sql);
            while(resultSet.next())
            {
                result = resultSet.getBoolean(column);
            }
            resultSet.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public void veriEkle(String table, String column, boolean Value) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement("UPDATE public.\"" +table +"\" SET \""+ column + "\"= ? WHERE \"id\"=1");
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
        String sql = "Select * From public.\"" + table + "\"";
        try {
            stmt = connection.createStatement();
            resultSet= stmt.executeQuery(sql);
            while (resultSet.next()) {
                result = resultSet.getDouble(column);
            }
            resultSet.close();
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

            st=connection.prepareStatement("UPDATE public.\"" +table +"\" SET \""+ column + "\"= ? WHERE \"id\"=1");
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
            if (resultSet != null)
                resultSet.close();
            connection.close();
            if (stmt != null)
                stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
