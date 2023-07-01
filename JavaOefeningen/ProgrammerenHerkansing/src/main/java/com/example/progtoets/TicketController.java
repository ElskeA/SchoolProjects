package com.example.progtoets;

import java.util.ArrayList;

public class TicketController {

    ArrayList<RecreatieTicket> lstRecreatie = new ArrayList<RecreatieTicket>();
    ArrayList<BaantjesTicket> lstBaantjes = new ArrayList<BaantjesTicket>();

//    public TicketController(){
//        lstRecreatie.add(new RecreatieTicket("Recreatie", "123RB", "09-03-2022", "10:00", "4834ME", "Breda"));
//        lstRecreatie.add(new RecreatieTicket("Recreatie", "456RB", "10-03-2022", "13:00", "4815AD", "Breda"));
//        lstRecreatie.add(new RecreatieTicket("Recreatie", "789RB", "11-03-2022", "15:00", "2024BE", "Ulvenhout"));
//
//        lstBaantjes.add(new BaantjesTicket("Baantjes", "321BR", "12-03-2022", "10:00", "1234AB", "Ulvenhout"));
//        lstBaantjes.add(new BaantjesTicket("Baantjes", "654BR", "13-03-2022", "13:00", "4321AB", "Breda"));
//        lstBaantjes.add(new BaantjesTicket("Baantjes", "987BR", "14-03-2022", "15:00", "1234KH", "Breda"));
//    }

    public void opslaanRecreatie(RecreatieTicket rt){
        lstRecreatie.add(rt);
    }

    public void opslaanBaantjes(BaantjesTicket bt){
        lstBaantjes.add(bt);
    }

    public ArrayList geefOverzichtRec(){
        return lstRecreatie;
    }

    public ArrayList geefOverzichtBaan(){
        return lstBaantjes;
    }

    public double geefTotaalRec(){
        double totaalR = 0;
        for (Object rec : lstRecreatie){
            double prijs = ((RecreatieTicket)rec).getPrijs();
            totaalR += prijs;
        }
        return totaalR;
    }

    public double geefTotaalBaan(){
        double totaalB = 0;
        for (Object baan : lstBaantjes){
            double prijs = ((BaantjesTicket)baan).getPrijs();
            totaalB += prijs;
        }
        return totaalB;
    }

    public double geefTotaal(double g1, double g2){
         double totaal = g1 + g2;
         return totaal;
    }

}
