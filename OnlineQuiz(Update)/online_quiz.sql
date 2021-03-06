USE [master]
GO
/****** Object:  Database [J3LP0001]    Script Date: 6/28/2021 5:26:42 PM ******/
CREATE DATABASE [J3LP0001]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'J3LP0001', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\J3LP0001.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'J3LP0001_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\J3LP0001_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [J3LP0001] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [J3LP0001].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [J3LP0001] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [J3LP0001] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [J3LP0001] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [J3LP0001] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [J3LP0001] SET ARITHABORT OFF 
GO
ALTER DATABASE [J3LP0001] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [J3LP0001] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [J3LP0001] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [J3LP0001] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [J3LP0001] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [J3LP0001] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [J3LP0001] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [J3LP0001] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [J3LP0001] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [J3LP0001] SET  ENABLE_BROKER 
GO
ALTER DATABASE [J3LP0001] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [J3LP0001] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [J3LP0001] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [J3LP0001] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [J3LP0001] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [J3LP0001] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [J3LP0001] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [J3LP0001] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [J3LP0001] SET  MULTI_USER 
GO
ALTER DATABASE [J3LP0001] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [J3LP0001] SET DB_CHAINING OFF 
GO
ALTER DATABASE [J3LP0001] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [J3LP0001] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [J3LP0001] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [J3LP0001] SET QUERY_STORE = OFF
GO
USE [J3LP0001]
GO
/****** Object:  Table [dbo].[Answer]    Script Date: 6/28/2021 5:26:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Answer](
	[aid] [varchar](50) NOT NULL,
	[qid] [varchar](50) NULL,
	[content] [nvarchar](max) NOT NULL,
	[isTrue] [bit] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Question]    Script Date: 6/28/2021 5:26:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Question](
	[qid] [varchar](50) NOT NULL,
	[userName] [varchar](50) NOT NULL,
	[content] [nvarchar](max) NOT NULL,
	[created] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[qid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 6/28/2021 5:26:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[userName] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[email] [varchar](max) NOT NULL,
	[isTeacher] [bit] NOT NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[userName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'bjaprgzxeg', N'wsfqfkkock', N'khong chac chan lam !', 0)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'hseqvxmwwz', N'wsfqfkkock', N'Tat nhien', 0)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'oxhaspdzdd', N'wsfqfkkock', N'chac chan', 0)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'yghjavpeyg', N'wsfqfkkock', N'option 2 and option 3 is true', 1)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'kmgkibgvpm', N'tlkbddlcgx', N'Trung quoc', 0)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'fnxdyqxelc', N'tlkbddlcgx', N'Nga', 1)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'quismgdbfu', N'tlkbddlcgx', N'Viet Nam', 0)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'sbwcugiczw', N'tlkbddlcgx', N'Indonesia', 0)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'psqoosrepr', N'fxjxrqswed', N'Software testing', 0)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'ofbgtvjepl', N'fxjxrqswed', N'Introduction to software engineering', 1)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'qiabadsdac', N'fxjxrqswed', N'Software Requirements', 0)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'iqgxamezux', N'fxjxrqswed', N'Development web', 0)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'yruqlgzgfa', N'yqmuuwbnzj', N'mix green + red', 1)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'bznykjjkkb', N'yqmuuwbnzj', N'mix gray+red', 0)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'gwwgfpucvz', N'yqmuuwbnzj', N'mix orange+red', 0)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'yyrrchqngf', N'yqmuuwbnzj', N'mix green+blue', 0)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'flotomqaiv', N'szivhmzysb', N'1', 0)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'nhtwsrpnal', N'szivhmzysb', N'2', 0)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'vedpgcxevd', N'szivhmzysb', N'3', 0)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'ehlbbnnfxw', N'szivhmzysb', N'4', 1)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'owqoygmydd', N'xxhitccqxb', N'1', 0)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'busmyhhnyc', N'xxhitccqxb', N'2', 1)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'bvifbolcjy', N'xxhitccqxb', N'3-1', 1)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'tckjqtgpnl', N'xxhitccqxb', N'4', 0)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'kiyjizaqhd', N'vfdoctodzl', N'1', 0)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'mcbxbbktqd', N'vfdoctodzl', N'2', 1)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'eeqetvichk', N'vfdoctodzl', N'3', 0)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'vwntourchm', N'vfdoctodzl', N'4', 0)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'mqxikqcbje', N'ggstuormio', N'1', 0)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'bsnjnhlped', N'ggstuormio', N'2', 0)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'fffoyxoauq', N'ggstuormio', N'3', 1)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'kijquoxyio', N'ggstuormio', N'4', 0)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'ysvmefjabx', N'tlkkzyehlc', N'hgf', 1)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'ijeutvdnob', N'tlkkzyehlc', N'hgf', 1)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'islnkxpqdb', N'tlkkzyehlc', N'hfg', 1)
INSERT [dbo].[Answer] ([aid], [qid], [content], [isTrue]) VALUES (N'kakajowvxc', N'tlkkzyehlc', N'hgf', 0)
GO
INSERT [dbo].[Question] ([qid], [userName], [content], [created]) VALUES (N'fxjxrqswed', N'tuan', N'SWE stand for', CAST(N'2021-06-11' AS Date))
INSERT [dbo].[Question] ([qid], [userName], [content], [created]) VALUES (N'ggstuormio', N'tuan', N'1+2=', CAST(N'2021-06-11' AS Date))
INSERT [dbo].[Question] ([qid], [userName], [content], [created]) VALUES (N'szivhmzysb', N'tuan', N'con cho co may chan', CAST(N'2021-06-11' AS Date))
INSERT [dbo].[Question] ([qid], [userName], [content], [created]) VALUES (N'tlkbddlcgx', N'tuan', N'what country is the largest in the world!', CAST(N'2021-06-11' AS Date))
INSERT [dbo].[Question] ([qid], [userName], [content], [created]) VALUES (N'tlkkzyehlc', N'tuan', N'hfg', CAST(N'2021-06-25' AS Date))
INSERT [dbo].[Question] ([qid], [userName], [content], [created]) VALUES (N'vfdoctodzl', N'tuan', N'con ga co may chan', CAST(N'2021-06-11' AS Date))
INSERT [dbo].[Question] ([qid], [userName], [content], [created]) VALUES (N'wsfqfkkock', N'tuan', N'Viet Nam Chien thang dai dich', CAST(N'2021-06-11' AS Date))
INSERT [dbo].[Question] ([qid], [userName], [content], [created]) VALUES (N'xxhitccqxb', N'tuan', N'what is answer of 1+1?', CAST(N'2021-06-11' AS Date))
INSERT [dbo].[Question] ([qid], [userName], [content], [created]) VALUES (N'yqmuuwbnzj', N'tuan', N'how to make yellow color?', CAST(N'2021-06-11' AS Date))
GO
INSERT [dbo].[User] ([userName], [password], [email], [isTeacher]) VALUES (N'cong', N'123', N'congbvhe141326@fpt.edu.vn', 0)
INSERT [dbo].[User] ([userName], [password], [email], [isTeacher]) VALUES (N'cong123', N'123', N'congbvhe141326@fpt.edu.vn', 0)
INSERT [dbo].[User] ([userName], [password], [email], [isTeacher]) VALUES (N'cong1234', N'133', N'congbvhe141326@fpt.edu.vn', 1)
INSERT [dbo].[User] ([userName], [password], [email], [isTeacher]) VALUES (N'congbv', N'123', N'congbvhe141326@fpt.edu.vn', 1)
INSERT [dbo].[User] ([userName], [password], [email], [isTeacher]) VALUES (N'sonnt', N'123456', N'sonnt@fpt.edu', 1)
INSERT [dbo].[User] ([userName], [password], [email], [isTeacher]) VALUES (N'thinh', N'123', N'y', 1)
INSERT [dbo].[User] ([userName], [password], [email], [isTeacher]) VALUES (N'tuan', N'123', N'tuanvm@fpt.edu.vn', 1)
INSERT [dbo].[User] ([userName], [password], [email], [isTeacher]) VALUES (N'tung', N'123', N'tung@gmail.com', 0)
GO
ALTER TABLE [dbo].[Answer]  WITH CHECK ADD FOREIGN KEY([qid])
REFERENCES [dbo].[Question] ([qid])
GO
USE [master]
GO
ALTER DATABASE [J3LP0001] SET  READ_WRITE 
GO
