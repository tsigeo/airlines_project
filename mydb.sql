-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Φιλοξενητής: 127.0.0.1
-- Χρόνος δημιουργίας: 08 Ιουν 2020 στις 14:17:21
-- Έκδοση διακομιστή: 10.4.11-MariaDB
-- Έκδοση PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `mydb`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `customers`
--

CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `address` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `customers`
--

INSERT INTO `customers` (`customer_id`, `firstname`, `lastname`, `email`, `address`) VALUES
(1, 'Giorgos', 'Tsichlakis', 'tsigeo26@outlook.com', 'Ath.Diakoy 7'),
(2, 'Dimitris', 'Papakostas', 'dpapa@gmail.com', 'Syrou 23'),
(3, 'Konstantinos', 'Brintakis', 'kwstasbrint@yahoo.gr', 'kanari 8'),
(4, 'Antigoni', 'Kiadi', 'a_kiad@hotmail.com', 'Pharon 19'),
(5, 'Giannis', 'Zacharias', 'john21z@gmail.com', 'Fygalleias 34'),
(6, 'Vasiliki', 'Antonopoyloy', 'vicky_ant@outlook.com', 'Platonos 5'),
(7, 'Nikolas', 'Vasilopoylos', 'nickvas10@hotmail.com', 'Kypriadoy 9'),
(8, 'Anna', 'Anastasopoyloy', 'annouuu99@gmail.com', 'Charilaoy Trikoypi 81'),
(9, 'Periklis', 'Panagiotidis', 'periklis_pana7@hotmail.com', 'Pheidioy 6'),
(10, 'Olympia', 'Georgioy', 'oly_g89@hotmail.com', 'Parnithas 15');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `exchange_rates`
--

