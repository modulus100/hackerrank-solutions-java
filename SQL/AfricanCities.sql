select c.name from city c
inner join country con on con.code = c.countrycode
where con.continent = 'Africa';