package controller;

import model.FileRead;

import java.util.ArrayList;

public class CaculateVotes {

    String files;
    ArrayList<String> YYP;
    ArrayList<String> APC;
    ArrayList<String> PDP;
    ArrayList<String> ACP;
    ArrayList<String> SDP;
    ArrayList<String> list;
    int yypCount;
    int apcCount;
    int pdpCount;
    int acpCount;
    int sdpCount;
    int [] partyList;

    public CaculateVotes(){

    }

    public void calculateVote(String states) {
        this.files = states;
        FileRead fileRead = new FileRead();
        YYP = new ArrayList<>();
        APC = new ArrayList<>();
        PDP = new ArrayList<>();
        ACP = new ArrayList<>();
        SDP = new ArrayList<>();

        list = fileRead.fileRead(files);

        for (String position : list) {
            if (position.equals("YYP")) {
                YYP.add(position);
            } else if (position.equals("APC")) {
                APC.add(position);
            } else if (position.equals("PDP")) {
                PDP.add(position);
            } else if (position.equals("ACP")) {
                ACP.add(position);
            } else {
                SDP.add(position);
            }
        }

        yypCount = YYP.size();
        apcCount = APC.size();
        pdpCount = PDP.size();
        acpCount = ACP.size();
        sdpCount = SDP.size();

        //Printing vote count

        System.out.println("YYP count is: " + yypCount);
        System.out.println("APC count is: " + apcCount);
        System.out.println("PDP count is: " + pdpCount);
        System.out.println("ACP count is: " + acpCount);
        System.out.println("SDP count is: " + sdpCount);

        partyList = new int[]{yypCount, apcCount, pdpCount, acpCount, sdpCount};
        compareVotes(partyList);
    }

    public void compareVotes(int [] party){

        int max = 0;
        for (int i = 0; i<party.length; i++){
            if(party[i] > max){
                max = party[i];
            }
        }
        System.out.println("");
        System.out.println("The party with the highest votes has: " + max + " votes.");
    }
}
