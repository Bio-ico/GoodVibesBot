package com.bio.GoodVibes;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class PKMN extends Command {
    public PKMN (){
        this.name = "pkmn";
        this.help = "generates a random pokemon";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.bestrandoms.com/random-pokemon").get();
            //Element content = doc.getElementById("content");
            Elements links = doc.getElementsByClass("text-center font-18");
            String name = links.get((int)((System.currentTimeMillis() &0x00FF) % links.size())).text();

            String name2 = "https://play.pokemonshowdown.com/sprites/xyani/"+name.toLowerCase()+".gif";

            doc = Jsoup.connect("https://www.pokemon.com/us/pokedex/"+name.toLowerCase()).get();
            Elements link = doc.getElementsByClass("version-x");

            String hyperlink = "https://bulbapedia.bulbagarden.net/wiki/"+name+"_(Pokemon)";

            SendEmbed.send_image_with_hyperlink(name, hyperlink, link.first().text(), name2, commandEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
