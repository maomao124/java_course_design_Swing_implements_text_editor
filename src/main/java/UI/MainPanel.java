package UI;

import io.SHA.MD5;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.*;
import java.io.File;



/**
 * Project name(项目名称)：java课程设计 Swing实现文本编辑器
 * Package(包名): UI
 * Class(类名): MainPanel
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/7
 * Time(创建时间)： 12:42
 * Version(版本): 1.0
 * Description(描述)： 主面板类
 */

public class MainPanel
{
    private static JFrame jFrame;                         //顶层面板
    private static JPanel jPanel;                         //主面板
    private static JPanel jPanel_FileInformation;         //文件信息面板
    private static JPanel jPanel_ErrorLog;                //错误日志面板
    private JTextArea jTextArea;                           //文本域
    private JScrollPane jScrollPane;                      //滚动面板
    private final JLabel label_FilePath = new JLabel("所选文件路径：");  //路径显示
    private final JTextField jTextField_FilePath = new JTextField(25);
    private final JButton button_Open = new JButton("浏览");      //文件打开按钮
    private final JButton button_Save = new JButton("保存");     //保存按钮
    private final JButton button_save_file = new JButton("另存为");
    private final JButton button_EditMode = new JButton("编辑模式");      //编辑模式
    private static JButton button_FileInformation = new JButton("文件信息");       //文件信息按钮
    private static JButton button_Back = new JButton("<-返回");           //返回按钮
    boolean isEditable = true;                                      //文本域是否可以编辑
    private static File file;                                       //关联的文件
    private final JLabel label_Information = new JLabel("欢迎使用文件编辑器", JLabel.CENTER);      //状态位

    public static JButton getButton_FileInformation()
    {
        return button_FileInformation;
    }

    public static void setButton_FileInformation(JButton button_FileInformation)
    {
        MainPanel.button_FileInformation = button_FileInformation;
    }

    public static JPanel getjPanel_ErrorLog()
    {
        return jPanel_ErrorLog;
    }

    public static void setjPanel_ErrorLog(JPanel jPanel_ErrorLog)
    {
        MainPanel.jPanel_ErrorLog = jPanel_ErrorLog;
    }

    public static JFrame getjFrame()
    {
        return jFrame;
    }

    public static void setjFrame(JFrame jFrame)
    {
        MainPanel.jFrame = jFrame;
    }

    public static JPanel getjPanel()
    {
        return jPanel;
    }

    public static void setjPanel(JPanel jPanel)
    {
        MainPanel.jPanel = jPanel;
    }

    public static JPanel getjPanel_FileInformation()
    {
        return jPanel_FileInformation;
    }

    public static void setjPanel_FileInformation(JPanel jPanel_FileInformation)
    {
        MainPanel.jPanel_FileInformation = jPanel_FileInformation;
    }

    public static JButton getButton_Back()
    {
        return button_Back;
    }

    public static void setButton_Back(JButton button_Back)
    {
        MainPanel.button_Back = button_Back;
    }

    public static File getFile()
    {
        return file;
    }

    public static void setFile(File file)
    {
        MainPanel.file = file;
    }

    private void init_mainPanel()                                    //初始化主面板
    {
        jPanel = new JPanel();                                       //初始化主面板
        Font font = new Font("宋体", Font.PLAIN, 19);      //设置字体

        jTextArea = new JTextArea(720 / 28, 1280 / 11);     //初始化文本域
        jTextArea.setLineWrap(true);
        jTextArea.setFont(font);
        jTextArea.setEditable(isEditable);

        jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(jTextArea);

        button_Open.setBackground(Color.cyan);                          //设置颜色
        button_Save.setBackground(Color.cyan);
        button_EditMode.setBackground(Color.green);
        button_save_file.setBackground(Color.cyan);
        button_FileInformation.setBackground(Color.cyan);

        label_Information.setPreferredSize(new Dimension(800, 30));

        jPanel.add(label_FilePath);                                      //加入到主面板中
        jPanel.add(jTextField_FilePath);
        jPanel.add(button_Open);
        jPanel.add(button_Save);
        jPanel.add(button_save_file);
        jPanel.add(button_EditMode);
        jPanel.add(button_FileInformation);
        jPanel.add(jScrollPane);
        jPanel.add(label_Information);
    }

    private void init_menu()                                            //初始化菜单面板
    {

    }

