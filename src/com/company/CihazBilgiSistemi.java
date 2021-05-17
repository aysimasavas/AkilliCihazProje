package com.company;

import java.sql.*;

public class CihazBilgiSistemi implements ICihazBilgiSistemi{

    Connection connection;
    ResultSet resultSet;
    Statement stmt;

    public CihazBilgiSistemi() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AkilliCihazDB",
                    "postgres", "aysisava");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean userSorgu(String username, String password) {
        String sql="SELECT * FROM public.\"Kullanici\"";

        try {
            stmt=connection.createStatement();
            resultSet=stmt.executeQuery(sql);

            while(resultSet.next())
            {
                String username1=resultSet.getString("userName");
                String password1=resultSet.getString("password");

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

    @Override
    public Double sicaklikSorgu(String table, String column)
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

    @Override
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

    @Override
    public void veriEkle(String column, boolean Value) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement("UPDATE public.\"Sogutucu\" SET \""+ column + "\"= ? WHERE \"id\"=1");
            st.setBoolean(1, Value);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean sogutucuSorgu() {

        boolean result = false;
        String sql = "Select * From public.\"Sogutucu\""; //Sql sorgusu
        try {
            stmt=connection.createStatement();
            resultSet=stmt.executeQuery(sql);
            while(resultSet.next())
            {
                    result = resultSet.getBoolean("isOpen");
            }
            resultSet.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
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
