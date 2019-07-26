# DML (data manipulation language)

# insert
insert into
employees
(first_name , last_name , id_departments)
select
	CONCAT first_name ,' - duplicate',
	CONCAT last_name , ' - duplicate'
	id_departments
from
employees;

# update
update employees
set
    first_name = 'Johnny'
where
    id_employees = 3;
    
# update (multiple tables)
update employees
        INNER JOIN
    departments ON employees.id_employees = departments.id_departments 
SET 
    employees.first_name = CONCAT(employees.first_name,
            ' from the HR dept')
WHERE
    departments.name = 'HR';
    
# delete (multiple tables)
delete employees FROM employees
        INNER JOIN
    departments USING (id_departments) 
WHERE
    id_departments = 2;