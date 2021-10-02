-- average population per continent
select con.continent, avg(c.population) from city c
inner join country con on con.code = c.countrycode
group by con.continent;