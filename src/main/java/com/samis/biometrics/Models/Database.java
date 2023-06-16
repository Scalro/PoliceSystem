package com.samis.biometrics.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.*;

public class Database {

    public static Connection ConnectDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Samis_Biometrics","root","");
            System.out.println("Connected to Database.");
            return connection;
        }catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Cannot connect to database", e);
        }
    }

//    public static ObservableList<Attendance> getData(){
//        Connection connection = ConnectDb();
//        ObservableList<Attendance> list = FXCollections.observableArrayList();
//
//        try {
//            PreparedStatement ps = connection.prepareStatement("select * from students");
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()){
//                list.add(new Attendance( Integer.parseInt(rs.getString("id")), rs.getString("name")
//                        ,rs.getString("adm"), rs.getString("form"),
//                        rs.getString("gender"),rs.getString("adm_year")
//                        , rs.getString("check_in"), rs.getString("check_out") ));
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return list;
//    }

    public static ObservableList<Attendance> getData() {
        ObservableList<Attendance> list = FXCollections.observableArrayList();

        try {
            URL url = new URL("https://api.leonteqsecurity.com/fetch_all/project/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
//            String response = reader.readLine();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line+"\n");
                }
                reader.close();

                JSONObject data =new JSONObject(response.toString());
                System.out.println(data.get("allProjects"));
                JSONArray samis= (JSONArray) data.get("allProjects");
//

                for (int i = 0; i < samis.length(); i++) {
                    JSONObject jsonObject = (JSONObject) samis.get(i);
                    System.out.println(jsonObject);

                    String id = String.valueOf(jsonObject.getLong("id"));
                    String name = jsonObject.getString("category");
                    String adm = jsonObject.getString("price");
                    String form = jsonObject.getString("title");
                    String gender = jsonObject.getString("language");
                    String adm_year = jsonObject.getString("isprice");
                    String check_in = jsonObject.getString("isActive");
                    String check_out = jsonObject.getString("description");

                    list.add(new Attendance(id, name, adm, form, gender, adm_year, check_in, check_out));
                }

                reader.close();
            } else {
                // Handle error response
                System.out.println("HTTP request failed with response code: " + responseCode);
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
