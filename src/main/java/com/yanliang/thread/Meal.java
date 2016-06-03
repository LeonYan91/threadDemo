package com.yanliang.thread;

/**
 * @author yanliang
 * @ClassName Meal
 * @Description
 * @Date 2016/5/12
 */
public class Meal {
    private int order;

    public Meal(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }


    @Override
    public String toString() {
        return "Meal{" +
                "order=" + order +
                '}';
    }
}
