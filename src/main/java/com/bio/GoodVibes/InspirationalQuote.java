package com.bio.GoodVibes;

import com.acher.HaGaon.SendVerse;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.util.ArrayList;
import java.util.Arrays;

public class InspirationalQuote extends Command {
    public InspirationalQuote(){
        this.name = "IQ";
        this.help = "gets inspirational quote";
    }

    @Override
    protected void execute(CommandEvent event) {
        String args = event.getArgs();
        int v = ((v = (int) System.currentTimeMillis()% quotes.size()) < 0) ? -v:v;
        System.out.println(v);
        SendVerse.sendEmbed("here's a random quote from a list we have", quotes.get(v), event);
    }

    private static ArrayList<String> quotes = new ArrayList<>(Arrays.asList(
            "May the wind under your wings bear you where the sun sails and the moon walks. |  J.R.R. Tolkien",
            "Where there's life there's hope. |  J.R.R. Tolkien",
            "Do or do not, there is no try |  Yoda",
            "Age does not protect you from love. But love, to some extent, protects you from age. |  Anais Nin",
            "It takes a great deal of courage to stand up to your enemies, but even more to stand up to your friends |  JK Rowling",
            "Always be a first-rate version of yourself, instead of a second-rate version of somebody else. |  Judy Garland",
            "The most courageous act is still to think for yourself. Aloud |  Coco Chanel",
            "I must not fear. Fear is the mind-killer. Fear is the little-death that brings total obliteration. |  Dune",
            "You don’t just give up. You don’t just let things happen. You make a stand! You say no! You have the guts to do what’s right, even when everyone else just runs away |  Rose Tyler(Doctor Who)",
            "Sometimes you gotta run before you can walk. |  Tony Stark (Iron Man)",
            "Never ignore a coincidence. Unless you’re busy. In which case, always a ignore coincidence. |  The Doctor (Doctor Who)",
            "If we're going to be damned, let's be damned for what we really are. |  Jean Luc Picard (Star Trek)",
            "Don't panic! |  The Hitchhiker's Guide to The Galaxy",
            "It is our choices, Harry, that show what we truly are, far more than our abilities. |  Harry Potter and the Chamber of Secrets",
            "We’ve all got both light and dark inside us. What matters is the part we choose to act on. That’s who we really are. |  Harry Potter and the Order of the Phoenix",
            "It matters not what someone is born, but what they grow to be. |  Harry Potter and the Goblet of Fire",
            "Things we lose have a way of coming back to us in the end, if not always in the way we expect. |  Harry Potter and the Order of the Phoenix",
            "Life shrinks or expands in proportion to one’s courage. |  Anais Nin",
            "Traveling – it leaves you speechless, then turns you into a storyteller. |  Ibn Battuta",
            "We travel, some of us forever, to seek other places, other lives, other souls. |  Anais Nin",
            "A journey is best measured in friends, rather than miles. |  Tim Cahill",
            "The gladdest moment in human life, me thinks, is a departure into unknown lands. |  Sir Richard Burton",
            "No place is ever as bad as they tell you it’s going to be. |  Chuck Thompson",
            "I am not the same, having seen the moon shine on the other side of the world. |  Mary Anne Radmacher",
            "Travel makes one modest. You see what a tiny place you occupy in the world. |  Gustave Flaubert",
            "We travel not to escape life, but for life not to escape us. |  Anonymous",
            "The man who goes alone can start today; but he who travels with another must wait till that other is ready. |  Henry David Thoreau",
            "To awaken alone in a strange town is one of the pleasantest sensations in the world. |  Freya Stark",
            "The life you have led doesn’t need to be the only life you have. |  Anna Quindlen",
            "Broad, wholesome, charitable views of men and things cannot be acquired by vegetating in one little corner of the earth all of one’s lifetime. |  Mark Twain",
            "Man cannot discover new oceans unless he has the courage to lose sight of the shore. |  Andre Gide",
            "The use of traveling is to regulate imagination with reality, and instead of thinking of how things may be, see them as they are. |  Samuel Johnson",
            "The most courageous act is still to think for yourself. Aloud |  Coco Chanel",
            "Twenty years from now you will be more disappointed by the things you didn’t do than by the ones you did do. |  Mark Twain",
            "Once a year, go someplace you’ve never been before. |  Anonymous",
            "Travel is the only thing you buy that makes you richer. |  Anonymous",
            "To travel is to discover that everyone is wrong about other countries. |  Aldous Huxley",
            "Stuff your eyes with wonder, live as if you’d drop dead in ten seconds. See the world. It’s more fantastic than any dream made or paid for in factories. |  Ray Bradbury",
            "Traveling tends to magnify all human emotions. |  Peter Hoeg",
            "If you reject the food, ignore the customs, fear the religion and avoid the people, you might better stay at home. |  James Michener",
            "People don’t take trips, trips take people. |  John Steinbeck",
            "When overseas you learn more about your own country, than you do the place you’re visiting. |  Clint Borgen",
            "To my mind, the greatest reward and luxury of travel is to be able to experience everyday things as if for the first time, to be in a position in which almost nothing is so familiar it is taken for granted. |  Bill Bryson",
            "Life is either a daring adventure or nothing. |  Helen Keller",
            "Our happiest moments as tourists always seem to come when we stumble upon one thing while in pursuit of something else. |  Lawrence Block",
            "Stop worrying about the potholes in the road and enjoy the journey. |  Babs Hoffman",
            "He who would travel happily must travel light. |  Antoine de St. Exupery",
            "Every man can transform the world from one of monotony and drabness to one of excitement and adventure. |  Irving Wallace",
            "The more I traveled the more I realized that fear makes strangers of people who should be friends. |  Shirley MacLaine",
            "I travel a lot; I hate having my life disrupted by routine. |  Caskie Stinnett",
            "A mind that is stretched by a new experience can never go back to its old dimensions. |  Oliver Wendell Holmes",
            "Remember that happiness is a way of travel – not a destination. |  Roy M. Goodman",
            "Life begins at the end of your comfort zone. |  Neale Donald Walsch",
            "Once in a while it really hits people that they don’t have to experience the world in the way they have been told to. |  Alan Keightley",
            "Nobody can discover the world for somebody else. Only when we discover it for ourselves does it become common ground and a common bond and we cease to be alone. |  Wendell Berry",
            "Take only memories, leave only footprints. |  Chief Seattle",
            "Two roads diverged in a wood and I – I took the one less traveled by. |  Robert Frost",
            "There is no moment of delight in any pilgrimage like the beginning of it. |  Charles Dudley Warner",
            "It is not down in any map; true places never are. |  Herman Melville",
            "Investment in travel is an investment in yourself. |  Matthew Karsten",
            "When all think alike, then no one is thinking |  Walter Lippman",
            "Great is the human who has not lost his childlike heart |  Mencius",
            "There's a way to do it better—find it |  Thomas Edison",
            "The essential part of creativity is not being afraid to fail. |  Edwin H. Land",
            "Creative activity could be described as a type of learning process where teacher and pupil are located in the same individual. | Arthur Koestler",
            "A ship in harbor is safe, but that is not what ships are built for |  John A. Shedd",
            "Ideas are easy. Implementation is hard. |  Guy Kawasaki",
            "Never give in–never, never, never, never, in nothing great or small, large or petty, never give in except to convictions of honour and good sense. Never yield to force; never yield to the apparently overwhelming might of the enemy. |  Winston Churchill",
            "The secret to successful hiring is this: look for the people who want to change the world. |  Marc Benioff",
            "The price of success is hard work, dedication to the job at hand, and the determination that whether we win or lose, we have applied the best of ourselves to the task at hand. |  Vince Lombardi",
            "When everything seems to be going against you, remember that the airplane takes off against the wind, not with it. |  Henry Ford",
            "Always deliver more than expected. |  Larry Page",
            "You shouldn't focus on why you can’t do something, which is what most people do. You should focus on why perhaps you can, and be one of the exceptions. |  Steve Case",
            "A person who never made a mistake never tried anything new. |  Albert Einstein",
            "Risk more than others think is safe. Dream more than others think is practical. |  Howard Schultz",
            "I'm convinced that about half of what separates the successful entrepreneurs from the non-successful ones is pure perseverance. |  Steve Jobs",
            "The way to get started is to quit talking and begin doing. |  Walt Disney",
            "Do not be embarrassed by your failures, learn from them and start again. |  Richard Branson",
            "It does not matter how slowly you go as long as you do not stop. |  Confucius",
            "It's hard to beat a person who never gives up. |  Babe Ruth",
            "Fail often so you can succeed sooner. |  Tom Kelley",
            "You may be disappointed if you fail, but you are doomed if you don't try. |  Beverly Sills",
            "When you cease to dream you cease to live |  Malcolm Forbes",
            "I have not failed. I've just found 10,000 ways that won't work. |  Thomas Edison",
            "Success is how high you bounce after you hit bottom. |  General George Patton",
            "Positive thinking will let you do everything better than negative thinking will. |  Zig Ziglar",
            "Every mountain top is within reach if you just keep climbing. |  Barry Finlay",
            "How glorious a greeting the sun gives the mountains! |  John Muir",
            "If you don't think every day is a good day, just try missing one. |  Cavett Robert",
            "Failure will never overtake me if my determination to succeed is strong enough. |  Og Mandino",
            "The most courageous act is still to think for yourself. Aloud |  Coco Chanel",
            "Don’t ask yourself what the world needs, ask yourself what makes you come alive. And then go and do that. Because what the world needs is people who are alive. |  Howard Thurman",
            "The ships hung in the sky, much the way that bricks don't | The Hitchhikers Guide To The Galaxy"
    ));
}
