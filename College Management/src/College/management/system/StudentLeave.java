package College.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeave extends JFrame implements ActionListener {

    Choice choiceRollNo, choTime;
    JDateChooser seldate;
    JButton submit,cancel;

    StudentLeave(){


        getContentPane().setBackground(new Color(210,232,250));

        JLabel heading = new JLabel("Apply Leave (Student)");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel RollNoSE = new JLabel("Search By Roll No.");
        RollNoSE.setBounds(60,100,200,20);
        RollNoSE.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(RollNoSE);

        choiceRollNo = new Choice();
        choiceRollNo.setBounds(60,130,200,20);
        add(choiceRollNo);

        try{
           Conn c= new Conn();
           ResultSet resultSet = c.statement.executeQuery("select * from student");
           while(resultSet.next()){
               choiceRollNo.add(resultSet.getString("rollno"));
           }
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60,180,200,20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbldate);

        seldate = new JDateChooser();
        seldate.setBounds(60,210,200,25);
        add(seldate);

        JLabel time = new JLabel("Time");
        time.setBounds(60,260,200,20);
        time.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(time);

        choTime = new Choice();
        choTime.setBounds(60,290,200,20);
        choTime.add("Full Day");
        choTime.add("Half Day");
        add(choTime);

        submit= new JButton("SUBMIT");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel= new JButton("CANCEL");
        cancel.setBounds(250,350,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);



        setSize(500,550);
        setLocation(550,100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String rollno=choiceRollNo.getSelectedItem();
            String date=((JTextField) seldate.getDateEditor().getUiComponent()).getText();
            String time=choTime.getSelectedItem();

            String Q="insert into studentleave values('"+rollno+"','"+date+"','"+time+"')";
            try{
                Conn c= new Conn();
                c.statement.executeUpdate(Q);
                JOptionPane.showMessageDialog(null,"Leave Request Submitted");
                setVisible(false);

            }catch(Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentLeave();
    }
}
