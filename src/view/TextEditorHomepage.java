package view;

import controller.CaculateVotes;

import java.util.ArrayList;

public class TextEditorHomepage {

    static String [] stateList;
    CaculateVotes calculateVotes = new CaculateVotes();

    public TextEditorHomepage(){

        this.stateList = new String []{"src/files/Abia_votes.txt", "src/files/Enugu_votes.txt",
                "src/files/Kaduna_votes.txt", "src/files/Lagos_votes.txt", "src/files/oyo_votes.txt"};
    }

    public static void main(String [] args){
        TextEditorHomepage textEditorHomepage = new TextEditorHomepage();
        System.out.println("---------   The vote count for each party in each state ---------");
        System.out.println("");
        textEditorHomepage.voteCalculation(stateList);
    }

    public void voteCalculation(String [] list) {
        for (int i = 0; i < list.length; i++) {
            String [] parts = list[i].split("/");
            String [] semiFinalParts = parts[2].split("\\.");
            String [] finalParts = semiFinalParts[0].split("_");
            System.out.println("-------------- Votes from " + finalParts[0] + " state -------------");
            calculateVotes.calculateVote(list[i]);
            System.out.println("");

        }
    }
}
