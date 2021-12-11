package data;

import java.io.Serializable;

/**
 * Project name(项目名称)：java课程设计 Swing实现文本编辑器
 * Package(包名): data
 * Class(类名): Configuration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/9
 * Time(创建时间)： 13:04
 * Version(版本): 1.0
 * Description(描述)： 配置文件的数据类 可序列化
 */

public class Configuration implements Serializable
{
    private int width = 1280;                       //窗口大小 默认1280*720
    private int height = 720;

    private String fontName = "宋体";              //字体设置
    private int fontStyle = 0;
    private int fontSize = 20;

    private int font_color_r = 0;                //字体颜色 默认黑色
    private int font_color_g = 0;
    private int font_color_b = 0;

    private int cursor_color_r = 0;              //光标颜色 默认黑色
    private int cursor_color_g = 0;
    private int cursor_color_b = 0;

    private int background_color_r = 255;         //背景颜色 默认白色
    private int background_color_g = 255;
    private int background_color_b = 255;

    private int selected_color_r = 0;             //选择颜色 默认白色
    private int selected_color_g = 0;
    private int selected_color_b = 0;

    private int rendering_color_r = 0;           //渲染颜色 默认天蓝色
    private int rendering_color_g = 160;
    private int rendering_color_b = 200;

    private int Layout_left = 30;                //边框大小
    private int Layout_right = 30;
    private int Layout_up = 0;
    private int Layout_down = 15;

    boolean wrap = true;                         //文本域是否换行
    boolean isAutoClear = false;                   //是否自动清理


    public Configuration()                       //无参构造方法
    {

    }

    public int getWidth()                          //get和set方法
    {
        return width;
    }

    public void setWidth(int width)
    {
        if (width >= 0)
        {
            this.width = width;
        }
        else
        {
            this.width = 0;
        }
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        if (height >= 0)
        {
            this.height = height;
        }
        else
        {
            this.height = 0;
        }
    }

    public String getFontName()
    {
        return fontName;
    }

    public void setFontName(String fontName)
    {
        this.fontName = fontName;
    }

    public int getFontStyle()
    {
        return fontStyle;
    }

    public void setFontStyle(int fontStyle)
    {
        if (fontStyle >= 0)
        {
            this.fontStyle = fontStyle;
        }
        else
        {
            this.fontStyle = 0;
        }
    }

    public int getFontSize()
    {
        return fontSize;
    }

    public void setFontSize(int fontSize)
    {
        if (fontSize >= 0)
        {
            this.fontSize = fontSize;
        }
        else
        {
            this.fontSize = 0;
        }
    }

    public int getFont_color_r()
    {
        return font_color_r;
    }

    public void setFont_color_r(int font_color_r)
    {
        if (font_color_r > 255)
        {
            font_color_r = 255;
        }
        if (font_color_r >= 0)
        {
            this.font_color_r = font_color_r;
        }
        else
        {
            this.font_color_r = 0;
        }
    }

    public int getFont_color_g()
    {
        return font_color_g;
    }

    public void setFont_color_g(int font_color_g)
    {
        if (font_color_g > 255)
        {
            font_color_g = 255;
        }
        if (font_color_g >= 0)
        {
            this.font_color_g = font_color_g;
        }
        else
        {
            this.font_color_g = 0;
        }
    }

    public int getFont_color_b()
    {
        return font_color_b;
    }

    public void setFont_color_b(int font_color_b)
    {
        if (font_color_b > 255)
        {
            font_color_b = 255;
        }
        if (font_color_b >= 0)
        {
            this.font_color_b = font_color_b;
        }
        else
        {
            this.font_color_b = 0;
        }
    }

    public int getCursor_color_r()
    {
        return cursor_color_r;
    }

    public void setCursor_color_r(int cursor_color_r)
    {
        if (cursor_color_r > 255)
        {
            cursor_color_r = 255;
        }
        if (cursor_color_r >= 0)
        {
            this.cursor_color_r = cursor_color_r;
        }
        else
        {
            this.cursor_color_r = 0;
        }
    }

    public int getCursor_color_g()
    {
        return cursor_color_g;
    }

    public void setCursor_color_g(int cursor_color_g)
    {
        if (cursor_color_g > 255)
        {
            cursor_color_g = 255;
        }
        if (cursor_color_g >= 0)
        {
            this.cursor_color_g = cursor_color_g;
        }
        else
        {
            this.cursor_color_g = 0;
        }
    }

    public int getCursor_color_b()
    {
        return cursor_color_b;
    }

    public void setCursor_color_b(int cursor_color_b)
    {
        if (cursor_color_b > 255)
        {
            cursor_color_b = 255;
        }
        if (cursor_color_b >= 0)
        {
            this.cursor_color_b = cursor_color_b;
        }
        else
        {
            this.cursor_color_b = 0;
        }
    }

    public int getBackground_color_r()
    {
        return background_color_r;
    }

