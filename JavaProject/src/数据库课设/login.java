package 数据库课设;
/*登录界面*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jdk.nashorn.internal.scripts.JO;
import myFont.*;

public class login extends JFrame implements ActionListener {
    JPanel jp1, jp2, jp3, jp4, jp5;
    JButton yes, register;
    JLabel identity, number, pwd, title;
    JTextField jf1;
    JPasswordField jpf;
    JComboBox jc;
    String s[] = {"管理员", "用户"};

    public static void main(String[] args) {
        login l = new login();
    }

    public login() {
        title = new JLabel("网上书店系统");
        title.setFont(tool.f2);
        identity = new JLabel("身份");
        identity.setFont(tool.f2);
        number = new JLabel("账号");
        number.setFont(tool.f2);
        pwd = new JLabel("密码");
        pwd.setFont(tool.f2);
        yes = new JButton("登录");
        yes.setFont(tool.f2);
        register = new JButton("注册");
        register.setFont(tool.f2);


        register.addActionListener(this);//注册监听事件，监听者为JFrame窗口
        yes.addActionListener(this);

        jc = new JComboBox(s);
        jc.setFont(tool.f2);
        jc.setPreferredSize(new Dimension(165, 25));//给JComboBox设置宽度和高度

        jf1 = new JTextField(15);
        jf1.setBorder(BorderFactory.createLoweredBevelBorder());
        jpf = new JPasswordField(15);
        jpf.setBorder(BorderFactory.createLoweredBevelBorder());
        jp1 = new JPanel();
        jp1.setBackground(Color.LIGHT_GRAY);
        jp2 = new JPanel();
        jp2.setBackground(Color.LIGHT_GRAY);
        jp3 = new JPanel();
        jp3.setBackground(Color.LIGHT_GRAY);
        jp4 = new JPanel();
        jp4.setBackground(Color.LIGHT_GRAY);
        jp5=new JPanel();
        jp5.setBackground(Color.LIGHT_GRAY);

        this.setLayout(new GridLayout(5, 1, 2, 2));
        jp1.add(title);

        jp2.add(identity);
        jp2.add(jc);

        jp3.add(number);
        jp3.add(jf1);

        jp4.add(pwd);
        jp4.add(jpf);

        jp5.add(yes);
        jp5.add(register);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);
        this.setSize(300, 250);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String str = jc.getSelectedItem().toString();
        if (e.getSource() == register) {
            if (str==s[0])
            {
                JOptionPane.showMessageDialog(this,"请选择您的登录身份为用户");
            }else {
                new Register();
                this.dispose();
            }
        } else if (e.getSource() == yes) {
            {
                String  txt=jf1.getText();
                if (str == s[1]) {
                    String id = this.jf1.getText().trim();
                    String password =new String(this.jpf.getPassword());
                    userModel um = new userModel();
                    if (id.length()==0 || password.length()==0)
                    {
                        JOptionPane.showMessageDialog(this,"请输入登录账号和密码");
                        return;
                    }else  if (!um.checkUser(id,password)) {
                        JOptionPane.showMessageDialog(this, "登录错误：您可能还没注册或密码和账号输入错误");
                       return;
                   }
                    else {
                        new userMenu(id);
                        this.dispose();
                    }
                }else if (str==s[0])
                {
                      String id=new String("lruiyou");
                      String pwd=new String("123456");
                      String uid=jf1.getText().trim();
                    String password =new String(this.jpf.getPassword());
                      if (jf1.getText().length()==0 || jpf.getPassword().length==0)
                      {
                          JOptionPane.showMessageDialog(this,"请输入登录账号和密码");
                          return;
                      }else if (uid.equals(id) && pwd.equals(password))
                      {
                          new ManagerMenu();
                          this.dispose();
                      }else
                      {
                          JOptionPane.showMessageDialog(this, "登录错误：密码或账号输入错误");
                      }
                }
            }
            }
        }
}

