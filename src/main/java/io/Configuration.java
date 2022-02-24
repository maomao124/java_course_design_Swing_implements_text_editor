package io;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.File;

/**
 * Project name(项目名称)：java课程设计 Swing实现文本编辑器
 * Package(包名): io
 * Class(类名): Configuration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/9
 * Time(创建时间)： 13:04
 * Version(版本): 1.0
 * Description(描述)： 配置文件的输入和输出
 */
public class Configuration
{
    /**
     * The constant config.
     */
    public static data.Configuration config;                //配置文件对象
    /**
     * The constant config_is_not_null.
     */
    public static boolean config_is_not_null;               //配置文件的对象是否为空

    /**
     * Write.
     */
    public static void write()                              //将配置写入内存
    {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try                                  //文件流打开，文件读写
        {
            fileOutputStream = new FileOutputStream("Configuration.ini");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(config);
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
                if (fileOutputStream != null)
                {
                    fileOutputStream.close();
                }
                if (objectOutputStream != null)
                {
                    objectOutputStream.close();
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

    /**
     * Read.
     */
    public static void read()
    {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try                                  //文件流打开，文件读写
        {
            fileInputStream = new FileInputStream("Configuration.ini");
            objectInputStream = new ObjectInputStream(fileInputStream);
            config = (data.Configuration) objectInputStream.readObject();
            config_is_not_null = true;
        }
        catch (FileNotFoundException e)      //文件未找到
        {
            System.err.println("未找到配置文件");
            config_is_not_null = false;
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
            config_is_not_null = false;
        }
        finally
        {
            try                              //关闭流
            {
                if (fileInputStream != null)
                {
                    fileInputStream.close();
                }
                if (objectInputStream != null)
                {
                    objectInputStream.close();
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

    /**
     * Delete.
     */
    public static void delete()                             //删除此抽象路径名表示的文件或目录
    {
        int result;
        //根据本机系统设置和硬件功能发出音频哔声
        Toolkit.getDefaultToolkit().beep();
        //调出一个对话框，其中选择的数量由optionType参数确定，其中messageType参数确定要显示的图标。 messageType参数主要用于提供外观的默认图标。
        result = JOptionPane.showConfirmDialog(null, """
                        确认删除配置文件？这将删除所有已保存的个性化信息
                        包括窗口大小、字体、各颜色信息、边框信息、换行策略和自动清理
                        是否继续？"""
                , "数据丢失警告！", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if (result == 0)
        {
            File file = new java.io.File("Configuration.ini");
            if (!file.exists())                     //不存在
            {
                //根据本机系统设置和硬件功能发出音频哔声
                Toolkit.getDefaultToolkit().beep();
                //调出一个对话框，其中选择的数量由optionType参数确定，其中messageType参数确定要显示的图标。 messageType参数主要用于提供外观的默认图标。
                JOptionPane.showMessageDialog(null, "配置文件不存在！", "删除失败", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                boolean result1;
                result1 = file.delete();                    //删除此抽象路径名表示的文件或目录
                if (result1)
                {
                    Configuration.config_is_not_null = false;
                    //调出一个对话框，该对话框使用由messageType参数确定的默认图标显示消息
                    JOptionPane.showMessageDialog(null, "删除成功！重启软件生效",
                            "提示", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    //根据本机系统设置和硬件功能发出音频哔声。
                    Toolkit.getDefaultToolkit().beep();
                    //调出一个对话框，该对话框使用由messageType参数确定的默认图标显示消息
                    JOptionPane.showMessageDialog(null, "删除失败！", "提示", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }
}
