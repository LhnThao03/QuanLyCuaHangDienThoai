insert into HoaDon(MaHD ,MaNV,MaKH,NgayLap) values(
'HD01','NV01','KH01','2022-5-19')
go
insert into ChiTietHoaDon(MaHD,MaSP,SoLuong) values(
'HD01','SP01',1
)
go
update ChiTietHoaDon
set DonGia = (
select DonGia from SANPHAM where MaSP = ChiTietHoaDon.MaSP
)
where MaHD = 'HD01'
Update HoaDon
set TongTien = (Select sum(TongTien) from ChiTietHoaDon where  HoaDon.MaHD = ChiTietHoaDon.MaHD group by MaHD)
where MaHD = 'HD01'


insert into HoaDon(MaHD ,MaNV,MaKH,NgayLap) values(
'HD02','NV03','KH02','2021-8-21')
go
insert into ChiTietHoaDon(MaHD,MaSP,SoLuong) values
('HD02','SP02',1),
('HD02','SP03',2)
go
update ChiTietHoaDon
set DonGia = (
select DonGia from SANPHAM where MaSP = ChiTietHoaDon.MaSP
)
where MaHD = 'HD02'
go
Update HoaDon
set TongTien = (Select sum(TongTien) from ChiTietHoaDon where  HoaDon.MaHD = ChiTietHoaDon.MaHD group by MaHD)
where MaHD = 'HD02'


insert into HoaDon(MaHD ,MaNV,MaKH,NgayLap) values(
'HD03','NV06','KH03','2023-2-17')
go
insert into ChiTietHoaDon(MaHD,MaSP,SoLuong) values
('HD03','SP04',1),
('HD03','SP05',1),
('HD03','SP07',1)
go
update ChiTietHoaDon
set DonGia = (
select DonGia from SANPHAM where MaSP = ChiTietHoaDon.MaSP
)
where MaHD = 'HD03'
go
Update HoaDon
set TongTien = (Select sum(TongTien) from ChiTietHoaDon where  HoaDon.MaHD = ChiTietHoaDon.MaHD group by MaHD)
where MaHD = 'HD03'

insert into HoaDon(MaHD ,MaNV,MaKH,NgayLap) values(
'HD04','NV08','KH04','2023-3-5')
go
insert into ChiTietHoaDon(MaHD,MaSP,SoLuong) values
('HD04','SP02',1),
('HD04','SP06',2)
go
update ChiTietHoaDon
set DonGia = (
select DonGia from SANPHAM where MaSP = ChiTietHoaDon.MaSP
)
where MaHD = 'HD04'
go
Update HoaDon
set TongTien = (Select sum(TongTien) from ChiTietHoaDon where  HoaDon.MaHD = ChiTietHoaDon.MaHD group by MaHD)
where MaHD = 'HD04'

insert into HoaDon(MaHD ,MaNV,MaKH,NgayLap) values(
'HD05','NV02','KH05','2022-11-10')
go
insert into ChiTietHoaDon(MaHD,MaSP,SoLuong) values
('HD05','SP08',1),
('HD05','SP09',1),
('HD05','SP10',1),
('HD05','SP04',1)
go
update ChiTietHoaDon
set DonGia = (
select DonGia from SANPHAM where MaSP = ChiTietHoaDon.MaSP
)
where MaHD = 'HD05'
go
Update HoaDon
set TongTien = (Select sum(TongTien) from ChiTietHoaDon where  HoaDon.MaHD = ChiTietHoaDon.MaHD group by MaHD)
where MaHD = 'HD05'

insert into HoaDon(MaHD ,MaNV,MaKH,NgayLap) values(
'HD10','NV07','KH10','2023-3-26')
go
insert into ChiTietHoaDon(MaHD,MaSP,SoLuong) values
('HD10','SP10',4),
('HD10','SP09',2),
('HD10','SP04',3)
go
update ChiTietHoaDon
set DonGia = (
select DonGia from SANPHAM where MaSP = ChiTietHoaDon.MaSP
)
where MaHD = 'HD10'
go
Update HoaDon
set TongTien = (Select sum(TongTien) from ChiTietHoaDon where  HoaDon.MaHD = ChiTietHoaDon.MaHD group by MaHD)
where MaHD = 'HD10'
delete from ChiTietHoaDon
delete from HoaDon

delete from TaiKhoan

insert into TaiKhoan values
('NV01','Sunflower','6sunny'),
('NV02','BlueSky1','6bsk1y'),
('NV03','HappyDay','6h@ppy'),
('NV04','SweetHome','6sw33t'),
('NV05','LuckyStar','6lucki'),
('NV06','OceanView','6ocean'),
('NV07','GreenLeaf','6gre3n'),
('NV08','SilverMoon','6silv3r'),
('NV09','MagicKey','6magic'),
('NV10','GoldenSun','6gold3n')