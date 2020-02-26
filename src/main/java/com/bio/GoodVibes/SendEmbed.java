package com.bio.GoodVibes;

import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;

import java.awt.*;

public class SendEmbed {
    public static void send_image_with_hyperlink(String name, String hyperlink, String body, String imgUrl, CommandEvent event) {
        String sURL = "https://cdn.discordapp.com/avatars/464181282583085056/5b8d2bae28e2e67779aaef217b9648b3.png?size=4096";
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        event.reply(new EmbedBuilder().setTitle(name, hyperlink).setImage(imgUrl).setDescription(body).setColor(Color.BLUE)
                .setFooter("Good Vibes Bot v0.1", sURL).build());
    }

    public static void sendImage(String name, String hyperlink, String body, String imgUrl, CommandEvent event) {
        String sURL = "https://cdn.discordapp.com/avatars/464181282583085056/5b8d2bae28e2e67779aaef217b9648b3.png?size=4096";
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        event.reply(new EmbedBuilder().setTitle(name, hyperlink).setImage(imgUrl).setDescription(body).setColor(Color.BLUE)
                .setFooter("Good Vibes Bot v0.1", sURL).build());
    }

    public static void send_message_with_hyperLink(String name, String hyperlink, String body, CommandEvent event){
        String sURL = "https://cdn.discordapp.com/avatars/464181282583085056/5b8d2bae28e2e67779aaef217b9648b3.png?size=4096";
        event.reply(new EmbedBuilder().setTitle(name, hyperlink).setDescription(body).setColor(Color.BLUE)
                .setFooter("Good Vibes Bot v0.1", sURL).build());
    }

    public static void sendUrl(String title, String body, CommandEvent event){
        String sURL = "https://cdn.discordapp.com/avatars/464181282583085056/5b8d2bae28e2e67779aaef217b9648b3.png?size=4096";
        event.reply(new EmbedBuilder().setTitle(title).setDescription(body).setColor(Color.BLUE)
                .setFooter("Good Vibes Bot v0.1", sURL).build());
    }
}
