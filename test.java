import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;
import java.sql.*; 

class test extends JFrame implements ActionListener
 Color clr ; 
  JButton rcp,rtr ; 
JButton rtbl; 
 int test[]= new int[3];
  int r1et[] = new int[16]; 
 int r2et[] = new int[8]; 
 int r3et[] = new int[4]; 
 int r4et[] = new int[2]; 
  int winet; 
  huitieme h ;  
  match m ;
  JPanel [] pr1r2 = new JPanel[10];
    JPanel [] pr1r2r3 = new JPanel[5];
    JPanel [] pr1r2r3r4 = new JPanel[3];
    JPanel pcenter= new JPanel();
    JButton [] r1 = new JButton [20];
    JButton [] r2 = new JButton [20];
    JButton [] r3 = new JButton [20];
    JButton [] r4= new JButton [10];
    JButton winner = new JButton();
    JButton recherche = new JButton("RECHERCHER EQUIPE");
    JButton affichereq = new JButton("AFFICHER LES 32 EQUIPES ");
    JButton affichermatch= new JButton("AFFICHER LES MATCHES");
    JLabel Gestion = new JLabel("GESTION DES MATCHES COUPE DU MONDE QATAR 2022");

public test()
{
for(int i=0;i<16;i++)
r1et[i]=0;
for(int i=0;i<8;i++)
r2et[i]=0;
for(int i=0;i<4;i++)
r3et[i]=0;
for(int i=0;i<2;i++)
{r4et[i]=0;
  test[i]=0; }
winet=0; 

setTitle("Agent FIFA");
setSize(1500,700);
setLocationRelativeTo(null);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);
Gestion.setFont(new Font("Italic", Font.BOLD, 40));
Gestion.setForeground(Color.white);

//setLayout(new BorderLayout());
setContentPane(new JLabel(new ImageIcon("Quatar.jpg")));
setLayout(new FlowLayout());
add(Gestion);
//Just for refresh :) Not optional!
 
  pcenter.setLayout(new BorderLayout());
  pcenter.setSize(1000,500);
  /*Initialisation des boutons de r1 , r2 , r3 et r4 */
for (int i =0;i<16;i++){r1[i]= new JButton();r1[i].setPreferredSize(new Dimension(90, 30));r1[i].addActionListener(this);}
for (int i =0;i<8;i++){r2[i]= new JButton();r2[i].setPreferredSize(new Dimension(90, 30));r2[i].addActionListener(this);r2[i].setEnabled(false);}
for (int i =0;i<4;i++){r3[i]= new JButton();r3[i].setPreferredSize(new Dimension(90, 30));r3[i].addActionListener(this);r3[i].setEnabled(false);}
  r4[0]=new JButton();
  r4[0].setPreferredSize(new Dimension(90, 30));
  r4[0].addActionListener(this);
  r4[0].setEnabled(false);
  r4[1]=new JButton();
  r4[1].setPreferredSize(new Dimension(90, 30));
  r4[1].addActionListener(this);
  r4[1].setEnabled(false);
  winner= new JButton();
  winner.addActionListener(this);
  winner.setPreferredSize(new Dimension(90, 30));
  
  winner.setOpaque(true);
  winner.setEnabled(false);
