package UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Project name(项目名称)：java课程设计 Swing实现文本编辑器
 * Package(包名): UI
 * Class(类名): ErrorLog
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/8
 * Time(创建时间)： 9:55
 * Version(版本): 1.0
 * Description(描述)： 错误日志类的GUI界面
 */
public class ErrorLog
{
    private static JTextArea jTextArea_ErrorLog;
    private static JScrollPane jScrollPane;
    private static JButton button_back;
    private static JButton button_back_pop;

    /**
     * Gets text area error log.
     *
     * @return the text area error log
     */
    public static JTextArea getjTextArea_ErrorLog()
    {
        return jTextArea_ErrorLog;
    }

    /**
     * Init error log j panel.
     */
    public static void init_error_log_jPanel()                  //初始化错误日志面板
    {
        jTextArea_ErrorLog = new JTextArea(15, 55);
        jTextArea_ErrorLog.setLineWrap(false);
        jTextArea_ErrorLog.setEditable(false);
        Font font = new Font("宋体", Font.PLAIN, 18);
        jTextArea_ErrorLog.setFont(font);
        jScrollPane = new JScrollPane(jTextArea_ErrorLog);
        JPanel jPanel = new JPanel();
        MainPanel.setjPanel_ErrorLog(jPanel);
        jPanel.setLayout(new BorderLayout());
        button_back = new JButton("<-返回");
        button_back_pop = new JButton("<-返回");
        jScrollPane.setBorder(new EmptyBorder(20, 45, 50, 100));
        jPanel.add(jScrollPane, BorderLayout.CENTER);
        JPanel jPanel2 = new JPanel();                        //底部面板
        JPanel jPanel3 = new JPanel();                        //顶部面板
        jPanel2.setLayout(new FlowLayout());
        jPanel2.add(button_back);
        jPanel3.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        jPanel3.add(button_back_pop);
        jPanel.add(jPanel2, BorderLayout.SOUTH);
        jPanel.add(jPanel3, BorderLayout.WEST);
        button_back.setBackground(Color.cyan);                //设置颜色
        button_back_pop.setBackground(Color.WHITE);
        button_back.addActionListener(new ActionListener()
        {                                                     //设置监听
            @Override
            public void actionPerformed(ActionEvent e)
            {
                back();
            }
        });

        button_back_pop.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                back();
            }
        });

        MainPanel.getErrorLog().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                display();
            }
        });

        jPanel.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                int mods = e.getModifiersEx();
                if (mods == 16384)
                {
                    back();
                }
            }
        });

        jTextArea_ErrorLog.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                int mods = e.getModifiersEx();
                if (mods == 16384)
                {
                    back();
                }
            }
        });
    }

    /**
     * Display.
     */
    public static void display()                                    //显示面板
    {
        jTextArea_ErrorLog.setText("");             //清空
        io.ErrorLog.read();                                   //读取日志
        JFrame jFrame = MainPanel.getjFrame();
        jFrame.remove(MainPanel.getjPanel());
        jFrame.add(MainPanel.getjPanel_ErrorLog());
        MainPanel.getjPanel_ErrorLog().updateUI();
        jFrame.repaint();
    }

    private static void back()                                      //返回到主面板
    {
        JFrame jFrame = MainPanel.getjFrame();
        jFrame.remove(MainPanel.getjPanel_ErrorLog());
        jFrame.add(MainPanel.getjPanel());
        jFrame.repaint();
    }
}
