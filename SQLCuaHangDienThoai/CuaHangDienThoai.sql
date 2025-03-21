USE [master]
GO
/****** Object:  Database [QuanLyCuaHangDienThoai]    Script Date: 09-Apr-23 4:31:43 PM ******/
CREATE DATABASE [QuanLyCuaHangDienThoai]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyCuaHangDienThoai', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\QuanLyCuaHangDienThoai.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QuanLyCuaHangDienThoai_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\QuanLyCuaHangDienThoai_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyCuaHangDienThoai].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [QuanLyCuaHangDienThoai]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 09-Apr-23 4:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaHD] [nchar](10) foreign key(MaHD) references HoaDon(MaHD),
	[MaSP] [nchar](10) foreign key(MaSP) references SANPHAM(MaSP),
	[SoLuong] [int] NULL,
	[DonGia] [float] NULL,
	[TongTien] as (SoLuong*DonGia),
	primary key(MaHD,MaSP)
	)
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ChiTietPhieuNhap]    Script Date: 09-Apr-23 4:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuNhap](
	[MaPN] [nchar](10) NOT NULL foreign key(MaPN) references PhieuNhap(MaPN),
	[MaSP] [nchar](10) NOT NULL foreign key(MaSP) references SanPham(MaSP),
	[SoLuong] [int] NULL,
	[DonGia] [float] NULL,
	[ThanhTien]  as (SoLuong*DonGia),
 CONSTRAINT [PK_ChiTietPhieuNhap] PRIMARY KEY CLUSTERED 
(
	[MaPN] ASC,
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ChiTietSanPham]    Script Date: 09-Apr-23 4:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietSanPham](
	[MaSP] [nchar](10) NOT NULL foreign key(MaSP) references SANPHAM(MaSP),
	[BaoHanh] [nvarchar](50) NULL,
	[MauSac] [nvarchar](50) NULL,
	[IMEI] [nchar](20) NULL,
	[ManHinh] [nvarchar](50) NULL,
	[RAM] [nvarchar](50) NULL,
	[ROM] [nvarchar](50) NULL,
	[Pin] [nvarchar](50) NULL,
	[ThietKe] [nvarchar](50) NULL,
	[Camera] [nvarchar](50) NULL,
	[XuatSu] [nvarchar](50) NULL,
	[KhoiLuong] [float] NULL,
	PRIMARY KEY(MaSP))
 CONSTRAINT [PK_ChiTietSanPham] PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 09-Apr-23 4:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHD] [nchar](10) NOT NULL,
	[MaNV] [nchar](10) NULL foreign key(MaNV) references NhanVien(MaNV),
	[MaKH] [nchar](10) NULL foreign key(MaKH) references KhachHang(MaKH),
	[NgayLap] [date] NULL,
	[TongTien] [float] NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 09-Apr-23 4:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [nchar](10) NOT NULL,
	[TenKH] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[SDT] [nchar](10) NULL,
 CONSTRAINT [PK_Khachhang] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 09-Apr-23 4:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[MaNCC] [nchar](10) NOT NULL,
	[TenNCC] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[SDT] [int] NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 09-Apr-23 4:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [nchar](10) NOT NULL,
	[HoTen] [nvarchar](50) NOT NULL,
	[SDT] [nchar](10) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[GioiTinh] [nvarchar](50) NULL,
	[Luong] [float] NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PhieuNhap]    Script Date: 09-Apr-23 4:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhap](
	[MaPN] [nchar](10) NOT NULL,
	[NgayNhap] [date] NULL,
	[GioNhap] [int] NULL,
	[TongTien] [float] NULL,
	[MaNCC] [nchar](10) NOT NULL foreign key(MaNCC) references NhaCungCap(MaNCC),
	[MaNV] [nchar](10) NOT NULL foreign key(MaNV) references NhanVien(MaNV)
 CONSTRAINT [PK_PhieuNhap] PRIMARY KEY CLUSTERED 
(
	[MaPN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 09-Apr-23 4:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE SANPHAM(
    [MaSP] [nchar](10) NOT NULL PRIMARY KEY,
	[TenSP] [nvarchar](50) NOT NULL,
	[SoLuong] [int] NULL,
	[DonGia] [float] NULL,
	[NamSX] [int] NULL,
	[HDH] [nvarchar](50) NOT NULL,
)
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 09-Apr-23 4:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
    [MaNV] [nchar](10) foreign key (MaNV) references NhanVien(MaNV),
	[TaiKhoan] [nvarchar](50) NOT NULL primary key,
	[MatKhau] [nchar](10) NULL,
	CONSTRAINT UQ_MaNV_MaNV UNIQUE(MaNV)
	)
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[TaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([MaHD])
REFERENCES [dbo].[HoaDon] ([MaHD])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuNhap_PhieuNhap] FOREIGN KEY([MaPN])
REFERENCES [dbo].[PhieuNhap] ([MaPN])
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap] CHECK CONSTRAINT [FK_ChiTietPhieuNhap_PhieuNhap]
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuNhap_SanPham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap] CHECK CONSTRAINT [FK_ChiTietPhieuNhap_SanPham]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhap_NhaCungCap] FOREIGN KEY([MaNCC])
REFERENCES [dbo].[NhaCungCap] ([MaNCC])
GO
ALTER TABLE [dbo].[PhieuNhap] CHECK CONSTRAINT [FK_PhieuNhap_NhaCungCap]
GO
ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhap_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[PhieuNhap] CHECK CONSTRAINT [FK_PhieuNhap_NhanVien]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_ChiTietSanPham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[ChiTietSanPham] ([MaSP])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_ChiTietSanPham]
GO
USE [master]
GO
ALTER DATABASE [QuanLyCuaHangDienThoai] SET  READ_WRITE 
GO
delete from ChiTietPhieuNhap
insert into PhieuNhap(MaPN,NgayNhap,GioNhap,MaNCC,MaNV) values(
'PN01','2022-12-15',16,'NCC01','NV01'
)
go
insert into ChiTietPhieuNhap values(
'PN01','SP01',5,13500000
)
go
insert into ChiTietPhieuNhap values(
'PN01','SP04',5,10200000
)
go
insert into ChiTietPhieuNhap values(
'PN01','SP05',7,8540000
)
go
UPDATE PhieuNhap
SET TongTien = (
SELECT SUM(ThanhTien)
FROM ChiTietPhieuNhap
WHERE ChiTietPhieuNhap.MaPN = PhieuNhap.MaPN
GROUP BY MaPN
)
WHERE MaPN = 'PN01';

