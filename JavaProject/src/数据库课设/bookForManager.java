package 数据库课设;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import myFont.*;
public class bookForManager extends JPanel implements ActionListener{
    JPanel jp1,jp2,jp3,jp4,jp5;
    JLabel plab1;
    JTextField pjtf1;
    JButton  pjb1,jp3_jb2,jp3_jb3,jp3_jb4;
    JScrollPane jsp;
    JTable jtb;
    dataModel m;
    public bookForManager()
    {
        jp1=new JPanel(new FlowLayout(FlowLayout.CENTER));
        plab1=new JLabel("请输入书名（或编号）");plab1.setFont(tool.f2);
        pjtf1=new JTextField(15);
        pjb1=new JButton("查询");pjb1.setFont(tool.f2);
        pjb1.addActionListener(this);
        jp1.add(plab1);
        jp1.add(pjtf1);
        jp1.add(pjb1);

        m=new dataModel();
        String[] paras={"1"};
        m.query("select * from book where 1=?",paras);
        jtb=new JTable(m);
        jp2=new JPanel(new BorderLayout());
        jsp=new JScrollPane(jtb);
        jp2.add(jsp);

         jp3=new JPanel(new FlowLayout(FlowLayout.RIGHT));

         jp3_jb2=new JButton("添加");
        jp3_jb2.addActionListener(this);
         jp3_jb2.setFont(tool.f3);

         jp3_jb3=new JButton("修改");
         jp3_jb3.addActionListener(this);
         jp3_jb3.setFont(tool.f3);

         jp3_jb4=new JButton("删除");
         jp3_jb4.setFont(tool.f3);
         jp3_jb4.addActionListener(this);

        jp3.add(jp3_jb2);
        jp3.add(jp3_jb3);
        jp3.add(jp3_jb4);
        jp5=new JPanel(new BorderLayout());
        jp5.add(jp3,"East");
        this.setLayout(new BorderLayout());//要把JPanel的布局设置为BorderLayout
        this.add(jp1,"North");
        this.add(jp2,"Center");
        this.add(jp5,"South");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jp3_jb4)    //删除
        {
            upgrade u=new upgrade();
            u.initSelect(m);
            int rowNum=jtb.getSelectedRow();
            String Id=(String)m.getValueAt(rowNum,0);
            if (m.delBookById(Id))
            {
                JOptionPane.showMessageDialog(null,"删除成功");
            }else
            {
                JOptionPane.showMessageDialog(null,"删除失败");
            }
            String[] paras={"1"};
            String sql="select * from book where 1=?";
            m=new dataModel();
            m.query(sql,paras);
            jtb.setModel(m);
        }
        else if (e.getSource()==jp3_jb2)  //添加
        {
            new insertBook(jtb,m);
        }else if (e.getSource()==jp3_jb3)//修改
        {
             upgrade u=new upgrade();
             u.initSelect(m);
             int rowNum=jtb.getSelectedRow();
             if (rowNum==-1)
             {
                 JOptionPane.showMessageDialog(this,"请选择一行才可进行修改");
                 return ;
             }
             new updateBook(jtb,m,rowNum);
        }else if (e.getSource()==pjb1)
        {
            String []paras={pjtf1.getText()};
            String sql="select * from book where 书名=?";
            dataModel mm=new dataModel();
            mm.query(sql,paras);
            jtb.setModel(mm);
        }
    }
}
