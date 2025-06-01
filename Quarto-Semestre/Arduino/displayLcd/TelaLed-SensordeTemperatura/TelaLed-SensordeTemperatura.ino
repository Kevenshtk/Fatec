#include <LiquidCrystal.h>
 
const int rs = 3, en = 4, d4 = A2, d5 = A3, d6 = A4, d7 = A5;
LiquidCrystal lcd(rs, en, d4, d5, d6, d7);
int led = 10;
float sensor = A1;
float valor = 0;
float temp = 0;
 
void setup()
{
 pinMode(sensor, INPUT);
 pinMode (led, OUTPUT);
 Serial.begin(9600);
 lcd.begin(16, 2); //inicia o display de 2 linhas x 16 colunas
 lcd.setCursor(1, 1); //o curso fica na posição 1,1
lcd.print("Inicializando..."); //escreve mensagem no display
 delay (1000);
 lcd.clear(); //limpa a tela do display
 lcd.setCursor(2, 0);
lcd.print("Sistema OK!");
 delay (1000);
 lcd.clear();
}
void loop()
{
 valor = analogRead(sensor);
 temp = (valor * (552.7 / 1023.0)) -5;
 digitalWrite (led, 1);
 lcd.setCursor(0, 0);
 lcd.print("Temperatura: ");
 lcd.print(temp);
 Serial.println (temp);
 delay (1000);
 lcd.clear();
}
