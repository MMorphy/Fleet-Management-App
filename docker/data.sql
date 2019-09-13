use fleet;

insert ignore into roles(id,name) values(1, 'ROLE_ADMIN');
insert ignore into roles(id,name) values(2, 'ROLE_USER');
insert ignore into roles(id,name) values(3, 'ROLE_OPER');

insert ignore into users(id,username, password) values(1,'admin','$2a$10$1ze0QIC1X355x6IBDanMDuf9ZP3o/WDjRAK2mtHECnRZlI4oO8H.W');

insert ignore into user_roles(user_id, role_id) values(1, 1);
insert ignore into user_roles(user_id, role_id) values(1, 2);
insert ignore into user_roles(user_id, role_id) values(1, 3);

insert ignore into cargroups(id,carGroup) values(1,'Mini');
insert ignore into options(id,amount,code,name,price,group_id) values(1,1,'T','Rental days',20,1);
insert ignore into options(id,amount,code,name,price,group_id) values(2,1,'GF','Body insurance',10,1);
insert ignore into options(id,amount,code,name,price,group_id) values(3,1,'TG','Tire and glass insurance',7,1);
insert ignore into options(id,amount,code,name,price,group_id) values(4,1,'TI','Third party insurance',3,1);
insert ignore into options(id,amount,code,name,price,group_id) values(5,1,'TP','Theft protection',2,1);
insert ignore into options(id,amount,code,name,price,group_id) values(6,1,'PAP','Personal accident protection',5,1);
insert ignore into options(id,amount,code,name,price,group_id) values(7,1,'IT','Internation travel',16,1);
insert ignore into options(id,amount,code,name,price,group_id) values(8,1,'NV','Navigation',4,1);
insert ignore into options(id,amount,code,name,price,group_id) values(9,1,'PF','Prepaid fuel',1.3,1);
insert ignore into options(id,amount,code,name,price,group_id) values(10,1,'DM','Damage',100,1);
insert ignore into options(id,amount,code,name,price,group_id) values(11,1,'DD','Damage description',0,1);


insert ignore into cargroups(id,carGroup) values(2,'Economy');
insert ignore into options(id,amount,code,name,price,group_id) 
values(12,1,'T','Rental days',30,2);
insert ignore into options(id,amount,code,name,price,group_id) values(13,1,'GF','Body insurance',14,2);
insert ignore into options(id,amount,code,name,price,group_id) values(14,1,'TG','Tire and glass insurance',14,2);
insert ignore into options(id,amount,code,name,price,group_id) values(15,1,'TI','Third party insurance',4,2);
insert ignore into options(id,amount,code,name,price,group_id) values(16,1,'TP','Theft protection',4,2);
insert ignore into options(id,amount,code,name,price,group_id) values(17,1,'PAP','Personal accident protection',5,2);
insert ignore into options(id,amount,code,name,price,group_id) values(18,1,'IT','Internation travel',16,2);
insert ignore into options(id,amount,code,name,price,group_id) values(19,1,'NV','Navigation',4,2);
insert ignore into options(id,amount,code,name,price,group_id) values(20,1,'PF','Prepaid fuel',1.3,2);
insert ignore into options(id,amount,code,name,price,group_id) values(21,1,'DM','Damage',100,2);
insert ignore into options(id,amount,code,name,price,group_id) values(22,1,'DD','Damage description',0,2);



insert ignore into cargroups(id,carGroup) values(3,'Compact');
insert ignore into options(id,amount,code,name,price,group_id) 
values(23,1,'T','Rental days',40,3);
insert ignore into options(id,amount,code,name,price,group_id) values(24,1,'GF','Body insurance',17,3);
insert ignore into options(id,amount,code,name,price,group_id) values(25,1,'TG','Tire and glass insurance',16,3);
insert ignore into options(id,amount,code,name,price,group_id) values(26,1,'TI','Third party insurance',6,3);
insert ignore into options(id,amount,code,name,price,group_id) values(27,1,'TP','Theft protection',6,3);
insert ignore into options(id,amount,code,name,price,group_id) values(28,1,'PAP','Personal accident protection',5,3);
insert ignore into options(id,amount,code,name,price,group_id) values(29,1,'IT','Internation travel',16,3);
insert ignore into options(id,amount,code,name,price,group_id) values(30,1,'NV','Navigation',4,3);
insert ignore into options(id,amount,code,name,price,group_id) values(31,1,'PF','Prepaid fuel',1.3,3);
insert ignore into options(id,amount,code,name,price,group_id) values(32,1,'DM','Damage',100,3);
insert ignore into options(id,amount,code,name,price,group_id) values(33,1,'DD','Damage description',0,3);