go
insert into PhieuNhap(MaPN,NgayNhap,GioNhap,MaNCC,MaNV) values(
'PN02','2022-11-12',10,'NCC02','NV03'
)
go
insert into ChiTietPhieuNhap values(
'PN02','SP01',9,13500000
)
go
insert into ChiTietPhieuNhap values(
'PN02','SP06',5,600000
)
go
insert into ChiTietPhieuNhap values(
'PN01','SP09',4,7540000
)
go
UPDATE PhieuNhap
SET TongTien = (
SELECT SUM(ThanhTien)
FROM ChiTietPhieuNhap
WHERE ChiTietPhieuNhap.MaPN = PhieuNhap.MaPN
GROUP BY MaPN
)
WHERE MaPN = 'PN02';
go
insert into PhieuNhap(MaPN,NgayNhap,GioNhap,MaNCC,MaNV) values(
'PN03','2022-9-21',9,'NCC03','NV09'
)
go
insert into ChiTietPhieuNhap values(
'PN03','SP06',5,6500000
)
go
insert into ChiTietPhieuNhap values(
'PN03','SP02',7,9500000
)
go
insert into ChiTietPhieuNhap values(
'PN03','SP07',11,8040000
)
go
UPDATE PhieuNhap
SET TongTien = (
SELECT SUM(ThanhTien)
FROM ChiTietPhieuNhap
WHERE ChiTietPhieuNhap.MaPN = PhieuNhap.MaPN
GROUP BY MaPN
)
WHERE MaPN = 'PN03';
go
insert into PhieuNhap(MaPN,NgayNhap,GioNhap,MaNCC,MaNV) values(
'PN04','2022-5-12',14,'NCC02','NV05'
)
go
insert into ChiTietPhieuNhap values(
'PN04','SP05',15,9000000
)
go
insert into ChiTietPhieuNhap values(
'PN04','SP08',4,6000000
)
go
insert into ChiTietPhieuNhap values(
'PN04','SP06',7,7040000
)
go
UPDATE PhieuNhap
SET TongTien = (
SELECT SUM(ThanhTien)
FROM ChiTietPhieuNhap
WHERE ChiTietPhieuNhap.MaPN = PhieuNhap.MaPN
GROUP BY MaPN
)
WHERE MaPN = 'PN04';
insert into PhieuNhap(MaPN,NgayNhap,GioNhap,MaNCC,MaNV) values(
'PN05','2022-1-17',9,'NCC01','NV07'
)

