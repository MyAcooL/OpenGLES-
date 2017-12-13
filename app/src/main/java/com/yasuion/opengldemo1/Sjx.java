package com.yasuion.opengldemo1;



import com.yasuion.opengldemo1.utils.OpenGLUtils;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * 创建时间：2017/12/2
 *
 * @author 苏青岩
 */
//第三步：创建  算法类 进行顶点计算
public class Sjx extends OpenGLUtils {

    private FloatBuffer verBuffer, colorBuffer;
    private ByteBuffer indBuffer;
    private int verNum;

    public Sjx() {
        //3.1初始化（顶点 颜色 索引）
        init();
    }

    private void init() {
        //边长 (角度)
        int length = 45;
        //顶点个数
        verNum = (360 / length + 2);
        //顶点坐标容器
        float ver[] = new float[verNum * 3];
        //计数器
        int count = 0;
        //第一个点坐标
        ver[count++] = 0;
        ver[count++] = 0;
        ver[count++] = 0;
        for (int i = 0; i < 360 + length; i += length) {
            ver[count++] = (float) (Math.cos(Math.toRadians(i)) - Math.sin(Math.toRadians(i)));
            ver[count++] = (float) (Math.cos(Math.toRadians(i)) + Math.sin(Math.toRadians(i)));
            ver[count++] = 0;
        }
        verBuffer = getFloatbuffer(ver);
        //顶点颜色
        int one = 65535;//支持65535色彩通道
        //顶点颜色数据（R GB A）
        float color[] = new float[]{
                0, one, 0, 0,
                0, one, 0, 0,
                0, one, 0, 0,
                0, one, 0, 0,
                0, one, 0, 0,
                0, one, 0, 0,
                0, one, 0, 0,
                0, one, 0, 0,
                0, one, 0, 0,
                0, one, 0, 0
        };
        //创建顶点颜色缓冲
        colorBuffer = getFloatbuffer(color);

    }

    //第四步 绘制
    public void drawSelf(GL10 gl) {
        //启用顶点坐标数组
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        //启用顶点颜色数组
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        //设置画笔
        //为画笔指定顶点坐标数据
        gl.glVertexPointer(3, //坐标个数（ xyz）
                GL10.GL_FLOAT,//顶点的数据类型
                0, //连续顶点坐标数据的间隔
                verBuffer);//顶点数据缓冲

        //为画笔指定顶点颜色数据
        gl.glColorPointer(4, //颜色值组成（ RGBA）
                GL10.GL_FLOAT,//数据类型
                0, //连续顶点坐标数据的间隔
                colorBuffer);//顶点颜色数据缓冲
        gl.glPointSize(10);///设置绘制的顶点大小
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, //绘制的图元
                0, //从数组缓存的那一一位开始绘制 ，一般0
                verNum);//顶点个数
    }
}
