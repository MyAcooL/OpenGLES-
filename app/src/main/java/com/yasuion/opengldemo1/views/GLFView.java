package com.yasuion.opengldemo1.views;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

import com.yasuion.opengldemo1.Points;
import com.yasuion.opengldemo1.Sjx;
import com.yasuion.opengldemo1.Sjx2;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Create by AcooL 2017/12/12
 */

public class GLFView extends GLSurfaceView {




    public GLFView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    // 第一步
    private void init() {
        EGLRender render=new EGLRender();
        // 设置渲染器
        setRenderer(render);
        // 设置渲染器模式  主动渲染    //RENDERMODE_WHEN_DIRTY   等待渲染  刷新界面 requestRender()
        setRenderMode(RENDERMODE_CONTINUOUSLY);
    }


    // 第二步 内部类 实现GLSurfaceView.Renderer 接口 设置渲染器内容
    public class EGLRender implements GLSurfaceView.Renderer{
        private Points p;
        private Sjx s1;
        private Sjx2 s2;

        @Override
        public void onSurfaceCreated(GL10 gl, EGLConfig config) {
            // 关闭抗抖动 (对于颜色较少的系统 可以牺牲分辨率 通过颜色抖动来增加颜色的数量)
            gl.glDisable(GL10.GL_DITHER);
            // 设置hint模式(设置为快速模式)
            gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT,GL10.GL_FASTEST);
            // 设置背景颜色 黑色
            gl.glClearColor(0,0,0,0);
            // 开启深度检测
            gl.glEnable(GL10.GL_DEPTH_TEST);

            p = new Points();
            s1 = new Sjx();
            s2 = new Sjx2();
        }

        @Override
        public void onSurfaceChanged(GL10 gl, int width, int height) {

            // 设置视口
            gl.glViewport(0,0,width,height);
            // 设置投影矩阵
            gl.glMatrixMode(GL10.GL_PROJECTION);
            // 设置单位矩阵
            gl.glLoadIdentity();
            // 得到宽高比
            float r=(float) width / height;
            // 设置视角大小
            gl.glFrustumf(-r,r,-1,1,1,20);

        }

        @Override
        public void onDrawFrame(GL10 gl) {
            // 清楚颜色缓存和深度缓存
            gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
            //设置模型矩阵
            gl.glMatrixMode(GL10.GL_MODELVIEW);
            gl.glLoadIdentity();
            gl.glTranslatef(0, 0, -3.0f);//平移
           // p.drawSelf(gl);
            //s1.drawSelf(gl);
            s2.drawSelf(gl);
        }
    }


}
