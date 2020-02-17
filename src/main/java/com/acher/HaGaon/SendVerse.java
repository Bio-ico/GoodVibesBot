/*
 * Copyright (c) 2018 Daniel J. Kirsch
 * HaGaon HaMachane [https://github.com/djkirsch/HaGaonHaMachane]
 *
 * This file is part of HaGaon HaMachane.
 *
 * HaGaon HaMachane is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License
 * version 3 as published by the Free Software Foundation
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
*/
package com.acher.HaGaon;

import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;

import java.awt.*;

public class SendVerse {
	public static void sendEmbed(String name, String verseText, CommandEvent event) {
		String sURL = "https://cdn.discordapp.com/avatars/464181282583085056/5b8d2bae28e2e67779aaef217b9648b3.png?size=4096";
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		event.reply(new EmbedBuilder().setTitle(name).setDescription(verseText).setColor(Color.BLUE)
				.setFooter("Good Vibes Bot v0.1", sURL).build());
	}
}
