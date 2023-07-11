// Файл Lr21.java
// Лабораторная работы №2 "Классы в языке Java"
// ================================================================ 
// Данный апплет Lr21 обеспечивает создание и инициализацию массива
// на основе параметров из HTML-файла, а также вывод элементов 
// исходного массива в окно апплета.
// ================================================================ 
// Аналогичный массив создается и инициализируется при выполнении
// апплета Lr22, который , кроме того, выполняет обработку массива  
// в соответствии с заданием и выводит на экран результаты.
// ================================================================
// Класс Elem, обеспечивающий хранение данных типов int, String 
// и доступ к ним, и класс Array, предназначенный для хранения 
// массива объектов класса Elem и работы с массивом, представлены 
// в файле Lr22.java.
// ================================================================ 
// Выполнение апплетов Lr21 и Lr22, расположенных на одной HTML-
// странице, позволяет сравнить исходный массив с массивом,  
// полученным в результате обработки.
// ================================================================ 

import java.awt.*;
import java.awt.event.*;
import java.lang.*;

// Класс, производный от класса Applet
	public class Lr21 extends Canvas
{ 
 // Исходный массив для сравнения с результатами обработки
 Array  myArray21;
 // Флаг ошибки 
 int errf; 
 // Строки сообщения об ошибке     
 String msg, msgException = "";
 // Шрифты для вывода исходного массива
 Font fnt1, fnt2;
 
  // Строки для представления параметров апплета 
  String s1, s2, s3, s4, s5;
  // Переменные, используемые при разборе параметров апплета
  int b1 = 0, b2 = 0, e1 , e2;
  // Строка для представления извлекаемых из параметров  
  // данных типов int и String текущего злемента массива 
  String str;
  // Переменная для хранения данного типа int текущего злемента массива  
  int i, int1, int2;
 
	public Lr21 ()
{
 // Флаг инициализации массива  
  boolean flag = true;
  
  errf = 0;
  
  s1 = "6";
  s2 = "bbbb,aaHh,ccaaCc,ddddd,aa,ddaa";
  s3 = "40,-3,100,-60,21,34";
  s4 = "60";
  s5 = "258";

 /* fnt1 = new Font("Dialog", Font.BOLD, 14);
  fnt2 = new Font("Dialog", Font.PLAIN, 14);*/

 /* // Получение параметров апплета (исходных данных)
  s1 = getParameter("SIZE");
  s2 = getParameter("NUMBERS");
  s3 = getParameter("STRINGS");
  s4 = getParameter("INT1"); 
  s5 = getParameter("INT2");  */
  
  // Создание и инициализация массива
  if (s1 != null && s2 !=null && s3 != null && s4 != null && s5 != null)
    {  
      try { 
        i = Integer.parseInt(s1);
        myArray21 = new Array(i);
      }
      catch( Exception e) {
        msg = "Ошибка при указании размера массива:";
        msgException = e.toString(); 
        errf = 1;
        return; 
      } 
      // Разбор строк-параметров и добавление элементов в массив 
      while(flag)
      {
        try {
	    e1 = s2.indexOf(",", b1);
            if(e1 == -1) 
              {e1 = s2.length(); flag = false;}
            str = s2.substring(b1, e1);
            b1 = e1 + 1;
	    i = Integer.parseInt(str); 
	// Внимание!!!
	// Браузер (например, MS IE) может не поддерживать
	// методы parseType() некоторых классов-оболочек.
	// В этом случае следует воспользоваться другими
	// средствами для преобразования строкового
	// представления числа в данное простого типа.
	// Например, для значения переменной f типа float
	// используйте оператор :
	//   f = Float.valueOf(str). floatValue();
 
            e2 = s3.indexOf(",", b2);
            if(e2 == -1) 
              {e2 = s3.length(); flag = false;}
            str = s3.substring(b2, e2); 
            b2 = e2 + 1;
    
            myArray21.add(i, str);
        }
        catch( Exception e) {
            msg = "Ошибка при инициализации массива:";
 	    msgException = e.toString(); 
            errf = 1;
            return; 
        }
      }      
    }
  else 
    {
      msg = "Отсутствует параметр в файле .html"; 
      errf = 1;
    }
	//int1 = Integer.parseInt(s4);
	//int1 = Integer.parseInt(s5);
 }//конструктор

 public void paint(Graphics g)
 {          
    // Установка шрифта 
   g.setFont (new Font("TimesRoman", Font.BOLD, 16));
   
   if (errf == 0)
     {
      // Отображение в строке состояния браузера числа
      // инициализированных элементов массива

      showStatus("Lr21-realSize = " + myArray21.getRealSize());
      g.setFont(fnt1);
      g.drawString("Исходный массив:", 50, 25);
      g.setFont(fnt2);
      showArray(g, myArray21, 50);  
     }
   else 
     {
      g.drawString(msg, 50, 70);
      g.drawString(msgException, 50, 85);
     }
 }//paint

// Метод вывода элементов массива 
 void showArray(Graphics g, Array mas, int xpos)
 { 
  Elem element;
  for(int i = 0; i < mas.getRealSize(); i++)
    {
      element = mas.at(i);
      g.drawString("Элемент "+i+": " + element.getInt(), 
			xpos, 50 + 25*i);
      g.drawString(element.getStr(), xpos + 75, 60 + 25*i);
    }
 }//showArray
 // Точка хода в программу
 public static void main(String args[]) 
 {
  // Объявления и инициализация переменной типа GreetApplication
  Lr21 canvas = new Lr21 (args[0]);
   
  /* Метод setBackground наследуется от класса java.awt.Component.
     Этот метод устанавливает цвет фона компонента. 
  */
  canvas.setBackground(Color.white); 
  
  /* Шаблон для размещения компонента-"холста" в контейнере-окне
     -----------------------------------------------------------
     Объявления и инициализация переменной типа java.awt.Frame,
     размещение компонента в окне-фрейме,
     установка размеров окна,
     установка местоположения окна на экране,
     установка видимости окна на экране,
     регистрация приемника события закрытия окна.
  */
  Frame frame = new Frame("An AWT-Based Application");	
  frame.add(canvas);
  frame.setSize(425, 275);
  frame.setLocation(100, 100);
  frame.setVisible(true);
  frame.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e){
               System.exit(0);
       }
  });
 } 

}//Lr21
