package 数据库课设;
/*管理员添加书籍界面*/
import javax.swing.*;
import  myFont.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class insertBook extends JFrame implements ActionListener{
    JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
    JTextField jf1,jf2,jf3,jf4,jf5,jf6,jf7;
    JButton jb1,jb2;
     static JTable jtable;
     static dataModel mm;

    public insertBook(JTable jt, dataModel m)
    {
        this.setLayout(null);
        Container ct=this.getContentPane();
        jl1=new JLabel("编号");
        jl1.setFont(tool.f2);
        jl1.setBounds(40,23,30,30);
        ct.add(jl1);


        jl2=new JLabel("书名");
        jl2.setFont(tool.f2);
        jl2.setBounds(40,63,30,30);
        ct.add(jl2);


        jl3=new JLabel("作者");
        jl3.setFont(tool.f2);
        jl3.setBounds(40,103,30,30);
        ct.add(jl3);

        jl4=new JLabel("出版社");
        jl4.setFont(tool.f2);
        jl4.setBounds(28,143,45,30);
        ct.add(jl4);

        jl5=new JLabel("类型");
        jl5.setFont(tool.f2);
        jl5.setBounds(40,183,30,30);
        ct.add(jl5);

        jl6=new JLabel("库存");
        jl6.setFont(tool.f2);
        jl6.setBounds(40,223,30,30);
        ct.add(jl6);

        jl7=new JLabel("价格");
        jl7.setFont(tool.f2);
        jl7.setBounds(40,263,30,30);
        ct.add(jl7);

        jf1=new JTextField(15);
        jf1.setBounds(75,25,170,25);
        jf1.setBorder(BorderFactory.createLoweredBevelBorder());
        ct.add(jf1);
        jf2=new JTextField(15);
        jf2.setBounds(75,65,170,25);
        jf2.setBorder(BorderFactory.createLoweredBevelBorder());
        ct.add(jf2);

        jf3=new JTextField(15);
        jf3.setBounds(75,105,170,25);
        jf3.setBorder(BorderFactory.createLoweredBevelBorder());
        ct.add(jf3);
        jf4=new JTextField(15);
        jf4.setBounds(75,145,170,25);
        jf4.setBorder(BorderFactory.createLoweredBevelBorder());
        ct.add(jf4);
        jf5=new JTextField(15);
        jf5.setBounds(75,185,170,25);
        jf5.setBorder(BorderFactory.createLoweredBevelBorder());
        ct.add(jf5);
        jf6=new JTextField(15);
        jf6.setBounds(75,225,170,25);
        jf6.setBorder(BorderFactory.createLoweredBevelBorder());
        ct.add(jf6);
        jf7=new JTextField(15);
        jf7.setBounds(75,265,170,25);
        jf7.setBorder(BorderFactory.createLoweredBevelBorder());
        ct.add(jf7);

        jb1=new JButton("确定");
        jb1.setFont(tool.f2);
        jb1.addActionListener(this);
        jb1.setBounds(70,310,65,30);


        jb2=new JButton("取消");
        jb2.addActionListener(this);
        jb2.setFont(tool.f2);
        jb2.setBounds(160,310,65,30);

        jtable=jt;
        mm=m;

        ct.add(jb1);
        ct.add(jb2);
        this.setSize(300,400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public  void  setTable(JTable jt)
    {

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jb1)   //添加
        {
             mm=new dataModel();
            if (!mm.insert(jf1.getText(),jf2.getText(),jf3.getText(), jf4.getText(),
                    jf5.getText(),jf6.getText(),jf7.getText()))
            {
                JOptionPane.showMessageDialog(this,"添加失败");
            }else {
                JOptionPane.showMessageDialog(this,"添加成功");
                this.dispose();
            }
            String[] paras={"1"};
            String sql="select * from book where 1=?";
            dataModel m=new dataModel();
            m.query(sql,paras);
            jtable.setModel(m);
        }else if (e.getSource()==jb2)  //取消
        {
            this.dispose();
        }
    }
}
