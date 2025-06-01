int led = 12;
int botao = 10;
float valor = 0;

void setup() {
  pinMode(led, OUTPUT);
  pinMode(botao, INPUT);
}

void loop() {
  valor = digitalRead(botao);
  
  if(valor){
    digitalWrite(led, 1);
  } else {
    digitalWrite(led, 0);
  }

}
