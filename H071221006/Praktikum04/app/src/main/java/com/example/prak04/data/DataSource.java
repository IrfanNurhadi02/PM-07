package com.example.prak04.data;


import com.example.prak04.Postingan;
import com.example.prak04.R;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<Postingan> instagrams = generateDummyPostingans();

    private static ArrayList<Postingan> generateDummyPostingans() {
        ArrayList<Postingan> instagram1 = new ArrayList<>();
        instagram1.add(new Postingan("Fakhrul Oud","foLovers"
                ,"A very unique and mysterious scent"
                , R.drawable.fologo,R.drawable.ach));

        instagram1.add(new Postingan("Fakhrul Oud", "foLovers"
                ,"Every morning I always drink a glass of coffee to give me enthusiasm and energy, coffee makes me addicted to its taste, scent and enjoyment."
                ,R.drawable.fologo,R.drawable.cafe));

        instagram1.add(new Postingan("Initio Parfums Prive", "Initio"
                ,"Experience the powerful force of duality as you uncover the truth behind the undeniable attraction of opposites."
                ,R.drawable.initiologo, R.drawable.ofg));

        instagram1.add((new Postingan("Amouage Official","Amouage"
                ,"Retaining the instantly recognisable Blackberry opening, Jubilation 40 reveals dry, tart hints of Blackcurrant. This makes way for the perfume’s majestic heart: Scotch Broom unfurls within a burst of honeyed Tobacco notes while regal Frankincense cuts through the narcotic warmth of Balsams and Resins. Eventually, the scent settles on an enveloping, heart-stopping dry-down of Patchouli and Cistus."
                ,R.drawable.amouagelogo,R.drawable.amouage)));

        instagram1.add(new Postingan("Hausser Perfume", "Hausser"
                ,"There is something so comforting and alluring about the smell of new magazines. We capture that essence in Ballade en Papier. The elegant scent of new magazine, spices, floral and musk. This is what Ballade en Papier is all about: the combination of timelessness and modernity."
                ,R.drawable.hausserlogo,R.drawable.ballade));

        instagram1.add(new Postingan("Hausser Perfume","Hausser"
                ,"The intoxicating and modern white floral to infuse yourself with deep pleasure"
                ,R.drawable.hausserlogo, R.drawable.bijoux));

        instagram1.add(new Postingan("Hausser Perfume","Hausser"
                , "Bergamot, Rose, Oud, Tobacco, Vanilla, Amber, Musk"
                ,R.drawable.hausserlogo,R.drawable.tresor));

        instagram1.add(new Postingan("Hom Haute Perfumerie","HomHaute"
                ,"A Night in Strasbourg"
                ,R.drawable.homlogo, R.drawable.anis));

        instagram1.add(new Postingan("Stephane Humbert Lucas", "SHL777"
                ,"A breath of cocoa, and the patchouli takes over, we are in the home of the Kalbelia women who bewitch the souls who come to confide in them, to rest and to dance"
                ,R.drawable.shllogo, R.drawable.shl));

        instagram1.add(new Postingan("Matiere Premiere", "Matiere Premiere"
                ,"It is inspired by the intoxicating smell of our tuberose field at night.\n"
                ,R.drawable.matierelogo, R.drawable.matiere));
        return instagram1;
    }
}