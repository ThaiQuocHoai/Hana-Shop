create database Assignment1_ThaiQuocHoai
go
use Assignment1_ThaiQuocHoai
go

go
create table tblUser
(
	userID varchar(20) primary key,
	password varchar(30) ,
	fullname nvarchar(50) ,
	phoneNumber varchar(11) ,
	Address nvarchar(200) ,
	dob date ,
	isadmin bit
)
go

go
create table tblCategory
(
	CategoryID int primary key ,
	CategoryName varchar(100)
)
go


create table tblFood
(
	foodID int identity(1,1) primary key,
	foodName varchar(100) ,
	image varchar(200) ,
	decription varchar(1000) ,
	price float ,
	quantity int ,
	categoryID int foreign key (CategoryID) references tblCategory(CategoryID),
	createdate date,
	invalidate date,
	isDelete bit
)

create table tblOrder(
	orderID int identity(1,1) primary key,
	nameCus nvarchar(50),
	phoneNum int,
	address nvarchar(200),
	total float,
	date date
)

create table tblOrder_detail(
	orderID int foreign key (orderID) references tblOrder(orderID),
	foodID int foreign key (foodID) references tblFood(foodID),
	foodName nvarchar(100),
	quantity int

)

create table tblAction(
	actionID int primary key,
	actionName varchar(10)
)

create table tblManager(
	id int identity(1,1) primary key,
	userID varchar(20) foreign key (userID) references tblUser(userID),
	foodID int foreign key (foodID) references tblFood(foodID),
	date date,
	actionID int foreign key (actionID) references tblAction(actionID)

)



go
-- insert into tblUser
insert into tblUser(userID, password, fullname,phoneNumber, Address, dob, isadmin)
values('hoaitq', '123456789', 'Thai Quoc Hoai','1234567891','Rach Gia city','12/29/2000', 1)

insert into tblUser(userID, password, fullname,phoneNumber, Address, dob, isadmin)
values('phatvh', '123456789', 'Vu Hoang Phat','1234567891','4 District - Ho Chi Minh city','20001012', 1)

insert into tblUser(userID, password, fullname,phoneNumber, Address, dob, isadmin)
values('hungnp', '123456789', 'Nguyen Phi Hung','1234567891','Binh Duong province','01/01/1998', 0)

insert into tblUser(userID, password, fullname,phoneNumber, Address, dob, isadmin)
values('baohc', '123456789', 'Huynh Chau Bao','1234567891','Dak Lak','02/02/1983', 0)

insert into tblUser(userID, password, fullname,phoneNumber, Address, dob, isadmin)
values('annv', '123456789', 'Nguyen Van An','1234567891', '9 District - Ho Chi Minh city','03/04/1999', 0)

insert into tblUser(userID, password, fullname,phoneNumber, Address, dob, isadmin)
values('test', '123456', 'Test','1234567891', '9 District - Ho Chi Minh city','03/04/1999', 0)

insert into tblUser(userID, password, fullname,phoneNumber, Address, dob, isadmin)
values('admin', '123456', 'Admin','1234567891', '9 District - Ho Chi Minh city','03/04/1999', 1)
-- end of insert to tblUser

--insert into tblAction
insert into tblAction(actionID, actionName)
values(1,'Delete')

insert into tblAction(actionID, actionName)
values(2,'Update')

--insert into tblCategory
insert into tblCategory(CategoryID, CategoryName)
values(1, 'Food')

insert into tblCategory(CategoryID, CategoryName)
values(2, 'Drink')
--end of insert to tblCategory

--insert into tblFood

	--insert Food
insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Pork Burger','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3ZWAtC_lR184qtPJvC5Pm9OiR4HUuk8eaJg&usqp=CAU','Combine the ground pork, 1 teaspoon salt, 1/4 teaspoon pepper and the sage in a large bowl. Add the bacon mixture and gently mix with your hands. Gently form the meat into 4 balls, then lightly press into 4-inch-wide, 1-inch-thick patties. Make a 2-inch-wide indentation in the center of each with your thumb to prevent the burgers from bulging when grilled.',29000,100,1,'01/01/2021','01/01/2022',0)


insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Beef Burger','https://estonianworld.com/wp-content/uploads/2019/09/burger-king-I-1024x576.jpg','Place the beef mince, breadcrumbs, egg, parsley, onion, garlic, Worcestershire sauce and Tabasco sauce in large bowl. Season with salt and pepper. Mix with your hands until evenly combined.',59000,100,1,'01/09/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Cheese pizza','https://daylambanh.edu.vn/wp-content/uploads/2017/07/cach-lam-banh-pizza-pho-mai.jpg','The main of this pizza is cheese',119000,200,1,'01/10/2021','01/11/2021',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Hot dot','https://www.simplyrecipes.com/wp-content/uploads/2010/05/chili-dog-horiz-a-1600.jpg','Hot dog means a whole, cured, cooked sausage that is skinless or stuffed in a casing',19000,50,1,'01/10/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Snack bap','https://toplist.vn/images/800px/snack-oishi-533581.jpg','This is one type of snack',5000,500,1,'01/10/2020','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Poca','https://csfood.vn/wp-content/uploads/2017/03/B%C3%A1nh-Snack-Partyz-V%E1%BB%8B-B%C3%B2-L%C3%BAc-L%E1%BA%AFc-Texas-G%C3%B3i-40g.jpg','This is one type of snack',10000,100,1,'01/10/2020','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Nabati','https://cdn.tgdd.vn/Products/Images/3360/79852/bhx/banh-xop-nhan-pho-mai-nabati-goi-52g-201911251536557449.jpg','This is the snack which like a cake with a cheese',8000,100,1,'01/10/2020','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Potato chip','https://nghebep.com/wp-content/uploads/2018/10/khoai-tay-chien-bo.jpg','The potato fried',22000,100,1,'02/10/2020','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Onigiri','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTs-ttFE_2FUMJwwo0WW4jqNrgKCf8TKpycwA&usqp=CAU','This like a shushi in Japan',12000,100,1,'01/10/2020','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Ramen','https://image.thanhnien.vn/800/uploaded/ngocthanh/2019_06_28/mi2_zsft.jpg','This is a one type of noodle in Japan',25000,100,1,'01/7/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Taco','https://www.thewholesomedish.com/wp-content/uploads/2019/06/The-Best-Classic-Tacos-550.jpg','This is a one type of bread in American',35000,30,1,'01/01/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Snack cua','https://cf.shopee.vn/file/8a9e1bb888634d726893ea56215f5e94','This is one type of snack',5000,400,1,'01/10/2020','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Snack hanh','https://cdn.tgdd.vn/Products/Images/3364/79730/bhx/snack-hanh-oishi-orion-rings-goi-42g-201912042353285308.jpg','This is one type of snack',5000,100,1,'01/10/2020','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Ostar','https://product.hstatic.net/1000323874/product/4555-01_1b7d25e2d1654c45a4c3554a9f2a8474.png','This is one type of snack',5000,100,1,'01/10/2020','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Snack bi do','https://cdn.tgdd.vn/Products/Images/3364/79708/bhx/snack-bi-do-vi-bo-nuong-oishi-goi-42g-201912050009414776.jpg','This is one type of snack',5000,100,1,'01/10/2020','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Dorites','https://salt.tikicdn.com/cache/280x280/ts/product/81/9f/52/55c53a9fca0c5828c35703d8812e8823.jpg','This is one type of snack',10000,100,1,'01/10/2020','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Stax','https://bizweb.dktcdn.net/100/255/723/products/88507188045731542449819.jpg?v=1586570660563','This is one type of snack with potato',29000,100,1,'01/10/2020','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Swing','https://salt.tikicdn.com/ts/product/40/d7/a8/d908e1c42601e2da8875da1c7cfe4021.jpg','This is one type of snack',5000,100,1,'01/10/2020','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Snack ga nuong','https://lh3.googleusercontent.com/proxy/kX9APvgJ32z51JYJiXw8OMDiSb19i79YFKApddukZNov6EwZjEHJhEl3GeOg_VMYw6gJvxhXGmJvx62Dtnfc0zr8Ukzp_oJW4Axvw1bSid-JHumRn6kafcNr5Q','This is one type of snack',5000,100,1,'01/10/2020','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Snack lay','https://image.pharmacity.vn/live/uploads/2019/05/P06625_1.jpg','This is one type of snack',5000,100,1,'01/10/2020','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Chip chip','https://product.hstatic.net/1000115147/product/snack-ca-_cp_724fd3ec01674bd99712f04b1678b03a_master.png','This is one type of snack',5000,100,1,'01/10/2020','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Snack pho mat','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEf5RfXaZEvgM6JqvXpLmOigOPS3DNWm6q7A&usqp=CAU','This is one type of snack',5000,100,1,'01/10/2020','01/01/2022',0)


