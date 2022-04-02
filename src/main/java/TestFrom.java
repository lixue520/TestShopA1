import java.awt.*;
import java.sql.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sat Apr 02 18:35:22 CST 2022
 */



/**
 * @author 1
 */
public class TestFrom extends JFrame {
    public TestFrom() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField("MrQin");
        label2 = new JLabel();
        textField2 = new JTextField("Qin123");
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("username:");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(110, 60), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(180, 55, 95, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("password:");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(110, 95), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(180, 95, 95, textField2.getPreferredSize().height);

        //---- button1 ----
        button1.setText("Log in");
        button1.addActionListener(a->{
            /*
               实现登录
               1、先拿到登录界面的用户名和密码
               2、拿去数据库比对是否有用户名和密码
             */
            String username = textField1.getText();
            String password = textField2.getText();
            String sql="SELECT * FROM sys_user WHERE name='"+username+"' AND password='"+password+"'";

            /*
            * 1.连接数据库（通过mysql的maven依赖）
            * */

            Connection conn = null;
            String user = "root";
            String dbPassword="123456";
            String url = "jdbc:mysql://localhost:3306/testshop?useUnicode=ture&characterEncoding=UTF-8&serverTimezone=GMT%2B8";

            Statement statement = null;  //语句对象
            ResultSet rs = null;   //利用语句对象创建游标对象
            try {
                conn = DriverManager.getConnection(url,user,dbPassword);
                System.out.println(conn);
                System.out.println(sql);

                //如何判断用户名和密码是否正确
                statement = conn.createStatement();
                rs = statement.executeQuery(sql); //刚刚执行完查询时，游标不指向任何记录

                if(rs.next()){
                    System.out.println("登录成功");
                }else{
                    System.out.println("用户名或密码错误");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }



        });
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(160, 175), button1.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
       this.setVisible(true);

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new TestFrom();
    }

}
