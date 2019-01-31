package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.impl.CircularlyLinkedList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SolitaireDecrypt {
    CircularlyLinkedList<Integer> deck = new CircularlyLinkedList<>();
    int[] keyStream;

    SolitaireDecrypt(String e) {
        Scanner deckFile = null;

            try {
                deckFile = new Scanner(new BufferedReader(new FileReader(e)));

                 while (deckFile.hasNext()) {
                deck.addFirst(deckFile.nextInt());
                }
            }
            catch (IOException error) {

            }
            finally {
            if (deckFile != null) deckFile.close();
        }

        }


    void JokerA() {
        int index = deck.indexOf(27);
        if (index == 28) {
            int joker = deck.removeLast();
            deck.insert(joker, 2);
        } else if (index == 27) {
            int joker = deck.remove(27);
            deck.addLast(joker);
        } else {
            int joker = deck.remove(index);
            deck.insert(joker, (index + 1));
        }
        JokerB();
    }

    void JokerB() {
        int index = deck.indexOf(28);
        if (index == 28) {
            int joker = deck.removeLast();
            deck.insert(joker, 3);
        } else if (index == 27) {
            int joker = deck.remove(27);
            deck.insert(joker, 2);
        } else if (index == 26) {
            int joker = deck.remove(26);
            deck.addFirst(joker);
        } else {
            int joker = deck.remove(index);
            deck.insert(joker, (index + 2));
        }
        TripleCut();
    }

    void TripleCut() {
        int jokerA = deck.indexOf(27);
        int jokerB = deck.indexOf(28);
        int leftSide;
        int rightSide;
        int tailBreak = deck.last();
        if (jokerA < jokerB) {
            leftSide = jokerA;
            rightSide = jokerB;
        } else {
            leftSide = jokerB;
            rightSide = jokerA;
        }

        for (int index = leftSide - 1; index > 0; index--) {
            deck.addLast(deck.remove(index));
        }
        for (int index = rightSide + 1; deck.get(index) != tailBreak; index++) {
            deck.addFirst(index);
        }
        BottomCardCount();
    }

    void BottomCardCount() {
        int count = deck.removeLast();
        if (count == 28) count = 27;
        for (int index = 0; index < count; index++) {
            deck.addLast(deck.removeFirst());
        }
        deck.addLast(count);
        TopCardCount();
    }

    int TopCardCount() {
        int count = deck.first();
        if (count == 28) count = 27;
        count += 1;
        if (deck.get(count) == 27 || deck.get(count) == 28) {
            JokerA();
        }
        return deck.get(count);
    }


    public String execute(String input) {
        keyStream = new int[input.length()];
        String answer = "";
        JokerA();
        return answer;
    }
}