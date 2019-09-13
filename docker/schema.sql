CREATE DATABASE fleet /*!40100 DEFAULT CHARACTER SET cp1250 COLLATE cp1250_croatian_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE fleet;

CREATE TABLE if not exists cargroups (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  carGroup varchar(255) COLLATE cp1250_croatian_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

CREATE TABLE if not exists car_manufacturers (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  carManufacturer varchar(255) COLLATE cp1250_croatian_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;


CREATE TABLE if not exists car_models (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  carModel varchar(255) COLLATE cp1250_croatian_ci NOT NULL,
  manufacturer_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FKjgd61a3x9e3orkbqrqvm97w8f (manufacturer_id),
  CONSTRAINT FKjgd61a3x9e3orkbqrqvm97w8f FOREIGN KEY (manufacturer_id) REFERENCES car_manufacturers (id)
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

CREATE TABLE if not exists damagesizes (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  size varchar(255) COLLATE cp1250_croatian_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

CREATE TABLE if not exists damagetypes (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  type varchar(255) COLLATE cp1250_croatian_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

CREATE TABLE if not exists fueltypes (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  type varchar(255) COLLATE cp1250_croatian_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

CREATE TABLE if not exists engines (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  capacity float NOT NULL,
  consumption float NOT NULL,
  maxPower float NOT NULL,
  fuel_type_id bigint(20) NOT NULL,
  PRIMARY KEY (id),
  KEY FKamwmrcqhstriuwpmprnr2iw7w (fuel_type_id),
  CONSTRAINT FKamwmrcqhstriuwpmprnr2iw7w FOREIGN KEY (fuel_type_id) REFERENCES fueltypes (id)
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

CREATE TABLE if not exists navigationmodels (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  model varchar(255) COLLATE cp1250_croatian_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

CREATE TABLE if not exists navigations (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  navigation_model_id bigint(20) NOT NULL,
  PRIMARY KEY (id),
  KEY FKjch4pyak1pqgrbcadp78cd88a (navigation_model_id),
  CONSTRAINT FKjch4pyak1pqgrbcadp78cd88a FOREIGN KEY (navigation_model_id) REFERENCES navigationmodels (id)
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

CREATE TABLE if not exists options (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  amount int(11) NOT NULL,
  code varchar(255) COLLATE cp1250_croatian_ci NOT NULL,
  name varchar(255) COLLATE cp1250_croatian_ci NOT NULL,
  price float NOT NULL,
  group_id bigint(20) NOT NULL,
  PRIMARY KEY (id),
  KEY FKt0im5gdaye1jyhn6v6byayq4b (group_id),
  CONSTRAINT FKt0im5gdaye1jyhn6v6byayq4b FOREIGN KEY (group_id) REFERENCES cargroups (id)
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

CREATE TABLE if not exists roles (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(255) COLLATE cp1250_croatian_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

CREATE TABLE if not exists specifications (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  doors int(11) NOT NULL,
  fuelTankCapacity int(11) NOT NULL,
  numberOfSeats int(11) NOT NULL,
  topSpeed float NOT NULL,
  engine_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK7mr6hbweu3fjaurf3mxqmef99 (engine_id),
  CONSTRAINT FK7mr6hbweu3fjaurf3mxqmef99 FOREIGN KEY (engine_id) REFERENCES engines (id)
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

CREATE TABLE if not exists tirebrands (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  brand varchar(255) COLLATE cp1250_croatian_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

CREATE TABLE if not exists tiretypes (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  type varchar(255) COLLATE cp1250_croatian_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

CREATE TABLE if not exists wheeltypes (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  type varchar(255) COLLATE cp1250_croatian_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

CREATE TABLE if not exists workinghours (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  holidayET datetime DEFAULT NULL,
  holidayST datetime DEFAULT NULL,
  saturdayET datetime DEFAULT NULL,
  saturdayST datetime DEFAULT NULL,
  sundayET datetime DEFAULT NULL,
  sundayST datetime DEFAULT NULL,
  workdayET datetime DEFAULT NULL,
  workdayST datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

CREATE TABLE if not exists users (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  createTS datetime DEFAULT CURRENT_TIMESTAMP,
  email varchar(255) COLLATE cp1250_croatian_ci NOT NULL,
  lastChangeTS datetime DEFAULT CURRENT_TIMESTAMP,
  password varchar(255) COLLATE cp1250_croatian_ci NOT NULL,
  username varchar(255) COLLATE cp1250_croatian_ci NOT NULL,
  office_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

CREATE TABLE if not exists user_roles (
  user_id bigint(20) NOT NULL,
  role_id bigint(20) NOT NULL,
  KEY FKh8ciramu9cc9q3qcqiv4ue8a6 (role_id),
  KEY FKhfh9dx7w3ubf1co1vdev94g3f (user_id),
  CONSTRAINT FKh8ciramu9cc9q3qcqiv4ue8a6 FOREIGN KEY (role_id) REFERENCES roles (id),
  CONSTRAINT FKhfh9dx7w3ubf1co1vdev94g3f FOREIGN KEY (user_id) REFERENCES users (id)
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

CREATE TABLE if not exists offices (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  address varchar(255) COLLATE cp1250_croatian_ci NOT NULL,
  name varchar(255) COLLATE cp1250_croatian_ci NOT NULL,
  workingHours_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK8nu18o4t0r0wd81d7sat62efj (workingHours_id),
  CONSTRAINT FK8nu18o4t0r0wd81d7sat62efj FOREIGN KEY (workingHours_id) REFERENCES workinghours (id)
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

CREATE TABLE if not exists tires (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  aspectRatio int(11) DEFAULT NULL,
  manufacturingYear int(11) DEFAULT NULL,
  wheelDiameter int(11) DEFAULT NULL,
  width int(11) DEFAULT NULL,
  tire_brand_id bigint(20) NOT NULL,
  tire_type_id bigint(20) NOT NULL,
  wheel_type_id bigint(20) NOT NULL,
  PRIMARY KEY (id),
  KEY FKq4kim0cvni33mu64upc7nukur (tire_brand_id),
  KEY FKp2bmj6l1i454lhp1lr76g3ke0 (tire_type_id),
  KEY FKnjvh78o03sn62bs7srfnj5q4q (wheel_type_id),
  CONSTRAINT FKnjvh78o03sn62bs7srfnj5q4q FOREIGN KEY (wheel_type_id) REFERENCES wheeltypes (id),
  CONSTRAINT FKp2bmj6l1i454lhp1lr76g3ke0 FOREIGN KEY (tire_type_id) REFERENCES tiretypes (id),
  CONSTRAINT FKq4kim0cvni33mu64upc7nukur FOREIGN KEY (tire_brand_id) REFERENCES tirebrands (id)
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

CREATE TABLE if not exists damages (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  location varchar(255) COLLATE cp1250_croatian_ci NOT NULL,
  repaired bit(1) NOT NULL,
  damage_size_id bigint(20) NOT NULL,
  damage_type_id bigint(20) NOT NULL,
  vehicle_id bigint(20) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

CREATE TABLE if not exists res_options (
  res_id bigint(20) NOT NULL,
  option_id bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

CREATE TABLE if not exists reservations (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  checkInTime datetime NOT NULL,
  checkOutTime datetime NOT NULL,
  group_id bigint(20) NOT NULL,
  checkIn_office_id bigint(20) DEFAULT NULL,
  checkOut_office_id bigint(20) DEFAULT NULL,
  user_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

CREATE TABLE if not exists vehicles (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  VIN varchar(17) COLLATE cp1250_croatian_ci DEFAULT NULL,
  currentKM int(11) DEFAULT '0',
  fuelLevel int(11) DEFAULT '0',
  manufactoringYear int(11) NOT NULL,
  registrationNumber varchar(255) COLLATE cp1250_croatian_ci DEFAULT NULL,
  group_id bigint(20) NOT NULL,
  manufacturer_id bigint(20) DEFAULT NULL,
  model_id bigint(20) DEFAULT NULL,
  nagivation_id bigint(20) DEFAULT NULL,
  spec_id bigint(20) DEFAULT NULL,
  tire_id bigint(20) DEFAULT NULL,
  office_id bigint(20) DEFAULT NULL,
  rented bit(1) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_8ylx4aeqdhg29wtax7upk3wxn (VIN)
) ENGINE=InnoDB DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

ALTER TABLE users
	ADD KEY FKikayxh0uod2b6heppb3qs7t4 (office_id),
	ADD CONSTRAINT FKikayxh0uod2b6heppb3qs7t4 FOREIGN KEY (office_id) REFERENCES offices (id);

ALTER TABLE damages
  ADD KEY FK2ljd2uv48s9bxljjeth4ci02h (damage_size_id),
  ADD KEY FKpre4c5x78cafverippwqkus34 (damage_type_id),
  ADD KEY FK8v6wrvlsajkbelqks5dyrcl3t (vehicle_id),
  ADD CONSTRAINT FK2ljd2uv48s9bxljjeth4ci02h FOREIGN KEY (damage_size_id) REFERENCES damagesizes (id),
  ADD CONSTRAINT FK8v6wrvlsajkbelqks5dyrcl3t FOREIGN KEY (vehicle_id) REFERENCES vehicles (id),
  ADD CONSTRAINT FKpre4c5x78cafverippwqkus34 FOREIGN KEY (damage_type_id) REFERENCES damagetypes (id);
 
ALTER TABLE res_options
  ADD KEY FKaq8pjv9e4i753ht3ndxbpbq9 (option_id),
  ADD KEY FKi72don4nynwi7b13rb45dir5e (res_id),
  ADD CONSTRAINT FKaq8pjv9e4i753ht3ndxbpbq9 FOREIGN KEY (option_id) REFERENCES options (id),
  ADD CONSTRAINT FKi72don4nynwi7b13rb45dir5e FOREIGN KEY (res_id) REFERENCES reservations (id);
  
ALTER TABLE reservations
  ADD KEY FKm5x9wb96ombtg7v4dwp2uwjgs (group_id),
  ADD KEY FKo5f8hv6bfr6s7dlf4n6lvay6e (checkIn_office_id),
  ADD KEY FKa812gf3ry2oypy0jda9gsvvro (checkOut_office_id),
  ADD KEY FKb5g9io5h54iwl2inkno50ppln (user_id),
  ADD CONSTRAINT FKa812gf3ry2oypy0jda9gsvvro FOREIGN KEY (checkOut_office_id) REFERENCES offices (id),
  ADD CONSTRAINT FKb5g9io5h54iwl2inkno50ppln FOREIGN KEY (user_id) REFERENCES users (id),
  ADD CONSTRAINT FKm5x9wb96ombtg7v4dwp2uwjgs FOREIGN KEY (group_id) REFERENCES cargroups (id),
  ADD CONSTRAINT FKo5f8hv6bfr6s7dlf4n6lvay6e FOREIGN KEY (checkIn_office_id) REFERENCES offices (id);
  
ALTER TABLE vehicles 
  ADD KEY FKf2numpd2cdhyfh5lhaqpvm214 (group_id),
  ADD KEY FKbg9uc2qw2nh0fqn1f1p139oii (manufacturer_id),
  ADD KEY FK5jw64qbvx7beeioruiprux28b (model_id),
  ADD KEY FKo61hwu4kvl9i667e0jk9ogrfj (nagivation_id),
  ADD KEY FK23udmn3d1g2r2bpxu0ky91qjq (spec_id),
  ADD KEY FKeiqmljhlttf39s3pnex33xfyw (tire_id),
  ADD KEY FK2uofoxrng4ep85432v1mdq17w (office_id),
  ADD CONSTRAINT FK23udmn3d1g2r2bpxu0ky91qjq FOREIGN KEY (spec_id) REFERENCES specifications (id),
  ADD CONSTRAINT FK2uofoxrng4ep85432v1mdq17w FOREIGN KEY (office_id) REFERENCES offices (id),
  ADD CONSTRAINT FK5jw64qbvx7beeioruiprux28b FOREIGN KEY (model_id) REFERENCES car_models (id),
  ADD CONSTRAINT FKbg9uc2qw2nh0fqn1f1p139oii FOREIGN KEY (manufacturer_id) REFERENCES car_manufacturers (id),
  ADD CONSTRAINT FKeiqmljhlttf39s3pnex33xfyw FOREIGN KEY (tire_id) REFERENCES tires (id),
  ADD CONSTRAINT FKf2numpd2cdhyfh5lhaqpvm214 FOREIGN KEY (group_id) REFERENCES cargroups (id),
  ADD CONSTRAINT FKo61hwu4kvl9i667e0jk9ogrfj FOREIGN KEY (nagivation_id) REFERENCES navigations (id);