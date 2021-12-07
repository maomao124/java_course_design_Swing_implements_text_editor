package io;

import UI.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * Project name(项目名称)：java课程设计 Swing实现文本编辑器
 * Package(包名): io
 * Class(类名): File
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/7
 * Time(创建时间)： 13:52
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class File
{
    public static void read(java.io.File file, JTextArea jTextArea, JLabel label_Information)
    {
        FileReader fileReader = null;
        try                                  //文件流打开，文件读写
        {

            fileReader = new FileReader(file);
            char[] buffer = new char[1024];
            int count = 0;
            while ((count = fileReader.read(buffer)) != -1)
            {
                jTextArea.append(new String(buffer, 0, count));
                //System.out.println(new String(buffer, 0, count));
            }
            label_Information.setText("加载完成");

        }
        catch (FileNotFoundException e1)      //文件未找到
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("文件未找到！！！  " + "\n错误内容：" + e1.toString());
            final Writer result = new StringWriter();
            final PrintWriter printWriter = new PrintWriter(result);
            e1.printStackTrace(printWriter);
            String stackTraceStr = result.toString();
            io.ErrorLog.write(stackTraceStr);
        }
        catch (Exception e1)                  //其它异常
        {
            Toolkit.getDefaultToolkit().beep();
            e1.printStackTrace();
            final Writer result = new StringWriter();
            final PrintWriter printWriter = new PrintWriter(result);
            e1.printStackTrace(printWriter);
            String stackTraceStr = result.toString();
            io.ErrorLog.write(stackTraceStr);
        }
        finally
        {
            try                              //关闭流
            {
                if (fileReader != null)
                {
                    fileReader.close();
                }
            }
            catch (NullPointerException e1)    //空指针异常
            {
                Toolkit.getDefaultToolkit().beep();
                System.err.println("文件已经被关闭，无法再次关闭！！！");
                final Writer result = new StringWriter();
                final PrintWriter printWriter = new PrintWriter(result);
                e1.printStackTrace(printWriter);
                String stackTraceStr = result.toString();
                io.ErrorLog.write(stackTraceStr);
            }
            catch (Exception e1)              //其它异常
            {
                Toolkit.getDefaultToolkit().beep();
                e1.printStackTrace();
                final Writer result = new StringWriter();
                final PrintWriter printWriter = new PrintWriter(result);
                e1.printStackTrace(printWriter);
                String stackTraceStr = result.toString();
                io.ErrorLog.write(stackTraceStr);
            }
        }
    }

    public static void write(java.io.File file, JTextArea jTextArea, JLabel label_Information)
    {
        FileWriter fileWriter = null;
        try                                  //文件流打开，文件读写
        {
            label_Information.setText("正在保存...");
            fileWriter = new FileWriter(file);
            fileWriter.write(jTextArea.getText());
            label_Information.setText("保存成功");
        }
        catch (FileNotFoundException e1)      //文件未找到
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("文件未找到！！！  " + "\n错误内容：" + e1.toString());
            final Writer result = new StringWriter();
            final PrintWriter printWriter = new PrintWriter(result);
            e1.printStackTrace(printWriter);
            String stackTraceStr = result.toString();
            io.ErrorLog.write(stackTraceStr);
        }
        catch (Exception e1)                  //其它异常
        {
            Toolkit.getDefaultToolkit().beep();
            e1.printStackTrace();
            final Writer result = new StringWriter();
            final PrintWriter printWriter = new PrintWriter(result);
            e1.printStackTrace(printWriter);
            String stackTraceStr = result.toString();
            io.ErrorLog.write(stackTraceStr);
        }
        finally
        {
            try                              //关闭流
            {
                if (fileWriter != null)
                {
                    fileWriter.close();
                }
            }
            catch (NullPointerException e1)    //空指针异常
            {
                Toolkit.getDefaultToolkit().beep();
                System.err.println("文件已经被关闭，无法再次关闭！！！");
                final Writer result = new StringWriter();
                final PrintWriter printWriter = new PrintWriter(result);
                e1.printStackTrace(printWriter);
                String stackTraceStr = result.toString();
                io.ErrorLog.write(stackTraceStr);
            }
            catch (Exception e1)              //其它异常
            {
                Toolkit.getDefaultToolkit().beep();
                e1.printStackTrace();
                final Writer result = new StringWriter();
                final PrintWriter printWriter = new PrintWriter(result);
                e1.printStackTrace(printWriter);
                String stackTraceStr = result.toString();
                io.ErrorLog.write(stackTraceStr);
            }
        }
    }
    public static void write(JTextArea jTextArea,JLabel label_Information)
    {
        FileWriter fileWriter = null;
        try                                  //文件流打开，文件读写
        {
            label_Information.setText("正在保存...");
            fileWriter = new FileWriter(MainPanel.getFile());
            fileWriter.write(jTextArea.getText());
            label_Information.setText("保存成功");
        }
        catch (FileNotFoundException e1)      //文件未找到
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("文件未找到！！！  " + "\n错误内容：" + e1.toString());
            final Writer result = new StringWriter();
            final PrintWriter printWriter = new PrintWriter(result);
            e1.printStackTrace(printWriter);
            String stackTraceStr = result.toString();
            io.ErrorLog.write(stackTraceStr);
        }
        catch (Exception e1)                  //其它异常
        {
            Toolkit.getDefaultToolkit().beep();
            e1.printStackTrace();
            final Writer result = new StringWriter();
            final PrintWriter printWriter = new PrintWriter(result);
            e1.printStackTrace(printWriter);
            String stackTraceStr = result.toString();
            io.ErrorLog.write(stackTraceStr);
        }
        finally
        {
            try                              //关闭流
            {
                if (fileWriter != null)
                {
                    fileWriter.close();
                }
            }
            catch (NullPointerException e1)    //空指针异常
            {
                Toolkit.getDefaultToolkit().beep();
                System.err.println("文件已经被关闭，无法再次关闭！！！");
                final Writer result = new StringWriter();
                final PrintWriter printWriter = new PrintWriter(result);
                e1.printStackTrace(printWriter);
                String stackTraceStr = result.toString();
                io.ErrorLog.write(stackTraceStr);
            }
            catch (Exception e1)              //其它异常
            {
                Toolkit.getDefaultToolkit().beep();
                e1.printStackTrace();
                final Writer result = new StringWriter();
                final PrintWriter printWriter = new PrintWriter(result);
                e1.printStackTrace(printWriter);
                String stackTraceStr = result.toString();
                io.ErrorLog.write(stackTraceStr);
            }
        }
    }
}