    private void init_Listener()                                        //初始化各种监听器
    {
        jFrame.addWindowListener(new WindowListener()
        {
            @Override
            public void windowOpened(WindowEvent e)
            {

            }

            @Override
            public void windowClosing(WindowEvent e)
            {
                MainPanel.this.close();
            }

            @Override
            public void windowClosed(WindowEvent e)
            {

            }

            @Override
            public void windowIconified(WindowEvent e)
            {

            }

            @Override
            public void windowDeiconified(WindowEvent e)
            {

            }

            @Override
            public void windowActivated(WindowEvent e)
            {

            }

            @Override
            public void windowDeactivated(WindowEvent e)
            {

            }
        });
        jFrame.addComponentListener(new ComponentListener()
        {
            @Override
            public void componentResized(ComponentEvent e)
            {
                int width = jFrame.getWidth();
                int height = jFrame.getHeight();
                if (height <= 500)
                {
                    jTextArea.setRows(height / 30);
                    jTextArea.setColumns(width / 11);
                }
                else if (height > 1000)
                {
                    jTextArea.setRows(height / 26);
                    jTextArea.setColumns(width / 11);
                }
                else
                {
                    jTextArea.setRows(height / 28);
                    jTextArea.setColumns(width / 11);
                }
            }

            @Override
            public void componentMoved(ComponentEvent e)
            {

            }

            @Override
            public void componentShown(ComponentEvent e)
            {

            }

            @Override
            public void componentHidden(ComponentEvent e)
            {

            }
        });
        jFrame.addWindowStateListener(new WindowStateListener()
        {
            @Override
            public void windowStateChanged(WindowEvent e)
            {
                int width = jFrame.getWidth();
                int height = jFrame.getHeight();
                jTextArea.setRows(height / 27);
                jTextArea.setColumns(width / 11);
            }
        });

        jTextArea.addCaretListener(new CaretListener()
        {                                                            //实时获取文本域指针位置
            @Override
            public void caretUpdate(CaretEvent e)
            {
                MainPanel.this.jTextArea_CaretListener();
            }
        });

        button_save_file.addActionListener(new ActionListener()
        {                                                            //另存为
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.saveAs();
            }
        });

