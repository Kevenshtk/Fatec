int led = 2;
int sensor_presenca = 3;
int acionamento;

void setup() {
  pinMode(led, OUTPUT);
  pinMode(sensor_presenca, INPUT);
}

void loop() {
  acionamento = digitalRead(sensor_presenca);
  if (acionamento == 0){
    digitalWrite(led, 1);
  } else {
    digitalWrite(led, 0);
  }
}