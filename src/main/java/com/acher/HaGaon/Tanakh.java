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

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Tanakh extends bookImpl {
	public Tanakh() {
		this.name = "tanakh";
		this.help = "Grabs a Tanakh verse from Sefaria's API";
	}

	public String[] run(String args){
		String sURL = "https://www.sefaria.org/api/texts/";
		//                           (book)   (chap):(line)(-lineEnd)
        Pattern r = Pattern.compile("(\\S+)\\s(\\d+):(\\d+)(-\\d+)*");
        Matcher m = r.matcher(args);
        if (!m.find()){return new String[]{"error.","if you're seeing this, something's wrong."};}
        String book = m.group(1);
        int chapter = Integer.parseInt(m.group(2));
        int line    = Integer.parseInt(m.group(3));
        String translation = "The Koren Jerusalem Bible";
        String verseText;
        try {
            if (m.group(4) == null)
                verseText = TextProcessing.getVerse(book, chapter, line, translation, sURL);
            else {
                int lineEnd = Integer.parseInt(m.group(4).substring(1));
                verseText = TextProcessing.getVerse(book, chapter, line, lineEnd, translation, sURL);
            }
            return new String[]{args,verseText};
        }
        catch (Exception e) {
            e.printStackTrace();
            return new String[]{"error.","if you're seeing this, something's wrong:\n"+e.toString()};
        }
    }
}