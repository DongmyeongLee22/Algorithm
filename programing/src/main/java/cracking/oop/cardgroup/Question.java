package cracking.oop.cardgroup;

import java.util.List;

public class Question {

    public static void main(String[] args) {
        int numHands = 5;

        BlackJackGameAutomator automator = new BlackJackGameAutomator(numHands);
        automator.initializeDeck();
        boolean success = automator.dealInitial();

        if (!success) {
            System.out.println("Error. Out of cards");
        } else {
            System.out.println("-- Initial --");
            automator.printHandsAndScore();
            List<Integer> blackjacks = automator.getBlackJacks();
            if (blackjacks.size() > 0) {
                System.out.println("Blackjack at ");
                for (int i : blackjacks) {
                    System.out.print(i + ", ");
                }
                System.out.println();
            } else {
                success = automator.playAllHands();
                if (!success){
                    System.out.println("Error. Out of cards");
                }else {
                    System.out.println("-- Completed Game --");
                    automator.printHandsAndScore();
                    List<Integer> winners = automator.getWinners();
                    if (winners.size()>0){
                        System.out.print("Winner: ");
                        for(int i : winners){
                            System.out.print(i + ", ");
                        }
                        System.out.println();
                    }else{
                        System.out.println("Draw. All players have busted.");
                    }
                }
            }
        }
    }
}

