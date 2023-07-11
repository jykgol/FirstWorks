  // Файл Lr22.java
// Лабораторная работы №2 "Классы в языке Java"
// ================================================================
// Задание
// ---------------------------------------------------------------- 
// Разработать:
// - Класс Elem для хранения данных типов int, String, обеспечив их 
// защиту и методы доступа.
// - Класс Array для хранения массива объектов класса Elem.
// Обеспечить методы работы с массивом. 
// - Класс, производный от класса Applet, который выполняет создание 
// и инициализацию массива на основе информации из HTML-файла,  
// а также обработку массива:
//  1) преобразование символов строк в символы нижнего регистра;
//  2) удаление элементов массива, в которых целочисленные данные 
//     не превышают среднего для массива значения;
//  3) в оставшихся элементах массива замена первого символа строки
//     первым символом самой длинной в массиве строки.
// 
// ================================================================ 
// Класс Elem, обеспечивающий хранение данных типов int, String 
// и доступ к ним, и класс Array, предназначенный для хранения 
// массива объектов класса Elem и работы с массивом, представлены 
// в данном файле Lr22.java.
// ================================================================
// Апплет Lr22 обеспечивает создание и инициализацию массива
// на основе параметров из HTML-файла, выполняет обработку массива  
// в соответствии с заданием и выводит на экран результаты.
// ================================================================ 
// Аналогичный массив создается и инициализируется при выполнении
// апплета Lr21, который выводит элементы этого исходного  
// массива в окно апплета.
// ================================================================ 
// Выполнение апплетов Lr21 и Lr22, расположенных на одной HTML-
// странице, позволяет сравнить исходный массив с массивом,  
// полученным в результате обработки.
// ================================================================ 

import java.awt.*;
import java.applet.*;
import java.lang.*;
//Класс для хранения данных типов int, String
class Elem
   {
     // Поля класса
     private int intField;
     private String strField;
       
     Elem (int i,String s)
       {intField = i;
	strField = s;}

     // Методы доступа к данным
     String getStr()
       {return strField;}

     int getInt()
       {return intField;}

     void setStr(String str)
       {strField=str;}
   }//Elem

//Класс для хранения массива объектов класса Elem
class Array
   {  
     // Поля класса
     private Elem arrElem[];
     private int realSize;   

     // Конструктор класса
     Array(int size)
       {arrElem = new Elem[size];	
        realSize = 0;
       }
     // Методы работы с массивом
     // ------------------------
     // Возвращает размер массива 
     int getSize()
       {return arrElem.length;}

     // Возвращает число действительных (с точки зрения класса
     // Array),т.е. инициализированных (добавленных) и далее 
     // неудаленных  элементов массива.
     int getRealSize()
       {return realSize;}

     // Возвращает указанный элемент массива 
     Elem at(int i)
       {return (arrElem[i]);}

     // Возвращает индекс элемента массива с указанными 
     // значениями данных типов int, String. 
     // Если такой элемент отсутствует,возвращает -1.
     int indexOf(int ival, String str) 
       {
        for (int k = 0; k < realSize; k++)
           if(arrElem[k].getInt() == ival && 
              str.equals(arrElem[k].getStr()))
              return k;
        return -1;
       }  
     // Данный метод indexOf(), не используемый в классе Lr22,
     // включен для демонстрации метода equals() класса 
     // String. Метод equals(), в отличие от оператора ==, 
     // сравнивает содержимое String-объектов, а не ссылки 
      //на них!

     // Добавляет в массив элемент с указанными значениями
     // данных типов int, String  
     void add(int i,String s)                                  
        {arrElem[realSize] = new Elem(i, s); 
	    realSize++;
        }
     // Возвращает индекс элемента массива с самой длинной
     // строкой.
     // Возвращает -1, если элементы массива отсутствуют.
      int great()
        {int i, index,lenStr,lenMax = 0;
         if(realSize == 0)
	   return -1;
         for(i = index = 0; i < realSize; i++)
             {lenStr = (arrElem[i].getStr()).length();
              if (lenStr > lenMax)
    		       {lenMax = lenStr; index = i;}
             }
         return index;
        }
	// Возвращает индекс элемента массива с самой короткой 
	// строкой
	// Возвращает -1, если элементы массива отсутствуют.
		
		int min()
        {int i, index, lenStr, lenMin = Integer.MAX_VALUE;
         if(realSize == 0)
	   return -1;
         for(i = index = 0; i < realSize; i++)
             {lenStr = (arrElem[i].getStr()).length();
              if (lenStr < lenMin)
    		       {lenMin = lenStr; index = i;}
             }
         return index;
        }
     // Удаляет элементы массива, в которых целочисленные 
     // данные не превышают указанного значения 
     void delete(int j)
        {int i, k;
         for (i = k = 0;i < realSize; i++)
            if (arrElem[i].getInt() > j)
               arrElem[k++] = arrElem[i];
         realSize = k;
        } 	
	 // Удаляет элементы массива, в которых целочисленные 
     // данные находятся в указанном диапазоне
	 void delete(int a, int b)
        {int i, k;
         for (i = k = 0;i < realSize; i++)
            if (arrElem[i].getInt() < a || arrElem[i].getInt() > b)
               arrElem[k++] = arrElem[i];
         realSize = k;
        }
     // Обратите внимание! Элементы массива (ссылки на 
     // объекты типа Elem), не подлежащие удалению, просто 
     // переписываются в новую позицию, удаляемые элементы - 
     // пропускаются. Определяется новое число действительных
     // элементов массива.
   }//Array

