package com.yanliang.thread;

/**
 * @author yanliang
 * @ClassName WaitPerson
 * @Description
 * @Date 2016/5/12
 */
public class WaitPerson implements Runnable{

    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    while (restaurant.getMeal() == null){
                        wait();
                    }

                    System.out.println("get meal order "+restaurant.getMeal().getOrder()+"!");
                    restaurant.setMeal(null);

                    synchronized (restaurant.chef){
                        restaurant.chef.notifyAll();
                    }
                }
            }
        }catch (InterruptedException e){
            System.out.println("waitperson interrupted!");
        }
    }
}
