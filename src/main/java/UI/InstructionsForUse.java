package UI;

import javax.swing.*;
import java.awt.*;

/**
 * Project name(项目名称)：java课程设计 Swing实现文本编辑器
 * Package(包名): UI
 * Class(类名): InstructionsForUse
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/9
 * Time(创建时间)： 13:03
 * Version(版本): 1.0
 * Description(描述)： 使用说明
 */

public class InstructionsForUse extends JFrame
{
    public InstructionsForUse()
    {
        this.setTitle("使用说明");
        this.setSize(950, 550);
        JPanel jPanel = new JPanel();
        JTextArea jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        JScrollPane jScrollPane = new JScrollPane(jTextArea);

        String str = """
                使用说明：
                功能：
                程序除了支持基本的文字编辑外，还支持自动保存、文本边框设置、文件信息查看、设置文字大小、设置字体、
                设置字体颜色、设置光标颜色、设置背景颜色、设置选择颜色、设置渲染颜色、可以设置换行策略、
                设置编辑模式或者只读模式、支持查找和替换等。
                替换功能使用说明：两种方式
                第一种：先在文本域选中要替换的文字，再打开替换窗口，窗口的查找栏会自动显示你选中的文字，这时只要在
                替换栏输入你要替换的文字再点击右边的替换按钮就行了。
                第二种：先打开替换窗口，在搜索栏输入你想要要替换的文字，再点击右边的搜索按钮，搜索到你想要
                替换的内容的正确位置后，再在下面的替换栏里输入你要替换的内容，输入完成后再点击右边的替换按钮。
                字体颜色、光标颜色、背景颜色、选择颜色和渲染颜色都支持自定义色彩（8位色深 RGB）
                                
                快捷键说明：
                当打开错误日志和文件信息界面时，按鼠标退回键快速返回到主面板；
                F4：清理软件内存
                ctrl+f：打开搜索面板
                ctrl+g：打开查找面板
                ctrl+s：保存
                ctrl+shift+s：另存为
                ctrl+o：浏览
                ctrl+i：打开文件信息面板
                ctrl+e：打开错误日志面板
                ctrl+a：全选
                ctrl+c：复制
                ctrl+v：粘贴
                ctrl+x：剪切
                ctrl+r：编辑模式和只读模式的切换
                f3：改变自动保存模式
                """;

        Font font = new Font("宋体", Font.BOLD, 18);
        jTextArea.setFont(font);
        jTextArea.setForeground(Color.PINK);
        //jTextArea.setBackground(new Color(0,244,125));
        jTextArea.setText(str);
        jPanel.setLayout(new BorderLayout());
        jPanel.add(jScrollPane,BorderLayout.CENTER);
        this.add(jPanel);
    }
}
