package com.progen.engine.s2dengine.io.fileManagement;

import com.progen.engine.s2dengine.core.Scene;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileLoader {


    public static Scene loadSceneFromTXT (String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        
        Scene scene = new Scene();
        return scene;
    }


}
