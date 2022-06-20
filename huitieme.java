import java.awt.*;
import javax.swing.*;
import java.sql.*; 
import java.awt.event.ActionListener ;
import java.awt.event.ActionEvent ;
import java.awt.event.ItemListener;
import static javax.swing.JOptionPane.showMessageDialog;
public class huitieme implements ActionListener
{
  
  JButton btan ; 
  JButton btn; 
  JFrame frame ;
  String eq ="";
  JButton bt ;
  String chmp ;
  JComboBox<String> jcb ; 
  String x =""; 
  String s3="";
  JButton btn2 ;
  JButton[] r2 ;
  int[] r1et;
  int ind ; 
  public huitieme(String x,String chmp,JButton btn,JButton btn2,JButton []r2,int []r1et,int ind)
  {
  this.ind  = ind ;
  btan = new JButton("Annuler");
  btan.addActionListener(this); 
    this.r2= r2 ;
    this.r1et=r1et; 
    this.btn = btn ;
    this.btn2 = btn2 ;
    this.x =x ;
    this.chmp=chmp ;
    jcb = new JComboBox<String>(); 
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wc2022","root","");
      PreparedStatement ps = conn.prepareStatement("select nom_equipe from equipes where etat=0");
      ResultSet rs1 = ps.executeQuery();
      while(rs1.next())
      {
        jcb.addItem(rs1.getString("nom_equipe"));
      }
    }catch (Exception e){e.printStackTrace();
  }
    

    frame = new JFrame();
    frame.setLayout(new GridLayout(3,1));

    JLabel label = new JLabel("Ajouter une equipe", SwingConstants.CENTER);
    label.setFont(new Font("Serif", Font.BOLD, 30));
    label.setForeground(Color.RED);
    label.setOpaque(true);

    JLabel label2 = new JLabel("Choisir une equipe :", SwingConstants.CENTER);
    label2.setFont(new Font("Serif", Font.PLAIN, 15));
    label2.setForeground(Color.BLACK);
    label2.setOpaque(true);

    JPanel p = new JPanel(); 
    p.setLayout(new FlowLayout());
    p.add(label2); 
    p.add(jcb);
    JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    p2.add(p);
    frame.setTitle("Ajouter une equipe");
    frame.add(label); 

    jcb.addActionListener(new ActionListener() {     
      @Override
      public void actionPerformed(ActionEvent e) {
        
        eq =jcb.getSelectedItem().toString();      
      }
    });    
    
    String ch1="" ;
    String ch2="" ;
    String ch3="" ;
    String ch4="" ;

    JPanel info = new JPanel(); 
    info.setLayout(new GridLayout(4,1));
    JPanel info2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wc2022","root","");
    String s= "SELECT * from tournoi where code_m="+x ;
    PreparedStatement ps = conn.prepareStatement(s);
    ResultSet rs1 = ps.executeQuery();
    while(rs1.next())
      {   
    ch1= rs1.getString("tour");
       ch2= rs1.getString("date");
       ch3= rs1.getString("stade");
       ch4= rs1.getString("spectateur");
      }

  }catch (Exception e){e.printStackTrace();}
  JLabel lb1 = new JLabel() ; 
  JLabel lb2  = new JLabel(); 
  JLabel lb3  = new JLabel(); 
  JLabel lb4  = new JLabel(); 

  if(ch1.equals("1/8"))
  lb1=new JLabel("Coupe du monde 2022 Qatar :Huitièmes de finale",SwingConstants.CENTER);
  else if(ch1.equals("1/4"))
  lb1=new JLabel("Coupe du monde 2022 Qatar :Quart de finale",SwingConstants.CENTER);
  else if(ch1.equals("1/2"))
  lb1=new JLabel("Coupe du monde 2022 Qatar :Demi-finale");
else if(ch1.equals("1"))
lb1=new JLabel("Coupe du monde 2022 Qatar :finale");
lb1.setFont(new Font("Serif", Font.PLAIN, 15));
 
ch2="Date : "+ch2 ; 
lb2 = new JLabel(ch2,SwingConstants.CENTER); 
lb2.setFont(new Font("Serif", Font.PLAIN, 15));

lb3 = new JLabel(ch3,SwingConstants.CENTER); 
lb3.setFont(new Font("Serif", Font.PLAIN, 15));

ch4="Nombre de spectateurs : "+ch4 ; 
lb4 = new JLabel(ch4,SwingConstants.CENTER); 
lb4.setFont(new Font("Serif", Font.PLAIN, 15));

JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
bt = new JButton("Ajouter");
bt.addActionListener(this);
p3.add(bt); 
p3.add(btan);
info.add(lb1);
info.add(lb2);
info.add(lb3);
info.add(lb4);
info2.add(info);

JPanel p4 = new JPanel();
BorderLayout brd = new BorderLayout(); 
p4.setLayout(brd);
p4.add(info2,BorderLayout.NORTH);
p4.add(p2,BorderLayout.CENTER);

frame.add(p4); 
frame.add(p3); 


frame.pack();
frame.setLocationRelativeTo(null);
frame.setSize(450,500);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void actionPerformed(ActionEvent e)
{
  String eq1="",eq2="" ; 
boolean et=true;
  String ch ;   
  Object  src = e.getSource(); 
    if(src==bt) 
    {
      if(eq=="")
      {    showMessageDialog(null, "Veuillez choisir une equipe");
    }
    else
    {
      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wc2022","root","");
      Statement stmt = conn.createStatement();
      Statement stmt2 = conn.createStatement();

        String s1= "update equipes set etat=1 where nom_equipe=\""+eq+"\"" ;
        String s2="update tournoi set equipe"+chmp+"=\""+eq+"\"where code_m="+x ;      
       stmt.executeUpdate(s1);
       stmt2.executeUpdate(s2);
        btn.setText(eq);
        
        if(chmp.equals("2"))
         {
          ch=eq+" - ";  
          btn2.setText(ch+btn2.getText()); 
        }
        else
          btn2.setText(btn2.getText()+eq);
        

    }catch (Exception e2){e2.printStackTrace();}
      
    
    
    showMessageDialog(null, "Equipe ajoutée avec succées");
    frame.dispose();
    for(int o=0;o<16;o++)
    if (r1et[o]<1)
      et=false; 
  if (et==true) 
  for(int o=0;o<8;o++)
  r2[o].setEnabled(true);
    }
  }
else if(src==btan)
  {frame.dispose();
    r1et[ind]--;
  } 


    
   }
  public String getEq() {
    return eq;
  }
  public void setEq(String eq) {
    this.eq = eq;
  }
 
}