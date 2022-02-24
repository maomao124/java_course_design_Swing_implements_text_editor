import UI.MainPanel;
import io.File;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private static long runTime = 0;
    /**
     * The constant decimalFormat.
     */
//public static boolean args_filePath = false;                              //匿名包里其它包里的类无法调用匿名包里的
    static DecimalFormat decimalFormat = new DecimalFormat("00");                       //yyyy/MM/dd  HH:mm:ss
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

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
                runTime = runTime + 1;
                System.out.print("运行时长：" + runTime / 60 + "分" + decimalFormat.format(runTime % 60) + "秒  ");
                System.out.printf("已使用的内存：%8.4fMB\n", memory);
                MainPanel.label_time_and_memory.setText("运行：" + runTime / 60 + "分" +
                        decimalFormat.format(runTime % 60) + "秒  " + String.format(" 内存：%8.3fMB", memory));
                MainPanel.label_localTime.setText("时间：" + simpleDateFormat.format(new Date()));
                /*
                if (Configuration.config_is_not_null)
                {
                    System.out.println(Configuration.config);
                }
                 */
            }
        };
        Timer timer = new Timer(1000, taskPerformer);
        timer.start();
    }

    private static void init_args(String[] args)                    //处理参数
    {
        if (args.length == 0)
        {
            return;
        }
        else if (args.length == 1)                                       //第一个参数为操作系统传入的要打开的文件路径
        {
            java.io.File file = new java.io.File(args[0]);
            if (!file.exists())
            {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,
                        "文件\"" + file.getName() + "\"不存在！", "参数传入错误", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!file.isFile())
            {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,
                        "传入的路径指向的不是一个文件！", "提示", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!file.canRead())
            {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,
                        "文件\"" + file.getName() + "\"不能读取！", "提示", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (file.length() > 1000000000)
            {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,
                        "传入的路径指向的文件过于庞大！", "提示", JOptionPane.QUESTION_MESSAGE);
                return;
            }
            //通过验证，开始处理
            MainPanel.setFile(file);
            //args_filePath = true;
        }
        else if (args.length == 2)                                  //有些情况第二个才是传入的要打开的文件路径
        {                                                           //第一个参数是操作系统传入的程序文件本身所在的的路径，第二个才是，c/c++就是这样的
            java.io.File file = new java.io.File(args[1]);
            if (!file.exists())
            {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,
                        "文件\"" + file.getName() + "\"不存在！", "参数传入错误", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!file.isFile())
            {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,
                        "传入的路径指向的不是一个文件！", "提示", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!file.canRead())
            {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,
                        "文件\"" + file.getName() + "\"不能读取！", "提示", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (file.length() > 1000000000)
            {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,
                        "传入的路径指向的文件过于庞大！", "提示", JOptionPane.QUESTION_MESSAGE);
                return;
            }
            //通过验证，开始处理
            MainPanel.setFile(file);
            //args_filePath = true;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "因为传入了多个参数，所以只处理第二个传入的参数");
            java.io.File file = new java.io.File(args[1]);
            if (!file.exists())
            {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,
                        "文件\"" + file.getName() + "\"不存在！", "参数传入错误", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!file.isFile())
            {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,
                        "传入的路径指向的不是一个文件！", "提示", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!file.canRead())
            {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,
                        "文件\"" + file.getName() + "\"不能读取！", "提示", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (file.length() > 1000000000)
            {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,
                        "传入的路径指向的文件过于庞大！", "提示", JOptionPane.QUESTION_MESSAGE);
                return;
            }
            //通过验证，开始处理
            MainPanel.setFile(file);
            //args_filePath = true;
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args)
    {
        try
        {
            init_args(args);
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
