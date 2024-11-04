package com.moonhotels.MoonhotelsHUB.domain.model;

public class Rate {
    private int mealPlanId;
    private boolean isCancellable;
    private double price;
    
	public int getMealPlanId() {
		return mealPlanId;
	}
	public void setMealPlanId(int mealPlanId) {
		this.mealPlanId = mealPlanId;
	}
	public boolean isCancellable() {
		return isCancellable;
	}
	public void setCancellable(boolean isCancellable) {
		this.isCancellable = isCancellable;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
    
    
}