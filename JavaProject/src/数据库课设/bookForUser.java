package 数据库课设;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import myFont.*;

public class bookForUser extends JPanel implements ActionListener {
    JPanel jpl1,jpl2,jpl3,jpl4,jpl5;
    JLabel  jl;
    JTextField jtf;
    JButton  bt1,bt2,bt3;
    JScrollPane jsp;
    JTable jtb;
    dataModel manage;
    static String txtId;
      public bookForUser(String id)
      {
          jpl1=new JPanel(new FlowLayout(FlowLayout.CENTER));
          jl=new JLabel("请输入书名查找您要的书"); jl.setFont(tool.f2);
          jtf=new JTextField(15);
          bt1=new JButton("查询");bt1.setFont(tool.f2);
          bt1.addActionListener(this);
          jpl1.add(jl);
          jpl1.add(jtf);
          jpl1.add(bt1);

          manage=new dataModel();
          String[]paras={"1"};
          manage.query("select * from book where 1=?",paras);
          jtb=new JTable(manage);

          jpl2=new JPanel(new BorderLayout());
          jsp=new JScrollPane(jtb);
          jpl2.add(jsp);

          jpl3=new JPanel(new FlowLayout(FlowLayout.RIGHT));
          bt2=new JButton("加入购物车");
          bt2.setFont(tool.f3);
          bt2.addActionListener(this);

          bt3=new JButton("刷新");
          bt3.setFont(tool.f3);
          bt3.addActionListener(this);

          txtId=id;

          jpl3.add(bt3);
          jpl3.add(bt2);

          jpl4=new JPanel(new BorderLayout());
          jpl4.add(jpl3,"East");
          this.setLayout(new BorderLayout());
          this.add(jpl1,"North");
          this.add(jpl2,"Center");
          this.add(jpl4,"South");
          this.setVisible(true);
      }
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource()==bt1)
         {
             if (!manage.checkBookName(jtf.getText()))
             {
                 JOptionPane.showMessageDialog(this,"抱歉，本店没有您要找的书");
                 return;
             }else {
                 String[] paras = {jtf.getText()};
                 String sql = "select * from book where 书名=?";
                 dataModel dm = new dataModel();
                 dm.query(sql, paras);
                 jtb.setModel(dm);
             }
         }else if (e.getSource()==bt2)
         {
             int row=jtb.getSelectedRow();
             new intoCart(jtb,manage,row,txtId);
         }else if (e.getSource()==bt3)
         {
             String[] paras={"1"};
             String sql="select * from book where 1=?";
             dataModel d=new dataModel();
             d.query(sql,paras);
             jtb.setModel(d);
         }
    }
}
