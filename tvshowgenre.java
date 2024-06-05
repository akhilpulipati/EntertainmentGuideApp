package edu.dayton.entertainmentguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class tvshowgenre extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> groupTitles;
    private HashMap<String, List<String>> childItems;
    private HashMap<String, String> itemImages;
    private HashMap<String, String> itemContents;
    private HashMap<String, String> itemLinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvshowgenre);

        // Initialize data
        initData();

        // Set up the ExpandableListView
        expandableListView = findViewById(R.id.expandableListView);
        expandableListAdapter = new ExpandableListAdapter(this, groupTitles, childItems);
        expandableListView.setAdapter(expandableListAdapter);

        // Set click listener for the list items
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                // Retrieve the selected item's information
                String groupName = groupTitles.get(groupPosition);
                List<String> childList = childItems.get(groupName);
                if (childList != null && childPosition < childList.size()) {
                    String childName = childList.get(childPosition);
                    String imageName = itemImages.get(childName);
                    String content = itemContents.get(childName);
                    String link = itemLinks.get(childName);

                    // Pass the selected item's information to the next activity
                    Intent intent = new Intent(tvshowgenre.this, selectedentertainment.class);
                    intent.putExtra("itemName", childName);
                    intent.putExtra("imageName", imageName);
                    intent.putExtra("content", content);
                    intent.putExtra("link", link);
                    startActivity(intent);
                }

                return true;
            }
        });
    }

    private void initData() {
        // Initialize group titles
        groupTitles = new ArrayList<>();
        groupTitles.add("Action");
        groupTitles.add("Drama");
        groupTitles.add("Romance");
        groupTitles.add("Adventure");
        groupTitles.add("Anime");
        groupTitles.add("Fantasy");
        groupTitles.add("Mystery");
        groupTitles.add("Science Fiction");
        groupTitles.add("Thriller");
        groupTitles.add("Comedy");
        groupTitles.add("Crime");

        // Initialize child items
        childItems = new HashMap<>();
        addChildItems("Action", "One Piece","Game of Thrones","My Hero Academia","Gintama","Chuck","How a Realist Hero Rebuilt the Kingdom","Black Clover","Vincenzo","Halo","Reacher","Demon Slayer: Kimetsu no Yaiba","Shadow and Bone","Prison Break","The Wheel of Time","The Eminence in Shadow","Jujutsu Kaisen");
        addChildItems("Drama", "One Piece","Game of Thrones","Black Clover","My Hero Academia","Haikyuu!!","Invasion","Modern Family","The Walking Dead","Stranger Things","Outlander","The Summer I Turned Pretty","The Vampire Diaries","Sherlock","YOU","The Wheel of Time","Chuck","Breaking Bad","Reacher","Shadow and Bone", "Prison Break","Peaky Blinders","Dark","Lucifer","The Expanse");
        addChildItems("Romance", "Modern Family","The Big Bang Theory","YOU","The Summer I Turned Pretty","Friends","Outlander");
        addChildItems("Adventure", "Game of Thrones","Halo","Shadow and Bone","Demon Slayer: Kimetsu no Yaiba","Uncle From Another World","KonoSuba: God's Blessing on This Wonderful World!","The Wheel of Time","The Eminence in Shadow","Jujutsu Kaisen");
        addChildItems("Anime", "One Piece","Black Clover","Blue Lock","KonoSuba: God's Blessing on This Wonderful World!","Gintama","How a Realist Hero Rebuilt the Kingdom","Uncle From Another World","My Hero Academia","Haikyuu!!","The Eminence in Shadow","Jujutsu Kaisen","Demon Slayer: Kimetsu no Yaiba");
        addChildItems("Fantasy", "The Vampire Diaries","Lucifer","Outlander","Invasion","Stranger Things");
        addChildItems("Mystery", "Sherlock","Dark","The Expanse");
        addChildItems("Science Fiction", "Dark","Lost in Space","The Expanse","Halo","Invasion");
        addChildItems("Thriller", "Breaking Bad","Blue Lock","Stranger Things","Dark","The Walking Dead");
        addChildItems("Comedy", "Friends","Haikyuu!!","KonoSuba: God's Blessing on This Wonderful World!","Gintama","How a Realist Hero Rebuilt the Kingdom","The Big Bang Theory","Modern Family","Chuck","Uncle From Another World","Vincenzo");
        addChildItems("Crime", "Vincenzo","Sherlock","Reacher","Prison Break", "Peaky Blinders", "Dark","Lucifer","Breaking Bad","YOU");

        // Initialize item images
        itemImages = new HashMap<>();
        itemImages.put("Chuck", "chuck");
        itemImages.put("Reacher", "reacher");
        itemImages.put("Shadow and Bone", "sandb");
        itemImages.put("Prison Break", "pb");
        itemImages.put("Peaky Blinders", "peakyb");
        itemImages.put("Dark", "dark");
        itemImages.put("Lucifer", "lucifer");
        itemImages.put("Sherlock", "sherlock");
        itemImages.put("Breaking Bad", "bb");
        itemImages.put("The Wheel of Time", "wot");
        itemImages.put("YOU", "you");
        itemImages.put("The Vampire Diaries", "tvd");
        itemImages.put("Vincenzo", "vincenzo");
        itemImages.put("The Summer I Turned Pretty", "tsip");
        itemImages.put("Game of Thrones", "got");
        itemImages.put("Outlander", "outl");
        itemImages.put("Friends", "friends");
        itemImages.put("Modern Family", "mf");
        itemImages.put("The Big Bang Theory", "tbbt");
        itemImages.put("Lost in Space", "lis");
        itemImages.put("The Expanse", "te");
        itemImages.put("Halo", "halo");
        itemImages.put("Invasion", "inv");
        itemImages.put("Stranger Things", "tst");
        itemImages.put("The Walking Dead", "twd");
        itemImages.put("One Piece", "onepiece");
        itemImages.put("Black Clover", "bc");
        itemImages.put("My Hero Academia", "mha");
        itemImages.put("Blue Lock", "bl");
        itemImages.put("Haikyuu!!", "haikyu");
        itemImages.put("Uncle From Another World", "ufaw");
        itemImages.put("The Eminence in Shadow", "eis");
        itemImages.put("Gintama", "gintama");
        itemImages.put("Jujutsu Kaisen", "jjk");
        itemImages.put("Demon Slayer: Kimetsu no Yaiba", "demons");
        itemImages.put("How a Realist Hero Rebuilt the Kingdom", "hrb");
        itemImages.put("KonoSuba: God's Blessing on This Wonderful World!", "konosuba");

        // Initialize item contents
        itemContents = new HashMap<>();
        itemContents.put("Chuck", "When a computer geek inadvertently downloads critical government secrets into his brain, both the CIA and the NSA assign an agent to protect him and exploit his newfound skills.\n" +
                "\n" +
                "Creators\n" +
                "Chris FedakJosh Schwartz\n" +
                "Stars\n" +
                "Zachary Levi Yvonne Strahovski Joshua Gomez");
        itemContents.put("Reacher", "Jack Reacher was arrested for murder and now the police need his help. Based on the books by Lee Child.\n" +
                "\n" +
                "Creator\n" +
                "Nick Santora\n" +
                "Stars\n" +
                "Alan Ritchson Malcolm Goodwin Willa Fitzgerald");
        itemContents.put("Shadow and Bone", "Dark forces conspire against orphan mapmaker Alina Starkov when she unleashes an extraordinary power that could change the fate of her war-torn world.\n" +
                "\n" +
                "Creator\n" +
                "Eric Heisserer\n" +
                "Stars\n" +
                "Jessie Mei Li Ben Barnes Archie Renaux");
        itemContents.put("Prison Break", "A structural engineer installs himself in a prison he helped design, in order to save his falsely accused brother from a death sentence by breaking themselves out from the inside.\n" +
                "\n" +
                "Creator\n" +
                "Paul T. Scheuring\n" +
                "Stars\n" +
                "Dominic Purcell Wentworth Miller Amaury Nolasco");
        itemContents.put("Peaky Blinders", "A gangster family epic set in 1900s England, centering on a gang who sew razor blades in the peaks of their caps, and their fierce boss Tommy Shelby.\n" +
                "\n" +
                "Creator\n" +
                "Steven Knight\n" +
                "Stars\n" +
                "Cillian Murphy Paul Anderson Sophie Rundle");
        itemContents.put("Dark", "A family saga with a supernatural twist, set in a German town where the disappearance of two young children exposes the relationships among four families.\n" +
                "\n" +
                "Creators\n" +
                "Baran bo OdarJantje Friese\n" +
                "Stars\n" +
                "Louis Hofmann Karoline Eichhorn Lisa Vicari");
        itemContents.put("Lucifer", "Lucifer Morningstar has decided he's had enough of being the dutiful servant in Hell and decides to spend some time on Earth to better understand humanity. He settles in Los Angeles - the City of Angels.\n" +
                "\n" +
                "Creator\n" +
                "Tom Kapinos\n" +
                "Stars\n" +
                "Tom Ellis Lauren German Kevin Alejandro");
        itemContents.put("Sherlock", "The quirky spin on Conan Doyle's iconic sleuth pitches him as a \"high-functioning sociopath\" in modern-day London. Assisting him in his investigations: Afghanistan War vet John Watson, who's introduced to Holmes by a mutual acquaintance.\n" +
                "\n" +
                "Creators\n" +
                "Mark GatissSteven Moffat\n" +
                "Stars\n" +
                "Benedict Cumberbatch Martin Freeman Una Stubbs");
        itemContents.put("Breaking Bad", "A chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine with a former student in order to secure his family's future.\n" +
                "\n" +
                "Creator\n" +
                "Vince Gilligan\n" +
                "Stars\n" +
                "Bryan Cranston Aaron Paul Anna Gunn");
        itemContents.put("The Wheel of Time","Set in a high fantasy world where magic exists, but only some can access it, a woman named Moiraine crosses paths with five young men and women. This sparks a dangerous, world-spanning journey. Based on the book series by Robert Jordan.\n" +
                "\n" +
                "Creator\n" +
                "Rafe Judkins\n" +
                "Stars\n" +
                "Rosamund Pike Daniel Henney Madeleine Madden\n");
        itemContents.put("YOU", "A dangerously charming, intensely obsessive young man goes to extreme measures to insert himself into the lives of those he is transfixed by.\n" +
                "\n" +
                "Creators\n" +
                "Greg BerlantiSera Gamble\n" +
                "Stars\n" +
                "Penn Badgley Victoria Pedretti Tati Gabrielle");
        itemContents.put("The Vampire Diaries", "The lives, loves, dangers and disasters in the town, Mystic Falls, Virginia. Creatures of unspeakable horror lurk beneath this town as a teenage girl is suddenly torn between two vampire brothers.\n" +
                "\n" +
                "Creators\n" +
                "Julie PlecKevin Williamson\n" +
                "Stars\n" +
                "Nina Dobrev Paul Wesley Ian Somerhalder");
        itemContents.put("Vincenzo", "During a visit to his motherland, a Korean-Italian mafia lawyer gives an unrivaled conglomerate a taste of its own medicine with a side of justice.\n" +
                "\n" +
                "Stars\n" +
                "Song Joong-ki Jeon Yeo-been Taecyeon");
        itemContents.put("The Summer I Turned Pretty", "A love triangle between one girl and two brothers. A story about first love, first heartbreak, and the magic of that one perfect summer.\n" +
                "\n" +
                "Creator\n" +
                "Jenny Han\n" +
                "Stars\n" +
                "Lola Tung Christopher Briney Gavin Casalegno\n");
        itemContents.put("Game of Thrones", "Nine noble families fight for control over the lands of Westeros, while an ancient enemy returns after being dormant for a millennia.\n" +
                "\n" +
                "Creators\n" +
                "David BenioffD.B. Weiss\n" +
                "Stars\n" +
                "Emilia Clarke Peter Dinklage Kit Harington");
        itemContents.put("Outlander", "Claire Beauchamp Randall, a nurse in World War II, mysteriously goes back in time to Scotland in 1743. There, she meets a dashing Highland warrior and gets drawn into an epic rebellion.\n" +
                "\n" +
                "Creator\n" +
                "Ronald D. Moore\n" +
                "Stars\n" +
                "Caitríona Balfe Sam Heughan Sophie Skelton");
        itemContents.put("Friends","Follows the personal and professional lives of six twenty to thirty year-old friends living in the Manhattan borough of New York City.\n" +
                "\n" +
                "Creators\n" +
                "David CraneMarta Kauffman\n" +
                "Stars\n" +
                "Jennifer Aniston Courteney Cox Lisa Kudrow\n");
        itemContents.put("Modern Family", "Three different but related families face trials and tribulations in their own uniquely comedic ways.\n" +
                "\n" +
                "Creators\n" +
                "Steven LevitanChristopher Lloyd\n" +
                "Stars\n" +
                "Ed O'Neill Sofía Vergara Julie Bowen");
        itemContents.put("The Big Bang Theory", "A woman who moves into an apartment across the hall from two brilliant but socially awkward physicists shows them how little they know about life outside of the laboratory.\n" +
                "\n" +
                "Creators\n" +
                "Chuck LorreBill Prady\n" +
                "Stars\n" +
                "Johnny Galecki Jim Parsons Kaley Cuoco\n");
        itemContents.put("Lost in Space", "After crash-landing on an alien planet, the Robinson family fight against all odds to survive and escape, but they're surrounded by hidden dangers.\n" +
                "\n" +
                "Creators\n" +
                "Irwin AllenMatt SazamaBurk Sharpless\n" +
                "Stars\n" +
                "Toby Stephens Molly Parker Maxwell Jenkins");
        itemContents.put("The Expanse", "The disappearance of rich-girl-turned-political-activist links the lives of Ceres detective, accidental ship captain and U.N. politician. Amidst political tension between Earth, Mars and the Belt, they unravel the greatest conspiracy.\n" +
                "\n" +
                "Creators\n" +
                "Daniel AbrahamMark FergusTy Franck\n" +
                "Stars\n" +
                "Steven Strait Dominique Tipper Wes Chatham");
        itemContents.put("Halo", "Aliens threaten human existence in an epic 26th-century showdown.\n" +
                "\n" +
                "Creators\n" +
                "Steven KaneKyle Killen\n" +
                "Stars\n" +
                "Pablo Schreiber Shabana Azmi Natasha Culzac");
        itemContents.put("Invasion", "Earth is visited by an alien species that threatens humanity's existence. Events unfold in real time through the eyes of five ordinary people across the globe as they struggle to make sense of the chaos unraveling around them.\n" +
                "\n" +
                "Creators\n" +
                "Simon KinbergDavid Weil\n" +
                "Stars\n" +
                "Golshifteh Farahani Shamier Anderson Shioli Kutsuna");
        itemContents.put("Stranger Things", "When a young boy disappears, his mother, a police chief and his friends must confront terrifying supernatural forces in order to get him back.\n" +
                "\n" +
                "Stars\n" +
                "Millie Bobby Brown Finn Wolfhard Winona Ryder\n");
        itemContents.put("The Walking Dead", "Sheriff Deputy Rick Grimes wakes up from a coma to learn the world is in ruins and must lead a group of survivors to stay alive.\n" +
                "\n" +
                "Creator\n" +
                "Frank Darabont\n" +
                "Stars\n" +
                "Andrew Lincoln Norman Reedus Melissa McBride");
        itemContents.put("One Piece", "Follows the adventures of Monkey D. Luffy and his pirate crew in order to find the greatest treasure ever left by the legendary Pirate, Gold Roger. The famous mystery treasure named \"One Piece\".\n" +
                "\n" +
                "Creator\n" +
                "Eiichirô Oda\n" +
                "Stars\n" +
                "Mayumi Tanaka Laurent Vernin Tony Beck");
        itemContents.put("Black Clover", "Asta and Yuno were abandoned together at the same church and have been inseparable since. As children, they promised that they would compete against each other to see who would become the next Emperor Magus.\n" +
                "\n" +
                "Stars\n" +
                "Dallas Reid Jill Harris Cris George");
        itemContents.put("My Hero Academia", "A superhero-admiring boy without any powers enrolls in a prestigious hero academy and learns what it really means to be a hero.\n" +
                "\n" +
                "Stars\n" +
                "Daiki Yamashita Justin Briner Nobuhiko Okamoto");
        itemContents.put("Blue Lock", "High school soccer players from across Japan gather for a controversial project designed to create the best and most egoistic striker in the world.\n" +
                "\n" +
                "Stars\n" +
                "Ricco Fajardo Aaron Dismuke Drew Breedlove");
        itemContents.put("Haikyuu!!", "Determined to be like the volleyball championship's star player nicknamed \"the small giant\", Shoyo joins his school's volleyball club.\n" +
                "\n" +
                "Creator\n" +
                "Haruichi Furudate\n" +
                "Stars\n" +
                "Ayumu Murase Kaito Ishikawa Yu Hayashi");
        itemContents.put("Uncle From Another World", "Takafumi's uncle wakes after a 17-year coma. He had actually gone to another world, and has returned with magical powers. But now that he's back, Takafumi must help him to survive in his home world.\n" +
                "\n" +
                "Stars\n" +
                "Takehito Koyasu Victoria Grace Feodor Chin\n");
        itemContents.put("The Eminence in Shadow", "Cid Kagenou creates an elaborate plot to fight the Cult of Diabolos and builds his organization, the Shadow Garden.\n" +
                "\n" +
                "Stars\n" +
                "Seiichiro Yamashita Kana Hanazawa Haruka Shiraishi");
        itemContents.put("Gintama", "In an era where aliens have invaded and taken over feudal Tokyo, an unemployed samurai finds work however he can.\n" +
                "\n" +
                "Stars\n" +
                "Tomokazu Sugita Daisuke Sakaguchi Rie Kugimiya");
        itemContents.put("Jujutsu Kaisen", "A boy swallows a cursed talisman - the finger of a demon - and becomes cursed himself. He enters a shaman's school to be able to locate the demon's other body parts and thus exorcise himself.\n" +
                "\n" +
                "Stars\n" +
                "Junya Enoki Adam McArthur Yûichi Nakamura");
        itemContents.put("Demon Slayer: Kimetsu no Yaiba", "A family is attacked by demons and only two members survive - Tanjiro and his sister Nezuko, who is turning into a demon slowly. Tanjiro sets out to become a demon slayer to avenge his family and cure his sister.\n" +
                "\n" +
                "Stars\n" +
                "Natsuki Hanae Zach Aguilar Abby Trott");
        itemContents.put("How a Realist Hero Rebuilt the Kingdom", "O, Hero! When Kazuya Souma is unexpectedly transported to another world, he knows the people expect a hero. But Souma's idea of heroism is more practical than most, he wants to rebuild the flagging economy of the new land he's found himself in! Betrothed to the princess and abruptly planted on the throne, this realist hero must gather talented people to help him  get the country back on its feet--not through war, or adventure, but with administrative reform.\n" +
                "\n" +
                "Stars\n" +
                "Yûsuke Kobayashi Inori Minase Show Hayami");
        itemContents.put("KonoSuba: God's Blessing on This Wonderful World!", "It was a happy day for Kazuma - right up to the moment he died. A goddess intervenes and offers him a second chance in a magical land.\n" +
                "\n" +
                "Stars\n" +
                "Jun Fukushima Sora Amamiya Noucky Andriansyah");



        // Initialize item links
        itemLinks = new HashMap<>();
        itemLinks.put("Chuck", "https://www.primevideo.com/detail/0M6KM2KMOZIILT6N2KU6WQGI27/ref=atv_dp_share_cu_r");
        itemLinks.put("Reacher", "https://www.primevideo.com/detail/0RTZ57DQ6PBHH29UN5JS7U7CW4/ref=atv_dp_share_cu_r");
        itemLinks.put("Shadow and Bone", "https://www.netflix.com/in/title/80236319?source=35");
        itemLinks.put("Prison Break", "https://www.hotstar.com/in/shows/prison-break/8536");
        itemLinks.put("Peaky Blinders", "https://netflix.com/in/title/80002479?source=35");
        itemLinks.put("Dark", "https://www.netflix.com/in/title/80100172");
        itemLinks.put("Lucifer", "https://www.netflix.com/in/title/80057918");
        itemLinks.put("Sherlock", "https://www.primevideo.com/detail/0Q18NAAMP9UE0PPFAHTTUE2XOL/ref=atv_dp_share_cu_r");
        itemLinks.put("Breaking Bad", "https://www.netflix.com/in/title/70143836?source=35");
        itemLinks.put("The Wheel of Time","https://www.primevideo.com/detail/0U3073DE9J38JXZ5WLZW5O8MH3/ref=atv_dp_share_cu_r");
        itemLinks.put("YOU", "https://www.netflix.com/in/title/80211991");
        itemLinks.put("The Vampire Diaries", "https://www.primevideo.com/detail/0I1CFAR5K3VLBJ5O1T75O8RJX0/ref=atv_dp_share_cu_r");
        itemLinks.put("Vincenzo", "https://www.netflix.com/in/title/81365087?source=35");
        itemLinks.put("The Summer I Turned Pretty", "https://www.primevideo.com/detail/0ITVI13B4SST8NI37QK4HLVXNL/ref=atv_dp_share_cu_r");
        itemLinks.put("Game of Thrones", "https://www.hbo.com/game-of-thrones");
        itemLinks.put("Outlander", "https://www.netflix.com/in/title/70285581?source=35");
        itemLinks.put("Friends", "https://www.netflix.com/in/title/70153404?source=35");
        itemLinks.put("Modern Family", "https://www.hulu.com/series/modern-family-883c414c-34a3-4fcc-b50a-0ad5a184c977");
        itemLinks.put("The Big Bang Theory", "https://www.netflix.com/in/title/70143830?source=35");
        itemLinks.put("Lost in Space", "https://www.netflix.com/in/title/80104198");
        itemLinks.put("The Expanse", "https://www.primevideo.com/detail/0PWWY8BZB8COGDELCHYLRXOCR5/ref=atv_dp_share_cu_r");
        itemLinks.put("Halo", "https://jiocinema.onelink.me/fRhd/92gidj72");
        itemLinks.put("Invasion", "https://tv.apple.com/in/episode/last-day/umc.cmc.bmtv5n93jgkx5sa30ylzlubm?action=playSmartEpisode");
        itemLinks.put("Stranger Things", "https://www.netflix.com/in/title/80057281");
        itemLinks.put("The Walking Dead", "https://www.netflix.com/in/title/70177057");
        itemLinks.put("One Piece", "https://aniwatch.to/one-piece-100");
        itemLinks.put("Black Clover", "https://www.crunchyroll.com/series/GRE50KV36/black-clover");
        itemLinks.put("My Hero Academia", "https://aniwatch.to/my-hero-academia-322?ref=search");
        itemLinks.put("Blue Lock", "https://aniwatch.to/blue-lock-17889?ref=search");
        itemLinks.put("Haikyuu!!", "https://www.netflix.com/in/title/80090673?source=35");
        itemLinks.put("Uncle From Another World","https://www.netflix.com/in/title/81499847");
        itemLinks.put("The Eminence in Shadow", "https://aniwatch.to/the-eminence-in-shadow-17473?ref=search");
        itemLinks.put("Gintama", "https://aniwatch.to/gintama-13?ref=search");
        itemLinks.put("Jujutsu Kaisen", "https://aniwatch.to/jujutsu-kaisen-tv-534");
        itemLinks.put("Demon Slayer: Kimetsu no Yaiba", "https://aniwatch.to/demon-slayer-kimetsu-no-yaiba-47?ref=search");
        itemLinks.put("How a Realist Hero Rebuilt the Kingdom", "https://aniwatch.to/how-a-realist-hero-rebuilt-the-kingdom-15711");
        itemLinks.put("KonoSuba: God's Blessing on This Wonderful World!", "https://example.com/link12");


    }

    private void addChildItems(String groupTitle, String... items) {
        List<String> childList = new ArrayList<>();
        for (String item : items) {
            childList.add(item);
        }
        childItems.put(groupTitle, childList);
    }
}
