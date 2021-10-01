-- longest and shortest cities

select top 1 city, len(city) citylen from station order by citylen asc, city asc;
select top 1 city, len(city) citylen from station order by citylen desc, city asc;