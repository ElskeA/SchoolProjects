//Code van de volgende website is gebruik om de opdracht te maken
//https://roboticsbackend.com/arduino-turn-led-on-and-off-with-button/

int ledPin = 11;
int Button = 1;

//Een  variabele de huidige buttonstate bij te houden
int buttonState = LOW;
//Een  variabele om de laatste buttonstate bij te houden
int lastButtonState = LOW;
int ledState = LOW;

void setup() {
  pinMode(ledPin, OUTPUT);
  pinMode(Button, INPUT);
}

void loop() {
  //Leest de knop uit en slaat de state op in de variabele
  int buttonState = digitalRead(Button);
  //Als de buttonstate niet hetzelfde is als de lastButtonstate dan begint de eerste if
  //buttonState is na het klikken HIGH en komt dus niet meer overeen met lastButtonstate die begint op LOW
  //Dan wordt de lastbuttonstate gelijk gemaakt aan de buttonstate en loopt de loop opnieuw door
  //De buttonstate is dan wel gelijk aan de lastbuttonstate
  if (buttonState != lastButtonState) {
    lastButtonState = buttonState;
    delay(50);
    //Bij nogmaals op de knop te drukken wordt de buttonstate weer LOW en loopt de volgnde if statement door
    if (buttonState == LOW) {
      //de ledState wordt hier aangepast a.d.h.v. of die al op HIGH of LOW staat
      //en zet het om naar de tegenovergestelde waarde
      //Staat de ledState op HIGH zet het om naar LOW en vice versa
      ledState = (ledState == HIGH) ? LOW: HIGH;
      //De ledState wordt hier toegepast aan de ledPin
      digitalWrite(ledPin, ledState);
      delay(50);
    }
  }
}
