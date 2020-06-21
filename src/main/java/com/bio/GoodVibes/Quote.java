package com.bio.GoodVibes;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import org.jsoup.Jsoup;

public class Quote extends Command {
    public Quote(){
        this.name = "quote";
        this.help = "gets a quote";
    }
    @Override
    protected void execute(CommandEvent commandEvent) {
        try {
            String link =  Jsoup.connect("http://inspirobot.me//api?generate=true").get().body().text();
            SendEmbed.sendImage("Inspirobot Quote",link, "here's your inspirobot quote", link, commandEvent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
