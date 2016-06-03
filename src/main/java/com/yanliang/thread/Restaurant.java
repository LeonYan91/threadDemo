package com.yanliang.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yanliang
 * @ClassName Restaurant
 * @Description
 * @Date 2016/5/12
 */
public class Restaurant {

    private Meal meal = null;

    private int mealCount = 0;

    public Chef chef;

    public WaitPerson waitPerson;

    private ExecutorService executorService = Executors.newCachedThreadPool();

    public Restaurant(Chef chef, WaitPerson waitPerson) {
        this.chef = chef;
        this.waitPerson = waitPerson;
    }

    public Restaurant() {

        chef = new Chef(this);
        waitPerson = new WaitPerson(this);

        executorService.execute(chef);
        executorService.execute(waitPerson);

    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public int getMealCount() {
        return mealCount;
    }

    public void setMealCount(int mealCount) {
        this.mealCount = mealCount;
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

//    public static void main(String[] args) {
//        new Restaurant();
//    }

}
