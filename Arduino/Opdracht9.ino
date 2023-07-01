//https://linuxhint.com/fix-avrdude-stk500-error-arduino/ - Deze link is gebruikt bij het oplossen van de error code bij het uploaden van de code naar arduino
//https://create.arduino.cc/projecthub/mayooghgirish/arduino-bluetooth-basic-tutorial-d8b737 - Deze link is gebruikt bij het registreren en ophalen van de input vanuit de android app

#include <stdlib.h> // Standard library

const int ledPins[] = {2, 3, 4};
unsigned long lastTimes[] = {0, 0, 0, 0};
int ledStatus[] = {LOW, LOW, LOW, LOW};
unsigned long groenStart;
unsigned long oranjeStart;
unsigned long roodStart;

void setup() {
  Serial.begin(9600);
  pinMode(ledPins[0], OUTPUT);
  pinMode(ledPins[1], OUTPUT);
  pinMode(ledPins[2], OUTPUT);
  //randomSeed zorgt ervoor dat elke keer dat de random functie wordt aangesproken er een nieuwe output uit komt, en niet elke keer hetzelfde
  randomSeed(analogRead(A0));
}

void loop() {

//Knipperen van het oranje licht
  digitalWrite(ledPins[1], HIGH);
  delay(1000);
  digitalWrite(ledPins[1], LOW);
  delay(1000);

  //Checkt of er een input wordt gegeven via de android app
  if(Serial.available()){
    //Serial.read haalt de code op die met android wordt meegestuurd en in een variabele gezet
      char c = Serial.read();
      //als de variabele 1 is dan worden de functies doorlopen voor het aanzetten van de lampen
      if(c == '1'){
        digitalWrite(ledPins[0], HIGH);
        //genereerd een random nummer
        int groenRandom = random(8, 16);
        //Maakt een startpunt aan met huidige millis
        groenStart = millis(); 
        Serial.println(groenRandom);
        //zolang de millis onder het random getal blijven zitten blijft de lamp aan
        while (millis() - groenStart < groenRandom * 1000) {
          
        }
        //Als dat niet meer zo is, gaat de lamp uit
        digitalWrite(ledPins[0], LOW);
      
        digitalWrite(ledPins[1], HIGH);
        //Startpunt maken voor oranje met millis
        oranjeStart = millis();
        //Oranje hoeft standaard maar 3 seconden aan
        while (millis() - oranjeStart < 3000) {
          
        }
        digitalWrite(ledPins[1], LOW);
      
        digitalWrite(ledPins[2], HIGH);
        //Random nummer genereren voor de rode lamp
        int roodRandom = random(8, 15);
        Serial.println(roodRandom);
        //startpunt maken voor rood in millis
        roodStart = millis();
        //zolang de millis onder het startpunt blijven, blijft de lamp aan
        while (millis() - roodStart < roodRandom * 1000) {
        
        }
        //Millis zijn voorbij het startpunt, lamp gaat nu uit
        digitalWrite(ledPins[2], LOW);
    }
  }
}

  
