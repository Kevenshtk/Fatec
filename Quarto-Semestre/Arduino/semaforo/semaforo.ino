int led = 0;
int led1 = 2;
int led2 = 4;
void setup() {
  pinMode (led, OUTPUT);
  pinMode (led1, OUTPUT);
  pinMode (led2, OUTPUT);
}



void loop() {
  digitalWrite (led, 1); 
  delay (1000);
  digitalWrite (led, 0);
  
  
  digitalWrite (led1, 1); 
  delay (2000);
  digitalWrite (led1, 0);

  digitalWrite (led2, 1); 
  delay (3000);
  digitalWrite (led2, 0);

}
