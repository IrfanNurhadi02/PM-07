package com.example.praktikum3;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<ProfileModel> profiles = generateDummyProfiles();


    private static ArrayList<ProfileModel> generateDummyProfiles() {
        ArrayList<ProfileModel> profiles = new ArrayList<>();
        profiles.add(new ProfileModel("rezkyymaulana_", R.drawable.foto, R.drawable.post1, "19JT", "1", "Alif Rezky Maulana", "Hello, I'm Rezky.", R.drawable.foto, "ini Caption"));
        profiles.add(new ProfileModel("ammar", R.drawable.ammar, R.drawable.post2, "950", "299", "Ammar Tyo", "Hello, I'm Ammar.", R.drawable.ammar,"ini Caption"));
        profiles.add(new ProfileModel("shaff", R.drawable.shaff, R.drawable.post3, "1,002", "388", "Shaff solehah", "Hello, I'm shaff.", R.drawable.shaff,"ini Caption"));
        profiles.add(new ProfileModel("rama", R.drawable.rama, R.drawable.post4, "1,444", "540", "Ramadhan", "Hello, I'm rama.", R.drawable.rama,"ini Caption"));
        profiles.add(new ProfileModel("ojan", R.drawable.ojan, R.drawable.post5, "901", "205", "Ojan Jrot", "Hello, I'm ojan.", R.drawable.ojan,"ini Caption"));
        profiles.add(new ProfileModel("fadel", R.drawable.fadel, R.drawable.post6, "785", "555", "Fadel Mustapa", "Hello, I'm fadel.", R.drawable.fadel,"ini Caption"));
        profiles.add(new ProfileModel("adrian", R.drawable.adrian, R.drawable.post7, "8,000", "812", "Adrian Tegar", "Hello, I'm adrian.", R.drawable.adrian,"ini Caption"));
        profiles.add(new ProfileModel("alqa", R.drawable.alqa, R.drawable.post8, "456", "200", "Alqa Je'ne", "Hello, I'm alqa.", R.drawable.alqa,"ini Caption"));
        profiles.add(new ProfileModel("trisman", R.drawable.trisman, R.drawable.post9, "744", "124", "Trisman Frenchcrop", "Hello, I'm trisman.", R.drawable.trisman,"ini Caption"));
        profiles.add(new ProfileModel("wali", R.drawable.wali, R.drawable.post10, "1", "2", "Wali Mulet", "Hello, I'm wali.", R.drawable.wali,"ini Caption"));
        return profiles;
    }
}