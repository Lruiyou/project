package 数据库课设;
/*管理员修改书籍界面*/
import myFont.tool;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updateBook extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField f1,f2,f3,f4,f5,f6,f7;
    JButton b1,b2;
    static  JTable t;
    public updateBook(JTable jt, dataModel manage, int row)
    {
        this.setLayout(null);
        Container ct=this.getContentPane();
        l1=new JLabel("编号");
        l1.setFont(tool.f2);
        l1.setBounds(40,23,30,30);
        ct.add(l1);


        l2=new JLabel("书名");
        l2.setFont(tool.f2);
        l2.setBounds(40,63,30,30);
        ct.add(l2);


        l3=new JLabel("作者");
        l3.setFont(tool.f2);
        l3.setBounds(40,103,30,30);
        ct.add(l3);

        l4=new JLabel("出版社");
        l4.setFont(tool.f2);
        l4.setBounds(28,143,45,30);
        ct.add(l4);

        l5=new JLabel("类型");
        l5.setFont(tool.f2);
        l5.setBounds(40,183,30,30);
        ct.add(l5);

        l6=new JLabel("库存");
        l6.setFont(tool.f2);
        l6.setBounds(40,223,30,30);
        ct.add(l6);

        l7=new JLabel("价格");
        l7.setFont(tool.f2);
        l7.setBounds(40,263,30,30);
        ct.add(l7);

        f1=new JTextField(15);
        f1.setBounds(75,25,170,25);
        f1.setText(manage.getValueAt(row,0).toString());
        f1.setEditable(false);
        f1.setBorder(BorderFactory.createLoweredBevelBorder());
        ct.add(f1);

        f2=new JTextField(15);
        f2.setBounds(75,65,170,25);
        f2.setText(manage.getValueAt(row,1).toString());
        f2.setBorder(BorderFactory.createLoweredBevelBorder());
        ct.add(f2);

        f3=new JTextField(15);
        f3.setBounds(75,105,170,25);
        f3.setText(manage.getValueAt(row,2).toString());
        f3.setBorder(BorderFactory.createLoweredBevelBorder());
        ct.add(f3);
        f4=new JTextField(15);
        f4.setBounds(75,145,170,25);
        f4.setText(manage.getValueAt(row,3).toString());
        f4.setBorder(BorderFactory.createLoweredBevelBorder());
        ct.add(f4);


        f5=new JTextField(15);
        f5.setBounds(75,185,170,25);
        f5.setText(manage.getValueAt(row,4).toString());
        f5.setBorder(BorderFactory.createLoweredBevelBorder());
        ct.add(f5);

        f6=new JTextField(15);
        f6.setBounds(75,225,170,25);
        f6.setText(manage.getValueAt(row,5).toString());
        f6.setBorder(BorderFactory.createLoweredBevelBorder());
        ct.add(f6);

        f7=new JTextField(15);
        f7.setBounds(75,265,170,25);
        f7.setText(manage.getValueAt(row,6).toString());
        f7.setBorder(BorderFactory.createLoweredBevelBorder());
        ct.add(f7);

        b1=new JButton("确定");
        b1.setFont(tool.f2);
        b1.addActionListener(this);
        b1.setBounds(70,310,65,30);


        b2=new JButton("取消");
        b2.addActionListener(this);
        b2.setFont(tool.f2);
        b2.setBounds(160,310,65,30);

        t=jt;

        ct.add(b1);
        ct.add(b2);
        this.setSize(300,400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource()==b1)
         {
             dataModel m=new dataModel();
             if(!m.update(f1.getText(),f2.getText(),f3.getText(),f4.getText(),
                     f5.getText(),f6.getText(),f7.getText()))
             {
                 JOptionPane.showMessageDialog(this,"修改失败");
             }
             String[]paras={"1"};
             String sql="select * from book where 1=?";
             dataModel mm=new dataModel();
             mm.query(sql,paras);
             t.setModel(mm);
             this.dispose();
         }else if (e.getSource()==b2)
         {
             this.dispose();
         }

    }
}
