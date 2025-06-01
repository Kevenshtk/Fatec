int sensor= A0;
int led1 = 2;
int led2 = 3;
int led3 = 4;

void setup() {
  pinMode(sensor, INPUT);
  pinMode(led1, OUTPUT);
  Serial.begin(9600);

}

void loop() {
  
  delay(500);

  if(sensor < 50){
    digitalWrite(led1, 1);
  }

  if(sensor > 50){
    digitalWrite(led1, 0);
  }
}