insert ignore into cargroups(id,carGroup) values(4,'Intermediate');
insert ignore into options(id,amount,code,name,price,group_id) 
values(34,1,'T','Rental days',60,4);
insert ignore into options(id,amount,code,name,price,group_id) values(35,1,'GF','Body insurance',20,4);
insert ignore into options(id,amount,code,name,price,group_id) values(36,1,'TG','Tire and glass insurance',16,4);
insert ignore into options(id,amount,code,name,price,group_id) values(37,1,'TI','Third party insurance',8,4);
insert ignore into options(id,amount,code,name,price,group_id) values(38,1,'TP','Theft protection',8,4);
insert ignore into options(id,amount,code,name,price,group_id) values(39,1,'PAP','Personal accident protection',5,4);
insert ignore into options(id,amount,code,name,price,group_id) values(40,1,'IT','Internation travel',16,4);
insert ignore into options(id,amount,code,name,price,group_id) values(41,1,'NV','Navigation',4,4);
insert ignore into options(id,amount,code,name,price,group_id) values(42,1,'PF','Prepaid fuel',1.3,4);
insert ignore into options(id,amount,code,name,price,group_id) values(43,1,'DM','Damage',100,4);
insert ignore into options(id,amount,code,name,price,group_id) values(44,1,'DD','Damage description',0,4);


insert ignore into cargroups(id,carGroup) values(5,'Family');
insert ignore into options(id,amount,code,name,price,group_id) 
values(45,1,'T','Rental days',70,5);
insert ignore into options(id,amount,code,name,price,group_id) values(46,1,'GF','Body insurance',22,5);
insert ignore into options(id,amount,code,name,price,group_id) values(47,1,'TG','Tire and glass insurance',18,5);
insert ignore into options(id,amount,code,name,price,group_id) values(48,1,'TI','Third party insurance',11,5);
insert ignore into options(id,amount,code,name,price,group_id) values(49,1,'TP','Theft protection',10,5);
insert ignore into options(id,amount,code,name,price,group_id) values(50,1,'PAP','Personal accident protection',5,5);
insert ignore into options(id,amount,code,name,price,group_id) values(51,1,'IT','Internation travel',16,5);
insert ignore into options(id,amount,code,name,price,group_id) values(52,1,'NV','Navigation',4,5);
insert ignore into options(id,amount,code,name,price,group_id) values(53,1,'PF','Prepaid fuel',1.3,5);
insert ignore into options(id,amount,code,name,price,group_id) values(54,1,'DM','Damage',100,5);
insert ignore into options(id,amount,code,name,price,group_id) values(55,1,'DD','Damage description',0,5);


insert ignore into cargroups(id,carGroup) values(6,'Premium');
insert ignore into options(id,amount,code,name,price,group_id) 
values(56,1,'T','Rental days',90,6);
insert ignore into options(id,amount,code,name,price,group_id) values(57,1,'GF','Body insurance',26,6);
insert ignore into options(id,amount,code,name,price,group_id) values(58,1,'TG','Tire and glass insurance',22,6);
insert ignore into options(id,amount,code,name,price,group_id) values(59,1,'TI','Third party insurance',14,6);
insert ignore into options(id,amount,code,name,price,group_id) values(60,1,'TP','Theft protection',11,6);
insert ignore into options(id,amount,code,name,price,group_id) values(61,1,'PAP','Personal accident protection',5,6);
insert ignore into options(id,amount,code,name,price,group_id) values(62,1,'IT','Internation travel',16,6);
insert ignore into options(id,amount,code,name,price,group_id) values(63,1,'NV','Navigation',4,6);
insert ignore into options(id,amount,code,name,price,group_id) values(64,1,'PF','Prepaid fuel',1.3,6);
insert ignore into options(id,amount,code,name,price,group_id) values(65,1,'DM','Damage',100,6);
insert ignore into options(id,amount,code,name,price,group_id) values(66,1,'DD','Damage description',0,6);


insert ignore into damagesizes(id,size) values(1,'0-5');
insert ignore into damagesizes(id,size) values(2,'6-10');
insert ignore into damagesizes(id,size) values(3,'10+');

insert ignore into damagetypes(id,type) values(1,'Scratch surface');
insert ignore into damagetypes(id,type) values(2,'Scratch prime coat');
insert ignore into damagetypes(id,type) values(3,'Dent');
insert ignore into damagetypes(id,type) values(4,'Crash');
insert ignore into damagetypes(id,type) values(5,'Missing');

insert ignore into fueltypes(id,type) values(1, 'Petrol');
insert ignore into fueltypes(id,type) values(2, 'Diesel');
insert ignore into fueltypes(id,type) values(3, 'Hybrid');
insert ignore into fueltypes(id,type) values(4, 'Electric');

insert ignore into navigationmodels(id, model) values(1,'Integrated');
insert ignore into navigationmodels(id, model) values(2,'Garmin');
insert ignore into navigationmodels(id, model) values(3,'TomTom');

