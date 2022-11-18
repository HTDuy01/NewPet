-- drop database petstore;
create database PetStore;

USE PetStore;


CREATE TABLE AccountInfo(
	id bigint  NOT NULL primary key auto_increment,
	fullName nvarchar(100) NOT NULL,
	age int NULL,
	username nvarchar(100) NOT NULL,
	password nvarchar(50) NOT NULL,
	address nvarchar(300)  NULL,
	phone nvarchar(100) NULL,
	position nvarchar(300) NOT NULL);



CREATE TABLE Bill(
	id bigint  NOT NULL primary key auto_increment,
	totalPrice float NOT NULL,
	discount int NOT NULL,
	moneyCustomer float NOT NULL,
	moneyReturn float NOT NULL,
	date datetime NOT NULL,
	customer_id bigint NOT NULL,
	account_id bigint NOT NULL
    

);


CREATE TABLE BillInfo(
	id int  NOT NULL primary key auto_increment,
	product_Id bigint NOT NULL,
	quantity int NOT NULL,
	bill_id bigint NOT NULL,
    note nvarchar(1000) null
 );







CREATE TABLE Customer(
	id bigint  NOT NULL primary key auto_increment,
	fullName nvarchar(300) NOT NULL,
	sex nvarchar(50) NULL,
	address nvarchar(300) NULL,
	phone nvarchar(100) NULL
 );


CREATE TABLE Pet(
	id int  NOT NULL primary key auto_increment,
	name nvarchar(100) NULL,
	ownerId bigint NULL,
	serviceID int NULL,
	note nvarchar(100) NULL,
    cage int null);


CREATE TABLE Product(
	id bigint  NOT NULL primary key auto_increment,
	name nvarchar(300) NOT NULL,
	price float NOT NULL,
	descript nvarchar(1111)  DEFAULT (N'...'),
	quantity int NOT NULL,
	supplier_id bigint NOT NULL,
	account_id bigint NOT NULL);


CREATE TABLE Service(
	id int  NOT NULL primary key auto_increment,
	name nvarchar(100) NULL,
	price float NULL,
    descript nvarchar(1000) default (n'....'));


CREATE TABLE Supplier(
	id bigint  NOT NULL primary key auto_increment,
	name nvarchar(300) NOT NULL,
	address nvarchar(300) NOT NULL,
	phone nvarchar(100) NOT NULL,
	email nvarchar(300) NOT NULL);









---------
alter table Pet add constraint FK_Owner_ID foreign key (ownerId)
references Customer (id);

alter table Pet add constraint Fk_service_id foreign key (serviceID)
references Service (id);



alter table Bill add constraint FK_Customer_ID foreign key (customer_id)
references Customer (id);





ALTER TABLE Bill   ADD  CONSTRAINT FK_Bill_Account FOREIGN KEY(account_id)
REFERENCES AccountInfo (id);

ALTER TABLE BillInfo   ADD  CONSTRAINT FK_BillInfo_Bill FOREIGN KEY(bill_id)
REFERENCES Bill (id);

ALTER TABLE Product   ADD  CONSTRAINT FK_Product_Account1 FOREIGN KEY(account_id)
REFERENCES AccountInfo (id);



ALTER TABLE Product   ADD  CONSTRAINT FK_Product_Supplier1 FOREIGN KEY(supplier_id)
REFERENCES Supplier (id);

----------------
INSERT into AccountInfo (id, fullName, age, username, password,  address, phone ,position) VALUES (1, N'Admin', 12, N'admin', N'123456', N'....', N'0987463563', N'Quản Lý');

