package com.bio.GoodVibes;

import com.acher.HaGaon.SendVerse;
import com.acher.HaGaon.TextProcessing;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.io.IOException;

public class EOTF extends Command {
    public EOTF() {
        this.name = "eotf";
        this.help = "Grabs a Pirkei Avot verse from Sefaria's API";
    }
    protected void execute(CommandEvent event) {
        //1:1-18
        //2:1-16
        //3:1-18
        //4:1-22
        //5:1-23
        //6:1-11
        String args = event.getArgs();
        String sURL = "https://www.sefaria.org/api/texts/";
        String book = "Pirkei_Avot";
        String verseText = "";
        HighQualityRandom r = new HighQualityRandom();
        int chapter = 1 + r.nextInt(6);
        int line = 1 + r.nextInt(
            switch(chapter){
                case 1 -> 18;
                case 2 -> 16;
                case 3 -> 18;
                case 4 -> 22;
                case 5 -> 23;
                default -> 11;
            });
        System.out.println("chapter = "+chapter+" line = "+line);
        try { verseText = TextProcessing.getVerse(book,chapter,line,sURL); }
        catch (IOException e) {
            e.printStackTrace();
            SendVerse.sendEmbed("ERROR", "An Exception has occurred! Try again in a minute!", event);
        }
        SendVerse.sendEmbed("Ethics Of The Fathers "+chapter+": "+line, verseText, event);
    }

}
