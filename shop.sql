/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2018-04-08 22:45:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ad`
-- ----------------------------
DROP TABLE IF EXISTS `ad`;
CREATE TABLE `ad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `properties` varchar(255) DEFAULT NULL,
  `is_active` bit(63) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ad_ad_group_1` (`group_id`),
  CONSTRAINT `fk_ad_ad_group_1` FOREIGN KEY (`group_id`) REFERENCES `ad_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ad
-- ----------------------------

-- ----------------------------
-- Table structure for `ad_group`
-- ----------------------------
DROP TABLE IF EXISTS `ad_group`;
CREATE TABLE `ad_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `is_active` bit(63) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ad_group
-- ----------------------------

-- ----------------------------
-- Table structure for `ad_property`
-- ----------------------------
DROP TABLE IF EXISTS `ad_property`;
CREATE TABLE `ad_property` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) DEFAULT NULL,
  `property_key` varchar(255) DEFAULT NULL,
  `propety_value` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ad_property_ad_group_1` (`group_id`),
  CONSTRAINT `fk_ad_property_ad_group_1` FOREIGN KEY (`group_id`) REFERENCES `ad_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ad_property
-- ----------------------------

-- ----------------------------
-- Table structure for `authorization`
-- ----------------------------
DROP TABLE IF EXISTS `authorization`;
CREATE TABLE `authorization` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_authorization_user_1` (`user_id`),
  CONSTRAINT `FKb0ki8m7r22jwyto1m0xcxdjqo` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authorization
-- ----------------------------
INSERT INTO `authorization` VALUES ('1', '1', '2018-01-08 17:38:57', '2018-01-08 17:39:01', 'edit');

-- ----------------------------
-- Table structure for `carousel_item`
-- ----------------------------
DROP TABLE IF EXISTS `carousel_item`;
CREATE TABLE `carousel_item` (
  `carouse_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img_url` varchar(255) DEFAULT NULL,
  `action_url` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjwl487i2w2ss801f30llci5je` (`carouse_id`),
  CONSTRAINT `FKjwl487i2w2ss801f30llci5je` FOREIGN KEY (`carouse_id`) REFERENCES `carousel_view` (`id`),
  CONSTRAINT `fkb_carousel` FOREIGN KEY (`carouse_id`) REFERENCES `carousel_view` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carousel_item
-- ----------------------------
INSERT INTO `carousel_item` VALUES ('1', '1', 'https://ws3.sinaimg.cn/large/006tKfTcly1fkk2v3mfjaj30le0aoq5h.jpg', 'wfshop://abc', '2018-01-12 15:55:14', '2018-01-12 15:55:22');
INSERT INTO `carousel_item` VALUES ('1', '2', 'https://ws4.sinaimg.cn/large/006tKfTcly1fkk2vq6y8fj30le0aomzj.jpg', 'wfshop://abc', '2018-01-12 15:55:17', '2018-01-12 15:55:25');
INSERT INTO `carousel_item` VALUES ('1', '3', 'https://ws2.sinaimg.cn/large/006tKfTcly1fkk2vxs4vej30le0aogoa.jpg', 'wfshop://abc', '2018-01-12 15:55:19', '2018-01-12 15:55:28');

-- ----------------------------
-- Table structure for `carousel_view`
-- ----------------------------
DROP TABLE IF EXISTS `carousel_view`;
CREATE TABLE `carousel_view` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ratio` float(2,0) DEFAULT NULL,
  `conf_id` int(11) DEFAULT NULL,
  `duration` float(2,0) DEFAULT NULL,
  `style_id` varchar(255) DEFAULT 'carousel_view',
  `updated_at` datetime DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnqen8y2wglnsgx65j3uyk94w3` (`conf_id`),
  CONSTRAINT `FKnqen8y2wglnsgx65j3uyk94w3` FOREIGN KEY (`conf_id`) REFERENCES `indexconfig` (`id`),
  CONSTRAINT `fk_car_conf` FOREIGN KEY (`conf_id`) REFERENCES `indexconfig` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carousel_view
-- ----------------------------
INSERT INTO `carousel_view` VALUES ('1', '0.', '1', '3', 'carousel_view', '2018-01-15 09:53:44', '2018-01-15 09:53:56');
INSERT INTO `carousel_view` VALUES ('2', '0.', '1', '2', 'carousel_view', '2018-01-15 09:53:51', '2018-01-15 09:53:59');

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `cart_key` varchar(255) DEFAULT NULL,
  `user` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `FK2h19ugnvpw7x51hox7ia3o55t` (`user`),
  CONSTRAINT `FK2h19ugnvpw7x51hox7ia3o55t` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('1', '2018-01-06 00:00:00', '2018-01-06 00:00:00', '123', '1');
INSERT INTO `cart` VALUES ('2', '2018-01-06 00:00:00', '2018-01-06 00:00:00', '234', '2');

-- ----------------------------
-- Table structure for `cart_item`
-- ----------------------------
DROP TABLE IF EXISTS `cart_item`;
CREATE TABLE `cart_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cart_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `product` int(11) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `modify_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1uobyhgl1wvgt1jpccia8xxs3` (`cart_id`),
  KEY `FK1995n4vu1kx536ajess0mhn60` (`product`),
  CONSTRAINT `FK1995n4vu1kx536ajess0mhn60` FOREIGN KEY (`product`) REFERENCES `product` (`id`),
  CONSTRAINT `FK1uobyhgl1wvgt1jpccia8xxs3` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`),
  CONSTRAINT `cart_item_ibfk_1` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`),
  CONSTRAINT `cart_item_ibfk_2` FOREIGN KEY (`product`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart_item
-- ----------------------------
INSERT INTO `cart_item` VALUES ('1', '1', '1', '1', '2018-01-06', '2018-01-06');
INSERT INTO `cart_item` VALUES ('2', '1', '2', '2', '2018-01-06', '2018-01-06');
INSERT INTO `cart_item` VALUES ('3', '2', '1', '3', '2018-01-06', '2018-01-06');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT '-1',
  `img_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_catagory_catagory_1` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '-1', null, '手机数码', null, null);
