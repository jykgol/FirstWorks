import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.util.Calendar;

// Основной класс
public class MyApplet extends Applet implements ItemListener, ActionListener, Runnable
{		
		// Поток для рисования анимированного изображения
		Thread animThread = null;
		// Буферизированный символьный поток записи в файл
		BufferedWriter out;

		// Координаты изображения
		int textX = 0, textY = 0;
		// Направление движения
		int textDirectionX = 0, textDirectionY = 0;
		
		// Глобальные переменные
		Panel p, p1, p2, p3, p4, p5, p6;
		Canvas cn;
		Button b1, b2, b3;
		TextField tf1, tf2, tf3, tf4; 
		Choice ch1; 
		Label lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8;
		String temp, fileName = "";
		CheckboxGroup cbg1;
		List ls1; 
		TextArea fileText;

		  public void init()
		  {
			// Компоновка панелей в окне апплета
			setLayout(new GridLayout(3,3,1,1));

			//заполнение панели p
		    // ***********************************************************
			p = new Panel();
			p.setLayout(new GridLayout(4,1,40,15));
			p.setBackground( new Color(74,255,165));
			lb1 = new Label("Выберите цвет изображения:", Label.CENTER);
			lb1.setForeground(Color.black);
			p.add(lb1);
			
			ch1 = new Choice();
			ch1.addItem("Белый");
			ch1.addItem("Красный");
		    ch1.addItem("Розовый");
		    ch1.addItem("Зеленый");
		    ch1.addItem("Синий");
		    ch1.addItem("Желтый");
		    ch1.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent ie)
	{
		String temp = (String)ie.getItem();
		if (temp.equals("Зеленый"))
		{
			b1.setBackground(new Color (74,255,165));
			b2.setBackground(new Color (74,255,165));
		}
		else if (temp.equals("Белый"))
		{
			b1.setBackground(new Color (250,252,252));
			b2.setBackground(new Color (250,252,252));
		}
		else if (temp.equals("Красный"))
		{
			b1.setBackground(new Color (255,0,0));
			b2.setBackground(new Color (255,0,0));
		}
		else if (temp.equals("Синий"))
		{
			b1.setBackground(new Color (17,0,255));
			b2.setBackground(new Color (17,0,255));
		}
		else if (temp.equals("Желтый"))
		{
			b1.setBackground(new Color (208,255,0));
			b2.setBackground(new Color (208,255,0));
		}
		else if (temp.equals("Розовый"))
		{
			b1.setBackground(new Color (255,0,247));
			b2.setBackground(new Color (255,0,247));
		}
		
	}
			});
			p.add(ch1);
			
			lb2 = new Label("Введите текст", Label.CENTER);
			lb2.setForeground(Color.black);
			p.add(lb2);
			
			tf1 = new TextField("",20);
			tf1.setEditable(true);
			
			// Регистрация и реализация блока прослушивания событий от текстового поля
			tf1.addTextListener(new TextListener(){
				public void textValueChanged(TextEvent te)
				{
					temp = tf1.getText();
					tf3.setText(temp);
				}
			});
			p.add(tf1);
			
			// Добавление панели p в контейнер (окно апплета)
			add(p);
			
			//заполнение панели p1
			// ***********************************************************
			p1 = new Panel();
			p1.setLayout(new FlowLayout(FlowLayout.LEFT,25,40));
			p1.setBackground(new Color(255,255,191));
			
			 cbg1 = new CheckboxGroup();
			 Checkbox cb1,cb2,cb3,cb4;
			 cb1 = new Checkbox("Java",cbg1,true);
			 cb2 = new Checkbox("Apllet",cbg1,false);
			 cb3 = new Checkbox("Ok",cbg1,false);
			 cb4 = new Checkbox("Hello",cbg1,false);
			 
			 cb1.addItemListener(this);
			 cb2.addItemListener(this);
			 cb3.addItemListener(this);
			 cb4.addItemListener(this);
			
			p1.add(cb1);
			p1.add(cb2);
			p1.add(cb3);
			p1.add(cb4);
			
			// Добавление панели p1 в контейнер (окно апплета)			
			add(p1);
			
			//заполнение панели p2
			// ***********************************************************
			p2 = new Panel(); 
			p2.setLayout(new GridLayout(2,1,1,1));
			p2.setBackground( new Color(74,255,165));
			lb8 = new Label("Выберите цвет фона", Label.CENTER);
			p2.add(lb8);
			ls1 = new List(8,false);
			  ls1.add("Голубой");
			  ls1.add("Зеленый");
			  ls1.add("Светло-Серый");
			  ls1.add("Фиолетовый");
			  ls1.add("Оранжевый");
			  ls1.add("Розовый");
			  ls1.add("Белый");
			  ls1.add("Желтый");
			
			// Регистрация и реализация блока прослушивания 
			// событий от списка			  
			ls1.addItemListener(new ItemListener(){
		public void itemStateChanged(ItemEvent ie)
	{
		temp = ls1.getSelectedItem();
		if (temp.equals("Голубой"))
		{
			cn.setBackground(new Color (43,160,207));
		}
		else if (temp.equals("Зеленый"))
		{
			cn.setBackground(new Color (74,255,165));
		}
		else if (temp.equals("Светло-Серый"))
		{
			cn.setBackground(new Color (134,138,134));
		}
		else if (temp.equals("Фиолетовый"))
		{
			cn.setBackground(new Color (119,24,214));
		}
		else if (temp.equals("Розовый"))
		{
			cn.setBackground(new Color (232,84,225));
		}
		else if (temp.equals("Белый"))
		{
			cn.setBackground(new Color (255,255,255));
		}
		else if (temp.equals("Желтый"))
		{
			cn.setBackground(new Color (255,255,1));
		}
		else if (temp.equals("Оранжевый"))
		{
			cn.setBackground(new Color (255,111,0));
		}
		
	}
			});
			  
			p2.add(ls1);
			
			// Добавление панели p2 в контейнер (окно апплета)			
			add(p2);
			
			//заполнение панели p3
			// ***********************************************************
			p3 = new Panel();
			p3.setLayout(new GridLayout(3,1,1,1));
			p3.setBackground( new Color(255,255,128));
			
			lb6 = new Label("Действия:", Label.CENTER);
			lb6.setForeground(Color.black); 
			p3.add(lb6);
			
			b1 = new Button("Соединить");
			b1.addActionListener(this);
			
			b2 = new Button("Отчистить");
			b2.addActionListener(this);

			p3.add(b1);
			p3.add(b2);
			
			// Добавление панели p3 в контейнер (окно апплета)			
			add(p3);
			
			//заполнение панели p4
			// ***********************************************************
			p4 = new Panel();
			p4.setLayout(new GridLayout(7,1,1,1));
			p4.setBackground( new Color(0,236,118));
			
			lb3 = new Label("Первая строка:", Label.CENTER);
			lb3.setForeground(Color.black); 
			lb4 = new Label("+", Label.CENTER);
			lb4.setForeground(Color.black); 
			lb5 = new Label("Вторая строка", Label.CENTER);
			lb5.setForeground(Color.black); 
			lb7 = new Label("=", Label.CENTER);
			lb7.setForeground(Color.black); 

			tf2 = new TextField();
			tf2.setEditable(false);
			tf3 = new TextField();
			tf3.setEditable(false);
			tf4 = new TextField();
			tf4.setEditable(false);

			p4.add(lb3);
			p4.add(tf2);
			p4.add(lb4);
			p4.add(lb5);
			p4.add(tf3);
			p4.add(lb7);
			p4.add(tf4);
			
			// Добавление панели p4 в контейнер (окно апплета)			
			add(p4);
			
			//заполнение панели p5
			// ***********************************************************
			p5 = new Panel();
			p5.setLayout(new BorderLayout());
			
			//заполнение панели canvas
			// ***********************************************************
			cn = new Canvas(){
				// Рисование с использованием двойной буферизации для предотвращения мерцания
    	 Image buffer;  

		public void update(Graphics g)
   		{
        		paint(g);
   		}

			public void paint(Graphics g)
			{			
				buffer = createImage(getSize().width, getSize().height);
				drawString();
				g.drawImage(buffer,0,0,this);
			}
				
				private void drawString()
				{
					Graphics gc = buffer.getGraphics();	
					Font font = new Font("Tahoma",Font.BOLD|Font.ITALIC,textX);
					gc.setFont(font);
					gc.drawString(tf4.getText(),textX,textY);
				
				}
			};
			cn.setBackground(Color.white);
			p5.add(cn,BorderLayout.CENTER);						
			
			// Добавление панели p5 в контейнер (окно апплета)			
			add(p5);
			
			//заполнение панели p6 (журнал для записи информации о работе апплета)
			// ***********************************************************		
			p6 = new Panel();
			p6.setLayout(new BorderLayout());
			p6.setBackground(Color.yellow);
			fileText = new TextArea();
			fileText.setBackground(Color.white);
			p6.add(fileText, BorderLayout.CENTER);
			fileName = getParameter("FileName");
			if(fileName == null)
					fileName = "log.txt";
			b3 = new Button("Чтение файла-журнала");
			b3.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						// Сброс данных из буфера потока (запись в файл)
						out.flush();
						// Чтение из файла-журнала
						BufferedReader in = new BufferedReader(new FileReader(fileName));
						String s = "", line;
						while((line = in.readLine()) != null)
							s += line + "\n";
							fileText.setText(s);
							in.close();
					}
					catch(IOException ex)
					{
						fileText.setText("Ошибка чтения файла: " + "\n");
						fileText.append(ex.toString());
					}
			}});
			p6.add(b3, BorderLayout.NORTH);
			add(p6);
			try
			{
				// Создание буферизированного символьного потока записи в файл
				out = new BufferedWriter(new FileWriter(fileName));
			}
			catch(IOException ex)
			{
				fileText.setText("Ошибка при создании потока записи: " + "\n");
				fileText.append(ex.toString());
			}
			catch(SecurityException ex)
			{
				fileText.setText("Нет разрешения доступа к файлу: " + "\n");
				fileText.append(ex.toString());
				b3.setEnabled(false);
			}
			if(out != null)
			{
				Calendar c = Calendar.getInstance();
				String dateMessage = "Дата и время: " + c.get(Calendar.DAY_OF_MONTH) + "/" + 
				(c.get(Calendar.MONTH)+1) + "-" + c.get(Calendar.YEAR) + " " +
				c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE);
				writeMessage(dateMessage);
				writeMessage("Инициализация апплета завершена");
			}		
		}// конец метода init
	
 public void start()
 {
  animThread = new Thread(this);
  animThread.start();
  if(out != null)
	 {
		 writeMessage("Поток апплета запущен");
	 }
 }
 
 public void stop()
 {
  animThread = null;
  if(out != null)
	 {
		 writeMessage("Поток апплета остановлен");
	 }
 }

 public void destroy()
 {
	 if(out != null)
	 {
		 writeMessage("Выполнение апплета завершено");
		 try
		 {
			 out.close();
		 }
		 catch(IOException ex) {}
	 }
 }
 
 public void run()
 {
  Thread thisThread = Thread.currentThread();
  while (animThread!= null)
  {  
   try {
	    cn.repaint();  // перерисовка панели canvas
		thisThread.sleep(15); // приостановить поток
		moveText();   // изменение координат изображения
 
   
     
   } 
   catch (InterruptedException e) {
     return;                           // завершить поток
   }
  }
 }

 private void writeMessage(String message)
 {
	 try
	 {
		 out.write(message);
		 out.newLine();
	 }
	 catch(IOException ex)
	 {
		 fileText.setText("Ошибка записи в файл:" + "\n");
		 fileText.append(ex.toString());
	 }
 }
		 
 private void moveText()
 {
  if(textDirectionX == 0)  // движение вправо
   {
    textX++;
    if(textX == cn.getSize().width/3)
      textDirectionX = 1;  // изменение направления      
   } else
       {
        textX --;
        if(textX == 0)
           textDirectionX = 0;         
       }
   if(textDirectionY == 0) // движение вниз
   {
    textY ++;
    if( textY == cn.getSize().height)
      textDirectionY = 1;  // изменение направления
    } else
       {
        textY --;
        if (textY == 70)
          textDirectionY = 0;
       } 
 }
	
	// Реализация блока прослушивания событий от переключателей	
	public void itemStateChanged(ItemEvent ie)
	{
		String temp = (String)ie.getItem();
		if (temp.equals("Java"))
		tf2.setText(temp);
		else if(temp.equals("Apllet"))
		tf2.setText(temp);
		else if(temp.equals("Ok"))
		tf2.setText(temp);
		else if(temp.equals("Hello"))
		tf2.setText(temp);
	}
	
	// Реализация блока прослушивания событий от кнопок и текстового поля
		public void actionPerformed(ActionEvent te)
		{			
		 String ac = te.getActionCommand();
		 if ("Соединить".equals(ac))			 
			{
				temp = cbg1.getSelectedCheckbox().getLabel();
				String temp1 = tf3.getText();
				String concat = temp + temp1;
				tf2.setText(temp);
				tf4.setText(concat);
				b1.setEnabled(false);
				cn.repaint();	// Перерисовка окна апплета (панели canvas)
				start();
						
			}
		 else if ("Отчистить".equals(ac))
			{
				tf1.setText("");
				tf4.setText("");
				tf3.setText("");
				tf2.setText("");
				b1.setEnabled(true);
				cn.repaint();	// Перерисовка окна апплета (панели canvas)
				stop();
					
			}		 
		}
}
	



















