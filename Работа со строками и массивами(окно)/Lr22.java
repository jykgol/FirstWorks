  // ���� Lr22.java
// ������������ ������ �2 "������ � ����� Java"
// ================================================================
// �������
// ---------------------------------------------------------------- 
// �����������:
// - ����� Elem ��� �������� ������ ����� int, String, ��������� �� 
// ������ � ������ �������.
// - ����� Array ��� �������� ������� �������� ������ Elem.
// ���������� ������ ������ � ��������. 
// - �����, ����������� �� ������ Applet, ������� ��������� �������� 
// � ������������� ������� �� ������ ���������� �� HTML-�����,  
// � ����� ��������� �������:
//  1) �������������� �������� ����� � ������� ������� ��������;
//  2) �������� ��������� �������, � ������� ������������� ������ 
//     �� ��������� �������� ��� ������� ��������;
//  3) � ���������� ��������� ������� ������ ������� ������� ������
//     ������ �������� ����� ������� � ������� ������.
// 
// ================================================================ 
// ����� Elem, �������������� �������� ������ ����� int, String 
// � ������ � ���, � ����� Array, ��������������� ��� �������� 
// ������� �������� ������ Elem � ������ � ��������, ������������ 
// � ������ ����� Lr22.java.
// ================================================================
// ������ Lr22 ������������ �������� � ������������� �������
// �� ������ ���������� �� HTML-�����, ��������� ��������� �������  
// � ������������ � �������� � ������� �� ����� ����������.
// ================================================================ 
// ����������� ������ ��������� � ���������������� ��� ����������
// ������� Lr21, ������� ������� �������� ����� ���������  
// ������� � ���� �������.
// ================================================================ 
// ���������� �������� Lr21 � Lr22, ������������� �� ����� HTML-
// ��������, ��������� �������� �������� ������ � ��������,  
// ���������� � ���������� ���������.
// ================================================================ 

import java.awt.*;
import java.applet.*;
import java.lang.*;
//����� ��� �������� ������ ����� int, String
class Elem
   {
     // ���� ������
     private int intField;
     private String strField;
       
     Elem (int i,String s)
       {intField = i;
	strField = s;}

     // ������ ������� � ������
     String getStr()
       {return strField;}

     int getInt()
       {return intField;}

     void setStr(String str)
       {strField=str;}
   }//Elem

//����� ��� �������� ������� �������� ������ Elem
class Array
   {  
     // ���� ������
     private Elem arrElem[];
     private int realSize;   

     // ����������� ������
     Array(int size)
       {arrElem = new Elem[size];	
        realSize = 0;
       }
     // ������ ������ � ��������
     // ------------------------
     // ���������� ������ ������� 
     int getSize()
       {return arrElem.length;}

     // ���������� ����� �������������� (� ����� ������ ������
     // Array),�.�. ������������������ (�����������) � ����� 
     // �����������  ��������� �������.
     int getRealSize()
       {return realSize;}

     // ���������� ��������� ������� ������� 
     Elem at(int i)
       {return (arrElem[i]);}

     // ���������� ������ �������� ������� � ���������� 
     // ���������� ������ ����� int, String. 
     // ���� ����� ������� �����������,���������� -1.
     int indexOf(int ival, String str) 
       {
        for (int k = 0; k < realSize; k++)
           if(arrElem[k].getInt() == ival && 
              str.equals(arrElem[k].getStr()))
              return k;
        return -1;
       }  
     // ������ ����� indexOf(), �� ������������ � ������ Lr22,
     // ������� ��� ������������ ������ equals() ������ 
     // String. ����� equals(), � ������� �� ��������� ==, 
     // ���������� ���������� String-��������, � �� ������ 
      //�� ���!

     // ��������� � ������ ������� � ���������� ����������
     // ������ ����� int, String  
     void add(int i,String s)                                  
        {arrElem[realSize] = new Elem(i, s); 
	    realSize++;
        }
     // ���������� ������ �������� ������� � ����� �������
     // �������.
     // ���������� -1, ���� �������� ������� �����������.
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
	// ���������� ������ �������� ������� � ����� �������� 
	// �������
	// ���������� -1, ���� �������� ������� �����������.
		
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
     // ������� �������� �������, � ������� ������������� 
     // ������ �� ��������� ���������� �������� 
     void delete(int j)
        {int i, k;
         for (i = k = 0;i < realSize; i++)
            if (arrElem[i].getInt() > j)
               arrElem[k++] = arrElem[i];
         realSize = k;
        } 	
	 // ������� �������� �������, � ������� ������������� 
     // ������ ��������� � ��������� ���������
	 void delete(int a, int b)
        {int i, k;
         for (i = k = 0;i < realSize; i++)
            if (arrElem[i].getInt() < a || arrElem[i].getInt() > b)
               arrElem[k++] = arrElem[i];
         realSize = k;
        }
     // �������� ��������! �������� ������� (������ �� 
     // ������� ���� Elem), �� ���������� ��������, ������ 
     // �������������� � ����� �������, ��������� �������� - 
     // ������������. ������������ ����� ����� ��������������
     // ��������� �������.
   }//Array

