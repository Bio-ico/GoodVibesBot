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

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

public class HaGaon {
	public static void main(String[] arguments) throws Exception {
		EventWaiter waiter = new EventWaiter();
		CommandClientBuilder builder = new CommandClientBuilder();
		builder.setOwnerId("455504351872548885");

		Command[] book = {
				new Text(),
				new Tanakh(),
				new Talmud(),
				new Mishnah(),
				new PirkeiAvot(),
				new Tosefta(),
				new Rashi(),
				new About(),
				new JPS()
		};
		for (Command i : book)
			builder.addCommand(i);

		builder.setPrefix("--");
		CommandClient client = builder.build();
		Object[] EventListers = { waiter, client };
		new JDABuilder(AccountType.BOT)
				.setToken("")
				.setGame(Game.playing("loading..."))
				.addEventListener(EventListers)
				.buildAsync();

	}
}
