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

import java.io.IOException;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class PikeriAvot extends Command {
	public PikeriAvot() {
		this.name = "PirkeiAvot";
		this.help = "Grabs a Pikeri Avot verse from Sefaria's API";
	}
	protected void execute(CommandEvent event) {
		String args = event.getArgs();
		String sURL = "https://www.sefaria.org/api/texts/";
		String book = "Pirkei_Avot";
		String verseText = "";
		int chapter = Integer.parseInt(args.substring(args.lastIndexOf(" ")+1,args.indexOf(':')));
		if(args.indexOf("-") == -1) {
			int line = Integer.parseInt(args.substring(args.indexOf(':')+1));
			try { verseText = TextProcessing.getVerse(book,chapter,line,sURL); }
			catch (IOException e) { 
				e.printStackTrace(); 
				SendVerse.sendEmbed("ERROR", "An Exception has occured! Try again in a minute!", event);
			} 
		}
		else {
			int line = Integer.parseInt(args.substring(args.indexOf(':')+1, args.indexOf('-')));
			int lineEnd = Integer.parseInt(args.substring(args.indexOf('-')+1));
			try { verseText = TextProcessing.getVerse(book,chapter,line,lineEnd,sURL); }
			catch (IOException e) { 
				e.printStackTrace(); 
				SendVerse.sendEmbed("ERROR", "An Exception has occured! Try again in a minute!", event);
			}
		}
		SendVerse.sendEmbed(args, verseText, event); 
	}
	
}
