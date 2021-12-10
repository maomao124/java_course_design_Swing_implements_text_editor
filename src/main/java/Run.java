import UI.About;
import UI.MainPanel;
import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;

/**
 * Project name(项目名称)：java课程设计 Swing实现文本编辑器
 * Package(包名): PACKAGE_NAME
 * Class(类名): Run
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/7
 * Time(创建时间)： 12:58
 * Version(版本): 1.0
 * Description(描述)： 从这里启动整个程序
 */

public class Run
{
    private static void init_MemoryComputing()
    {
        ActionListener taskPerformer = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Runtime r = Runtime.getRuntime();
                float memory;
                memory = r.totalMemory();
                memory = memory / 1024 / 1024;
                //System.out.printf("JVM总内存：%.3fMB\n", memory);
                memory = r.freeMemory();
                memory = memory / 1024 / 1024;
                //System.out.printf(" 空闲内存：%.3fMB\n", memory);
                memory = r.totalMemory() - r.freeMemory();
                memory = memory / 1024 / 1024;
                System.out.printf("已使用的内存：%.4fMB\n", memory);
            }
        };
        Timer timer = new Timer(2000, taskPerformer);
        timer.start();
    }

    public static void main(String[] args)
    {
        try
        {
            init_MemoryComputing();
            new MainPanel();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            final Writer result = new StringWriter();
            final PrintWriter printWriter = new PrintWriter(result);
            e.printStackTrace(printWriter);
            String stackTraceStr = result.toString();
            io.ErrorLog.write(stackTraceStr);
        }
    }
}
