set names utf8;

-- [#1012] 创建表test，包含基础的数据的插入
-- Data: 2016-04-13
-- Author: zhoucl
source D:/sqls/tables/gc_off_deposit.sql;
source D:/sqls/tables/gc_ratio_coin.sql;
source D:/sqls/tables/gc_ratio_tax.sql;
source D:/sqls/tables/gf_rank.sql;
source D:/sqls/tables/gf_reward.sql;
source D:/sqls/tables/gf_score.sql;
source D:/sqls/tables/gg_hist.sql;
source D:/sqls/tables/gg_room_player.sql;
source D:/sqls/tables/gg_room.sql;
source D:/sqls/tables/gu_deposit.sql;
source D:/sqls/tables/gu_login.sql;
source D:/sqls/tables/gu_user.sql;

-- [#1014] 增加function: test
-- Data: 2016-04-13
-- Author: zhoucl
source D:/sqls/functions/test.func;

-- [#1015] 增加procedure: test
-- Data: 2016-04-13
-- Author: zhoucl
source D:/sqls/procedures/test.proc;

-- [#1016] 增加view: test_view
-- Data: 2016-04-13
-- Author: zhoucl
source D:/sqls/views/v_test.sql;