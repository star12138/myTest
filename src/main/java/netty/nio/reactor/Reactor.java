package netty.nio.reactor;

/**
 * @Auther: Administrator
 * @Date: 2020/6/9 10:31
 * @Description:
 *
 *1、 当其中某个 handler 阻塞时， 会导致其他所有的 client 的 handler 都得不到执行，
 *  并且更严重的是， handler 的阻塞也会导致整个服务不能接收新的 client 请求(因为 acceptor 也被阻塞了)。
 *  因为有这么多的缺陷， 因此单线程Reactor 模型用的比较少。
 *  这种单线程模型不能充分利用多核资源，所以实际使用的不多。
 *
 * 2、因此，单线程模型仅仅适用于handler 中业务处理组件能快速完成的场景。
 *
 *
 *
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

class Reactor implements Runnable
{
    final Selector selector;
    final ServerSocketChannel serverSocket;

    Reactor(int port) throws IOException
    { //Reactor初始化
        selector = Selector.open();
        serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(port));
        //非阻塞
        serverSocket.configureBlocking(false);

        //分步处理,第一步,接收accept事件
        SelectionKey sk =
                serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        //attach callback object, Acceptor
        sk.attach(new Acceptor());
    }

    public void run()
    {
        try
        {
            while (!Thread.interrupted())
            {
                selector.select();
                Set selected = selector.selectedKeys();
                Iterator it = selected.iterator();
                while (it.hasNext())
                {
                    //Reactor负责dispatch收到的事件
                    dispatch((SelectionKey) (it.next()));
                }
                selected.clear();
            }
        } catch (IOException ex)
        { /* ... */ }
    }

    void dispatch(SelectionKey k)
    {
        Runnable r = (Runnable) (k.attachment());
        //调用之前注册的callback对象
        if (r != null)
        {
            r.run();
        }
    }

    // inner class
    class Acceptor implements Runnable
    {
        public void run()
        {
            try
            {
                SocketChannel channel = serverSocket.accept();
                if (channel != null)
                    new Handler(selector, channel);
            } catch (IOException ex)
            { /* ... */ }
        }
    }
}