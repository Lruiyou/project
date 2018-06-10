package 数据库课设;
/*注册界面*/
import myFont.tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame  implements ActionListener{
    JLabel l1,l2,l,l6;
    JTextField  text1,text2;
    JButton ok,no;
    dataModel mm;
    public  Register()
    {
        this.setLayout(null);
        Container ct=this.getContentPane();
        ct.setBackground(Color.LIGHT_GRAY);
        l=new JLabel("欢迎来到注册界面");
        l.setFont(tool.f2);
        l.setBounds(95,15,120,30);
        ct.add(l);
        l1=new JLabel("账号");
        l1.setFont(tool.f2);
        l1.setBounds(45,55,30,30);
        ct.add(l1);
        l2=new JLabel("密码");
        l2.setFont(tool.f2);
        l2.setBounds(45,100,30,30);
        ct.add(l2);

        ok=new JButton("确定");
        ok.setFont(tool.f2);
        ok.setBounds(75,158,65,30);
        ok.addActionListener(this);
        ct.add(ok);
        no=new JButton("取消");
        no.setFont(tool.f2);
        no.setBounds(165,158,65,30);
        ct.add(no);

        l6=new JLabel("密码至少6位");
        l6.setFont(tool.f4);
        l6.setBounds(30,117,50,30);
         ct.add(l6);
        text1=new JTextField(15);
        text1.setBorder(BorderFactory.createLoweredBevelBorder());
        text1.setBounds(80,60,170,25);
        ct.add(text1);
        text2=new JTextField(15);
        text2.setBorder(BorderFactory.createLoweredBevelBorder());
        text2.setBounds(80,105,170,25);
        ct.add(text2);



        no.addActionListener(this);
        this.setSize(300,240);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
          String s1=text1.getText();
          String s2=text2.getText();

            if (e.getSource()==no)
            {
                this.dispose();
            }else if (e.getSource()==ok)
            {
                if (s1.length()==0||s2.length()==0)
                {
                      JOptionPane.showMessageDialog(this,"注册信息不能为空");
                }else if (s2.length()<6)
                {
                    JOptionPane.showMessageDialog(this,"密码不能少于6位");
                }
               else
               {
                   mm=new dataModel();
                   mm.userInsert(s1,s2);
                   JOptionPane.showMessageDialog(this,"注册成功，现在可以开启你的旅途了！");
                   this.dispose();
               }
            }
      }
}
