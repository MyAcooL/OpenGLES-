package com.yasuion.opengldemo1;

import com.yasuion.opengldemo1.utils.OpenGLUtils;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Create by AcooL 2017/12/12
 */

public class Points extends OpenGLUtils {

    private IntBuffer verBuffer;
    private IntBuffer colorBuffer;
    private ByteBuffer indBuffer;

    public Points() {
        init();
    }

    private void init() {
        // 定点个数
        int vcount=4;
        int UNIT_SIZE = 10000;//缩放比例
        // 定点数据(x y z)
        int ver[]=new int[]{
                -2*UNIT_SIZE,3*UNIT_SIZE,0,
                2*UNIT_SIZE,-3*UNIT_SIZE,0,
                2*UNIT_SIZE,3*UNIT_SIZE,0,
                -2*UNIT_SIZE,-3*UNIT_SIZE,0
        };
        verBuffer = getIntBuffer(ver);// 顶点数据缓冲
        //顶点颜色
        int one = 65535;//支持65535色彩通道

        int color[]=new int[]{
                0,one,0,0,
                0,one,0,0,
                0,one,0,0,
                0,one,0,0
        };
        colorBuffer = getIntBuffer(color);// 定点颜色数据缓冲

        byte indices[]=new byte[]{
                0,3,2,1
        };
        indBuffer = getByteBuffer(indices);// 索引数据缓冲

    }
    public void drawSelf(GL10 gl){
        // 启用顶点坐标数组
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        // 启用顶点颜色数组
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        // 设置画笔
        // 为画笔指定顶点数据坐标 //坐标个数（ xyz） //顶点的数据类型 //连续顶点坐标数据的间隔 //顶点数据缓冲
        gl.glVertexPointer(3,GL10.GL_FIXED,0,verBuffer);
        // 为画笔指定顶点颜色数据  //颜色值组成（ RGBA） ,//数据类型   //连续顶点坐标数据的间隔 //顶点颜色数据缓冲
        gl.glColorPointer(4,GL10.GL_FIXED,0,colorBuffer);
        // 设置绘制点的大小
        gl.glPointSize(10);///设置绘制的顶点大小
        // 索引法绘制   //绘制模型（点 线段 三角形 ） //索引个数 ,//数据类型 //索引数据缓冲
        gl.glDrawElements(GL10.GL_TRIANGLE_FAN,4,GL10.GL_UNSIGNED_BYTE,indBuffer);

    }


}
