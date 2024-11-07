package com.moonhotels.MoonhotelsHUB.adapter.out.hotellegs;

import java.util.List;

public class HotelLegsResponse {
    private List<Result> results;

    // Getters y Setters
    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    // Clase interna para representar cada resultado de la respuesta
    public static class Result {
        private int room;
        private int meal;
        private boolean canCancel;
        private double price;

        // Getters y Setters
        public int getRoom() {
            return room;
        }

        public void setRoom(int room) {
            this.room = room;
        }

        public int getMeal() {
            return meal;
        }

        public void setMeal(int meal) {
            this.meal = meal;
        }

        public boolean isCanCancel() {
            return canCancel;
        }

        public void setCanCancel(boolean canCancel) {
            this.canCancel = canCancel;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
