package com.bio.GoodVibes;

import com.acher.HaGaon.SendVerse;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class RandWiki extends Command {
    public RandWiki(){
        this.name = "randWiki";
        this.help = "generates a random wikipedia page";
    }
    @Override
    protected void execute(CommandEvent commandEvent) {
        URL url = null;
        try {
            url = new URL(" https://en.wikipedia.org/wiki/Special:Random");
            //BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            URLConnection conn = url.openConnection();
            SendVerse.sendEmbed("Inspirobot Quote", url.toExternalForm(), commandEvent);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
