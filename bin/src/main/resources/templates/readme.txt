Thank you for using our template!

For more awesome templates please visit https://colorlib.com/wp/templates/

Copyright information for the template can't be altered/removed unless you purchase a license.
More information about the license is available here: https://colorlib.com/wp/licence/

Removing copyright information without the license will result in suspension of your hosting and/or domain name(s).

---------bobby userInfo data
create table userInfo(
userId int IDENTITY(1,1) not null primary key,
email nvarchar(50) not null,
userPwd nvarchar(max) not null,
userName nvarchar(50) not null,
gender nvarchar(5),
userPhone nvarchar(11),
userBirthday nvarchar(10),
userPic nvarchar(max),
roles nvarchar(10) not null
)

---------bobby userInfo data
