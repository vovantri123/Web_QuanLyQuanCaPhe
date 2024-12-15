USE WebBanCaPhe

GO

------------------------------------------------------Trigger------------------------------------------------------
CREATE TRIGGER trg_TuDongTaoMaSlide_Slide
ON Slide
INSTEAD OF INSERT
AS
BEGIN
    BEGIN TRY
        DECLARE @maxMaSlide NVARCHAR(50);
        DECLARE @newMaSlide NVARCHAR(50);
        DECLARE @numPart INT;
		 
        SELECT @maxMaSlide = MAX(MaSlide)
        FROM Slide
        WHERE MaSlide LIKE 'SL%';

        IF @maxMaSlide IS NOT NULL
        BEGIN 
            SET @numPart = CAST(SUBSTRING(@maxMaSlide, 3, LEN(@maxMaSlide) - 2) AS INT) + 1;
        END
        ELSE
        BEGIN 
            SET @numPart = 1;
        END

        -- Tạo mã mới dạng SLxx (2 chữ số)
        SET @newMaSlide = 'SL' + RIGHT('00' + CAST(@numPart AS NVARCHAR), 2);
		 
        INSERT INTO Slide(MaSlide, TenSlide, AnhSlide, ViTri, TrangThai, MaND)
        SELECT @newMaSlide, TenSlide, AnhSlide, ViTri, TrangThai, MaND
        FROM inserted;

    END TRY
    BEGIN CATCH
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE();
        RAISERROR (@ErrorMessage, 16, 1);
    END CATCH
END;

GO 
 

CREATE TRIGGER trg_TuDongTaoMaVC_Voucher
ON Voucher
INSTEAD OF INSERT
AS
BEGIN
    BEGIN TRY
        DECLARE @maxMaVC NVARCHAR(50);
        DECLARE @newMaVC NVARCHAR(50);
        DECLARE @numPart INT;
        
        -- Lấy mã Voucher lớn nhất trong bảng Voucher, mã Voucher bắt đầu với 'VC'
        SELECT @maxMaVC = MAX(MaVC)
        FROM Voucher
        WHERE MaVC LIKE 'VC%';

        -- Nếu đã có mã Voucher, tăng số cuối của mã lên 1
        IF @maxMaVC IS NOT NULL
        BEGIN 
            SET @numPart = CAST(SUBSTRING(@maxMaVC, 3, LEN(@maxMaVC) - 2) AS INT) + 1;
        END
        ELSE
        BEGIN 
            SET @numPart = 1;  -- Nếu chưa có mã Voucher nào, bắt đầu từ 1
        END

        -- Tạo mã Voucher mới với định dạng 'VCxx' (2 chữ số)
        SET @newMaVC = 'VC' + RIGHT('00' + CAST(@numPart AS NVARCHAR), 2);

        -- Thực hiện chèn dữ liệu vào bảng Voucher với mã Voucher tự động
        INSERT INTO Voucher(MaVC, TenVC, GiaTriVC, SoLuotSuDungToiDa, SoLuotDaSuDung, NgayBatDau, NgayKetThuc, TrangThai)
        SELECT @newMaVC, TenVC, GiaTriVC, SoLuotSuDungToiDa, SoLuotDaSuDung, NgayBatDau, NgayKetThuc, TrangThai
        FROM inserted;

    END TRY
    BEGIN CATCH
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE();
        RAISERROR (@ErrorMessage, 16, 1);
    END CATCH
END;

GO

CREATE TRIGGER trg_TuDongTaoMaSP_SanPham
ON SanPham
INSTEAD OF INSERT
AS
BEGIN
    BEGIN TRY
        DECLARE @maxMaSP NVARCHAR(50);
        DECLARE @newMaSP NVARCHAR(50);
        DECLARE @numPart INT;
		 
        -- Lấy mã sản phẩm cao nhất hiện tại
        SELECT @maxMaSP = MAX(MaSP)
        FROM SanPham
        WHERE MaSP LIKE 'SP%';

        -- Tính toán phần số của mã sản phẩm mới
        IF @maxMaSP IS NOT NULL
        BEGIN
            SET @numPart = CAST(SUBSTRING(@maxMaSP, 3, LEN(@maxMaSP) - 2) AS INT) + 1;
        END
        ELSE
        BEGIN 
            SET @numPart = 1;
        END

        -- Tạo mã sản phẩm mới theo định dạng SPxx
        SET @newMaSP = 'SP' + RIGHT('00' + CAST(@numPart AS NVARCHAR), 2);
		 
        -- Thực hiện INSERT với mã sản phẩm mới
        INSERT INTO SanPham(MaSP, TenSP, GiaSP, AnhSP, MaLoaiSP, MoTaSP)
        SELECT @newMaSP, TenSP, GiaSP, AnhSP, MaLoaiSP, MoTaSP
        FROM inserted;

    END TRY
    BEGIN CATCH
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE();
        RAISERROR (@ErrorMessage, 16, 1);
    END CATCH
