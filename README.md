## Lab 1: Bài tập
### 1. Dữ liệu lớn: Hãy thử thêm ít nhất 10 sinh viên nữa.
![alt text](images/lab1-1.png)

### 2. Ràng buộc Khóa Chính (Primary Key):
- Câu hỏi: Cố tình Insert một sinh viên có id trùng với một người đã có sẵn. Quan sát thông báo lỗi: `UNIQUE constraint failed.` Tại sao Database lại chặn thao tác này?

- Trả lời:
![alt text](images/lab1-2.png)

Database chặn thao tác này vì `PRIMARY KEY` sẽ tự động ràng buộc mọi giá trị thuộc tính đó là duy nhất (`UNIQUE`).

### 3. Toàn vẹn dữ liệu (Constraints):
- Câu hỏi: Thử Insert một sinh viên nhưng bỏ trống cột name (để NULL).
Database có báo lỗi không? Từ đó suy nghĩ xem sự thiếu chặt chẽ này ảnh
hưởng gì khi code Java đọc dữ liệu lên?

- Trả lời:
![alt text](images/lab1-3.png)

Database không báo lỗi vì thuộc t ính `name` không có ràng buộc `NOT NULL`. Sự thiếu chặt chẽ này sẽ ảnh hưởng khi Java đọc dữ liệu lên vì Khi Java đọc một Student có `name = NULL`, biến name trong object sẽ là `null`. Nếu code không kiểm tra `null`, sẽ gây ra `NullPointerException` khi gọi các phương thức như `student.getName().length()`, `student.getName().toUpperCase()`,...


## Lab 2: Bài tập
### 1. Test Case 1: Lấy danh sách sinh viên
![alt text](images/lab2-1.png)

### 2. Test Case 2: Lấy chi tiết sinh viên
![alt text](images/lab2-2.png)

### 3. Test Case 3: Lấy sinh viên không tồn tại
![alt text](images/lab2-3.png)
