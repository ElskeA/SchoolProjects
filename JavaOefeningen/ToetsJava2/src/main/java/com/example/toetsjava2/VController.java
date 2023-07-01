package com.example.toetsjava2;

import java.util.ArrayList;

public class VController implements IVController {

    public ArrayList<Object> vlijst;

//    public VController() {
//        vlijst = new ArrayList<>();
//    }
    public VController(){
        vlijst = new ArrayList<>();
        vlijst.add(new Auto("04-04-2022", "12:00", "Breda", "Roosendaal", "1980", "Diesel", "AC123456", "Nissan",  40, "Bezet", "4deurs"));
        vlijst.add(new Bus("08-04-2022", "14:30", "Rotterdam", "Amsterdam", "1999", "Benzine", "BA78945", "Busje",  80, "In onderhoud", 5));
        vlijst.add(new Motor("10-04-2022", "08:00", "Roosendaal", "Breda", "1995", "Elektrisch", "KA19292", "Honda",  100, "Vrij", true));
        vlijst.add(new Touringcar("25-06-2022", "09:00", "Amsterdam", "Rotterdam", "2005", "Diesel", "HA91843", "Tourtje",  250, "Vrij", 12));
    }

    @Override
    public void opslaanV(Object v) {
        vlijst.add(v);

    }

    @Override
    public void geefLijst() {
    }


    @Override
    public String geefAuto() {
        String resulta = "";
        for (Object a : vlijst) {
            if (a instanceof Auto) {
                resulta = "Soort: " + ((Auto) a).soortAuto + "\n" +
                            "Datum: " + ((Reservering)a).datum + "\n" +
                            "Tijd: " + ((Reservering)a).tijd;
            }
        }
        return resulta;
    }

    @Override
    public String geefBus() {
        String resultb = "";
        for (Object b : vlijst) {
            if (b instanceof Bus) {
                resultb = "Aantal passagiers: " + ((Bus) b).aantPass + "\n" +
                        "Datum: " + ((Reservering)b).datum + "\n" +
                        "Tijd: " + ((Reservering)b).tijd;
            }
        }
        return resultb;
    }

    @Override
    public String geefTour() {
        String resultt = "";
        for (Object t : vlijst) {
            if (t instanceof Touringcar) {
                resultt = "Aantal passagiers: " + ((Touringcar) t).aantPass + "\n" +
                        "Datum: " + ((Reservering)t).datum + "\n" +
                        "Tijd: " + ((Reservering)t).tijd;
            }
        }
        return resultt;
    }


    @Override
    public String geefMotor() {
        String resultm = "";
        for (Object m : vlijst) {
            if (m instanceof Motor) {
                resultm = "Zijspan: " + ((Motor) m).zijspan + "\n" +
                        "Datum: " + ((Reservering)m).datum + "\n" +
                        "Tijd: " + ((Reservering)m).tijd;
            }
        }
        return resultm;
    }
}
