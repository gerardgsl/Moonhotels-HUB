package com.moonhotels.MoonhotelsHUB.domain.model;

import java.util.List;

public class HubSearchResponse {

    private List<Room> rooms;

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public static class Room {
        private int roomId;
        private List<Rate> rates;

        public int getRoomId() {
            return roomId;
        }

        public void setRoomId(int roomId) {
            this.roomId = roomId;
        }

        public List<Rate> getRates() {
            return rates;
        }

        public void setRates(List<Rate> rates) {
            this.rates = rates;
        }
    }

    public static class Rate {
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

        public void setIsCancellable(boolean cancellable) {
            isCancellable = cancellable;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
