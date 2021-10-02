-- city population sum
select SUM(c.population) from city c
inner join country con on con.code = c.countrycode
and con.continent = 'Asia';

-- subquery method
SELECT SUM(CITY.POPULATION)
FROM CITY, COUNTRY
WHERE CITY.COUNTRYCODE = COUNTRY.CODE AND COUNTRY.CONTINENT = 'Asia';