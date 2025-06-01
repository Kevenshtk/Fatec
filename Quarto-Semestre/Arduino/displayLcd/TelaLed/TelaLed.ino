#include <LiquidCrystal.h>
 
const int rs = 3, en = 4, d4 = A2, d5 = A3, d6 = A4, d7 = A5;
LiquidCrystal lcd(rs, en, d4, d5, d6, d7);
int led = 10;
 
void setup()
{
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
 digitalWrite (led, 1);
 lcd.setCursor(0, 0);
 lcd.print("LED ligado");
 delay (1000);
 digitalWrite (led, 0);
 lcd.clear();
 lcd.setCursor(0, 1);
 lcd.print("LED desligado");
 delay (1000);
 lcd.clear();
}