/*initialisation des panels contenant r1 et r2*/
clr =  r4[0].getBackground();   
for(int i =0;i<8;i++)
  {
    pr1r2[i]=new JPanel();
    pr1r2[i].setLayout(new BorderLayout(2,2));
  }
  /*initialisation des panels contenant  pr1r2 et r3*/
  for(int i =0;i<4;i++)
  {
    pr1r2r3[i]=new JPanel();
    pr1r2r3[i].setLayout(new BorderLayout(2,2));
  }
  /*Initialisation de panel contenant pr1r2r3 et r4 */
  for(int i =0;i<2;i++)
  {
    pr1r2r3r4[i]=new JPanel();
    pr1r2r3r4[i].setLayout(new BorderLayout(2,2));
  }
  /*Ajouter les boutons du panel pr1r2*/
      pr1r2[0].add(r1[0],BorderLayout.EAST);
     pr1r2[0].add(r1[1],BorderLayout.WEST);
     pr1r2[0].add(r2[0],BorderLayout.SOUTH);

      pr1r2[1].add(r1[2],BorderLayout.EAST);
      pr1r2[1].add(r1[3],BorderLayout.WEST);
      pr1r2[1].add(r2[1],BorderLayout.SOUTH);

      pr1r2[2].add(r1[4],BorderLayout.EAST);
      pr1r2[2].add(r1[5],BorderLayout.WEST);
      pr1r2[2].add(r2[2],BorderLayout.SOUTH);

      pr1r2[3].add(r1[6],BorderLayout.EAST);
      pr1r2[3].add(r1[7],BorderLayout.WEST);
      pr1r2[3].add(r2[3],BorderLayout.SOUTH);

      pr1r2[4].add(r1[8],BorderLayout.EAST);
      pr1r2[4].add(r1[9],BorderLayout.WEST);
      pr1r2[4].add(r2[4],BorderLayout.SOUTH);

      pr1r2[5].add(r1[10],BorderLayout.EAST);
      pr1r2[5].add(r1[11],BorderLayout.WEST);
      pr1r2[5].add(r2[5],BorderLayout.SOUTH);

      pr1r2[6].add(r1[12],BorderLayout.EAST);
      pr1r2[6].add(r1[13],BorderLayout.WEST);
      pr1r2[6].add(r2[6],BorderLayout.SOUTH);

      pr1r2[7].add(r1[14],BorderLayout.EAST);
      pr1r2[7].add(r1[15],BorderLayout.WEST);
      pr1r2[7].add(r2[7],BorderLayout.SOUTH);


      /*remplir panel  pr1r2r3 */
      pr1r2r3[0].add(pr1r2[0],BorderLayout.EAST);
      pr1r2r3[0].add(pr1r2[1],BorderLayout.WEST);
      pr1r2r3[0].add(r3[0],BorderLayout.SOUTH);

      pr1r2r3[1].add(pr1r2[2],BorderLayout.EAST);
      pr1r2r3[1].add(pr1r2[3],BorderLayout.WEST);
      pr1r2r3[1].add(r3[1],BorderLayout.SOUTH);

      pr1r2r3[2].add(pr1r2[4],BorderLayout.EAST);
      pr1r2r3[2].add(pr1r2[5],BorderLayout.WEST);
      pr1r2r3[2].add(r3[2],BorderLayout.SOUTH);

      pr1r2r3[3].add(pr1r2[6],BorderLayout.EAST);
      pr1r2r3[3].add(pr1r2[7],BorderLayout.WEST);
      pr1r2r3[3].add(r3[3],BorderLayout.SOUTH);

      /*Remplir panel  pr1r2r3r4*/ 
      pr1r2r3r4[0].add(pr1r2r3[0],BorderLayout.EAST);
      pr1r2r3r4[0].add(pr1r2r3[1],BorderLayout.WEST);
      pr1r2r3r4[0].add(r4[0],BorderLayout.SOUTH);

      pr1r2r3r4[1].add(pr1r2r3[2],BorderLayout.EAST);
      pr1r2r3r4[1].add(pr1r2r3[3],BorderLayout.WEST);
      pr1r2r3r4[1].add(r4[1],BorderLayout.SOUTH);
      /*Panel finale qui contient tout les autres panels*/
      rcp = new JButton("recuperer"); 
      rtbl = new JButton("Retablir") ;
      rtr= new JButton("Retour"); 
      pcenter.add(pr1r2r3r4[0],BorderLayout.EAST);
      pcenter.add(pr1r2r3r4[1],BorderLayout.WEST);
      pcenter.add(winner,BorderLayout.SOUTH);

    JPanel p1 = new JPanel(new BorderLayout()); 
    p1.add(pcenter,BorderLayout.NORTH) ;

  

      add(p1,BorderLayout.CENTER); 
 
      add(rcp,BorderLayout.SOUTH) ;
      add(rtbl,BorderLayout.SOUTH);
      add(rtr,BorderLayout.SOUTH);

      setExtendedState(JFrame.MAXIMIZED_BOTH); 