INSERT INTO `category` VALUES ('2', '-1', null, '电脑办公', null, null);
INSERT INTO `category` VALUES ('3', '-1', null, '电视影视', null, null);
INSERT INTO `category` VALUES ('4', '-1', null, '空调冰系', null, null);
INSERT INTO `category` VALUES ('5', '-1', null, '厨卫电器', null, null);
INSERT INTO `category` VALUES ('6', '-1', null, '生活电器', null, null);
INSERT INTO `category` VALUES ('7', '-1', null, '食品烟酒', null, null);
INSERT INTO `category` VALUES ('8', '-1', null, '美妆个护', null, null);
INSERT INTO `category` VALUES ('9', '-1', null, '母婴玩具', null, null);
INSERT INTO `category` VALUES ('10', '-1', null, '服饰鞋帽', null, null);
INSERT INTO `category` VALUES ('11', '-1', null, '运动户外', null, null);
INSERT INTO `category` VALUES ('12', '10', null, '男装', null, null);
INSERT INTO `category` VALUES ('13', '10', null, '家居内衣', null, null);
INSERT INTO `category` VALUES ('14', '12', 'http://img14.gomein.net.cn/image/prodimg/promimg/topics/201607/201607211606480715.png', '马甲/背心', null, null);
INSERT INTO `category` VALUES ('15', '13', 'http://img14.gomein.net.cn/image/prodimg/gicon/cat15985592.png', '男袜', null, null);
INSERT INTO `category` VALUES ('16', '1', null, '手机', null, null);
INSERT INTO `category` VALUES ('17', '1', null, '电脑', null, null);
INSERT INTO `category` VALUES ('18', '16', null, '小米', null, null);
INSERT INTO `category` VALUES ('19', '16', null, '华为', null, null);
INSERT INTO `category` VALUES ('20', '16', null, '魅族', null, null);

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `rate` int(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `is_show` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_table_1_product_1` (`product_id`),
  KEY `fk_table_1_user_1` (`user_id`),
  CONSTRAINT `FK8kcum44fvpupyw6f5baccx25c` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKm1rmnfcvq5mk26li4lit88pc5` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_table_1_product_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_table_1_user_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '1', '1', '华而不实', '1', '2018-03-13 21:36:40', '2018-03-13 21:36:53');
INSERT INTO `comment` VALUES ('2', '1', '1', '2', '为所欲为', '1', '2018-03-13 21:36:43', '2018-03-13 21:36:56');
INSERT INTO `comment` VALUES ('3', '2', '2', '3', 'are you OK', '1', '2018-03-13 21:36:45', '2018-03-13 21:36:58');
INSERT INTO `comment` VALUES ('4', '3', '3', '4', '魅族演唱会', '1', '2018-03-13 21:36:47', '2018-03-13 21:37:01');
INSERT INTO `comment` VALUES ('5', '4', '3', '5', '阿里云OS', '1', '2018-03-13 22:36:50', '2018-03-13 21:37:04');

