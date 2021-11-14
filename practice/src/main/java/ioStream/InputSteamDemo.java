package ioStream;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author Sc
 * @date 2021/3/1
 */
public class InputSteamDemo {

    @Test
    public void demo(){
        String str = "[[\"CGSL000032\",\"2\",\"BM000009\",\"BM000002\",\"行政采购部\",\"财务中心\",1000000.0000000000,884955.7500000000,115044.2500000000,0.0,1,100633,\"深圳市顺帆达印刷有限公司\",\"CK002\",\" \",103495,\"佘琼\",100065,\"SU002117\",100000.0000000000,0.0,8.8495580000,884955.7500000000,10.0000000000,1000000.0000000000,115044.2500000000,13.000000,\"CGDD000664\",\"CGSQ000052\"],[\"CGSL000031\",\"2\",\"BM000009\",\"BM000002\",\"行政采购部\",\"财务中心\",4840.0000000000,4283.1900000000,556.8100000000,0.0,1,100632,\"深圳市佳顺印刷包装有限公司\",\"CK002\",\" \",103495,\"佘琼\",100064,\"SU002116\",220.0000000000,0.0,19.4690270000,4283.1900000000,22.0000000000,4840.0000000000,556.8100000000,13.000000,\"CGDD000663\",\"CGSQ000051\"],[\"CGSL000030\",\"2\",\"BM000009\",\"BM000002\",\"行政采购部\",\"财务中心\",6000.0000000000,5309.7300000000,690.2700000000,0.0,1,100632,\"深圳市佳顺印刷包装有限公司\",\"CK002\",\" \",103495,\"佘琼\",100063,\"SU002114\",200.0000000000,0.0,26.5486730000,5309.7300000000,30.0000000000,6000.0000000000,690.2700000000,13.000000,\"CGDD000662\",\"CGSQ000050\"],[\"CGSL000029\",\"2\",\"BM000009\",\"BM000002\",\"行政采购部\",\"财务中心\",300.0000000000,265.4900000000,34.5100000000,0.0,1,100632,\"深圳市佳顺印刷包装有限公司\",\"CK002\",\" \",103495,\"佘琼\",100061,\"SU002106\",10.0000000000,0.0,8.8495580000,88.5000000000,10.0000000000,100.0000000000,11.5000000000,13.000000,\"CGDD000661\",\"CGSQ000049\"],[\"CGSL000029\",\"2\",\"BM000009\",\"BM000002\",\"行政采购部\",\"财务中心\",300.0000000000,265.4900000000,34.5100000000,0.0,1,100632,\"深圳市佳顺印刷包装有限公司\",\"CK002\",\" \",103495,\"佘琼\",100062,\"SU002107\",10.0000000000,0.0,17.6991150000,176.9900000000,20.0000000000,200.0000000000,23.0100000000,13.000000,\"CGDD000661\",\"CGSQ000049\"],[\"CGSL000022\",\"2\",\"BM000009\",\"BM000002\",\"行政采购部\",\"财务中心\",1800.0000000000,1758.9900000000,41.0100000000,0.0,1,100632,\"深圳市佳顺印刷包装有限公司\",\"CK002\",\" \",104138,\"陈润聪\",100051,\"SU001110\",30.0000000000,30.0000000000,19.4174760000,582.5200000000,20.0000000000,600.0000000000,17.4800000000,3.000000,\"CGDD000654\",\"CGSQ000040\"],[\"CGSL000022\",\"2\",\"BM000009\",\"BM000002\",\"行政采购部\",\"财务中心\",1800.0000000000,1758.9900000000,41.0100000000,0.0,1,100632,\"深圳市佳顺印刷包装有限公司\",\"CK002\",\" \",104138,\"陈润聪\",100052,\"SU001111\",40.0000000000,40.0000000000,29.4117650000,1176.4700000000,30.0000000000,1200.0000000000,23.5300000000,2.000000,\"CGDD000654\",\"CGSQ000040\"],[\"CGSL000021\",\"2\",\"BM000009\",\"BM000002\",\"行政采购部\",\"财务中心\",700.0000000000,682.4700000000,17.5300000000,0.0,1,100632,\"深圳市佳顺印刷包装有限公司\",\"CK002\",\" \",104138,\"陈润聪\",100049,\"SU001111\",10.0000000000,10.0000000000,29.4117650000,294.1200000000,30.0000000000,300.0000000000,5.8800000000,2.000000,\"CGDD000653\",\"CGSQ000039\"],[\"CGSL000021\",\"2\",\"BM000009\",\"BM000002\",\"行政采购部\",\"财务中心\",700.0000000000,682.4700000000,17.5300000000,0.0,1,100632,\"深圳市佳顺印刷包装有限公司\",\"CK002\",\" \",104138,\"陈润聪\",100050,\"SU001110\",20.0000000000,10.0000000000,19.4174760000,388.3500000000,20.0000000000,400.0000000000,11.6500000000,3.000000,\"CGDD000653\",\"CGSQ000039\"],[\"CGSL000020\",\"2\",\"BM000009\",\"BM000002\",\"行政采购部\",\"财务中心\",1650.0000000000,1460.1800000000,189.8200000000,0.0,1,100633,\"深圳市顺帆达印刷有限公司\",\"CK002\",\" \",104138,\"陈润聪\",100048,\"SU001110\",50.0000000000,20.0000000000,29.2035400000,1460.1800000000,33.0000000000,1650.0000000000,189.8200000000,13.000000,\"CGDD000652\",\"CGSQ000038\"],[\"CGSL000020\",\"2\",\"BM000009\",\"BM000002\",\"行政采购部\",\"财务中心\",1650.0000000000,1460.1800000000,189.8200000000,0.0,1,100633,\"深圳市顺帆达印刷有限公司\",\"CK002\",\" \",104138,\"陈润聪\",100048,\"SU001110\",50.0000000000,20.0000000000,29.2035400000,1460.1800000000,33.0000000000,1650.0000000000,189.8200000000,13.000000,\"CGDD000652\",\"CGSQ000038\"],[\"CGSL000016\",\"2\",\"BM000009\",\"BM000002\",\"行政采购部\",\"财务中心\",1500.0000000000,1363.6400000000,136.3600000000,0.0,1,100632,\"深圳市佳顺印刷包装有限公司\",\"CK002\",\" \",104138,\"陈润聪\",100043,\"SU000043\",50.0000000000,1.0000000000,27.2727270000,1363.6400000000,30.0000000000,1500.0000000000,136.3600000000,10.000000,\"CGDD000649\",\"CGSQ000035\"],[\"CGSL000016\",\"2\",\"BM000009\",\"BM000002\",\"行政采购部\",\"财务中心\",1500.0000000000,1363.6400000000,136.3600000000,0.0,1,100632,\"深圳市佳顺印刷包装有限公司\",\"CK002\",\" \",104138,\"陈润聪\",100043,\"SU000043\",50.0000000000,1.0000000000,27.2727270000,1363.6400000000,30.0000000000,1500.0000000000,136.3600000000,10.000000,\"CGDD000649\",\"CGSQ000035\"]]";
        InputStream is = new ByteArrayInputStream(str.getBytes());
        System.out.println(is);

        String str1 = "[[\"CGSL000029\",\"1\",\"BM000012\",\"BM000012\",\"智能教具部\",\"智能教具部\",1905.0000000000,1849.5100000000,55.4900000000,0.0,1,108605,\"吴江区盛泽镇优易百货商行\",\"CK003\",\" \",106546,\"龙晓芳\",100064,\"SU001606\",1.0000000000,0.0,1849.5145630000,1849.5100000000,1905.0000000000,1905.0000000000,55.4900000000,3.000000,\"CGDD000724\",\"CGSQ000113\"],[\"CGSL000027\",\"2\",\"BM000008\",\"BM000008\",\"探月业务中心\",\"探月业务中心\",11957.0000000000,10581.4200000000,1375.5800000000,0.0,1,107502,\"京东\",\"CK002\",\" \",104140,\"邓京姗\",100060,\"SU001570\",3.0000000000,0.0,2413.2743360000,7239.8200000000,2727.0000000000,8181.0000000000,941.1800000000,13.000000,\"CGDD000690\",\"CGSQ000080\"],[\"CGSL000027\",\"2\",\"BM000008\",\"BM000008\",\"探月业务中心\",\"探月业务中心\",11957.0000000000,10581.4200000000,1375.5800000000,0.0,1,107502,\"京东\",\"CK002\",\" \",104140,\"邓京姗\",100061,\"SU001571\",7.0000000000,0.0,352.2123890000,2465.4900000000,398.0000000000,2786.0000000000,320.5100000000,13.000000,\"CGDD000690\",\"CGSQ000080\"],[\"CGSL000027\",\"2\",\"BM000008\",\"BM000008\",\"探月业务中心\",\"探月业务中心\",11957.0000000000,10581.4200000000,1375.5800000000,0.0,1,107502,\"京东\",\"CK002\",\" \",104140,\"邓京姗\",100062,\"SU001572\",10.0000000000,0.0,87.6106190000,876.1100000000,99.0000000000,990.0000000000,113.8900000000,13.000000,\"CGDD000690\",\"CGSQ000080\"],[\"CGSL000026\",\"1\",\"BM000005\",\"BM000005\",\"获客增长部\",\"获客增长部\",25000.0000000000,24271.8400000000,728.1600000000,0.0,1,106457,\"广东省东谷玩具有限公司\",\"CK002\",\" \",104146,\"郭忠钿\",100059,\"SU000598\",500.0000000000,0.0,48.5436890000,24271.8400000000,50.0000000000,25000.0000000000,728.1600000000,3.000000,\"CGDD000685\",\"CGSQ000079\"],[\"CGSL000025\",\"1\",\"BM000004\",\"BM000004\",\"定制课业务中心\",\"定制课业务中心\",7140.0000000000,6932.0400000000,207.9600000000,0.0,1,106904,\"汕头市澄海区荣洽玩具商行\",\"CK003\",\" \",106544,\"黄于蓝\",100058,\"SU000632\",102.0000000000,0.0,67.9611650000,6932.0400000000,70.0000000000,7140.0000000000,207.9600000000,3.000000,\"CGDD000684\",\"CGSQ000078\"],[\"CGSL000024\",\"1\",\"BM000005\",\"BM000005\",\"获客增长部\",\"获客增长部\",28600.0000000000,25309.7300000000,3290.2700000000,0.0,1,102197,\"佛山金色年华玩具有限公司\",\"CK001\",\" \",106541,\"张勇\",100057,\"SU000168\",1300.0000000000,0.0,19.4690270000,25309.7300000000,22.0000000000,28600.0000000000,3290.2700000000,13.000000,\"CGDD000682\",\"CGSQ000065\"],[\"CGSL000023\",\"1\",\"BM000011\",\"BM000011\",\"内容与考评中心\",\"内容与考评中心\",0.0,0.0,0.0,0.0,1,106550,\"恒美印务（广州）有限公司\",\"CK002\",\" \",106545,\"何彩虹\",100055,\"SU000843\",100000.0000000000,0.0,3.3185840000,331858.4100000000,3.7500000000,375000.0000000000,43141.5900000000,13.000000,\"CGDD000681\",\"CGSQ000076\"],[\"CGSL000023\",\"1\",\"BM000011\",\"BM000011\",\"内容与考评中心\",\"内容与考评中心\",0.0,0.0,0.0,0.0,1,106550,\"恒美印务（广州）有限公司\",\"CK002\",\" \",106545,\"何彩虹\",100056,\"SU000930\",154000.0000000000,0.0,1.5929200000,245309.7300000000,1.8000000000,277200.0000000000,31890.2700000000,13.000000,\"CGDD000681\",\"CGSQ000076\"],[\"CGSL000022\",\"1\",\"BM000011\",\"BM000011\",\"内容与考评中心\",\"内容与考评中心\",123600.0000000000,109380.5300000000,14219.4700000000,0.0,1,106550,\"恒美印务（广州）有限公司\",\"CK001\",\" \",106545,\"何彩虹\",100053,\"SU001550\",30000.0000000000,0.0,3.3185840000,99557.5200000000,3.7500000000,112500.0000000000,12942.4800000000,13.000000,\"CGDD000681\",\"CGSQ000076\"],[\"CGSL000022\",\"1\",\"BM000011\",\"BM000011\",\"内容与考评中心\",\"内容与考评中心\",123600.0000000000,109380.5300000000,14219.4700000000,0.0,1,106550,\"恒美印务（广州）有限公司\",\"CK001\",\" \",106545,\"何彩虹\",100054,\"SU001551\",2000.0000000000,0.0,4.9115040000,9823.0100000000,5.5500000000,11100.0000000000,1276.9900000000,13.000000,\"CGDD000681\",\"CGSQ000076\"],[\"CGSL000021\",\"1\",\"BM000011\",\"BM000011\",\"内容与考评中心\",\"内容与考评中心\",90000.0000000000,79646.0200000000,10353.9800000000,0.0,1,106550,\"恒美印务（广州）有限公司\",\"CK003\",\" \",106545,\"何彩虹\",100052,\"SU001550\",24000.0000000000,0.0,3.3185840000,79646.0200000000,3.7500000000,90000.0000000000,10353.9800000000,13.000000,\"CGDD000681\",\"CGSQ000076\"],[\"CGSL000020\",\"1\",\"BM000011\",\"BM000011\",\"内容与考评中心\",\"内容与考评中心\",99900.0000000000,88407.0800000000,11492.9200000000,0.0,1,106550,\"恒美印务（广州）有限公司\",\"CK003\",\" \",106545,\"何彩虹\",100051,\"SU001551\",18000.0000000000,0.0,4.9115040000,88407.0800000000,5.5500000000,99900.0000000000,11492.9200000000,13.000000,\"CGDD000681\",\"CGSQ000076\"],[\"CGSL000019\",\"2\",\"BM000008\",\"BM000008\",\"探月业务中心\",\"探月业务中心\",198800.0000000000,175929.2000000000,22870.8000000000,0.0,1,102197,\"佛山金色年华玩具有限公司\",\"CK001\",\" \",106541,\"张勇\",100050,\"SU000097\",14000.0000000000,0.0,12.5663720000,175929.2000000000,14.2000000000,198800.0000000000,22870.8000000000,13.000000,\"CGDD000680\",\"CGSQ000073\"],[\"CGSL000018\",\"2\",\"BM000008\",\"BM000007\",\"探月业务中心\",\"小火箭业务中心\",214500.0000000000,189823.0100000000,24676.9900000000,0.0,1,100676,\"广东哈一代玩具股份有限公司\",\"CK002\",\" \",106541,\"张勇\",100049,\"SU001476\",55000.0000000000,0.0,3.4513270000,189823.0100000000,3.9000000000,214500.0000000000,24676.9900000000,13.000000,\"CGDD000708\",\"CGSQ000096\"],[\"CGSL000017\",\"1\",\"BM000004\",\"BM000004\",\"定制课业务中心\",\"定制课业务中心\",70000.0000000000,67961.1700000000,2038.8300000000,0.0,1,106904,\"汕头市澄海区荣洽玩具商行\",\"CK003\",\" \",106544,\"黄于蓝\",100046,\"SU000632\",1000.0000000000,0.0,67.9611650000,67961.1700000000,70.0000000000,70000.0000000000,2038.8300000000,3.000000,\"CGDD000701\",\"CGSQ000089\"]]";
        InputStream is2 = new ByteArrayInputStream(str1.getBytes());
        System.out.println(is2);
    }
}
