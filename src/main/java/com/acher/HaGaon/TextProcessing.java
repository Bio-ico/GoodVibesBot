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

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class TextProcessing {
	public static String fixText(String text) {
		text = text.replaceAll("(?i)<i[^>]*>", "");
		text = text.replaceAll("(?i)</i[^>]*>", "");
		text = text.replaceAll("(?i)<b[^>]*>", "");
		text = text.replaceAll("(?i)</b[^>]*>", "");
		text = text.replaceAll("(?i)<strong[^>]*>", "");
		text = text.replaceAll("(?i)</strong[^>]*>", "");
		text = text.replaceAll(" +", " ");
		return text;
	}



	public static String getVerse(String book, int chapter, int verse, int verseEnd, String sURL) throws IOException {
		book = book.replaceAll(" ", "_");
		String text = "";
		String sURLoriginal = sURL;
		for (int i = verse; i <= verseEnd; i++) {
			sURL = sURLoriginal;
			sURL += book + "." + chapter + "." + i + "?context=0";
			URL url = new URL(sURL);
			URLConnection request = url.openConnection();
			request.connect();
			JsonParser jp = new JsonParser();
			JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
			JsonObject rootobj = root.getAsJsonObject();
			if (text.length() + rootobj.get("text").getAsString().length() > 2048)
				break;
			text = text + rootobj.get("text").getAsString() + " ";
		}
		text = TextProcessing.fixText(text);
		return text;
	}

	public static String getVerse(String book, int chapter, int verse, String sURL) throws IOException {
		if (book.indexOf(' ') != 0) {
			book = book.replaceAll(" ", "_");
		}
		sURL = sURL + book + "." + chapter + "." + verse + "?context=0";
		URL url = new URL(sURL);
		URLConnection request = url.openConnection();
		request.connect();
		JsonParser jp = new JsonParser();
		JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
		JsonObject rootobj = root.getAsJsonObject();
		String text = rootobj.get("text").getAsString();
		text = TextProcessing.fixText(text);
		return text;
	}

	public static String getVerse(String book, int chapter, int verse, int verseEnd, String translation, String sURL)
			throws IOException {
		book = book.replaceAll(" ", "_");
		translation = translation.replaceAll(" ", "_");
		String text = "";
		String sURLoriginal = sURL;
		for (int i = verse; i <= verseEnd; i++) {
			sURL = sURLoriginal + book + "." + chapter + "." + i + "?context=0" + "&ven=" + translation;
			URL url = new URL(sURL);
			URLConnection request = url.openConnection();
			request.connect();
			JsonParser jp = new JsonParser();
			JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
			JsonObject rootobj = root.getAsJsonObject();
			if (text.length() + rootobj.get("text").getAsString().length() > 2048)
				break;
			text = text + rootobj.get("text").getAsString() + " ";
		}
		text = TextProcessing.fixText(text);
		return text;
	}

	public static String getVerse(String book, int chapter, int verse, String translation, String sURL)
			throws IOException {
		if (book.indexOf(' ') != 0) {
			book = book.replaceAll(" ", "_");
		}
		if (translation.indexOf(' ') != 0) {
			translation = translation.replaceAll(" ", "_");
		}
		sURL = sURL + book + "." + chapter + "." + verse + "?context=0" + "&ven=" + translation;
		URL url = new URL(sURL);
		URLConnection request = url.openConnection();
		request.connect();
		JsonParser jp = new JsonParser();
		JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
		JsonObject rootobj = root.getAsJsonObject();
		String text = rootobj.get("text").getAsString();
		text = TextProcessing.fixText(text);
		return text;
	}
}
