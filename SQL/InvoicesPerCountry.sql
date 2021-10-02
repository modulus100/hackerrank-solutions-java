select con.country_name, count(inv.id), avg(inv.total_price)  from country con
inner join city ct on ct.country_id = con.id
inner join customer cmer on cmer.city_id = ct.id
inner join invoice inv on inv.customer_id = cmer.id
group by con.country_name
having avg(inv.total_price) > (select avg(inv2.total_price) from invoice inv2);