package 数据库课设;
/*添加购物车界面*/
import myFont.tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class intoCart extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5;
    JTextField f1,f2,f3,f4,f5;
    JButton b1,b2;
    static  JTable able;
    static String sId;
   static dataModel data;
   static int rows;
    public intoCart(JTable jtb,dataModel dm,int row,String id)
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


        l3=new JLabel("价格");
        l3.setFont(tool.f2);
        l3.setBounds(40,103,30,30);
        ct.add(l3);

        l4=new JLabel("数量");
        l4.setFont(tool.f2);
        l4.setBounds(40,143,30,30);
        ct.add(l4);

        l5=new JLabel("账号");
        l5.setFont(tool.f2);
        l5.setBounds(40,183,30,30);
        ct.add(l5);

        f1=new JTextField(15);
        f1.setBounds(75,25,170,25);
       f1.setText(dm.getValueAt(row,0).toString());
        f1.setEditable(false);
        f1.setBorder(BorderFactory.createLoweredBevelBorder());
        ct.add(f1);

        f2=new JTextField(15);
        f2.setBounds(75,65,170,25);
       f2.setText(dm.getValueAt(row,1).toString());
        f2.setEditable(false);
        f2.setBorder(BorderFactory.createLoweredBevelBorder());
        ct.add(f2);

        f3=new JTextField(15);
        f3.setBounds(75,105,170,25);
        f3.setText(dm.getValueAt(row,6).toString());
        f3.setEditable(false);
        f3.setBorder(BorderFactory.createLoweredBevelBorder());
        ct.add(f3);

        f4=new JTextField(15);
         f4.setBounds(75,145,170,25);
        f4.setBorder(BorderFactory.createLoweredBevelBorder());
        ct.add(f4);

        f5=new JTextField(15);
        f5.setBounds(75,185,170,25);
       f5.setText(id);
        f5.setEditable(false);
        f5.setBorder(BorderFactory.createLoweredBevelBorder());
        ct.add(f5);

        b1=new JButton("确定");
        b1.setFont(tool.f2);
        b1.addActionListener(this);
        b1.setBounds(70,240,65,30);


        b2=new JButton("取消");
        b2.addActionListener(this);
        b2.setFont(tool.f2);
        b2.setBounds(160,240,65,30);

        able=jtb;
        rows=row;
        sId=id;
        data=dm;

        ct.add(b1);
        ct.add(b2);
        this.setSize(300,320);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource()==b1) {
                String number = f4.getText();
                String Id = (String) able.getValueAt(rows, 0);
                String name = (String) able.getValueAt(rows, 1);
                String num = (String) able.getValueAt(rows, 5);
                String price = (String) able.getValueAt(rows, 6);
                int bNum = Integer.parseInt(num);
                data = new dataModel();
                if (number.isEmpty())
                {
                    JOptionPane.showMessageDialog(this, "请填入您要购买的书籍数量");
                    return;
                 }
                 else {
                    int bookNum = Integer.parseInt(f4.getText());
                    if (bookNum==0) {
                        JOptionPane.showMessageDialog(this, "请选择购买书籍数量");
                        return;
                    }else if (bookNum > bNum) {
                        JOptionPane.showMessageDialog(this, "库存不够");
                        return;
                    } else if (data.checkId(Id, sId)) {
                        JOptionPane.showMessageDialog(this, "该记录已存在，请不要重复添加");
                        return;
                    } else if (data.insertCar(Id, name, price, number, sId)) {
                        JOptionPane.showMessageDialog(this, "添加成功，快去购物车看看吧");
                        this.dispose();
                    }
                }

            }
    }
}
