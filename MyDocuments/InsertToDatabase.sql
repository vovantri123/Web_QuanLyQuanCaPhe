USE [WebBanCaPhe]
GO
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV], [PhiVanChuyen]) VALUES (N'KV01', N'Thành phố Thủ Đức', 20000)
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV], [PhiVanChuyen]) VALUES (N'KV02', N'Quận 1', 15000)
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV], [PhiVanChuyen]) VALUES (N'KV03', N'Quận 3', 14000)
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV], [PhiVanChuyen]) VALUES (N'KV04', N'Quận 4', 13000)
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV], [PhiVanChuyen]) VALUES (N'KV05', N'Quận 5', 13500)
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV], [PhiVanChuyen]) VALUES (N'KV06', N'Quận 6', 14000)
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV], [PhiVanChuyen]) VALUES (N'KV07', N'Quận 7', 16000)
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV], [PhiVanChuyen]) VALUES (N'KV08', N'Quận 8', 15000)
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV], [PhiVanChuyen]) VALUES (N'KV09', N'Quận 10', 13500)
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV], [PhiVanChuyen]) VALUES (N'KV10', N'Quận 11', 14000)
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV], [PhiVanChuyen]) VALUES (N'KV11', N'Quận 12', 17000)
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV], [PhiVanChuyen]) VALUES (N'KV12', N'Quận Tân Bình', 14500)
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV], [PhiVanChuyen]) VALUES (N'KV13', N'Quận Bình Tân', 15500)
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV], [PhiVanChuyen]) VALUES (N'KV14', N'Quận Bình Thạnh', 15000)
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV], [PhiVanChuyen]) VALUES (N'KV15', N'Quận Tân Phú', 16000)
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV], [PhiVanChuyen]) VALUES (N'KV16', N'Quận Gò Vấp', 15500)
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV], [PhiVanChuyen]) VALUES (N'KV17', N'Quận Phú Nhuận', 14500)
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV], [PhiVanChuyen]) VALUES (N'KV18', N'Huyện Bình Chánh', 18000)
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV], [PhiVanChuyen]) VALUES (N'KV19', N'Huyện Hóc Môn', 17500)
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV], [PhiVanChuyen]) VALUES (N'KV20', N'Huyện Cần Giờ', 20000)
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV], [PhiVanChuyen]) VALUES (N'KV21', N'Huyện Củ Chi', 18500)
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV], [PhiVanChuyen]) VALUES (N'KV22', N'Huyện Nhà Bè', 19000)
GO
INSERT [dbo].[Voucher] ([MaVC], [TenVC], [GiaTriVC], [SoLuotSuDungToiDa], [SoLuotDaSuDung], [NgayBatDau], [NgayKetThuc], [TrangThai]) VALUES (N'VC01', N'Giảm giá 10%', 10000, 100, 5, CAST(N'2024-12-01' AS Date), CAST(N'2024-12-31' AS Date), N'Còn hạn')
INSERT [dbo].[Voucher] ([MaVC], [TenVC], [GiaTriVC], [SoLuotSuDungToiDa], [SoLuotDaSuDung], [NgayBatDau], [NgayKetThuc], [TrangThai]) VALUES (N'VC02', N'Giảm giá 20%', 20000, 50, 10, CAST(N'2024-11-01' AS Date), CAST(N'2024-12-31' AS Date), N'Còn hạn')
INSERT [dbo].[Voucher] ([MaVC], [TenVC], [GiaTriVC], [SoLuotSuDungToiDa], [SoLuotDaSuDung], [NgayBatDau], [NgayKetThuc], [TrangThai]) VALUES (N'VC03', N'Giảm giá 15%', 15000, 30, 30, CAST(N'2024-11-01' AS Date), CAST(N'2024-10-15' AS Date), N'Hết lượt')
INSERT [dbo].[Voucher] ([MaVC], [TenVC], [GiaTriVC], [SoLuotSuDungToiDa], [SoLuotDaSuDung], [NgayBatDau], [NgayKetThuc], [TrangThai]) VALUES (N'VC04', N'Giảm giá 5%', 5000, 20, 0, CAST(N'2024-12-01' AS Date), CAST(N'2024-11-30' AS Date), N'Hết hạn')
INSERT [dbo].[Voucher] ([MaVC], [TenVC], [GiaTriVC], [SoLuotSuDungToiDa], [SoLuotDaSuDung], [NgayBatDau], [NgayKetThuc], [TrangThai]) VALUES (N'VC05', N'Giảm giá 25%', 25000, 10, 1, CAST(N'2024-11-15' AS Date), CAST(N'2024-12-20' AS Date), N'Còn hạn')
GO
INSERT [dbo].[DonHang] ([MaDH], [GiaTriDH], [NgayMua], [TrangThai], [MaKV], [MaVC]) VALUES (N'DH01', 30000, CAST(N'2024-11-01' AS Date), N'Đã giao', N'KV01', N'VC01')
INSERT [dbo].[DonHang] ([MaDH], [GiaTriDH], [NgayMua], [TrangThai], [MaKV], [MaVC]) VALUES (N'DH02', 15000, CAST(N'2024-11-02' AS Date), N'Đã giao', N'KV02', N'VC02')
INSERT [dbo].[DonHang] ([MaDH], [GiaTriDH], [NgayMua], [TrangThai], [MaKV], [MaVC]) VALUES (N'DH03', 45000, CAST(N'2024-11-03' AS Date), N'Đã giao', N'KV03', N'VC03')
INSERT [dbo].[DonHang] ([MaDH], [GiaTriDH], [NgayMua], [TrangThai], [MaKV], [MaVC]) VALUES (N'DH04', 60000, CAST(N'2024-11-04' AS Date), N'Đã giao', N'KV01', N'VC04')
INSERT [dbo].[DonHang] ([MaDH], [GiaTriDH], [NgayMua], [TrangThai], [MaKV], [MaVC]) VALUES (N'DH05', 40000, CAST(N'2024-11-05' AS Date), N'Đã hủy', N'KV02', N'VC05')
GO
INSERT [dbo].[LoaiSanPham] ([MaLoaiSP], [TenLoaiSP], [HinhLoaiSP]) VALUES (N'LSP01', N'Cà phê', N'caphedenda.jpg')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSP], [TenLoaiSP], [HinhLoaiSP]) VALUES (N'LSP02', N'Trà', N'travai.jpg')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSP], [TenLoaiSP], [HinhLoaiSP]) VALUES (N'LSP03', N'Sinh tố', N'sinhtobo.jpg')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSP], [TenLoaiSP], [HinhLoaiSP]) VALUES (N'LSP04', N'Kem', N'kemsocola.jpg')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSP], [TenLoaiSP], [HinhLoaiSP]) VALUES (N'LSP05', N'Bánh kem', N'banhkemdau.jpg')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSP], [TenLoaiSP], [HinhLoaiSP]) VALUES (N'LSP06', N'Bánh', N'tiramisu.jpg')
GO
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP01', N'Cà phê đen đá', 20000, N'caphedenda.jpg', N'LSP01', N'<p>
	<span style="box-sizing: border-box; font-weight: bolder; color: rgb(63, 63, 63); font-family: &quot;Roboto Condensed&quot;, sans-serif; font-size: 16px;">Mi&ecirc;u tả 5 hương vị đạt chuẩn của c&agrave; ph&ecirc;, giải đ&aacute;p cafe ngon c&oacute; bao nhi&ecirc;u vị.</span><span style="color: rgb(63, 63, 63); font-family: &quot;Roboto Condensed&quot;, sans-serif; font-size: 16px;">&nbsp;Thế giới c&agrave; ph&ecirc; kh&ocirc;ng chỉ dừng lại ở việc pha phin truyền thống hay thưởng thức Cappuccino v&agrave; Latte tại c&aacute;c qu&aacute;n cafe. Đằng sau cốc c&agrave; ph&ecirc; đơn giản ấy l&agrave; một thế giới phong ph&uacute; với h&agrave;ng trăm loại hương vị v&agrave; hậu vị độc đ&aacute;o. Trong b&agrave;i viết n&agrave;y, ch&uacute;ng ta sẽ kh&aacute;m ph&aacute; v&agrave; đ&aacute;nh gi&aacute; 5 hương vị c&agrave; ph&ecirc; th&uacute; vị. Để từ đ&oacute; t&igrave;m ra hương vị ngon chuẩn của cafe.</span></p>
