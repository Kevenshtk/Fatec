int led_vermelho = 13;
int led_verde = 12;
int led_amarelo = 11;
char led;

void setup()
{ 
  pinMode(led_vermelho, OUTPUT);
  pinMode(led_verde, OUTPUT);
  pinMode(led_amarelo, OUTPUT);
  Serial.begin(9600);
}

void loop()
{
  if (Serial.available())
  { 
    led = Serial.read();
    
    if (led == 'Q')
    digitalWrite(led_vermelho, HIGH); // Acende led vermelho
    
    if (led == 'W')
    digitalWrite(led_verde, HIGH); // Acende led verde
    
    if (led == 'E')
    digitalWrite(led_amarelo, HIGH); // Acende led amarelo
    
    if (led == 'A')
    digitalWrite(led_vermelho, LOW); // Apaga led vermelho
    
    if (led == 'S')
    digitalWrite(led_verde, LOW); // Apaga led verde
    
    if (led == 'D')
    digitalWrite(led_amarelo, LOW); // Apaga led amarelo
  }
}