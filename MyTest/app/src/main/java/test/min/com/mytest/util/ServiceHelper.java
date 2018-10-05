package test.min.com.mytest.util;

import com.alibaba.fastjson.JSON;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import test.min.com.mytest.view.Food;

public class ServiceHelper {
    public void callRestService(String strUrl) {
        try {
            URL url = new URL(strUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String output;
            String strJson = "";
            while( (output = reader.readLine()) != null) {
                strJson = output;
            }

            System.out.println(strJson);

            List<Food> list = JSON.parseArray(strJson, Food.class);
            System.out.println(list.get(0).getName());
//            List<Food> list = new ArrayList<Food>();
//            JSONArray ja = new JSONArray(strJson);
//
//            for (int i = 0; i < ja.length(); i++) {
//                JSONObject o = ja.getJSONObject(i);
//                String name = o.getString("name");
//                Food food = new Food();
//                food.setName(name);
//                list.add(food);
//            }
//            System.out.println(list.size());
//            System.out.println(list.get(0).getName());


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static List<Food> getFoodDetl(String keyword) {
        List<Food> list = null;
        URL url;
        try {
            if("".equals(keyword)){
                url = new URL("https://www.ptelearning.cn/pte-app/getFoodInfo");
            }else{
                url = new URL("https://www.ptelearning.cn/pte-app/getFoodInfo?keyword="+keyword);
            }

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String output;
            String strJson = "";
            while( (output = reader.readLine()) != null) {
                strJson = output;
            }

            System.out.println(strJson);

            list = JSON.parseArray(strJson, Food.class);


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {

        List<Food> list = ServiceHelper.getFoodDetl(URLEncoder.encode("徐汇"));
        System.out.println(list.get(0).getName());
    }
}
