int trig = 13;
int echo = 12;
int led = 8;
float distancia;

void setup() {
  pinMode(trig, OUTPUT);
  pinMode(echo, INPUT);
  pinMode(led, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  digitalWrite(trig, 0);
  delay(0005);
  digitalWrite(trig, 1);
  delay(0010);
  digitalWrite(trig, 0);

  distancia = pulseIn(echo, 1);
  distancia = distancia/58;
  Serial.println(distancia);
  delay(1000);

  if(distancia >= 25 && distancia < 30) {
    digitalWrite(led, 1);
    delay(100);
    digitalWrite(led, 0);
  } else if(distancia >= 15 && distancia < 20) {
    digitalWrite(led, 1);
    delay(50);
    digitalWrite(led, 0);
  } else if(distancia < 15) {
    digitalWrite(led, 1);
    delay(100);
  } else {
    digitalWrite(led, 0);
  }
}