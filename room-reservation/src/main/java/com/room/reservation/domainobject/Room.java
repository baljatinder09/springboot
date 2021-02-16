package com.room.reservation.domainobject;

/*ROOM_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
NAME VARCHAR(16) NOT NULL,
ROOM_NUMBER CHAR(2) NOT NULL UNIQUE,
BED_INFO CHAR(2) NOT NULL*/
public class Room {
	
	private Long id;
	private String name;
    private String roomNumber;
    private String bedInfo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getBedInfo() {
		return bedInfo;
	}
	public void setBedInfo(String bedInfo) {
		this.bedInfo = bedInfo;
	}
    
}