CREATE TABLE `exchange_rates` (
  `from_currency` varchar(16) DEFAULT NULL,
  `to_currency` varchar(16) DEFAULT NULL,
  `exchange_rate_id` int(11) NOT NULL,
  `rate` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `exchange_rates`
--

INSERT INTO `exchange_rates` (`from_currency`, `to_currency`, `exchange_rate_id`, `rate`) VALUES
('KWD', 'AMD', 0, 8.82281),
('MYR', 'KES', 1, 4.40414),
('MRO', 'TTD', 2, 6.01342),
('SVC', 'LSL', 3, 2.06414),
('AFN', 'AUD', 4, 8.04241),
('CUP', 'VUV', 5, 6.18705),
('ZMW', 'KRW', 6, 7.68423),
('KZT', 'BGN', 7, 2.43053),
('COP', 'IDR', 8, 4.952),
('KRW', 'AOA', 9, 1.28267),
('ZAR', 'COP', 10, 8.3774),
('TND', 'BGN', 11, 4.43399),
('BOB', 'BRL', 12, 6.91459),
('ETB', 'SRD', 13, 3.09944),
('GMD', 'MGA', 14, 2.49487),
('MWK', 'PYG', 15, 3.99918),
('ETB', 'DJF', 16, 7.54831),
('RWF', 'GNF', 17, 9.23553),
('TRY', 'BRL', 18, 2.92369),
('NAD', 'CUP', 19, 7.70281);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `fax_numbers`
--

CREATE TABLE `fax_numbers` (
  `fax_number_id` int(11) NOT NULL,
  `country_code` varchar(45) DEFAULT NULL,
  `area_code` varchar(45) DEFAULT NULL,
  `number` varchar(45) DEFAULT NULL,
  `customer_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `flights`
--

CREATE TABLE `flights` (
  `flight_id` int(11) NOT NULL,
  `flight_number` varchar(255) NOT NULL,
  `company_id` varchar(255) NOT NULL,
  `has_smoking` int(11) DEFAULT NULL,
  `num_business_class` int(11) DEFAULT NULL,
  `num_business_reserved` int(11) DEFAULT NULL,
  `num_economy` int(11) DEFAULT NULL,
  `num_economy_reserved` int(11) DEFAULT NULL,
  `from_airport` varchar(45) DEFAULT NULL,
  `to_airport` varchar(45) DEFAULT NULL,
  `departure_time` timestamp NULL DEFAULT NULL,
  `flight_duration` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `flights`
--

INSERT INTO `flights` (`flight_id`, `flight_number`, `company_id`, `has_smoking`, `num_business_class`, `num_business_reserved`, `num_economy`, `num_economy_reserved`, `from_airport`, `to_airport`, `departure_time`, `flight_duration`) VALUES
(1, '5461', 'Aircan', 0, 35, 33, 120, 99, 'NY', 'Berlin', '2020-04-01 09:00:00', 500),
(2, '22736', 'USAir', 0, 40, 39, 80, 80, 'YYZ', 'CHI', '2020-04-02 23:00:00', 200),
(3, '27799', 'BritAir', 1, 50, 48, 180, 169, 'AirFrance', 'ROME', '2020-04-21 13:00:00', 140),
(5, '27346', 'LuftAir', 0, 25, 25, 60, 60, 'London', 'JFK', '2020-04-28 05:00:00', 160),
(6, '19540', 'ItalAir', 1, 20, 0, 60, 37, 'Paris', 'YYZ', '2020-05-01 21:30:00', 200),
(7, '1092', 'AirCan', 1, 60, 60, 200, 200, 'London', 'CHI', '2020-05-12 14:00:00', 180),
(8, '9203', 'USAir', 0, 40, 40, 100, 100, 'Berlin', 'Edinburgh', '2020-05-25 13:00:00', 600),
(9, '12610', 'BritAir', 0, 30, 4, 70, 29, 'Berlin', 'Edinburgh', '2020-06-01 16:00:01', 180),
(10, '5803', 'AirFrance', 0, 20, 20, 60, 60, 'Naples', 'Berlin', '2020-06-04 20:00:00', 120),
(11, '16619', 'LuftAir', 0, 80, 49, 160, 152, 'YYZ', 'JFK', '2020-06-05 12:00:00', 300);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `phone_numbers`
--

CREATE TABLE `phone_numbers` (
  `phone_number_id` int(11) NOT NULL,
  `country_code` varchar(45) DEFAULT NULL,
  `area_code` varchar(45) DEFAULT NULL,
  `number` varchar(45) DEFAULT NULL,
  `customer_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `reservations`
--

CREATE TABLE `reservations` (
  `reservation_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `flight_id` int(11) NOT NULL,
  `reservation_type` varchar(45) DEFAULT NULL,
  `reservation_city` varchar(45) DEFAULT NULL,
  `reservation_status` int(11) DEFAULT NULL,
  `prepayment` float DEFAULT NULL,
  `price_total` float DEFAULT NULL,
  `price_flight` float DEFAULT NULL,
  `currency` varchar(16) DEFAULT NULL,
  `departure_time` timestamp NULL DEFAULT NULL,
  `arrival_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `reservations`
--

INSERT INTO `reservations` (`reservation_id`, `customer_id`, `flight_id`, `reservation_type`, `reservation_city`, `reservation_status`, `prepayment`, `price_total`, `price_flight`, `currency`, `departure_time`, `arrival_time`) VALUES
(1, 1, 3, '1', 'Paris', 0, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`customer_id`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`);

--
-- Ευρετήρια για πίνακα `exchange_rates`
--
ALTER TABLE `exchange_rates`
  ADD PRIMARY KEY (`exchange_rate_id`);

--
-- Ευρετήρια για πίνακα `fax_numbers`
--
ALTER TABLE `fax_numbers`
  ADD PRIMARY KEY (`fax_number_id`),
  ADD KEY `fk_phone_numbers_customers1_idx` (`customer_id`);

--
-- Ευρετήρια για πίνακα `flights`
--
ALTER TABLE `flights`
  ADD PRIMARY KEY (`flight_id`);

--
-- Ευρετήρια για πίνακα `phone_numbers`
--
ALTER TABLE `phone_numbers`
  ADD PRIMARY KEY (`phone_number_id`),
  ADD KEY `fk_phone_numbers_customers1_idx` (`customer_id`);

--
-- Ευρετήρια για πίνακα `reservations`
--
ALTER TABLE `reservations`
  ADD PRIMARY KEY (`reservation_id`),
  ADD KEY `fk_reservations_customers1_idx` (`customer_id`),
  ADD KEY `fk_reservations_flight1_idx` (`flight_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
