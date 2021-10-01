-- either do not start with vowels or do not end with vowels
select distinct city from station where city not like '[aeiou]%' or city not like '%[aeiou]';