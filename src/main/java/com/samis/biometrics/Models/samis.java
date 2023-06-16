//package com.samis.biometrics.Models;
//
//import com.mysql.cj.xdevapi.JsonArray;
//import com.mysql.cj.xdevapi.JsonParser;
//import org.json.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.ProtocolException;
//import java.net.URL;//package com.samis.biometrics.Models;
//
//import com.mysql.cj.xdevapi.JsonArray;
//import com.mysql.cj.xdevapi.JsonParser;
//import org.json.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.ProtocolException;
//import java.net.URL;
//
//public class samis {
//    public static  void main(String[] args) throws IOException {
//        URL url = new URL("https://api.leonteqsecurity.com/fetch_all/project/");
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("GET");
//
//        int responseCode = connection.getResponseCode();
//        if (responseCode == HttpURLConnection.HTTP_OK) {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            StringBuilder response = new StringBuilder();
////            String response = reader.readLine();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                response.append(line+"\n");
//            }
//            reader.close();
//            String hhello=response.toString();
//            JSONObject hello = new JSONObject(hhello);
//            System.out.println(hello.get("allProjects").getClass());
//
//
//
//
//
//        }
//    }
//
//}

//
//public class samis {
//    public static  void main(String[] args) throws IOException {
//        URL url = new URL("https://api.leonteqsecurity.com/fetch_all/project/");
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("GET");
//
//        int responseCode = connection.getResponseCode();
//        if (responseCode == HttpURLConnection.HTTP_OK) {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            StringBuilder response = new StringBuilder();
////            String response = reader.readLine();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                response.append(line+"\n");
//            }
//            reader.close();
//            String hhello=response.toString();
//            JSONObject hello = new JSONObject(hhello);
//            System.out.println(hello.get("allProjects").getClass());
//
//
//
//
//
//        }
//    }
//
//}
