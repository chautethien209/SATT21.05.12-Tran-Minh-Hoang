package main.Common;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonHelper {
    public static JsonObject getJsonObject(String jsonProjectPath) {
        try {
            JsonObject obj;
            Gson gson = new Gson();
            JsonReader reader = getJsonReader(jsonProjectPath);
            obj = gson.fromJson(reader, JsonObject.class);
            return obj;
        } catch (Exception e) {
            throw e;
        }
    }

    private static JsonReader getJsonReader(String jsonProjectPath) {
        try {
            JsonReader reader;
            reader = new JsonReader(new FileReader(jsonProjectPath));
            return reader;
        } catch (FileNotFoundException e) {
            return null;
        }
    }
}
