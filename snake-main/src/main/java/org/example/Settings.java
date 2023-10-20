package org.example;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Settings {
    private final static String FILE_NAME = "settings.json";

    public Color gamePanelBackground = Color.BLACK; //DEFAULT VALUE
    public Color appleColor = Color.red; // DEFAULT VALUE
    public Color gamePanelLineColor = Color.DARK_GRAY; // DEFAULT VALUE

    private static Settings instance;
    public static Settings getInstance() {
        if(instance == null) instance = new Settings();
        return instance;
    }

    private Settings(){
        loadSettings();
    }

    public void loadSettings(){
        JSONObject jsonObject = getFileContent();
        if(jsonObject == null) return;

        if(jsonObject.has("background-color")){
            String gamePanelBackgroundStr = (String) jsonObject.get("background-color");
            this.gamePanelBackground = Color.decode(gamePanelBackgroundStr);
        }

        if(jsonObject.has("apple-color")){
            String gamePanelBackgroundStr = (String) jsonObject.get("apple-color");
            this.appleColor = Color.decode(gamePanelBackgroundStr);
        }

        if(jsonObject.has("line-color")){
            String gamePanelBackgroundStr = (String) jsonObject.get("line-color");
            this.gamePanelLineColor = Color.decode(gamePanelBackgroundStr);
        }
    }

    private JSONObject getFileContent(){
        File file = new File(getSettingsFilePath());
        FileReader fileReader;

        try{
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e){
            System.out.println("Could not find the settings file");
            return null;
        }

        JSONTokener jsonTokener = new JSONTokener(fileReader);

        return new JSONObject(jsonTokener);
    }

    private static String getSettingsFilePath(){
        ClassLoader classLoader = Settings.class.getClassLoader();
        try{
            return classLoader.getResource(FILE_NAME).getPath();
        } catch (NullPointerException e){
            System.out.println("Could not find the settings file");
            return "";
        }
    }
}
