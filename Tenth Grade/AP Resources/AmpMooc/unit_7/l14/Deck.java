/*
 * AP CS MOOC
 * Term 2 - Assignment 5: Shuffle
 * A class which represents a Deck of cards. For this assignment, you will need to implement the method shuffleDeck, which appears at the bottom of this class.
 */

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> deck;

    public Deck () {
        deck = new ArrayList <Card>();
        deck = initDeck();
        deck = shuffleDeck();
        System.out.println(deck);
    }

    public String toString () {
        String temp = "";

        for (Card c: deck) {
            temp += c.toString() + "\n";
        }
        return temp;
    }

    public Card getTopCard () {
        Card c = deck.get(0);
        deck.remove(0);

        return c;
    }

    public static ArrayList <Card> initDeck () {

        ArrayList <String> ranks = new ArrayList <String> ();

        ranks.add ("ace");

        ranks.add ("two");
        ranks.add ("three");
        ranks.add ("four");
        ranks.add ("five");
        ranks.add ("six");
        ranks.add ("seven");
        ranks.add ("eight");
        ranks.add ("nine");
        ranks.add ("ten");
        ranks.add ("jack");
        ranks.add ("queen");
        ranks.add ("king");

        ArrayList <String> suites = new ArrayList <String> ();
        suites.add("clubs");
        suites.add("diamonds");
        suites.add("hearts");
        suites.add("spades");

        ArrayList <Card> deck = new ArrayList <Card> ();
        for (String s : suites) {
            int p = 1;
            for (String r: ranks) {
                Card c = new Card (r, s, p);
                p++;
                deck.add(c);
            }
        }
        return deck;
    }


    public  ArrayList <Card> shuffleDeck () {

        ArrayList <Card> t = new ArrayList <Card> ();

        while (t.size() < 52) {
        Card randomCard = deck.get((int)(Math.random() * 52));
            boolean inShuffled;
            inShuffled = false;
            for (Card card: t) {
                if (card.matches(randomCard)) {
                    inShuffled = true;
                }
            }

            if (!inShuffled) {
                t.add(randomCard);
            }
        }

        return t;
    }
}