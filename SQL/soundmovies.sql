-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.5.10-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping structure for table soundmovies.movies
CREATE TABLE IF NOT EXISTS `movies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `releaseYear` int(11) NOT NULL,
  `productionId` varchar(20) NOT NULL,
  `updateDateTime` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `createDateTime` datetime NOT NULL DEFAULT current_timestamp(),
  `image_data` mediumblob DEFAULT NULL,
  `link` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `productionId_fkey` (`productionId`),
  CONSTRAINT `productionId_fkey` FOREIGN KEY (`productionId`) REFERENCES `production` (`productionId`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=latin1;

-- Dumping data for table soundmovies.movies: ~61 rows (approximately)
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` (`id`, `title`, `releaseYear`, `productionId`, `updateDateTime`, `createDateTime`, `image_data`, `link`) VALUES
	(1, 'The Hunt', 2017, 'Short', '2023-12-01 22:38:58', '2023-11-13 13:43:56', NULL, 'https://www.youtube.com/watch?v=S-aTJ1hSqck'),
	(2, 'A Night Out', 2017, 'Short', '2023-12-01 22:37:48', '2023-11-13 13:43:56', NULL, 'https://www.youtube.com/watch?v=aUTReDjvQBM'),
	(3, 'The Diner', 2017, 'Short', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(4, 'Mountain Side', 2018, 'Short', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(5, 'Delivery', 2019, 'Short', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(6, 'Avaline', 2019, 'Short', '2023-12-01 22:39:17', '2023-11-13 13:43:56', NULL, 'https://www.youtube.com/watch?v=l_9AboOulVg'),
	(7, 'Lazuli', 2019, 'Short', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(8, 'Baking', 2019, 'Short', '2023-12-04 11:47:05', '2023-11-13 13:43:56', NULL, 'https://www.youtube.com/watch?v=p4YGh74ax0M'),
	(9, 'Maria and Her Dog', 2019, 'Short', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(10, 'Beta Bros', 2019, 'Short', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(11, 'Chemiclas Between Us', 2020, 'Short', '2023-12-03 23:15:39', '2023-11-13 13:43:56', NULL, 'https://youtu.be/_Bd_onrDI3A'),
	(12, 'The Daily', 2020, 'Concept', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(13, 'The Yankee', 2020, 'Short', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(14, 'At Jabok', 2020, 'Short', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(15, 'Master Sun', 2020, 'Short', '2023-12-04 13:09:51', '2023-11-13 13:43:56', NULL, 'https://youtu.be/d3JbmRjokyo'),
	(16, 'Fathers Day', 2020, 'Short', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(17, 'Hidden Letters', 2020, 'Short', '2023-12-04 11:56:41', '2023-11-13 13:43:56', NULL, 'https://www.youtube.com/watch?v=AchA95D7wLQ'),
	(18, 'Born User', 2020, 'Short', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(19, 'Swipe Right', 2020, 'Short', '2023-12-04 11:55:59', '2023-11-13 13:43:56', NULL, 'https://youtu.be/brF864rr6Sg'),
	(20, 'Crain Team XMAS', 2020, 'Corporate', '2023-12-01 22:35:52', '2023-11-13 13:43:56', NULL, 'https://www.youtube.com/watch?v=89j1VifdVgA&list=PLd3WWjAta1f--1Wg0EPz7SaVmrWXNQP02&index=3'),
	(21, 'Llego Hoy', 2023, 'Feature', '2023-11-24 22:02:12', '2023-11-13 13:43:56', NULL, NULL),
	(22, 'Crain Team Got Em Browsin', 2021, 'Corporate', '2023-12-01 22:36:05', '2023-11-13 13:43:56', NULL, 'https://www.youtube.com/watch?v=edwhlCHY64k&list=PLd3WWjAta1f--1Wg0EPz7SaVmrWXNQP02&index=4'),
	(23, 'Crypsis', 2021, 'Short', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(24, 'Among The Grain', 2021, 'Short', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(25, 'Moth', 2021, 'Short', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(26, 'The Light Outside', 2021, 'Short', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(27, 'Crain Team RV', 2021, 'Corporate', '2023-12-01 22:48:06', '2023-11-13 13:43:56', NULL, 'https://www.youtube.com/watch?v=taocU--VFfs&list=PLd3WWjAta1f--1Wg0EPz7SaVmrWXNQP02&index=5'),
	(28, 'Avidity', 2021, 'Short', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(29, 'Good Gorgeous Hell', 2021, 'Short', '2023-12-01 23:02:18', '2023-11-13 13:43:56', NULL, 'https://vimeo.com/875664362'),
	(30, 'Everything Holy', 2021, 'Short', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(31, 'Predition Falls', 2021, 'Short', '2023-12-01 22:23:09', '2023-11-13 13:43:56', NULL, 'https://madebyprisma.wistia.com/medias/g63dwhattc'),
	(32, 'Mae', 2022, 'Short', '2023-12-04 14:57:42', '2023-11-13 13:43:56', NULL, 'https://www.youtube.com/watch?v=g1sxqKcrRoo&list=PLd3WWjAta1f--1Wg0EPz7SaVmrWXNQP02&index=6'),
	(33, 'Garver Videos', 2021, 'Corporate', '2023-12-01 22:36:47', '2023-11-13 13:43:56', NULL, 'https://www.youtube.com/watch?v=jLUKZb1Vffs'),
	(34, 'Cossatot', 2022, 'Short', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(35, 'Pursuit', 2022, 'Feature', '2023-12-01 00:03:52', '2023-11-13 13:43:56', NULL, 'https://tubitv.com/movies/672479/pursuit'),
	(36, 'True Morels', 2022, 'Short', '2023-12-04 11:47:44', '2023-11-13 13:43:56', NULL, 'https://www.youtube.com/watch?v=K0q1U5hvjlc'),
	(37, 'Leo', 2022, 'Short', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(38, 'The Invisible Pilot', 2022, 'Documentary', '2023-12-01 22:34:35', '2023-11-13 13:43:56', NULL, 'https://www.hbo.com/the-invisible-pilot'),
	(39, 'PBS Daisy Bates', 2022, 'Documentary', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(40, 'Through Elijahs Eyes', 2022, 'Short', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(41, 'I Want That Job!', 2022, 'Corporate', '2023-12-01 22:33:57', '2023-11-13 13:43:56', NULL, 'https://www.youtube.com/watch?v=eN8w22B-GZU&list=PLd3WWjAta1f--1Wg0EPz7SaVmrWXNQP02&index=7'),
	(42, 'Four Besties', 2022, 'Short', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(43, 'The Queens Stake', 2022, 'Commercial', '2023-12-01 22:33:54', '2023-11-13 13:43:56', NULL, 'https://www.youtube.com/watch?v=jXE14SVu_C8&list=PLd3WWjAta1f--1Wg0EPz7SaVmrWXNQP02&index=8'),
	(44, 'UpSummit', 2022, 'Documentary', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(45, 'HGTV and DISH Network', 2022, 'Commercial', '2023-12-04 15:42:13', '2023-11-13 13:43:56', NULL, 'https://www.youtube.com/watch?v=YC3bGJFLUQA'),
	(46, 'The Book Club', 2022, 'Short', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(47, 'Monster Map', 2022, 'Concept', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(48, 'SEC ESPN Fayetteville AR', 2022, 'ENG', '2023-12-01 22:33:28', '2023-11-13 13:43:56', NULL, 'https://www.youtube.com/watch?v=8H1iLa3qdH4&list=PLd3WWjAta1f--1Wg0EPz7SaVmrWXNQP02&index=9'),
	(49, 'The Intimidation Game', 2022, 'Concept', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(50, 'The Watchman', 2022, 'Commercial', '2023-12-01 22:32:22', '2023-11-13 13:43:56', NULL, 'https://www.youtube.com/watch?v=tmys3I_NhPw&list=PLd3WWjAta1f--1Wg0EPz7SaVmrWXNQP02&index=10'),
	(51, 'Rebound', 2022, 'Short', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(52, 'Wonderland Cave', 2022, 'Concept', '2023-12-01 22:32:06', '2023-11-13 13:43:56', NULL, 'https://www.youtube.com/watch?v=xMbqwHlYEuI'),
	(53, 'Neema Namadamu', 2022, 'Documentary', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(54, 'Sams Club Thank Savings Sales Event', 2022, 'Commercial', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(55, 'Clinton Anderson Uncut and Real Raw', 2023, 'Podcast', '2023-12-04 14:49:50', '2023-11-13 13:43:56', NULL, 'https://www.youtube.com/watch?v=7jMJ7q8giEs&list=PLd3WWjAta1f--1Wg0EPz7SaVmrWXNQP02&index=11'),
	(56, 'If Only', 2023, 'Short', '2023-12-04 18:00:49', '2023-11-13 13:43:56', NULL, 'https://www.youtube.com/watch?v=aZiBIGooCFo'),
	(57, 'A Neighbors Vendetta', 2023, 'Feature', '2023-12-01 22:30:26', '2023-11-13 13:43:56', NULL, 'https://tubitv.com/movies/713116/a-neighbor-s-vendetta'),
	(58, 'I Do This For A Living', 2023, 'Feature', '2023-11-13 13:43:56', '2023-11-13 13:43:56', NULL, NULL),
	(59, 'Deadly Secrets of a Cam Girl', 2023, 'Feature', '2023-12-01 22:26:38', '2023-11-13 13:43:56', NULL, 'https://tubitv.com/movies/100004455/deadly-secrets-of-a-cam-girl#:~:text=A%20young%20woman%20working%20to,a%20mysterious%20subscriber%20goes%20missing.'),
	(60, 'Twisted Marriage Therapist', 2023, 'Feature', '2023-12-07 13:53:44', '2023-11-13 13:43:56', NULL, 'https://tubitv.com/movies/100008449/twisted-marriage-therapist'),
	(61, 'Delta County', 2023, 'Short', '2023-12-07 15:34:36', '2023-11-13 13:43:56', NULL, NULL);
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;

-- Dumping structure for table soundmovies.production
CREATE TABLE IF NOT EXISTS `production` (
  `productionId` varchar(20) NOT NULL,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`productionId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table soundmovies.production: ~8 rows (approximately)
/*!40000 ALTER TABLE `production` DISABLE KEYS */;
INSERT INTO `production` (`productionId`, `description`) VALUES
	('Commercial', 'A 30 second spot typically highlighting a product'),
	('Concept', 'A proof of concept created to spark interest in funding the project for further development'),
	('Corporate', 'Any video created for a large corporation'),
	('Documentary', 'A film that is non-fiction intended to document reality'),
	('ENG', 'Stands for electronic news gathering, gather and present news live'),
	('Feature', 'A full length film with a run time between 80 and 180 minutes long'),
	('Podcast', 'A digital audio file made available on the internet, sometimes with video as well'),
	('Short', 'A film that is not long enough to be conisdered a feature');
/*!40000 ALTER TABLE `production` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
