//De sheets van les 2 zijn gebruikt als voorbeeld bij het schrijven van de code
//Analoge input voor temperatuur sensor
int Temp = A1;
int tempWaarde = 0;

void setup()
{
  //Start de seriele communicatie om de uitkomst van de sensor uit te lezen
  //in de console
  Serial.begin(9600);
  pinMode(Temp, INPUT);
}

void loop()
{
  //Uitlezen van temperatuur sensor en opslaan in variabele
  tempWaarde = analogRead(Temp);

  //Analoge waarde omzetten d.m.v. map functie om correcte temperatuur
  //als resultaat te krijgen. 
  tempWaarde = map(tempWaarde, 0, 1023, 0, 500);

  //Print zet de tekst in de console
  Serial.print("Temperatuur is graden celcius=");
  //println geeft de temperatuur weer die hiervoor is berekend
  Serial.println(tempWaarde);
  delay(500);
  
}
