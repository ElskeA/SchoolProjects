package com.example.boompjes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

//        String deVraag = "Wat is uw lievelingsdier?";
//        String arr[] = {"Kat", "Muis", "Hond"};

//        Knoop k1 = new Knoop(new Vraag(deVraag, arr));
//        if(k1.getUserObject() instanceof Vraag)
//        {
//            Vraag eenVraag = (Vraag)k1.getUserObject();
//            System.out.println(eenVraag.getDeVraag());
//        }

        Knoop k1 = new Knoop(1);
        Knoop k3 = new Knoop(3);
        Knoop k5 = new Knoop(5);
        Knoop k7 = new Knoop(7);
        Knoop k9 = new Knoop(9);
        Knoop k11 = new Knoop(11);
        Knoop k13 = new Knoop(13);
        Knoop k15 = new Knoop(15);

        Knoop k2 = new Knoop(2, k1, k3);
        Knoop k6 = new Knoop(6, k5, k7);
        Knoop k10 = new Knoop(10, k9, k11);
        Knoop k14 = new Knoop(14, k13, k15);

        Knoop k4 = new Knoop(4, k2, k6);
        Knoop k12 = new Knoop(12, k10, k14);

        Knoop k8 = new Knoop(8, k4, k12);

        //Nieuwe boom met vragen
        String ant[] = {"Eik", "Spar", "Berk"};
        Vraag eenVraag = new Vraag("Wat is dit voor boom?", ant);

        String ant1[] = {"Kat", "Muis", "Hond"};
        Vraag eenVraag1 = new Vraag("Wat is uw lievelingsdier?", ant1);

        String ant2[] = {"Brein", "Help", "I don't get it"};
        Vraag eenVraag2 = new Vraag("Wat is dit?", ant2);

        //Opbouw nieuwe boom met niveau 0 en 1
        Knoop newRoot = new Knoop(eenVraag, new Knoop(eenVraag2), new Knoop(eenVraag1));
        //koppelt nieuwe boom aan knoop 15
        k15.setRechterKind(newRoot);

        wandel(k8, 22, 0);

    }

    //Waar begint de functie en wat heeft het nodig > begint bij root, en moet een getal vinden
    public boolean wandel(Knoop root, int zoek, int teller)
    {
        teller++;
        System.out.println(teller);
        //Object van root omzetten naar integer
        if((Integer)root.getUserObject() == zoek)
        {
            System.out.println("Gevonden");
        }else if(zoek < (Integer)root.getUserObject())
        {
            //Check of linkerchild niet null is
            if(root.getLinkerKind() != null)
            {
                wandel(root.getLinkerKind(), zoek, teller);
            }

            //Afvangen als er geen linkerchild meer is
            else System.out.println("Niets gevonden");
        }else if(zoek > (Integer)root.getUserObject())
        {
            if(root.getRechterKind() != null)
            {
                if(root.getRechterKind().getUserObject() instanceof Vraag)
                {
                    Knoop deKnoop = root.getRechterKind();
                    Vraag eenVraag = (Vraag)deKnoop.getUserObject();
                    System.out.println(eenVraag.getDeVraag());
                    Vraag eenVraag2 = (Vraag)deKnoop.getRechterKind().getUserObject();
                    System.out.println(eenVraag2.getDeVraag());
                    Vraag eenVraag3 = (Vraag)deKnoop.getLinkerKind().getUserObject();
                    System.out.println(eenVraag3.getDeVraag());
                }
                else wandel(root.getRechterKind(), zoek, teller);
            }
            else
            {

            }
        }
        return false;
    }

    public static void main(String[] args) {
        launch();
    }
}