package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Project name(项目名称)：java课程设计 Swing实现文本编辑器
 * Package(包名): UI
 * Class(类名): Color_JtestAra
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/8
 * Time(创建时间)： 20:01
 * Version(版本): 1.0
 * Description(描述)： 设置文本域颜色
 */

public class Color_JTextArea
{
    private static JTextArea jTextArea;

    public static void init_Color_JTextArea(JTextArea jTextArea, JMenuItem font_color, JMenuItem cursor_color, JMenuItem background_color, JMenuItem selected_color)
    {
        Color_JTextArea.jTextArea = jTextArea;

        font_color.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                change_font_color();
            }
        });

        cursor_color.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                change_cursor_color();
            }
        });

        background_color.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                change_background_color();
            }
        });

        selected_color.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                change_selected_color();
            }
        });
    }


    private static void change_font_color()
    {
        Color color = null;
        color = JColorChooser.showDialog(MainPanel.getjFrame(), "请选择字体颜色", Color.black);
        if (color != null)
        {
            jTextArea.setForeground(color);
        }
    }

    private static void change_cursor_color()
    {
        Color color = null;
        color = JColorChooser.showDialog(MainPanel.getjFrame(), "请选择光标颜色", Color.black);
        if (color != null)
        {
            jTextArea.setCaretColor(color);
        }
    }

    private static void change_background_color()
    {
        Color color = null;
        color = JColorChooser.showDialog(MainPanel.getjFrame(), "请选择背景颜色", Color.black);
        if (color != null)
        {
            jTextArea.setBackground(color);
        }
    }

    private static void change_selected_color()
    {
        Color color = null;
        color = JColorChooser.showDialog(MainPanel.getjFrame(), "请选择选中颜色", Color.black);
        if (color != null)
        {
            jTextArea.setSelectedTextColor(color);
            jTextArea.setSelectionColor(color);
        }
    }
}
