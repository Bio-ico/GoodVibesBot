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

import java.io.IOException;

public class Tanakh extends bookImpl {
	public Tanakh() {
		this.name = "tanakh";
		this.help = "Grabs a Tanakh verse from Sefaria's API";
	}

	public void run(CommandEvent event,  String args){
		String sURL = "https://www.sefaria.org/api/texts/";
		String book = args.substring(0,args.lastIndexOf(" "));
		String translation = "The Koren Jerusalem Bible";
		String verseText = "";
		int chapter = Integer.parseInt(args.substring(args.lastIndexOf(" ")+1,args.indexOf(':')));
		if(args.indexOf("-") == -1) {
			int line = Integer.parseInt(args.substring(args.indexOf(':')+1));
			try { verseText = TextProcessing.getVerse(book,chapter,line,translation,sURL); }
			catch (IOException e) {
				e.printStackTrace();
				SendVerse.sendEmbed("ERROR", "An Exception has occured! Try again in a minute!", event);
			}
		}
		else {
			int line = Integer.parseInt(args.substring(args.indexOf(':')+1, args.indexOf('-')));
			int lineEnd = Integer.parseInt(args.substring(args.indexOf('-')+1));
			try { verseText = TextProcessing.getVerse(book,chapter,line,lineEnd,translation,sURL); }
			catch (IOException e) {
				e.printStackTrace();
				SendVerse.sendEmbed("ERROR", "An Exception has occured! Try again in a minute!", event);
			}
		}
		SendVerse.sendEmbed(args, verseText, event);
	}

}
