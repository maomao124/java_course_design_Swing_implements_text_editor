package UI;

import io.SHA.MD5;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
    private final JTextField jTextField_FilePath = new JTextField(30);
    private final JButton button_Open = new JButton("浏览");      //文件打开按钮
    private final JButton button_Save = new JButton("保存");     //保存按钮
    private final JButton button_save_file = new JButton("另存为");
    private final JButton button_EditMode = new JButton("编辑模式");      //编辑模式
    private static JButton button_FileInformation = new JButton("文件信息");       //文件信息按钮
    private static JButton button_Back = new JButton("<-返回");           //返回按钮
    boolean isEditable = true;                                      //文本域是否可以编辑
    private static File file;                                       //关联的文件
    private final JLabel label_Information = new JLabel("欢迎使用文件编辑器", JLabel.CENTER);      //状态位

    JMenuBar jMenuBar;        //菜单栏
    JPopupMenu jPopupMenu;      //弹出菜单
    JMenuItem copy_pop;
    JMenuItem cut_pop;
    JMenuItem paste_pop;
    JMenuItem delete_pop;
    JMenuItem deleteAll_pop;
    JMenuItem selectAll_pop;
    JMenu menu_file;            //菜单
    JMenu menu_edit;
    JMenu individualization;
    JMenu format;
    JMenu help;
    JMenuItem open;         // 子菜单
    JMenuItem save;
    JMenuItem save_as;
    JMenuItem exit;
    JMenuItem selectAll;
    JMenuItem copy;
    JMenuItem cut;
    JMenuItem paste;
    JMenuItem delete;
    JMenuItem deleteAll;
    JMenuItem search;
    JMenuItem replace;
    JMenuItem edit_mode;
    JMenuItem font_setting;
    JMenuItem cursor_color;
    JMenuItem background_color;
    JMenuItem selected_color;
    JMenuItem wrap;
    JMenuItem errorLog;
    JMenuItem about;

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
        jPanel.setLayout(new BorderLayout());
        JPanel jPanel1 = new JPanel();                               //上面的按钮
        JPanel jPanel2 = new JPanel();                                 //下面的状态字体
        jPanel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        jPanel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        Font font = new Font("宋体", Font.PLAIN, 19);      //设置字体

        jTextArea = new JTextArea(720 / 30, 1280 / 12);     //初始化文本域
        jTextArea.setLineWrap(true);
        jTextArea.setFont(font);
        jTextArea.setEditable(isEditable);

        jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(jTextArea);
        jScrollPane.setBorder(new EmptyBorder(0, 30, 15, 30));

        button_Open.setBackground(Color.cyan);                          //设置颜色
        button_Save.setBackground(Color.cyan);
        button_EditMode.setBackground(Color.green);
        button_save_file.setBackground(Color.cyan);
        button_FileInformation.setBackground(Color.cyan);

        label_Information.setPreferredSize(new Dimension(800, 30));

        jPanel1.add(label_FilePath);                                      //加入到主面板中
        jPanel1.add(jTextField_FilePath);
        jPanel1.add(button_Open);
        jPanel1.add(button_Save);
        jPanel1.add(button_save_file);
        jPanel1.add(button_EditMode);
        jPanel1.add(button_FileInformation);
        jPanel.add(jPanel1, BorderLayout.NORTH);
        jPanel.add(jScrollPane, BorderLayout.CENTER);
        jPanel2.add(label_Information);
        jPanel.add(jPanel2, BorderLayout.SOUTH);
    }

    private void init_menu()                                            //初始化菜单面板
    {
        // 菜单栏
        jMenuBar = new JMenuBar();

        // 弹出菜单
        jPopupMenu = new JPopupMenu();
        copy_pop = new JMenuItem("复制");
        cut_pop = new JMenuItem("剪切");
        paste_pop = new JMenuItem("粘贴");
        delete_pop = new JMenuItem("删除");
        deleteAll_pop = new JMenuItem("清空");
        selectAll_pop = new JMenuItem("全选");

        copy_pop.setBackground(Color.cyan);
        cut_pop.setBackground(Color.cyan);
        paste_pop.setBackground(Color.cyan);
        delete_pop.setBackground(Color.yellow);
        deleteAll_pop.setBackground(Color.red);
        selectAll_pop.setBackground(Color.cyan);

        jPopupMenu.add(copy_pop);
        jPopupMenu.add(cut_pop);
        jPopupMenu.add(paste_pop);
        jPopupMenu.add(delete_pop);
        jPopupMenu.add(deleteAll_pop);
        jPopupMenu.add(selectAll_pop);

        // 菜单
        menu_file = new JMenu("文件");
        menu_edit = new JMenu("编辑");
        individualization = new JMenu("个性化");
        format = new JMenu("格式");
        help = new JMenu("帮助");

        // 子菜单
        open = new JMenuItem("浏览");
        save = new JMenuItem("保存");
        save_as = new JMenuItem("另存为");
        exit = new JMenuItem("退出");
        open.setBackground(Color.cyan);
        save.setBackground(Color.cyan);
        save_as.setBackground(Color.cyan);
        exit.setBackground(Color.red);

        selectAll = new JMenuItem("全选");
        copy = new JMenuItem("复制");
        cut = new JMenuItem("剪切");
        paste = new JMenuItem("粘贴");
        delete = new JMenuItem("删除");
        deleteAll = new JMenuItem("清空");
        search = new JMenuItem("查找");
        replace = new JMenuItem("替换");
        edit_mode = new JMenuItem("编辑模式");
        selectAll.setBackground(Color.cyan);
        copy.setBackground(Color.cyan);
        cut.setBackground(Color.cyan);
        paste.setBackground(Color.cyan);
        delete.setBackground(Color.yellow);
        deleteAll.setBackground(Color.red);
        search.setBackground(Color.cyan);
        replace.setBackground(Color.cyan);
        edit_mode.setBackground(Color.green);

        font_setting = new JMenuItem("字体设置");
        cursor_color = new JMenuItem("光标颜色");
        background_color = new JMenuItem("背景颜色");
        selected_color = new JMenuItem("选中颜色");
        font_setting.setBackground(Color.green);
        cursor_color.setBackground(Color.green);
        background_color.setBackground(Color.green);
        selected_color.setBackground(Color.green);

        wrap = new JMenuItem("自动换行");
        wrap.setBackground(Color.cyan);

        errorLog = new JMenuItem("错误日志");
        about = new JMenuItem("关于");
        errorLog.setBackground(Color.pink);
        about.setBackground(Color.pink);

        //文件
        menu_file.add(open);
        menu_file.add(save);
        menu_file.add(save_as);
        menu_file.add(exit);

        //编辑
        menu_edit.add(selectAll);
        menu_edit.add(copy);
        menu_edit.add(cut);
        menu_edit.add(paste);
        menu_edit.add(delete);
        menu_edit.add(deleteAll);
        menu_edit.add(search);
        menu_edit.add(replace);
        menu_edit.add(edit_mode);

        //个性化
        individualization.add(font_setting);
        individualization.add(cursor_color);
        individualization.add(background_color);
        individualization.add(selected_color);

        //格式
        format.add(wrap);

        //帮助
        help.add(errorLog);
        help.add(about);

        // 将菜单和相应的子菜单添加到菜单栏
        jMenuBar.add(menu_file);
        jMenuBar.add(menu_edit);
        jMenuBar.add(individualization);
        jMenuBar.add(format);
        jMenuBar.add(help);

        // 添加菜单栏
        jFrame.setJMenuBar(jMenuBar);
    }

    private void init_menu_Listener()                                   //初始化菜单监听器
    {
        // 鼠标监听,弹出右键菜单
        jTextArea.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                int mods = e.getModifiersEx();
                //System.out.println(mods);
                // 鼠标右键
                if (mods == 4096)
                {
                    // 弹出菜单
                    jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        open.addActionListener(new ActionListener()
        {                                                   //菜单按钮 浏览
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.open();
            }
        });

        save.addActionListener(new ActionListener()
        {                                                   //菜单按钮 保存
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.save();
            }
        });

        save_as.addActionListener(new ActionListener()
        {                                                   //菜单按钮 另存为
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.saveAs();
            }
        });

        exit.addActionListener(new ActionListener()
        {                                                   //菜单按钮 退出
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.close();
            }
        });

        selectAll.addActionListener(new ActionListener()
        {                                                    //菜单按钮 全选
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.selectAll();
            }
        });

        selectAll_pop.addActionListener(new ActionListener()
        {                                                    //菜单按钮 全选
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.selectAll();
            }
        });

        copy.addActionListener(new ActionListener()
        {                                                   //菜单按钮 复制
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.copy();
            }
        });

        copy_pop.addActionListener(new ActionListener()
        {                                                   //菜单按钮 复制
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.copy();
            }
        });

        cut.addActionListener(new ActionListener()
        {                                                   //菜单按钮 剪切
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.cut();
            }
        });

        cut_pop.addActionListener(new ActionListener()
        {                                                   //菜单按钮 剪切
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.cut();
            }
        });

        paste.addActionListener(new ActionListener()
        {                                                   //菜单按钮 粘贴
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.paste();
            }
        });

        paste_pop.addActionListener(new ActionListener()
        {                                                   //菜单按钮 粘贴
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.paste();
            }
        });

        delete.addActionListener(new ActionListener()
        {                                                   //菜单按钮 删除
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.delete();
            }
        });

        delete_pop.addActionListener(new ActionListener()
        {                                                   //菜单按钮 删除
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.delete();
            }
        });
    }

    private void selectAll()                                         //全选
    {
        if (jTextArea.getText().length() == 0)
        {
            Toolkit.getDefaultToolkit().beep();
            label_Information.setText("全选失败！ 文本域为空！");
        }
        else
        {
            jTextArea.selectAll();
            int start = jTextArea.getSelectionStart();
            int end = jTextArea.getSelectionEnd();
            label_Information.setText("全选成功, 选中位置为" + start + "到" + end + "的文本");
        }
    }

    private void copy()                                                 //复制
    {
        if (jTextArea.getSelectedText() == null)
        {
            Toolkit.getDefaultToolkit().beep();
            label_Information.setText("复制失败！ 未选择文字");
        }
        else
        {
            jTextArea.copy();
            int start = jTextArea.getSelectionStart();
            int end = jTextArea.getSelectionEnd();
            label_Information.setText("复制成功, 复制选中位置为" + start + "到" + end + "的文本");
        }
    }

    private void cut()                                                  //剪切
    {
        if (jTextArea.getSelectedText() == null)
        {
            Toolkit.getDefaultToolkit().beep();
            label_Information.setText("剪切失败！ 未选择文字");
        }
        else
        {
            int start = jTextArea.getSelectionStart();
            int end = jTextArea.getSelectionEnd();
            jTextArea.cut();
            label_Information.setText("剪切成功, 剪切选中位置为" + start + "到" + end + "的文本");
        }
    }

    private void paste()                                                //粘贴
    {
        jTextArea.paste();
        label_Information.setText("粘贴成功");
    }

    private void delete()                                               //删除
    {
        if (jTextArea.getSelectedText() == null)
        {
            Toolkit.getDefaultToolkit().beep();
            label_Information.setText("删除失败！ 未选择如何文字！");
        }
        else
        {
            jTextArea.replaceSelection("");
        }
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
        this.init_menu_Listener();                                       //初始化菜单监听器
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
