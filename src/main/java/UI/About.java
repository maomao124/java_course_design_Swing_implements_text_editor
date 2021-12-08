package UI;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Project name(项目名称)：java课程设计 Swing实现文本编辑器
 * Package(包名): UI
 * Class(类名): About
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/8
 * Time(创建时间)： 20:52
 * Version(版本): 1.0
 * Description(描述)： 关于
 */

public class About extends JFrame
{
    public static ImageIcon createImageIcon(String path)
    {
        URL imgURL = MainPanel.class.getResource(path);
        if (imgURL != null)
        {
            return new ImageIcon(imgURL);
        }
        else
        {
            System.err.println("文件未找到: " + path);
            return null;
        }
    }

    public About()
    {
        this.setSize(300, 200);
        this.setTitle("关于");
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(4, 1));
        JLabel label1 = new JLabel("作者：mao");
        label1.setHorizontalAlignment(0);
        JLabel label2 = new JLabel("完成时间：2021-12-08");
        label2.setHorizontalAlignment(0);
        JLabel label3 = new JLabel("GitHub：https://github.com/maomao124/");
        label3.setHorizontalAlignment(0);
        ImageIcon icon = createImageIcon("二维码.bmp");
        JLabel jLabel4 = new JLabel(icon);
        this.add(label1);
        this.add(label2);
        this.add(label3);
    }
}
