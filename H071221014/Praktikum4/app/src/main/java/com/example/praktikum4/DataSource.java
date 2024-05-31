package com.example.praktikum4;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<ProfileModel> profiles = generateDummyProfiles();


    private static ArrayList<ProfileModel> generateDummyProfiles() {
        ArrayList<ProfileModel> profiles = new ArrayList<>();
        profiles.add(new ProfileModel("rezkyymaulana_", R.drawable.foto, "19JT", "1", "Alif Rezky Maulana", "Hello, I'm Rezky.", R.drawable.foto, "ini Caption"));
        profiles.add(new ProfileModel("ammar", R.drawable.ammar, "950", "299", "Ammar Tyo", "Hello, I'm Ammar.", R.drawable.ammar,"ini Caption"));
        profiles.add(new ProfileModel("shaff", R.drawable.shaff, "1,002", "388", "Shaff solehah", "Hello, I'm shaff.", R.drawable.shaff,"ini Caption"));
        profiles.add(new ProfileModel("rama", R.drawable.rama, "1,444", "540", "Ramadhan", "Hello, I'm rama.", R.drawable.rama,"ini Caption"));
        profiles.add(new ProfileModel("ojan", R.drawable.ojan, "901", "205", "Ojan Jrot", "Hello, I'm ojan.", R.drawable.ojan,"ini Caption"));
        profiles.add(new ProfileModel("fadel", R.drawable.fadel, "785", "555", "Fadel Mustapa", "Hello, I'm fadel.", R.drawable.fadel,"ini Caption"));
        profiles.add(new ProfileModel("adrian", R.drawable.adrian, "8,000", "812", "Adrian Tegar", "Hello, I'm adrian.", R.drawable.adrian,"ini Caption"));
        profiles.add(new ProfileModel("alqa", R.drawable.alqa, "456", "200", "Alqa Je'ne", "Hello, I'm alqa.", R.drawable.alqa,"ini Caption"));
        profiles.add(new ProfileModel("trisman", R.drawable.trisman, "744", "124", "Trisman Frenchcrop", "Hello, I'm trisman.", R.drawable.trisman,"ini Caption"));
        profiles.add(new ProfileModel("wali", R.drawable.wali, "1", "2", "Wali Mulet", "Hello, I'm wali.", R.drawable.wali,"ini Caption"));
        return profiles;
    }
}