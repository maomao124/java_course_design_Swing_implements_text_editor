package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Project name(项目名称)：java课程设计 Swing实现文本编辑器
 * Package(包名): UI
 * Class(类名): Search
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/8
 * Time(创建时间)： 10:52
 * Version(版本): 1.0
 * Description(描述)： 查找面板
 */
public class Search
{
    private static int start = 0;                                            // 查找开始位置
    private static int end = 0;                                              // 查找结束位置

    /**
     * Init search.
     *
     * @param jTextArea         the j text area
     * @param label_information the label information
     */
    public static void init_search(JTextArea jTextArea, JLabel label_information)
    {
        MainPanel.getSearch().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // 查找对话框
                JDialog jDialog_search = new JDialog(MainPanel.getjFrame(), "查找");
                jDialog_search.setSize(500, 150);
                int x = MainPanel.getjFrame().getX();
                int y = MainPanel.getjFrame().getY();
                //System.out.println(x+"  "+y);
                int width = MainPanel.getjFrame().getWidth();
                int height = MainPanel.getjFrame().getHeight();
                int search_x = x + width / 2 - 500 / 2;
                int search_y = y + height / 2 - 150 / 2;
                jDialog_search.setLocation(search_x, search_y);
                JLabel label_search = new JLabel("查找的内容");
                label_search.setFont(new Font("宋体", Font.BOLD, 15));
                final JTextField textField_search = new JTextField(10);
                JButton buttonFind = new JButton("查找下一个");
                buttonFind.setBackground(Color.cyan);
                JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
                JPanel panel1 = new JPanel(new BorderLayout());
                JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
                panel.add(label_search);
                panel2.add(buttonFind);
                panel1.add(panel, BorderLayout.NORTH);
                panel1.add(panel2, BorderLayout.SOUTH);
                panel1.add(textField_search, BorderLayout.CENTER);
                jDialog_search.add(panel1);
                jDialog_search.setVisible(true);

                // 查找下一个按钮监听器
                buttonFind.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        String findText = textField_search.getText();       // 查找的字符串
                        String textArea = jTextArea.getText();              // 当前文本框的内容
                        start = textArea.indexOf(findText, end);
                        end = start + findText.length();
                        // 没有找到
                        if (start == -1)
                        {
                            Toolkit.getDefaultToolkit().beep();
                            JOptionPane.showMessageDialog(null,
                                    "已经到达文档尾部", "提示", JOptionPane.WARNING_MESSAGE);
                            jTextArea.select(start, end);
                            start = 0;
                            end = 0;
                        }
                        else                                                //找到了
                        {
                            jTextArea.select(start, end);
                            label_information.setText("查找成功  当前位置：" + start + "-" + end);
                        }
                    }
                });
            }
        });
    }

    /**
     * Search.
     *
     * @param jTextArea         the j text area
     * @param label_information the label information
     */
    public static void search(JTextArea jTextArea, JLabel label_information)
    {
        // 查找对话框
        JDialog jDialog_search = new JDialog(MainPanel.getjFrame(), "查找");
        jDialog_search.setSize(500, 150);
        int x = MainPanel.getjFrame().getX();
        int y = MainPanel.getjFrame().getY();
        //System.out.println(x+"  "+y);
        int width = MainPanel.getjFrame().getWidth();
        int height = MainPanel.getjFrame().getHeight();
        int search_x = x + width / 2 - 500 / 2;
        int search_y = y + height / 2 - 150 / 2;
        jDialog_search.setLocation(search_x, search_y);
        JLabel label_search = new JLabel("查找的内容");
        label_search.setFont(new Font("宋体", Font.BOLD, 15));
        final JTextField textField_search = new JTextField(10);
        JButton buttonFind = new JButton("查找下一个");
        buttonFind.setBackground(Color.cyan);
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel.add(label_search);
        panel2.add(buttonFind);
        panel1.add(panel, BorderLayout.NORTH);
        panel1.add(panel2, BorderLayout.SOUTH);
        panel1.add(textField_search, BorderLayout.CENTER);
        jDialog_search.add(panel1);
        jDialog_search.setVisible(true);

        // 查找下一个按钮监听器
        buttonFind.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String findText = textField_search.getText();       // 查找的字符串
                String textArea = jTextArea.getText();              // 当前文本框的内容
                start = textArea.indexOf(findText, end);
                end = start + findText.length();
                // 没有找到
                if (start == -1)
                {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null,
                            "已经到达文档尾部", "提示", JOptionPane.WARNING_MESSAGE);
                    //选择指定开始和结束位置之间的文本。
                    jTextArea.select(start, end);
                    start = 0;                                      //清0
                    end = 0;
                }
                else                                                //找到了
                {
                    //选择指定开始和结束位置之间的文本。
                    jTextArea.select(start, end);
                    label_information.setText("查找成功  当前位置：" + start + "-" + end);
                }
            }
        });
    }
}
