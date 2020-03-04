package com.bio.GoodVibes;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class randime extends Command {

    public randime() {
        this.name = "randime";
        this.help = "generates a random anime";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        String args = commandEvent.getArgs();
        URL url = null;
        try {
            url = new URL("https://anidb.net/anime/random");
            URLConnection request = url.openConnection();
            request.connect();
            Document doc = Jsoup.connect("https://anidb.net/anime/random").get();
            Elements name = doc.getElementsByClass("value");
            String[] n = name.first().text().split("\\(.+\\)");
            String numen = n[0];
            String line = doc.getElementsByClass(
                    args.contains("MAL") ?
                        "i_icon i_resource_mal brand" :
                        "shortlink"
            ).attr("href");
            System.out.println(n);
            Elements ne = doc.select("div[itemprop = description]");
            if (ne.text().length() < 1) {
                execute(commandEvent);
                return;
            }
            String body = ne.text().replaceAll("(^\")|Source:\\s.+", "");
            System.out.println(body);
            Elements img = doc.select("img[itemprop = image]");
            SendEmbed.send_image_with_hyperlink(numen, line, body, img.attr("src"), commandEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
