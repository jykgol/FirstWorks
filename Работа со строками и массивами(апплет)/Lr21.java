// ���� Lr21.java
// ������������ ������ �2 "������ � ����� Java"
// ================================================================ 
// ������ ������ Lr21 ������������ �������� � ������������� �������
// �� ������ ���������� �� HTML-�����, � ����� ����� ��������� 
// ��������� ������� � ���� �������.
// ================================================================ 
// ����������� ������ ��������� � ���������������� ��� ����������
// ������� Lr22, ������� , ����� ����, ��������� ��������� �������  
// � ������������ � �������� � ������� �� ����� ����������.
// ================================================================
// ����� Elem, �������������� �������� ������ ����� int, String 
// � ������ � ���, � ����� Array, ��������������� ��� �������� 
// ������� �������� ������ Elem � ������ � ��������, ������������ 
// � ����� Lr22.java.
// ================================================================ 
// ���������� �������� Lr21 � Lr22, ������������� �� ����� HTML-
// ��������, ��������� �������� �������� ������ � ��������,  
// ���������� � ���������� ���������.
// ================================================================ 

import java.awt.*;
import java.applet.*;
import java.lang.*;

// �����, ����������� �� ������ Applet
public class Lr21 extends Applet
{ 
 // �������� ������ ��� ��������� � ������������ ���������
 Array  myArray21;
 // ���� ������ 
 int errf = 0;
 // ������ ��������� �� ������     
 String msg, msgException = "";
 // ������ ��� ������ ��������� �������
 Font fnt1, fnt2;
 
 public void init()
 { 
  // ������ ��� ������������� ���������� ������� 
  String s1, s2, s3, s4, s5;
  // ����������, ������������ ��� ������� ���������� �������
  int b1 = 0, b2 = 0, e1 , e2;
  // ������ ��� ������������� ����������� �� ����������  
  // ������ ����� int � String �������� �������� ������� 
  String str;
  // ���������� ��� �������� ������� ���� int �������� �������� �������  
  int i, int1, int2;
  // ���� ������������� �������  
  boolean flag = true;

  fnt1 = new Font("Dialog", Font.BOLD, 14);
  fnt2 = new Font("Dialog", Font.PLAIN, 14);

  // ��������� ���������� ������� (�������� ������)
  s1 = getParameter("SIZE");
  s2 = getParameter("NUMBERS");
  s3 = getParameter("STRINGS");
  s4 = getParameter("INT1"); 
  s5 = getParameter("INT2");  
  // �������� � ������������� �������
  if (s1 != null && s2 !=null && s3 != null && s4 != null && s5 != null)
    {  
      try { 
        i = Integer.parseInt(s1);
        myArray21 = new Array(i);
      }
      catch( Exception e) {
        msg = "������ ��� �������� ������� �������:";
        msgException = e.toString(); 
        errf = 1;
        return; 
      } 
      // ������ �����-���������� � ���������� ��������� � ������ 
      while(flag)
      {
        try {
	    e1 = s2.indexOf(",", b1);
            if(e1 == -1) 
              {e1 = s2.length(); flag = false;}
            str = s2.substring(b1, e1);
            b1 = e1 + 1;
	    i = Integer.parseInt(str); 
	// ��������!!!
	// ������� (��������, MS IE) ����� �� ������������
	// ������ parseType() ��������� �������-��������.
	// � ���� ������ ������� ��������������� �������
	// ���������� ��� �������������� ����������
	// ������������� ����� � ������ �������� ����.
	// ��������, ��� �������� ���������� f ���� float
	// ����������� �������� :
	//   f = Float.valueOf(str). floatValue();
 
            e2 = s3.indexOf(",", b2);
            if(e2 == -1) 
              {e2 = s3.length(); flag = false;}
            str = s3.substring(b2, e2); 
            b2 = e2 + 1;
    
            myArray21.add(i, str);
        }
        catch( Exception e) {
            msg = "������ ��� ������������� �������:";
 	    msgException = e.toString(); 
            errf = 1;
            return; 
        }
      }      
    }
  else 
    {
      msg = "����������� �������� � ����� .html"; 
      errf = 1;
    }
	//int1 = Integer.parseInt(s4);
	//int1 = Integer.parseInt(s5);
 }//init

 public void paint(Graphics g)
 {          
   if (errf == 0)
     {
      // ����������� � ������ ��������� �������� �����
      // ������������������ ��������� �������

      showStatus("Lr21-realSize = " + myArray21.getRealSize());
      g.setFont(fnt1);
      g.drawString("�������� ������:", 50, 25);
      g.setFont(fnt2);
      showArray(g, myArray21, 50);  
     }
   else 
     {
      g.drawString(msg, 50, 70);
      g.drawString(msgException, 50, 85);
     }
 }//paint

// ����� ������ ��������� ������� 
 void showArray(Graphics g, Array mas, int xpos)
 { 
  Elem element;
  for(int i = 0; i < mas.getRealSize(); i++)
    {
      element = mas.at(i);
      g.drawString("������� "+i+": " + element.getInt(), 
			xpos, 50 + 25*i);
      g.drawString(element.getStr(), xpos + 75, 60 + 25*i);
    }
 }//showArray

}//Lr21
