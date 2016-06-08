package edu.nyit.app.demo;

import android.os.Environment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileMaker {

    protected static File       file;
    protected static FileWriter fw;

    protected static File       storage = Environment.getExternalStorageDirectory(),
                                folder  = new File(storage.toString());

    public static void folder(String f) {
        folder = new File(storage+"/"+f);
        if(!folder.exists()) folder.mkdir();
    }

    public static void file(String fn) {
        file = new File(folder+"/"+fn);
    }

    public static boolean touchFile(String filename) {
        file(filename);
        return touchFile();
    }

    public static boolean touchFile() {
        try {
            fw = new FileWriter(file);
            fw.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public static boolean open() {
        try {
            fw = new FileWriter(file,true);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public static boolean close() {
        try {
            fw.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public static boolean print(String word) {
        try {
            fw.write(word);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public static boolean println(String line){
        return print(line+"\n");
    }

}
