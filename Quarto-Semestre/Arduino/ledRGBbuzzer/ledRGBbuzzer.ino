int led = 0;
int led2 = 1;
int led3 = 2;
int led4 = 3;
int buzzer = 4;
float pot = A0;
float valor_lido = 0;

void setup() {
  pinMode(led, OUTPUT);
  pinMode(led2, OUTPUT);
  pinMode(led3, OUTPUT);
  pinMode(led4, OUTPUT);
  pinMode(buzzer, OUTPUT);
  pinMode(pot, OUTPUT);
}

void loop() {
  valor_lido = map(analogRead(pot), 0, 1023, 0, 2000);
  digitalWrite(led, 1);
  digitalWrite(led4, 1);
  digitalWrite(led2, 0);
  digitalWrite(led3, 0);
  tone(buzzer, 2000, 300);
  delay(valor_lido);

  digitalWrite(led, 0);
  digitalWrite(led4, 0);
  digitalWrite(led2, 1);
  digitalWrite(led3, 1);
  tone(buzzer, 2500, 300);
  delay(valor_lido);
}
