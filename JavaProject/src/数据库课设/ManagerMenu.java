package 数据库课设;
/*管理员界面*/
import myFont.tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

public class ManagerMenu extends JFrame implements ActionListener,MouseListener{
    JPanel p,p1,p3,p4,p5,p6;
    JLabel time; //显示当前的时间
    JLabel p2_lab1,p2_lab2;
    JLabel lable1,lable2,lable3,lable4;
    JSplitPane jsp;
    CardLayout cardp3;
    Timer t;//该对象可以定时的触发Action事件
    public ManagerMenu()
    {
        Cursor myCursor=new Cursor(Cursor.HAND_CURSOR);//定义光标样式
        CardLayout cl=new CardLayout();
        lable1=new JLabel("图 书 管 理");
        lable1.setFont(tool.f1);
        lable1.setEnabled(false);
        lable1.setCursor(myCursor);
        lable1.addMouseListener(this);

        lable2=new JLabel("订 单");
        lable2.setFont(tool.f1);
        lable2.setCursor(myCursor);
        lable2.setEnabled(false);
        lable2.addMouseListener(this);


        lable3=new JLabel("退 出");
        lable3.setFont(tool.f1);
        lable3.setEnabled(false);
        lable3.setCursor(myCursor);
        lable3.addMouseListener(this);


        p=new JPanel(new BorderLayout());
        p.setBackground(Color.LIGHT_GRAY);
        p1=new JPanel();
        p1.setLayout(null);
        lable1.setBounds(20,30,85,35);
        lable2.setBounds(40,100,40,35);
        lable3.setBounds(40,170,40,35);
        p1.add(lable1);
        p1.add(lable2);
        p1.add(lable3);


        p4=new JPanel(new BorderLayout());

         cardp3=new CardLayout();
        p3=new JPanel(this.cardp3);
        bookForManager bm=new bookForManager();
        formForManager  ff=new formForManager();
        p3.add(bm,"0");
        p3.add(ff,"1");
        p.add(p1);

        p4.add(p3,"Center");
        jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,p,p4);
        jsp.setDividerLocation(125);
        jsp.setDividerSize(2);
        p5=new JPanel(new BorderLayout());
        p6=new JPanel(new BorderLayout());
        p6.setBackground(new Color(170,170,165));
        t=new Timer(1000,this);//每隔1秒触发ActionEvent事件，让面板中的时间动起来
        t.start();//启动定时器，让时间动起来
        time=new JLabel(Calendar.getInstance().getTime().toLocaleString());
        time.setFont(tool.f2);
        p6.add(time,BorderLayout.EAST);
        p5.add(p6);
        Container ct=this.getContentPane();
        ct.add(jsp,"Center");
        ct.add(p5,"South");
        this.setSize(800,500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         this.time.setText("当前时间："+Calendar.getInstance().getTime().toLocaleString());//重新获得时间
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.lable1) {
            this.cardp3.show(p3, "0");
        } else if (e.getSource() == this.lable2)
        {
              this.cardp3.show(p3,"1");
        }else if (e.getSource()==lable3)
           {
               this.dispose();
           }
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }


    @Override
    public void mouseEntered(MouseEvent e) {
         if (e.getSource()==this.lable1)
         {this.lable1.setEnabled(true);}
         else if (e.getSource()==this.lable2)
         {
             this.lable2.setEnabled(true);
         } else if (e.getSource()==this.lable3)
         {
             this.lable3.setEnabled(true);
         }
    }


    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource()==this.lable1)
        { this.lable1.setEnabled(false);}
        else if (e.getSource()==this.lable2)
        {
            this.lable2.setEnabled(false);
        } else if (e.getSource()==this.lable3)
        {
            this.lable3.setEnabled(false);
        }
    }
}
