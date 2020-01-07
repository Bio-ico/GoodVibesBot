package com.acher.HaGaon;


import com.jagrosh.jdautilities.command.CommandEvent;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text extends bookImpl{
    public Text() {
        this.name = "Text";
        this.help = "If you don't know the full/formal name of the book, try this command";
    }
    protected void run(CommandEvent event,  String args){
        String sURL = "https://www.sefaria.org/api/texts/";
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
            SendVerse.sendEmbed("not oka", args, event);
        }
        String text = "couldn't find it.";
        text = findBookType(book);
        //let's call some functions
        try {
            Class<?> myClass = Class.forName("com.acher.HaGaon."+text);
            SendVerse.sendEmbed("Yup", "found: ->"+text+"<-", event);
            Constructor con = myClass.getConstructor();
            Object inst = con.newInstance();
            Method method = myClass.getDeclaredMethod("run", CommandEvent.class, String.class);
            String all = book+rest;
            method.invoke(inst, event, all);
        } catch (ClassNotFoundException e) {
            SendVerse.sendEmbed("whoops", "not found:->"+text+"<-", event);
            e.printStackTrace();
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            SendVerse.sendEmbed("no method", "not found:->"+text+"<-", event);
            e.printStackTrace();
        }
        SendVerse.sendEmbed(book, text, event);
    }

}
