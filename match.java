import java.awt.*;
import javax.swing.*;
import java.sql.*; 
import java.awt.event.ActionListener ;
import java.awt.event.ActionEvent ;
import java.awt.event.ItemListener;
import static javax.swing.JOptionPane.showMessageDialog;
public class match implements ActionListener
{
  JButton btan ;  
  JTextField tf1;
    JTextField tf2 ;
    JButton bt1 ; 
    JFrame frame ;
    String ch1,ch2,ch3,ch4,eq1,eq2 ; 
    String sc1=""; 
    String sc2="" ;
    String a,nm,ct;
    JButton btn,btr11,btr12,btr3,r3b[];
    int ind ,r2et[],r3[] ; 
    public match(String a,JButton btn,JButton btr11,JButton btr12,int ind,int []r2et,JButton btr3,JButton[]r3)
    {
      if(a.equals("15")==false)
        {this.r2et =r2et ;
      r3b = r3 ;
      this.btr3 = btr3; }
      this.ind = ind ; 

      this.btr11=btr11 ;
      this.btr12=btr12 ;
      btan = new JButton("Annuler"); 
      btan.addActionListener(this);
      this.btn = btn ;  
      this.a = a;
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wc2022","root","");
          String s= "SELECT * from tournoi where code_m="+a ;
          PreparedStatement ps = conn.prepareStatement(s);
          ResultSet rs1 = ps.executeQuery();
          while(rs1.next())
            {   
          ch1= rs1.getString("tour");
             ch2= rs1.getString("date");
             ch3= rs1.getString("stade");
             ch4= rs1.getString("spectateur");
             eq1= rs1.getString("equipe1");
             eq2= rs1.getString("equipe2");
            nm= rs1.getString("next_m");
            ct= rs1.getString("cote");

            }
      
        }catch (Exception e){e.printStackTrace();}
        JLabel lb1=new JLabel() ;
        if(ch1.equals("1/8"))
            lb1=new JLabel("Coupe du monde 2022 Qatar :Huitièmes de finale",SwingConstants.CENTER);
        else if(ch1.equals("1/4"))
            lb1=new JLabel("Coupe du monde 2022 Qatar :Quart de finale",SwingConstants.CENTER);
        else if(ch1.equals("1/2"))
            lb1=new JLabel("Coupe du monde 2022 Qatar :Demi-finale");
        else if(ch1.equals("1"))
           { lb1=new JLabel("Coupe du monde 2022 Qatar :finale");
           btn.setBackground(new Color(219, 190, 24));}
        lb1.setFont(new Font("Serif", Font.BOLD, 15));

       JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
       p1.add(lb1); 

      
       JLabel lb3 =new JLabel(new ImageIcon(eq1+".png"));

       JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
        tf1 = new JTextField(5); 
       JLabel lb4 = new JLabel("-"); 
        tf2 = new JTextField(5); 
       JLabel lb5 =new JLabel(new ImageIcon(eq2+".png"));
       JLabel lb6 = new JLabel(eq1);
       JLabel lb7 = new JLabel(eq2);