    public void setBackground_color_r(int background_color_r)
    {
        if (background_color_r > 255)
        {
            background_color_r = 255;
        }
        if (background_color_r >= 0)
        {
            this.background_color_r = background_color_r;
        }
        else
        {
            this.background_color_r = 0;
        }
    }

    public int getBackground_color_g()
    {
        return background_color_g;
    }

    public void setBackground_color_g(int background_color_g)
    {
        if (background_color_g > 255)
        {
            background_color_g = 255;
        }
        if (background_color_g >= 0)
        {
            this.background_color_g = background_color_g;
        }
        else
        {
            this.background_color_g = 0;
        }
    }

    public int getBackground_color_b()
    {
        return background_color_b;
    }

    public void setBackground_color_b(int background_color_b)
    {
        if (background_color_b > 255)
        {
            background_color_b = 255;
        }
        if (background_color_b >= 0)
        {
            this.background_color_b = background_color_b;
        }
        else
        {
            this.background_color_b = 0;
        }
    }

    public int getSelected_color_r()
    {
        return selected_color_r;
    }

    public void setSelected_color_r(int selected_color_r)
    {
        if (selected_color_r > 255)
        {
            selected_color_r = 255;
        }
        if (selected_color_r >= 0)
        {
            this.selected_color_r = selected_color_r;
        }
        else
        {
            this.selected_color_r = 0;
        }
    }

    public int getSelected_color_g()
    {
        return selected_color_g;
    }

    public void setSelected_color_g(int selected_color_g)
    {
        if (selected_color_g > 255)
        {
            selected_color_g = 255;
        }
        if (selected_color_g >= 0)
        {
            this.selected_color_g = selected_color_g;
        }
        else
        {
            this.selected_color_g = 0;
        }
    }

    public int getSelected_color_b()
    {
        return selected_color_b;
    }

    public void setSelected_color_b(int selected_color_b)
    {
        if (selected_color_b > 255)
        {
            selected_color_b = 255;
        }
        if (selected_color_b >= 0)
        {
            this.selected_color_b = selected_color_b;
        }
        else
        {
            this.selected_color_b = 0;
        }
    }

    public int getRendering_color_r()
    {
        return rendering_color_r;
    }

    public void setRendering_color_r(int rendering_color_r)
    {
        if (rendering_color_r > 255)
        {
            rendering_color_r = 255;
        }
        if (rendering_color_r >= 0)
        {
            this.rendering_color_r = rendering_color_r;
        }
        else
        {
            this.rendering_color_r = 0;
        }
    }

    public int getRendering_color_g()
    {
        return rendering_color_g;
    }

    public void setRendering_color_g(int rendering_color_g)
    {
        if (rendering_color_g > 255)
        {
            rendering_color_g = 255;
        }
        if (rendering_color_g >= 0)
        {
            this.rendering_color_g = rendering_color_g;
        }
        else
        {
            this.rendering_color_g = 0;
        }
    }

    public int getRendering_color_b()
    {
        return rendering_color_b;
    }

    public void setRendering_color_b(int rendering_color_b)
    {
        if (rendering_color_b > 255)
        {
            rendering_color_b = 255;
        }
        if (rendering_color_b >= 0)
        {
            this.rendering_color_b = rendering_color_b;
        }
        else
        {
            this.rendering_color_b = 0;
        }
    }

    public int getLayout_left()
    {
        return Layout_left;
    }

    public void setLayout_left(int layout_left)
    {
        if (layout_left >= 0)
        {
            this.Layout_left = layout_left;
        }
        else
        {
            this.Layout_left = 0;
        }
    }

    public int getLayout_right()
    {
        return Layout_right;
    }

    public void setLayout_right(int layout_right)
    {
        if (layout_right >= 0)
        {
            this.Layout_right = layout_right;
        }
        else
        {
            this.Layout_right = 0;
        }
    }

    public int getLayout_up()
    {
        return Layout_up;
    }

    public void setLayout_up(int layout_up)
    {
        if (layout_up >= 0)
        {
            this.Layout_up = layout_up;
        }
        else
        {
            this.Layout_up = 0;
        }
    }

    public int getLayout_down()
    {
        return Layout_down;
    }

    public void setLayout_down(int layout_down)
    {
        if (layout_down >= 0)
        {
            this.Layout_down = layout_down;
        }
        else
        {
            this.Layout_down = 0;
        }
    }

    public boolean isWrap()
    {
        return wrap;
    }

    public void setWrap(boolean wrap)
    {
        this.wrap = wrap;
    }

    public boolean isAutoClear()
    {
        return isAutoClear;
    }

    public void setAutoClear(boolean autoClear)
    {
        isAutoClear = autoClear;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)      //引用同一个对象
        {
            return true;
        }
        if (o == null)      //检测obj是否为null
        {
            return false;
        }
        //if(!(otherObject instanceof ClassName)) //如果所有的子类都拥有统一的语义
        if (this.getClass() != o.getClass())   //比较this与obj是否属于同一个类
        {
            return false;
        }

        //Object类向下转型
        Configuration that = (Configuration) o;

