package College.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    main_class(){

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500,700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        JMenuBar mb= new JMenuBar();

        //new information

        JMenu newInfo= new JMenu("New Information");
        newInfo.setForeground(Color.black);
        mb.add(newInfo);

        JMenuItem facultyInfo=new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.white);
        facultyInfo.addActionListener(this);
        newInfo.add(facultyInfo);

        JMenuItem studentInfo= new JMenuItem("New Student Info");
        studentInfo.setBackground(Color.white);
        studentInfo.addActionListener(this);
        newInfo.add(studentInfo);

        //detailsss
        JMenu details= new JMenu("View Details");
        details.setForeground(Color.black);
        details.addActionListener(this);
        mb.add(details);

        JMenuItem facultydetails=new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.white);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdeatils= new JMenuItem("View Student Details");
        studentdeatils.setBackground(Color.white);
        studentdeatils.addActionListener(this);
        details.add(studentdeatils);

        //Leave
        JMenu leave= new JMenu("Leave Deatils");
        leave.setForeground(Color.black);
        mb.add(leave);

        JMenuItem facultyleave= new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.white);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);

        JMenuItem studentleave= new JMenuItem("Student Leave");
        studentleave.setBackground(Color.white);
        studentleave.addActionListener(this);
        leave.add(studentleave);


        //leave Deatils
        JMenu leaveDetails= new JMenu("Apply leave");
        leave.setForeground(Color.black);
        mb.add(leaveDetails);

        JMenuItem facultyleaveDetails= new JMenuItem("Faculty Leave Details");
        facultyleaveDetails.setBackground(Color.white);
        facultyleaveDetails.addActionListener(this);
        leaveDetails.add(facultyleaveDetails);

        JMenuItem studentleaveDetails= new JMenuItem("Student Leave Details");
        studentleaveDetails.setBackground(Color.white);
        studentleaveDetails.addActionListener(this);
        leaveDetails.add(studentleaveDetails);

        //Exam

        JMenu exam= new JMenu("Examination");
        exam.setForeground(Color.black);
        exam.addActionListener(this);
        mb.add(exam);

        JMenuItem examinationDetails= new JMenuItem("Examination Result");
        examinationDetails.setBackground(Color.white);
        examinationDetails.addActionListener(this);
        exam.add(examinationDetails);

        JMenuItem Entermarks= new JMenuItem("Enter Marks");
        Entermarks.setBackground(Color.white);
        Entermarks.addActionListener(this);
        exam.add(Entermarks);

       //update Info
        JMenu updateInfo= new JMenu("Update Deatils");
        updateInfo.setForeground(Color.black);
        updateInfo.addActionListener(this);
        mb.add(updateInfo);

        JMenuItem updateFacultyInfo= new JMenuItem("Update Faculty Details");
        updateFacultyInfo.setBackground(Color.white);
        updateFacultyInfo.addActionListener(this);
        updateInfo.add(updateFacultyInfo);

        JMenuItem updateStudentInfo= new JMenuItem("Update Student Details");
        updateStudentInfo.setBackground(Color.white);
        updateStudentInfo.addActionListener(this);
        updateInfo.add(updateStudentInfo);

        //fee

        JMenu fee= new JMenu("Fee Deatils");
        fee.setForeground(Color.black);
        fee.addActionListener(this);
        mb.add(fee);

        JMenuItem feeStructure= new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.white);
        feeStructure.addActionListener(this);
        fee.add(feeStructure);

        JMenuItem feeForm= new JMenuItem("Student Fee Form");
        feeForm.setBackground(Color.white);
        feeForm.addActionListener(this);
        fee.add(feeForm);

        //utility
        JMenu  utility= new JMenu("Utility");
        utility.setForeground(Color.black);
        utility.addActionListener(this);
        mb.add(utility);

        JMenuItem Calculator= new JMenuItem("Calculator");
        Calculator.setBackground(Color.white);
        Calculator.addActionListener(this);
        utility.add(Calculator);

        JMenuItem NotePad= new JMenuItem("NotePad");
        NotePad.setBackground(Color.white);
        NotePad.addActionListener(this);
        utility.add(NotePad);

        //About
        JMenu  about= new JMenu("About");
        about.setForeground(Color.black);
        about.addActionListener(this);
        mb.add(about);

        JMenuItem About= new JMenuItem("About Us");
        About.setBackground(Color.white);
        about.add(About);

        JMenuItem contact= new JMenuItem("Contact Us");
        contact.setBackground(Color.white);
        about.add(contact);

        //Notice
        JMenu  notice= new JMenu("Notice");
        notice.setForeground(Color.black);
        mb.add(notice);

        JMenuItem Notice= new JMenuItem("Notice");
        Notice.setBackground(Color.white);
        notice.add(Notice);

        //Exit
        JMenu  exit= new JMenu("Exit");
        exit.setForeground(Color.black);
        mb.add(exit);

        JMenuItem Exit= new JMenuItem("Exit");
        Exit.setBackground(Color.white);
        Exit.addActionListener(this);
        exit.add(Exit);

        JMenu  cb= new JMenu("ChatBot");
        cb.setForeground(Color.black);
        mb.add(cb);

        JMenuItem Cb= new JMenuItem("Chat With Us");
        Cb.setBackground(Color.white);
        Cb.addActionListener(this);
        cb.add(Cb);
        setJMenuBar(mb);
        setSize(1540,850);
        setTitle("Ambalika Institute of Management And Technology");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sm= e.getActionCommand();
        if(sm.equals("Exit")){
            System.exit(150);
        } else if (sm.equals("Calculator")) {
            try {
                    Runtime.getRuntime().exec("calc.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (sm.equals("NotePad")) {
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
            
        } else if (sm.equals("New Faculty Information")) {
            new AddFaculty();
            
        } else if (sm.equals("New Student Info")) {
            new AddStudent();
        } else if (sm.equals("View Faculty Details")) {
            new TeacherDeatils();
        } else if (sm.equals("View Student Details")) {
            new StudentDetails();
        } else if (sm.equals("Faculty Leave")) {
            new FacultyLeave();
        } else if (sm.equals("Student Leave")) {
            new StudentLeave();
        } else if (sm.equals("Faculty Leave Details")) {
            new TeacherLeaveDetail();

        } else if (sm.equals("Student Leave Details")) {
            new StudentLeaveDetail();
        } else if (sm.equals("Update Faculty Details")) {
            new UpdateTeacher();
        } else if (sm.equals("Update Student Details")) {
            new updateStudent();
        } else if (sm.equals("Enter Marks")) {
            new EnterMarks();
            
        } else if (sm.equals("Examination Result")) {
            new ExaminationDetail();
        } else if (sm.equals("Fee Structure")) {
            new FeeStructure();
        } else if (sm.equals("Student Fee Form")) {
            new StudentFeeForm();
        } else if (sm.equals("About us")) {
            new About();
        } else if (sm.equals("Chat With Us")) {
            new ChatBotGUI();
        }

    }

    public static void main(String[] args) {
        new main_class();
    }
}