')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP02', N'Cà phê sữa đá', 25000, N'caphesuada.jpg', N'LSP01', N'<h1 class="title-detail" style="margin: 0px 0px 15px; padding: 0px; box-sizing: border-box; text-rendering: optimizelegibility; line-height: 48px; font-size: 32px; font-feature-settings: &quot;pnum&quot;, &quot;lnum&quot;; font-family: Merriweather, serif; background-color: rgb(252, 250, 246);">
	C&aacute;ch nhận ra một ly c&agrave; ph&ecirc; ngon</h1>
<p class="description" style="margin: 0px 0px 15px; padding: 0px; box-sizing: border-box; text-rendering: optimizelegibility; font-size: 18px; line-height: 28.8px; font-family: arial; background-color: rgb(252, 250, 246);">
	Một ly c&agrave; ph&ecirc; thật l&agrave; khi ta chế nước s&ocirc;i v&agrave;o phin c&agrave; ph&ecirc;, những hạt c&agrave; ph&ecirc; đầu ti&ecirc;n thường cho m&agrave;u đậm, sau đ&oacute; những giọt sau sẽ nhạt dần. Một ly c&agrave; ph&ecirc; ngon sẽ c&oacute; vị thanh thanh khi uống v&agrave; cảm gi&aacute;c t&ecirc; t&ecirc; c&aacute;i lưỡi.<br style="margin: 0px; padding: 0px; box-sizing: border-box; text-rendering: optimizelegibility;" />
	&gt;&nbsp;<a href="https://vnexpress.net/tin-tuc/ban-doc-viet/cach-phan-biet-ca-phe-that-va-hoa-chat-bap-rang-2413885.html" rel="1002310527" style="margin: 0px; padding: 0px; box-sizing: border-box; text-rendering: optimizelegibility; color: rgb(7, 109, 182); text-underline-position: under;">C&aacute;ch ph&acirc;n biệt c&agrave; ph&ecirc; thật v&agrave; h&oacute;a chất, bắp rang</a></p>
