package com.epam.mjc.io;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) throws IOException {
        String[] strings = null;

        try(FileInputStream inputStream = new FileInputStream(file)) {
            String text = null;
            int ch;
            while ((ch = inputStream.read()) != -1){
                text += String.valueOf((char)ch);
            }
            text = text.replace("\n"," ");
            text = text.replace("\r","");
            strings = text.split(" ");

        } catch (IOException e)
        {

        }
        String name = strings[1];
        Integer age = Integer.valueOf(strings[3]);
        String email = strings[5];
        Long phone = Long.valueOf(strings[7]);
        Profile pro = new Profile(name,age,email,phone);
        return pro;
    }
}