       ch2="Date : "+ch2 ; 
JLabel lb8 = new JLabel(ch2,SwingConstants.CENTER); 
lb8.setFont(new Font("Serif", Font.PLAIN, 15));

JLabel lb9 = new JLabel(ch3,SwingConstants.CENTER); 
lb9.setFont(new Font("Serif", Font.PLAIN, 15));

ch4="Nombre de spectateurs : "+ch4 ; 
JLabel lb10 = new JLabel(ch4,SwingConstants.CENTER); 
lb10.setFont(new Font("Serif", Font.PLAIN, 15));

JPanel p5 = new JPanel(new BorderLayout()); 
JPanel info = new JPanel(); 
info.setLayout(new GridLayout(3,1));
info.add(lb8); 
info.add(lb9); 
info.add(lb10); 
p5.add(info,BorderLayout.SOUTH); 

p2.add(lb5);
p2.add(lb7);
p2.add(tf2);

p2.add(lb4);
p2.add(tf1);
p2.add(lb6); 
p2.add(lb3);


tf1.addActionListener(this);
tf2.addActionListener(this);


p5.add(p2,BorderLayout.NORTH);
 JPanel pf = new JPanel(new FlowLayout(FlowLayout.CENTER));
 bt1 = new JButton("ajouter"); 
bt1.addActionListener(this); 
pf.add(bt1);
pf.add(btan); 
frame.add(p1,BorderLayout.NORTH);
frame.add(p5,BorderLayout.CENTER);
frame.add(pf,BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(450,250);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public boolean verif_scr(String x)
    {
      int i ;
      for (i=0;i<x.length();i++)
        if (Character.isAlphabetic(x.charAt(i))== true)
          return false ;
      return true ;
    }

    public void actionPerformed(ActionEvent e)
    {
     
     
      int taille =0 ,taille2=0;
      boolean et=true ;
      String win;  
      sc1= tf1.getText(); 
        sc2= tf2.getText(); 
       
          


        Object  src = e.getSource();
        if(src==btan)
     {
       frame.dispose();
       if(nm.equals("0")==false) 
       r2et[ind]--; 
     }
     else
     {
        if(verif_scr(sc1)==false || verif_scr(sc1)==false ||  sc1.equals(sc2))
        {showMessageDialog(null, "Resultat invalide");
        return ;}
        if(ch1.equals("1/8"))
          {taille=4 ; 
          taille2=8;}
            if(ch1.equals("1/4"))
          {taille=2 ;
            taille2=4; }
          if(ch1.equals("1/2"))
          {taille=1 ;
            taille2=2; }
     if(src==bt1) 
     {
       try {
         Class.forName("com.mysql.cj.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wc2022","root","");
       Statement stmt = conn.createStatement();
       
       


       String s1= "update tournoi set scr_a=\""+sc1+"\" where code_m="+a ;
       
        String s2= "update tournoi set scr_b=\""+sc2+"\" where code_m="+a ;
        String s3=""; 
        
        
        if( Integer.parseInt(sc1)> Integer.parseInt(sc2))
         {
          if(nm.equals("0")==false)
          s3 = "update tournoi set "+ct+" = \""+eq1+"\" where code_m ="+nm;
          btr12.setBackground(new Color(230, 78, 87));
         btr12.setOpaque(true);
         btr11.setBackground(new Color(64, 199, 64));
         btr12.setOpaque(true);
         btn.setText(eq1);
         win=eq1 ;             
        }
         else  
         {
          if(nm.equals("0")==false)
          s3 = "update tournoi set "+ct+" = \""+eq2+"\" where code_m ="+nm;
          btr11.setBackground(new Color(230, 78, 87));
         btr11.setOpaque(true);
         btr12.setBackground(new Color(64, 199, 64));
         btr12.setOpaque(true);
         btn.setText(eq2);
         win = eq2 ;         
      }
      if(nm.equals("0")==false)
      {
      if(ct.equals("equipe2"))
        btr3.setText(win+" - "+btr3.getText());
      else 
      btr3.setText(btr3.getText()+win);
      stmt.executeUpdate(s3);
      }
        
         stmt.executeUpdate(s1);
        stmt.executeUpdate(s2);

     }catch (Exception e2){e2.printStackTrace();}
     if(nm.equals("0")==false)
     {
     for(int i=0;i<taille2;i++)
      if(r2et[i]<1)
        et=false; 

    if (et==true) 
    {  
      if(r3b==null)
        btr3.setEnabled(true);
        else
        {
      for(int o=0;o<taille;o++)
        r3b[o].setEnabled(true);}} }
        
        showMessageDialog(null, "Resultat affécté avec succées");
     frame.dispose();   
    }
      

    
    }

    }
}