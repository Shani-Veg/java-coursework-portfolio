CREATE TABLE appointments (
    id SERIAL PRIMARY KEY,
    year_num INT NOT NULL,
    month_num INT NOT NULL,
    day_num INT NOT NULL,
    appointment_text TEXT NOT NULL
);
