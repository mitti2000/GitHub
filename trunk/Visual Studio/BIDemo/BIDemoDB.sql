USE MASTER;
GO
IF EXISTS(SELECT * FROM sys.databases WHERE NAME = 'AdventureWorksDWH') BEGIN
	DROP DATABASE AdventureWorksDWH;
END;
GO
CREATE DATABASE AdventureWorksDWH;
ALTER DATABASE AdventureWorksDWH SET RECOVERY SIMPLE WITH NO_WAIT;
GO
USE AdventureWorksDWH;
GO

CREATE SCHEMA [BI]
GO

CREATE SCHEMA [Staging]
GO

CREATE TABLE [BI].[DimCustomer]
(   [DimCustomerID] INT IDENTITY NOT NULL
  , [CustomerID] INT NOT NULL
  , [AddressID] INT NOT NULL
  , [CountryRegion] NVARCHAR(50) NOT NULL
  , [StateProvince] NVARCHAR(50) NOT NULL
  , [City] NVARCHAR(30) NOT NULL
  , [PersonName] NVARCHAR(128) NULL
)  

CREATE TABLE [BI].[DimProduct]
(   [DimProductID] INT IDENTITY NOT NULL
  , [Category] NVARCHAR(50) NOT NULL
  , [Subcategory] NVARCHAR(50) NOT NULL
  , [Product] NVARCHAR(50) NOT NULL
  , [Color] NVARCHAR(15) NULL
  , [ListPrice] MONEY NOT NULL
  , [ProductID] INT NOT NULL
)


CREATE TABLE [BI].[FactSales]
(
    [FactSalesID] INT IDENTITY NOT NULL
  , [DimCustomerID] INT NOT NULL
  , [DimProductID] INT NOT NULL
  , [ShipDateID] INT NULL
  , [SubTotal] MONEY NOT NULL
  , [TaxAmt] MONEY NOT NULL
  , [Freight] MONEY NOT NULL
  , [TotalDue] MONEY NOT NULL
  , [OrderQty] SMALLINT NOT NULL
  , [ProductID] INT NOT NULL
  , [UnitPrice] MONEY NOT NULL
  , [UnitPriceDiscount] MONEY NOT NULL
  , [LineTotal] NUMERIC(38, 6) NOT NULL
)

ALTER TABLE [BI].[DimCustomer]
	ADD CONSTRAINT [PK_DimCustomer]
	PRIMARY KEY (DimCustomerID)

ALTER TABLE [BI].[DimProduct]
	ADD CONSTRAINT [PK_DimProduct]
	PRIMARY KEY (DimProductID)

ALTER TABLE [BI].[FactSales]
	ADD CONSTRAINT [PK_FactSales]
	PRIMARY KEY (FactSalesID)

CREATE TABLE [Staging].[DimProduct]
(   [DimProductID] INT NOT NULL
  , [Category] NVARCHAR(50) NOT NULL
  , [Subcategory] NVARCHAR(50) NOT NULL
  , [Product] NVARCHAR(50) NOT NULL
  , [Color] NVARCHAR(15) NULL
  , [ListPrice] MONEY NOT NULL
  , [ProductID] INT NOT NULL
)

CREATE TABLE [Staging].[DimCustomer]
(   [DimCustomerID] INT NOT NULL
  , [CustomerID] INT NOT NULL
  , [AddressID] INT NOT NULL
  , [CountryRegion] NVARCHAR(50) NOT NULL
  , [StateProvince] NVARCHAR(50) NOT NULL
  , [City] NVARCHAR(30) NOT NULL
  , [PersonName] NVARCHAR(128) NULL
)  