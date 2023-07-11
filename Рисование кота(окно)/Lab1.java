/* ����������� ����� ��� ��������� appletviewer
  ----------------------------------------------------
  <applet  code = Lab1 width = 650  height = 400>
  <param name = "AUTHOR" value = "�������� �.�">
  <param name = "THEME" value = "���">
  </applet>
  ----------------------------------------------------
*/

/* ���� Lab1.java
   ������������ ������ �1 "��������� � ���� �������"

   �������:
 ����������� ������, ������� ��������� ��������� ��������������
 ����������� ��������� ��������, � ����� ������� ���������� �� 
 ������ � ���� �������, ��������� ��������� �� HTML-�����.
   ���� �������: ���. 

   ��������: ������� ������ ���-612 �������� �.�.
*/
import java.awt.*;
import java.awt.event.*;

public class Lab1 extends Canvas{

 // ������ ��� �������� ���������� �������
    String author, theme; 

  public Lab1()
  {
	  author = "�������� �.�";
	  theme = "���"; 
  }
 
  public void paint(Graphics g) {
  
  // ��������� ������ 
   g.setFont (new Font("TimesRoman", Font.BOLD, 16));
 
 // �������� ����������� ������ ��� ��������� 
    Color col = new Color(211, 143, 54);      	// ���������
 	Color col2 = new Color(125, 74, 158);  		// ����������
	Color col3 = new Color(255, 255, 255); 		//�����
	Color col4 = new Color(0, 0, 0);  			//������
	Color col5 = new Color(255, 69, 0); 		// ����-�����
 
 // ������� ��������� ���������� ����
 // ������������ ������ ������� ���� ������� 		
	int xPol1[] = {350, 320, 280};
	int yPol1[] = {100, 65, 85};
	
	int xPol2[] = {430,400,463};
	int yPol2[] = {95,57,85};
	
 // ����� �����-��������� � ���� �������
	g.drawString("�����: " + author, 20, 25);
	g.drawString("����: " + theme, 20, 50);
	
 // ��������� ����� � ��������� �������� 
	g.setColor(col4);							//������ ����
	g.drawRoundRect(100,70,300,120,200,125);	//��������
	g.drawArc(95,30, 35, 80, -75, 180);			//�����	
	g.drawRoundRect(165,150,20,50,200,125);		//����
	g.drawRoundRect(320,150,20,50,200,125);
		 
 // ��������� ����� � ��������� ���
	g.setColor(col5);		 					//����-�����
	g.fillRoundRect(165,150,20,50,200,125);	
	g.fillRoundRect(320,150,20,50,200,125);
		 
 // ��������� ����� � ��������� 
	g.setColor(col);							//���������
	g.fillRoundRect(100,70,300,120,200,125);	//��������
	g.fillArc(95,30, 35, 80, -75, 180);         //�����  
	g.setColor(col5);							//����-�����
	g.fillPolygon(xPol1, yPol1, 3);				//���
	g.fillPolygon(xPol2, yPol2, 3);
	
 // ��������� ����� � ��������� ��������
	g.setColor(col4);							//������ ����
	g.drawPolygon(xPol1, yPol1, 3);				//���
	g.drawPolygon(xPol2, yPol2, 3);		 
	g.drawRoundRect(130,160,20,40,200,125);		//����
	g.drawRoundRect(345,160,20,40,200,125);
	
// ��������� ����� � ���������
	g.setColor(col);							//���������
	g.fillOval(300, 50, 140, 100);				//������
	g.setColor(col3);							//�����
	g.fillOval(335, 80, 10, 8);					//�����
	g.fillOval(380, 80, 10, 8);
	
 // ��������� ����� � ��������� ��������
	g.setColor(col4);							//������ ����
	g.fillOval(337, 83, 7, 5);
	g.fillOval(382, 83, 7, 5);
	g.drawOval(300, 50, 140, 100);				//������
	g.drawRoundRect(165,73,10,70,200,125);		
	g.drawRoundRect(205,70,10,90,200,125);
	g.drawRoundRect(245,70,10,75,200,125);
	g.fillOval(360, 97, 12, 7);					//���
	g.drawLine(365, 100, 365,107);
	g.drawLine(365, 107, 360,109);
	g.drawLine(365, 107, 370,109);
	g.drawLine(356, 100, 320,95);				//���
	g.drawLine(356, 103, 320,102);
	g.drawLine(356, 105, 320,110);
	g.drawLine(374, 100, 402,95);	
	g.drawLine(374, 103, 402,103);
	g.drawLine(374, 105, 402,110);
	
 // ��������� ����� � ���������
	g.setColor(col5);		 					//����-�����
	g.fillRoundRect(130,160,20,40,200,125);		//����
	g.fillRoundRect(345,160,20,40,200,125);
	g.fillRoundRect(165,73,10,70,200,125);		
	g.fillRoundRect(205,70,10,90,200,125);
	g.fillRoundRect(245,70,10,75,200,125);
		
	}
// ����� ���� � ���������
 public static void main(String args[]) 
 {
  // ���������� � ������������� ���������� ���� Lab1
  Lab1 canvas = new Lab1 ();
   
  /* ����� setBackground ����������� �� ������ java.awt.Component.
     ���� ����� ������������� ���� ���� ����������. 
  */
     // ��������� ����� ���� ���� ������� � ������
   canvas.setBackground(new Color(255, 160, 122)); 
  
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
}

 