insert ignore into navigations(id,navigation_model_id) values(1,1);

insert ignore into tirebrands(id,brand) values(1,'Michelin');
insert ignore into tirebrands(id,brand) values(2,'Bridgestone');
insert ignore into tirebrands(id,brand) values(3,'Goodyear');
insert ignore into tirebrands(id,brand) values(4,'Sava');

insert ignore into tiretypes(id,type) values(1,'Winter');
insert ignore into tiretypes(id,type) values(2,'Summer');
insert ignore into tiretypes(id,type) values(3,'All year');

insert ignore into wheeltypes(id,type) values(1,'Steel');
insert ignore into wheeltypes(id,type) values(2,'Alloy');
insert ignore into wheeltypes(id,type) values(3,'Carbon');

insert ignore into car_manufacturers(id,carManufacturer) values(1,'Alfa Romeo');
insert ignore into car_models(id,carModel,manufacturer_id) values(1,'Alfa Romeo Giulietta',1);
insert ignore into car_models(id,carModel,manufacturer_id) values(2,'Alfa Romeo Giulia',1);
insert ignore into car_models(id,carModel,manufacturer_id) values(3,'Alfa Romeo Stelvio',1);

insert ignore into car_manufacturers(id,carManufacturer) values(2,'Audi');
insert ignore into car_models(id,carModel,manufacturer_id) values(4,'Audi A3',2);
insert ignore into car_models(id,carModel,manufacturer_id) values(5,'Audi A4',2);
insert ignore into car_models(id,carModel,manufacturer_id) values(6,'Audi A6',2);
insert ignore into car_models(id,carModel,manufacturer_id) values(7,'Audi Q3',2);
insert ignore into car_models(id,carModel,manufacturer_id) values(8,'Audi Q5',2);
insert ignore into car_models(id,carModel,manufacturer_id) values(9,'Audi Q7',2);

insert ignore into car_manufacturers(id,carManufacturer) values(3,'BMW');
insert ignore into car_models(id,carModel,manufacturer_id) values(10,'1',3);
insert ignore into car_models(id,carModel,manufacturer_id) values(11,'3',3);
insert ignore into car_models(id,carModel,manufacturer_id) values(12,'5',3);
insert ignore into car_models(id,carModel,manufacturer_id) values(13,'X1',3);
insert ignore into car_models(id,carModel,manufacturer_id) values(14,'X3',3);
insert ignore into car_models(id,carModel,manufacturer_id) values(15,'X5',3);

insert ignore into car_manufacturers(id,carManufacturer) values(4,'Chevrolet');
insert ignore into car_models(id,carModel,manufacturer_id) values(16,'Spark',4);
insert ignore into car_models(id,carModel,manufacturer_id) values(17,'Cruze',4);
insert ignore into car_models(id,carModel,manufacturer_id) values(18,'Captiva',4);

insert ignore into car_manufacturers(id,carManufacturer) values(5,'Citroen');
insert ignore into car_models(id,carModel,manufacturer_id) values(19,'C1',5);
insert ignore into car_models(id,carModel,manufacturer_id) values(20,'C3',5);
insert ignore into car_models(id,carModel,manufacturer_id) values(21,'C4',5);
insert ignore into car_models(id,carModel,manufacturer_id) values(22,'C5',5);
insert ignore into car_models(id,carModel,manufacturer_id) values(23,'Jumper',5);

insert ignore into car_manufacturers(id,carManufacturer) values(6,'Dacia');
insert ignore into car_models(id,carModel,manufacturer_id) values(24,'Duster',6);
insert ignore into car_models(id,carModel,manufacturer_id) values(25,'Sandero',6);
insert ignore into car_models(id,carModel,manufacturer_id) values(26,'Logan',6);

insert ignore into car_manufacturers(id,carManufacturer) values(7,'Fiat');
insert ignore into car_models(id,carModel,manufacturer_id) values(27,'500',7);
insert ignore into car_models(id,carModel,manufacturer_id) values(28,'Panda',7);
insert ignore into car_models(id,carModel,manufacturer_id) values(29,'Tipo',7);
insert ignore into car_models(id,carModel,manufacturer_id) values(30,'Doblo',7);

insert ignore into car_manufacturers(id,carManufacturer) values(8,'Ford');
insert ignore into car_models(id,carModel,manufacturer_id) values(30,'Focus',8);
insert ignore into car_models(id,carModel,manufacturer_id) values(31,'Mondeo',8);
insert ignore into car_models(id,carModel,manufacturer_id) values(32,'S-Max',8);
insert ignore into car_models(id,carModel,manufacturer_id) values(33,'Transit',8);

insert ignore into car_manufacturers(id,carManufacturer) values(9,'Honda');
insert ignore into car_models(id,carModel,manufacturer_id) values(34,'Accord',9);
insert ignore into car_models(id,carModel,manufacturer_id) values(35,'Civic',9);

