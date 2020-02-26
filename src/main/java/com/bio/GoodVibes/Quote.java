package com.bio.GoodVibes;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Quote extends Command {
    public Quote(){
        this.name = "quote";
        this.help = "gets a quote";
    }
    @Override
    protected void execute(CommandEvent commandEvent) {
        try {
            URL url = new URL("http://inspirobot.me//api?generate=true");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            SendEmbed.sendImage("Inspirobot Quote","", "here's your inspirobot quote", br.readLine(), commandEvent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
