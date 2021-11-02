-- Var 34
use labor_sql;

-- Q1
SELECT model, ram, screen, price
FROM laptop
WHERE price > 1000
ORDER BY ram, price DESC; 

-- Q2
SELECT *
FROM ships
WHERE RIGHT(class, 1) = 'o' AND RIGHT(class, 2) <> 'go'
-- Alternative version: class LIKE '%o' AND class NOT LIKE '%go'
;

-- Q3
SELECT p.maker, p.`type`, l.speed, l.hd 
FROM laptop l
	INNER JOIN product p ON p.model = l.model 
WHERE l.hd >= 10; 

-- Q4
SELECT distinct maker
FROM product 
WHERE maker <> ALL (SELECT maker FROM product WHERE `type`='Laptop')
	AND `type` = 'PC';

-- Q5
SELECT p.maker 
FROM product p 
	LEFT JOIN pc ON pc.model = p.model AND pc.speed >= 750
	LEFT JOIN laptop l ON l.model = p.model AND l.speed >= 750
GROUP BY p.maker
HAVING COUNT(pc.model) > 0 AND COUNT(l.model) > 0;

-- Q6
SELECT DATE_FORMAT(`date`, '%Y.%m.%d') AS Date_Formatted 
FROM income;

-- Q7
SELECT p.maker 
FROM product p 
	LEFT JOIN pc ON p.model = pc.model 
WHERE p.`type` = 'PC'
GROUP BY p.maker
HAVING COUNT(p.model) = COUNT(pc.model);

-- Q8
SELECT p.maker, AVG(l.screen) Avg_Screen_Size
FROM product p 
	INNER JOIN laptop l ON l.model = p.model 
GROUP BY p.maker;

-- Q9
SELECT i.`point`, i.`date`, i.inc, CASE WHEN o.`out` IS NULL THEN 0 ELSE o.`out` END AS `out` 
FROM income_o i 
	LEFT JOIN outcome_o o ON i.`point` = o.`point` AND i.`date` = o.`date`
UNION ALL 
SELECT o.`point`, o.`date`, 0 AS `inc`, o.`out` 
FROM income_o i 
	RIGHT JOIN outcome_o o ON i.`point` = o.`point` AND i.`date` = o.`date`
WHERE i.`point` IS NULL;

-- Q10
SELECT AVG(price) AS Avg_Price
FROM  (SELECT l.price 
	FROM laptop l INNER JOIN product p ON p.model = l.model AND p.maker = 'A'
	UNION ALL
	SELECT pc.price 
	FROM pc INNER JOIN product p ON p.model = pc.model AND p.maker = 'A') t;
	
-- Alternative Q10
SELECT AVG(CASE WHEN l.model IS NULL THEN pc.price ELSE l.price END) Avg_Price 
FROM product p 
	LEFT JOIN laptop l ON l.model = p.model 
	LEFT JOIN pc ON pc.model = p.model 
WHERE p.maker = 'A' AND (l.model IS NOT NULL OR pc.model IS NOT NULL);