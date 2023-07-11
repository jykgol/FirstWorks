/* Встраивание тегов для программы appletviewer
  ----------------------------------------------------
  <applet  code = Lab1 width = 650  height = 400>
  <param name = "AUTHOR" value = "Грохотов А.И">
  <param name = "THEME" value = "Кот">
  </applet>
  ----------------------------------------------------
*/

/* Файл Lab1.java
   Лабораторная работа №1 "Рисование в окне апплета"

   Задание:
 Разработать апплет, который выполняет рисование стилизованного
 изображения заданного предмета, а также выводит информацию об 
 авторе и теме рисунка, используя параметры из HTML-файла.
   Тема рисунка: кот. 

   Выполнил: студент группы КИБ-612 Грохотов А.И.
*/
import java.awt.*;
import java.applet.*;

public class Lab1 extends Applet{

 // Строки для хранения параметров апплета
    String author, theme; 

 // Координаты рисунка в окне апплета
  int x0, y0;

  public void init()
 {
 // Установка цвета фона окна апплета и шрифта
   setBackground(new Color(255, 160, 122));
   setFont(new Font("TimesRoman", Font.BOLD + Font.ITALIC, 16));
 
 // Получение параметров из HTML-файла
	author = getParameter("AUTHOR");
	theme = getParameter("THEME");
 
 // Вычисление координат левого верхнего угла рисунка
    x0 = (getWidth() - 500) / 2;
    y0 = (getHeight() - 250) / 2;
	
 }
 
  public void paint(Graphics g) {
	
	g.translate(x0, y0);
  
 // Создание собственных цветов для рисования 
    Color col = new Color(211, 143, 54);      	// оранжевый
 	Color col2 = new Color(125, 74, 158);  		// Фиолетовый
	Color col3 = new Color(255, 255, 255); 		//белый
	Color col4 = new Color(0, 0, 0);  			//чёрный
	Color col5 = new Color(255, 69, 0); 		// тёмно-рыжий
 
 // Массивы координат фрагментов кота
 // относительно левого вехнего угла рисунка 		
	int xPol1[] = {350, 320, 280};
	int yPol1[] = {100, 65, 85};
	
	int xPol2[] = {430,400,463};
	int yPol2[] = {95,57,85};
	
 // Вывод строк-сообщений в окно апплета
	g.drawString("Автор: " + author, 5, 6);
	g.drawString("Тема: " + theme, 5, 25);
	 
 // Вывод сообщения в строку состояния браузера
    showStatus("Апплет Lab1 - " + author); 
	
 // Установка цвета и рисование контуров 
	g.setColor(col4);							//чёрный цвет
	g.drawRoundRect(100,70,300,120,200,125);	//туловище
	g.drawArc(95,30, 35, 80, -75, 180);			//хвост	
	g.drawRoundRect(165,150,20,50,200,125);		//лапы
	g.drawRoundRect(320,150,20,50,200,125);
		 
 // Установка цвета и рисование лап
	g.setColor(col5);		 					//тёмно-рыжий
	g.fillRoundRect(165,150,20,50,200,125);	
	g.fillRoundRect(320,150,20,50,200,125);
		 
 // Установка цвета и рисование 
	g.setColor(col);							//оранжевый
	g.fillRoundRect(100,70,300,120,200,125);	//туловище
	g.fillArc(95,30, 35, 80, -75, 180);         //хвост  
	g.setColor(col5);							//тёмно-рыжий
	g.fillPolygon(xPol1, yPol1, 3);				//уши
	g.fillPolygon(xPol2, yPol2, 3);
	
 // Установка цвета и рисование контуров
	g.setColor(col4);							//чёрный цвет
	g.drawPolygon(xPol1, yPol1, 3);				//уши
	g.drawPolygon(xPol2, yPol2, 3);		 
	g.drawRoundRect(130,160,20,40,200,125);		//лапы
	g.drawRoundRect(345,160,20,40,200,125);
	
// Установка цвета и раскраска
	g.setColor(col);							//оранжевый
	g.fillOval(300, 50, 140, 100);				//голова
	g.setColor(col3);							//белый
	g.fillOval(335, 80, 10, 8);					//глаза
	g.fillOval(380, 80, 10, 8);
	
 // Установка цвета и рисование контуров
	g.setColor(col4);							//чёрный цвет
	g.fillOval(337, 83, 7, 5);
	g.fillOval(382, 83, 7, 5);
	g.drawOval(300, 50, 140, 100);				//головы
	g.drawRoundRect(165,73,10,70,200,125);		
	g.drawRoundRect(205,70,10,90,200,125);
	g.drawRoundRect(245,70,10,75,200,125);
	g.fillOval(360, 97, 12, 7);					//нос
	g.drawLine(365, 100, 365,107);
	g.drawLine(365, 107, 360,109);
	g.drawLine(365, 107, 370,109);
	g.drawLine(356, 100, 320,95);				//усы
	g.drawLine(356, 103, 320,102);
	g.drawLine(356, 105, 320,110);
	g.drawLine(374, 100, 402,95);	
	g.drawLine(374, 103, 402,103);
	g.drawLine(374, 105, 402,110);
	
 // Установка цвета и раскраска
	g.setColor(col5);		 					//тёмно-рыжий
	g.fillRoundRect(130,160,20,40,200,125);		//лапы
	g.fillRoundRect(345,160,20,40,200,125);
	g.fillRoundRect(165,73,10,70,200,125);		
	g.fillRoundRect(205,70,10,90,200,125);
	g.fillRoundRect(245,70,10,75,200,125);
		
	}
}
 