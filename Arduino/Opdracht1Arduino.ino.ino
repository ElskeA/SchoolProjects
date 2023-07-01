//Voor de onderstaande opdracht is er gebruik gemaakt van bestaande code gevonden via de onderstaande link
//https://docs.arduino.cc/built-in-examples/control-structures/ForLoopIteration      

//Voor de setup wordt er een loop gebruikt om alle pinnen aan te spreken en als OUTPUT te registreren
void setup() {
  for (int ledPin = 1; ledPin < 9; ledPin++) 
  {
    pinMode(ledPin, OUTPUT);
  }
}

void loop() {
  //De loop begint bij ledpin 1 en blijft het doorlopen totdat het pin8 heeft bereikt
  //en gaat dan verder met de volgende loop
  for (int ledPin = 1; ledPin < 9; ledPin++) {
    
    //Zet de ledpin aan
    digitalWrite(ledPin, HIGH);

    //Zorgt dat er een kleine delay is zodat het niet te snel gaat
    delay(100);

    //Zet de pin vervolgens weer uit
    digitalWrite(ledPin, LOW);

  }
  //Als het aan deze loop begint betekend het dat de vorige loop de 8e pin heeft bereikt
  //Deze loop zorgt er dan weer voor dat het terug afloopt naar de eerste pin
  //en begint dan weer opnieuw met de eerste loop
  for (int ledPin = 8; ledPin >= 1; ledPin--) {

    //Zet de pin aan
    digitalWrite(ledPin, HIGH);

    delay(100);

    //Zet pin weer uit
    digitalWrite(ledPin, LOW);

  }
}
