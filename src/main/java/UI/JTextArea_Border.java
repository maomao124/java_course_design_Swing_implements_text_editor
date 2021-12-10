package UI;

import io.Configuration;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * Project name(项目名称)：java课程设计 Swing实现文本编辑器
 * Package(包名): UI
 * Class(类名): Border
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/10
 * Time(创建时间)： 20:49
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class JTextArea_Border extends JFrame
{
    private JTextArea textArea;
    private JScrollPane jScrollPane;
    private JList<String> list1;
    private JList<String> list2;
    private JList<String> list3;
    private JList<String> list4;

    private DefaultListModel<String> defaultListModel1;
    private DefaultListModel<String> defaultListModel2;
    private DefaultListModel<String> defaultListModel3;
    private DefaultListModel<String> defaultListModel4;

    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;

    public JTextArea_Border(JTextArea textArea, JScrollPane jScrollPane)
    {

        this.textArea = textArea;
        this.jScrollPane = jScrollPane;

        this.setTitle("边框设置-左边为左右边框设置，右边为上下边框设置");
        this.setSize(470, 300);
        this.setLocationRelativeTo(null);

        this.setLayout(new GridLayout(1, 4));
        this.addLists();
        this.addListener();
    }

    private void addLists()
    {
        defaultListModel1 = new DefaultListModel<String>();
        defaultListModel2 = new DefaultListModel<String>();
        defaultListModel3 = new DefaultListModel<String>();
        defaultListModel4 = new DefaultListModel<String>();

        list1 = new JList<String>(defaultListModel1);
        list2 = new JList<String>(defaultListModel2);
        list3 = new JList<String>(defaultListModel3);
        list4 = new JList<String>(defaultListModel4);

        jScrollPane1 = new JScrollPane(list1);
        jScrollPane2 = new JScrollPane(list2);
        jScrollPane3 = new JScrollPane(list3);
        jScrollPane4 = new JScrollPane(list4);

        defaultListModel1.addElement("0");
        defaultListModel1.addElement("5");
        defaultListModel1.addElement("10");
        defaultListModel1.addElement("15");
        defaultListModel1.addElement("20");
        defaultListModel1.addElement("25");
        defaultListModel1.addElement("30");
        defaultListModel1.addElement("35");
        defaultListModel1.addElement("40");
        defaultListModel1.addElement("45");
        defaultListModel1.addElement("50");
        defaultListModel1.addElement("55");
        defaultListModel1.addElement("60");
        defaultListModel1.addElement("65");
        defaultListModel1.addElement("70");
        defaultListModel1.addElement("75");
        defaultListModel1.addElement("80");
        defaultListModel1.addElement("85");
        defaultListModel1.addElement("90");
        defaultListModel1.addElement("95");
        defaultListModel1.addElement("100");
        defaultListModel1.addElement("110");
        defaultListModel1.addElement("120");
        defaultListModel1.addElement("130");
        defaultListModel1.addElement("140");
        defaultListModel1.addElement("150");
        defaultListModel1.addElement("160");
        defaultListModel1.addElement("170");
        defaultListModel1.addElement("180");
        defaultListModel1.addElement("190");
        defaultListModel1.addElement("200");
        defaultListModel1.addElement("220");
        defaultListModel1.addElement("240");
        defaultListModel1.addElement("260");
        defaultListModel1.addElement("280");
        defaultListModel1.addElement("300");
        defaultListModel1.addElement("325");
        defaultListModel1.addElement("350");
        defaultListModel1.addElement("375");
        defaultListModel1.addElement("400");
        defaultListModel1.addElement("425");
        defaultListModel1.addElement("450");
        defaultListModel1.addElement("475");
        defaultListModel1.addElement("500");
        defaultListModel1.addElement("525");
        defaultListModel1.addElement("550");
        defaultListModel1.addElement("575");
        defaultListModel1.addElement("600");
        defaultListModel1.addElement("625");
        defaultListModel1.addElement("650");
        defaultListModel1.addElement("675");
        defaultListModel1.addElement("700");
        defaultListModel1.addElement("725");
        defaultListModel1.addElement("750");

        defaultListModel2.addElement("0");
        defaultListModel2.addElement("5");
        defaultListModel2.addElement("10");
        defaultListModel2.addElement("15");
        defaultListModel2.addElement("20");
        defaultListModel2.addElement("25");
        defaultListModel2.addElement("30");
        defaultListModel2.addElement("35");
        defaultListModel2.addElement("40");
        defaultListModel2.addElement("45");
        defaultListModel2.addElement("50");
        defaultListModel2.addElement("55");
        defaultListModel2.addElement("60");
        defaultListModel2.addElement("65");
        defaultListModel2.addElement("70");
        defaultListModel2.addElement("75");
        defaultListModel2.addElement("80");
        defaultListModel2.addElement("85");
        defaultListModel2.addElement("90");
        defaultListModel2.addElement("95");
        defaultListModel2.addElement("100");
        defaultListModel2.addElement("110");
        defaultListModel2.addElement("120");
        defaultListModel2.addElement("130");
        defaultListModel2.addElement("140");
        defaultListModel2.addElement("150");
        defaultListModel2.addElement("160");
        defaultListModel2.addElement("170");
        defaultListModel2.addElement("180");
        defaultListModel2.addElement("190");
        defaultListModel2.addElement("200");
        defaultListModel2.addElement("220");
        defaultListModel2.addElement("240");
        defaultListModel2.addElement("260");
        defaultListModel2.addElement("280");
        defaultListModel2.addElement("300");
        defaultListModel2.addElement("325");
        defaultListModel2.addElement("350");
        defaultListModel2.addElement("375");
        defaultListModel2.addElement("400");
        defaultListModel2.addElement("425");
        defaultListModel2.addElement("450");
        defaultListModel2.addElement("475");
        defaultListModel2.addElement("500");


        list1.setSelectedIndex(0);
        list2.setSelectedIndex(0);

        this.add(jScrollPane1);
        this.add(jScrollPane2);
    }

    public void addListener()
    {
        list1.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                int Layout_left_and_right = Integer.parseInt(defaultListModel1.get(list1.getSelectedIndex()));
                int Layout_up_and_down = Integer.parseInt(defaultListModel2.get(list2.getSelectedIndex()));
                System.out.println(Layout_left_and_right);
                System.out.println(Layout_up_and_down);
                jScrollPane.setBorder(new EmptyBorder(Layout_up_and_down, Layout_left_and_right, Layout_up_and_down, Layout_left_and_right));
                MainPanel.getjFrame().repaint();
            }
        });

        list2.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                int Layout_left_and_right = Integer.parseInt(defaultListModel1.get(list1.getSelectedIndex()));
                int Layout_up_and_down = Integer.parseInt(defaultListModel2.get(list2.getSelectedIndex()));
                System.out.println(Layout_left_and_right);
                System.out.println(Layout_up_and_down);
                jScrollPane.setBorder(new EmptyBorder(Layout_up_and_down, Layout_left_and_right, Layout_up_and_down, Layout_left_and_right));
                MainPanel.getjFrame().repaint();

            }
        });
    }
}
