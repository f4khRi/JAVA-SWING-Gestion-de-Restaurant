import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.NumberFormatException;

public class interf extends JFrame implements ActionListener, MouseListener{
	//fonts & Colors
    Font fontbtn = new Font("Courier", Font.BOLD,18); //font 4 buttons
    Font fontlbl = new Font("Verdana",Font.BOLD,14);  //font 4 lbls
    Font fontlbltitre = new Font("Verdana",Font.BOLD,28); //font of title
    Font fonttxt = new Font("Verdana",Font.BOLD,14); //font pour les txts ecrives par l'utilisateur
    Color col = new Color(0,0,213);  //Blue
    Color col2 = new Color(255,0,0); //Red
    
    //Adding image to JFrame
    ImageIcon image = new ImageIcon("icons/ffdnb.jpg");
    JLabel lblimg = new JLabel(image);  
    
    //Adding icons
    ImageIcon saveicon = new ImageIcon("icons/savee.png");
    JLabel lblsaveicon = new JLabel(saveicon,JLabel.LEFT); 
    ImageIcon moneyicon = new ImageIcon("icons/money.png");
    ImageIcon subtotalicon = new ImageIcon("icons/Sum.png");
    ImageIcon remiseicon = new ImageIcon("icons/rem.png");
    ImageIcon shipicon = new ImageIcon("icons/ship.png");
    JLabel lblshipicon = new JLabel(shipicon,JLabel.RIGHT); 
    ImageIcon sodaicon = new ImageIcon("icons/soda.png");
    ImageIcon ma9loubicon = new ImageIcon("icons/ma9loub.png");
    ImageIcon sandwichicon = new ImageIcon("icons/sandwich.png");
    ImageIcon pizzaicon = new ImageIcon("icons/pizza.png");
    ImageIcon unicon = new ImageIcon("icons/1.png");
    ImageIcon deuxicon = new ImageIcon("icons/2.png");
    ImageIcon troisicon = new ImageIcon("icons/3.png");



     //double array 4 aswem les repas
     double coutrepactuel;
     String newcout=new String("0");

     //Simple Menu
     JMenuBar menuBar = new JMenuBar();  
     JMenu help = new JMenu();
     JMenuItem open = new JMenuItem();
    
	//Titre
	JLabel lbltitre = new JLabel("RESTAURANT ElBARAKA [FAST-FOOD] ");
	
	
	// LES PANELS :
	JPanel p1,p2,p3,p4,p5,p6;
	//panel 1 
	JCheckBox pizza = new JCheckBox("Pizza");
	JCheckBox ma9loub = new JCheckBox("Ma9loub");
	JCheckBox sandwich = new JCheckBox("Sandwich");
	JTextField pizzatxt = new JTextField("0",4);
	JTextField ma9loubtxt = new JTextField("0",4);
	JTextField sandwichtxt = new JTextField("0",4);
	JLabel Drinks = new JLabel(" Drinks : ",sodaicon,JLabel.LEFT);
	String[] drinkslist = {"Choisir une boisson","Coca","Fanta","Boga","Appla","Chwips","Viva"};
	JComboBox cambodrinks = new JComboBox(drinkslist);
	
	
	//panel 2
	JLabel coutb = new JLabel("Coût boissons",unicon,JLabel.LEFT);
	JLabel coutrep = new JLabel("Coût de repas",deuxicon,JLabel.LEFT);
	JLabel coutliv = new JLabel("Coût livraison",troisicon,JLabel.LEFT);
	JTextField coutbtxt = new JTextField("0",4);
	JTextField coutreptxt = new JTextField("0",4);
	JTextField coutlivtxt = new JTextField("0",4);
	
	//panel 3
	JLabel SubTotal = new JLabel("Total ",subtotalicon,JLabel.LEFT);
	JLabel remise = new JLabel("Remise",remiseicon,JLabel.LEFT);
	JLabel Total = new JLabel("Total apres remise",moneyicon,JLabel.LEFT);
	JTextField subtotaltxt = new JTextField("",7);
	JTextField remisetxt = new JTextField("10 %",7);
	JTextField totaltxt = new JTextField("",7);
	
