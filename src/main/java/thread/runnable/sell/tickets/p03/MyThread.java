package thread.runnable.sell.tickets.p03;
public class MyThread implements Runnable
{
    private int ticket = 10;
    @Override
    public void run()
    {
        //synchronized (this)
        //{
            for (int i = 0; i < 10; i++)
            {
                try
                {
                    Thread.sleep(500);
                } catch (InterruptedException e)
                {
                    // TODO 自动生成的 catch 块
                    e.printStackTrace();
                }
                if (ticket > 0)
                    System.out.println("车票 :" + ticket--);
            }
        //}
    }
}