insert ignore into car_manufacturers(id,carManufacturer) values(10,'Hyundai');
insert ignore into car_models(id,carModel,manufacturer_id) values(36,'i20',10);
insert ignore into car_models(id,carModel,manufacturer_id) values(37,'i30',10);

insert ignore into car_manufacturers(id,carManufacturer) values(11,'Kia');
insert ignore into car_models(id,carModel,manufacturer_id) values(38,'Ceed',11);
insert ignore into car_models(id,carModel,manufacturer_id) values(39,'Sorento',11);


insert ignore into car_manufacturers(id,carManufacturer) values(12,'Mazda');
insert ignore into car_models(id,carModel,manufacturer_id) values(38,'2',12);
insert ignore into car_models(id,carModel,manufacturer_id) values(39,'3',12);
insert ignore into car_models(id,carModel,manufacturer_id) values(40,'6',12);

insert ignore into car_manufacturers(id,carManufacturer) values(13,'Mercedes Benz');
insert ignore into car_models(id,carModel,manufacturer_id) values(41,'A-Class',13);
insert ignore into car_models(id,carModel,manufacturer_id) values(42,'B-Class',13);
insert ignore into car_models(id,carModel,manufacturer_id) values(43,'C-Class',13);
insert ignore into car_models(id,carModel,manufacturer_id) values(44,'E-Class',13);
insert ignore into car_models(id,carModel,manufacturer_id) values(45,'V-Class',13);

insert ignore into car_manufacturers(id,carManufacturer) values(14,'Nissan');
insert ignore into car_models(id,carModel,manufacturer_id) values(46,'Juke',14);
insert ignore into car_models(id,carModel,manufacturer_id) values(47,'Qashqai',14);
insert ignore into car_models(id,carModel,manufacturer_id) values(48,'Note',14);

insert ignore into car_manufacturers(id,carManufacturer) values(15,'Opel');
insert ignore into car_models(id,carModel,manufacturer_id) values(49,'Corsa',15);
insert ignore into car_models(id,carModel,manufacturer_id) values(50,'Astra',15);
insert ignore into car_models(id,carModel,manufacturer_id) values(51,'Insignia',15);
insert ignore into car_models(id,carModel,manufacturer_id) values(52,'Vivaro',15);

insert ignore into car_manufacturers(id,carManufacturer) values(16,'Peugeot');
insert ignore into car_models(id,carModel,manufacturer_id) values(53,'207',16);
insert ignore into car_models(id,carModel,manufacturer_id) values(54,'308',16);
insert ignore into car_models(id,carModel,manufacturer_id) values(55,'3008',16);

insert ignore into car_manufacturers(id,carManufacturer) values(17,'Seat');
insert ignore into car_models(id,carModel,manufacturer_id) values(56,'Ibiza',17);
insert ignore into car_models(id,carModel,manufacturer_id) values(57,'Leon',17);
insert ignore into car_models(id,carModel,manufacturer_id) values(58,'Ateca',17);

insert ignore into car_manufacturers(id,carManufacturer) values(18,'Škoda');
insert ignore into car_models(id,carModel,manufacturer_id) values(59,'Fabia',18);
insert ignore into car_models(id,carModel,manufacturer_id) values(60,'Octavia',18);
insert ignore into car_models(id,carModel,manufacturer_id) values(61,'Superb',18);
insert ignore into car_models(id,carModel,manufacturer_id) values(62,'Karoq',18);

insert ignore into car_manufacturers(id,carManufacturer) values(19,'Toyota');
insert ignore into car_models(id,carModel,manufacturer_id) values(63,'Corolla',19);
insert ignore into car_models(id,carModel,manufacturer_id) values(64,'Avensis',19);
insert ignore into car_models(id,carModel,manufacturer_id) values(65,'Yaris',19);

insert ignore into car_manufacturers(id,carManufacturer) values(20,'Volkswagen');
insert ignore into car_models(id,carModel,manufacturer_id) values(66,'Polo',20);
insert ignore into car_models(id,carModel,manufacturer_id) values(67,'Golf',20);
insert ignore into car_models(id,carModel,manufacturer_id) values(68,'Pasat',20);
insert ignore into car_models(id,carModel,manufacturer_id) values(69,'Touran',20);
insert ignore into car_models(id,carModel,manufacturer_id) values(70,'Transporter',20);
insert ignore into car_models(id,carModel,manufacturer_id) values(71,'Crafter',20);

insert ignore into car_manufacturers(id,carManufacturer) values(21,'Volvo');
insert ignore into car_models(id,carModel,manufacturer_id) values(72,'V60',21);
insert ignore into car_models(id,carModel,manufacturer_id) values(73,'XC90',21);

