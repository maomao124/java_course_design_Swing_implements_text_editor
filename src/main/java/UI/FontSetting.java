package UI;

import io.Configuration;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * Project name(项目名称)：java课程设计 Swing实现文本编辑器
 * Package(包名): UI
 * Class(类名): Font
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/8
 * Time(创建时间)： 19:37
 * Version(版本): 1.0
 * Description(描述)： 字体设置
 */

public class FontSetting extends JFrame
{
    private JTextArea textArea;
    private JList<String> list1;
    private JList<String> list2;
    private JList<String> list3;
    private DefaultListModel<String> defaultListModel1;
    private DefaultListModel<String> defaultListModel2;
    private DefaultListModel<String> defaultListModel3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;

    public FontSetting(JTextArea textArea)
    {

        this.textArea = textArea;

        this.setTitle("字体设置");
        this.setSize(350, 250);
        this.setLocationRelativeTo(null);

        this.setLayout(new GridLayout(1, 3));
        this.addLists();
        this.addListener();

    }

    private void addLists()
    {
        defaultListModel1 = new DefaultListModel<String>();
        defaultListModel2 = new DefaultListModel<String>();
        defaultListModel3 = new DefaultListModel<String>();
        list1 = new JList<String>(defaultListModel1);
        list2 = new JList<String>(defaultListModel2);
        list3 = new JList<String>(defaultListModel3);
        jScrollPane1 = new JScrollPane(list1);
        jScrollPane2 = new JScrollPane(list2);
        jScrollPane3 = new JScrollPane(list3);

        defaultListModel1.addElement("12");
        defaultListModel1.addElement("14");
        defaultListModel1.addElement("16");
        defaultListModel1.addElement("18");
        defaultListModel1.addElement("20");
        defaultListModel1.addElement("22");
        defaultListModel1.addElement("24");
        defaultListModel1.addElement("26");
        defaultListModel1.addElement("28");
        defaultListModel1.addElement("30");
        defaultListModel1.addElement("32");
        defaultListModel1.addElement("34");
        defaultListModel1.addElement("36");
        defaultListModel1.addElement("38");
        defaultListModel1.addElement("40");

        defaultListModel2.addElement("正常");
        defaultListModel2.addElement("粗体");

        defaultListModel3.addElement("宋体");
        defaultListModel3.addElement("楷体");
        defaultListModel3.addElement("黑体");

        list1.setSelectedIndex(4);
        list2.setSelectedIndex(0);
        list3.setSelectedIndex(0);

        this.add(jScrollPane1);
        this.add(jScrollPane2);
        this.add(jScrollPane3);
    }

    public void addListener()
    {
        list1.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                Font font = new java.awt.Font(defaultListModel3.get(list3.getSelectedIndex()),
                        list2.getSelectedIndex(), Integer.parseInt(defaultListModel1.get(list1.getSelectedIndex())));
                textArea.setFont(font);
                if (io.Configuration.config == null)                        //如果对象不存在就创建对象
                {
                    io.Configuration.config = new data.Configuration();
                    Configuration.config_is_not_null = true;
                }
                io.Configuration.config.setFontName(font.getName());      //写入配置
                io.Configuration.config.setFontStyle(font.getStyle());
                io.Configuration.config.setFontSize(font.getSize());
            }
        });

        list2.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                Font font = new java.awt.Font(defaultListModel3.get(list3.getSelectedIndex()),
                        list2.getSelectedIndex(), Integer.parseInt(defaultListModel1.get(list1.getSelectedIndex())));
                textArea.setFont(font);
                if (io.Configuration.config == null)                        //如果对象不存在就创建对象
                {
                    io.Configuration.config = new data.Configuration();
                    Configuration.config_is_not_null = true;
                }
                io.Configuration.config.setFontName(font.getName());      //写入配置
                io.Configuration.config.setFontStyle(font.getStyle());
                io.Configuration.config.setFontSize(font.getSize());
            }
        });

        list3.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                Font font = new java.awt.Font(defaultListModel3.get(list3.getSelectedIndex()),
                        list2.getSelectedIndex(), Integer.parseInt(defaultListModel1.get(list1.getSelectedIndex())));
                textArea.setFont(font);
                if (io.Configuration.config == null)                        //如果对象不存在就创建对象
                {
                    io.Configuration.config = new data.Configuration();
                    Configuration.config_is_not_null = true;
                }
                io.Configuration.config.setFontName(font.getName());      //写入配置
                io.Configuration.config.setFontStyle(font.getStyle());
                io.Configuration.config.setFontSize(font.getSize());
            }
        });
    }
}