-- ----------------------------
-- Table structure for `commission_snapshot`
-- ----------------------------
DROP TABLE IF EXISTS `commission_snapshot`;
CREATE TABLE `commission_snapshot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `commission` float(255,0) DEFAULT NULL,
  `levels_ratio` varchar(255) DEFAULT NULL,
  `distributers` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commission_snapshot
-- ----------------------------

-- ----------------------------
-- Table structure for `coupon`
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_id` int(11) DEFAULT NULL,
  `begin_at` int(255) DEFAULT NULL,
  `end_at` int(255) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  `max_price` float(10,2) DEFAULT NULL,
  `min_price` float(10,2) DEFAULT NULL,
  `max_quantity` int(255) DEFAULT NULL,
  `min_quantity` int(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price_expression` varchar(255) DEFAULT NULL,
  `instance_amount` int(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coupon
-- ----------------------------

-- ----------------------------
-- Table structure for `coupon_instance`
-- ----------------------------
DROP TABLE IF EXISTS `coupon_instance`;
CREATE TABLE `coupon_instance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coupon_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `is_used` int(255) DEFAULT NULL,
  `isvalid` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `used_at` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_coupon_instance_coupon_1` (`coupon_id`),
  KEY `fk_coupon_instance_user_1` (`user_id`),
  CONSTRAINT `fk_coupon_instance_coupon_1` FOREIGN KEY (`coupon_id`) REFERENCES `coupon` (`id`),
  CONSTRAINT `fk_coupon_instance_user_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coupon_instance
-- ----------------------------

-- ----------------------------
-- Table structure for `distribute`
-- ----------------------------
DROP TABLE IF EXISTS `distribute`;
CREATE TABLE `distribute` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trace_identifier` varchar(11) DEFAULT NULL,
  `shop_id` int(11) DEFAULT NULL,
  `from_shop_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_distribute_shop_1` (`shop_id`),
  KEY `fk_distribute_shop_2` (`from_shop_id`),
  KEY `fk_distribute_product_1` (`product_id`),
  CONSTRAINT `fk_distribute_product_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_distribute_shop_1` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`id`),
  CONSTRAINT `fk_distribute_shop_2` FOREIGN KEY (`from_shop_id`) REFERENCES `shop` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of distribute
-- ----------------------------

-- ----------------------------
-- Table structure for `grid_item`
-- ----------------------------
DROP TABLE IF EXISTS `grid_item`;
CREATE TABLE `grid_item` (
  `grid_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img_url` varchar(255) DEFAULT NULL,
  `action_url` varchar(255) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmk95abn488qyyqqwixbd45rh3` (`grid_id`),
  CONSTRAINT `FKmk95abn488qyyqqwixbd45rh3` FOREIGN KEY (`grid_id`) REFERENCES `grid_view` (`id`),
  CONSTRAINT `fkb_grid_id` FOREIGN KEY (`grid_id`) REFERENCES `grid_view` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grid_item
-- ----------------------------
INSERT INTO `grid_item` VALUES ('2', '1', 'https://ws3.sinaimg.cn/large/006tNc79ly1fkm829cjfhj305k05kdfz.jpg', 'wfshop://abc', '1', null, null);
INSERT INTO `grid_item` VALUES ('2', '2', 'https://ws1.sinaimg.cn/large/006tNc79ly1fkm82o87h3j305k05kq32.jpg', 'wfshop://abc', '1', null, null);
INSERT INTO `grid_item` VALUES ('2', '3', 'https://ws3.sinaimg.cn/large/006tNc79ly1fkm829cjfhj305k05kdfz.jpg', 'wfshop://abc', '1', null, null);
INSERT INTO `grid_item` VALUES ('2', '4', 'https://ws3.sinaimg.cn/large/006tNc79ly1fkm829cjfhj305k05kdfz.jpg', 'wfshop://abc', '1', null, null);
INSERT INTO `grid_item` VALUES ('2', '5', 'https://ws3.sinaimg.cn/large/006tNc79ly1fkm829cjfhj305k05kdfz.jpg', 'wfshop://abc', '1', null, null);
INSERT INTO `grid_item` VALUES ('3', '6', 'https://ws3.sinaimg.cn/large/006tNc79ly1fkm829cjfhj305k05kdfz.jpg', 'wfshop://abc', '1', null, null);
INSERT INTO `grid_item` VALUES ('3', '7', 'https://ws3.sinaimg.cn/large/006tNc79ly1fkm829cjfhj305k05kdfz.jpg', 'wfshop://abc', '1', null, null);
INSERT INTO `grid_item` VALUES ('3', '8', 'https://ws3.sinaimg.cn/large/006tNc79ly1fkm829cjfhj305k05kdfz.jpg', 'wfshop://abc', '1', null, null);
INSERT INTO `grid_item` VALUES ('3', '9', 'https://ws3.sinaimg.cn/large/006tNc79ly1fkm829cjfhj305k05kdfz.jpg', 'wfshop://abc', '1', null, null);
INSERT INTO `grid_item` VALUES ('1', '10', 'https://ws1.sinaimg.cn/large/006tNc79ly1fkm82o87h3j305k05kq32.jpg', 'wfshop://abc', '1', '2018-03-19 10:11:11', '2018-03-19 10:11:15');

-- ----------------------------
-- Table structure for `grid_view`
-- ----------------------------
DROP TABLE IF EXISTS `grid_view`;
CREATE TABLE `grid_view` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `weight` int(11) DEFAULT NULL,
  `orientation` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `conf_id` int(11) DEFAULT NULL,
  `style_id` varchar(255) DEFAULT 'grid_view',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `ratio` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk382qqk76iy0p7rmrlo371w1e` (`conf_id`),
  CONSTRAINT `FKk382qqk76iy0p7rmrlo371w1e` FOREIGN KEY (`conf_id`) REFERENCES `indexconfig` (`id`),
  CONSTRAINT `fbk_config_id` FOREIGN KEY (`conf_id`) REFERENCES `indexconfig` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grid_view
-- ----------------------------
INSERT INTO `grid_view` VALUES ('1', '1', 'v', '-1', '1', 'grid_view', '2018-01-15 16:20:54', '2018-01-15 16:20:57', '0.1');
INSERT INTO `grid_view` VALUES ('2', '1', 'h', '-1', '1', 'grid_view', '2018-01-15 16:21:00', '2018-01-15 16:21:03', '0.1');
INSERT INTO `grid_view` VALUES ('3', '1', 'h', '1', '1', 'grid_view', '2018-01-15 16:21:05', '2018-01-15 16:21:08', '0.1');

-- ----------------------------
-- Table structure for `group_ specification`
-- ----------------------------
DROP TABLE IF EXISTS `group_ specification`;
CREATE TABLE `group_ specification` (
  `group_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq1e6rn7k6arnthd090u8uxken` (`group_id`),
  CONSTRAINT `FKq1e6rn7k6arnthd090u8uxken` FOREIGN KEY (`group_id`) REFERENCES `product_group` (`id`),
  CONSTRAINT `ps_fk1` FOREIGN KEY (`group_id`) REFERENCES `product_group` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group_ specification
-- ----------------------------
INSERT INTO `group_ specification` VALUES ('1', '1', '机身颜色', '2018-01-09 11:49:55', '2018-01-09 11:49:58');
INSERT INTO `group_ specification` VALUES ('1', '2', '机身容量', '2018-01-09 12:02:46', '2018-01-09 12:02:49');
INSERT INTO `group_ specification` VALUES ('1', '3', '网络制式', '2018-01-09 12:03:42', '2018-01-09 12:03:45');
INSERT INTO `group_ specification` VALUES ('1', '4', '套餐类型', '2018-01-09 12:04:04', '2018-01-09 12:04:07');

-- ----------------------------
-- Table structure for `group_specification_option`
-- ----------------------------
DROP TABLE IF EXISTS `group_specification_option`;
CREATE TABLE `group_specification_option` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `spe_id` int(11) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_specification_option_product_ specification_1` (`spe_id`),
  CONSTRAINT `FK5dqx7w0713h2rhyljsqw5f63g` FOREIGN KEY (`spe_id`) REFERENCES `group_ specification` (`id`),
  CONSTRAINT `fk_product_specification_option_product_ specification_1` FOREIGN KEY (`spe_id`) REFERENCES `group_ specification` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group_specification_option
-- ----------------------------
INSERT INTO `group_specification_option` VALUES ('1', '1', '红色', '2018-01-09 12:05:57', '2018-01-09 12:05:59');
INSERT INTO `group_specification_option` VALUES ('2', '1', '金色', '2018-01-09 12:06:10', '2018-01-09 12:06:13');
INSERT INTO `group_specification_option` VALUES ('3', '1', '黑色', '2018-01-09 12:06:22', '2018-01-09 12:06:25');
INSERT INTO `group_specification_option` VALUES ('4', '2', '全网通', '2018-01-09 12:06:59', '2018-01-09 12:07:02');
INSERT INTO `group_specification_option` VALUES ('5', '2', '电信', '2018-01-09 12:07:14', '2018-01-09 12:07:16');
INSERT INTO `group_specification_option` VALUES ('6', '2', '移动合约', '2018-01-09 12:07:33', '2018-01-09 12:07:35');
INSERT INTO `group_specification_option` VALUES ('7', '3', '16g', '2018-01-09 12:08:11', '2018-01-09 12:08:15');
INSERT INTO `group_specification_option` VALUES ('8', '3', '64g', '2018-01-09 12:08:24', '2018-01-09 12:08:26');
INSERT INTO `group_specification_option` VALUES ('9', '4', '官方标配', '2018-01-09 12:08:56', '2018-01-09 12:09:00');
INSERT INTO `group_specification_option` VALUES ('10', '4', '套餐1', '2018-01-09 12:09:09', '2018-01-09 12:09:12');
INSERT INTO `group_specification_option` VALUES ('11', '4', '套餐2', '2018-01-09 12:09:19', '2018-01-09 12:09:23');

-- ----------------------------
-- Table structure for `indexconfig`
-- ----------------------------
DROP TABLE IF EXISTS `indexconfig`;
CREATE TABLE `indexconfig` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rato` float DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of indexconfig
-- ----------------------------
INSERT INTO `indexconfig` VALUES ('1', '0.5', null, null);

-- ----------------------------
-- Table structure for `mobile_ad`
-- ----------------------------
DROP TABLE IF EXISTS `mobile_ad`;
CREATE TABLE `mobile_ad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mobile_ad_group_id` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `order_num` int(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `is_active` bit(63) DEFAULT NULL,
  `width` int(255) DEFAULT NULL,
  `height` int(255) DEFAULT NULL,
  `orientation` varchar(1) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_mobile_ad_mobile_ad_1` (`parent_id`),
  KEY `fk_mobile_ad_mobile_ad_group_1` (`mobile_ad_group_id`),
  CONSTRAINT `fk_mobile_ad_mobile_ad_1` FOREIGN KEY (`parent_id`) REFERENCES `mobile_ad` (`id`),
  CONSTRAINT `fk_mobile_ad_mobile_ad_group_1` FOREIGN KEY (`mobile_ad_group_id`) REFERENCES `mobile_ad_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mobile_ad
-- ----------------------------

-- ----------------------------
-- Table structure for `mobile_ad_group`
-- ----------------------------
DROP TABLE IF EXISTS `mobile_ad_group`;
CREATE TABLE `mobile_ad_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_num` int(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `is_active` bit(63) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mobile_ad_group
-- ----------------------------

-- ----------------------------
-- Table structure for `mobile_intro_img`
-- ----------------------------
DROP TABLE IF EXISTS `mobile_intro_img`;
CREATE TABLE `mobile_intro_img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `ratio` float(255,0) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_mobile_intro_img_product_1` (`product_id`),
  CONSTRAINT `FKhob2f9ryg5jrk7q1g9xpnht0e` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_mobile_intro_img_product_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mobile_intro_img
-- ----------------------------
INSERT INTO `mobile_intro_img` VALUES ('1', '1', '1', 'http://gfs12.gomein.net.cn/T1bTYTBjJQ1RCvBVdK_800.jpg', '2018-01-09 13:53:48', '2018-01-09 16:00:37');
INSERT INTO `mobile_intro_img` VALUES ('2', '1', '1', 'http://gfs12.gomein.net.cn/T1WS_TBKVg1RCvBVdK_800.jpg', '2018-01-09 13:54:07', '2018-01-09 13:54:17');
INSERT INTO `mobile_intro_img` VALUES ('3', '1', '1', 'http://gfs12.gomein.net.cn/T1bTYTBjJQ1RCvBVdK_800.jpg', '2018-01-09 13:54:35', '2018-01-09 13:54:38');
INSERT INTO `mobile_intro_img` VALUES ('4', '1', '1', 'http://gfs12.gomein.net.cn/T1WS_TBKVg1RCvBVdK_800.jpg', '2018-01-09 13:54:54', '2018-01-09 13:54:56');

-- ----------------------------
-- Table structure for `mobile_navigation`
-- ----------------------------
DROP TABLE IF EXISTS `mobile_navigation`;
CREATE TABLE `mobile_navigation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_num` int(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mobile_navigation
-- ----------------------------

-- ----------------------------
-- Table structure for `navigation`
-- ----------------------------
DROP TABLE IF EXISTS `navigation`;
CREATE TABLE `navigation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `order_num` int(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `navigation_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `navigation_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of navigation
-- ----------------------------

-- ----------------------------
-- Table structure for `navigation_type`
-- ----------------------------
DROP TABLE IF EXISTS `navigation_type`;
CREATE TABLE `navigation_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of navigation_type
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `shop_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `ship_address_id` int(11) DEFAULT NULL,
  `products` varchar(255) DEFAULT NULL,
  `totalfee` int(255) DEFAULT NULL,
  `shipfee` int(255) DEFAULT NULL,
  `shiptype_id` int(255) DEFAULT NULL,
  `payment_id` int(255) DEFAULT NULL,
  `payment_info_id` int(11) DEFAULT NULL,
  `ship_info_id` int(11) DEFAULT NULL,
  `order_status` int(255) DEFAULT NULL,
  `commission_snapshot_id` int(11) DEFAULT NULL,
  `coupon_instance_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_ship_address_1` (`ship_address_id`),
  KEY `fk_order_user_1` (`user_id`),
  KEY `fk_order_shop_1` (`shop_id`),
  KEY `fk_order_payment_1` (`payment_id`),
  KEY `fk_order_shiptype_1` (`shiptype_id`),
  KEY `fk_order_ship_info_1` (`ship_info_id`),
  KEY `fk_order_commission_snapshot_1` (`commission_snapshot_id`),
  KEY `fk_order_coupon_instance_1` (`coupon_instance_id`),
  CONSTRAINT `fk_order_commission_snapshot_1` FOREIGN KEY (`commission_snapshot_id`) REFERENCES `commission_snapshot` (`id`),
  CONSTRAINT `fk_order_coupon_instance_1` FOREIGN KEY (`coupon_instance_id`) REFERENCES `coupon_instance` (`id`),
  CONSTRAINT `fk_order_payment_1` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`id`),
  CONSTRAINT `fk_order_ship_address_1` FOREIGN KEY (`ship_address_id`) REFERENCES `ship_address` (`id`),
  CONSTRAINT `fk_order_ship_info_1` FOREIGN KEY (`ship_info_id`) REFERENCES `ship_info` (`id`),
  CONSTRAINT `fk_order_shiptype_1` FOREIGN KEY (`shiptype_id`) REFERENCES `shiptype` (`id`),
  CONSTRAINT `fk_order_shop_1` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`id`),
  CONSTRAINT `fk_order_user_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `password_auth`
-- ----------------------------
DROP TABLE IF EXISTS `password_auth`;
CREATE TABLE `password_auth` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_password_user_1` (`user_id`),
  CONSTRAINT `fk_password_user_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of password_auth
-- ----------------------------

-- ----------------------------
-- Table structure for `payment`
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of payment
-- ----------------------------

-- ----------------------------
-- Table structure for `payment_info`
-- ----------------------------
DROP TABLE IF EXISTS `payment_info`;
CREATE TABLE `payment_info` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `type` int(255) DEFAULT NULL,
  `payment_id` int(11) DEFAULT NULL,
  `status` int(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of payment_info
-- ----------------------------

-- ----------------------------
-- Table structure for `payment_setting`
-- ----------------------------
DROP TABLE IF EXISTS `payment_setting`;
CREATE TABLE `payment_setting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `payment_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_payment_setting_payment_1` (`payment_id`),
  CONSTRAINT `fk_payment_setting_payment_1` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of payment_setting
