package com.acher.HaGaon;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public abstract class bookImpl extends Command {
    protected void execute(CommandEvent commandEvent) {
        String[] r = run(commandEvent.getArgs());
        SendVerse.sendEmbed(r[0],r[1],commandEvent);
    }

    protected String[] run(String args){
        return new String[]{"generic command","if you're seeing this, something's wrong."};
    }

}