// Основной класс, производный от класса Applet
public class Lr22 extends Applet
{
 Array  myArray22;              // массив для обработки  
 int errf = 0;                  // флаг ошибки      
 String msg, msgException = ""; // строки сообщения об ошибке 
 int sum;                       // сумма целочисленных данных элементов массива
 int index;                     // индекс злемента с самой длинной строкой
 Font fnt1, fnt2;               // шрифты для вывода результатов обработки
 
 public void init()
 {
  // Строки для представления параметров апплета 
  String s1, s2, s3, s4, s5;
  // Переменные, используемые при разборе параметров апплета
  int b1 = 0, b2 = 0, e1 , e2;
  // Переменные, используемые при инициализации и обработке массива
  String str, strMin; 
  int i, int1, int2;
  Elem elem;
  char ch;
  // Флаг инициализации массива  
  boolean flag = true;
  // Число инициализированных (действительных) элементов массива
  int rs;

  fnt1 = new Font("Dialog", Font.BOLD, 14);
  fnt2 = new Font("Dialog", Font.PLAIN, 14);

  // Получение параметров апплета LR21 (исходных данных).
  // Для этого используется объект контекста апплета.
  // Контекст апплета позволяет получить ссылку на апплет LR21,
  // расположеный на той же HTML-странице, по имени, указанному 
  // в атрибуте NAME: 
  
  Applet appLR21 = getAppletContext().getApplet("LR21");
  s1 = appLR21.getParameter("SIZE");
  s2 = appLR21.getParameter("NUMBERS");
  s3 = appLR21.getParameter("STRINGS");
  s4 = appLR21.getParameter("INT1"); 
  s5 = appLR21.getParameter("INT2");  
  int1 = Integer.parseInt(s4);
  int2 = Integer.parseInt(s5);
  // Создание и инициализация массива
  if (s1 != null && s2 !=null && s3 != null)
    {  
      try { 
        i = Integer.parseInt(s1);
        myArray22 = new Array(i);
      }
      catch( Exception e) {
        msg = "Ошибка при указании размера массива:";
        msgException = e.toString();  
        errf = 1;
        return; 
      } 
      // Разбор строк-параметров и добавление элементов в массив  
      while(flag){
        try {
	    e1 = s2.indexOf(",", b1);
            if(e1 == -1) 
              {e1 = s2.length(); flag = false;}
            str = s2.substring(b1, e1);
            b1 = e1 + 1;
	    i = Integer.parseInt(str);
        // Можно воспользоваться другими
	// средствами для преобразования строкового
	// представления в данное простого типа.
	// Например, значение переменной f типа float
	// можно получить, используя оператор:
	//   f = Float.valueOf(str).floatValue(); 

 
            e2 = s3.indexOf(",", b2);
            if(e2 == -1) 
              {e2 = s3.length(); flag = false;}
            str = s3.substring(b2, e2); 
            b2 = e2 + 1;
    
            // Обработка строк при инициализации:
            // преобразование символов строк в символы нижнего регистра
            str = str.toLowerCase(); 
            myArray22.add(i, str);
            }
        catch( Exception e) {
            msg = "Ошибка при инициализации массива:";
            msgException = e.toString();  
            errf = 1;
            return; 
           }
      }
       
      // Обработка массива в соответствии с заданием
      // ------------------------------------------------------------
      // Вычисление суммы целочисленных данных элементов массива      
      rs = myArray22.getRealSize();
      for(i = sum = 0; i < rs; i++)
         sum = sum + (myArray22.at(i)).getInt();

      // Удаление элементов массива, в которых целочисленные данные 
      // не превышают среднего для массива значения
       //  myArray22.delete(sum / rs);
		
	 // Удаление элементов массива, в которых целочисленные 
     // данные находятся в указанном диапазоне 
		 myArray22.delete(int1, int2);

      // В оставшихся элементах массива замена первого символа строки
      // первым символом самой длинной в массиве строки
     /* if ((rs = myArray22.getRealSize()) > 0)
          { index = myArray22.great();
            elem = myArray22.at(index);
            str = elem.getStr();
            ch = str.charAt(0);

            for(i = 0; i < rs; i++)
               if(i != index)
                 { elem = myArray22.at(i);
	           str = elem.getStr();
	           elem.setStr(ch + str.substring(1));
		 }
          } 
      // ------------------------------------------------------------
    }
  else 
    {
     msg = "Отсутствует параметр в файле .html"; 
     errf = 1;
    }*/
	// В оставшихся элементах массива удаление первого вхождения самой короткой строки 
    // массива как подстроки, если поле String не является самой короткой строкой

	if ((rs = myArray22.getRealSize()) > 0)
          { index = myArray22.min();
            elem = myArray22.at(index);
            str = elem.getStr();
			strMin=str;
        

            for(i = 0; i < rs; i++)
               if(i != index)
				 { elem = myArray22.at(i);  
	           str = elem.getStr();
	           if(str.startsWith(strMin) == true)
			    elem.setStr(str.substring(strMin.length(),str.length()));
				 }
          } 
      // ------------------------------------------------------------
    }
  else 
    {
     msg = "Отсутствует параметр в файле .html"; 
     errf = 1;
    }
}//init

public void paint(Graphics g)
 { int rs;
   Elem element;
   String s;
  
   if (errf == 0)
     {
      rs = myArray22.getRealSize();
      // Отображение в строке состояния браузера числа
      // действительных элементов массива
      showStatus("Lr22-realSize = " + rs);
      
      if (rs > 0)
         {
          g.setFont(fnt1);
          g.drawString("Результаты обработки:",50,25);
          g.setFont(fnt2);
          showArray(g, myArray22, 50);
          g.drawString("Сумма до обработки: "+sum,
			50, 70 + 25*rs);
    
          element = myArray22.at(index);
          s = element.getStr();
  
          g.drawString("Самая короткая строка: " + s, 50, 85 + 25*rs);
          g.drawString("Индекс самой короткой строки: " 
                  	+ index, 50, 100 + 25*rs);
         }
       else
           g.drawString("Массив после обработки пуст", 50, 70);       
    }
   else 
    {
     g.drawString(msg, 50, 70);
     g.drawString(msgException, 50, 85);
    }
 }//paint

// Метод вывода элементов массива 
 private void showArray(Graphics g, Array mas, int xpos)
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
}//Lr22
