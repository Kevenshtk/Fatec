int led = 12;
int botao = 10;
int buzzer = 9;
float valor = 0;

void setup() {
  pinMode(led, OUTPUT);
  pinMode(buzzer, OUTPUT);
  pinMode(botao, INPUT);

}

void loop() {
    valor = digitalRead(botao);
  
  if(valor){
    digitalWrite(led, 1);
    digitalWrite(buzzer, 1);
  } else {
    digitalWrite(led, 0);
    digitalWrite(buzzer, 0);
  }

}
