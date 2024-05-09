package com.example.tugasprak03.Data;


import java.util.ArrayList;

import com.example.tugasprak03.R;

public class DataSource {
    public static ArrayList<DataClass> dataClasses = generateDummyPosts();
    public static ArrayList<StoryData> stories = generateDummyStories();
    public static ArrayList<User> users = generateDummyUser();

    private static ArrayList<DataClass> generateDummyPosts() {
        ArrayList<DataClass> dataClasses = new ArrayList<>();

        dataClasses.add(new DataClass(0, R.drawable.shl, "Sand Dance is inspired by the most sensual dance movements of the Kalbelia dancers, a nomadic people from Rajahstan, the land of kings in northern India and the gateway to the Orient.", 0));

        dataClasses.add(new DataClass(1, R.drawable.casamorati, "Discover the intoxicating charm of Italica, part of the Casamorati collection.\n" +
                "        Warm and full-bodied, Italica opens to creamy top notes of almond and milk , warmed by hints of spicy saffron and leading to a sweet heart of bourbon, vanilla and irresistible toffee.\n" +
                "        Notes of deep sandalwood and white musk provide a classic base.\n" +
                "        The classic Xerjoff Casamorati packaging has been reimagined with a focus on sustainability, while retaining the references to the Liberty style that distinguishes the brand’s history.", 1));

        dataClasses.add(new DataClass(2, R.drawable.matiere, "Create a bouquet of Tuberose with Absolute and Enfleurage of Tuberose petals. Nigeria Ginger amplifies the whiteness of the flower. Chinese Tea Leaf Essence and a Green Pear accord underline the vegetal character of this stemmed flower.", 2));

        dataClasses.add(new DataClass(3, R.drawable.kajal, "LAMAR…beauty in a name, beauty in a bottle, beauty in a scent. A name with French origins Lumière, meaning light, LAMAR is also known to be liquid gold: mesmerizing, fascinating and enticing. A scent created to resemble the beauty of a golden sun setting in the horizon. Distant clouds reflect rich rays of color – hues of red, streaks of yellow and shimmers of gold. The scent of LAMAR evokes fragrant notes of rose and jasmine that float on a Mediterranean breeze. A magnificent scent", 3));

        dataClasses.add(new DataClass(4, R.drawable.nishane, "Part of the NISHANE collection, transports wearers to the Far East’s serene tea gardens with oolong tea leaves and Mediterranean fig. The original fragrance, a blend of invigorating elements, has been refined with floral accents, particularly magnolia. The fragrance begins with lively citrus notes, followed by heart notes of magnolia, thyme oil, and green tea. The base notes of musk and fig provide a cozy, revitalizing experience.", 4));

        return dataClasses;
    }

    private static ArrayList<StoryData> generateDummyStories() {
        ArrayList<StoryData> stories = new ArrayList<>();

        stories.add(new StoryData(0, R.drawable.shl, 0));

        stories.add(new StoryData(1, R.drawable.casamorati, 1));

        stories.add(new StoryData(2, R.drawable.matiere, 2));

        stories.add(new StoryData(3, R.drawable.kajal, 3));

        stories.add(new StoryData(4, R.drawable.nishane, 4));

        return stories;
    }

    private static ArrayList<User> generateDummyUser() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(0, R.drawable.shl, "StephaneHumbertLucas", 15500, 235));
        users.add(new User(1, R.drawable.casamorati, "Casamorati1888", 72100, 3200));
        users.add(new User(2, R.drawable.matiere, "MatierePremiere", 11000, 52));
        users.add(new User(3, R.drawable.kajal, "KajalPerfumes", 7200, 1120));
        users.add(new User(4, R.drawable.nishane, "Nishane", 34273, 125));
        return users;
    }
}