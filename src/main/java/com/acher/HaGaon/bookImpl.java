package com.acher.HaGaon;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public abstract class bookImpl extends Command {
    private static String sURL = "https://www.sefaria.org/api/texts/";
    protected void execute(CommandEvent commandEvent) {
        run(commandEvent, commandEvent.getArgs());
    }

    protected void run(CommandEvent event,  String args){}

    protected String findBookType(String book){
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
