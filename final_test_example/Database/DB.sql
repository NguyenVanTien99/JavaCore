USE [final_example]
GO
/****** Object:  Table [dbo].[GoodStudent]    Script Date: 30/05/2021 09:42:53 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GoodStudent](
	[name] [varchar](55) NULL,
	[day_of_birth] [date] NULL,
	[sex] [varchar](10) NULL,
	[phone_number] [varchar](255) NULL,
	[name_universiry] [varchar](255) NULL,
	[grade_level] [varchar](255) NULL,
	[gpa] [float] NULL,
	[best_reward_name] [varchar](255) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NormalStudent]    Script Date: 30/05/2021 09:42:53 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NormalStudent](
	[name] [varchar](55) NULL,
	[day_of_birth] [date] NULL,
	[sex] [varchar](10) NULL,
	[phone_number] [varchar](255) NULL,
	[name_universiry] [varchar](255) NULL,
	[grade_level] [varchar](255) NULL,
	[english_score] [float] NULL,
	[entry_score] [float] NULL
) ON [PRIMARY]
GO
