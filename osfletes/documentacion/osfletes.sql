-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', null, null, '', 'admin', 'admin', null, null);
INSERT INTO `user` VALUES ('2', '2012-01-24', null, '', 'c', 'c', null, null);
INSERT INTO `user` VALUES ('3', '2012-01-24', null, '', 'p', 'p', null, null);
INSERT INTO `user` VALUES ('4', '2012-01-24', null, '', 'c1', 'c1', null, null);



-- ----------------------------
-- Records of cliente
-- ----------------------------
INSERT INTO `cliente` VALUES ('2');
INSERT INTO `cliente` VALUES ('4');


-- ----------------------------
-- Records of proveedor
-- ----------------------------
INSERT INTO `proveedor` VALUES ('3');


-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', null, null, 'ROLE_ADMIN', null, null);
INSERT INTO `role` VALUES ('2', null, null, 'ROLE_CLIENT', null, null);
INSERT INTO `role` VALUES ('3', null, null, 'ROLE_PROV', null, null);

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('2', '2');
INSERT INTO `user_role` VALUES ('3', '3');
INSERT INTO `user_role` VALUES ('4', '2');
