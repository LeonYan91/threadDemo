package com.yanliang.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author yanliang
 * @ClassName Chef
 * @Description
 * @Date 2016/5/12
 */
public class Chef implements Runnable{

    private Restaurant restaurant;


    public Chef(Restaurant restaurant) {
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
                    while (restaurant.getMeal() != null){
                        this.wait();
                    }

                    if(restaurant.getMealCount() >= 10){
                        System.out.println("out of meal,shut down restaurant!");
                        restaurant.getExecutorService().shutdownNow();
                    }

                    Meal meal = new Meal(restaurant.getMealCount()+1);
                    System.out.println("cook another meal order"+meal.getOrder()+"!");

                    restaurant.setMeal(meal);
                    restaurant.setMealCount(meal.getOrder());

                    TimeUnit.MILLISECONDS.sleep(100);
                    synchronized(restaurant.waitPerson){
                        restaurant.waitPerson.notifyAll();
                    }
                }
            }
        }catch (InterruptedException e){
            System.out.println("chef inter");
        }

    }
}