rcp.addActionListener(this);
rtbl.addActionListener(this);
rtr.addActionListener(this);




  
  


  recherche.addActionListener(this);
  affichereq.addActionListener(this);
  affichermatch.addActionListener(this);

 
   }
   
   public void actionPerformed(ActionEvent e)
   {
    Object  src = e.getSource(); 
    String mt="",tr="",eq1="",eq2="" ,s1="",s2="",s3="";   
    

    int i=0,j=1,k=0,ind1=0,ind2=0,ind3=0,ind4=0,x=0;
      String ch1="",ch2="" ;
      boolean ok=true;
      int l=0; 
      if(src==rtr)
        dispose();
      
      if(src==rtbl)
      {
        for(int i3=0;i3<16;i3++)
r1et[i3]=0;
for(int i3=0;i3<8;i3++)
r2et[i3]=0;
for(int i3=0;i3<4;i3++)
r3et[i3]=0;
for(int i3=0;i3<2;i3++)
{r4et[i3]=0;
  test[i]=0; }
winet=0; 
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wc2022","root","");
        Statement stmt = conn.createStatement();
        Statement stmt2 = conn.createStatement();
  
          String s11= "update equipes set etat=0 " ;
          String s12="UPDATE tournoi set equipe1=\"\",equipe2=\"\",scr_a=\"\",scr_b=\"\" "  ;      
         stmt.executeUpdate(s11);
         stmt2.executeUpdate(s12);
      }catch (Exception e2){e2.printStackTrace();}
        for(int i1=0;i1<16;i1++)
          {r1[i1].setText("");
r1[i1].setBackground(clr);        }
        
        for(int i1=0;i1<8;i1++)
        {
          r2[i1].setText("");
          r2[i1].setEnabled(false);
          r2[i1].setBackground(clr); 
        }
        for(int i1=0;i1<4;i1++)
        {
          r3[i1].setText("");
          r3[i1].setEnabled(false);
          r3[i1].setBackground(clr); 
        }
        for(int i1=0;i1<2;i1++)
        {
          r4[i1].setText("");
          r4[i1].setEnabled(false);
          r4[i1].setBackground(clr); 
        }
        winner.setText("");
        winner.setEnabled(false);
        winner.setBackground(clr);
      }
      
      if(src==rcp)
      {
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wc2022","root","");
        for(int a=1;a<9;a++)
        {
        String s= "SELECT * from tournoi where code_m="+String.valueOf(a) ;
        PreparedStatement ps = conn.prepareStatement(s);
        ResultSet rs1 = ps.executeQuery();
        while(rs1.next())
          {   
            mt= rs1.getString("code_m");
            tr= rs1.getString("tour");
          
           eq1= rs1.getString("equipe1");
           eq2= rs1.getString("equipe2");
       
          s1= rs1.getString("scr_a");
          s2= rs1.getString("scr_b");
          }
            x=Integer.parseInt(mt) ;
            x--; 

            if(tr.equals("1/8"))
            {
              
              if(eq1.equals("")!=true)
                {
                  r1[x*2].setText(eq1);
                  r1et[x*2]++; 
                  ind1++;
                  ch2=r2[x].getText()+eq1 ;
                  r2[x].setText(ch2);
                }    
              if(eq2.equals("")!=true)
                {
                r1[x*2+1].setText(eq2);
                r1et[x*2+1]++;
                ind1++; 
                ch2=eq2+" - "+r2[x].getText();
                r2[x].setText(ch2);

                }
              if(s1.equals("")!=true)
              {
                ind2++; 
                if(Integer.parseInt(s1)<Integer.parseInt(s2))
                {
            
          r1[x*2].setBackground(new Color(230, 78, 87));
         r1[x*2].setOpaque(true);
         r1[x*2+1].setBackground(new Color(64, 199, 64));
         r1[x*2+1].setOpaque(true);
         r2[x].setText(eq2);
         r2et[x]++;
        }
         else  
         {   
        r1[x*2+1].setBackground(new Color(230, 78, 87));
        r1[x*2+1].setOpaque(true);
        r1[x*2].setBackground(new Color(64, 199, 64));
        r1[x*2].setOpaque(true);
        r2[x].setText(eq1);
        r2et[x]++;

       }
       
      
                }



              }

            


        }
        for(int k1=0;k1<8;k1=k1+2)
       {
        l=k1/2; 

          if(r2et[k1+1]==1) 
            r3[l].setText(r2[k1+1].getText()+" - ");
          if(r2et[k1]==1)//Occurrences(r2[k1].getText(),'-')==0) 
              r3[l].setText(r3[l].getText()+r2[k1].getText() );
         
       }
        if(ind1==16)
        {
          for(int i2=0;i2<8;i2++)
            r2[i2].setEnabled(true);
            
        }
        if(ind2==8)
        {
          for(int i2=0;i2<4;i2++)
            r3[i2].setEnabled(true);
        }

    
      }catch (Exception e3){e3.printStackTrace();}
      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wc2022","root","");
      for(int a=9;a<13;a++)
      {
      String s= "SELECT * from tournoi where code_m="+String.valueOf(a) ;
      PreparedStatement ps = conn.prepareStatement(s);
      ResultSet rs1 = ps.executeQuery();
      while(rs1.next())
        {   
          mt= rs1.getString("code_m");
          tr= rs1.getString("tour");
        
         eq1= rs1.getString("equipe1");
         eq2= rs1.getString("equipe2");
       
        s1= rs1.getString("scr_a");
        s2= rs1.getString("scr_b");
        }
          x=Integer.parseInt(mt) ;
          
          if(tr.equals("1/4"))
          {
            
            if(s1.equals("")!=true)
              {
                ind3++; 
                r3et[x-9]++; 
                if(Integer.parseInt(s1)>Integer.parseInt(s2))
                {
                r3[x-9].setText(eq1);
                r2[(x-9)*2+1].setBackground(new Color(230, 78, 87));
                r2[(x-9)*2+1].setOpaque(true);
                r2[(x-9)*2].setBackground(new Color(64, 199, 64));
                r2[(x-9)*2].setOpaque(true);
              }
              else
              {
                r3[x-9].setText(eq2);
                r2[(x-9)*2].setBackground(new Color(230, 78, 87));
                r2[(x-9)*2].setOpaque(true);
                r2[(x-9)*2+1].setBackground(new Color(64, 199, 64));
                r2[(x-9)*2+1].setOpaque(true);}
               
              }
              if(ind3==4)
        {
          for(int i2=0;i2<2;i2++)
            r4[i2].setEnabled(true);
        }
          }
        
      }
            
      for(int k1=0;k1<4;k1=k1+2)
      {
        l=k1/2; 
         if(r3et[k1+1]==1)//Occurrences(r3[k1+1].getText(),'-')==0) 
           r4[l].setText(r3[k1+1].getText()+" - ");
         if(r3et[k1]==1)//Occurrences(r3[k1].getText(),'-')==0) 
             r4[l].setText(r4[l].getText()+r3[k1].getText() );
        
      }
  
    }catch (Exception e3){e3.printStackTrace();}
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wc2022","root","");
    for(int a=13;a<15;a++)
    {
    String s= "SELECT * from tournoi where code_m="+String.valueOf(a) ;
    PreparedStatement ps = conn.prepareStatement(s);
    ResultSet rs1 = ps.executeQuery();
    while(rs1.next())
      {   
        
        mt= rs1.getString("code_m");
        tr= rs1.getString("tour");
      
       eq1= rs1.getString("equipe1");
       eq2= rs1.getString("equipe2");
     
      s1= rs1.getString("scr_a");
      s2= rs1.getString("scr_b");
      }
        x=Integer.parseInt(mt) ;
        
        if(tr.equals("1/2"))
        {
          
          if(s1.equals("")!=true)
            {
              ind4++; 
              r4et[x-13]++; 
              if(Integer.parseInt(s1)>Integer.parseInt(s2))
              {
              r4[x-13].setText(eq1);
              r3[(x-13)*2+1].setBackground(new Color(230, 78, 87));
              r3[(x-13)*2+1].setOpaque(true);
              r3[(x-13)*2].setBackground(new Color(64, 199, 64));
              r3[(x-13)*2].setOpaque(true);
            }
            else
            {
              r4[x-13].setText(eq2);
              r3[(x-13)*2].setBackground(new Color(230, 78, 87));
              r3[(x-13)*2].setOpaque(true);
              r3[(x-13)*2+1].setBackground(new Color(64, 199, 64));
              r3[(x-13)*2+1].setOpaque(true);}
              
            }
             
           

          if (ind4==2)
           { winner.setEnabled(true);
            winner.setBackground(new Color(219, 190, 24));}
        }
      
    }
    
       if(r4et[1]==1) 
         winner.setText(r4[1].getText()+" - ");
       if(r4et[0]==1) 
           winner.setText(winner.getText()+r4[0].getText() );
      
     


  }catch (Exception e3){e3.printStackTrace();}
  try {
    Class.forName("com.mysql.cj.jdbc.Driver");
  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wc2022","root","");
  
  String s= "SELECT * from tournoi where code_m="+"15" ;
  PreparedStatement ps = conn.prepareStatement(s);
  ResultSet rs1 = ps.executeQuery();
  while(rs1.next())
    {   
      mt= rs1.getString("code_m");
      tr= rs1.getString("tour");
    
     eq1= rs1.getString("equipe1");
     eq2= rs1.getString("equipe2");
    
    s1= rs1.getString("scr_a");
    s2= rs1.getString("scr_b");
    }
      x=Integer.parseInt(mt) ;
      
      
        if(s1.equals("")!=true)
          {
            
            if(Integer.parseInt(s1)<Integer.parseInt(s2))
            {
            winner.setText(eq2);
           r4[0].setBackground(new Color(230, 78, 87));
            r4[0].setOpaque(true);
            r4[1].setBackground(new Color(64, 199, 64));
            r4[1].setOpaque(true);
          }
          else
          {
            winner.setText(eq1);
            r4[1].setBackground(new Color(230, 78, 87));
            r4[1].setOpaque(true);
            r4[0].setBackground(new Color(64, 199, 64));
            r4[0].setOpaque(true);}
            
          
        
    
  }
        


}catch (Exception e3){e3.printStackTrace();}
      }
      else 
      {
      while(i<16 && ok)
      {       
        k++;
        if(j==3)
        j=1;
        if(src==r1[i]) 
          {
            r1et[i]++; 
            if(r1et[i]!=1)
              showMessageDialog(null, "Veuillez cliquer sur retablir");
            else 
            {
            l=i/2; 
            ch1=String.valueOf(l);
            l=Integer.parseInt(String.valueOf(ch1.charAt(0))); 
            h= new huitieme(String.valueOf(k),String.valueOf(j),r1[i],r2[l],r2,r1et,i);            
            }
          ok= false ;
          }
          else if(src==r2[i])
          {
            r2et[i]++;
            if(r2et[i]!=1)
              showMessageDialog(null, "Veuillez cliquer sur retablir");
            else 
      {
        l=i/2; 
        ch1=String.valueOf(l);
        l=Integer.parseInt(String.valueOf(ch1.charAt(0)));     
        m = new match(String.valueOf(i+1),r2[i],r1[i*2],r1[i*2+1],i,r2et,r3[l],r3);
      }
ok = false ; 
          }
          else if(src==r3[i])
          {
            r3et[i]++;
            if(r3et[i]!=1)
              showMessageDialog(null, "Veuillez cliquer sur retablir");
            else 
      {
        l=i/2; 
        ch1=String.valueOf(l);
        l=Integer.parseInt(String.valueOf(ch1.charAt(0)));     
        m = new match(String.valueOf(i+9),r3[i],r2[i*2],r2[i*2+1],i,r3et,r4[l],r4);
      }
      ok = false ;
          }
          else if(i<2 && src==r4[i])
          {
            r4et[i]++;
            if(r4et[i]!=1)
              showMessageDialog(null, "Veuillez cliquer sur retablir");
            else 
      {
        l=i/2; 
        ch1=String.valueOf(l);
        l=Integer.parseInt(String.valueOf(ch1.charAt(0)));     
        m = new match(String.valueOf(i+13),r4[i],r3[i*2],r3[i*2+1],i,r4et,winner,null);
      }
      ok = false ; 
          }
          else if(src==winner)
            {
              m= new match("15",winner,r4[0],r4[1],0,test,null,null);
             ok=false;
            }
          
          i++;
          j++; 
          if (j==2)
          k--; 
          
      }
        
    }
      
         
          
  }
  public static void main(String[] args) {
    new test() ;
  }
 }