END;

GO

CREATE TRIGGER trg_TuDongTaoMaLoaiSP_LoaiSanPham
ON LoaiSanPham
INSTEAD OF INSERT
AS
BEGIN
    BEGIN TRY
        DECLARE @maxMaLoaiSP NVARCHAR(50);
        DECLARE @newMaLoaiSP NVARCHAR(50);
        DECLARE @numPart INT;

        -- Lấy mã loại sản phẩm cao nhất hiện tại
        SELECT @maxMaLoaiSP = MAX(MaLoaiSP)
        FROM LoaiSanPham
        WHERE MaLoaiSP LIKE 'LSP%';

        -- Tính toán phần số của mã loại sản phẩm mới
        IF @maxMaLoaiSP IS NOT NULL
        BEGIN
            SET @numPart = CAST(SUBSTRING(@maxMaLoaiSP, 4, LEN(@maxMaLoaiSP) - 3) AS INT) + 1;
        END
        ELSE
        BEGIN 
            SET @numPart = 1;
        END

        -- Tạo mã loại sản phẩm mới theo định dạng LSPxx
        SET @newMaLoaiSP = 'LSP' + RIGHT('00' + CAST(@numPart AS NVARCHAR), 2);

        -- Thực hiện INSERT với mã loại sản phẩm mới
        INSERT INTO LoaiSanPham(MaLoaiSP, TenLoaiSP, HinhLoaiSP)
        SELECT @newMaLoaiSP, TenLoaiSP, HinhLoaiSP
        FROM inserted;

    END TRY
    BEGIN CATCH
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE();
        RAISERROR (@ErrorMessage, 16, 1);
    END CATCH
END;

GO

CREATE TRIGGER trg_TuDongTaoMaKV_KhuVuc
ON KhuVuc
INSTEAD OF INSERT
AS
BEGIN
    BEGIN TRY
        DECLARE @maxMaKV NVARCHAR(50);
        DECLARE @newMaKV NVARCHAR(50);
        DECLARE @numPart INT;

        -- Lấy mã khu vực cao nhất hiện tại
        SELECT @maxMaKV = MAX(MaKV)
        FROM KhuVuc
        WHERE MaKV LIKE 'KV%';

        -- Tính toán phần số của mã khu vực mới
        IF @maxMaKV IS NOT NULL
        BEGIN
            SET @numPart = CAST(SUBSTRING(@maxMaKV, 3, LEN(@maxMaKV) - 2) AS INT) + 1;
        END
        ELSE
        BEGIN 
            SET @numPart = 1;
        END

        -- Tạo mã khu vực mới theo định dạng KVxx
        SET @newMaKV = 'KV' + RIGHT('00' + CAST(@numPart AS NVARCHAR), 2);

        -- Thực hiện INSERT với mã khu vực mới
        INSERT INTO KhuVuc(MaKV, TenKV, PhiVanChuyen)
        SELECT @newMaKV, TenKV, PhiVanChuyen
        FROM inserted;

    END TRY
    BEGIN CATCH
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE();
        RAISERROR (@ErrorMessage, 16, 1);
    END CATCH
END;

GO

CREATE TRIGGER trg_TuDongTaoMaNL_NguyenLieu
ON NguyenLieu
INSTEAD OF INSERT
AS
BEGIN
    BEGIN TRY
        DECLARE @maxMaNL NVARCHAR(50);
        DECLARE @newMaNL NVARCHAR(50);
        DECLARE @numPart INT;

        -- Lấy mã nguyên liệu cao nhất hiện tại
        SELECT @maxMaNL = MAX(MaNL)
        FROM NguyenLieu
        WHERE MaNL LIKE 'NL%';

        -- Tính toán phần số của mã nguyên liệu mới
        IF @maxMaNL IS NOT NULL
        BEGIN
            SET @numPart = CAST(SUBSTRING(@maxMaNL, 3, LEN(@maxMaNL) - 2) AS INT) + 1;
        END
        ELSE
        BEGIN 
            SET @numPart = 1;
        END

        -- Tạo mã nguyên liệu mới theo định dạng NLxx
        SET @newMaNL = 'NL' + RIGHT('00' + CAST(@numPart AS NVARCHAR), 2);

        -- Thực hiện INSERT với mã nguyên liệu mới
        INSERT INTO NguyenLieu(MaNL, TenNL, SoLuongTonKho, MaDV)
        SELECT @newMaNL, TenNL, SoLuongTonKho, MaDV
        FROM inserted;

    END TRY
    BEGIN CATCH
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE();
        RAISERROR (@ErrorMessage, 16, 1);
    END CATCH
