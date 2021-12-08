package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Project name(项目名称)：java课程设计 Swing实现文本编辑器
 * Package(包名): UI
 * Class(类名): Replace
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/8
 * Time(创建时间)： 16:39
 * Version(版本): 1.0
 * Description(描述)： 替换
 */

public class Replace
{
    private static int start = 0;// 查找开始位置
    private static int end = 0;// 查找结束位置

    public static void init_replace(JTextArea jTextArea, JLabel label_information)
    {
        MainPanel.getReplace().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // 替换对话框
                JDialog jDialog_search = new JDialog(MainPanel.getjFrame(), "替换");
                jDialog_search.setSize(500, 150);
                int x = MainPanel.getjFrame().getX();
                int y = MainPanel.getjFrame().getY();
                int width = MainPanel.getjFrame().getWidth();
                int height = MainPanel.getjFrame().getHeight();
                int search_x = x + width / 2 - 500 / 2;
                int search_y = y + height / 2 - 150 / 2;
                jDialog_search.setLocation(search_x, search_y);
                JLabel label_search = new JLabel("查找的内容");
                label_search.setHorizontalAlignment(0);
                JLabel label_Replace = new JLabel("替换为");
                label_Replace.setHorizontalAlignment(0);
                final JTextField textField_search = new JTextField(20);
                final JTextField textField_Replace = new JTextField(20);
                JButton buttonFind = new JButton("查找下一个");
                JButton buttonReplace = new JButton("替换查找选中的内容");
                JPanel panel = new JPanel(new GridLayout(2, 3));
                buttonFind.setBackground(Color.cyan);
                buttonReplace.setBackground(Color.cyan);
                panel.add(label_search);
                panel.add(textField_search);
                panel.add(buttonFind);
                panel.add(label_Replace);
                panel.add(textField_Replace);
                panel.add(buttonReplace);
                jDialog_search.add(panel);
                if (jTextArea.getSelectedText() != null)                              //如果选中了文字
                {
                    textField_search.setText(jTextArea.getSelectedText());            //从选中处开始
                    start = jTextArea.getSelectionStart();
                    end = jTextArea.getSelectionEnd();
                }
                jDialog_search.setVisible(true);

                buttonFind.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        String findText = textField_search.getText();               // 查找的字符串
                        String textArea = jTextArea.getText();                      // 当前文本框的内容
                        start = textArea.indexOf(findText, end);
                        end = start + findText.length();
                        if (start == -1)                                            // 没有找到
                        {
                            Toolkit.getDefaultToolkit().beep();
                            JOptionPane.showMessageDialog(null,
                                    "已经到达文档尾部", "提示", JOptionPane.WARNING_MESSAGE);
                            jTextArea.select(start, end);
                            start = 0;
                            end = 0;
                        }
                        else
                        {
                            jTextArea.select(start, end);
                        }
                    }
                });

                buttonReplace.addActionListener(new ActionListener()
                {                                                                       //替换监听器
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        String ReplaceText = textField_Replace.getText();
                        jTextArea.select(start, end);
                        jTextArea.replaceSelection(ReplaceText);
                        jTextArea.select(start, end);
                        label_information.setText("替换成功    \"" + textField_search.getText() + "\"替换成\"" + ReplaceText + "\"");
                    }
                });
            }
        });
    }

    public static void replace(JTextArea jTextArea, JLabel label_information)
    {
        // 替换对话框
        JDialog jDialog_search = new JDialog(MainPanel.getjFrame(), "替换");
        jDialog_search.setSize(500, 150);
        int x = MainPanel.getjFrame().getX();
        int y = MainPanel.getjFrame().getY();
        int width = MainPanel.getjFrame().getWidth();
        int height = MainPanel.getjFrame().getHeight();
        int search_x = x + width / 2 - 500 / 2;
        int search_y = y + height / 2 - 150 / 2;
        jDialog_search.setLocation(search_x, search_y);
        JLabel label_search = new JLabel("查找的内容");
        label_search.setHorizontalAlignment(0);
        JLabel label_Replace = new JLabel("替换为");
        label_Replace.setHorizontalAlignment(0);
        final JTextField textField_search = new JTextField(20);
        final JTextField textField_Replace = new JTextField(20);
        JButton buttonFind = new JButton("查找下一个");
        JButton buttonReplace = new JButton("替换查找选中的内容");
        JPanel panel = new JPanel(new GridLayout(2, 3));
        buttonFind.setBackground(Color.cyan);
        buttonReplace.setBackground(Color.cyan);
        panel.add(label_search);
        panel.add(textField_search);
        panel.add(buttonFind);
        panel.add(label_Replace);
        panel.add(textField_Replace);
        panel.add(buttonReplace);
        jDialog_search.add(panel);
        if (jTextArea.getSelectedText() != null)                              //如果选中了文字
        {
            textField_search.setText(jTextArea.getSelectedText());            //从选中处开始
            start = jTextArea.getSelectionStart();
            end = jTextArea.getSelectionEnd();
        }
        jDialog_search.setVisible(true);

        buttonFind.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String findText = textField_search.getText();               // 查找的字符串
                String textArea = jTextArea.getText();                      // 当前文本框的内容
                start = textArea.indexOf(findText, end);
                end = start + findText.length();
                if (start == -1)                                            // 没有找到
                {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null,
                            "已经到达文档尾部", "提示", JOptionPane.WARNING_MESSAGE);
                    jTextArea.select(start, end);
                    start = 0;
                    end = 0;
                }
                else
                {
                    jTextArea.select(start, end);
                }
            }
        });

        buttonReplace.addActionListener(new ActionListener()
        {                                                                       //替换监听器
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String ReplaceText = textField_Replace.getText();
                jTextArea.select(start, end);
                jTextArea.replaceSelection(ReplaceText);
                jTextArea.select(start, end);
                label_information.setText("替换成功    \"" + textField_search.getText() + "\"替换成\"" + ReplaceText + "\"");
            }
        });
    }
}