-- ----------------------------

-- ----------------------------
-- Table structure for `phone_auth`
-- ----------------------------
DROP TABLE IF EXISTS `phone_auth`;
CREATE TABLE `phone_auth` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_phone_auth_user_1` (`user_id`),
  CONSTRAINT `fk_phone_auth_user_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of phone_auth
-- ----------------------------

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `shop_category_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` float(10,2) DEFAULT NULL,
  `product_comission_id` int(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `product_group_id` int(11) DEFAULT NULL,
  `sub_title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_product_1` (`category_id`),
  KEY `fk_product_shop_catagory_1` (`shop_category_id`),
  KEY `fk_product_product_commision_1` (`product_comission_id`),
  KEY `FKd1puiblqvkggoc63q7c3ux5x6` (`product_group_id`),
  CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKd1puiblqvkggoc63q7c3ux5x6` FOREIGN KEY (`product_group_id`) REFERENCES `product_group` (`id`),
  CONSTRAINT `fk_product_product_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `fk_product_product_commision_1` FOREIGN KEY (`product_comission_id`) REFERENCES `product_commision` (`id`),
  CONSTRAINT `fk_product_product_group_1` FOREIGN KEY (`product_group_id`) REFERENCES `product_group` (`id`),
  CONSTRAINT `fk_product_shop_catagory_1` FOREIGN KEY (`shop_category_id`) REFERENCES `shop_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '1', '19', '1', '华为 HUAWEI Mate9 Pro （LON-AL00）6GB+128GB 琥珀金', '5299.00', '1', '2018-01-09 12:54:55', '2018-01-09 12:55:06', '1', '    人像摄影大师”新一代徕卡双镜头 一体化前置指纹 5.1英寸显示屏 麒麟960芯片');
INSERT INTO `product` VALUES ('2', '2', '18', '1', '小米 （MI）红米4A 2GB+16GB 全网通双卡双带手机', '599.00', '1', '2018-01-09 12:54:58', '2018-01-09 12:55:08', '1', '人像摄影大师”新一代徕卡双镜头 一体化前置指纹 5.1英寸显示屏 麒麟960芯片');
INSERT INTO `product` VALUES ('3', '1', '20', '1', '魅族（MiZu）魅族科比定制版 指纹识别全网通手机 4GB+64GB', '1280.00', '1', '2018-01-09 12:55:00', '2018-01-09 12:55:12', '1', '人像摄影大师”新一代徕卡双镜头 一体化前置指纹 5.1英寸显示屏 麒麟960芯片');
INSERT INTO `product` VALUES ('4', '1', '20', '1', '魅族（MiZu）魅族英雄联盟定制版 指纹识别全网通手机 4GB+64GB', '835.00', '1', '2018-01-09 12:55:03', '2018-01-09 12:55:16', '1', '人像摄影大师”新一代徕卡双镜头 一体化前置指纹 5.1英寸显示屏 麒麟960芯片');

-- ----------------------------
-- Table structure for `product_commision`
-- ----------------------------
DROP TABLE IF EXISTS `product_commision`;
CREATE TABLE `product_commision` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `commission` float(255,0) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_commision
-- ----------------------------
INSERT INTO `product_commision` VALUES ('1', '1', '1', '2018-03-13 21:28:11', '2018-03-13 21:28:15');

-- ----------------------------
-- Table structure for `product_commission_ratio`
-- ----------------------------
DROP TABLE IF EXISTS `product_commission_ratio`;
CREATE TABLE `product_commission_ratio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` int(255) DEFAULT NULL,
  `ratio` float(255,0) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_commission_ratio
-- ----------------------------

-- ----------------------------
-- Table structure for `product_group`
-- ----------------------------
DROP TABLE IF EXISTS `product_group`;
CREATE TABLE `product_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL,
  `shop_category_id` int(11) DEFAULT NULL,
  `shop_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_group_product_category_1` (`category_id`),
  KEY `fk_product_group_shop_category_1` (`shop_category_id`),
  CONSTRAINT `FKdreaf3fj3s32hmbf6m4ivvj66` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `fk_product_group_product_category_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `fk_product_group_shop_category_1` FOREIGN KEY (`shop_category_id`) REFERENCES `shop_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_group
-- ----------------------------
INSERT INTO `product_group` VALUES ('1', '1', '1', '1', '小米手机', '2018-01-09 10:19:14', '2018-01-09 10:19:18');
INSERT INTO `product_group` VALUES ('2', '1', '1', '2', '小米手机', '2018-01-09 11:55:00', '2018-01-09 11:55:03');
INSERT INTO `product_group` VALUES ('3', '1', '1', '1', 'iphone8', '2018-01-09 11:56:41', '2018-01-09 11:56:44');

-- ----------------------------
-- Table structure for `product_info`
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `info_name` varchar(255) DEFAULT NULL,
  `info_value` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_info_product_1` (`product_id`),
  CONSTRAINT `FK51m6a4nrmlfdj3o2o69r6wn1q` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_product_info_product_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('1', '1', '内存', '16g', '2018-01-09 13:52:42', '2018-01-09 13:52:46');
INSERT INTO `product_info` VALUES ('2', '1', '颜色', '琥珀金', '2018-01-09 13:53:07', '2018-01-09 13:53:10');

-- ----------------------------
-- Table structure for `product_specification`
-- ----------------------------
DROP TABLE IF EXISTS `product_specification`;
CREATE TABLE `product_specification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `specification_id` int(11) DEFAULT NULL,
  `specification_value` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6gsoovgy8m1dqgbeyjbp45dtt` (`specification_id`),
  KEY `FK90tr36u682rcuqex6knno8boj` (`specification_value`),
  KEY `FKjk3nq9o6i8anej70mx7bkiyxc` (`product_id`),
  CONSTRAINT `FK6gsoovgy8m1dqgbeyjbp45dtt` FOREIGN KEY (`specification_id`) REFERENCES `group_ specification` (`id`),
  CONSTRAINT `FK90tr36u682rcuqex6knno8boj` FOREIGN KEY (`specification_value`) REFERENCES `group_specification_option` (`id`),
  CONSTRAINT `FKjk3nq9o6i8anej70mx7bkiyxc` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_prs_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_prs_2` FOREIGN KEY (`specification_id`) REFERENCES `group_ specification` (`id`),
  CONSTRAINT `fk_prs_3` FOREIGN KEY (`specification_value`) REFERENCES `group_specification_option` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_specification
-- ----------------------------
INSERT INTO `product_specification` VALUES ('1', '特点1', '2018-01-09 12:09:42', '2018-01-09 12:09:45', '1', '1', '1');
INSERT INTO `product_specification` VALUES ('2', '特点2', '2018-01-09 12:17:12', '2018-01-09 12:17:15', '1', '2', '1');
INSERT INTO `product_specification` VALUES ('3', '特点3', '2018-01-09 12:19:53', '2018-01-09 12:20:00', '1', '3', '1');
INSERT INTO `product_specification` VALUES ('4', '特点4', '2018-01-09 12:19:56', '2018-01-09 12:20:03', '1', '4', '1');

-- ----------------------------
-- Table structure for `qq_auth`
-- ----------------------------
DROP TABLE IF EXISTS `qq_auth`;
CREATE TABLE `qq_auth` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `access_token` varchar(255) DEFAULT NULL,
  `refresh_token` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_qq_auth_user_1` (`user_id`),
  CONSTRAINT `fk_qq_auth_user_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qq_auth
-- ----------------------------

-- ----------------------------
-- Table structure for `refund`
-- ----------------------------
DROP TABLE IF EXISTS `refund`;
CREATE TABLE `refund` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `payment_id` int(11) DEFAULT NULL,
  `amount` int(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_refund_user_1` (`user_id`),
  KEY `fk_refund_order_1` (`order_id`),
  KEY `fk_refund_payment_1` (`payment_id`),
  CONSTRAINT `fk_refund_order_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`),
  CONSTRAINT `fk_refund_payment_1` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`id`),
  CONSTRAINT `fk_refund_user_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of refund
-- ----------------------------

-- ----------------------------
-- Table structure for `refund_payment`
-- ----------------------------
DROP TABLE IF EXISTS `refund_payment`;
CREATE TABLE `refund_payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of refund_payment
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '2018-03-23 16:08:31', '2018-03-23 16:08:33', 'admin');
INSERT INTO `role` VALUES ('2', '2018-03-23 16:08:51', '2018-03-23 16:08:55', 'member');

-- ----------------------------
-- Table structure for `shiptype`
-- ----------------------------
DROP TABLE IF EXISTS `shiptype`;
CREATE TABLE `shiptype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shipname` varchar(255) DEFAULT NULL,
  `need_address` bit(63) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shiptype
-- ----------------------------

-- ----------------------------
-- Table structure for `ship_address`
-- ----------------------------
DROP TABLE IF EXISTS `ship_address`;
CREATE TABLE `ship_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `receiver_name` varchar(255) DEFAULT NULL,
  `receiver_phone` varchar(255) DEFAULT NULL,
  `postcode` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `is_default` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ship_address
-- ----------------------------
INSERT INTO `ship_address` VALUES ('1', '1', '张三', '1326161626355', null, '北京市', '海淀区', '西土城路10号', '2018-01-09 21:01:55', '2018-01-09 21:02:13', '1');
INSERT INTO `ship_address` VALUES ('2', '1', '李四', '1326161626355', null, '北京市', '海淀区', '西土城路10号', '2018-01-09 21:01:58', '2018-01-09 21:02:16', '0');
INSERT INTO `ship_address` VALUES ('3', '1', '张三', '1326161626355', null, '深圳市', '南山区', '深南大道', '2018-01-09 21:02:01', '2018-01-09 21:02:19', '0');
INSERT INTO `ship_address` VALUES ('4', '1', '李四', '1326161626355', null, '浙江省', '宁波市', '江东区', '2018-01-09 21:02:05', '2018-01-09 21:02:23', '0');
INSERT INTO `ship_address` VALUES ('5', '1', '王二', '1326161626355', null, '江苏省', '南京市', '总统府', '2018-01-09 21:02:08', '2018-01-09 21:02:26', '0');
INSERT INTO `ship_address` VALUES ('6', '2', '王五', '1326161626355', null, '浙江省', '杭州市', null, '2018-01-09 21:02:10', '2018-01-09 21:02:29', '1');

-- ----------------------------
-- Table structure for `ship_info`
-- ----------------------------
DROP TABLE IF EXISTS `ship_info`;
CREATE TABLE `ship_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shiptype_id` int(255) DEFAULT NULL,
  `ship_company` varchar(255) DEFAULT NULL,
  `ship_number` varchar(255) DEFAULT NULL,
  `status` int(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ship_info
-- ----------------------------

-- ----------------------------
-- Table structure for `shop`
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_shop_shop_product_1` FOREIGN KEY (`id`) REFERENCES `shop_product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('1', '网服旗舰店', '2018-01-06 18:23:51', '2018-01-06 18:23:53');
INSERT INTO `shop` VALUES ('2', '网服旗舰店2号', '2018-01-06 18:27:01', '2018-01-06 18:27:05');

-- ----------------------------
-- Table structure for `shop_category`
-- ----------------------------
DROP TABLE IF EXISTS `shop_category`;
CREATE TABLE `shop_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT '-1',
  `shop_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_shop_catagory_shop_1` (`shop_id`),
  KEY `fk_shop_catagory_shop_catagory_1` (`parent_id`),
  CONSTRAINT `fk_shop_catagory_shop_1` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_category
-- ----------------------------
INSERT INTO `shop_category` VALUES ('1', '-1', '1', '手机数码', '2018-01-09 11:46:54', '2018-01-09 11:46:57');

-- ----------------------------
-- Table structure for `shop_product`
-- ----------------------------
DROP TABLE IF EXISTS `shop_product`;
CREATE TABLE `shop_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `type` int(2) DEFAULT NULL COMMENT '1:自由商品 2：分销商品',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_shop_product_product_1` (`product_id`),
  CONSTRAINT `fk_shop_product_product_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_product
-- ----------------------------
INSERT INTO `shop_product` VALUES ('1', '1', '1', null, '2018-01-06 18:26:19', '2018-01-06 18:26:23');
INSERT INTO `shop_product` VALUES ('2', '2', '2', null, '2018-01-06 18:27:48', '2018-01-06 18:27:52');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `avatar_url` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`),
  CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', null, '18800115530', '2018-01-08 17:38:12', '2018-01-08 17:38:21', '123456', 'https://wfshop.andysheng.cn/img/avatar_1.jpg', null, '2');
INSERT INTO `user` VALUES ('2', '李四', null, '18800115531', '2018-01-08 17:38:15', '2018-01-08 17:38:24', null, 'https://wfshop.andysheng.cn/img/avatar_2.jpg', null, '2');
INSERT INTO `user` VALUES ('3', '王五', null, '18800115531', '2018-01-08 17:38:18', '2018-01-08 17:38:27', null, 'https://wfshop.andysheng.cn/img/avatar_3.jpg', null, '2');
INSERT INTO `user` VALUES ('4', 'admin', null, '18800115530', '2018-03-23 16:10:37', '2018-03-23 16:10:39', 'admin123', null, null, '1');
INSERT INTO `user` VALUES ('5', 'zhangsan', null, '18800115530', '2018-04-06 13:55:05', '2018-04-06 13:55:08', '123456', null, null, '2');
INSERT INTO `user` VALUES ('6', 'lisan', null, null, '2018-04-06 16:09:07', '2018-04-06 16:09:07', null, null, null, null);
INSERT INTO `user` VALUES ('7', 'lisi', '359128244@qq.com', '18800115530', '2018-04-06 17:12:00', '2018-04-06 17:12:00', '123456', null, null, null);
INSERT INTO `user` VALUES ('8', 'liwu', null, null, '2018-04-06 17:14:49', '2018-04-06 17:14:49', '123456', null, null, null);
INSERT INTO `user` VALUES ('19', 'xiao', null, null, '2018-04-06 19:00:55', '2018-04-06 19:00:55', null, null, null, null);
INSERT INTO `user` VALUES ('20', 'xia3333o', null, null, '2018-04-06 19:05:39', '2018-04-06 19:05:39', null, null, null, null);
INSERT INTO `user` VALUES ('23', 'mml', '4355262', null, '2018-04-06 19:15:39', '2018-04-06 19:15:39', '13455', null, null, null);

-- ----------------------------
-- Table structure for `wechat_auth`
-- ----------------------------
DROP TABLE IF EXISTS `wechat_auth`;
CREATE TABLE `wechat_auth` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `openid` varchar(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_wechat_auth_user_1` (`user_id`),
  CONSTRAINT `fk_wechat_auth_user_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wechat_auth
-- ----------------------------
