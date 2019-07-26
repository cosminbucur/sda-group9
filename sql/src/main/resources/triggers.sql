# trigger
DELIMITER $$
CREATE TRIGGER store_history BEFORE UPDATE ON employees
FOR EACH ROW
    BEGIN
        INSERT INTO employees_history
        VALUES (new.id_employees , NOW(),
        old.first_name , old.last_name,
        new.first_name , new.last_name);
    END$$

# use trigger
UPDATE employees SET first_name ='Lucy' WHERE first_name='Kate';