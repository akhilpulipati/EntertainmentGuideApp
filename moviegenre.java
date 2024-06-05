package edu.dayton.entertainmentguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class moviegenre extends AppCompatActivity {

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
        setContentView(R.layout.activity_moviegenre);

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
                    Intent intent = new Intent(moviegenre.this, selectedentertainment.class);
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

        // Initialize child items
        childItems = new HashMap<>();
        addChildItems("Action", "RRR","Geostorm","The Batman","Brahmāstra: Part One – Shiva","Tenet","Everything Everywhere All at Once", "Ghosted","Sita Ramam", "Pathaan","Dune","Dungeons & Dragons: Honour Among Thieves", "Bahubali 2","K.G.F: Chapter 2","Top Gun: Maverick","John Wick: Chapter 4","Avatar: The Way of Water","HIT: The Second Case","Dasara","Guardians of the Galaxy Vol. 3");
        addChildItems("Drama", "Sita Ramam","RRR", "The Martian","The Batman","Fifty Shades of Grey","Top Gun: Maverick", "Bahubali 2", "Dune","Twilight","K.G.F: Chapter 2","My Fault","HIT: The Second Case","Dasara","After","Interstellar");
        addChildItems("Romance", "My Fault", "After", "Fifty Shades of Grey", "La La Land", "Twilight");
        addChildItems("Adventure", "The Martian","Fantastic Beasts: The Secrets of Dumbledore","Brahmāstra: Part One – Shiva","Everything Everywhere All at Once","Ghosted", "Pathaan", "Dasara", "Dune","Avatar: The Way of Water","The Batman","Dungeons & Dragons: Honour Among Thieves","Guardians of the Galaxy Vol. 3","Interstellar");
        addChildItems("Anime", "Suzume", "A Silent Voice", "Weathering with You", "Akira","Your Name.","Spirited Away");
        addChildItems("Fantasy", "Twilight", "Brahmāstra: Part One – Shiva", "Fantastic Beasts: The Secrets of Dumbledore","Dungeons & Dragons: Honour Among Thieves","Avatar: The Way of Water");
        addChildItems("Mystery", "Sita Ramam", "Virupaksha", "The Pale Blue Eye", "Death on the Nile");
        addChildItems("Science Fiction", "The Tomorrow War", "Tenet", "Geostorm", "The Martian","Interstellar");
        addChildItems("Thriller", "Tenet","Pathaan", "John Wick: Chapter 4", "Geostorm","Fifty Shades of Grey");
        addChildItems("Comedy", "Ghosted", "La La Land", "Everything Everywhere All at Once","Dungeons & Dragons: Honour Among Thieves","Guardians of the Galaxy Vol. 3");

        // Initialize item images
        itemImages = new HashMap<>();
        itemImages.put("RRR", "rrr");
        itemImages.put("Ghosted", "ghosted");
        itemImages.put("Pathaan", "pathaan");
        itemImages.put("Bahubali 2", "bahubali2");
        itemImages.put("K.G.F: Chapter 2", "kgf2");
        itemImages.put("Top Gun: Maverick", "topgun");
        itemImages.put("John Wick: Chapter 4", "johnwick4");
        itemImages.put("Avatar: The Way of Water", "avatar2");
        itemImages.put("My Fault", "myfault");
        itemImages.put("HIT: The Second Case", "hit2");
        itemImages.put("Dasara", "dasara");
        itemImages.put("After", "after");
        itemImages.put("Sita Ramam", "sitaramam");
        itemImages.put("Fifty Shades of Grey", "ffs");
        itemImages.put("La La Land", "lalaland");
        itemImages.put("Twilight", "twilight");
        itemImages.put("The Batman", "batman");
        itemImages.put("Everything Everywhere All at Once", "everything");
        itemImages.put("Dune", "dune");
        itemImages.put("Guardians of the Galaxy Vol. 3", "gotg3");
        itemImages.put("Dungeons & Dragons: Honour Among Thieves", "dandd");
        itemImages.put("Suzume", "suzume");
        itemImages.put("A Silent Voice", "asv");
        itemImages.put("Weathering with You", "wwy");
        itemImages.put("Akira", "akira");
        itemImages.put("Spirited Away", "sa");
        itemImages.put("Your Name.", "yourname");
        itemImages.put("Fantastic Beasts: The Secrets of Dumbledore", "fb");
        itemImages.put("Brahmāstra: Part One – Shiva", "brahmastra");
        itemImages.put("Virupaksha", "virupaksha");
        itemImages.put("The Pale Blue Eye", "pbe");
        itemImages.put("Death on the Nile", "don");
        itemImages.put("The Tomorrow War", "ttw");
        itemImages.put("Tenet", "tenet");
        itemImages.put("Geostorm", "geostorm");
        itemImages.put("The Martian", "tm");
        itemImages.put("Interstellar", "interstellar");


        // Initialize item contents
        itemContents = new HashMap<>();
        itemContents.put("RRR", "A fictitious story about two legendary revolutionaries and their journey away from home before they started fighting for their country in the 1920s.\n" +
                "\n" +
                "Director\n" +
                "S.S. Rajamouli\n" +
                "Writers\n" +
                "Vijayendra PrasadS.S. RajamouliSai Madhav Burra\n" +
                "Stars\n" +
                "N.T. Rama Rao Jr. Ram Charan Ajay Devgn");
        itemContents.put("Ghosted", "Cole falls head over heels for enigmatic Sadie, but then makes the shocking discovery that she's a secret agent. Before they can decide on a second date, Cole and Sadie are swept away on an international adventure to save the world.\n" +
                "\n" +
                "Director\n" +
                "Dexter Fletcher\n" +
                "Writers\n" +
                "Rhett ReesePaul Wernick Chris McKenna\n" +
                "Stars\n" +
                "Chris Evans Ana de Armas Adrien Brody");
        itemContents.put("Pathaan", "An Indian agent races against a doomsday clock as a ruthless mercenary, with a bitter vendetta, mounts an apocalyptic attack against the country.\n" +
                "\n" +
                "Director\n" +
                "Siddharth Anand\n" +
                "Writers\n" +
                "Shridhar Raghavan Abbas Tyrewala Siddharth Anand\n" +
                "Stars\n" +
                "Shah Rukh Khan Deepika Padukone John Abraham");
        itemContents.put("Bahubali 2", "Amarendra Baahubali, the heir apparent to the throne of Mahishmati, finds his life and relationships endangered as his adoptive brother Bhallaladeva conspires to claim the throne.\n" +
                "\n" +
                "Director\n" +
                "S.S. Rajamouli\n" +
                "Writers\n" +
                "Vijayendra Prasad S.S. Rajamouli C.H. Vijay Kumar\n" +
                "Stars\n" +
                "Prabhas Rana Daggubati Anushka Shetty");
        itemContents.put("K.G.F: Chapter 2", "In the blood-soaked Kolar Gold Fields, Rocky's name strikes fear into his foes. While his allies look up to him, the government sees him as a threat to law and order. Rocky must battle threats from all sides for unchallenged supremacy.\n" +
                "\n" +
                "Director\n" +
                "Prashanth Neel\n" +
                "Writers\n" +
                "Harman H Noraiz Nafi Prashanth Neel\n" +
                "Stars\n" +
                "Yash Sanjay Dutt Raveena Tandon\n");
        itemContents.put("Top Gun: Maverick", "After thirty years, Maverick is still pushing the envelope as a top naval aviator, but must confront ghosts of his past when he leads TOP GUN's elite graduates on a mission that demands the ultimate sacrifice from those chosen to fly it.\n" +
                "\n" +
                "Director\n" +
                "Joseph Kosinski\n" +
                "Writers\n" +
                "Jim Cash Jack Epps Jr.Peter Craig\n" +
                "Stars\n" +
                "Tom Cruise Jennifer Connelly Miles Teller");
        itemContents.put("John Wick: Chapter 4", "John Wick uncovers a path to defeating The High Table. But before he can earn his freedom, Wick must face off against a new enemy with powerful alliances across the globe and forces that turn old friends into foes.\n" +
                "\n" +
                "Director\n" +
                "Chad Stahelski\n" +
                "Writers\n" +
                "Shay HattenMichael FinchDerek Kolstad\n" +
                "Stars\n" +
                "Keanu Reeves Laurence Fishburne George Georgiou");
        itemContents.put("Avatar: The Way of Water", "Jake Sully lives with his newfound family formed on the extrasolar moon Pandora. Once a familiar threat returns to finish what was previously started, Jake must work with Neytiri and the army of the Na'vi race to protect their home.\n" +
                "\n" +
                "Director\n" +
                "James Cameron\n" +
                "Writers\n" +
                "James CameronRick JaffaAmanda Silver\n" +
                "Stars\n" +
                "Sam Worthington Zoe Saldana Sigourney Weaver\n");
        itemContents.put("My Fault", "Noah has to leave her town, boyfriend and friends behind and move into the mansion of her mother's new rich husband. There she meets Nick, her new stepbrother. They fall madly in love in secret.\n" +
                "\n" +
                "Director\n" +
                "Domingo González\n" +
                "Writers\n" +
                "Domingo GonzálezMercedes Ron\n" +
                "Stars\n" +
                "Nicole WallaceGabriel GuevaraMarta Hazas");
        itemContents.put("HIT: The Second Case", "Krishna Dev aka KD, a laid back cop, works in AP HIT, has to take up a gruesome murder case. As KD unravels the layers of the crime, the stakes rise unbelievably high and the threat comes unusually close.\n" +
                "\n" +
                "Director\n" +
                "Sailesh Kolanu\n" +
                "Writer\n" +
                "Sailesh Kolanu\n" +
                "Stars\n" +
                "Adivi SeshMeenakshii ChaudharyRao Ramesh");
        itemContents.put("Dasara", "Set in the backdrop of Singareni coal mines near Godavarikhani of Telangana.\n" +
                "\n" +
                "Director\n" +
                "Srikanth Odela\n" +
                "Writers\n" +
                "Srikanth OdelaThota Srinivas\n" +
                "Stars\n" +
                "Samir Harhash Nani Keerthy Suresh");
        itemContents.put("After", "A young woman falls for a guy with a dark secret and the two embark on a rocky relationship. Based on the novel by Anna Todd.\n" +
                "\n" +
                "Director\n" +
                "Jenny Gage\n" +
                "Writers\n" +
                "Susan McMartinTamara ChestnaJenny Gage\n" +
                "Stars\n" +
                "Josephine Langford Hero Fiennes Tiffin Khadijha Red Thunder");
        itemContents.put("Sita Ramam", "An orphan soldier, Lieutenant Ram's life changes, after he gets a letter from a girl named Sita. He meets her and love blossoms between them. When he comes back to his camp in Kashmir,After he gets caught in jail, he sends a letter to Sita which won't reach her.\n" +
                "\n" +
                "Director\n" +
                "Hanu Raghavapudi\n" +
                "Writers\n" +
                "Hanu RaghavapudiJay KrishnaRaj Kumar Kandamudi\n" +
                "Stars\n" +
                "Dulquer Salmaan Mrunal Thakur Rashmika Mandanna");
        itemContents.put("Fifty Shades of Grey", "Literature student Anastasia Steele's life changes forever when she meets handsome, yet tormented, billionaire Christian Grey.\n" +
                "\n" +
                "Director\n" +
                "Sam Taylor-Johnson\n" +
                "Writers\n" +
                "Kelly MarcelE.L. James\n" +
                "Stars\n" +
                "Dakota Johnson Jamie Dornan Jennifer Ehle");
        itemContents.put("La La Land", "While navigating their careers in Los Angeles, a pianist and an actress fall in love while attempting to reconcile their aspirations for the future.\n" +
                "\n" +
                "Director\n" +
                "Damien Chazelle\n" +
                "Writer\n" +
                "Damien Chazelle\n" +
                "Stars\n" +
                "Ryan Gosling Emma Stone Rosemarie DeWitt\n");
        itemContents.put("Twilight", "When Bella Swan moves to a small town in the Pacific Northwest, she falls in love with Edward Cullen, a mysterious classmate who reveals himself to be a 108-year-old vampire.\n" +
                "\n" +
                "Director\n" +
                "Catherine Hardwicke\n" +
                "Writers\n" +
                "Melissa RosenbergStephenie Meyer\n" +
                "Stars\n" +
                "Kristen Stewart Robert Pattinson Billy Burke\n");
        itemContents.put("The Batman", "When a sadistic serial killer begins murdering key political figures in Gotham, Batman is forced to investigate the city's hidden corruption and question his family's involvement.\n" +
                "\n" +
                "Director\n" +
                "Matt Reeves\n" +
                "Writers\n" +
                "Matt ReevesPeter CraigBob Kane\n" +
                "Stars\n" +
                "Robert Pattinson Zoë Kravitz Jeffrey Wrigh");
        itemContents.put("Everything Everywhere All at Once", "A middle-aged Chinese immigrant is swept up into an insane adventure in which she alone can save existence by exploring other universes and connecting with the lives she could have led.\n" +
                "\n" +
                "Directors\n" +
                "Daniel KwanDaniel Scheinert\n" +
                "Writers\n" +
                "Daniel KwanDaniel Scheinert\n" +
                "Stars\n" +
                "Michelle Yeoh Stephanie Hsu Jamie Lee Curtis");
        itemContents.put("Dune", "A noble family becomes embroiled in a war for control over the galaxy's most valuable asset while its heir becomes troubled by visions of a dark future.\n" +
                "\n" +
                "Director\n" +
                "Denis Villeneuve\n" +
                "Writers\n" +
                "Jon SpaihtsDenis VilleneuveEric Roth\n" +
                "Stars\n" +
                "Timothée Chalamet Rebecca Ferguson Zendaya\n");
        itemContents.put("Guardians of the Galaxy Vol. 3", "Still reeling from the loss of Gamora, Peter Quill rallies his team to defend the universe and one of their own - a mission that could mean the end of the Guardians if not successful.\n" +
                "\n" +
                "Director\n" +
                "James Gunn\n" +
                "Writers\n" +
                "James GunnJim StarlinStan Lee\n" +
                "Stars\n" +
                "Chris Pratt Chukwudi Iwuji Bradley Cooper");
        itemContents.put("Dungeons & Dragons: Honour Among Thieves", "A charming thief and a band of unlikely adventurers embark on an epic quest to retrieve a lost relic, but things go dangerously awry when they run afoul of the wrong people.\n" +
                "\n" +
                "Directors\n" +
                "John Francis DaleyJonathan Goldstein\n" +
                "Writers\n" +
                "Jonathan GoldsteinJohn Francis DaleyMichael Gilio\n" +
                "Stars\n" +
                "Chris Pine Michelle Rodriguez Regé-Jean Page");
        itemContents.put("Suzume", "A modern action adventure road story where a 17-year-old girl named Suzume helps a mysterious young man close doors from the other side that are releasing disasters all over in Japan.\n" +
                "\n" +
                "Director\n" +
                "Makoto Shinkai\n" +
                "Writer\n" +
                "Makoto Shinkai\n" +
                "Stars\n" +
                "Nanoka Hara Hokuto Matsumura Eri Fukatsu");
        itemContents.put("A Silent Voice", "A young man is ostracized by his classmates after he bullies a deaf girl to the point where she moves away. Years later, he sets off on a path for redemption.\n" +
                "\n" +
                "Director\n" +
                "Naoko Yamada\n" +
                "Writers\n" +
                "Yoshitoki OimaReiko YoshidaKiyoshi Shigematsu\n" +
                "Stars\n" +
                "Miyu Irino Saori Hayami Aoi Yûki");
        itemContents.put("Weathering with You", "Set during a period of exceptionally rainy weather, high-school boy Hodaka Morishima runs away from his troubled rural home to Tokyo and befriends an orphan girl who can manipulate the weather.\n" +
                "\n" +
                "Director\n" +
                "Makoto Shinkai\n" +
                "Writer\n" +
                "Makoto Shinkai\n" +
                "Stars\n" +
                "Kotaro Daigo Nana Mori Tsubasa Honda");
        itemContents.put("Akira", "A secret military project endangers Neo-Tokyo when it turns a biker gang member into a rampaging psychic psychopath who can only be stopped by a teenager, his gang of biker friends and a group of psychics.\n" +
                "\n" +
                "Director\n" +
                "Katsuhiro Ôtomo\n" +
                "Writers\n" +
                "Katsuhiro ÔtomoIzô Hashimoto\n" +
                "Stars\n" +
                "Mitsuo Iwata Nozomu Sasaki Mami Koyama");
        itemContents.put("Spirited Away", "During her family's move to the suburbs, a sullen 10-year-old girl wanders into a world ruled by gods, witches and spirits, a world where humans are changed into beasts.\n" +
                "\n" +
                "Director\n" +
                "Hayao Miyazaki\n" +
                "Writer\n" +
                "Hayao Miyazaki\n" +
                "Stars\n" +
                "Daveigh Chase Suzanne Pleshette Miyu Irino");
        itemContents.put("Your Name.", "Two teenagers share a profound, magical connection upon discovering they are swapping bodies. Things manage to become even more complicated when the boy and girl decide to meet in person.\n" +
                "\n" +
                "Director\n" +
                "Makoto Shinkai\n" +
                "Writers\n" +
                "Makoto ShinkaiClark Cheng\n" +
                "Stars\n" +
                "Ryunosuke Kamiki Mone Kamishiraishi Ryo Narita\n");
        itemContents.put("Fantastic Beasts: The Secrets of Dumbledore", "Professor Albus Dumbledore must assist Newt Scamander and his partners as Grindelwald begins to lead an army to eliminate all Muggles.\n" +
                "\n" +
                "Director\n" +
                "David Yates\n" +
                "Writers\n" +
                "J.K. RowlingSteve Kloves\n" +
                "Stars\n" +
                "Eddie Redmayne Jude Law Ezra Miller");
        itemContents.put("Brahmāstra: Part One – Shiva", "A DJ with superpowers and his ladylove embark on a mission to protect the Brahmastra, a weapon of enormous energy, from dark forces closing in on them.\n" +
                "\n" +
                "Director\n" +
                "Ayan Mukerji\n" +
                "Writers\n" +
                "Hussain DalalAyan Mukerji\n" +
                "Stars\n" +
                "Amitabh Bachchan Ranbir Kapoor Alia Bhatt");
        itemContents.put("Virupaksha", "Mysterious deaths occur in a village due to an unknown person's occult practices. The whole town is afraid, and the problems continue as they search for the one responsible.\n" +
                "\n" +
                "Director\n" +
                "Karthik Varma Dandu\n" +
                "Writers\n" +
                "Krushna HariSukumar\n" +
                "Stars\n" +
                "Sai Dharam Tej Samyuktha Menon Sunil");
        itemContents.put("The Pale Blue Eye", "A world-weary detective is hired to investigate the murder of a West Point cadet. Stymied by the cadets' code of silence, he enlists one of their own to help unravel the case - a young man the world would come to know as Edgar Allan Poe.\n" +
                "\n" +
                "Director\n" +
                "Scott Cooper\n" +
                "Writers\n" +
                "Scott CooperLouis Bayard\n" +
                "Stars\n" +
                "Christian Bale Harry Melling Simon McBurney");
        itemContents.put("Death on the Nile", "While on vacation on the Nile, Hercule Poirot must investigate the murder of a young heiress.\n" +
                "\n" +
                "Director\n" +
                "Kenneth Branagh\n" +
                "Writers\n" +
                "Michael GreenAgatha Christie\n" +
                "Stars\n" +
                "Tom Bateman Annette Bening Kenneth Branagh");
        itemContents.put("The Tomorrow War", "A family man is drafted to fight in a future war where the fate of humanity relies on his ability to confront the past.\n" +
                "\n" +
                "Director\n" +
                "Chris McKay\n" +
                "Writer\n" +
                "Zach Dean\n" +
                "Stars\n" +
                "Chris Pratt Yvonne Strahovski J.K. Simmons");
        itemContents.put("Tenet", "Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.\n" +
                "\n" +
                "Director\n" +
                "Christopher Nolan\n" +
                "Writer\n" +
                "Christopher Nolan\n" +
                "Stars\n" +
                "John David Washington Robert Pattinson Elizabeth Debicki\n");
        itemContents.put("Geostorm", "When the network of satellites designed to control the global climate starts to attack Earth, it's a race against the clock for its creator to uncover the real threat before a worldwide Geostorm wipes out everything and everyone.\n" +
                "\n" +
                "Director\n" +
                "Dean Devlin\n" +
                "Writers\n" +
                "Dean DevlinPaul Guyot\n" +
                "Stars\n" +
                "Gerard Butler Jim Sturgess Abbie Cornish");
        itemContents.put("The Martian", "An astronaut becomes stranded on Mars after his team assume him dead, and must rely on his ingenuity to find a way to signal to Earth that he is alive and can survive until a potential rescue.\n" +
                "\n" +
                "Director\n" +
                "Ridley Scott\n" +
                "Writers\n" +
                "Drew GoddardAndy Weir\n" +
                "Stars\n" +
                "Matt Damon Jessica Chastain Kristen Wiig");
        itemContents.put("Interstellar", "When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans.\n" +
                "\n" +
                "Director\n" +
                "Christopher Nolan\n" +
                "Writers\n" +
                "Jonathan NolanChristopher Nolan\n" +
                "Stars\n" +
                "Matthew McConaughey Anne Hathaway Jessica Chastain\n");


        // Initialize item links
        itemLinks = new HashMap<>();
        itemLinks.put("RRR", "https://zee5.onelink.me/RlQq/wgxmt9vn");
        itemLinks.put("Ghosted", "https://tv.apple.com/in/movie/ghosted/umc.cmc.6nodv9rf3ltfk2ar3pfc8hced?action=play");
        itemLinks.put("Pathaan", "https://www.primevideo.com/detail/0FIVK55HUFIIADBSNC585CZFDP/ref=atv_dp_share_cu_r");
        itemLinks.put("Bahubali 2", "https://www.hotstar.com/in/movies/baahubali-2-the-conclusion/1770016137");
        itemLinks.put("K.G.F: Chapter 2", "https://www.primevideo.com/detail/0U57AXLPYCP2QBJ4P10GD4LYST/ref=atv_dp_share_cu_r");
        itemLinks.put("Top Gun: Maverick", "https://www.primevideo.com/detail/0SSXASJCFFG34TN8CBQFM0TN90/ref=atv_dp_share_cu_r");
        itemLinks.put("John Wick: Chapter 4", "https://www.primevideo.com/detail/0PUW4TW6JE3ANJ0FBIAISMPV1J/ref=atv_dp_share_cu_r");
        itemLinks.put("Avatar: The Way of Water", "https://tv.apple.com/in/movie/avatar-the-way-of-water/umc.cmc.5k5xo2espahvd6kcswi2b5oe9?action=play");
        itemLinks.put("My Fault", "https://www.primevideo.com/detail/0S0OIMOTSETYIWA2EVTWWH7JR9/ref=atv_dp_share_cu_r");
        itemLinks.put("HIT: The Second Case", "https://www.primevideo.com/detail/0TTMDX8S7AH2F9O7AQH8ALX16L/ref=atv_dp_share_cu_r");
        itemLinks.put("Dasara", "https://www.netflix.com/in/title/81604816");
        itemLinks.put("After", "https://www.primevideo.com/detail/0JBT5G9YFQ2M7U1665L880C3S0/ref=atv_dp_share_cu_r");
        itemLinks.put("Sita Ramam", "https://www.primevideo.com/detail/0G2G9F9BZAJUW8XZ2RQ5N3MRBS/ref=atv_dp_share_cu_r");
        itemLinks.put("Fifty Shades of Grey", "https://www.netflix.com/in/title/80013872?source=35");
        itemLinks.put("La La Land", "https://www.primevideo.com/detail/0H7M04DTV2G0YOTVKSS5F7BNUP/ref=atv_dp_share_cu_r");
        itemLinks.put("Twilight", "https://tv.apple.com/in/movie/twilight/umc.cmc.zszjpc99pebr6b9ap40succv?action=play");
        itemLinks.put("The Batman", "https://www.primevideo.com/detail/0TNWJYOSXYR74OY4W78E71780P/ref=atv_dp_share_cu_r");
        itemLinks.put("Everything Everywhere All at Once", "https://www.sonyliv.com/movies/everything-everywhere-all-at-once-1000213025?utm_source=Google&utm_medium=WatchNow&utm_campaign=1000213025");
        itemLinks.put("Guardians of the Galaxy Vol. 3", "https://tv.apple.com/in/movie/guardians-of-the-galaxy-vol-3/umc.cmc.4sfw9bhw8bx6dnyfysc8829rt?action=play");
        itemLinks.put("Dune", "https://www.primevideo.com/detail/0IYI4MP68J8X3KAW96CLQQXCTB/ref=atv_dp_share_cu_r");
        itemLinks.put("Dungeons & Dragons: Honour Among Thieves", "https://www.primevideo.com/detail/0FD5ZVWR76B4YTFZG5X75KILRB/ref=atv_dp_share_cu_r");
        itemLinks.put("Suzume", "https://aniwatch.to/suzumes-doorlocking-18190?ref=search");
        itemLinks.put("A Silent Voice", "https://aniwatch.to/a-silent-voice-11?ref=search");
        itemLinks.put("Weathering with You", "https://aniwatch.to/weathering-with-you-111?ref=search");
        itemLinks.put("Akira", "https://aniwatch.to/akira-337?ref=search");
        itemLinks.put("Spirited Away", "https://aniwatch.to/spirited-away-20?ref=search");
        itemLinks.put("Your Name.", "https://aniwatch.to/your-name-10?ref=search");
        itemLinks.put("Fantastic Beasts: The Secrets of Dumbledore", "https://www.youtube.com/watch?v=vVvBooye0-I");
        itemLinks.put("Brahmāstra: Part One – Shiva", "https://www.hotstar.com/in/movies/brahmastra-part-one-shiva/1260110227");
        itemLinks.put("Virupaksha", "https://www.netflix.com/in/title/81504461?source=35");
        itemLinks.put("The Pale Blue Eye", "https://www.netflix.com/in/title/81444818?source=35");
        itemLinks.put("Death on the Nile", "https://tv.apple.com/in/movie/death-on-the-nile-2022/umc.cmc.55p0q7voas9qe3f5u1oc76q3i?action=play");
        itemLinks.put("The Tomorrow War", "https://www.primevideo.com/detail/0L8V88NU7CFYRKM857QDN2O5B4/ref=atv_dp_share_cu_r");
        itemLinks.put("Tenet", "https://www.primevideo.com/detail/0LTVOZI56FO4ZEJ8GUM4LPVDDI/ref=atv_dp_share_cu_r");
        itemLinks.put("Geostorm", "https://www.primevideo.com/detail/0J3U6CLNFDRP09F6BTJ9EQ5BE7/ref=atv_dp_share_cu_r");
        itemLinks.put("The Martian", "https://tv.apple.com/in/movie/the-martian/umc.cmc.4kluf2kwyi1arpo7yult1pt58?action=play");
        itemLinks.put("Interstellar", "https://www.primevideo.com/detail/0I9WWNH0WX2Q545OV1W8O1SFE1/ref=atv_dp_share_cu_r");


    }

    private void addChildItems(String groupTitle, String... items) {
        List<String> childList = new ArrayList<>();
        for (String item : items) {
            childList.add(item);
        }
        childItems.put(groupTitle, childList);
    }
}