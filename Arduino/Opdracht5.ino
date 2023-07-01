//Code van de volgende website is gebruikt bij het maken van de opdracht
//https://electronics.stackexchange.com/questions/260962/arduino-rgb-loop

int ledRood = 6;
int ledBlauw = 5;
int ledGroen = 3;

void setup()
{
  Serial.begin(9600);
  pinMode(ledRood, OUTPUT);
  pinMode(ledBlauw, OUTPUT);
  pinMode(ledGroen, OUTPUT);
}

//Variabele voor opslaan kleurwaarde
int Rood;
int Groen;
int Blauw;

void loop()
{
 //En al laatste doorloopt de loop de roodwaarde
 for (Rood = 0 ; Rood < 256 ; Rood++)
{
   //vervolgens doorloopt de loop hetzelfde maar dan met de groenwaarde
   for (Groen = 0 ; Groen < 256 ; Groen++)
   {
      //Loop begint bij blauw, doorloopt alle mogelijke opties
      for (Blauw = 0 ; Blauw < 256 ; Blauw++)
      {
        //spreekt functie aan om alle waardes van de loop ook
        //te laten zien door het led lampje
        changeColor(Rood, Groen, Blauw);
      }
   }
}
}
//Methode wordt aangesproken en krijgt de parameters mee van 
//de forloops
void changeColor(int roodValue, int groenValue, int blauwValue)
 {
  //Het instellen van de kleur
  analogWrite(ledRood, roodValue);
  analogWrite(ledBlauw, blauwValue);
  analogWrite(ledGroen, groenValue);

  //Om het uitlezen op de console makkelijker te maken zijn de kleuren
  //opgesplitst in verschillende prints
  Serial.print("Rood: ");
  Serial.println(roodValue);
  Serial.print("Groen: ");
  Serial.println(groenValue);
  Serial.print("Blauw: ");
  Serial.println(blauwValue);
  Serial.print("\n");
}