        if (width != that.width)
        {
            return false;
        }
        if (height != that.height)
        {
            return false;
        }
        if (fontStyle != that.fontStyle)
        {
            return false;
        }
        if (fontSize != that.fontSize)
        {
            return false;
        }
        if (font_color_r != that.font_color_r)
        {
            return false;
        }
        if (font_color_g != that.font_color_g)
        {
            return false;
        }
        if (font_color_b != that.font_color_b)
        {
            return false;
        }
        if (cursor_color_r != that.cursor_color_r)
        {
            return false;
        }
        if (cursor_color_g != that.cursor_color_g)
        {
            return false;
        }
        if (cursor_color_b != that.cursor_color_b)
        {
            return false;
        }
        if (background_color_r != that.background_color_r)
        {
            return false;
        }
        if (background_color_g != that.background_color_g)
        {
            return false;
        }
        if (background_color_b != that.background_color_b)
        {
            return false;
        }
        if (selected_color_r != that.selected_color_r)
        {
            return false;
        }
        if (selected_color_g != that.selected_color_g)
        {
            return false;
        }
        if (selected_color_b != that.selected_color_b)
        {
            return false;
        }
        if (rendering_color_r != that.rendering_color_r)
        {
            return false;
        }
        if (rendering_color_g != that.rendering_color_g)
        {
            return false;
        }
        if (rendering_color_b != that.rendering_color_b)
        {
            return false;
        }
        if (Layout_left != that.Layout_left)
        {
            return false;
        }
        if (Layout_right != that.Layout_right)
        {
            return false;
        }
        if (Layout_up != that.Layout_up)
        {
            return false;
        }
        if (Layout_down != that.Layout_down)
        {
            return false;
        }
        if (wrap != that.wrap)
        {
            return false;
        }
        if (isAutoClear != that.isAutoClear)
        {
            return false;
        }
        return fontName.equals(that.fontName);
    }

    @Override
    public int hashCode()
    {
        int result = width;
        result = 31 * result + height;
        result = 31 * result + fontName.hashCode();
        result = 31 * result + fontStyle;
        result = 31 * result + fontSize;
        result = 31 * result + font_color_r;
        result = 31 * result + font_color_g;
        result = 31 * result + font_color_b;
        result = 31 * result + cursor_color_r;
        result = 31 * result + cursor_color_g;
        result = 31 * result + cursor_color_b;
        result = 31 * result + background_color_r;
        result = 31 * result + background_color_g;
        result = 31 * result + background_color_b;
        result = 31 * result + selected_color_r;
        result = 31 * result + selected_color_g;
        result = 31 * result + selected_color_b;
        result = 31 * result + rendering_color_r;
        result = 31 * result + rendering_color_g;
        result = 31 * result + rendering_color_b;
        result = 31 * result + Layout_left;
        result = 31 * result + Layout_right;
        result = 31 * result + Layout_up;
        result = 31 * result + Layout_down;
        result = 31 * result + (wrap ? 1 : 0);
        result = 31 * result + (isAutoClear ? 1 : 0);
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("width：").append(width).append('\n');
        stringbuilder.append("height：").append(height).append('\n');
        stringbuilder.append("fontName：").append(fontName).append('\n');
        stringbuilder.append("fontStyle：").append(fontStyle).append('\n');
        stringbuilder.append("fontSize：").append(fontSize).append('\n');
        stringbuilder.append("font_color_r：").append(font_color_r).append('\n');
        stringbuilder.append("font_color_g：").append(font_color_g).append('\n');
        stringbuilder.append("font_color_b：").append(font_color_b).append('\n');
        stringbuilder.append("cursor_color_r：").append(cursor_color_r).append('\n');
        stringbuilder.append("cursor_color_g：").append(cursor_color_g).append('\n');
        stringbuilder.append("cursor_color_b：").append(cursor_color_b).append('\n');
        stringbuilder.append("background_color_r：").append(background_color_r).append('\n');
        stringbuilder.append("background_color_g：").append(background_color_g).append('\n');
        stringbuilder.append("background_color_b：").append(background_color_b).append('\n');
        stringbuilder.append("selected_color_r：").append(selected_color_r).append('\n');
        stringbuilder.append("selected_color_g：").append(selected_color_g).append('\n');
        stringbuilder.append("selected_color_b：").append(selected_color_b).append('\n');
        stringbuilder.append("rendering_color_r：").append(rendering_color_r).append('\n');
        stringbuilder.append("rendering_color_g：").append(rendering_color_g).append('\n');
        stringbuilder.append("rendering_color_b：").append(rendering_color_b).append('\n');
        stringbuilder.append("Layout_left：").append(Layout_left).append('\n');
        stringbuilder.append("Layout_right：").append(Layout_right).append('\n');
        stringbuilder.append("Layout_up：").append(Layout_up).append('\n');
        stringbuilder.append("Layout_down：").append(Layout_down).append('\n');
        stringbuilder.append("wrap：").append(wrap).append('\n');
        stringbuilder.append("isAutoClear：").append(isAutoClear).append('\n');
        return stringbuilder.toString();
    }
}
