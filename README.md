SELECT * FROM springjpa.product_table;

insert into product_table (price,DESCRIPTION123,name,productType)
values
(1400,"KODAK Company","Kodak DSLR","Electronics");

 => IN :  WE USE IN when we want to give where condition as multiple same-column-values:
 -----------------------------------------------------------------------------------
      SELECT * FROM product_table WHERE DESCRIPTION123 IN ('Samsung Company','Rado Watch for Men','Bobs Furniture');


=> LIKE : In SQL, the LIKE operator is used in a WHERE clause to search for a pattern in a column:
--------------------------------------------------------------------------------------------------
      SELECT * FROM product_table WHERE NAME LIKE '%DSLR';


=> Between :
-------------
          SELECT * FROM springjpa.product_table where price between 300 AND 1000;



=> LESS-THAN, GREATER-THAN :
-----------------------------
           SELECT * FROM springjpa.product_table where price >=500 AND id <=5;



=> ORDER By : It is used for Sorting the Column:
-------------------------------------------------
           SELECT * FROM springjpa.product_table ORDER BY PRICE DESC;



=> Pagination : It means showing data in smaller chunks (pages) instead of all rows at once : USING LIMIT & OFFSET
--------------------------------------------------------------------------------------------------------------------
-- Pagination by using LIMIT and OFFSET :
                select * from product_table LIMIT 3 OFFSET 0;
                select * from product_table LIMIT 3 OFFSET 3;
                select * from product_table LIMIT 3 OFFSET 6;


-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Transactions in SQL:
--------------------------
1)  A **transaction** = group of SQL operations executed together as a single unit.
2) Either **all succeed (COMMIT)** or **all fail (ROLLBACK)** → ensures data consistency.
3) Use when multiple related changes must happen together.

Example: Transfer money
------------------------
START TRANSACTION;

UPDATE accounts SET balance = balance - 100 WHERE id = 1; -- deduct
UPDATE accounts SET balance = balance + 100 WHERE id = 2; -- add

-- If all good:
COMMIT;

-- If error occurs:
ROLLBACK;
```
```

📌 Composite Primary Key:
--------------------------
1)  A **primary key** uniquely identifies a row.
2) Composite primary key** = uses **two or more columns together** as the primary key.
3) Useful when one column alone is not unique.

Example: Student & Course mapping
---------------------------------

```sql ```
CREATE TABLE StudentCourse (
    student_id INT,
    course_id INT,
    grade CHAR(1),
    PRIMARY KEY (student_id, course_id) -- composite key
);

SQL-Interview Qusestions :
-------------------------
-- second highest price in a table
select Max(price) from springjpa.product_table
where
price < (select Max(price) from springjpa.product_table);
               