INSERT Customer (id, fullName, sex, address, phone) VALUES (1, N'Võ Thị Thanh Thảo', N'Nữ', N'Số 16C Tôn Đức Thắng, phường Mỹ Bình, TP. Long Xuyên, tỉnh An Giang', N'0988061983');
INSERT Customer (id, fullName, sex, address, phone) VALUES (2, N'Lê Thị Mai', N'Nữ', N'Số 1 Phạm Văn Đồng, phường Phước Trung, TP. Bà Rịa, tỉnh Bà Rịa – Vũng Tàu', N'0979093839');
INSERT Customer (id, fullName, sex, address, phone) VALUES (4, N'Cao Ngọc Phương Trinh', N'Nữ', N'Số 04 đường Phan Đình Phùng, phường 3, TP.Bạc Liêu, tỉnh Bạc Liêu', N'0988061983');
INSERT Customer (id, fullName, sex, address, phone) VALUES (5, N'Đỗ Thị Thùy Dương', N'Nam', N'Tổ 1A, phường Phùng Chí Kiên, TX.Bắc Kạn, tỉnh Bắc Kạn', N'0972872418');
INSERT Customer (id, fullName, sex, address, phone) VALUES (6, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (7, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (8, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (9, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (10, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (11, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (12, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (13, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (14, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (15, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (16, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (17, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (18, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (19, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (20, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (21, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (22, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (23, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (24, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (25, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (26, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (27, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (28, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (29, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (30, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (31, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (32, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (33, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (34, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (35, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (36, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (37, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (38, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (39, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (40, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (41, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (42, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (43, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (44, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (45, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (46, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (47, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (48, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (49, N'Khách vãng lai', N'Nam', NULL, NULL);
INSERT Customer (id, fullName, sex, address, phone) VALUES (50, N'Khách vãng lai', N'Nam', NULL, NULL);

INSERT Bill (id, totalPrice, discount, moneyCustomer, moneyReturn, date, customer_id, account_id) VALUES (38, 10173000, 5, 10173000, 508650, CAST(N'2020-01-04 13:46:37.300' AS DateTime), 4, 1);
INSERT Bill (id, totalPrice, discount, moneyCustomer, moneyReturn, date, customer_id, account_id) VALUES (39, 10160000, 2, 10160000, 203200, CAST(N'2020-01-04 13:48:06.840' AS DateTime), 46, 1);
INSERT Bill (id, totalPrice, discount, moneyCustomer, moneyReturn, date, customer_id, account_id) VALUES (40, 550000, 2, 650000, 111000, CAST(N'2020-01-04 13:48:27.650' AS DateTime), 47, 1);
INSERT Bill (id, totalPrice, discount, moneyCustomer, moneyReturn, date, customer_id, account_id) VALUES (41, 1634000, 1, 1634000, 16340, CAST(N'2020-01-04 13:48:51.687' AS DateTime), 48, 1);
INSERT Bill (id, totalPrice, discount, moneyCustomer, moneyReturn, date, customer_id, account_id) VALUES (42, 2480000, 15, 2600000, 492000, CAST(N'2020-01-04 13:49:11.100' AS DateTime), 49, 1);
INSERT Bill (id, totalPrice, discount, moneyCustomer, moneyReturn, date, customer_id, account_id) VALUES (43, 1512000, 0, 1512000, 0, CAST(N'2020-01-04 13:49:32.857' AS DateTime), 50, 1);


INSERT BillInfo (id, product_Id, quantity, bill_id) VALUES (30, 18, 10, 38);
INSERT BillInfo (id, product_Id, quantity, bill_id) VALUES (31, 15, 4, 38);
INSERT BillInfo (id, product_Id, quantity, bill_id) VALUES (32, 16, 2, 38);
INSERT BillInfo (id, product_Id, quantity, bill_id) VALUES (33, 19, 6, 38);
INSERT BillInfo (id, product_Id, quantity, bill_id) VALUES (34, 12, 1, 38);
INSERT BillInfo (id, product_Id, quantity, bill_id) VALUES (35, 18, 7, 39);
INSERT BillInfo (id, product_Id, quantity, bill_id) VALUES (36, 11, 2, 39);
INSERT BillInfo (id, product_Id, quantity, bill_id) VALUES (37, 13, 2, 39);
INSERT BillInfo (id, product_Id, quantity, bill_id) VALUES (38, 19, 2, 39);
INSERT BillInfo (id, product_Id, quantity, bill_id) VALUES (39, 14, 2, 40);
INSERT BillInfo (id, product_Id, quantity, bill_id) VALUES (40, 12, 2, 41);
INSERT BillInfo (id, product_Id, quantity, bill_id) VALUES (41, 19, 1, 41);
INSERT BillInfo (id, product_Id, quantity, bill_id) VALUES (42, 16, 2, 41);
INSERT BillInfo (id, product_Id, quantity, bill_id) VALUES (43, 13, 2, 42);
INSERT BillInfo (id, product_Id, quantity, bill_id) VALUES (44, 16, 2, 43);
INSERT BillInfo (id, product_Id, quantity, bill_id) VALUES (45, 19, 2, 43);






INSERT Supplier (id, name, address, phone, email) VALUES (2, N'Cún Yêu shop', N'06 Phạm Văn Nghị, Thanh Khê, Đà Nẵng', N'0935630219', N'handhand@gmail.com');
INSERT Supplier (id, name, address, phone, email) VALUES (3, N'Cửa hàng thú cưng Nobipet', N'423/29 Trưng Nữ Vương, Hải Châu, Đà Nẵng', N'0973405754', N'nobipet@gmail.com');
INSERT Supplier (id, name, address, phone, email) VALUES (4, N'KPETMART - siêu thị thú cưng', N'19 Nguyễn Phước Thái, Thanh Khê, Đà Nẵng', N'0989288470', N'cuahangthucungdanang@gmail.com');
INSERT Supplier (id, name, address, phone, email) VALUES (5, N'Petcity – siêu thị đồ cho chó mèo và thú cưng', N'255 Trưng Nữ Vương, Hải Châu, Đà Nẵng', N'0565478159', N'petcity.danang@gmail.com');
INSERT Supplier (id, name, address, phone, email) VALUES (6, N'TILU PET', N'97 Trần Hưng Đạo, Sơn Trà, Đà Nẵng', N'0949486326', N'lyphuongls@gmail.com');
INSERT Supplier (id, name, address, phone, email) VALUES (7, N'XU BÔNG Pet Shop Đà Nẵng', N'271 Hoài Thanh, Ngũ Hành Sơn, Đà Nẵng', N'0905497001', N'petshopdanang99@gmail.com');
INSERT Supplier (id, name, address, phone, email) VALUES (8, N'Happy PetShop', N'11 Trần Kế Xương, Hải Châu, Đà Nẵng', N'0935 141 414', N'nobipet@gmail.com');
INSERT Supplier (id, name, address, phone, email) VALUES (9, N'Công Ty TNHH Sản Xuất Và Xuất Nhập Khẩu Sgreen', N'Tầng 7, 60 Nguyễn Văn Thủ, P. Đa Kao, Q. 1, Tp. Hồ Chí Minh (TPHCM)', N'0934979887', N'sgreen.saigon@gmail.com');
INSERT Supplier (id, name, address, phone, email) VALUES (10, N'Pet Stock - Cửa Hàng Thức Ăn Và Phụ Kiện Thú Cưng', N'179 DT848 ấp An Thuận, X. Mỹ An Hưng B, H. Lấp Vò, Đồng Tháp', N'0939707205', N'nhsang.dt@gmail.com');
INSERT Supplier (id, name, address, phone, email) VALUES (11, N'Siêu Thị Chó Mèo Sunpet', N'235 Giải Phóng, P. Phương Liệt, Q. Thanh Xuân, Hà Nội', N'0971512513', N'sunset.jsc@gmail.com');

INSERT Product (id, name, price, descript, quantity, supplier_id, account_id) VALUES (11, N'Royal canin Medium Puppy', 1240000, N'Bột mì, lúa mạch, bột gluten bắp, chất béo gà, ngô, gluten lúa mì, bột củ cải đường khô, lúa mì, hương vị tự nhiên, bột mì gạo, dầu cá, canxi cacbonat, men distillers khô men, natri silic aluminat, Dầu thực vật, kali phốt phát, muối, fructooligosaccharides, L-lysine, men thủy phân, clorua choline, taurine, DL-methionine, vitamin DL-alpha tocopherol acetate (nguồn vitamin E), L-ascorbyl-2-polyphosphate Vitamin B6, vitamin B6, vitamin B6, vitamin B2, vitamin B2, vitamin B2, vitamin C, vitamin C, vitamin C, Kẽm proteinate, oxit kẽm, sắt sulfate, protein mangan, oxit mangan, đồng sulfat, canxi iodat, proteinate đồng, selenit natri), chiết xuất thảo mộc, bảo quản với tocopherols hỗn hợp và axit xitric.', 43, 4, 1);
INSERT Product (id, name, price, descript, quantity, supplier_id, account_id) VALUES (12, N'Thức ăn cho chó Poodle', 381000, N'Sản phẩm chức năng có chứa dưỡng chất giúp duy trì sự phát triển của bộ lông chó Poodle. Giauf Omega 3 và các axit béo (EPA & DHA) và dầu lưu ly. Có chứa protein giúp bộ lông phát triển mềm mượt.', 42, 8, 1);
INSERT Product (id, name, price, descript, quantity, supplier_id, account_id) VALUES (13, N'Royal canin - Medium Puppy 10kg', 1240000, N'Bột mì, lúa mạch, bột gluten bắp, chất béo gà, ngô, gluten lúa mì, bột củ cải đường khô, lúa mì, hương vị tự nhiên, bột mì gạo, dầu cá, canxi cacbonat, men distillers khô men, natri silic aluminat, Dầu thực vật, kali phốt phát, muối, fructooligosaccharides, L-lysine, men thủy phân, clorua choline, taurine, DL-methionine, vitamin DL-alpha tocopherol acetate (nguồn vitamin E), L-ascorbyl-2-polyphosphate Vitamin B6, vitamin B6, vitamin B6, vitamin B2, vitamin B2, vitamin B2, vitamin C, vitamin C, vitamin C, Kẽm proteinate, oxit kẽm, sắt sulfate, protein mangan, oxit mangan, đồng sulfat, canxi iodat, proteinate đồng, selenit natri), chiết xuất thảo mộc, bảo quản với tocopherols hỗn hợp và axit xitric.', 52, 6, 1);
INSERT Product (id, name, price, descript, quantity, supplier_id, account_id) VALUES (14, N'Natural core - Thức ăn hữu cơ giàu đạm cho mèo', 275000, N'Thức ăn hữu cơ cho mèo Natural Core được chế biến từ thịt gà, thịt cá hồi, thịt vịt rút xương, hồng sâm… với 95% thành phần hữu cơ và 5% khoáng chất vô cơ tốt cho sức khỏe mèo, phù hợp với mọi lứa tuổi, mọi giống mèo. Được chứng nhận hữu cơ ECOCERT, sản phẩm có tác dụng làm đẹp da, đẹp lông, tối đa hóa khả năng hấp thụ, giảm thiểu mùi phân, trị búi lông.', 33, 3, 1);
INSERT Product (id, name, price, descript, quantity, supplier_id, account_id) VALUES (15, N'Thức ăn cho mèo Me-o 350g', 30000, N'- Protein từ Sữa và Cá Biển giúp phát triển cơ thể và cơ bắp khỏe mạnh
- Acid Amino cần thiết cho chức năng của mắt và cải thiện thị giác của mèo
- Tăng cường hệ thống miễn dịch và giúp giảm tác động của stress lên sức khỏe của mèo
- Canxi, Photpho và Vitamin D giúp làm chắc răng và xương
- Flutd giúp ngăn ngừa bệnh đường tiết niệu trên mèo và sỏi bàng quang
- Omega 3&6 và Kẽm từ dầu chất lượng cao trong hợp chất với kẽm giúp nuôi dưỡng tóc và da mèo
- Công thức Natri thấp giúp giảm nguy cơ cao huyết áp, bệnh thận và tim ở Mèo', 30, 7, 1);
INSERT Product (id, name, price, descript, quantity, supplier_id, account_id) VALUES (16, N'Thức ăn cho mèo Whiskas Ocean Fish 1,2kg', 116000, N'Thức ăn cho mèo lớn Whiskas vị cá ngừ 1,2kg được lựa chọn từ những thành phần thịt, cá tươi ngon nhất trong chế biến, giàu protein, các vitamin và khoáng chất thiết yếu và không có chất bảo quản, mang đến tác dụng cân bằng dinh dưỡng hàng ngày cho thú cưng của bạn.
Thức ăn cho mèo Whiskas được phát triển bởi các chất dinh dưỡng tối ưu và được các chuyên gia vật nuôi trên khắp thế giới công nhận là sản phẩm dinh dưỡng tốt nhất và khuyên dùng.', 339, 4, 1);
INSERT Product (id, name, price, descript, quantity, supplier_id, account_id) VALUES (17, N'Ferplast Atlas Deluxe Open - Lồng vận chuyển size S', 1190000, N'Sản phẩm được sản xuất từ loại nhựa cứng rất an toàn khi vận chuyển chó mèo. Cùng với thiết kê cửa sổ thoáng khí thông minh tạo sự thoải mái khi chó mèo ở bên trong.', 346, 7, 1);
INSERT Product (id, name, price, descript, quantity, supplier_id, account_id) VALUES (18, N'Balo vận chuyển chó mèo Phi hành gia (da)', 560000, N'- Thiết kế phi hành gia độc đáo, dễ thương
- Chất liệu da mềm mại, thoáng khí.
- 2 cửa tích hợp (cầu tròn, lưới phẳng) dễ dàng thay đổi. 
- Màu sắc nổi bật, bắt mắt', 309, 6, 1);
INSERT Product (id, name, price, descript, quantity, supplier_id, account_id) VALUES (19, N'Nón bảo hiểm thỏ Cony, vịt Missha cho chó mèo size nhỏ', 640000, N'Size nhỏ: 10 cm đường kính
Màu sắc: Xanh, cam, trắng', 19, 6, 1);



