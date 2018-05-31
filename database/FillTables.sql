USE MarketPlaceDB;

INSERT Gender(id, name) VALUES 
(1, 'Men'),
(2, 'Women'),
(3, 'Children');

INSERT Retailer(id, name, rootUrl, parserClassName) VALUES
('1', 'Wildberries', 'https://www.wildberries.ru', 'com.lexach.ClothingFeedParsers.parsers.WildberriesParser');
