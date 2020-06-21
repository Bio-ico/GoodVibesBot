package com.bio.GoodVibes;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.net.URL;

public class anime extends Command {

    public anime() {
        this.name = "anime";
        this.help = "Generates an anime. If given no name, will produce a random one.";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        String search_results;
        String args = commandEvent.getArgs();
        boolean mal;
        Document doc;
        URL url;
        if(mal = args.startsWith("MAL"))
            args = args.substring(3).trim();
        try {
            if(args.equalsIgnoreCase("")) {
                 doc = Jsoup.connect("https://anidb.net/anime/random").get();
            }
            else{
                doc = Jsoup.connect( "https://anidb.net/anime/?adb.search="+args+"&do.search=1").get();
                if(doc.getElementsByClass("animelist").hasText()) {
                    search_results = doc.getElementsByClass("thumb anime").select("a").first().attr("href");
                    doc = Jsoup.connect("https://anidb.net"+search_results).get();
                }
            }
            Elements get_name = doc.getElementsByClass("value");
            name = get_name.first().text().split("\\(.+\\)")[0];

            String line = doc.getElementsByClass(
                    mal ?
                        "i_icon i_resource_mal brand" :
                        "shortlink"
            ).attr("href");
            Elements ne = doc.select("div[itemprop = description]");
            String body = "";
            if (ne.text().length() > 0) {
              body = ne.text().replaceAll("(^\")|Source:\\s.+", "");
            }
            Elements img = doc.select("img[itemprop = image]");
            SendEmbed.send_image_with_hyperlink(name, line, body, img.attr("src"), commandEvent);
        }catch (NullPointerException e){
            SendEmbed.send_error_message("anime", "couldn't find anime \""+args+"\"!", commandEvent);
        }
        catch (Exception e) {
            SendEmbed.send_error_message("anime", "an error occurred :/", commandEvent);
            e.printStackTrace();
        }
    }
}
