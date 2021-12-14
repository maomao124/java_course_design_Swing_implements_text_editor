package io;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * Project name(项目名称)：java课程设计 Swing实现文本编辑器
 * Package(包名): io
 * Class(类名): ErrorLog
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/7
 * Time(创建时间)： 14:20
 * Version(版本): 1.0
 * Description(描述)： 错误日志类 读写
 */

public class ErrorLog
{
    public static void write(String message)
    {
        Calendar calendar = Calendar.getInstance();// 获取当前时间
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        month = month + 1;                         //月份从 0 开始，所以加 1
        int day = calendar.get(Calendar.DATE);
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        week = week - 1;                             //星期日为第一天
        int hour = calendar.get(Calendar.HOUR_OF_DAY); //时
        int minute = calendar.get(Calendar.MINUTE);   //分
        int second = calendar.get(Calendar.SECOND);   //秒
        int millisecond = calendar.get(Calendar.MILLISECOND); //毫秒
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); // 获取今天是本月第几天
        int dayOfWeekInMonth = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH); // 获取今天是本月第几周
        int many = calendar.get(Calendar.DAY_OF_YEAR); // 获取今天是今年第几天
        StringBuilder stringBuffer1 = new StringBuilder();
        DecimalFormat decimalFormat1 = new DecimalFormat("00");
        //stringBuffer1.append(year).append("年 ").append(month).append("月 ").append(day).append("日 ")
        // .append(hour).append("时 ").append(minute).append("分 ").append(second).append("秒");
        stringBuffer1.append("日期：");
        stringBuffer1.append(decimalFormat1.format(year)).append("/").append(decimalFormat1.format(month)).append("/")
                .append(decimalFormat1.format(day)).append("    时间：").append(decimalFormat1.format(hour))
                .append(":").append(decimalFormat1.format(minute)).append(":").append(decimalFormat1.format(second));
        //System.out.println(stringBuffer1);
        stringBuffer1.append("        主机：").append(System.getProperty("user.name"));
        stringBuffer1.append("        错误堆栈：\n");
        stringBuffer1.append(message);
        stringBuffer1.append("\n\n\n");

        //写入
        FileOutputStream fileOutputStream = null;
        try                                  //文件流打开，文件读写
        {
            fileOutputStream = new FileOutputStream("error.log", true);
            fileOutputStream.write(stringBuffer1.toString().getBytes(StandardCharsets.UTF_8));
        }
        catch (FileNotFoundException e)      //文件未找到
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("文件未找到！！！  " + "\n错误内容：" + e.toString());
        }
        catch (Exception e)                  //其它异常
        {
            Toolkit.getDefaultToolkit().beep();
            e.printStackTrace();
        }
        finally
        {
            try                              //关闭流
            {
                if (fileOutputStream != null)
                {
                    fileOutputStream.close();
                }
            }
            catch (NullPointerException e)    //空指针异常
            {
                Toolkit.getDefaultToolkit().beep();
                System.err.println("文件已经被关闭，无法再次关闭！！！");
            }
            catch (Exception e)              //其它异常
            {
                Toolkit.getDefaultToolkit().beep();
                e.printStackTrace();
            }
        }
    }

    public static void read()
    {
        FileInputStream fileInputStream = null;
        InputStreamReader InputStreamReader = null;
        BufferedReader bufferedReader = null;
        try                                  //文件流打开，文件读写
        {
            fileInputStream = new FileInputStream("error.log");
            InputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(InputStreamReader);
            String str;
            JTextArea jTextArea = UI.ErrorLog.getjTextArea_ErrorLog();
            while ((str = bufferedReader.readLine()) != null)
            {
                jTextArea.append(str + "\n");
            }
        }
        catch (FileNotFoundException e)      //文件未找到
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("文件未找到！！！  " + "\n错误内容：" + e.toString());
            final Writer result = new StringWriter();
            final PrintWriter printWriter = new PrintWriter(result);
            e.printStackTrace(printWriter);
            String stackTraceStr = result.toString();
            io.ErrorLog.write(stackTraceStr);
        }
        catch (Exception e)                  //其它异常
        {
            Toolkit.getDefaultToolkit().beep();
            e.printStackTrace();
            final Writer result = new StringWriter();
            final PrintWriter printWriter = new PrintWriter(result);
            e.printStackTrace(printWriter);
            String stackTraceStr = result.toString();
            io.ErrorLog.write(stackTraceStr);
        }
        finally
        {
            try                              //关闭流
            {
                if (fileInputStream != null)
                {
                    fileInputStream.close();
                }
                if (InputStreamReader != null)
                {
                    InputStreamReader.close();
                }
                if (bufferedReader != null)
                {
                    bufferedReader.close();
                }
            }
            catch (NullPointerException e)    //空指针异常
            {
                Toolkit.getDefaultToolkit().beep();
                System.err.println("文件已经被关闭，无法再次关闭！！！");
                final Writer result = new StringWriter();
                final PrintWriter printWriter = new PrintWriter(result);
                e.printStackTrace(printWriter);
                String stackTraceStr = result.toString();
                io.ErrorLog.write(stackTraceStr);
            }
            catch (Exception e)              //其它异常
            {
                Toolkit.getDefaultToolkit().beep();
                e.printStackTrace();
                final Writer result = new StringWriter();
                final PrintWriter printWriter = new PrintWriter(result);
                e.printStackTrace(printWriter);
                String stackTraceStr = result.toString();
                io.ErrorLog.write(stackTraceStr);
            }
        }
    }
}
