set names utf8;

-- [#1012] 创建表test，包含基础的数据的插入；
source D:/sqls/tables/bk_account.sql;
source D:/sqls/tables/bk_consume.sql;
source D:/sqls/tables/bk_recharge.sql;
source D:/sqls/tables/gg_hist.sql;
source D:/sqls/tables/gg_score.sql;
source D:/sqls/tables/gg_table.sql;
source D:/sqls/tables/wx_user.sql;

-- [#1013] 插入表test数据
INSERT INTO `wx`(wxcode, wxnick, remark) VALUES('weixin', '微信小微', '测试');

-- [#1014] 增加function: test
source D:/sqls/functions/test.func;

-- [#1015] 增加procedure: test
source D:/sqls/procedures/test.proc;

-- [#1016] 增加view: test_view
source D:/sqls/views/v_test.sql;