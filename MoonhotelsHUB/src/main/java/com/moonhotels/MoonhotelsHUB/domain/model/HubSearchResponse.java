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
}