	//panel 4
	JButton btnTotal = new JButton("Total");
	JButton btnRecu = new JButton("Le reçu");
	JButton btnReset = new JButton("Reset");
	JButton btnQuitter = new JButton("Quitter");
	JButton btnRU = new JButton("RD/UP");
	JButton btnDel = new JButton("DEL");
	
	//panel 5
	JTextArea ta_recu = new JTextArea("",21,35); 
	JScrollPane scroll = new JScrollPane(ta_recu,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			                                     JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	//livraison checkbox :
	JCheckBox livraison = new JCheckBox("Livraison");

	//btn sauvegarder recu
	JButton btnsave = new JButton("Sauvegarder le recu (CRT)");
	

	//Constructeur	
	public interf()
	{

		this.setTitle("Gestion du restaurant App");
		this.setSize(1140,600);
		this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setResizable(false);
		this.setLayout(null);
		
		//TiTre
		lbltitre.setBounds(243, -50, 633, 190);
		lbltitre.setFont(fontlbltitre);
		this.add(lbltitre);
		

		
		//AbouT Greetz etc ..
		menuBar.add(help);
		help.setText("help");
		help.add(open);
		setJMenuBar(menuBar);
		open.setText("about");
		open.addActionListener(this);

		
		
		
		
		//PANEL 1 :
	    p1 = new JPanel();
        p1.setBounds(20, 100, 300, 150);
	    p1.setBorder(BorderFactory.createLineBorder(Color.black,4));
	    GridLayout gl = new GridLayout(4,2);
	    p1.setLayout(gl);
	    /*ma9loub.setIcon(ma9loubicon);*/  ma9loub.setFont(fontlbl);   p1.add(ma9loub);   p1.add(ma9loubtxt); ma9loubtxt.setForeground(col); ma9loubtxt.setFont(fonttxt);
	    /*sandwich.setIcon(sandwichicon);*/ sandwich.setFont(fontlbl);  p1.add(sandwich);  p1.add(sandwichtxt); sandwichtxt.setForeground(col); sandwichtxt.setFont(fonttxt); 
        /*pizza.setIcon(pizzaicon); */   pizza.setFont(fontlbl);     p1.add(pizza);     p1.add(pizzatxt);   pizzatxt.setForeground(col); pizzatxt.setFont(fonttxt);
        Drinks.setFont(fontlbl);    p1.add(Drinks);    p1.add(cambodrinks);
        
        this.add(p1);
        
        cambodrinks.addActionListener(this);
        ma9loub.addActionListener(this);
        sandwich.addActionListener(this);
        pizza.addActionListener(this);
        // ---------------------------------------
        
        //Between panel 1 and 2
        //le checkbox livraison
        lblshipicon.setBounds(100,260,25,20);
        this.add(lblshipicon);
        livraison.setFont(fontlbl);
        livraison.setBounds(130, 260,100,20);
        this.add(livraison); 
        
        livraison.addMouseListener(this);
        // ---------------------------------------
        
        //PANEL 2
        p2 = new JPanel();
        p2.setBounds(20, 290, 300, 150);
	    p2.setBorder(BorderFactory.createLineBorder(Color.black,4));
        p2.setLayout(new GridLayout(3,2));
        coutrep.setFont(fontlbl);  p2.add(coutrep);   p2.add(coutreptxt); coutreptxt.setForeground(col); coutreptxt.setFont(fonttxt);
        coutb.setFont(fontlbl);    p2.add(coutb);     p2.add(coutbtxt);  coutbtxt.setForeground(col); coutbtxt.setFont(fonttxt);
        coutliv.setFont(fontlbl);    p2.add(coutliv);   p2.add(coutlivtxt); coutlivtxt.setForeground(col); coutlivtxt.setFont(fonttxt);
        
        coutreptxt.setEditable(false);
        coutbtxt.setEditable(false);
        coutlivtxt.setEditable(false);
        
        this.add(p2);
        // ---------------------------------------
        
      //PANEL 3
        p3 = new JPanel();
        p3.setBounds(380, 100, 300, 339);
	    p3.setBorder(BorderFactory.createLineBorder(Color.black,4));
        p3.setLayout(new GridLayout(6,1));
        SubTotal.setFont(fontlbl);    p3.add(SubTotal);   p3.add(subtotaltxt); subtotaltxt.setForeground(col); subtotaltxt.setFont(fonttxt);
        remise.setFont(fontlbl);      p3.add(remise);     p3.add(remisetxt);   remisetxt.setForeground(col); remisetxt.setFont(fonttxt);
        Total.setFont(fontlbl);       p3.add(Total);   p3.add(totaltxt);       totaltxt.setForeground(col); totaltxt.setFont(fonttxt);
        
        subtotaltxt.setEditable(false);
        remisetxt.setEditable(false);
        totaltxt.setEditable(false);
        
        this.add(p3);
        // ---------------------------------------

        //PANEL 4
        p4 = new JPanel();
        p4.setBounds(20, 460, 660, 50);
	    p4.setBorder(BorderFactory.createLineBorder(Color.black,4));
	    FlowLayout fl = new FlowLayout();
	    fl.setHgap(15);
        p4.setLayout(fl);
        btnTotal.setFont(fontbtn);
        p4.add(btnTotal);
        btnTotal.addActionListener(this);
        btnRecu.setFont(fontbtn);
        p4.add(btnRecu);
        btnRecu.addActionListener(this);
        btnReset.setFont(fontbtn);
        p4.add(btnReset);
        btnReset.addActionListener(this);
        btnQuitter.setFont(fontbtn);
        p4.add(btnQuitter);
        btnQuitter.addActionListener(this);
        btnRU.setFont(fontbtn);
        p4.add(btnRU);
        btnRU.addActionListener(this);
        btnDel.setFont(fontbtn);
        p4.add(btnDel);
        btnDel.addActionListener(this);
        this.add(p4);
        // ---------------------------------------
        
        //PANEL 5
        p5 = new JPanel();
        p5.setBounds(710,100, 400, 410);
	    p5.setBorder(BorderFactory.createLineBorder(Color.black,4));
	    ta_recu.setBorder(BorderFactory.createDashedBorder(Color.BLUE));
	    ta_recu.setBackground(Color.lightGray);
	    ta_recu.setForeground(col);
	    //ta_recu.setFont(fonttxt);
	    ta_recu.setEditable(false);
	    //adding scroll
	    p5.add(scroll);  // ta is attached to the scroll 
        
	    
	    //save button :
	    lblsaveicon.setBounds(760, 457, 30, 40);
	    this.add(lblsaveicon);
	    
	    btnsave.setFont(fontbtn);
	    btnsave.setBounds(800, 457, 280, 40);
	    this.add(btnsave);
	    btnsave.addActionListener(this);
	    
		this.add(p5);
	     //----------------------------------------
		
		
		
		//Cover
		lblimg.setSize(1140,600);
		this.add(lblimg);

	}
	
	//----------------------------------------------------------------------
	//Events :
	//----------------------------------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		//Boutton Quitter
		if(obj.equals(btnQuitter)) {
            System.exit(0);
		                           }
		//Boutton Reset
		else if(obj.equals(btnReset)) {
			this.ma9loubtxt.setText("0");
			this.sandwichtxt.setText("0");
			this.pizzatxt.setText("0");
			this.coutreptxt.setText("0");
			this.coutbtxt.setText("0");
			this.coutlivtxt.setText("0");
			this.subtotaltxt.setText("0");
			//this.remisetxt.setText(null);
			this.totaltxt.setText(null);
			this.ta_recu.setText(null);
			this.ma9loub.setSelected(false);
			this.sandwich.setSelected(false);
			this.pizza.setSelected(false);
			this.livraison.setSelected(false);
		}
		
		 //Cambo drinks and coutbtxt the price of drink
		else if(obj.equals(cambodrinks)) {
			int fantaa=600;
			int cocaa=600;
			int bogaa =650;
			int aplaa=650;
			int chwipss=700;
			int vivaa=800;

			if(cambodrinks.getSelectedItem().equals("Coca") || cambodrinks.getSelectedItem().equals("Fanta") )
			{
			coutbtxt.setText(String.valueOf(cocaa));
			}
			else if(cambodrinks.getSelectedItem().equals("Boga") || cambodrinks.getSelectedItem().equals("Appla"))
			{
			coutbtxt.setText(String.valueOf(bogaa));
			}
			else if(cambodrinks.getSelectedItem().equals("Chwips"))
			{
				coutbtxt.setText(String.valueOf(chwipss));

			}
			else if(cambodrinks.getSelectedItem().equals("Viva"))
			{
				coutbtxt.setText(String.valueOf(vivaa));

			}
			else if(cambodrinks.getSelectedItem().equals("Choisir une boisson"))
			{
			coutbtxt.setText(null);	
			}
		
	   }
		
		//Total : cout repas + cout drink + cout livraison
		else if(obj.equals(btnTotal)) {
			int t1 = Integer.valueOf(coutbtxt.getText());
			int t2 = Integer.valueOf(coutreptxt.getText());
			int t3 = Integer.valueOf(coutlivtxt.getText());
	        int r = t1 + t2 + t3 ;
	        subtotaltxt.setText(String.valueOf(r));
	        //double tota = r - 0.1*r ;
	        int tot = (int) (r - 0.1*r);
	        totaltxt.setText(String.valueOf(tot));
			
		}
		
		//pizza checkbox 
		else if(obj.equals(pizza))
		{
			try{
			int c = Integer.valueOf(coutreptxt.getText());
			int piz = Integer.valueOf(pizzatxt.getText());
			int pizsoum = 3500;
			if(pizza.isSelected())
			{
			int pr = (piz * pizsoum) + c;
            System.out.println(pr);
			coutreptxt.setText(String.valueOf(pr));
		    }
			}catch(NumberFormatException ex){ 
			 System.out.println(ex.getMessage());
             System.out.println("Il faut entrer des entiers!");
             JOptionPane.showMessageDialog(null,"Il faut entrer des entiers!","ATTENTION",JOptionPane.ERROR_MESSAGE);}
		}
		
		//sandwich checkbox
		else if(obj.equals(sandwich))
		{
			try{
			int d = Integer.valueOf(coutreptxt.getText());
			int sand = Integer.valueOf(sandwichtxt.getText());
			int sandsoum = 2000;
			if(sandwich.isSelected())
			{
			int pri = (sand * sandsoum) + d;
            System.out.println(pri);
			coutreptxt.setText(String.valueOf(pri));
		    }
			}catch(NumberFormatException ex){ 
				 System.out.println(ex.getMessage());
	             System.out.println("Il faut entrer des entiers!");
	             JOptionPane.showMessageDialog(null,"Il faut entrer des entiers!","ATTENTION",JOptionPane.ERROR_MESSAGE);}

		} 
		
		//ma9loub checkbox
		else if(obj.equals(ma9loub))
		{
			try{
			int e = Integer.valueOf(coutreptxt.getText());
			int ma9 = Integer.valueOf(ma9loubtxt.getText());
			int ma9soum = 3800;
			if(ma9loub.isSelected())
			{
			int pric = (ma9 * ma9soum) + e;
            System.out.println(pric);
			coutreptxt.setText(String.valueOf(pric));
		    }
			}catch(NumberFormatException ex){ 
				 System.out.println(ex.getMessage());
	             System.out.println("Il faut entrer des entiers!");
	             JOptionPane.showMessageDialog(null,"Il faut entrer des entiers!","ATTENTION",JOptionPane.ERROR_MESSAGE);}

		}	
		
		//Button Recu
		else if(obj.equals(btnRecu))
		{
			int ma99 = Integer.valueOf(ma9loubtxt.getText());
			int sandd = Integer.valueOf(sandwichtxt.getText());
			int pizzaa = Integer.valueOf(pizzatxt.getText());
			String liiv=new String("YES");
			if(coutlivtxt.getText()=="0") liiv="NO";
            ta_recu.append("                   BIENVENUE DANS VOTRE RESTAURANT \n\n "
			+"\t          VENTE AU DETAIL\n\n"+" MA9LOUB \t                       QTE="
            +ma9loubtxt.getText()+"\t             PRIX="+ma99*3800+"\n SANDWICH \t                       QTE="
			+sandwichtxt.getText()+"\t             PRIX="+sandd*2000+"\n PIZZA \t                       QTE="
			+pizzatxt.getText()+"\t             PRIX="+pizzaa*3500+"\n---------------------------"
			+"----------------------------------------------------------------------"+"\n"+" TOTAL REP \t                           "
			+"----"+"\t             PRIX="+coutreptxt.getText()+"\n\n DRINK \t                       QTE="
			+"1"+"\t             PRIX="+coutbtxt.getText()+"\n LIVRAISON \t                           "
			+liiv+"\t             PRIX="+"3500"+"\n---------------------------"
			+"----------------------------------------------------------------------"+"\n\n"+" TOTAL  \t                           "
			+"----"+"\t             PRIX="+subtotaltxt.getText()+"\n---------------------------"
					+"----------------------------------------------------------------------"+"\n"+" TOTAL APR \t                           "
					+"----"+"\t             PRIX="+totaltxt.getText()+"\n\n"+"                   \t     MERCI DE VOTRE FIDELITE\n\n"
					+"                   RESTAURANT EL BARAKA VOUS REMERCIE\n\t             DE VOTRE VISITE");                          

		}
		
		//Boutton Sauvegarder le recu dans un fichier txt
		else if(obj.equals(btnsave))
		{
			
			JFileChooser save = new JFileChooser();
			int option = save.showSaveDialog(this);
			File file = new File(save.getSelectedFile().getPath());
			try
			{
			String source = ta_recu.getText();
			char buffer[] = new char[source.length()];
			source.getChars(0,source.length(),buffer,0);

			FileWriter f1= new FileWriter(file+".txt");
			for(int i=0;i<buffer.length;i++)
			{
			f1.write(buffer[i]);
			}
			f1.close();

			}
			catch(Exception ae1)
			{System.out.println(ae1);}
			
			
		}
		
		//About .. 
		else if(obj.equals(open))
		{
		about ab = new about();
		ab.setVisible(true);
		}
	
		//READ + UPDATE 
		else if(obj.equals(btnRU))
		{
			CRUD ru = new CRUD();
		}
		
		//DELETE
		else if(obj.equals(btnDel))
		{
			Del de = new Del();
		}
	
	
	}
	
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent me) {
	
	    Object objj = me.getSource();
	    //livraison Checkbox
		if(objj.equals(livraison)) 
		{
			int livr= 3500;
	        if(livraison.isSelected()) 
		       {
	    	   coutlivtxt.setText(String.valueOf(livr));
	           }
		    else 
               coutlivtxt.setText(null);	
		}
	}
		
		
			
		
	
 	//becuz of implement , mais on l'a pas utilise ..
    public void mouseEntered(MouseEvent me) {}
	public void mouseExited(MouseEvent me) {}
	public void mousePressed(MouseEvent me) {}
	public void mouseReleased(MouseEvent me) {}
	
	
	
	
	//Main :D
	public static void main(String[] argv)
	{
		interf ap = new interf();
		ap.setVisible(true);
		ap.ma9loubtxt.requestFocus();
	}




	









	

}
