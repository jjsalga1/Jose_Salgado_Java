use sakila;

-- Write a SQL query to find the total rental amount paid for each film.
-- Your query should return the following columns:
-- * film_id
-- * total_amount
select film.film_id, sum(amount) as total_amount from film
join inventory on film.film_id = inventory.film_id
join rental on inventory.inventory_id = rental.inventory_id
join payment on rental.rental_id = payment.rental_id
group by film.film_id;

-- Create a view named total_rental_amount using the query from the previous step.
create view total_rental_amount as
select film.film_id, sum(amount) as total_amount from film
join inventory on film.film_id = inventory.film_id
join rental on inventory.inventory_id = rental.inventory_id
join payment on rental.rental_id = payment.rental_id
group by film.film_id;

-- Write a SQL query to find the total number of copies in inventory for each film.
-- Your query should return the following columns:
-- * film_id
-- * total_copies
select film_id, count(inventory_id) as total_copies from inventory
group by film_id;

-- Create a view named total_film_copies using the query from the previous step.
create view total_film_copies as
select film_id, count(inventory_id) as total_copies from inventory
group by film_id;

-- Write a SQL query that combines data from the film table, the total_rental_amount view,
-- and the total_film_copies view to find all films with a total rental amount greater than 200.00,
-- and display the following columns:
-- * film_id
-- * title
-- * description
-- * rental_duration
-- * rental_rate
-- * replacement_cost
-- * rating
-- * total_copies
-- * total_amount
select film.film_id, film.title, film.description, film.rental_duration, film.rental_rate, film.replacement_cost,
film.rating, total_film_copies.total_copies, total_rental_amount.total_amount from film
join total_rental_amount on film.film_id = total_rental_amount.film_id
join total_film_copies on film.film_id = total_film_copies.film_id
where total_amount > 200;