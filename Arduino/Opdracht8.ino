//Code is geschreven met behulp van de lessheets, en Wouter heeft een klein beetje geholpen, dus de code kan hier en daar wat overeen komen
#include <IRremote.h>

//Alle buttons van de remote registreren
#define btn1 12
#define btn2 24
#define btn3 94
#define btn4 8
#define btn5 28
#define btn6 90
#define btn7 66
#define btn8 82
#define btn9 74

//IR sensor
const int irPin = 11;
const int ledPins[] = {8, 7, 5, 3};
//Alle blinktijden die worden gekoppeld aan de buttons
int blinkTimes[] = {100, 200, 300, 400, 500, 600, 700, 800, 900};
int buttonState = 0;
int buttonState2 = 0;
unsigned long lastTimes[] = {0, 0, 0, 0};
int ledStatus[] = {LOW, LOW, LOW, LOW};

int ledSelect = 0;
int ledSelect1 = 0;
int ledTime1 = 0;
int ledSelect2 = 1;
int ledTime2 = 0;

IRrecv irrecv(irPin);
decode_results results;

void setup()
{
  Serial.begin(9600);
  pinMode(ledPins[0], OUTPUT);
  pinMode(ledPins[1], OUTPUT);
  pinMode(ledPins[2], OUTPUT);
  pinMode(ledPins[3], OUTPUT);

  irrecv.enableIRIn();
 
}