// �������� �����, ����������� �� ������ Applet
public class Lr22 extends Applet
{
 Array  myArray22;              // ������ ��� ���������  
 int errf = 0;                  // ���� ������      
 String msg, msgException = ""; // ������ ��������� �� ������ 
 int sum;                       // ����� ������������� ������ ��������� �������
 int index;                     // ������ �������� � ����� ������� �������
 Font fnt1, fnt2;               // ������ ��� ������ ����������� ���������
 
 public void init()
 {
  // ������ ��� ������������� ���������� ������� 
  String s1, s2, s3, s4, s5;
  // ����������, ������������ ��� ������� ���������� �������
  int b1 = 0, b2 = 0, e1 , e2;
  // ����������, ������������ ��� ������������� � ��������� �������
  String str, strMin; 
  int i, int1, int2;
  Elem elem;
  char ch;
  // ���� ������������� �������  
  boolean flag = true;
  // ����� ������������������ (��������������) ��������� �������
  int rs;

  fnt1 = new Font("Dialog", Font.BOLD, 14);
  fnt2 = new Font("Dialog", Font.PLAIN, 14);

  // ��������� ���������� ������� LR21 (�������� ������).
  // ��� ����� ������������ ������ ��������� �������.
  // �������� ������� ��������� �������� ������ �� ������ LR21,
  // ������������ �� ��� �� HTML-��������, �� �����, ���������� 
  // � �������� NAME: 
  
  Applet appLR21 = getAppletContext().getApplet("LR21");
  s1 = appLR21.getParameter("SIZE");
  s2 = appLR21.getParameter("NUMBERS");
  s3 = appLR21.getParameter("STRINGS");
  s4 = appLR21.getParameter("INT1"); 
  s5 = appLR21.getParameter("INT2");  
  int1 = Integer.parseInt(s4);
  int2 = Integer.parseInt(s5);
  // �������� � ������������� �������
  if (s1 != null && s2 !=null && s3 != null)
    {  
      try { 
        i = Integer.parseInt(s1);
        myArray22 = new Array(i);
      }
      catch( Exception e) {
        msg = "������ ��� �������� ������� �������:";
        msgException = e.toString();  
        errf = 1;
        return; 
      } 
      // ������ �����-���������� � ���������� ��������� � ������  
      while(flag){
        try {
	    e1 = s2.indexOf(",", b1);
            if(e1 == -1) 
              {e1 = s2.length(); flag = false;}
            str = s2.substring(b1, e1);
            b1 = e1 + 1;
	    i = Integer.parseInt(str);
        // ����� ��������������� �������
	// ���������� ��� �������������� ����������
	// ������������� � ������ �������� ����.
	// ��������, �������� ���������� f ���� float
	// ����� ��������, ��������� ��������:
	//   f = Float.valueOf(str).floatValue(); 

 
            e2 = s3.indexOf(",", b2);
            if(e2 == -1) 
              {e2 = s3.length(); flag = false;}
            str = s3.substring(b2, e2); 
            b2 = e2 + 1;
    
            // ��������� ����� ��� �������������:
            // �������������� �������� ����� � ������� ������� ��������
            str = str.toLowerCase(); 
            myArray22.add(i, str);
            }
        catch( Exception e) {
            msg = "������ ��� ������������� �������:";
            msgException = e.toString();  
            errf = 1;
            return; 
           }
      }
       
      // ��������� ������� � ������������ � ��������
      // ------------------------------------------------------------
      // ���������� ����� ������������� ������ ��������� �������      
      rs = myArray22.getRealSize();
      for(i = sum = 0; i < rs; i++)
         sum = sum + (myArray22.at(i)).getInt();

      // �������� ��������� �������, � ������� ������������� ������ 
      // �� ��������� �������� ��� ������� ��������
       //  myArray22.delete(sum / rs);
		
	 // �������� ��������� �������, � ������� ������������� 
     // ������ ��������� � ��������� ��������� 
		 myArray22.delete(int1, int2);

      // � ���������� ��������� ������� ������ ������� ������� ������
      // ������ �������� ����� ������� � ������� ������
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
     msg = "����������� �������� � ����� .html"; 
     errf = 1;
    }*/
	// � ���������� ��������� ������� �������� ������� ��������� ����� �������� ������ 
    // ������� ��� ���������, ���� ���� String �� �������� ����� �������� �������

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
     msg = "����������� �������� � ����� .html"; 
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
      // ����������� � ������ ��������� �������� �����
      // �������������� ��������� �������
      showStatus("Lr22-realSize = " + rs);
      
      if (rs > 0)
         {
          g.setFont(fnt1);
          g.drawString("���������� ���������:",50,25);
          g.setFont(fnt2);
          showArray(g, myArray22, 50);
          g.drawString("����� �� ���������: "+sum,
			50, 70 + 25*rs);
    
          element = myArray22.at(index);
          s = element.getStr();
  
          g.drawString("����� �������� ������: " + s, 50, 85 + 25*rs);
          g.drawString("������ ����� �������� ������: " 
                  	+ index, 50, 100 + 25*rs);
         }
       else
           g.drawString("������ ����� ��������� ����", 50, 70);       
    }
   else 
    {
     g.drawString(msg, 50, 70);
     g.drawString(msgException, 50, 85);
    }
 }//paint

// ����� ������ ��������� ������� 
 private void showArray(Graphics g, Array mas, int xpos)
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
}//Lr22
