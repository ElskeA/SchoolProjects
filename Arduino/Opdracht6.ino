// De onderstaande code is geschreven met behulp van de voorbeelden die zijn gegeven in
// de sheets van les 03
#include <Servo.h>

Servo mijnServo;
int Button1 = 10;
int Button2 = 12;
int ButtonState1 = 0;
int ButtonState2 = 0;
int positie = 0;


void setup()
{
  Serial.begin(9600);
  pinMode(Button1, INPUT);
  pinMode(Button2, INPUT);
  //De Servo koppelen aan pin 7
  mijnServo.attach(7);
  //De servo begon af en toe al met draaien bij het aanzetten
  //Daarom zet ik in de setup een write0 om te zorgen dat de servo gereset wordt voordat
  //de loop wordt doorlopen
  mijnServo.write(0);
}

void loop()
{
  //De buttonstates van beide buttons worden in aparte variabele opgeslagen
  ButtonState1 = digitalRead(Button1);
  ButtonState2 = digitalRead(Button2);
  
  //In de if statements wordt er gekeken welke buttonstates overeen komen
  if(ButtonState1 == HIGH && ButtonState2 == LOW)
  {
    Serial.println(ButtonState1);
    
    //Positie begint op 1 en loopt op tot 120, bij elke keer dat de forloop opnieuw
    //wordt doorlopen wordt er 1 opgeteld bij positie en stopt als het 120 bereikt.   
    for(positie = 0; positie <= 120; positie++)
    {
      mijnServo.write(positie);
    //Door de delay op 1000/120 te zetten wordt er door de code uitgerekend dat het
    //1 seconde moet duren om de volledige positie te bereieken
      delay(1000/120);
      //In de volgende forloop gebeurd hetzelfde, met dan precies andersom
      //Door positie-- te gebruiken werkt het nu terug van 120 naar 0 om terug te draaien
      //naar de originele positie
    }for(positie = 120; positie >= 0; positie--)
    {
      Serial.println(positie);
      mijnServo.write(positie);
      delay(1000/120);
    }  
  }  
    
   if(ButtonState1 == LOW && ButtonState2 == HIGH)
   {
     Serial.println(ButtonState2);
     for(positie = 0; positie <= 120; positie++)
    {
      Serial.println(positie);
      mijnServo.write(positie);
      delay(500/120);
    }for(positie = 120; positie >= 0; positie--)
    {
      Serial.println(positie);
      mijnServo.write(positie);
      //De servo motor moet in deze loop de juiste stand bereiken in 0,5s
      //Net als voorheen rekent de delay hier zelf uit door het te delen door de stand
       //van de servo
      delay(500/120);
    }
    
    if(ButtonState1 == HIGH && ButtonState2 == HIGH)
    {
      for(positie = 0; positie <= 120; positie++)
      {
        Serial.println(positie);
        mijnServo.write(positie);
        delay(1000/120);
      }
      
      delay(2000);
      
      for(positie = 120; positie >= 0; positie--)
      {
        Serial.println(positie);
        mijnServo.write(positie);
        delay(1000/120);
      }
    } 
  }   
}
