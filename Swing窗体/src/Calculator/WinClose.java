package Calculator;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class WinClose implements WindowListener
{
    @Override
    public void windowClosing(WindowEvent e )    //单击窗口关闭按钮时触发并执行实现窗口监听器接口中的方法
    {
        System.exit( 0 );          //结束程序运行
    }
    @Override
    public void windowOpened(WindowEvent e ){ }
    @Override
    public void windowActivated(WindowEvent e ){}
    @Override
    public void windowDeactivated(WindowEvent e){ }
    @Override
    public void windowClosed(WindowEvent e ){ }
    @Override
    public void windowIconified(WindowEvent e ){ }
    @Override
    public void windowDeiconified(WindowEvent e ){ }
}