--insert drink

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Pepsi','https://pepsiphilippines.com/sites/default/files/pepsiRGB.jpg','Carbonated water',10000,100,2,'01/10/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Coca','https://sieuthitt.com/images/stories/virtuemart/product/coca390.jpg','Carbonated water',10000,200,2,'01/10/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Milk','https://www.purina.ca/sites/g/files/auxxlc601/files/styles/large/public/purina-article-cat-can-cats-drink-milk_500x300.png?itok=8Msuonn0','Milk',8000,100,2,'01/10/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Beer','https://cdn.tgdd.vn/Products/Images/2282/158346/bhx/bia-sai-gon-lager-330ml-202003251213543157.jpg','Fermented drinking water',20000,100,2,'01/11/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Coffee','https://upload.wikimedia.org/wikipedia/commons/4/45/A_small_cup_of_coffee.JPG','Popular drinking in Viet Nam',15000,50,2,'01/10/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Orange juice','https://www.earthfoodandfire.com/wp-content/uploads/2018/04/Homemade-Orange-Juice.jpg','The type of drinking',15000,200,2,'01/10/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Redbull','https://cdn.tgdd.vn/Products/Images/3226/76513/bhx/nuoc-tang-luc-redbull-lon-250ml-15112018162747.JPG','Drink redbull to stay awake',20000,100,2,'01/10/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Olong','https://cdn.tgdd.vn/Products/Images/8938/111564/bhx/6-chai-tra-o-long-tea-plus-455ml-201905221555494576.JPG','Popular drinking in VN',10000,100,2,'01/09/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Tra xanh','https://cdn.tgdd.vn/Products/Images/8938/85739/bhx/tra-xanh-khong-do-vi-chanh-455ml-202004221747285451.jpg','Green tea 0*',10000,200,2,'01/10/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Sting','https://cdn.tgdd.vn/Products/Images/3226/76520/bhx/nuoc-tang-luc-sting-huong-dau-330ml-201909031559004919.jpg','Red water will make you lucky like it color',10000,50,2,'01/11/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('7 up','https://cdn.tgdd.vn/Products/Images/2443/76444/bhx/nuoc-ngot-7-up-vi-chanh-chai-390ml-09112018113228.JPG','The carbonated water',10000,300,2,'01/10/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Milk tea','https://i1.wp.com/www.bamato.vn/wp-content/uploads/2018/09/B%E1%BB%99t-tr%C3%A0-s%E1%BB%AFa-%C4%90%C3%A0i-Loan-Milk-Tea-pha-v%E1%BB%9Bi-tr%C3%A2n-ch%C3%A2u.png?fit=800%2C800&ssl=1','This is a mixed between milk and tea',25000,20,2,'01/10/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Monster','https://cdn.tgdd.vn/Products/Images/3226/142215/bhx/nuoc-tang-luc-monster-energy-lon-355ml-5-700x467.jpg','It will make you stay awake',30000,60,2,'01/10/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Wine','https://luxuo.vn/wp-content/uploads/2020/03/20200331-virtual-wine-tasting.jpg','Alcohol is an alcoholic drink',50000,100,2,'01/11/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Coconut','https://vinmec-prod.s3.amazonaws.com/images/20200513_094457_911488_loi-ich-cua-nuoc-du.max-1800x1800.jpg','Fruit water',15000,100,2,'01/10/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Tea','https://static.toiimg.com/thumb/69385334.cms?width=680&height=512&imgsize=191579','Tea',15000,100,2,'01/10/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Mirinda','https://cdn.tgdd.vn/Products/Images/2443/158318/bhx/nuoc-ngot-mirinda-vi-soda-kem-330ml-201911261643077465.jpg','The carbonated water',10000,300,2,'01/11/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Tra dao','https://media.cooky.vn/recipe/g2/16934/s640/recipe16934-635979775269411988.jpg','The fruit water',20000,100,2,'01/10/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Milo','https://bizweb.dktcdn.net/thumb/large/100/197/189/products/70-14194070-c2a2-4659-ac44-9d17de133e79.jpg','drinking',12000,30,2,'01/09/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Nuoc suoi','https://cdn.tgdd.vn/Products/Images/2563/196027/bhx/nuoc-khoang-chuong-duong-350ml-202002211419444307.jpg','drinking',5000,30,2,'01/09/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Sinh to dau','https://www.hoidaubepaau.com/wp-content/uploads/2015/12/sinh-to-dau.jpg','drinking',25000,30,2,'01/09/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Welche','https://bianhapkhau.net/wp-content/uploads/2019/08/n%C6%B0%E1%BB%9Bc-ng%E1%BB%8Dt-welchs-h%C6%B0%C6%A1ng-nho.jpg','drinking',10000,30,2,'01/09/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Mountain dew','https://product.hstatic.net/1000126467/product/nuoc-ngot-mountain-dew-chai-pet-390ml_grande.jpg','drinking',12000,30,2,'01/09/2021','01/01/2022',0)

insert into tblFood(foodName, image, decription, price, quantity, categoryID, createdate, invalidate,isDelete)
values('Fanta','https://cdn.tgdd.vn/Products/Images/2443/140622/bhx/nuoc-ngot-fanta-vi-viet-quat-lon-330ml-09112018115020.JPG','drinking',10000,30,2,'01/09/2021','01/01/2022',0)

