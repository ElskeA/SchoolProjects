// Code is geschreven met behulp van de sheets les 4
//
#include <Servo.h>

//de triggerpin
const int tPin = 9;
//de echo pin
const int ePin = 8;
float time;
float distance;
float mapWaarde = 0;
Servo mijnServo;


void setup()
{
  Serial.begin(9600);
  pinMode(tPin, OUTPUT);
  pinMode(ePin, INPUT);
  
  mijnServo.attach(6);
  //Om te zorgen dat de servo op de correcte positie starts gebruik ik een 
  //write om te resetten
  mijnServo.write(0);
}

void loop()
{
  
  
  //Triggerpin begint op LOW
  digitalWrite(tPin, LOW);
  delayMicroseconds(2);
  
  //Zet triggerpin op HIGH om het ultrasoon geluid aan te zetten
  digitalWrite(tPin, HIGH);
  delayMicroseconds(100);
  //zet de triggerpin vervolgens weer uit
  digitalWrite(tPin, LOW);
  
  //Vraagt op hoelang de echopin op HIGh heeft gestaan
  time = pulseIn(ePin, HIGH);
  
  //Afstand wordt berekend a.d.h.v. de snelheid van het geluid
 distance = time / 58;
  //ik gebruik een println om te checken of het klopt
 Serial.println(distance);
  
  //De servo wordt aangepast a.d.h.v. de afstand van een object wat
  //wordt opgepakt door de ultrasoon sensor
  //Het object moet binnen 10 en 4 cm afstand komen
  if(distance <= 10 && distance >= 4)
  {
    //D.m.v. de mapwaarde wordt de distance omgerekend naar
    //de correcte afstand zodat alle standen door de servo 
    //worden doorlopen
    mapWaarde = map(distance, 10, 4, 0, 180);
    mijnServo.write(mapWaarde);
  }
  
  delay(100);
}
