//Opdracht in samenwerking gedaan met Viktor mocht er iets overeenkomen
//Er is ook gebruik gemaakt van de sheets van les 2

//potPin moet op een analoge aansluiting
const int potPin = A5;
const int ledPin1 = 10;
const int ledPin2 = 9;
const int ledPin3 = 8;
const int ledPin4 = 7;
const int ledPin5 = 6;
const int ledPin6 = 5;
const int ledPin7 = 4;
int potmeterWaarde = 0;
int mapWaarde = 0;

void setup()
{
  //zet alle pinmodes als OUTPUT zodat de lampjes aankunnen
  pinMode(ledPin1, OUTPUT);
  pinMode(ledPin2, OUTPUT);
  pinMode(ledPin3, OUTPUT);
  pinMode(ledPin4, OUTPUT);
  pinMode(ledPin5, OUTPUT);
  pinMode(ledPin6, OUTPUT);
  pinMode(ledPin7, OUTPUT);
}

void loop()
{
  //Leest de stand van de potmeter en slaat op in variabele
  potmeterWaarde = analogRead(potPin);
  //potmeterwaarde kan als laagste 0 zijn en als hoogste 1023
  //dit wordt in vergelijking gezet met 0 en 7 Het aantal lampjes
  //Het resultaat hiervan wordt opgeslagen in variabele mapWaarde
  mapWaarde = map(potmeterWaarde, 0, 1023, 0, 7);

  //if statements doorloopt welke mapwaarde het is, en zet alle lampjes aan
  //die voldoen aan de statement. Hoe hogen de mapwaarde, hoe meer lampjes
  //er aan gaan of vervolgens weer uit gaan als de mapwaarde weer lager wordt
  // dus bij het terugdraaien van de potmeter
  if(mapWaarde >= 1){
    digitalWrite(ledPin1, HIGH);
  }else{
    digitalWrite(ledPin1, LOW);
  }
  if(mapWaarde >= 2){
    digitalWrite(ledPin2, HIGH);
  }else{
    digitalWrite(ledPin2, LOW);
  }
    if(mapWaarde >= 3){
    digitalWrite(ledPin3, HIGH);
  }else{
    digitalWrite(ledPin3, LOW);
  }
  if(mapWaarde >= 4){
    digitalWrite(ledPin4, HIGH);
  }else{
    digitalWrite(ledPin4, LOW);
  }
  if(mapWaarde >= 5){
    digitalWrite(ledPin5, HIGH);
  }else{
    digitalWrite(ledPin5, LOW);
  }
    if(mapWaarde >= 6){
    digitalWrite(ledPin6, HIGH);
  }else{
    digitalWrite(ledPin6, LOW);
  }
  if(mapWaarde >= 7){
    digitalWrite(ledPin7, HIGH);
  }else{
    digitalWrite(ledPin7, LOW);
  }
}