INSERT INTO ChiTietPhieuNhap VALUES
('PN05','SP03',5,7500000),
('PN05','SP10',12,9000000),
('PN05','SP02',2,9500000);
UPDATE PhieuNhap
SET TongTien = (
SELECT SUM(ThanhTien)
FROM ChiTietPhieuNhap
WHERE ChiTietPhieuNhap.MaPN = PhieuNhap.MaPN
GROUP BY MaPN
)
WHERE MaPN = 'PN05';

insert into PhieuNhap(MaPN,NgayNhap,GioNhap,MaNCC,MaNV) values(
'PN06','2021-11-17',15,'NCC02','NV10'
)

INSERT INTO ChiTietPhieuNhap VALUES
('PN06','SP04',8,10200000),
('PN06','SP06',7,600000),
('PN06','SP07',4,8040000);
UPDATE PhieuNhap
SET TongTien = (
SELECT SUM(ThanhTien)
FROM ChiTietPhieuNhap
WHERE ChiTietPhieuNhap.MaPN = PhieuNhap.MaPN
GROUP BY MaPN
)
WHERE MaPN = 'PN06';

insert into PhieuNhap(MaPN,NgayNhap,GioNhap,MaNCC,MaNV) values(
'PN07','2023-2-16',16,'NCC03','NV02'
)
go
INSERT INTO ChiTietPhieuNhap VALUES
('PN07','SP03',16,8040000),
('PN07','SP02',12,9500000),
('PN07','SP01',13,13500000);
go
UPDATE PhieuNhap
SET TongTien = (
SELECT SUM(ThanhTien)
FROM ChiTietPhieuNhap
WHERE ChiTietPhieuNhap.MaPN = PhieuNhap.MaPN
GROUP BY MaPN
)
WHERE MaPN = 'PN07';

insert into PhieuNhap(MaPN,NgayNhap,GioNhap,MaNCC,MaNV) values(
'PN08','2023-4-5',12,'NCC02','NV04'
)
go
INSERT INTO ChiTietPhieuNhap VALUES
('PN08','SP04',16,11899000),
('PN08','SP05',12,8540000),
('PN08','SP06',13,600000);
go
UPDATE PhieuNhap
SET TongTien = (
SELECT SUM(ThanhTien)
FROM ChiTietPhieuNhap
WHERE ChiTietPhieuNhap.MaPN = PhieuNhap.MaPN
GROUP BY MaPN
)
WHERE MaPN = 'PN08';
insert into PhieuNhap(MaPN,NgayNhap,GioNhap,MaNCC,MaNV) values(
'PN09','2022-7-29',17,'NCC03','NV08'
)
go
INSERT INTO ChiTietPhieuNhap VALUES
('PN09','SP07',12,8040000),
('PN09','SP03',9,7500000),
('PN09','SP10',7,9000000);
go
UPDATE PhieuNhap
SET TongTien = (
SELECT SUM(ThanhTien)
FROM ChiTietPhieuNhap
WHERE ChiTietPhieuNhap.MaPN = PhieuNhap.MaPN
GROUP BY MaPN
)
WHERE MaPN = 'PN09';

insert into PhieuNhap(MaPN,NgayNhap,GioNhap,MaNCC,MaNV) values(
'PN10','2022-6-18',12,'NCC02','NV09'
)
go
INSERT INTO ChiTietPhieuNhap VALUES
('PN10','SP05',10,8540000),
('PN10','SP01',11,13500000)
go
UPDATE PhieuNhap
SET TongTien = (
SELECT SUM(ThanhTien)
FROM ChiTietPhieuNhap
WHERE ChiTietPhieuNhap.MaPN = PhieuNhap.MaPN
GROUP BY MaPN
)
WHERE MaPN = 'PN10';
delete from ChiTietPhieuNhap
delete from PhieuNhap

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