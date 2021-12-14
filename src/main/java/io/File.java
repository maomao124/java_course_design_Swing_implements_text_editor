package io;

import UI.MainPanel;
import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
 * Description(描述)： 文件读写类
 */

public class File
{
    public static String encoding = "UTF-8";                          //文件编码

    public static String autoDiscernEncoding(java.io.File file)
    {
        String encoding = "UTF-8";
        try
        {
            Path path = Paths.get(file.getPath());
            byte[] data = Files.readAllBytes(path);
            CharsetDetector detector = new CharsetDetector();
            detector.setText(data);
            CharsetMatch match = detector.detect();
            encoding = match.getName();
            System.out.println("文件：" + file.getName() + "的编码为：" + encoding);
            return encoding;
        }
        catch (IOException e)
        {
            System.err.println("编码识别失败");
            e.printStackTrace();
            final Writer result = new StringWriter();
            final PrintWriter printWriter = new PrintWriter(result);
            e.printStackTrace(printWriter);
            String stackTraceStr = result.toString();
            io.ErrorLog.write(stackTraceStr);
            return encoding;
        }
    }

    public static void read(java.io.File file, JTextArea jTextArea, JLabel label_Information)
    {
        FileInputStream fileInputStream = null;
        InputStreamReader InputStreamReader = null;
        try                                  //文件流打开，文件读写
        {
            fileInputStream = new FileInputStream(file);        // test.autoDiscernEncoding(file)
            encoding = autoDiscernEncoding(file);
            InputStreamReader = new InputStreamReader(fileInputStream, encoding);
            char[] buffer = new char[1024];
            int count = 0;
            while ((count = InputStreamReader.read(buffer)) != -1)
            {
                jTextArea.append(new String(buffer, 0, count));
                //System.out.println(new String(buffer, 0, count));
            }
            label_Information.setText("加载完成");
            MainPanel.label_encoding.setText("编码: " + encoding);
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
                if (fileInputStream != null)
                {
                    fileInputStream.close();
                }
                if (InputStreamReader != null)
                {
                    InputStreamReader.close();
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
        FileOutputStream fileOutputStream = null;
        try                                  //文件流打开，文件读写
        {
            label_Information.setText("正在保存...");
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(jTextArea.getText().getBytes(encoding));
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
                if (fileOutputStream != null)
                {
                    fileOutputStream.close();
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

    public static void write(java.io.File file, JTextArea jTextArea, JLabel label_Information, String encode)
    {
        FileOutputStream fileOutputStream = null;
        try                                  //文件流打开，文件读写
        {
            String s = "123";
            s.getBytes(encode);                                         //测试编码，避免编码错误时创建文件
            label_Information.setText("正在保存...");
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(jTextArea.getText().getBytes(encode));
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
        catch (UnsupportedEncodingException e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("编码\"" + encode + "\"无法识别！");
            JOptionPane.showMessageDialog(null,
                    "编码\"" + encode + "\"无法识别！\n 编码输入错误，或者该编码不支持！","编码错误", JOptionPane.ERROR_MESSAGE);
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
                if (fileOutputStream != null)
                {
                    fileOutputStream.close();
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

    public static void write(JTextArea jTextArea, JLabel label_Information)
    {
        FileOutputStream fileOutputStream = null;
        try                                  //文件流打开，文件读写
        {
            label_Information.setText("正在保存...");
            fileOutputStream = new FileOutputStream(MainPanel.getFile());
            fileOutputStream.write(jTextArea.getText().getBytes(encoding));
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
                if (fileOutputStream != null)
                {
                    fileOutputStream.close();
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

    public static void args_read(java.io.File file, JTextArea jTextArea, JLabel label_Information, JTextField jTextField_FilePath)
    {
        if (file != null)                                 //不为空
        {
            label_Information.setText("开始加载...");
            read(file, jTextArea, label_Information);
            jTextField_FilePath.setText(file.getAbsolutePath());
        }
    }
}
