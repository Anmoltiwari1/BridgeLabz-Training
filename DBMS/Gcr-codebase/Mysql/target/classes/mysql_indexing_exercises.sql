

-- Exercise 1: Identify Missing Indexes

SELECT c.first_name, c.last_name, o.order_date, o.total_amount
FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
WHERE c.country = 'USA'
AND o.status = 'completed'
AND o.order_date BETWEEN '2024-01-01' AND '2024-12-31'
ORDER BY o.order_date DESC;



-- Exercise 2: Optimize Composite Index

SELECT * FROM orders
WHERE customer_id = 100 AND status = 'completed';

