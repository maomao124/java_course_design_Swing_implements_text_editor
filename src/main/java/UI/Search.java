package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private static int start = 0;// 查找开始位置
    private static int end = 0;// 查找结束位置

    public static void init_search(JTextArea jTextArea)
    {
        MainPanel.getSearch().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // 查找对话框
                JDialog search = new JDialog(MainPanel.getjFrame(), "查找");
                search.setSize(200, 100);
                search.setLocation(450, 350);
                JLabel label_1 = new JLabel("查找的内容");
                JLabel label_2 = new JLabel("替换的内容");
                final JTextField textField_1 = new JTextField(5);
                final JTextField textField_2 = new JTextField(5);
                JButton buttonFind = new JButton("查找");
                JButton buttonChange = new JButton("替换");
                JPanel panel = new JPanel(new GridLayout(2, 3));
                panel.add(label_1);
                panel.add(textField_1);
                panel.add(buttonFind);
                panel.add(label_2);
                panel.add(textField_2);
                panel.add(buttonChange);
                search.add(panel);
                search.setVisible(true);
                // 为查找下一个 按钮绑定监听事件
                buttonFind.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // TODO Auto-generated method stub
                        String findText = textField_1.getText();// 查找的字符串

                        String textArea = jTextArea.getText();// 当前文本框的内容
                        start = textArea.indexOf(findText, end);
                        end = start + findText.length();
                        // 没有找到
                        if (start == -1)
                        {
                            JOptionPane.showMessageDialog(null, "“" + findText +
                                    "”" + "已经查找完毕", "记事本", JOptionPane.WARNING_MESSAGE);
                            jTextArea.select(start, end);
                        }
                        else
                        {
                            jTextArea.select(start, end);
                        }

                    }
                });
                // 为替换按钮绑定监听事件
                buttonChange.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // TODO Auto-generated method stub
                        String changeText = textField_2.getText();// 替换的字符串
                        jTextArea.select(start, end);
                        jTextArea.replaceSelection(changeText);
                        jTextArea.select(start, end);
                    }
                });
            }
        });

    }
}
