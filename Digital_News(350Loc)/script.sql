USE [master]
GO
/****** Object:  Database [Digital_News]    Script Date: 6/28/2021 5:27:03 PM ******/
CREATE DATABASE [Digital_News1]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Digital_News', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Digital_News1.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Digital_News_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Digital_News1_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Digital_News1] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Digital_News1].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Digital_News1] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Digital_News1] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Digital_News1] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Digital_News1] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Digital_News1] SET ARITHABORT OFF 
GO
ALTER DATABASE [Digital_News1] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [Digital_News1] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Digital_News1] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Digital_News1] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Digital_News1] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Digital_News1] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Digital_News1] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Digital_News1] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Digital_News1] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Digital_News1] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Digital_News1] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Digital_News1] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Digital_News1] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Digital_News1] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Digital_News1] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Digital_News1] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Digital_News1] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Digital_News1] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Digital_News1] SET  MULTI_USER 
GO
ALTER DATABASE [Digital_News1] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Digital_News1] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Digital_News1] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Digital_News1] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Digital_News1] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Digital_News1] SET QUERY_STORE = OFF
GO
USE [Digital_News1]
GO
/****** Object:  Table [dbo].[News]    Script Date: 6/28/2021 5:27:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[News](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](255) NOT NULL,
	[content] [text] NULL,
	[date] [datetime] NULL,
	[writer] [nvarchar](255) NULL,
	[images] [text] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[News] ON 

INSERT [dbo].[News] ([id], [title], [content], [date], [writer], [images]) VALUES (1, N'Title News 2', N'<img class="img-news" src="template/images/i1.jpg" alt="i1" />
        <p class="content-news"> In today’s age of surveillance, with cameras even in our homes, security professionals need to monitor an ever-increasing number of screens. In 2014 alone, 245 million video surveillance cameras were installed globally, according to an IHS report. It is increasingly clear that the ‘watchmen’ are having trouble watching. This is where Singapore-based Vi Dimensions hopes to help, by identifying anomalies to alert human operators that a second look is needed.
 </p>
        <p class="content-news"> While the security industry is already familiar with rule-based analytics, there is still a gap, according to its cofounder and chief executive officer Raymond Looi. Video analytics has been in the market for the last 10 years, but the way they have been doing it is not very efficient, using rule-based analytics. This requires you to know what you are looking for and then specify a rule, when most do not know what to look out for, he says, in a conversation with Digital News Asia (DNA) in Singapore recently. We felt that there was a gap in the industry in how they applied automation to cameras – and with the proliferation of surveillance cameras and vast amounts of data being generated, we felt that this was an area in which we could differentiate ourselves, he adds. </p>
', CAST(N'2021-05-11T13:13:51.363' AS DateTime), N'Writer2', N' <img class="img" src="template/images/i1.jpg" alt="i1" />')
INSERT [dbo].[News] ([id], [title], [content], [date], [writer], [images]) VALUES (2, N'Title News 3', N'<img class="img-news" src="template/images/i1.jpg" alt="i1" />
        <p class="content-news"> In today’s age of surveillance, with cameras even in our homes, security professionals need to monitor an ever-increasing number of screens. In 2014 alone, 245 million video surveillance cameras were installed globally, according to an IHS report. It is increasingly clear that the ‘watchmen’ are having trouble watching. This is where Singapore-based Vi Dimensions hopes to help, by identifying anomalies to alert human operators that a second look is needed.
 </p>
        <p class="content-news"> While the security industry is already familiar with rule-based analytics, there is still a gap, according to its cofounder and chief executive officer Raymond Looi. Video analytics has been in the market for the last 10 years, but the way they have been doing it is not very efficient, using rule-based analytics. This requires you to know what you are looking for and then specify a rule, when most do not know what to look out for, he says, in a conversation with Digital News Asia (DNA) in Singapore recently. We felt that there was a gap in the industry in how they applied automation to cameras – and with the proliferation of surveillance cameras and vast amounts of data being generated, we felt that this was an area in which we could differentiate ourselves, he adds. </p>
', CAST(N'2021-05-11T13:13:51.383' AS DateTime), N'Writer3', N' <img class="img" src="template/images/i1.jpg" alt="i1" />')
INSERT [dbo].[News] ([id], [title], [content], [date], [writer], [images]) VALUES (3, N'Title News 4', N'<img class="img-news" src="template/images/i1.jpg" alt="i1" />
        <p class="content-news"> In today’s age of surveillance, with cameras even in our homes, security professionals need to monitor an ever-increasing number of screens. In 2014 alone, 245 million video surveillance cameras were installed globally, according to an IHS report. It is increasingly clear that the ‘watchmen’ are having trouble watching. This is where Singapore-based Vi Dimensions hopes to help, by identifying anomalies to alert human operators that a second look is needed.
 </p>
        <p class="content-news"> While the security industry is already familiar with rule-based analytics, there is still a gap, according to its cofounder and chief executive officer Raymond Looi. Video analytics has been in the market for the last 10 years, but the way they have been doing it is not very efficient, using rule-based analytics. This requires you to know what you are looking for and then specify a rule, when most do not know what to look out for, he says, in a conversation with Digital News Asia (DNA) in Singapore recently. We felt that there was a gap in the industry in how they applied automation to cameras – and with the proliferation of surveillance cameras and vast amounts of data being generated, we felt that this was an area in which we could differentiate ourselves, he adds. </p>
', CAST(N'2021-05-11T13:13:51.387' AS DateTime), N'Writer1', N' <img class="img" src="template/images/i1.jpg" alt="i1" />')
INSERT [dbo].[News] ([id], [title], [content], [date], [writer], [images]) VALUES (4, N'Title News 5', N'<img class="img-news" src="template/images/i1.jpg" alt="i1" />
        <p class="content-news"> In today’s age of surveillance, with cameras even in our homes, security professionals need to monitor an ever-increasing number of screens. In 2014 alone, 245 million video surveillance cameras were installed globally, according to an IHS report. It is increasingly clear that the ‘watchmen’ are having trouble watching. This is where Singapore-based Vi Dimensions hopes to help, by identifying anomalies to alert human operators that a second look is needed.
 </p>
        <p class="content-news"> While the security industry is already familiar with rule-based analytics, there is still a gap, according to its cofounder and chief executive officer Raymond Looi. Video analytics has been in the market for the last 10 years, but the way they have been doing it is not very efficient, using rule-based analytics. This requires you to know what you are looking for and then specify a rule, when most do not know what to look out for, he says, in a conversation with Digital News Asia (DNA) in Singapore recently. We felt that there was a gap in the industry in how they applied automation to cameras – and with the proliferation of surveillance cameras and vast amounts of data being generated, we felt that this was an area in which we could differentiate ourselves, he adds. </p>
', CAST(N'2021-05-11T13:13:51.390' AS DateTime), N'Writer2', N' <img class="img" src="template/images/i1.jpg" alt="i1" />')
INSERT [dbo].[News] ([id], [title], [content], [date], [writer], [images]) VALUES (5, N'Title News 6', N'<img class="img-news" src="template/images/i1.jpg" alt="i1" />
        <p class="content-news"> In today’s age of surveillance, with cameras even in our homes, security professionals need to monitor an ever-increasing number of screens. In 2014 alone, 245 million video surveillance cameras were installed globally, according to an IHS report. It is increasingly clear that the ‘watchmen’ are having trouble watching. This is where Singapore-based Vi Dimensions hopes to help, by identifying anomalies to alert human operators that a second look is needed.
 </p>
        <p class="content-news"> While the security industry is already familiar with rule-based analytics, there is still a gap, according to its cofounder and chief executive officer Raymond Looi. Video analytics has been in the market for the last 10 years, but the way they have been doing it is not very efficient, using rule-based analytics. This requires you to know what you are looking for and then specify a rule, when most do not know what to look out for, he says, in a conversation with Digital News Asia (DNA) in Singapore recently. We felt that there was a gap in the industry in how they applied automation to cameras – and with the proliferation of surveillance cameras and vast amounts of data being generated, we felt that this was an area in which we could differentiate ourselves, he adds. </p>
', CAST(N'2021-05-11T13:13:49.400' AS DateTime), N'Writer1', N' <img class="img" src="template/images/i1.jpg" alt="i1" />')
INSERT [dbo].[News] ([id], [title], [content], [date], [writer], [images]) VALUES (6, N'Elevetina tawark an layanan Mok ado', N'<img class="img-news" src="template/images/i1.jpg" alt="i1" />
        <p class="content-news"> In today’s age of surveillance, with cameras even in our homes, security professionals need to monitor an ever-increasing number of screens. In 2014 alone, 245 million video surveillance cameras were installed globally, according to an IHS report. It is increasingly clear that the ‘watchmen’ are having trouble watching. This is where Singapore-based Vi Dimensions hopes to help, by identifying anomalies to alert human operators that a second look is needed.
 </p>
        <p class="content-news"> While the security industry is already familiar with rule-based analytics, there is still a gap, according to its cofounder and chief executive officer Raymond Looi. Video analytics has been in the market for the last 10 years, but the way they have been doing it is not very efficient, using rule-based analytics. This requires you to know what you are looking for and then specify a rule, when most do not know what to look out for, he says, in a conversation with Digital News Asia (DNA) in Singapore recently. We felt that there was a gap in the industry in how they applied automation to cameras – and with the proliferation of surveillance cameras and vast amounts of data being generated, we felt that this was an area in which we could differentiate ourselves, he adds. </p>
', CAST(N'2021-05-11T13:13:51.400' AS DateTime), N'Writer1', N' <img class="img" src="template/images/i1.jpg" alt="i1" />')
INSERT [dbo].[News] ([id], [title], [content], [date], [writer], [images]) VALUES (7, N'What is next for the wireless industry?', N'<img class="img-news" src="template/images/i1.jpg" alt="i1" />
        <p class="content-news"> In today’s age of surveillance, with cameras even in our homes, security professionals need to monitor an ever-increasing number of screens. In 2014 alone, 245 million video surveillance cameras were installed globally, according to an IHS report. It is increasingly clear that the ‘watchmen’ are having trouble watching. This is where Singapore-based Vi Dimensions hopes to help, by identifying anomalies to alert human operators that a second look is needed.
 </p>
        <p class="content-news"> While the security industry is already familiar with rule-based analytics, there is still a gap, according to its cofounder and chief executive officer Raymond Looi. Video analytics has been in the market for the last 10 years, but the way they have been doing it is not very efficient, using rule-based analytics. This requires you to know what you are looking for and then specify a rule, when most do not know what to look out for, he says, in a conversation with Digital News Asia (DNA) in Singapore recently. We felt that there was a gap in the industry in how they applied automation to cameras – and with the proliferation of surveillance cameras and vast amounts of data being generated, we felt that this was an area in which we could differentiate ourselves, he adds. </p>
', CAST(N'2021-05-11T13:13:51.400' AS DateTime), N'Writer1', N' <img class="img" src="template/images/i1.jpg" alt="i1" />')
INSERT [dbo].[News] ([id], [title], [content], [date], [writer], [images]) VALUES (8, N'Pick yourself''s up learn, sharpen skills', N'<img class="img-news" src="template/images/i1.jpg" alt="i1" />
        <p class="content-news"> In today’s age of surveillance, with cameras even in our homes, security professionals need to monitor an ever-increasing number of screens. In 2014 alone, 245 million video surveillance cameras were installed globally, according to an IHS report. It is increasingly clear that the ‘watchmen’ are having trouble watching. This is where Singapore-based Vi Dimensions hopes to help, by identifying anomalies to alert human operators that a second look is needed.
 </p>
        <p class="content-news"> While the security industry is already familiar with rule-based analytics, there is still a gap, according to its cofounder and chief executive officer Raymond Looi. Video analytics has been in the market for the last 10 years, but the way they have been doing it is not very efficient, using rule-based analytics. This requires you to know what you are looking for and then specify a rule, when most do not know what to look out for, he says, in a conversation with Digital News Asia (DNA) in Singapore recently. We felt that there was a gap in the industry in how they applied automation to cameras – and with the proliferation of surveillance cameras and vast amounts of data being generated, we felt that this was an area in which we could differentiate ourselves, he adds. </p>
', CAST(N'2021-05-11T13:13:51.400' AS DateTime), N'Writer2', N' <img class="img" src="template/images/i1.jpg" alt="i1" />')
INSERT [dbo].[News] ([id], [title], [content], [date], [writer], [images]) VALUES (9, N'Tony''s Top 10 Tips for Entrepreneurs', N'<img class="img-news" src="template/images/i1.jpg" alt="i1" />
        <p class="content-news"> In today’s age of surveillance, with cameras even in our homes, security professionals need to monitor an ever-increasing number of screens. In 2014 alone, 245 million video surveillance cameras were installed globally, according to an IHS report. It is increasingly clear that the ‘watchmen’ are having trouble watching. This is where Singapore-based Vi Dimensions hopes to help, by identifying anomalies to alert human operators that a second look is needed.
 </p>
        <p class="content-news"> While the security industry is already familiar with rule-based analytics, there is still a gap, according to its cofounder and chief executive officer Raymond Looi. Video analytics has been in the market for the last 10 years, but the way they have been doing it is not very efficient, using rule-based analytics. This requires you to know what you are looking for and then specify a rule, when most do not know what to look out for, he says, in a conversation with Digital News Asia (DNA) in Singapore recently. We felt that there was a gap in the industry in how they applied automation to cameras – and with the proliferation of surveillance cameras and vast amounts of data being generated, we felt that this was an area in which we could differentiate ourselves, he adds. </p>
', CAST(N'2021-05-11T13:13:51.400' AS DateTime), N'Writer2', N' <img class="img" src="template/images/i1.jpg" alt="i1" />')
INSERT [dbo].[News] ([id], [title], [content], [date], [writer], [images]) VALUES (10, N'Elevetina tawark an layanan Mok ado', N'<img class="img-news" src="template/images/i1.jpg" alt="i1" />
        <p class="content-news"> In today’s age of surveillance, with cameras even in our homes, security professionals need to monitor an ever-increasing number of screens. In 2014 alone, 245 million video surveillance cameras were installed globally, according to an IHS report. It is increasingly clear that the ‘watchmen’ are having trouble watching. This is where Singapore-based Vi Dimensions hopes to help, by identifying anomalies to alert human operators that a second look is needed.
 </p>
        <p class="content-news"> While the security industry is already familiar with rule-based analytics, there is still a gap, according to its cofounder and chief executive officer Raymond Looi. Video analytics has been in the market for the last 10 years, but the way they have been doing it is not very efficient, using rule-based analytics. This requires you to know what you are looking for and then specify a rule, when most do not know what to look out for, he says, in a conversation with Digital News Asia (DNA) in Singapore recently. We felt that there was a gap in the industry in how they applied automation to cameras – and with the proliferation of surveillance cameras and vast amounts of data being generated, we felt that this was an area in which we could differentiate ourselves, he adds. </p>
', CAST(N'2021-05-11T13:13:59.400' AS DateTime), N'Writer3', N' <img class="img" src="template/images/i1.jpg" alt="i1" />')
INSERT [dbo].[News] ([id], [title], [content], [date], [writer], [images]) VALUES (11, N'FPT University free vaccination COVID-19', N'<img class="img-news" src="template/images/i1.jpg" alt="i1" />
        <p class="content-news"> In today’s age of surveillance, with cameras even in our homes, security professionals need to monitor an ever-increasing number of screens. In 2014 alone, 245 million video surveillance cameras were installed globally, according to an IHS report. It is increasingly clear that the ‘watchmen’ are having trouble watching. This is where Singapore-based Vi Dimensions hopes to help, by identifying anomalies to alert human operators that a second look is needed.
 </p>
        <p class="content-news"> While the security industry is already familiar with rule-based analytics, there is still a gap, according to its cofounder and chief executive officer Raymond Looi. Video analytics has been in the market for the last 10 years, but the way they have been doing it is not very efficient, using rule-based analytics. This requires you to know what you are looking for and then specify a rule, when most do not know what to look out for, he says, in a conversation with Digital News Asia (DNA) in Singapore recently. We felt that there was a gap in the industry in how they applied automation to cameras – and with the proliferation of surveillance cameras and vast amounts of data being generated, we felt that this was an area in which we could differentiate ourselves, he adds. </p>
', CAST(N'2021-05-11T13:13:57.400' AS DateTime), N'Bien Cong', N' <img class="img" src="template/images/i1.jpg" alt="i1" />')
INSERT [dbo].[News] ([id], [title], [content], [date], [writer], [images]) VALUES (12, N'FPT University organizes online exam', N'<img class="img-news" src="template/images/i1.jpg" alt="i1" />
        <p class="content-news"> In today’s age of surveillance, with cameras even in our homes, security professionals need to monitor an ever-increasing number of screens. In 2014 alone, 245 million video surveillance cameras were installed globally, according to an IHS report. It is increasingly clear that the ‘watchmen’ are having trouble watching. This is where Singapore-based Vi Dimensions hopes to help, by identifying anomalies to alert human operators that a second look is needed.
 </p>
        <p class="content-news"> While the security industry is already familiar with rule-based analytics, there is still a gap, according to its cofounder and chief executive officer Raymond Looi. Video analytics has been in the market for the last 10 years, but the way they have been doing it is not very efficient, using rule-based analytics. This requires you to know what you are looking for and then specify a rule, when most do not know what to look out for, he says, in a conversation with Digital News Asia (DNA) in Singapore recently. We felt that there was a gap in the industry in how they applied automation to cameras – and with the proliferation of surveillance cameras and vast amounts of data being generated, we felt that this was an area in which we could differentiate ourselves, he adds. </p>
', CAST(N'2021-05-11T13:13:56.400' AS DateTime), N'Bien Cong', N' <img class="img" src="template/images/i1.jpg" alt="i1" />')
INSERT [dbo].[News] ([id], [title], [content], [date], [writer], [images]) VALUES (13, N'Wear a mask when leaving the house', N'<img class="img-news" src="template/images/i1.jpg" alt="i1" />
        <p class="content-news"> In today’s age of surveillance, with cameras even in our homes, security professionals need to monitor an ever-increasing number of screens. In 2014 alone, 245 million video surveillance cameras were installed globally, according to an IHS report. It is increasingly clear that the ‘watchmen’ are having trouble watching. This is where Singapore-based Vi Dimensions hopes to help, by identifying anomalies to alert human operators that a second look is needed.
 </p>
        <p class="content-news"> While the security industry is already familiar with rule-based analytics, there is still a gap, according to its cofounder and chief executive officer Raymond Looi. Video analytics has been in the market for the last 10 years, but the way they have been doing it is not very efficient, using rule-based analytics. This requires you to know what you are looking for and then specify a rule, when most do not know what to look out for, he says, in a conversation with Digital News Asia (DNA) in Singapore recently. We felt that there was a gap in the industry in how they applied automation to cameras – and with the proliferation of surveillance cameras and vast amounts of data being generated, we felt that this was an area in which we could differentiate ourselves, he adds. </p>
', CAST(N'2021-05-11T22:13:58.400' AS DateTime), N'Bien Cong', N' <img class="img" src="template/images/i1.jpg" alt="i1" />')
SET IDENTITY_INSERT [dbo].[News] OFF
GO
USE [master]
GO
ALTER DATABASE [Digital_News] SET  READ_WRITE 
GO