<article class="fck_detail " style="margin: 0px; padding: 0px; box-sizing: border-box; text-rendering: optimizelegibility; width: 680px; float: left; position: relative; font-variant-numeric: normal; font-variant-east-asian: normal; font-variant-alternates: normal; font-size-adjust: none; font-kerning: auto; font-optical-sizing: auto; font-feature-settings: normal; font-variation-settings: normal; font-variant-position: normal; font-variant-emoji: normal; font-stretch: normal; font-size: 18px; line-height: 28.8px; font-family: arial; background-color: rgb(252, 250, 246);">
	<p class="Normal" style="margin: 0px 0px 1em; padding: 0px; box-sizing: border-box; text-rendering: optimizespeed; line-height: 28.8px;">
		<strong style="margin: 0px; padding: 0px; box-sizing: border-box; text-rendering: optimizelegibility;">Tại sao ch&uacute;ng ta phải uống c&agrave; ph&ecirc; h&oacute;a chất?</strong></p>
	<p class="Normal" style="margin: 0px 0px 1em; padding: 0px; box-sizing: border-box; text-rendering: optimizespeed; line-height: 28.8px;">
		Mặc d&ugrave; t&ocirc;i kh&ocirc;ng phải l&agrave; một t&iacute;n đồ c&agrave; ph&ecirc;, nhưng thời gian gần đ&acirc;y t&ocirc;i cũng đ&atilde; bắt đầu uống c&agrave; ph&ecirc;. V&igrave; khắp nơi, ở đ&acirc;u t&ocirc;i cũng thấy quảng c&aacute;o về c&agrave; ph&ecirc; sạch. c&agrave; ph&ecirc; kh&ocirc;ng h&oacute;a chất, v&agrave; t&ocirc;i bắt đầu cuộc kh&aacute;m ph&aacute; của m&igrave;nh về c&agrave; ph&ecirc;.</p>
	<p class="Normal" style="margin: 0px 0px 1em; padding: 0px; box-sizing: border-box; text-rendering: optimizespeed; line-height: 28.8px;">
		T&ocirc;i đ&atilde; đi rất nhiều qu&aacute;n được giới thiệu l&agrave; c&agrave; ph&ecirc; sạch, kh&ocirc;ng h&oacute;a chất. Nhưng hương vị v&agrave; gi&aacute; cả ở những qu&aacute;n n&agrave;y đều kh&aacute;c nhau (trung b&igrave;nh chỉ từ 10 đến 12 ng&agrave;n đồng/ ly).</p>
	<p class="Normal" style="margin: 0px 0px 1em; padding: 0px; box-sizing: border-box; text-rendering: optimizespeed; line-height: 28.8px;">
		Một v&agrave;i qu&aacute;n giới thiệu l&agrave; c&agrave; ph&ecirc; sạch, nhưng t&ocirc;i vẫn chưa hiểu thế n&agrave;o l&agrave; sạch. Khi t&ocirc;i hỏi th&igrave; họ cũng giải th&iacute;ch với t&ocirc;i l&agrave; c&agrave; ph&ecirc; nguy&ecirc;n chất, nhưng để c&agrave; ph&ecirc; ngon v&agrave; thơm th&igrave; cũng phải cho một v&agrave;i hương liệu.</p>
	<p class="Normal" style="margin: 0px 0px 1em; padding: 0px; box-sizing: border-box; text-rendering: optimizespeed; line-height: 28.8px;">
		T&ocirc;i lại t&igrave;m đến những nơi kh&aacute;c, cũng c&oacute; một số qu&aacute;n đ&atilde; giải th&iacute;ch rằng: Sạch ở đ&acirc;y l&agrave; khi rang họ kh&ocirc;ng cho bất kỳ hương liệu g&igrave; v&agrave;o, để c&oacute; thể giữ nguy&ecirc;n m&ugrave;i v&agrave; vị thật của c&agrave; ph&ecirc;. V&agrave; khi t&ocirc;i uống th&igrave; thấy đ&uacute;ng l&agrave; kh&aacute;c thật, c&aacute;i vị thanh thanh khi uống v&agrave; cảm gi&aacute;c t&ecirc; t&ecirc; c&aacute;i lưỡi đ&atilde; l&agrave;m t&ocirc;i thật sự phải ghiền thức uống n&agrave;y.</p>
	<p class="Normal" style="margin: 0px 0px 1em; padding: 0px; box-sizing: border-box; text-rendering: optimizespeed; line-height: 28.8px;">
		C&agrave; ph&ecirc; sạch th&igrave; gi&aacute; cũng kh&ocirc;ng mắc hơn c&agrave; ph&ecirc; tạp chất l&agrave; bao nhi&ecirc;u, nhưng quan trọng l&agrave; c&oacute; thể đảm bảo cho sức khỏe. Vậy th&igrave; tại sao ch&uacute;ng ta lại phải bỏ tiền ra để rồi phải uống những loại c&agrave; ph&ecirc; k&eacute;m chất lượng?</p>
	<p align="left" class="SubTitle" style="margin: 0px 0px 1em; padding: 0px; box-sizing: border-box; text-rendering: optimizespeed; line-height: 28.8px;">
		C&aacute;ch nhận ra một ly c&agrave; ph&ecirc; ngon:</p>
	<p class="Normal" style="margin: 0px 0px 1em; padding: 0px; box-sizing: border-box; text-rendering: optimizespeed; line-height: 28.8px;">
		<strong style="margin: 0px; padding: 0px; box-sizing: border-box; text-rendering: optimizelegibility;">T</strong>&ocirc;i muốn chia sẻ c&aacute;ch ph&acirc;n biệt một ly c&agrave; ph&ecirc; ngon v&agrave; một ly c&agrave; ph&ecirc; đểu. Trước ti&ecirc;n n&oacute;i về c&agrave; ph&ecirc; nguy&ecirc;n liệu; lấy một &iacute;t bột c&agrave; ph&ecirc; cho v&agrave;o l&ograve;ng b&agrave;n tay, chao qua chao lại ch&uacute;ng ta sẽ thấy c&oacute; những hạt &oacute;ng &aacute;nh m&agrave;u đen, đ&oacute; ch&iacute;nh l&agrave; những hạt caramen. Những hạt n&agrave;y ch&iacute;nh l&agrave; những hạt tạo m&agrave;u đen của ly c&agrave; ph&ecirc;. Hạt c&agrave;ng nhiều chất lượng c&agrave;ng giảm, tỷ lệ c&agrave; ph&ecirc; nguy&ecirc;n chất tỷ lệ nghịch với hạt caramen n&agrave;y.</p>
	<p class="Normal" style="margin: 0px 0px 1em; padding: 0px; box-sizing: border-box; text-rendering: optimizespeed; line-height: 28.8px;">
		N&oacute;i chung theo t&ocirc;i biết hiện nay c&agrave; ph&ecirc; b&aacute;n ở vỉa h&egrave; v&agrave; c&aacute;c qu&aacute;n th&igrave; tỷ lệ c&agrave; ph&ecirc; nguy&ecirc;n chất kh&ocirc;ng qu&aacute; 20%.</p>
	<p class="Normal" style="margin: 0px 0px 1em; padding: 0px; box-sizing: border-box; text-rendering: optimizespeed; line-height: 28.8px;">
		&nbsp;Một ly c&agrave; ph&ecirc; ngon l&agrave; khi ta chế nước s&ocirc;i v&agrave;o phin c&agrave; ph&ecirc;, những hạt c&agrave; ph&ecirc; đầu ti&ecirc;n thường cho m&agrave;u đậm, sau đ&oacute; những giọt sau sẽ nhạt dần. Ngược lại những ly c&agrave; ph&ecirc; chất lượng k&eacute;m thường cho những giọt sau c&agrave;ng l&uacute;c c&agrave;ng đen hơn v&igrave; l&uacute;c n&agrave;y c&aacute;c hạt tạo m&agrave;u, tức l&agrave; hạt caramen mới đủ thời gian tan ra.</p>
	<p class="Author" style="margin: 0px 0px 1em; padding: 0px; box-sizing: border-box; text-rendering: optimizespeed; line-height: 28.8px;">
		&nbsp;</p>
	<p class="Author" style="margin: 0px 0px 1em; padding: 0px; box-sizing: border-box; text-rendering: optimizespeed; line-height: 28.8px;">
		Nguyễn Sỹ H&ugrave;ng-Nguyễn Xu&acirc;n Tiến</p>
	<p class="Normal" style="margin: 0px 0px 1em; padding: 0px; box-sizing: border-box; text-rendering: optimizespeed; line-height: 28.8px;">
		<strong style="margin: 0px; padding: 0px; box-sizing: border-box; text-rendering: optimizelegibility;">Chia sẻ b&agrave;i viết quan điểm của bạn về c&agrave; ph&ecirc;&nbsp;</strong><a class="Normal" data-itm-added="1" data-itm-source="#vn_source=Detail-YKien_CongDong-2414324&amp;vn_campaign=Box-InternalLink&amp;vn_medium=Link-TaiDay&amp;vn_term=Desktop&amp;vn_thumb=0" href="https://vnexpress.net/contactus/?id=webmaster@vnexpress.net" style="margin: 0px 0px 1em; padding: 0px 0px 1px; box-sizing: border-box; text-rendering: optimizespeed; color: rgb(7, 109, 182); text-decoration-line: none; line-height: 28.8px; position: relative; text-underline-position: under; border-bottom-width: 1px; border-bottom-style: solid;"><strong style="margin: 0px; padding: 0px; box-sizing: border-box; text-rendering: optimizelegibility;">tại đ&acirc;y.</strong></a></p>
