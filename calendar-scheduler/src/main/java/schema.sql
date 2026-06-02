CREATE TABLE appointments (
    id SERIAL PRIMARY KEY,
    year_num INT NOT NULL,
    month_num INT NOT NULL,
    day_num INT NOT NULL,
    appointment_text TEXT NOT NULL
);

ALTER TABLE appointments ADD CONSTRAINT unique_date UNIQUE (year_num, month_num, day_num);
