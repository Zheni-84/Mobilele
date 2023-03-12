INSERT INTO users (email, first_name, last_name, image_url, is_active, password)
VALUES ('zheni@abv.bg', 'Zheni', 'Avramova', null, 1, '9bae1fb7924d3f4a48e73ef4625f45b877ba8bf5dabde458146f3f4f1b72f34deedd2af36f74cbde');

insert into brands (id, name)
values (1, 'Ford'),
       (2, 'Toyota');

insert into models (id, name, category, start_year, end_year, brand_id, image_url)
values (1, 'Fiesta', 'CAR', 1976, null, 1, 'https://thumbs.dreamstime.com/b/ford-fiesta-new-isolated-white-62409339.jpg'),
       (2, 'Escort', 'CAR', 1968, 2000, 1, 'https://www.autopista.es/uploads/s1/92/11/42/9/ford-escort-reestilizado-china-5.jpeg'),
       (3, 'Yaris', 'CAR', 1999, null, 2,
        'https://kong-proxy-aws.toyota-europe.com/c1-images/resize/ccis/680x680/zip/bg/product-token/58687c2c-18f4-467a-ae3d-bb8adfcdf63a/vehicle/beab91be-94dd-473f-bfe7-b8710149a8c5/padding/50,50,50,50/image-quality/70/day-exterior-4_040.png');