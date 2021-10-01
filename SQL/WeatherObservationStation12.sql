-- do not start with vowels and do not end with vowels
select distinct city from station where city not like '[aeiou]%' and city not like '%[aeiou]';