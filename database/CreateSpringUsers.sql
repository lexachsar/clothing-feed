CREATE USER 'SpringWebApp'@'localhost' identified by 'SpringWebApp';

GRANT ALL ON MarketPlaceDB.* TO 'SpringWebApp'@'localhost';

CREATE USER 'SpringParsers'@'localhost' identified by 'SpringParsers';

GRANT ALL ON MarketPlaceDB.* TO 'SpringParsers'@'localhost';