SELECT city.name 
from city, country 
where city.countrycode = country.code and continent = 'Africa';