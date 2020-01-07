package com.acher.HaGaon;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text extends bookImpl{
    public Text() {
        this.name = "Text";
        this.help = "If you don't know the full/formal name of the book, try this command";
    }
    protected String[] run(String args){
        //let's pick it apart
        String pattern = "(\\S+)(\\s.+)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(args);
        String book = "Not found", rest = "Not found";
        if (m.find()){
            book = m.group(1);
            rest = m.group(2);
        }
        else {
            return new String[]{"error.","There was a problem finding either the book or the quote. Please try again."};
        }
        String text = "couldn't find it.";
        text = findBookType(book);
        //let's call some functions
        try {
            Class<?> myClass = Class.forName("com.acher.HaGaon."+text);
            Constructor con = myClass.getConstructor();
            Object inst = con.newInstance();
            Method method = myClass.getDeclaredMethod("run", String.class);
            String all = book+rest;
            return (String[]) method.invoke(inst, all);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
            return new String[]{"error.","if you're seeing this, we couldn't find "+text+" or some other error happened :/"};
        }
    }

    protected String findBookType(String book){
        String sURL = "https://www.sefaria.org/api/texts/";
        //let's pick it apart
        book = sURL + book;
        String type = "couldn't find it.";
        try {
            URL url = new URL(book);
            URLConnection request = url.openConnection();
            request.connect();
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject rootobj = root.getAsJsonObject();
            //JsonArray text = rootobj.get("titleVariants").getAsJsonArray();s
            type = rootobj.get("type").getAsString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return type;
    }
}
