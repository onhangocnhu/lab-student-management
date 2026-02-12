# Hệ Thống Quản Lý Sinh Viên - Student Management

## Mục Lục
1. [Danh Sách Nhóm](#danh-sách-nhóm)
2. [URL Công Khai](#url-công-khai)
3. [Cài Đặt Dự Án](#cài-đặt-dự-án)
4. [Bài Tập Lab](#bài-tập-lab)
   - [Lab 1: Khởi Tạo & Kiến Trúc](#lab-1-bài-tập)
   - [Lab 2: Xây Dựng Backend REST API](#lab-2-bài-tập)
   - [Lab 3: Xây Dựng Frontend (SSR)](#lab-3-bài-tập)
   - [Lab 4: Hoàn Thiện Sản Phẩm](#lab-4-bài-tập)
   - [Lab 5: Docker & Triển Khai](#lab-5-bài-tập)

## Danh Sách Nhóm
| MSSV |  Họ và Tên  | Email |
|:-----:|:--------:|:------:|
| 2312538   | **Ôn Hà Ngọc Như** | nhu.onhangoc@hcmut.edu.vn |
| 2310211   |  **Đặng Nguyên Bảo**  |   bao.dangnguyen@hcmut.edu.vn |

## URL Công Khai
- Render Deployment: https://lab-student-management.onrender.com/students
- Neon: https://console.neon.tech/app/projects/polished-meadow-81350192

## Cách chạy dự án
- Clone dự án: `git clone https://github.com/onhangocnhu/lab-student-management.git`
- Yêu cầu: Cài đặt Java Development Kit (JDK) 17+ và Docker, PostgreSQL.
- Chạy lệnh sau để khởi động container:
```bash
docker compose up -d
```

- Truy cập `localhost:8080/students` để thao tác.

## Bài tập Lab
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

## Lab 3: Bài tập
### Chức năng tìm kiếm
![alt text](images/lab3-1.png)

### Hiển thị có điều kiện: Sinh viên có độ tuổi từ 18 trở xuống
![alt text](images/lab3-2.png)

## Lab 4: Bài tập
### Trang danh sách
![alt text](images/lab4-1.1.png)

### Trang chi tiết
![alt text](images/lab4-1.2.1.png)

Khi xóa, sẽ có nút xác nhận
![alt text](images/lab4-1.2.2.png)
 
 ### Chức năng thêm và sửa
 #### Thêm mới
 Trường hợp thêm sinh viên với ID (MSSV) bị trùng
 ![alt text](images/lab4-1.3.1.png)
 
 Sẽ có thông báo lỗi xuất hiện khi ấn lưu
 ![alt text](images/lab4-1.3.2.png)

 Sau khi sửa lỗi trùng ID, thêm thành công sẽ được điều hướng về trang danh sách
 ![alt text](images/lab4-1.3.3.png)
 
 #### Chỉnh sửa
 ![alt text](images/lab4-1.3.4.png)
 
 Sau khi sửa thành công, sẽ điều hướng về trang danh sách
 ![alt text](images/lab4-1.3.5.png)
 
 ### Cấu hình cơ sở dữ liệu
 Khởi tạo postgres bằng 1 docker container
 ![alt text](images/lab4-2.png)
 Lệnh chạy
 ```bash
 docker compose up -d postgres
 ```
 
 chỉnh sửa file application.properties để kết nối đúng database
```
spring.application.name=student-management
spring.datasource.url=${SPRING_DATASOURCE_URL:jdbc:postgresql://localhost:5433/student-management}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME:postgres}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD:password}
spring.jpa.properties.hibernate.dialect=${STRING_JPA_HIBERNATE_DIALECT:org.hibernate.dialect.PostgreSQLDialect}
spring.jpa.hibernate.ddl-auto=${SPRING_JPA_HIBERNATE_DDL_AUTO:update}
spring.jpa.hibernate.format_sql=${STRING_JPA_FORMAT_SQL:true}
spring.jpa.show-sql=${STRING_JPA_SHOW_SQL:true}
```

### Cấu hình file môi trường
![alt text](images/lab4-3.png)

## Lab 5: Bài tập
### Database PostgreSQL
- Vì đã host database lên Neon, nhóm sẽ lấy link kết nối trên trang:
![alt text](images/lab5-0.png)

- Thêm data bằng `SQL Editor`:
![alt text](images/lab5-1.1.png)

- Thay đổi file môi trường `.env`:
![alt text](images/lab5.png)
### Docker
Chạy lệnh
```bash
docker compose up -d
```

Container sẽ gồm 2 image `student-management-postgres` trên Neon và `student-management-api` đã host lên Docker.
![alt text](images/lab5-1.2.png)

### Truy cập web
Truy cập trang: https://lab-student-management.onrender.com/students đã được deploy ở `render.com`

Thao tác các tính năng được trình bày ở Lab 4.
