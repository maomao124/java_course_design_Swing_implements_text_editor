import UI.MainPanel;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

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
 * Description(描述)： 无
 */

public class Run
{
    public static void main(String[] args)
    {
        try
        {
            new MainPanel();
        }
        catch (Exception e)
        {
            final Writer result = new StringWriter();
            final PrintWriter printWriter = new PrintWriter(result);
            e.printStackTrace(printWriter);
            String stackTraceStr = result.toString();
            io.ErrorLog.write(stackTraceStr);
        }
    }
}
