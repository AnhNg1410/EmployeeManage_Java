# EmployeeManagement_Java

" A simple desktop computer application project for employee management using the Java language and Java Swing GUI. "
" Dự án phần mềm máy tính đơn giản để quản lí nhân viên sử dụng ngôn ngữ lập trình Java và giao diện Java Swing. " 

### 1. Đây là gì ?

- Đây là dự án cá nhân đơn giản, sử dụng ngôn ngữ Java và giao diện Java Swing.
- Phần mềm quản lí nhân sự ( Employee Management ) là phần mềm sử dụng để quản lí nhân viên.

### 2. Thông tin về sản phẩm .

- Nền tảng của sản phẩm là phần mềm dành cho máy tính, được xây dựng dựa trên ngôn ngữ lập trình JAVA và giao diện người dùng JAVA Swing.
    - Sử dụng mô hình Lập trình hướng đối tượng ( OOP ) để xây dựng các lớp Nhân viên và triển khai các đối tượng nhân viên.
    - Thông tin về các đối tượng được nhập và xử lí trên phần mềm thông qua giao diện của JAVA Swing.
    - Thông tin về các đối tượng được lưu xuống các file riêng thông qua thư viện đọc - ghi File của Java.

### 3. Các chức năng có trong sản phẩm .

##### 3.1. Thêm nhân viên.

<img src="https://imgur.com/utpLcr0">
- Nhận nút "Add", sau đó điền các thông tin của nhân viên được thêm vào.
- Thông tin về các nhân viên được thêm sẽ chỉ được hiển thị trên bảng để xử lí và chỉ được lưu vào file khi người dùng "Save file".

##### 3.2. Xoá nhân viên.

<img src="https://imgur.com/RnMUHk8">
- Chọn nhân viên muốn xoá, sau đó nhấn nút "Delete".
- Thông tin về các nhân viên bị xoá sẽ chỉ được xoá trên bảng để xử lí và chỉ bị xoá khỏi file khi người dùng "Save file".

##### 3.3. Chỉnh sửa thông tin hiện có

<img src="https://imgur.com/FUfhWF7">
- Chọn nhân viên muốn sửa, sau đó nhấn nút "Update".
- Thông tin về các nhân viên sau khi sửa sẽ chỉ được thay đổi trên bảng để xử lí và chỉ thay đổi trong file khi người dùng "Save file".

##### 3.4. Tìm kiếm nhân viên.

<img src="https://imgur.com/61kHEqf">
- Lựa chọn các tuỳ chọn để thực hiện tìm kiếm sau đó nhấn "Find" để tìm kiếm hoặc nhấn "Cancel" để huỷ trạng thái tìm kiếm.
  - Nhập thông tin vào trường nhập thông tin
    - Tích ô "ID" nếu muốn tìm theo ID của nhân viên.
    - Tích ô "Name" nêu muốn tìm theo tên của nhân viên.
    - Tích ô "Positon" nếu muốn tìm theo chức vụ của nhân viên.
  - Chọn ô "Address" để thêm tuỳ chọn tìm theo địa chỉ của nhân viên.
  - Chọn ô "Department" để thêm tuỳ chọn tìm theo phòng ban của nhân viên.
  
##### 3.5. Các chức năng với File.

<img src="https://imgur.com/eMYB1Ge">
- Rê chuột đến menu file để mở thêm các tuỳ chọn với File.
  - "New" để tạo một trình xử lí mới.
  - "Open File" để mở file đã có sẵn.
  - "Save File" để lưu trình xử lí hiện tại xuống file.
- Lưu ý, chỉ có "Open File" với những file bạn có thẩm quyền.
- Có thể "Save File" chồng vào file dữ liệu cũ hoặc tạo thành một file mới.

##### 3.6. Đăng nhập với tài khoản ( người dùng ) có sẵn.

<img src="https://imgur.com/aEm6OzC">
- Sử dụng "Username" và "Password" có sẵn trong file dữ liệu để đăng nhập và có quyền truy cập vào file.
- Mỗi file sẽ cần một lần đăng nhập riêng biệt.

##### 3.7. Đăng kí tài khoản.

<img src="https://imgur.com/CnTtMn2">
- Đăng kí các thông tin cơ bản để tạo tài khoản và có quyền truy cập vào file dữ liệu.
- Thông tin đăng kí sẽ được lưu vào file dữ liệu.

### 4. Sử dụng

- Để sử dụng, tải file nén phần mềm, giải nén và sử dụng như ứng dụng thông thường.
- Đảm bảo máy bạn đã có JVM để thực thi phần mềm JAVA.
- Sản phẩm là dự án cá nhân cơ bản đầu tay nên có nhiều sai sót và còn sơ sài, mong bạn góp ý.