void loop()
{  
 //Er moeten altijd 2 LEDs knipperen, dus die worden hier aangezet voordat er op een knop wordt gedrukt
  blinkLED(ledSelect1, blinkTimes[ledTime1]); 
  blinkLED(ledSelect2, blinkTimes[ledTime2]);
  
  //Het decoden van de buttons van de remote controller
  if(irrecv.decode())
  {
    int btnCode = irrecv.decodedIRData.command;
    irrecv.resume();

//Switch gebruikt de buttoncode die is ge-decode, adhv wordt de juiste case ingezet
    switch(btnCode){
      case btn1:
      if(buttonState == 0)
      {
        //Als er nog niet eerder op de knop is gedrukt, wordt er een led geselecteerd
        //Hier is dat 0 in de array, dus pin 8
        ledSelect = 0;
      }else if(buttonState == 1)
      {
        //Als de buttonstate al wel op 1 staat, wordt er gekeken naar de buttonstate2
        if(buttonState2 == 0){
          //is buttonstate 0 dan wordt er een tijd geselecteerd voor het knipperen van LED
          //Het is hier 0 in de array, dus 100ms
          ledTime1 = 0;  
          digitalWrite(ledPins[ledSelect1], LOW);
           blinkLED(ledSelect1, blinkTimes[ledTime1]);
          ledSelect1 = ledSelect;
          buttonState2 = 1;
        }else{
          //Als buttonstate 2 1 is, dan wordt het 2e LEDje gebruikt. Dit zodat er altijd 2 LEDs aanstaan en ze ook omwisselt
          digitalWrite(ledPins[ledSelect2], LOW);
          ledTime2 = 0; 
          blinkLED(ledSelect2, blinkTimes[ledTime2]);
          ledSelect2 = ledSelect;
          buttonState2 = 0;
        }    
      }
      break;

      case btn2:      
      if(buttonState == 0)
      {
        ledSelect = 1;
      }else if(buttonState == 1)
      {
        if(buttonState2 == 0){
        ledTime1 = 1; 
            digitalWrite(ledPins[ledSelect1], LOW);
            blinkLED(ledSelect1, blinkTimes[ledTime1]);
            ledSelect1 = ledSelect;
            buttonState2 = 1;
        }else{
          digitalWrite(ledPins[ledSelect2], LOW);
          ledTime2 = 1; 
          blinkLED(ledSelect2, blinkTimes[ledTime2]);
          ledSelect2 = ledSelect;
          buttonState2 = 0;
        }    
      }
      break;
      case btn3:      
      if(buttonState == 0)
      {
        ledSelect = 2;
      }else if(buttonState == 1)
      {
        if(buttonState2 == 0){
          ledTime1 = 2; 
            digitalWrite(ledPins[ledSelect1], LOW);
            blinkLED(ledSelect1, blinkTimes[ledTime1]);
            ledSelect1 = ledSelect;
            buttonState2 = 1;
        }else{
          digitalWrite(ledPins[ledSelect2], LOW);
          ledTime2 = 2; 
          blinkLED(ledSelect2, blinkTimes[ledTime2]);
          ledSelect2 = ledSelect;
          buttonState2 = 0;
        }    
      }
      break;
      case btn4:      
      if(buttonState == 0)
      {
        ledSelect = 3;
      }else if(buttonState == 1)
      {
        if(buttonState2 == 0){
          ledTime1 = 3; 
            digitalWrite(ledPins[ledSelect1], LOW);
            blinkLED(ledSelect1, blinkTimes[ledTime1]);
            ledSelect1 = ledSelect;
            buttonState2 = 1;
        }else{
          digitalWrite(ledPins[ledSelect2], LOW);
          ledTime2 = 3; 
          blinkLED(ledSelect2, blinkTimes[ledTime2]);
          ledSelect2 = ledSelect;
          buttonState2 = 0;
        }    
      }
      break;
      case btn5:  
        if(buttonState2 == 0){
          digitalWrite(ledPins[ledSelect1], LOW);
           blinkLED(ledSelect1, blinkTimes[4]);
          ledTime1 = 4;     
          ledSelect1 = ledSelect;
          buttonState2 = 1;
        }else{
        digitalWrite(ledPins[ledSelect2], LOW);
          ledTime2 = 4;   
          blinkLED(ledSelect2, blinkTimes[4]);
          ledSelect2 = ledSelect;
          buttonState2 = 0;
        }    
      break;
      case btn6:      
        if(buttonState2 == 0){
        digitalWrite(ledPins[ledSelect1], LOW);
          ledTime1 = 5; 
          blinkLED(ledSelect1, blinkTimes[ledTime1]);
          ledSelect1 = ledSelect;
          buttonState2 = 1;
        }else{
        digitalWrite(ledPins[ledSelect2], LOW);
          ledTime2 = 5;   
          blinkLED(ledSelect2, blinkTimes[ledTime2]);
          ledSelect2 = ledSelect;
          buttonState2 = 0;
        }     
      break;
      case btn7:      
        if(buttonState2 == 0){
        digitalWrite(ledPins[ledSelect1], LOW);
          ledTime1 = 6;
          blinkLED(ledSelect1, blinkTimes[ledTime1]);
          ledSelect1 = ledSelect;
          buttonState2 = 1;
        }else{
        digitalWrite(ledPins[ledSelect2], LOW);
          ledTime2 = 6;
          blinkLED(ledSelect2, blinkTimes[ledTime2]);
          ledSelect2 = ledSelect;
          buttonState2 = 0;
        }    
      break;
      case btn8:      
        if(buttonState2 == 0){
        digitalWrite(ledPins[ledSelect1], LOW);
          ledTime1 = 7;
          blinkLED(ledSelect1, blinkTimes[ledTime1]);
          ledSelect1 = ledSelect;
          buttonState2 = 1;
        }else{
        digitalWrite(ledPins[ledSelect2], LOW);
          ledTime2 = 7;
          blinkLED(ledSelect2, blinkTimes[ledTime2]);
          ledSelect2 = ledSelect;
          buttonState2 = 0;
        }    
      break;
      case btn9:      
        if(buttonState2 == 0){
      digitalWrite(ledPins[ledSelect1], LOW);
          ledTime1 = 8;
          blinkLED(ledSelect1, blinkTimes[ledTime1]);
          ledSelect1 = ledSelect;
          buttonState2 = 1;
        }else{
        digitalWrite(ledPins[ledSelect2], LOW);
          ledTime2 = 8;
          blinkLED(ledSelect2, blinkTimes[ledTime2]);
          ledSelect2 = ledSelect;
          buttonState2 = 0;
        }    
      break;
    }
    if(buttonState == 0)
    { 
      //Buttonstate naar 1 om nogmaals de volledige loop te doorlopen
      buttonState=1; 
    }
    else
    { 
      //Buttonstate naar 0
      buttonState=0; 
    }
  Serial.println(buttonState);
  }
  
     
}

//Functie om de LEDs te laten knipperen
void blinkLED(int led, int blink){
  unsigned long huidigeTijd = millis();

  if(huidigeTijd - lastTimes[led] >= blink)
  {
    lastTimes[led] = huidigeTijd;
    ledStatus[led] = (ledStatus[led] == LOW) ? HIGH : LOW;
    digitalWrite(ledPins[led], ledStatus[led]);
  }
}
