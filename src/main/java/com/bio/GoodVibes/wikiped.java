package com.bio.GoodVibes;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class wikiped extends Command {
    public wikiped(){
        this.name = "wikiped";
        this.help = "Generates a wikipedia page. If given no name, will produce a random one.";
    }
    @Override
    protected void execute(CommandEvent commandEvent) {
        String args = commandEvent.getArgs().replaceAll(" ", "_");
        String page = (args.length() < 1)  ? "Special:Random":args;
        Document doc;
        try {
            doc = Jsoup.connect("https://en.wikipedia.org/wiki/"+page).get();
            System.out.println(doc.title());
            String link = doc.select("link[rel=canonical]").first().attr("href");
            Elements name = doc.getElementsByClass("firstHeading");
            Elements body = doc.select("p");
            if(body.text().contains("may refer to")) {
                String nextPage = doc.select("ul").first().getElementsByAttribute("href").first().attr("href");
                doc = Jsoup.connect("https://en.wikipedia.org/"+nextPage).get();
                link = doc.select("link[rel=canonical]").first().attr("href");
                name = doc.getElementsByClass("firstHeading");
                body = doc.select("p");
            }
            String des = body.text().replaceAll("\\[\\d\\]","");
            if (des.length() > 600){
                des = des.substring(0, 599);
                des = des.split("\\.(?=[^A-z0-9\\s.]*[^.]*$)")[0]+".";
                System.out.println(body.text());
            }
            if (des.length() < 1)
                throw new HttpStatusException("bad", 613, page);
            else
                SendEmbed.send_message_with_hyperLink(name.text(), link, des, commandEvent);
        } catch(HttpStatusException m){
            SendEmbed.send_error_message("wikiped", "couldn't find page \""+page+"\"!", commandEvent);
        }
        catch (Exception e) {
            SendEmbed.send_error_message("wikiped", "Some error occurred :/", commandEvent);
            e.printStackTrace();
        }
    }
}
