package com.ql.core.helper;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class JsonHelper {

    public static void exportJsonToFile(String filePath, JSONArray jsonArray){
        try (PrintWriter out = new PrintWriter(new FileWriter(filePath))) {
            out.write(jsonArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Object[][] ReadJsonFromFile(String filePath){
        Object[][] dataProvider;

        try (Reader reader = new FileReader(filePath))
        {
            //Read JSON file
            JSONParser parser = new JSONParser();

            Object objectRead = parser.parse(reader);
            JSONArray data = (JSONArray) objectRead;
            JSONObject firstObject = (JSONObject)data.get(0);
            int width = firstObject.size();
            int height = data.size();
            dataProvider = new Object[height][width];

            for(int i = 0; i < height; i++){
                JSONObject obj = (JSONObject)data.get(i);
                String[] key = (String[]) obj.keySet().toArray(new String[0]);
                for(int j = 0; j < width; j++){
                    if(obj == null){
                        dataProvider[i][j] = "";
                    }
                    else {
                        String dataFromKey = obj.get(key[j]).toString();
                        dataProvider[i][j] = dataFromKey;
                    }
                }
            }
            return dataProvider;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Object[0][0];
    }

}
