int buzzer1 = 8;
int buzzer2 = 7;
int R = 2;
int G = 3;
int B = 4;

void setup() {
  pinMode(buzzer1, OUTPUT);
  pinMode(buzzer2, OUTPUT);
  pinMode(R, OUTPUT);
  pinMode(G, OUTPUT);
  pinMode(B, OUTPUT);
}

void loop() {
  digitalWrite(R, 1);
  tone(buzzer1, 500, 300);
  tone(buzzer2, 500, 300);
  delay(300);

  digitalWrite(R, 0);
  digitalWrite(B, 1);
  tone(buzzer1, 2000, 300);
  tone(buzzer2, 2000, 300);
  delay(300);

}