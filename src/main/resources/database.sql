CREATE TABLE Boat
(
  BoatID     INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  boatnumber INT(11)
);

CREATE TABLE Booking
(
  BookingID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  startDate DATETIME,
  endDate   DATETIME,
  RoomID    INT(11),
  GuestID   INT(11),
  FOREIGN KEY (RoomID) REFERENCES Room (RoomID),
  FOREIGN KEY (GuestID) REFERENCES Guest (GuestID)
);

CREATE TABLE Guest
(
  GuestID     INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name        VARCHAR(255),
  address     VARCHAR(255),
  zipcode     VARCHAR(255),
  city        VARCHAR(255),
  country     VARCHAR(255),
  phonenumber VARCHAR(255),
  email       VARCHAR(255),
  special     VARCHAR(255)
);

CREATE TABLE Room
(
  RoomID     INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  roomnumber INT(11),
  type       VARCHAR(255)
);

CREATE TABLE Trip
(
  TripID    INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  startTime DATETIME,
  endTime   DATETIME,
  type      VARCHAR(255),
  BoatID    INT(11),
  FOREIGN KEY (BoatID) REFERENCES Boat (BoatID)
);