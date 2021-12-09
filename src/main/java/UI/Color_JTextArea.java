package UI;

import io.Configuration;

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

    public static void init_Color_JTextArea(JTextArea jTextArea, JMenuItem
            font_color, JMenuItem cursor_color, JMenuItem background_color, JMenuItem selected_color, JMenuItem rendering_color)
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

        rendering_color.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                change_rendering_color();
            }
        });
    }


    private static void change_font_color()                           //设置此组件的前景色
    {
        Color color = null;
        color = JColorChooser.showDialog(MainPanel.getjFrame(), "请选择字体颜色", Color.black);
        if (color != null)
        {
            jTextArea.setForeground(color);
            if (io.Configuration.config == null)
            {
                io.Configuration.config = new data.Configuration();
                Configuration.config_is_not_null = true;
            }
            io.Configuration.config.setFont_color_r(color.getRed());
            io.Configuration.config.setFont_color_g(color.getGreen());
            io.Configuration.config.setFont_color_b(color.getBlue());
        }
    }

    private static void change_cursor_color()                         //设置用于渲染插入符号的当前颜色
    {
        Color color = null;
        color = JColorChooser.showDialog(MainPanel.getjFrame(), "请选择光标颜色", Color.black);
        if (color != null)
        {
            jTextArea.setCaretColor(color);
            if (io.Configuration.config == null)
            {
                io.Configuration.config = new data.Configuration();
                Configuration.config_is_not_null = true;
            }
            io.Configuration.config.setCursor_color_r(color.getRed());
            io.Configuration.config.setCursor_color_g(color.getGreen());
            io.Configuration.config.setCursor_color_b(color.getBlue());
        }
    }

    private static void change_background_color()                    //设置此组件的背景颜色。
    // 背景颜色仅在组件不透明时使用，并且仅由JComponent或ComponentUI实现的子类使用
    {
        Color color = null;
        color = JColorChooser.showDialog(MainPanel.getjFrame(), "请选择背景颜色", Color.black);
        if (color != null)
        {
            jTextArea.setBackground(color);
            if (io.Configuration.config == null)
            {
                io.Configuration.config = new data.Configuration();
                Configuration.config_is_not_null = true;
            }
            io.Configuration.config.setBackground_color_r(color.getRed());
            io.Configuration.config.setBackground_color_g(color.getGreen());
            io.Configuration.config.setBackground_color_b(color.getBlue());
        }
    }

    private static void change_selected_color()                       //设置用于呈现选定文本的当前颜色
    {
        Color color = null;
        color = JColorChooser.showDialog(MainPanel.getjFrame(), "请选择选中颜色", Color.black);
        if (color != null)
        {
            jTextArea.setSelectedTextColor(color);
            if (io.Configuration.config == null)
            {
                io.Configuration.config = new data.Configuration();
                Configuration.config_is_not_null = true;
            }
            io.Configuration.config.setSelected_color_r(color.getRed());
            io.Configuration.config.setSelected_color_g(color.getGreen());
            io.Configuration.config.setSelected_color_b(color.getBlue());
        }
    }

    private static void change_rendering_color()                        //设置用于渲染选择的当前颜色
    {
        Color color = null;
        color = JColorChooser.showDialog(MainPanel.getjFrame(), "请选择渲染颜色", Color.black);
        if (color != null)
        {
            jTextArea.setSelectionColor(color);
            if (io.Configuration.config == null)
            {
                io.Configuration.config = new data.Configuration();
                Configuration.config_is_not_null = true;
            }
            io.Configuration.config.setRendering_color_r(color.getRed());
            io.Configuration.config.setRendering_color_g(color.getGreen());
            io.Configuration.config.setRendering_color_b(color.getBlue());
        }
    }
}
