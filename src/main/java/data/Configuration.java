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

    /**
     * The Wrap.
     */
    boolean wrap = true;                         //文本域是否换行
    /**
     * The Is auto clear.
     */
    boolean isAutoClear = false;                   //是否自动清理


    /**
     * Instantiates a new Configuration.
     */
    public Configuration()                       //无参构造方法
    {

    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public int getWidth()                          //get和set方法
    {
        return width;
    }

    /**
     * Sets width.
     *
     * @param width the width
     */
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

    /**
     * Gets height.
     *
     * @return the height
     */
    public int getHeight()
    {
        return height;
    }

    /**
     * Sets height.
     *
     * @param height the height
     */
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

    /**
     * Gets font name.
     *
     * @return the font name
     */
    public String getFontName()
    {
        return fontName;
    }

    /**
     * Sets font name.
     *
     * @param fontName the font name
     */
    public void setFontName(String fontName)
    {
        this.fontName = fontName;
    }

    /**
     * Gets font style.
     *
     * @return the font style
     */
    public int getFontStyle()
    {
        return fontStyle;
    }

    /**
     * Sets font style.
     *
     * @param fontStyle the font style
     */
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

    /**
     * Gets font size.
     *
     * @return the font size
     */
    public int getFontSize()
    {
        return fontSize;
    }

    /**
     * Sets font size.
     *
     * @param fontSize the font size
     */
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

    /**
     * Gets font color r.
     *
     * @return the font color r
     */
    public int getFont_color_r()
    {
        return font_color_r;
    }

    /**
     * Sets font color r.
     *
     * @param font_color_r the font color r
     */
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

    /**
     * Gets font color g.
     *
     * @return the font color g
     */
    public int getFont_color_g()
    {
        return font_color_g;
    }

    /**
     * Sets font color g.
     *
     * @param font_color_g the font color g
     */
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

    /**
     * Gets font color b.
     *
     * @return the font color b
     */
    public int getFont_color_b()
    {
        return font_color_b;
    }

    /**
     * Sets font color b.
     *
     * @param font_color_b the font color b
     */
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

    /**
     * Gets cursor color r.
     *
     * @return the cursor color r
     */
    public int getCursor_color_r()
    {
        return cursor_color_r;
    }

    /**
     * Sets cursor color r.
     *
     * @param cursor_color_r the cursor color r
     */
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

    /**
     * Gets cursor color g.
     *
     * @return the cursor color g
     */
    public int getCursor_color_g()
    {
        return cursor_color_g;
    }

    /**
     * Sets cursor color g.
     *
     * @param cursor_color_g the cursor color g
     */
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

    /**
     * Gets cursor color b.
     *
     * @return the cursor color b
     */
    public int getCursor_color_b()
    {
        return cursor_color_b;
    }

    /**
     * Sets cursor color b.
     *
     * @param cursor_color_b the cursor color b
     */
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

    /**
     * Gets background color r.
     *
     * @return the background color r
     */
    public int getBackground_color_r()
    {
        return background_color_r;
    }

    /**
     * Sets background color r.
     *
     * @param background_color_r the background color r
     */
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

    /**
     * Gets background color g.
     *
     * @return the background color g
     */
    public int getBackground_color_g()
    {
        return background_color_g;
    }

    /**
     * Sets background color g.
     *
     * @param background_color_g the background color g
     */
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

    /**
     * Gets background color b.
     *
     * @return the background color b
     */
    public int getBackground_color_b()
    {
        return background_color_b;
    }

    /**
     * Sets background color b.
     *
     * @param background_color_b the background color b
     */
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

    /**
     * Gets selected color r.
     *
     * @return the selected color r
     */
    public int getSelected_color_r()
    {
        return selected_color_r;
    }

    /**
     * Sets selected color r.
     *
     * @param selected_color_r the selected color r
     */
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

    /**
     * Gets selected color g.
     *
     * @return the selected color g
     */
    public int getSelected_color_g()
    {
        return selected_color_g;
    }

    /**
     * Sets selected color g.
     *
     * @param selected_color_g the selected color g
     */
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

    /**
     * Gets selected color b.
     *
     * @return the selected color b
     */
    public int getSelected_color_b()
    {
        return selected_color_b;
    }

    /**
     * Sets selected color b.
     *
     * @param selected_color_b the selected color b
     */
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

    /**
     * Gets rendering color r.
     *
     * @return the rendering color r
     */
    public int getRendering_color_r()
    {
        return rendering_color_r;
    }

    /**
     * Sets rendering color r.
     *
     * @param rendering_color_r the rendering color r
     */
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

    /**
     * Gets rendering color g.
     *
     * @return the rendering color g
     */
    public int getRendering_color_g()
    {
        return rendering_color_g;
    }

    /**
     * Sets rendering color g.
     *
     * @param rendering_color_g the rendering color g
     */
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

    /**
     * Gets rendering color b.
     *
     * @return the rendering color b
     */
    public int getRendering_color_b()
    {
        return rendering_color_b;
    }

    /**
     * Sets rendering color b.
     *
     * @param rendering_color_b the rendering color b
     */
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

    /**
     * Gets layout left.
     *
     * @return the layout left
     */
    public int getLayout_left()
    {
        return Layout_left;
    }

    /**
     * Sets layout left.
     *
     * @param layout_left the layout left
     */
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

    /**
     * Gets layout right.
     *
     * @return the layout right
     */
    public int getLayout_right()
    {
        return Layout_right;
    }

    /**
     * Sets layout right.
     *
     * @param layout_right the layout right
     */
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

    /**
     * Gets layout up.
     *
     * @return the layout up
     */
    public int getLayout_up()
    {
        return Layout_up;
    }

    /**
     * Sets layout up.
     *
     * @param layout_up the layout up
     */
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

    /**
     * Gets layout down.
     *
     * @return the layout down
     */
    public int getLayout_down()
    {
        return Layout_down;
    }

    /**
     * Sets layout down.
     *
     * @param layout_down the layout down
     */
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

    /**
     * Is wrap boolean.
     *
     * @return the boolean
     */
    public boolean isWrap()
    {
        return wrap;
    }

    /**
     * Sets wrap.
     *
     * @param wrap the wrap
     */
    public void setWrap(boolean wrap)
    {
        this.wrap = wrap;
    }

    /**
     * Is auto clear boolean.
     *
     * @return the boolean
     */
    public boolean isAutoClear()
    {
        return isAutoClear;
    }

    /**
     * Sets auto clear.
     *
     * @param autoClear the auto clear
     */
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
