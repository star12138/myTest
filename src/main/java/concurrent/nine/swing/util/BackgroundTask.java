package concurrent.nine.swing.util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.*;

/**
 * @Auther: Administrator
 * @Date: 2020/4/26 15:34
 * @Description:
 */
public abstract class BackgroundTask<V> implements Runnable, Future<V>{
    private final FutureTask<V> computation = new Computation();

    private class Computation extends FutureTask<V> {
        public Computation() {
            super(new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return BackgroundTask.this.compute();
                }
            });
        }

        protected final void done() {
            GuiExecutor.instance().execute(new Runnable() {
                @Override
                public void run() {
                    V value = null;
                    Throwable thrown = null;
                    boolean cancelled = false;
                    try {
                        value = get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        thrown = e.getCause();
                    } catch (CancellationException e) {
                        cancelled = true;
                    } finally {
                        onCompletion(value, thrown, cancelled);
                    }

                }
            });
        }
    }

    // 在事件线程中调用
    protected void onCompletion(V value, Throwable thrown, boolean cancelled){};

    // 在后台线程中调用
    protected abstract V compute() throws Exception;

    // 其他用于完成计算的方法
    protected void onProgress(int current, int max){}

}
