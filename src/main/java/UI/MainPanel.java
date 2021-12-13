package UI;

import io.Configuration;
import io.SHA.MD5;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.undo.UndoManager;
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
    private final JTextField jTextField_FilePath = new JTextField(35);
    private final JButton button_Open = new JButton("浏览");      //文件打开按钮
    private final JButton button_Save = new JButton("保存");     //保存按钮
    private final JButton button_save_file = new JButton("另存为");
    private final JButton button_EditMode = new JButton("编辑模式");      //编辑模式
    private static JButton button_FileInformation = new JButton("文件信息");       //文件信息按钮
    private final JButton button_autoSave = new JButton("不自动保存");             //自动保存按钮
    private static JButton button_Back = new JButton("<-返回");           //返回按钮
    boolean isEditable = true;                                      //文本域是否可以编辑
    boolean isAutoClear = false;                                       //是否自动清理软件内存
    private static File file;                                       //关联的文件
    private final JLabel label_Information = new JLabel("欢迎使用文件编辑器", JLabel.CENTER);      //状态位
    public static final JLabel label_time_and_memory = new JLabel("", JLabel.RIGHT);
    public static final JLabel label_localTime = new JLabel("", JLabel.LEFT);
    private final UI.FontSetting fontSetting;
    private final UI.JTextArea_Border jTextArea_border;
    private final UI.About about_software;
    private final InstructionsForUse instructionsForUse;
    private Timer timer_autoSave;
    private Timer timer_autoClear;
    private int auto_save_mode = 0;

    private UndoManager undoManager;                                //撤销

    @SuppressWarnings("all")
    private JMenuBar jMenuBar;        //菜单栏
    private JPopupMenu jPopupMenu;      //弹出菜单
    private JMenuItem copy_pop;
    private JMenuItem cut_pop;
    private JMenuItem paste_pop;
    private JMenuItem undo_pop;
    private JMenuItem redo_pop;
    private JMenuItem delete_pop;
    private JMenuItem deleteAll_pop;
    private JMenuItem selectAll_pop;
    @SuppressWarnings("all")
    private JMenu menu_file;            //菜单
    @SuppressWarnings("all")
    private JMenu menu_edit;
    @SuppressWarnings("all")
    private JMenu individualization;
    @SuppressWarnings("all")
    private JMenu format;
    @SuppressWarnings("all")
    private JMenu help;
    private JMenuItem open;         // 子菜单
    private JMenuItem save;
    private JMenuItem save_as;
    private JMenuItem auto_save;
    private static JMenuItem file_information;
    private JMenuItem auto_clear;
    private JMenuItem exit;
    private JMenuItem selectAll;
    private JMenuItem copy;
    private JMenuItem cut;
    private JMenuItem paste;
    private JMenuItem undo;
    private JMenuItem redo;
    private JMenuItem delete;
    private JMenuItem deleteAll;
    private static JMenuItem search;
    private static JMenuItem replace;
    private JMenuItem edit_mode;
    private JMenuItem font_setting;
    private JMenuItem font_color;
    private JMenuItem cursor_color;
    private JMenuItem background_color;
    private JMenuItem selected_color;
    private JMenuItem rendering_color;
    private JMenuItem border;
    private JMenuItem delete_confirmation;
    private JMenuItem wrap;
    private static JMenuItem errorLog;
    private JMenuItem instructions_for_use;
    private JMenuItem about;


    //各种get和set方法
    public static JButton getButton_FileInformation()
    {
        return button_FileInformation;
    }

    public static void setButton_FileInformation(JButton button_FileInformation)
    {
        MainPanel.button_FileInformation = button_FileInformation;
    }

    public static JMenuItem getReplace()
    {
        return replace;
    }

    public static JPanel getjPanel_ErrorLog()
    {
        return jPanel_ErrorLog;
    }

    public static JMenuItem getErrorLog()
    {
        return errorLog;
    }

    public static void setErrorLog(JMenuItem errorLog)
    {
        MainPanel.errorLog = errorLog;
    }

    public static JMenuItem getFile_information()
    {
        return file_information;
    }

    public static void setFile_information(JMenuItem file_information)
    {
        MainPanel.file_information = file_information;
    }

    public static JMenuItem getSearch()
    {
        return search;
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
        jTextField_FilePath.setEditable(false);

        jPanel = new JPanel();                                       //初始化主面板
        JPanel jPanel1 = new JPanel();                               //上面的按钮
        JPanel jPanel2 = new JPanel();                                 //下面的状态字体
        JPanel jPanel_left = new JPanel();                              //左
        JPanel jPanel_center = new JPanel();                              //中
        JPanel jPanel_right = new JPanel();                             //右

        Font font = new Font("宋体", Font.PLAIN, 20);         //设置字体

        jTextArea = new JTextArea(720 / 35, 1280 / 12);     //初始化文本域
        jTextArea.setLineWrap(true);
        jTextArea.setFont(font);
        jTextArea.setEditable(isEditable);

        undoManager = new UndoManager();                                     //撤销功能
        jTextArea.getDocument().addUndoableEditListener(undoManager);

        jPanel.setLayout(new BorderLayout());                              //设置布局
        jPanel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        jPanel2.setLayout(new GridLayout(1, 3));
        jPanel_left.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 0));
        jPanel_center.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel_right.setLayout(new FlowLayout(FlowLayout.RIGHT, 30, 0));


        jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(jTextArea);
        jScrollPane.setBorder(new EmptyBorder(0, 30, 15, 30));
        //jScrollPane.setBorder(new BevelBorder(0, Color.cyan, Color.green, Color.cyan, Color.red));
        //jScrollPane.setBorder(new LineBorder(Color.cyan,50,true));

        button_Open.setBackground(Color.cyan);                          //设置颜色
        button_Save.setBackground(Color.cyan);
        button_autoSave.setBackground(Color.cyan);
        button_EditMode.setBackground(Color.green);
        button_save_file.setBackground(Color.cyan);
        button_FileInformation.setBackground(Color.cyan);
        label_Information.setForeground(Color.black);

        //label_Information.setPreferredSize(new Dimension(800, 30));


        jPanel1.add(label_FilePath);                                      //加入到主面板中
        jPanel1.add(jTextField_FilePath);
        jPanel1.add(button_Open);
        jPanel1.add(button_Save);
        jPanel1.add(button_save_file);
        jPanel1.add(button_EditMode);
        jPanel1.add(button_autoSave);
        jPanel1.add(button_FileInformation);
        jPanel.add(jPanel1, BorderLayout.NORTH);
        jPanel.add(jScrollPane, BorderLayout.CENTER);
        jPanel_left.add(label_localTime);
        jPanel_center.add(label_Information);
        jPanel_right.add(label_time_and_memory);
        jPanel2.add(jPanel_left);
        jPanel2.add(jPanel_center);
        jPanel2.add(jPanel_right);
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
        undo_pop = new JMenuItem("撤销");
        redo_pop = new JMenuItem("重做");
        delete_pop = new JMenuItem("删除");
        deleteAll_pop = new JMenuItem("清空");
        selectAll_pop = new JMenuItem("全选");

        copy_pop.setBackground(Color.cyan);
        cut_pop.setBackground(Color.cyan);
        paste_pop.setBackground(Color.cyan);
        undo_pop.setBackground(Color.cyan);
        redo_pop.setBackground(Color.cyan);
        delete_pop.setBackground(Color.yellow);
        deleteAll_pop.setBackground(Color.red);
        selectAll_pop.setBackground(Color.cyan);

        jPopupMenu.add(copy_pop);
        jPopupMenu.add(cut_pop);
        jPopupMenu.add(paste_pop);
        jPopupMenu.add(undo_pop);
        jPopupMenu.add(redo_pop);
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
        auto_save = new JMenuItem("不自动保存");
        file_information = new JMenuItem("文件信息");
        auto_clear = new JMenuItem("自动清理");
        exit = new JMenuItem("退出");
        open.setBackground(Color.cyan);
        save.setBackground(Color.cyan);
        save_as.setBackground(Color.cyan);
        auto_save.setBackground(Color.cyan);
        file_information.setBackground(Color.cyan);
        auto_clear.setBackground(Color.green);
        exit.setBackground(Color.red);

        selectAll = new JMenuItem("全选");
        copy = new JMenuItem("复制");
        cut = new JMenuItem("剪切");
        paste = new JMenuItem("粘贴");
        undo = new JMenuItem("撤销");
        redo = new JMenuItem("重做");
        delete = new JMenuItem("删除");
        deleteAll = new JMenuItem("清空");
        search = new JMenuItem("查找");
        replace = new JMenuItem("替换");
        edit_mode = new JMenuItem("编辑模式");
        selectAll.setBackground(Color.cyan);
        copy.setBackground(Color.cyan);
        cut.setBackground(Color.cyan);
        paste.setBackground(Color.cyan);
        undo.setBackground(Color.cyan);
        redo.setBackground(Color.cyan);
        delete.setBackground(Color.yellow);
        deleteAll.setBackground(Color.red);
        search.setBackground(Color.cyan);
        replace.setBackground(Color.cyan);
        edit_mode.setBackground(Color.green);

        font_setting = new JMenuItem("字体设置");
        border = new JMenuItem("边框设置");
        font_color = new JMenuItem("字体颜色");
        cursor_color = new JMenuItem("光标颜色");
        background_color = new JMenuItem("背景颜色");
        selected_color = new JMenuItem("选中颜色");
        rendering_color = new JMenuItem("渲染颜色");
        delete_confirmation = new JMenuItem("清除配置");
        font_setting.setBackground(Color.green);
        border.setBackground(Color.green);
        font_color.setBackground(Color.green);
        cursor_color.setBackground(Color.green);
        background_color.setBackground(Color.green);
        selected_color.setBackground(Color.green);
        rendering_color.setBackground(Color.green);
        delete_confirmation.setBackground(Color.red);

        wrap = new JMenuItem("不自动换行");
        wrap.setBackground(Color.cyan);

        errorLog = new JMenuItem("错误日志");
        instructions_for_use = new JMenuItem("使用说明");
        about = new JMenuItem("关于");
        errorLog.setBackground(Color.pink);
        instructions_for_use.setBackground(Color.pink);
        about.setBackground(Color.pink);

        //文件
        menu_file.add(open);
        menu_file.add(save);
        menu_file.add(save_as);
        menu_file.add(auto_save);
        menu_file.add(file_information);
        menu_file.add(auto_clear);
        menu_file.add(exit);

        //编辑
        menu_edit.add(selectAll);
        menu_edit.add(copy);
        menu_edit.add(cut);
        menu_edit.add(paste);
        menu_edit.add(undo);
        menu_edit.add(redo);
        menu_edit.add(delete);
        menu_edit.add(deleteAll);
        menu_edit.add(search);
        menu_edit.add(replace);
        menu_edit.add(edit_mode);

        //个性化
        individualization.add(font_setting);
        individualization.add(border);
        individualization.add(font_color);
        individualization.add(cursor_color);
        individualization.add(background_color);
        individualization.add(selected_color);
        individualization.add(rendering_color);
        individualization.add(delete_confirmation);

        //格式
        format.add(wrap);

        //帮助
        help.add(errorLog);
        help.add(instructions_for_use);
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

    private void init_timer_auto_save()
    {
        ActionListener taskPerformer = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Toolkit.getDefaultToolkit().beep();
                if (Configuration.config_is_not_null)                   //保存配置文件
                {
                    Configuration.config.setWidth(jFrame.getWidth());
                    Configuration.config.setHeight(jFrame.getHeight());
                    io.Configuration.write();
                }
                if (file != null)
                {
                    MainPanel.this.save();
                    label_Information.setText("已触发自动保存");
                }
            }
        };
        timer_autoSave = new Timer(5000, taskPerformer);
    }

    private void init_configuration()
    {
        if (Configuration.config_is_not_null)
        {
            jFrame.setSize(Configuration.config.getWidth(), Configuration.config.getHeight());          //设置大小
            int screenWidth = ((int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);       //屏幕分辨率
            int screenHeight = ((int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);

            int x = screenWidth / 2 - Configuration.config.getWidth() / 2;                              //位于中心
            int y = screenHeight / 2 - Configuration.config.getHeight() / 2;
            if (x < 0)
            {
                x = 0;
            }
            if (y < 0)
            {
                y = 0;
            }
            jFrame.setLocation(x, y);
            Font font = new Font(Configuration.config.getFontName(),                              //设置字体和各颜色
                    Configuration.config.getFontStyle(), Configuration.config.getFontSize());
            jTextArea.setFont(font);
            Color font_color = new Color(Configuration.config.getFont_color_r(),
                    Configuration.config.getFont_color_g(), Configuration.config.getFont_color_b());
            jTextArea.setForeground(font_color);
            Color cursor_color = new Color(Configuration.config.getCursor_color_r()
                    , Configuration.config.getCursor_color_g(), Configuration.config.getCursor_color_b());
            jTextArea.setCaretColor(cursor_color);
            Color background_color = new Color(Configuration.config.getBackground_color_r()
                    , Configuration.config.getBackground_color_g(), Configuration.config.getBackground_color_b());
            jTextArea.setBackground(background_color);
            Color selected_color = new Color(Configuration.config.getSelected_color_r()
                    , Configuration.config.getSelected_color_g(), Configuration.config.getSelected_color_b());
            jTextArea.setSelectedTextColor(selected_color);
            Color rendering_color = new Color(Configuration.config.getRendering_color_r()
                    , Configuration.config.getRendering_color_g(), Configuration.config.getRendering_color_b());
            jTextArea.setSelectionColor(rendering_color);
            /*
            System.out.println(screenWidth);
            System.out.println(screenHeight);
            System.out.println(Configuration.config.getWidth());
            System.out.println(Configuration.config.getHeight());
             */
            if (screenWidth <= Configuration.config.getWidth() + 100 && screenHeight <= Configuration.config.getHeight() + 100)
            {                                                                               //任务栏会占用一部分屏幕空间
                jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);                                         //设置窗口最大化
                jFrame.setSize(1280, 720);
                int x1 = screenWidth / 2 - 1280 / 2;                              //位于中心
                int y1 = screenHeight / 2 - 720 / 2;

                jFrame.setLocation(x1, y1);
            }
            if (!Configuration.config.isWrap())
            {
                wrap.setBackground(Color.yellow);
                wrap.setText("自动换行");
                jTextArea.setLineWrap(false);
            }
            int Layout_left = 30;                //边框大小
            int Layout_right = 300;
            int Layout_up = 0;
            int Layout_down = 15;
            Layout_left = Configuration.config.getLayout_left();
            Layout_right = Configuration.config.getLayout_right();
            Layout_up = Configuration.config.getLayout_up();
            Layout_down = Configuration.config.getLayout_down();
            jScrollPane.setBorder(new EmptyBorder(Layout_up, Layout_left, Layout_down, Layout_right));
            if (Configuration.config.isAutoClear())                     //为真
            {
                isAutoClear = true;
                timer_autoClear.start();                    //启动
                auto_clear.setBackground(Color.yellow);
                auto_clear.setText("不自动清理");
            }
        }
    }

    public MainPanel()                                                   //构造方法
    {
        io.Configuration.read();                                         //读配置文件
        jFrame = new JFrame("文本编辑器");                            //初始化顶层面板
        jFrame.setSize(1280, 720);
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;       //获取屏幕宽度
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;     //获取屏幕高度
        jFrame.setLocation(screenWidth / 2 - 640, screenHeight / 2 - 360);  //位于屏幕中央
        jFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        this.init_mainPanel();                                           //初始化主面板
        this.init_menu();                                                //初始化菜单面板
        FileInformation.init();                                          //初始化文件信息面板
        UI.ErrorLog.init_error_log_jPanel();                             //初始化错误日志面板
        UI.Search.init_search(jTextArea, label_Information);              //初始化查找面板
        UI.Replace.init_replace(jTextArea, label_Information);            //初始化替换面板
        about_software = new UI.About();                                    //初始化关于面板
        instructionsForUse = new InstructionsForUse();                      //初始化使用说明面板
        jTextArea_border = new JTextArea_Border(jTextArea, jScrollPane);    //初始化边框设置模板
        this.init_timer_auto_save();                                        //初始化自动保存
        this.init_auto_clear();                                             //初始化自动清理
        fontSetting = new UI.FontSetting(jTextArea);                      //初始化字体设置面板
        this.init_configuration();                                        //初始化配置
        Color_JTextArea.init_Color_JTextArea                              //初始化文本域颜色选择
                (jTextArea, font_color, cursor_color, background_color, selected_color, rendering_color);

        jFrame.add(jPanel);                                              //主面板加入到顶层面板
        jFrame.setVisible(true);                                         //设置可见

        io.File.args_read(file, jTextArea,
                label_Information, jTextField_FilePath);                  //初始化参数

        this.init_Listener();                                            //初始化各种监听器
        this.init_menu_Listener();                                       //初始化菜单监听器
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
                if (Configuration.config_is_not_null)                   //保存配置文件
                {
                    Configuration.config.setWidth(jFrame.getWidth());
                    Configuration.config.setHeight(jFrame.getHeight());
                    io.Configuration.write();
                }
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

        deleteAll.addActionListener(new ActionListener()
        {                                                   //菜单按钮 清空
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.deleteAll();
            }
        });

        deleteAll_pop.addActionListener(new ActionListener()
        {                                                   //菜单按钮 清空
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.deleteAll();
            }
        });

        edit_mode.addActionListener(new ActionListener()
        {                                                   //编辑模式和只读模式来回切换
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.EditMode();
            }
        });

        font_setting.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int x = MainPanel.getjFrame().getX();
                int y = MainPanel.getjFrame().getY();
                int width = MainPanel.getjFrame().getWidth();
                int height = MainPanel.getjFrame().getHeight();
                int search_x = x + width / 2 - fontSetting.getWidth() / 2;
                int search_y = y + height / 2 - fontSetting.getHeight() / 2;
                fontSetting.setLocation(search_x, search_y);
                fontSetting.setVisible(true);
            }
        });

        wrap.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                boolean result = jTextArea.getLineWrap();
                if (result)                                              //是换行状态
                {
                    wrap.setBackground(Color.yellow);
                    wrap.setText("自动换行");
                    jTextArea.setLineWrap(false);
                    label_Information.setText("当前为不自动换行模式");
                    if (io.Configuration.config == null)
                    {
                        io.Configuration.config = new data.Configuration();
                        Configuration.config_is_not_null = true;
                    }
                    io.Configuration.config.setWrap(false);
                }
                else                                                      //不是换行状态
                {
                    wrap.setBackground(Color.cyan);
                    wrap.setText("不自动换行");
                    jTextArea.setLineWrap(true);
                    label_Information.setText("当前为自动换行模式");
                    if (io.Configuration.config == null)
                    {
                        io.Configuration.config = new data.Configuration();
                        Configuration.config_is_not_null = true;
                    }
                    io.Configuration.config.setWrap(true);
                }
            }
        });

        about.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int x = MainPanel.getjFrame().getX();
                int y = MainPanel.getjFrame().getY();
                int width = MainPanel.getjFrame().getWidth();
                int height = MainPanel.getjFrame().getHeight();
                int search_x = x + width / 2 - about_software.getWidth() / 2;
                int search_y = y + height / 2 - about_software.getHeight() / 2;
                about_software.setLocation(search_x, search_y);
                about_software.setVisible(true);
            }
        });

        auto_save.addActionListener(new ActionListener()
        {                                                              //自动保存按钮
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.change_auto_save_mode();
            }
        });

        delete_confirmation.addActionListener(new ActionListener()
        {                                                               //清除配置文件
            @Override
            public void actionPerformed(ActionEvent e)
            {
                io.Configuration.delete();
            }
        });

        border.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int x = MainPanel.getjFrame().getX();
                int y = MainPanel.getjFrame().getY();
                int width = MainPanel.getjFrame().getWidth();
                int height = MainPanel.getjFrame().getHeight();
                int search_x = x + width / 2 - jTextArea_border.getWidth() / 2;
                int search_y = y + height / 2 - jTextArea_border.getHeight() / 2;
                jTextArea_border.setLocation(search_x, search_y);
                jTextArea_border.setVisible(true);
            }
        });

        instructions_for_use.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int x = MainPanel.getjFrame().getX();
                int y = MainPanel.getjFrame().getY();
                int width = MainPanel.getjFrame().getWidth();
                int height = MainPanel.getjFrame().getHeight();
                int search_x = x + width / 2 - instructionsForUse.getWidth() / 2;
                int search_y = y + height / 2 - instructionsForUse.getHeight() / 2;
                instructionsForUse.setLocation(search_x, search_y);
                instructionsForUse.setVisible(true);
            }
        });

        undo.addActionListener(new ActionListener()
        {                                                                 //撤销监听器
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.undo();
            }
        });

        undo_pop.addActionListener(new ActionListener()
        {                                                                 //撤销监听器
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.undo();
            }
        });

        redo.addActionListener(new ActionListener()
        {                                                                  //重做监听器
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.redo();
            }
        });

        redo_pop.addActionListener(new ActionListener()
        {                                                                  //重做监听器
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.redo();
            }
        });

        auto_clear.addActionListener(new ActionListener()
        {                                                                   //自动清理监听器
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.change_auto_clear_mode();
            }
        });
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
                if (Configuration.config_is_not_null)                   //保存配置文件
                {
                    Configuration.config.setWidth(jFrame.getWidth());
                    Configuration.config.setHeight(jFrame.getHeight());
                    io.Configuration.write();
                }
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

        button_autoSave.addActionListener(new ActionListener()
        {                                                           //保存按钮
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.change_auto_save_mode();
            }
        });

        jTextArea.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {                                                       //ctrl+f 查找
                if ((e.getKeyCode() == KeyEvent.VK_F) && (e.isControlDown()))
                {
                    UI.Search.search(jTextArea, label_Information);
                }

                else if ((e.getKeyCode() == KeyEvent.VK_G) && (e.isControlDown()))
                {                                                   //ctrl+g 替换
                    UI.Replace.replace(jTextArea, label_Information);
                }

                else if ((e.getKeyCode() == KeyEvent.VK_S) && (e.isControlDown()))
                {                                                   //ctrl+s 保存
                    MainPanel.this.save();
                }

                else if ((e.getKeyCode() == KeyEvent.VK_S) && (e.isControlDown()) && (e.isShiftDown()))
                {                                                   //ctrl+shift+s 另存为
                    MainPanel.this.saveAs();
                }

                else if ((e.getKeyCode() == KeyEvent.VK_O) && (e.isControlDown()))
                {                                                   //ctrl+o 浏览
                    MainPanel.this.open();
                }

                else if ((e.getKeyCode() == KeyEvent.VK_I) && (e.isControlDown()))
                {                                                   //ctrl+i 文件信息
                    UI.FileInformation.display();
                }

                else if ((e.getKeyCode() == KeyEvent.VK_E) && (e.isControlDown()))
                {                                                   //ctrl+e 错误日志
                    UI.ErrorLog.display();
                }

                //以下快捷键不能设置操作，和操作系统快捷键起冲突，否则会得到双倍快乐
                else if ((e.getKeyCode() == KeyEvent.VK_A) && (e.isControlDown()))
                {                                                   //ctrl+a 全选
                    label_Information.setText("全选成功");
                }

                else if ((e.getKeyCode() == KeyEvent.VK_C) && (e.isControlDown()))
                {                                                   //ctrl+c 复制
                    label_Information.setText("复制成功");
                }

                else if ((e.getKeyCode() == KeyEvent.VK_V) && (e.isControlDown()))
                {                                                   //ctrl+v 粘贴
                    label_Information.setText("粘贴成功");
                }

                else if ((e.getKeyCode() == KeyEvent.VK_X) && (e.isControlDown()))
                {                                                   //ctrl+x 剪切
                    label_Information.setText("剪切成功");
                }

                else if ((e.getKeyCode() == KeyEvent.VK_R) && (e.isControlDown()))
                {                                                   //ctrl+r 模式切换
                    MainPanel.this.EditMode();
                }

                else if ((e.getKeyCode() == KeyEvent.VK_F4) && (e.isControlDown()))
                {                                                   //ctrl+f4 更改清理内存模式
                    MainPanel.this.change_auto_clear_mode();
                }

                else if ((e.getKeyCode() == KeyEvent.VK_F4))
                {                                                   //f4 清理内存
                    System.gc();
                    label_Information.setText("已清理软件内存");
                }

                else if ((e.getKeyCode() == KeyEvent.VK_F3))
                {                                                   //f3 改变自动保存模式
                    MainPanel.this.change_auto_save_mode();
                }

                else if ((e.getKeyCode() == KeyEvent.VK_Z) && (e.isControlDown()))
                {                                                   //ctrl+z 撤销
                    MainPanel.this.undo();
                }

                else if ((e.getKeyCode() == KeyEvent.VK_W) && (e.isControlDown()))
                {                                                   //ctrl+w 重做
                    MainPanel.this.redo();
                }
            }
        });

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
            edit_mode.setText("只读模式");
            button_EditMode.setBackground(Color.yellow);
            edit_mode.setBackground(Color.yellow);
            isEditable = false;
            jTextArea.setEditable(false);
            label_Information.setText("当前为只读模式");
        }
        else
        {
            button_EditMode.setText("编辑模式");
            edit_mode.setText("编辑模式");
            button_EditMode.setBackground(Color.green);
            edit_mode.setBackground(Color.green);
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

    private void deleteAll()                                            //清空
    {
        if (jTextArea.getText().length() == 0)
        {
            label_Information.setText("文本域已经清空 无法再清空");
        }
        else
        {
            int result;
            Toolkit.getDefaultToolkit().beep();
            result = JOptionPane.showConfirmDialog(null, "是否清空文本域的所有数据？"
                    , "数据丢失警告", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (result == 0)
            {
                jTextArea.setText("");                                  //清空操作
                label_Information.setText("文本域已清空");
            }
            else if (result == 1)
            {
                label_Information.setText("取消清空");
            }
            else
            {
                label_Information.setText("关闭会话框，取消清空");
            }
        }
    }

    private void change_auto_save_mode()                                //改变自动保存模式
    {
        if (auto_save_mode == 0)                //当前为不自动保存
        {                                           //改成600s
            auto_save_mode = 1;
            timer_autoSave.setDelay(600000);
            timer_autoSave.start();
            button_autoSave.setText("自动保存:10min");
            button_autoSave.setBackground(Color.green);
            auto_save.setText("自动保存：10min");
            auto_save.setBackground(Color.green);
            label_Information.setText("自动保存设置成10分钟");
        }
        else if (auto_save_mode == 1)               //600s
        {
            auto_save_mode = 2;                     //改成5分钟
            timer_autoSave.setDelay(300000);
            timer_autoSave.stop();
            timer_autoSave.start();
            button_autoSave.setText("自动保存:5min");
            button_autoSave.setBackground(Color.green);
            auto_save.setText("自动保存：5min");
            auto_save.setBackground(Color.green);
            label_Information.setText("自动保存设置成5分钟");
        }
        else if (auto_save_mode == 2)               //300s
        {
            auto_save_mode = 3;                     //改成4分钟
            timer_autoSave.setDelay(240000);
            timer_autoSave.stop();
            timer_autoSave.start();
            button_autoSave.setText("自动保存:4min");
            button_autoSave.setBackground(Color.green);
            auto_save.setText("自动保存:4min");
            auto_save.setBackground(Color.green);
            label_Information.setText("自动保存设置成4分钟");
        }
        else if (auto_save_mode == 3)                 //240s
        {
            auto_save_mode = 4;                     //改成3分钟
            timer_autoSave.stop();
            timer_autoSave.setDelay(180000);
            timer_autoSave.start();
            button_autoSave.setText("自动保存:3min");
            button_autoSave.setBackground(Color.green);
            auto_save.setText("自动保存：3min");
            auto_save.setBackground(Color.green);
            label_Information.setText("自动保存设置成3分钟");
        }
        else if (auto_save_mode == 4)                 //180s
        {
            auto_save_mode = 5;                     //改成2分钟
            timer_autoSave.stop();
            timer_autoSave.setDelay(120000);
            timer_autoSave.start();
            button_autoSave.setText("自动保存:2min");
            button_autoSave.setBackground(Color.green);
            auto_save.setText("自动保存：2min");
            auto_save.setBackground(Color.green);
            label_Information.setText("自动保存设置成2分钟");
        }
        else if (auto_save_mode == 5)                 //120s
        {
            auto_save_mode = 6;                     //改成90s
            timer_autoSave.stop();
            timer_autoSave.setDelay(90000);
            timer_autoSave.start();
            button_autoSave.setText("自动保存：90s");
            button_autoSave.setBackground(Color.green);
            auto_save.setText("自动保存：90s");
            auto_save.setBackground(Color.green);
            label_Information.setText("自动保存设置成90秒");
        }
        else if (auto_save_mode == 6)                 //90s
        {
            auto_save_mode = 7;                     //改成60s
            timer_autoSave.stop();
            timer_autoSave.setDelay(60000);
            timer_autoSave.start();
            button_autoSave.setText("自动保存：60s");
            button_autoSave.setBackground(Color.green);
            auto_save.setText("自动保存：60s");
            auto_save.setBackground(Color.green);
            label_Information.setText("自动保存设置成60秒");
        }
        else if (auto_save_mode == 7)                 //60s
        {
            auto_save_mode = 8;                     //改成30s
            timer_autoSave.stop();
            timer_autoSave.setDelay(30000);
            timer_autoSave.start();
            button_autoSave.setText("自动保存：30s");
            button_autoSave.setBackground(Color.green);
            auto_save.setText("自动保存：30s");
            auto_save.setBackground(Color.green);
            label_Information.setText("自动保存设置成30秒");
        }
        else if (auto_save_mode == 8)                //30s
        {
            auto_save_mode = 0;                      //关闭自动保存
            button_autoSave.setText("不自动保存");
            timer_autoSave.stop();
            button_autoSave.setBackground(Color.cyan);
            auto_save.setText("不自动保存");
            auto_save.setBackground(Color.cyan);
            label_Information.setText("已关闭自动保存");
        }
    }

    private void undo()                                                 //撤销
    {
        if (undoManager.canUndo())
        {
            undoManager.undo();
            label_Information.setText("已撤销");
        }
        else
        {
            label_Information.setText("撤销失败！");
        }
    }

    private void redo()                                                 //重做
    {
        if (undoManager.canRedo())
        {
            undoManager.redo();
            label_Information.setText("已重做");
        }
        else
        {
            label_Information.setText("重做失败");
        }
    }

    private void init_auto_clear()                                      //初始化自动清理
    {
        ActionListener taskPerformer = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.gc();
            }
        };
        timer_autoClear = new Timer(10000, taskPerformer);
    }

    private void change_auto_clear_mode()                               //改变自动清理模式
    {
        if (isAutoClear)                                //当前为自动清理模式
        {
            isAutoClear = false;
            timer_autoClear.stop();                      //停止
            if (io.Configuration.config == null)                        //如果对象不存在就创建对象
            {
                io.Configuration.config = new data.Configuration();
                Configuration.config_is_not_null = true;
            }
            Configuration.config.setAutoClear(false);
            auto_clear.setBackground(Color.green);
            auto_clear.setText("自动清理");
            label_Information.setText("已取消自动清理内存");
        }
        else                                            //当前为不自动清理模式
        {
            isAutoClear = true;
            timer_autoClear.start();                    //启动
            if (io.Configuration.config == null)                        //如果对象不存在就创建对象
            {
                io.Configuration.config = new data.Configuration();
                Configuration.config_is_not_null = true;
            }
            Configuration.config.setAutoClear(true);
            auto_clear.setBackground(Color.yellow);
            auto_clear.setText("不自动清理");
            label_Information.setText("开始自动清理内存");
        }
    }
}
