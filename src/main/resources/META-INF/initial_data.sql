insert into tab_insurance_car (id ,details, start_date,end_date) values (2 ,"Car security for one month.", current_date(), '2021-07-30');
insert into tab_insurance_car (id ,details, start_date,end_date) values (1 ,"Car security for two months.", current_date(), '2021-08-20');
insert into tab_insurance_car (id ,details, start_date,end_date) values (3 ,"Car security for one year.", current_date(), '2022-06-30');

insert into tab_car (provincia, matricula, manufacturer, model, year_manufactured, year_model, price, owner_name, insurance_car_id) values ('Gaza', "750-01", 'Fiat', 'Toro', 2020, 2020, 107000, "Owner Bigif", 1);
insert into tab_car (provincia, matricula, manufacturer, model, year_manufactured, year_model, price, data_cadastro, insurance_car_id) values ('Maputo', "210-02", 'Ford', 'Fiesta', 2019, 2019, 42000, current_date(), 3);
insert into tab_car (provincia, matricula, manufacturer, model, year_manufactured, year_model, price, insurance_car_id) values ('Niassa', "270-03", 'VW', 'Gol', 2019, 2020, 35000, 2);
insert into tab_car (provincia, matricula, manufacturer, model, year_manufactured, year_model, price, owner_name) values ('Zambeza', "250-04", 'BMW', 'X4', 2014, 2015, 59000, "Luis Kambula");
insert into tab_car (provincia, matricula, manufacturer, model, year_manufactured, year_model, price) values ('Baira', "650-05", 'Toyota', 'Racts', 2017, 2018, 10000);
insert into tab_car (provincia, matricula, manufacturer, model, year_manufactured, year_model, price) values ('Manica', "240-06", 'Ford', 'Ranger', 2010, 2010, 60000);
insert into tab_car (provincia, matricula, manufacturer, model, year_manufactured, year_model, price, data_cadastro, owner_name) values ('Sofala', "350-07", 'Mazda', 'BT50', 2021, 2021, 100000, current_date(), "Edilson Alexandre Cuamba");

insert into tab_wheels(manufacturer, size, quantity) values ('BBSV#', 17, 4);
insert into tab_wheels(manufacturer, size, quantity, car_provincia_id, car_matricula_id) values ('Alutec', 17, 4, 'Manica', "240-06");
insert into tab_wheels(manufacturer, size, quantity, car_provincia_id, car_matricula_id) values ('BBS', 17, 4, 'Sofala', "350-07");
insert into tab_wheels(manufacturer, size, quantity, car_provincia_id, car_matricula_id) values ('Borbet', 17, 6, 'Niassa', "270-03");
insert into tab_wheels(manufacturer, size, quantity, car_provincia_id, car_matricula_id) values ('MAK', 17, 8, 'Baira', "650-065");