        button_Save.addActionListener(new ActionListener()
        {                                                           //保存
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.save();
            }
        });

        button_EditMode.addActionListener(new ActionListener()
        {                                                         //只读模式或者编辑模式的来回切换
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.EditMode();
            }
        });

        button_Open.addActionListener(new ActionListener()
        {                                                           //浏览
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.open();
            }
        });

    }

    public MainPanel()
    {
        jFrame = new JFrame("文本编辑器");                           //初始化顶层面板
        jFrame.setSize(1280, 720);
        jFrame.setLocation(1920 / 2 - 640, 1080 / 2 - 360);
        jFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        this.init_mainPanel();                                           //初始化主面板
        this.init_menu();                                                //初始化菜单面板
        FileInformation.init();                                          //初始化文件信息面板

        jFrame.add(jPanel);                                              //主面板加入到顶层面板
        jFrame.setVisible(true);                                         //设置可见

        this.init_Listener();                                            //初始化各种监听器
    }

    private void close()                                                 //关闭程序
    {
        if (jTextArea.getText().length() == 0)
        {
            System.exit(1);
        }
        String fileMD5 = null;
        String testAreaMD5 = null;
        if (file != null)
        {
            label_Information.setText("请稍后，正在计算MD5值...");
            fileMD5 = MD5.getFileMD5(file.getAbsolutePath());
            testAreaMD5 = MD5.getMD5(jTextArea.getText());
            label_Information.setText("MD5值计算完成");
        }
        if (file == null)
        {
            int result;
            Toolkit.getDefaultToolkit().beep();
            result = JOptionPane.showConfirmDialog(null, "文本还未保存！ 是否退出？",
                    "退出提示", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (result == JOptionPane.YES_OPTION)
            {
                System.exit(1);
            }
            else if (result == 1)
            {
                label_Information.setText("取消退出");
            }
            else
            {
                label_Information.setText("关闭会话框，取消退出");
            }
        }
        else if (fileMD5.equals(testAreaMD5))         //MD5值相同,直接退出
        {
            System.exit(1);
        }
        else if (fileMD5 == null || testAreaMD5 == null)
        {
            int result;
            Toolkit.getDefaultToolkit().beep();
            result = JOptionPane.showConfirmDialog(null,
                    "无法计算MD5值！ 是否退出？\n文件MD5：" + fileMD5 + "\n文本域MD5:" + testAreaMD5,
                    "退出提示", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (result == JOptionPane.YES_OPTION)
            {
                System.exit(1);
            }
            else if (result == 1)
            {
                label_Information.setText("取消退出");
            }
            else
            {
                label_Information.setText("关闭会话框，取消退出");
            }
        }
        else
        {
            int result;
            Toolkit.getDefaultToolkit().beep();
            result = JOptionPane.showConfirmDialog(null,
                    "文本还有一部分未保存！ 是否退出？\n文件MD5：" + fileMD5 + "\n文本域MD5:" + testAreaMD5,
                    "退出提示", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (result == JOptionPane.YES_OPTION)
            {
                System.exit(1);
            }
            else if (result == 1)
            {
                label_Information.setText("取消退出");
            }
            else
            {
                label_Information.setText("关闭会话框，取消退出");
            }
        }
    }

    private void jTextArea_CaretListener()                                //实时获取文本域指针位置
    {
        try
        {
            int pos = jTextArea.getCaretPosition();
            //获取行数
            int lineOfC = 0;
            lineOfC = jTextArea.getLineOfOffset(pos) + 1;
            //获取列数
            int col = pos - jTextArea.getLineStartOffset(lineOfC - 1) + 1;
            //System.out.println("当前光标位置:" + lineOfC + "行," + col + "列");
            label_Information.setText("当前光标位置：第" + lineOfC + "行,第" + col + "列");
        }
        catch (BadLocationException e1)
        {
            System.out.println("无法获取光标位置");
            label_Information.setText("无法获取光标位置");
            //e1.printStackTrace();
        }
    }

    private void saveAs()                                                 //另存为
    {
        if (jTextArea.getText().length() == 0)
        {
            label_Information.setText("文本域为空,没必要保存");
            return;
        }
        JFileChooser jFileChooser = new JFileChooser(".");
        int result = jFileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            File file = jFileChooser.getSelectedFile();
            if (MainPanel.file == null)
            {
                MainPanel.file = file;
                jTextField_FilePath.setText(MainPanel.file.getAbsolutePath());
            }
            io.File.write(file, jTextArea, label_Information);         //写入文件
        }
        else
        {
            Toolkit.getDefaultToolkit().beep();
            label_Information.setText("未成功保存！！！");
        }
    }

    private void save()                                                    //保存
    {
        if (jTextArea.getText().length() == 0)
        {
            label_Information.setText("文本域为空,没必要保存");
            return;
        }
        if (MainPanel.file == null)
        {
            JFileChooser jFileChooser = new JFileChooser(".");
            int result = jFileChooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION)
            {
                File file = jFileChooser.getSelectedFile();
                MainPanel.file = file;
                jTextField_FilePath.setText(MainPanel.file.getAbsolutePath());
                io.File.write(file, jTextArea, label_Information);         //写入文件
            }
            else
            {
                Toolkit.getDefaultToolkit().beep();
                label_Information.setText("未成功保存！！！");
            }
        }
        else
        {
            io.File.write(jTextArea, label_Information);                    //写入文件
        }
    }

    private void EditMode()                                                //只读模式或者编辑模式的来回切换
    {
        if (isEditable)
        {
            button_EditMode.setText("只读模式");
            button_EditMode.setBackground(Color.yellow);
            isEditable = false;
            jTextArea.setEditable(false);
            label_Information.setText("当前为只读模式");
        }
        else
        {
            button_EditMode.setText("编辑模式");
            button_EditMode.setBackground(Color.green);
            isEditable = true;
            jTextArea.setEditable(true);
            label_Information.setText("当前为编辑模式");
        }
    }

    private void open()                                                    //打开或者浏览
    {
        if (jTextArea.getText().length() != 0)
        {
            String[] selection = {"文件数据插入到文本域的后面", "使用文件里的数据替换文本域里的数据"};
            Toolkit.getDefaultToolkit().beep();
            int result;
            result = JOptionPane.showOptionDialog(null, "文本域数据不为空！请选择更新模式！"
                    , "警告", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, selection, 0);
            if (result == 0)
            {
                label_Information.setText("从第" + (jTextArea.getText().length() - 1) + "个位置插入文件数据");
            }
            else if (result == 1)
            {
                jTextArea.setText("");
                label_Information.setText("文本域原来的数据已丢失");
            }
            else             //按到了关闭按钮
            {
                label_Information.setText("取消操作");
                return;
            }
        }
        JFileChooser jFileChooser = new JFileChooser(".");
        int result = jFileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            jTextField_FilePath.setText(jFileChooser.getSelectedFile().toString());
            file = jFileChooser.getSelectedFile();
            label_Information.setText("正在加载...");
            io.File.read(file, jTextArea, label_Information);
        }
        else
        {
            Toolkit.getDefaultToolkit().beep();
            label_Information.setText("未选择文件！！！");
        }
    }


}
