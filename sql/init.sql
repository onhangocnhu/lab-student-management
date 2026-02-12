CREATE TABLE students (id varchar(255) not null, age integer not null, email varchar(255), name varchar(255), primary key (id));

INSERT INTO students (id, name, email, age) VALUES 
    ('2310001', 'Nguyen Van A', 'vana@example.com', 20),
    ('2310002', 'Tran Thi B', 'thib@example.com', 21),
    ('2310003', 'Le Van C', 'vanc@example.com', 22),
    ('2310004', 'Pham Thi D', 'thid@example.com', 19),
    ('2310005', 'Hoang Van E', 'vane@example.com', 23),
    ('2310006', 'Ngo Thi F', 'thif@example.com', 20),
    ('2310007', 'Vu Van G', 'vang@example.com', 21),
    ('2310008', 'Do Thi H', 'thih@example.com', 22),
    ('2310009', 'Bui Van I', 'vani@example.com', 18),
    ('2310010', 'Dang Thi K', 'thik@example.com', 24),
    ('2310011', 'Trinh Van L', 'vanl@example.com', 20),
    ('2310012', 'Mai Thi M', 'thim@example.com', 21),
    ('2310013', 'Phan Van N', 'vann@example.com', 22),
    ('2310014', 'Cao Thi O', 'thio@example.com', 23)
ON CONFLICT (id) DO NOTHING;
