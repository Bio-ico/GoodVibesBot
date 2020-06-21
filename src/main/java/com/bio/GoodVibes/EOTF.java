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
        long n = System.currentTimeMillis();
        int chapter = 1 + (int)(((n &0xFF00)>> 8) % 6);
        int line = 0;
        switch(chapter){
            case 1:
                line = 18;
                break;
            case 2:
                line = 16;
                break;
            case 3:
                line = 18;
                break;
            case 4:
                line = 22;
                break;
            case 5:
                line = 23;
                break;
            default:
                line = 11;
        };
        line = 1 + (int)((n &0x00FF) % line);

        System.out.println(chapter+": "+line);
        try { verseText = TextProcessing.getVerse(book,chapter,line,sURL); }
        catch (IOException e) {
            e.printStackTrace();
            SendVerse.sendEmbed("ERROR", "An Exception has occurred! Try again in a minute!", event);
        }
        SendVerse.sendEmbed("Ethics Of The Fathers "+chapter+": "+line, verseText, event);
    }

}
