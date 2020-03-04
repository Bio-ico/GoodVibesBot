package com.bio.GoodVibes;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
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
            url = new URL("https://en.wikipedia.org/wiki/Special:Random");
            URLConnection request = url.openConnection();
            request.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader((InputStream) request.getContent()));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("rel=\"canonical\"")){
                    line = line.replaceAll("<.+href=\"","").replaceAll("\"/>","");
                    System.out.println(line);
                    break;
                }
            }
            Document doc = Jsoup.connect(line).get();
            Elements name = doc.getElementsByClass("firstHeading");

            Elements body = doc.select("p");//doc.getElementsByClass("mw-parser-output");

            String des = body.text().replaceAll("\\[\\d\\]","");
            if (des.length() > 600){
                des = des.substring(0, 599);
                des = des.split("\\.(?=[^A-z0-9\\s.]*[^.]*$)")[0]+".";
                System.out.println(body.text());
            }
            if (des.length() < 1)
                execute(commandEvent);
            else
                SendEmbed.send_message_with_hyperLink(name.text(), line, des, commandEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
