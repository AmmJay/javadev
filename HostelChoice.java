import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class HostelChoice extends Frame{
    Label r,str,name,gen,host,add,det;
    TextField nametf,rtf;
    TextArea address,details;
    Button b;
    List stream;
    Checkbox male,fem,sn,jc,mar;
    public HostelChoice(String s)
    {
        super(s);
        setSize(350,700);
        setVisible(true);
        setLayout(null);

        name = new Label("1)Enter Name: ");
        name.setBounds(20,50,100,30);
        add(name);

        nametf = new TextField(30);
        nametf.setBounds(140,50,150,30);
        add(nametf);

        r = new Label("2)Enter Roll no.:");
        r.setBounds(20,90,100,30);
        add(r);

        rtf = new TextField(30);
        rtf.setBounds(140,90,150,30);
        add(rtf);

        add = new Label("3)Enter Address:");
        add.setBounds(20,120,100,40);
        add(add);

        address = new TextArea();
        address.setBounds(20,160,260,60);
        add(address);

        str= new Label("4)Stream:");
        str.setBounds(20,230,70,30);
        add(str);

        stream = new List(1,false);
        stream.add("CSE");
        stream.add("IT");
        stream.add("ECE");
        stream.add("AEIE");
        stream.add("EE");
        stream.add("CE");
        stream.setBounds(100,230,50,30);
        add(stream);

        gen = new Label("5)Gender:");
        gen.setBounds(20,270,60,30);
        add(gen);

       CheckboxGroup cg = new CheckboxGroup();
        male = new Checkbox("Male",cg,false);
        male.setBounds(100,270,50,30);
        add(male);

        fem = new Checkbox("Female",cg,false);
        fem.setBounds(170,270,60,30);
        add(fem);

        host = new Label("6)Hostel Preference:");
        host.setBounds(20,300,120,30);
        add(host);

        
        sn = new Checkbox("S.N. Bose Boys' Hostel");
        sn.setBounds(150,300,150,30);
        add(sn);

        jc= new Checkbox("J.C. Bose Boys' Hostel");
        jc.setBounds(150,330,170,30);
        add(jc);

        mar = new Checkbox("Madam Curie Girls' Hostel");
        mar.setBounds(150,360,170,30);
        

        male.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                if(male.getState())
                mar.setEnabled(false);
            }
        });
        fem.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                if(fem.getState())
               { sn.setEnabled(false);
                jc.setEnabled(false);
            }
        }});
        add(mar);

        det = new Label("YOUR DETAILS:");
        det.setBounds(20,480,100,50);
        details = new TextArea();
        details.setBounds(20,530,300,140);

        b = new Button("SUBMIT");
        b.setBounds(100,400,100,40);
        add(b);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                add(det);
                add(details);
                String genderselect = male.getState()?"Male":"Female";
                String hostelselect = ""; 
                if(jc.getState()){
                    hostelselect = hostelselect+jc.getLabel();
                    if(sn.getState())
                    hostelselect = hostelselect+sn.getLabel();
                }
                else if(mar.getState())hostelselect = mar.getLabel();
                details.setText("Name : "+nametf.getText()+"\nRoll No.: "+rtf.getText()+"\nAddress: "+address.getText()+"\nStream : " +stream.getSelectedItem()+"\nGender : "+genderselect+ "\nHostel Prefered: "+hostelselect );
            }
        });
       
        addWindowListener(new WindowAdapter(){
             public void windowClosing(WindowEvent e){
                dispose();
            }
        });
    }

    public static void main(String args[]){
       HostelChoice obj1 = new HostelChoice("Student Details");
    }
}
