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
    int start = 0;// 查找开始位置
    int end = 0;// 查找结束位置

    public static void init_search()
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
            }
        });

    }
}