</article>
')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP03', N'Bạc xỉu', 25000, N'bacxiu.jpg', N'LSP01', N'Đồ uống có vị ngọt nhẹ, lớp sữa béo thơm hòa với cà phê nhạt tạo nên hương vị dịu dàng.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP04', N'Đường đen sữa đá', 30000, N'duongdensuada.jpg', N'LSP01', N'Hương vị ngọt ngào từ đường đen kết hợp cùng sữa tươi mát lạnh, thích hợp cho ngày hè.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP05', N'Latte đá', 35000, N'latteda.jpg', N'LSP01', N'Cà phê nhẹ nhàng với lớp sữa mịn, vị ngọt thanh, uống cùng đá càng thêm sảng khoái.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP06', N'Latte nóng', 35000, N'lattenong.jpg', N'LSP01', N'Sự kết hợp hoàn hảo giữa cà phê và sữa nóng, mang đến cảm giác ấm áp và dễ chịu.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP07', N'Cappuccino đá', 35000, N'cappuccinoda.jpg', N'LSP01', N'Vị đậm đà của cà phê, lớp sữa mịn và bọt béo hòa quyện, thêm đá lạnh sảng khoái.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP08', N'Cappuccino nóng', 35000, N'cappuccinonong.jpg', N'LSP01', N'Ly cà phê đậm hương với lớp bọt sữa béo ngậy, phù hợp cho buổi sáng đầy năng lượng.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP09', N'Trà đào', 30000, N'tradao.jpg', N'LSP02', N'Trá đào thơm ngon, kèm theo lát đào tươi mọng nước, mang lại cảm giác thư giãn.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP10', N'Trà đào cam sả', 40000, N'tradaocamsa.jpg', N'LSP02', N'Sự kết hợp hài hòa giữa vị ngọt của đào, vị chua nhẹ của cam và hương thơm thanh mát của sả.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP11', N'Trà vải', 30000, N'travai.jpg', N'LSP02', N'Trá vải tươi mát, ngọt dịu, đi kèm những miếng vải giòn ngọt.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP12', N'Trà sen', 30000, N'trasen.jpg', N'LSP02', N'Hương trà nhẹ nhàng, thanh tao, mang chút vị bùi bùi từ hạt sen.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP13', N'Sinh tố bơ', 35000, N'sinhtobo.jpg', N'LSP03', N'Sinh tố bơ béo ngậy, mịn màng, cung cấp năng lượng tuyệt vời cho cơ thể.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP14', N'Sinh tố dâu', 35000, N'sinhtodau.jpg', N'LSP03', N'Sinh tố dâu tươi mát với màu sắc bắt mắt và hương vị ngọt ngào.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP15', N'Sinh tố mãng cầu', 30000, N'sinhtomangcau.jpg', N'LSP03', N'Hương vị mãng cầu chua ngọt độc đáo, sinh tố mịn màng và tươi ngon.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP16', N'Sinh tố nho', 30000, N'sinhtonho.jpg', N'LSP03', N'Sinh tố nho thơm ngọt, đậm vị, giúp bổ sung năng lượng hiệu quả.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP17', N'Kem socola', 12000, N'kemsocola.jpg', N'LSP04', N'Kem socola đậm đà, tan chảy trong miệng với vị ngọt ngào khó cưỡng.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP18', N'Kem dâu', 12000, N'kemdau.jpg', N'LSP04', N'Kem dâu ngọt dịu với hương thơm đặc trưng, thích hợp cho mọi lứa tuổi.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP19', N'Kem matcha', 12000, N'kemmatcha.jpg', N'LSP04', N'Hương vị trà xanh matcha thơm lừng, hòa quyện cùng lớp kem mát lạnh.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP20', N'Kem cà phê', 12000, N'kemcaphe.jpg', N'LSP04', N'Kem cà phê thơm ngon, mang lại trải nghiệm mới lạ cho những tín đồ cà phê.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP21', N'Bánh kem cheese', 35000, N'banhkemcheese.jpg', N'LSP05', N'Bánh mềm mịn với lớp cheese béo ngậy, thích hợp làm món tráng miệng.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP22', N'Bánh kem dâu', 35000, N'banhkemdau.jpg', N'LSP05', N'Bánh với lớp kem tươi vị dâu thơm mát, phù hợp cho các buổi tiệc ngọt.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP23', N'Bánh kem socola', 35000, N'banhkemsocola.jpg', N'LSP05', N'Bánh kem socola thơm ngon với lớp phủ socola đậm đà.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP24', N'Bánh kem matcha', 35000, N'banhkemmatcha.jpg', N'LSP05', N'Hương vị matcha thanh mát, lớp kem béo ngậy, hòa quyện hoàn hảo.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP25', N'Bánh tiramisu', 38000, N'tiramisu.jpg', N'LSP06', N'Bánh tiramisu kiểu Ý, thơm lừng mùi cà phê và rượu rum, thích hợp cho người yêu ngọt ngào.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP26', N'Bánh chà bông phô mai', 27000, N'chabongphomai.jpg', N'LSP06', N'Bánh mặn với lớp chà bông và phô mai thơm lừng, thích hợp làm món ăn nhẹ.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP27', N'Bánh croissant', 22000, N'croissant.jpg', N'LSP06', N'Bánh croissant giòn rụm, lớp bơ thơm ngậy, mang phong cách Pháp.')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GiaSP], [AnhSP], [MaLoaiSP], [MoTaSP]) VALUES (N'SP28', N'Bánh chaud', 22000, N'chaud.jpg', N'LSP06', N'Bánh ngọt nhân bơ mềm mịn, hấp dẫn cho buổi chiều thư giãn.')
GO
INSERT [dbo].[ChiTietHoaDon] ([MaDH], [MaSP], [SoLuong], [TongTien]) VALUES (N'DH01', N'SP01', 2, 40000)
INSERT [dbo].[ChiTietHoaDon] ([MaDH], [MaSP], [SoLuong], [TongTien]) VALUES (N'DH02', N'SP02', 1, 25000)
INSERT [dbo].[ChiTietHoaDon] ([MaDH], [MaSP], [SoLuong], [TongTien]) VALUES (N'DH03', N'SP03', 3, 75000)
INSERT [dbo].[ChiTietHoaDon] ([MaDH], [MaSP], [SoLuong], [TongTien]) VALUES (N'DH04', N'SP04', 4, 120000)
INSERT [dbo].[ChiTietHoaDon] ([MaDH], [MaSP], [SoLuong], [TongTien]) VALUES (N'DH05', N'SP05', 2, 70000)
GO
INSERT [dbo].[NguoiDung] ([MaND], [TenND], [NamSinh], [GioiTinh], [SoDienThoai], [Email], [DiaChi], [AnhND], [VaiTro], [TenDangNhap], [MatKhau]) VALUES (N'ND01', N'Nguyen Van A', 1990, N'Nam', N'0912345678', N'a@gmail.com', N'Hồ Chí Minh', N'Avt1.jpg', N'Admin', N'nd1', N'123123')
INSERT [dbo].[NguoiDung] ([MaND], [TenND], [NamSinh], [GioiTinh], [SoDienThoai], [Email], [DiaChi], [AnhND], [VaiTro], [TenDangNhap], [MatKhau]) VALUES (N'ND02', N'Tran Thi B', 1992, N'Nữ', N'0987654321', N'vovantri2711@gmail.com', N'Hà Nội', N'Avt2.jpg', N'User', N'nd2', N'123123')
INSERT [dbo].[NguoiDung] ([MaND], [TenND], [NamSinh], [GioiTinh], [SoDienThoai], [Email], [DiaChi], [AnhND], [VaiTro], [TenDangNhap], [MatKhau]) VALUES (N'ND03', N'Le Van C', 1985, N'Nam', N'0911223344', N'c@gmail.com', N'Đà Nẵng', N'Avt3.jpg', N'User', N'nd3', N'123123')
INSERT [dbo].[NguoiDung] ([MaND], [TenND], [NamSinh], [GioiTinh], [SoDienThoai], [Email], [DiaChi], [AnhND], [VaiTro], [TenDangNhap], [MatKhau]) VALUES (N'ND04', N'Pham Thi D', 1993, N'Nữ', N'0977554433', N'd@gmail.com', N'Cần Thơ', N'Avt4.jpg', N'User', N'nd4', N'123123')
INSERT [dbo].[NguoiDung] ([MaND], [TenND], [NamSinh], [GioiTinh], [SoDienThoai], [Email], [DiaChi], [AnhND], [VaiTro], [TenDangNhap], [MatKhau]) VALUES (N'ND05', N'Hoang Van E', 1988, N'Nam', N'0966887766', N'e@gmail.com', N'Bình Dương', N'Avt5.jpg', N'User', N'nd5', N'123123')
INSERT [dbo].[NguoiDung] ([MaND], [TenND], [NamSinh], [GioiTinh], [SoDienThoai], [Email], [DiaChi], [AnhND], [VaiTro], [TenDangNhap], [MatKhau]) VALUES (N'ND06', N'Trí Văn', 0, N'', N'', N'vovantri204@gmail.com', N'', N'https://lh3.googleusercontent.com/a/ACg8ocKskVEG4GmqILsQjTxXjn374fArEJPDDEnVyj4B9kYnd60V5Qea=s96-c', N'User', N'', N'')
GO
INSERT [dbo].[PhuongThucThanhToan] ([MaPTTT], [TenPTTT]) VALUES (N'PT01', N'Tiền mặt')
INSERT [dbo].[PhuongThucThanhToan] ([MaPTTT], [TenPTTT]) VALUES (N'PT02', N'MoMo')
INSERT [dbo].[PhuongThucThanhToan] ([MaPTTT], [TenPTTT]) VALUES (N'PT03', N'ZaloPay')
INSERT [dbo].[PhuongThucThanhToan] ([MaPTTT], [TenPTTT]) VALUES (N'PT04', N'ShopeePay')
INSERT [dbo].[PhuongThucThanhToan] ([MaPTTT], [TenPTTT]) VALUES (N'PT05', N'Thẻ ngân hàng')
GO
INSERT [dbo].[ThanhToan] ([MaND], [MaDH], [MaPTTT]) VALUES (N'ND02', N'DH02', N'PT02')
INSERT [dbo].[ThanhToan] ([MaND], [MaDH], [MaPTTT]) VALUES (N'ND03', N'DH03', N'PT03')
INSERT [dbo].[ThanhToan] ([MaND], [MaDH], [MaPTTT]) VALUES (N'ND04', N'DH01', N'PT01')
INSERT [dbo].[ThanhToan] ([MaND], [MaDH], [MaPTTT]) VALUES (N'ND04', N'DH04', N'PT04')
INSERT [dbo].[ThanhToan] ([MaND], [MaDH], [MaPTTT]) VALUES (N'ND05', N'DH05', N'PT05')
GO
INSERT [dbo].[DonVi] ([MaDV], [TenDV]) VALUES (N'DV01', N'gam')
INSERT [dbo].[DonVi] ([MaDV], [TenDV]) VALUES (N'DV02', N'kg')
INSERT [dbo].[DonVi] ([MaDV], [TenDV]) VALUES (N'DV03', N'ml')
INSERT [dbo].[DonVi] ([MaDV], [TenDV]) VALUES (N'DV04', N'lít')
INSERT [dbo].[DonVi] ([MaDV], [TenDV]) VALUES (N'DV05', N'muỗng')
INSERT [dbo].[DonVi] ([MaDV], [TenDV]) VALUES (N'DV06', N'lon')
INSERT [dbo].[DonVi] ([MaDV], [TenDV]) VALUES (N'DV07', N'túi')
INSERT [dbo].[DonVi] ([MaDV], [TenDV]) VALUES (N'DV08', N'trái')
GO
INSERT [dbo].[NguyenLieu] ([MaNL], [TenNL], [SoLuongTonKho], [MaDV]) VALUES (N'NL01', N'Cà phê hạt', 100, N'DV01')
INSERT [dbo].[NguyenLieu] ([MaNL], [TenNL], [SoLuongTonKho], [MaDV]) VALUES (N'NL02', N'Đường', 50, N'DV01')
INSERT [dbo].[NguyenLieu] ([MaNL], [TenNL], [SoLuongTonKho], [MaDV]) VALUES (N'NL03', N'Sữa', 200, N'DV03')
INSERT [dbo].[NguyenLieu] ([MaNL], [TenNL], [SoLuongTonKho], [MaDV]) VALUES (N'NL04', N'Cam', 30, N'DV08')
INSERT [dbo].[NguyenLieu] ([MaNL], [TenNL], [SoLuongTonKho], [MaDV]) VALUES (N'NL05', N'Trà', 40, N'DV07')
GO
INSERT [dbo].[DanhGia] ([MaND], [MaSP], [SoSao], [NhanXet]) VALUES (N'ND02', N'SP02', 4, N'Chất lượng ổn')
INSERT [dbo].[DanhGia] ([MaND], [MaSP], [SoSao], [NhanXet]) VALUES (N'ND03', N'SP03', 3, N'Sản phẩm bình thường')
INSERT [dbo].[DanhGia] ([MaND], [MaSP], [SoSao], [NhanXet]) VALUES (N'ND04', N'SP04', 5, N'Rất hài lòng')
INSERT [dbo].[DanhGia] ([MaND], [MaSP], [SoSao], [NhanXet]) VALUES (N'ND05', N'SP05', 2, N'Không hài lòng')
GO
INSERT [dbo].[GioHang] ([MaND], [MaSP], [SoLuongMua]) VALUES (N'ND02', N'SP02', 1)
INSERT [dbo].[GioHang] ([MaND], [MaSP], [SoLuongMua]) VALUES (N'ND02', N'SP17', 5)
INSERT [dbo].[GioHang] ([MaND], [MaSP], [SoLuongMua]) VALUES (N'ND03', N'SP01', 2)
INSERT [dbo].[GioHang] ([MaND], [MaSP], [SoLuongMua]) VALUES (N'ND03', N'SP03', 3)
INSERT [dbo].[GioHang] ([MaND], [MaSP], [SoLuongMua]) VALUES (N'ND04', N'SP04', 4)
INSERT [dbo].[GioHang] ([MaND], [MaSP], [SoLuongMua]) VALUES (N'ND05', N'SP05', 2)
GO
INSERT [dbo].[Slide] ([MaSlide], [TenSlide], [AnhSlide], [ViTri], [TrangThai], [MaND]) VALUES (N'SL01', N'Slide 1', N'slide1.jpg', N'1', N'Hiển thị', N'ND01')
INSERT [dbo].[Slide] ([MaSlide], [TenSlide], [AnhSlide], [ViTri], [TrangThai], [MaND]) VALUES (N'SL02', N'Slide 2', N'slide2.jpg', N'2', N'Hiển thị', N'ND01')
INSERT [dbo].[Slide] ([MaSlide], [TenSlide], [AnhSlide], [ViTri], [TrangThai], [MaND]) VALUES (N'SL03', N'Slide 3', N'slide3.jpg', N'3', N'Ẩn', N'ND01')
INSERT [dbo].[Slide] ([MaSlide], [TenSlide], [AnhSlide], [ViTri], [TrangThai], [MaND]) VALUES (N'SL04', N'Slide 4', N'slide4.jpg', N'4', N'Hiển thị', N'ND01')
INSERT [dbo].[Slide] ([MaSlide], [TenSlide], [AnhSlide], [ViTri], [TrangThai], [MaND]) VALUES (N'SL05', N'Slide 5', N'slide5.jpg', N'5', N'Ẩn', N'ND01')
GO
INSERT [dbo].[PhaChe] ([MaSP], [MaNL], [SoLuong]) VALUES (N'SP01', N'NL01', 1)
INSERT [dbo].[PhaChe] ([MaSP], [MaNL], [SoLuong]) VALUES (N'SP02', N'NL02', 1)
INSERT [dbo].[PhaChe] ([MaSP], [MaNL], [SoLuong]) VALUES (N'SP03', N'NL03', 2)
INSERT [dbo].[PhaChe] ([MaSP], [MaNL], [SoLuong]) VALUES (N'SP04', N'NL04', 1)
INSERT [dbo].[PhaChe] ([MaSP], [MaNL], [SoLuong]) VALUES (N'SP05', N'NL05', 1)
GO
