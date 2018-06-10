package 数据库课设;

import myFont.tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

import myFont.*;
public class userMenu extends JFrame implements ActionListener,MouseListener {
    JPanel  pl1,pl2,pl3,pl4,pl5,pl6;
    JLabel lab_time; //显示当前的时间
    JLabel lb1,lb2,lb3,lb4;
    JSplitPane  split;
    CardLayout cardjp;
    static String userId;
    Timer time;//该对象可以定时的触发Action事件
    public  userMenu(String Id)
    {
        Cursor myCursor=new Cursor(Cursor.HAND_CURSOR);//定义光标样式
        CardLayout cl=new CardLayout();
        lb1=new JLabel("书 库");
        lb1.setFont(tool.f1);
        lb1.setBounds(40,70,40,35);
        lb1.setEnabled(false);
        lb1.setCursor(myCursor);
        lb1.addMouseListener(this);

        lb2=new JLabel("我 的 订 单");
        lb2.setFont(tool.f1);
        lb2.setBounds(20,140,85,35);
        lb2.setCursor(myCursor);
        lb2.setEnabled(false);
        lb2.addMouseListener(this);

        lb3=new JLabel("我的购物车");
        lb3.setFont(tool.f1);
        lb3.setBounds(20,210,80,35);
        lb3.setEnabled(false);
        lb3.setCursor(myCursor);
        lb3.addMouseListener(this);

        lb4=new JLabel("退 出");
        lb4.setFont(tool.f1);
        lb4.setBounds(40,280,40,35);
        lb4.setCursor(myCursor);
        lb4.setEnabled(false);
        lb4.addMouseListener(this);

        pl1=new JPanel(new BorderLayout());
        pl1.setBackground(Color.LIGHT_GRAY);
        pl2=new JPanel();
        pl2.setLayout(null);
        pl2.add(lb1);
        pl2.add(lb2);
        pl2.add(lb3);
        pl2.add(lb4);

        userId=Id;

        pl3=new JPanel(new BorderLayout());
        cardjp=new CardLayout();
        pl4=new JPanel(this.cardjp);
        bookForUser bu=new bookForUser(userId);
        pl4.add(bu,"0");
        bookForCart bfc=new bookForCart(userId);
        pl4.add(bfc,"1");
        bookforForm form=new bookforForm(Id);
        pl4.add(form,"2");
        pl1.add(pl2);

        pl3.add(pl4,"Center");
        split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,pl1,pl3);
        split.setDividerLocation(125);
        split.setDividerSize(2);

        pl5=new JPanel(new BorderLayout());
        pl6=new JPanel(new BorderLayout());

        pl6.setBackground(new Color(170,170,165));

        time=new Timer(1000,this);
        time.start();
        lab_time=new JLabel(Calendar.getInstance().getTime().toLocaleString());
        lab_time.setFont(tool.f2);
        pl6.add(lab_time,"East");
        pl5.add(pl6);
        Container ct=this.getContentPane();
        ct.add(split,"Center");
        ct.add(pl5,"South");
        this.setSize(900,500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
           this.lab_time.setText("当前时间："+Calendar.getInstance().getTime().toLocaleString());
    }


    @Override
    public void mouseClicked(MouseEvent e) {
         if (e.getSource()==lb1)
         {
             this.cardjp.show(pl4,"0");
         }else if (e.getSource()==lb2)
         {
             this.cardjp.show(pl4,"2");
         }else if (e.getSource()==lb3)
         {
            this.cardjp.show(pl4,"1");
         }else if (e.getSource()==lb4)
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
        if (e.getSource()==this.lb1)
        {this.lb1.setEnabled(true);}
        else if (e.getSource()==this.lb2)
        {
            this.lb2.setEnabled(true);
        } else if (e.getSource()==this.lb3)
        {
            this.lb3.setEnabled(true);
        }else if (e.getSource()==this.lb4)
        {
            this.lb4.setEnabled(true);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource()==this.lb1)
        {this.lb1.setEnabled(false);}
        else if (e.getSource()==this.lb2)
        {
            this.lb2.setEnabled(false);
        } else if (e.getSource()==this.lb3)
        {
            this.lb3.setEnabled(false);
        }else if (e.getSource()==this.lb4)
        {
            this.lb4.setEnabled(false);
        }
    }
}