END;

GO

CREATE TRIGGER trg_TuDongTaoMaDV_DonVi
ON DonVi
INSTEAD OF INSERT
AS
BEGIN
    BEGIN TRY
        DECLARE @maxMaDV NVARCHAR(50);
        DECLARE @newMaDV NVARCHAR(50);
        DECLARE @numPart INT;

        -- Lấy mã đơn vị cao nhất hiện tại
        SELECT @maxMaDV = MAX(MaDV)
        FROM DonVi
        WHERE MaDV LIKE 'DV%';

        -- Tính toán phần số của mã đơn vị mới
        IF @maxMaDV IS NOT NULL
        BEGIN
            SET @numPart = CAST(SUBSTRING(@maxMaDV, 3, LEN(@maxMaDV) - 2) AS INT) + 1;
        END
        ELSE
        BEGIN 
            SET @numPart = 1;
        END

        -- Tạo mã đơn vị mới theo định dạng DVxx
        SET @newMaDV = 'DV' + RIGHT('00' + CAST(@numPart AS NVARCHAR), 2);

        -- Thực hiện INSERT với mã đơn vị mới
        INSERT INTO DonVi(MaDV, TenDV)
        SELECT @newMaDV, TenDV
        FROM inserted;

    END TRY
    BEGIN CATCH
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE();
        RAISERROR (@ErrorMessage, 16, 1);
    END CATCH
END;

GO

CREATE TRIGGER trg_TuDongTaoMaND_NguoiDung
ON NguoiDung
INSTEAD OF INSERT
AS
BEGIN
    BEGIN TRY
        DECLARE @maxMaND NVARCHAR(50);
        DECLARE @newMaND NVARCHAR(50);
        DECLARE @numPart INT;

        -- Lấy mã người dùng cao nhất hiện tại
        SELECT @maxMaND = MAX(MaND)
        FROM NguoiDung
        WHERE MaND LIKE 'ND%';

        -- Tính toán phần số của mã người dùng mới
        IF @maxMaND IS NOT NULL
        BEGIN
            SET @numPart = CAST(SUBSTRING(@maxMaND, 3, LEN(@maxMaND) - 2) AS INT) + 1;
        END
        ELSE
        BEGIN 
            SET @numPart = 1;
        END

        -- Tạo mã người dùng mới theo định dạng NDxx
        SET @newMaND = 'ND' + RIGHT('00' + CAST(@numPart AS NVARCHAR), 2);

        -- Thực hiện INSERT với mã người dùng mới
        INSERT INTO NguoiDung(MaND, TenND, NamSinh, GioiTinh, SoDienThoai, Email, DiaChi, AnhND, VaiTro, TenDangNhap, MatKhau)
        SELECT @newMaND, TenND, NamSinh, GioiTinh, SoDienThoai, Email, DiaChi, AnhND, VaiTro, TenDangNhap, MatKhau
        FROM inserted;

    END TRY
    BEGIN CATCH
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE();
        RAISERROR (@ErrorMessage, 16, 1);
    END CATCH
END; 

GO

-- --------------------------------------------Func----------------------------------------------
CREATE FUNCTION [dbo].[FUNC_TaoMaDH]()
RETURNS NVARCHAR(50)
AS
BEGIN
    DECLARE @MaxNumber INT;

    SELECT @MaxNumber = ISNULL(MAX(CAST(SUBSTRING(MaDH, 3, LEN(MaDH) - 2) AS INT)), 0)
    FROM DonHang;
    SET @MaxNumber = @MaxNumber + 1;

    RETURN 'DH' + RIGHT('00' + CAST(@MaxNumber AS NVARCHAR(50)), 2);
END;

GO
CREATE FUNCTION [dbo].[FUNC_TaoMaND]()
RETURNS NVARCHAR(50)
AS
BEGIN
    DECLARE @MaxNumber INT;

    SELECT @MaxNumber = ISNULL(MAX(CAST(SUBSTRING(MaND, 3, LEN(MaND) - 2) AS INT)), 0)
    FROM NguoiDung;
    SET @MaxNumber = @MaxNumber + 1;

    RETURN 'ND' + RIGHT('00' + CAST(@MaxNumber AS NVARCHAR(50)), 2);
END;

GO

 



 
