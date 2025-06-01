#include <Servo.h>

int ledVerde = 11;
int ledVermelho = 12;

Servo servoMotor;

void setup() {
   pinMode(ledVerde, OUTPUT);
   pinMode(ledVermelho, OUTPUT);
   servoMotor.attach(A1);
   servoMotor.write(0);
}

void loop() {
  for(int i=0; i<=180; i=i+10)
  {
   servoMotor.write(i);
   delay(100);
   digitalWrite(ledVermelho, 0);
   digitalWrite(ledVerde, 1);
  }

  delay (1000);
  servoMotor.write(0);
  digitalWrite(ledVerde, 0);
  digitalWrite(ledVermelho, 1);
  delay(1000);
 }