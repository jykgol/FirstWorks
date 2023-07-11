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
import java.awt.event.*;
import java.lang.*;

// �����, ����������� �� ������ Applet
	public class Lr21 extends Canvas
{ 
 // �������� ������ ��� ��������� � ������������ ���������
 Array  myArray21;
 // ���� ������ 
 int errf; 
 // ������ ��������� �� ������     
 String msg, msgException = "";
 // ������ ��� ������ ��������� �������
 Font fnt1, fnt2;
 
  // ������ ��� ������������� ���������� ������� 
  String s1, s2, s3, s4, s5;
  // ����������, ������������ ��� ������� ���������� �������
  int b1 = 0, b2 = 0, e1 , e2;
  // ������ ��� ������������� ����������� �� ����������  
  // ������ ����� int � String �������� �������� ������� 
  String str;
  // ���������� ��� �������� ������� ���� int �������� �������� �������  
  int i, int1, int2;
 
	public Lr21 ()
{
 // ���� ������������� �������  
  boolean flag = true;
  
  errf = 0;
  
  s1 = "6";
  s2 = "bbbb,aaHh,ccaaCc,ddddd,aa,ddaa";
  s3 = "40,-3,100,-60,21,34";
  s4 = "60";
  s5 = "258";

 /* fnt1 = new Font("Dialog", Font.BOLD, 14);
  fnt2 = new Font("Dialog", Font.PLAIN, 14);*/

 /* // ��������� ���������� ������� (�������� ������)
  s1 = getParameter("SIZE");
  s2 = getParameter("NUMBERS");
  s3 = getParameter("STRINGS");
  s4 = getParameter("INT1"); 
  s5 = getParameter("INT2");  */
  
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
 }//�����������

 public void paint(Graphics g)
 {          
    // ��������� ������ 
   g.setFont (new Font("TimesRoman", Font.BOLD, 16));
   
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
 // ����� ���� � ���������
 public static void main(String args[]) 
 {
  // ���������� � ������������� ���������� ���� GreetApplication
  Lr21 canvas = new Lr21 (args[0]);
   
  /* ����� setBackground ����������� �� ������ java.awt.Component.
     ���� ����� ������������� ���� ���� ����������. 
  */
  canvas.setBackground(Color.white); 
  
  /* ������ ��� ���������� ����������-"������" � ����������-����
     -----------------------------------------------------------
     ���������� � ������������� ���������� ���� java.awt.Frame,
     ���������� ���������� � ����-������,
     ��������� �������� ����,
     ��������� �������������� ���� �� ������,
     ��������� ��������� ���� �� ������,
     ����������� ��������� ������� �������� ����.
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
