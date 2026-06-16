-- Indonesia Locations Database
-- Struktur lengkap: Provinsi, Kabupaten/Kota, Kecamatan, Desa dengan Latitude/Longitude

CREATE TABLE IF NOT EXISTS locations (
    id TEXT PRIMARY KEY,
    provinsi TEXT NOT NULL,
    kabupaten TEXT NOT NULL,
    kecamatan TEXT NOT NULL,
    desa TEXT NOT NULL,
    latitude REAL NOT NULL,
    longitude REAL NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_provinsi ON locations(provinsi);
CREATE INDEX idx_kabupaten ON locations(kabupaten);
CREATE INDEX idx_kecamatan ON locations(kecamatan);

-- Sample Data - Jakarta
INSERT INTO locations VALUES
('ID-DKI-001', 'DKI Jakarta', 'Jakarta Pusat', 'Menteng', 'Kebon Sirih', -6.1945, 106.8240),
('ID-DKI-002', 'DKI Jakarta', 'Jakarta Pusat', 'Menteng', 'Cikini', -6.1900, 106.8280),
('ID-DKI-003', 'DKI Jakarta', 'Jakarta Pusat', 'Tanah Abang', 'Petojo Utara', -6.2045, 106.8140),
('ID-DKI-004', 'DKI Jakarta', 'Jakarta Selatan', 'Tebet', 'Menteng Atas', -6.2350, 106.8350),
('ID-DKI-005', 'DKI Jakarta', 'Jakarta Selatan', 'Cilandak', 'Cilandak Timur', -6.2750, 106.7950),
('ID-DKI-006', 'DKI Jakarta', 'Jakarta Barat', 'Kebon Jeruk', 'Kebon Jeruk', -6.2150, 106.7640),
('ID-DKI-007', 'DKI Jakarta', 'Jakarta Utara', 'Penjaringan', 'Penjaringan', -6.1150, 106.8750),
('ID-DKI-008', 'DKI Jakarta', 'Jakarta Timur', 'Kramat Jati', 'Dukuh', -6.2650, 106.9150),

-- Jawa Barat
('ID-JBR-001', 'Jawa Barat', 'Bandung', 'Bandung', 'Babakan Ciamis', -6.9147, 107.6061),
('ID-JBR-002', 'Jawa Barat', 'Bandung', 'Bandung', 'Cibeunying Kaler', -6.8920, 107.6150),
('ID-JBR-003', 'Jawa Barat', 'Bandung', 'Cidadap', 'Cidadap', -6.8750, 107.5950),
('ID-JBR-004', 'Jawa Barat', 'Bekasi', 'Bekasi', 'Margajaya', -6.2050, 107.0100),
('ID-JBR-005', 'Jawa Barat', 'Bekasi', 'Medan Satria', 'Medan Satria', -6.1750, 107.0350),
('ID-JBR-006', 'Jawa Barat', 'Bogor', 'Bogor', 'Cibuluh', -6.5950, 106.8050),
('ID-JBR-007', 'Jawa Barat', 'Cirebon', 'Sumber', 'Sumber', -6.7050, 108.4750),
('ID-JBR-008', 'Jawa Barat', 'Depok', 'Depok', 'Grogol', -6.3950, 106.8350),

-- Jawa Tengah
('ID-JTG-001', 'Jawa Tengah', 'Semarang', 'Semarang', 'Banyumanik', -7.0450, 110.4250),
('ID-JTG-002', 'Jawa Tengah', 'Semarang', 'Semarang', 'Gajahmungkur', -7.0050, 110.4150),
('ID-JTG-003', 'Jawa Tengah', 'Surakarta', 'Surakarta', 'Laweyan', -7.5550, 110.8050),
('ID-JTG-004', 'Jawa Tengah', 'Yogyakarta', 'Yogyakarta', 'Kraton', -7.7950, 110.3950),
('ID-JTG-005', 'Jawa Tengah', 'Magelang', 'Magelang', 'Magelang', -7.4750, 110.2150),
('ID-JTG-006', 'Jawa Tengah', 'Purwokerto', 'Purwokerto', 'Purwokerto', -7.4250, 109.2350),
('ID-JTG-007', 'Jawa Tengah', 'Pekalongan', 'Pekalongan', 'Pekalongan', -6.8950, 109.6750),
('ID-JTG-008', 'Jawa Tengah', 'Kudus', 'Kudus', 'Kudus', -6.9050, 110.8050),

-- Jawa Timur
('ID-JTM-001', 'Jawa Timur', 'Surabaya', 'Surabaya', 'Tegalsari', -7.2250, 112.7450),
('ID-JTM-002', 'Jawa Timur', 'Surabaya', 'Surabaya', 'Tandes', -7.2050, 112.7150),
('ID-JTM-003', 'Jawa Timur', 'Malang', 'Malang', 'Kepanjen', -8.2350, 112.7150),
('ID-JTM-004', 'Jawa Timur', 'Pasuruan', 'Pasuruan', 'Pasuruan', -7.6450, 112.9050),
('ID-JTM-005', 'Jawa Timur', 'Sidoarjo', 'Sidoarjo', 'Sidoarjo', -7.4450, 112.7150),
('ID-JTM-006', 'Jawa Timur', 'Gresik', 'Gresik', 'Gresik', -7.1650, 112.6650),
('ID-JTM-007', 'Jawa Timur', 'Jombang', 'Jombang', 'Jombang', -7.5050, 112.2350),
('ID-JTM-008', 'Jawa Timur', 'Kediri', 'Kediri', 'Kediri', -7.2150, 111.9750),

-- Sumatera Utara
('ID-SUM-001', 'Sumatera Utara', 'Medan', 'Medan', 'Medan Baru', 3.1950, 98.6750),
('ID-SUM-002', 'Sumatera Utara', 'Medan', 'Medan', 'Medan Petisah', 3.1850, 98.6550),
('ID-SUM-003', 'Sumatera Utara', 'Deli Serdang', 'Deli Serdang', 'Batu Bara', 2.9950, 98.6450),
('ID-SUM-004', 'Sumatera Utara', 'Pematangsiantar', 'Pematangsiantar', 'Pematangsiantar', 2.9750, 99.0550),
('ID-SUM-005', 'Sumatera Utara', 'Karo', 'Berastagi', 'Berastagi', 3.1950, 98.5650),
('ID-SUM-006', 'Sumatera Utara', 'Labuhan Batu', 'Aek Kota', 'Aek Kota', 3.2950, 100.5050),
('ID-SUM-007', 'Sumatera Utara', 'Tapanuli', 'Padangsidempuan', 'Padangsidempuan', 1.3950, 99.2750),
('ID-SUM-008', 'Sumatera Utara', 'Asahan', 'Kisaran', 'Kisaran', 2.6750, 99.6050),

-- Bali
('ID-BAL-001', 'Bali', 'Badung', 'Denpasar', 'Denpasar', -8.6500, 115.2170),
('ID-BAL-002', 'Bali', 'Badung', 'Kuta', 'Kuta', -8.7170, 115.1690),
('ID-BAL-003', 'Bali', 'Gianyar', 'Ubud', 'Ubud', -8.5050, 115.2620),
('ID-BAL-004', 'Bali', 'Klungkung', 'Klungkung', 'Klungkung', -8.4950, 115.3950),
('ID-BAL-005', 'Bali', 'Tabanan', 'Tabanan', 'Tabanan', -8.5250, 115.1150),
('ID-BAL-006', 'Bali', 'Bangli', 'Bangli', 'Bangli', -8.2850, 115.3550),
('ID-BAL-007', 'Bali', 'Buleleng', 'Singaraja', 'Singaraja', -8.1150, 115.0850),
('ID-BAL-008', 'Bali', 'Jembrana', 'Negara', 'Negara', -8.3750, 114.6150);
