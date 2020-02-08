package frc.paths;

import com.team319.trajectory.Path;

public class TowerTrenchPickup extends Path {
   // dt,x,y,left.pos,left.vel,left.acc,left.jerk,center.pos,center.vel,center.acc,center.jerk,right.pos,right.vel,right.acc,right.jerk,heading
	private static final double[][] points = {
				{0.0200,32.1376,-5.5400,0.0024,0.1200,6.0000,0.0000,0.0024,0.1200,6.0000,0.0000,0.0024,0.1200,6.0000,0.0000,-3.1378},
				{0.0200,32.1328,-5.5400,0.0072,0.2397,5.9864,-0.6808,0.0072,0.2400,6.0000,0.0000,0.0072,0.2403,6.0136,0.6808,-3.1378},
				{0.0200,32.1256,-5.5401,0.0144,0.3591,5.9677,-0.9325,0.0144,0.3600,6.0000,0.0000,0.0144,0.3609,6.0323,0.9325,-3.1378},
				{0.0200,32.1160,-5.5401,0.0239,0.4778,5.9374,-1.5188,0.0240,0.4800,6.0000,0.0000,0.0241,0.4822,6.0626,1.5188,-3.1378},
				{0.0200,32.1040,-5.5401,0.0358,0.5958,5.8971,-2.0113,0.0360,0.6000,6.0000,0.0000,0.0362,0.6042,6.1029,2.0113,-3.1377},
				{0.0200,32.0896,-5.5402,0.0501,0.7127,5.8473,-2.4932,0.0504,0.7200,6.0000,0.0000,0.0507,0.7273,6.1527,2.4932,-3.1375},
				{0.0200,32.0728,-5.5403,0.0667,0.8285,5.7880,-2.9637,0.0672,0.8400,6.0000,0.0000,0.0677,0.8515,6.2120,2.9637,-3.1373},
				{0.0200,32.0536,-5.5403,0.0855,0.9429,5.7195,-3.4228,0.0864,0.9600,6.0000,0.0000,0.0873,0.9771,6.2805,3.4228,-3.1370},
				{0.0200,32.0320,-5.5405,0.1066,1.0557,5.6421,-3.8716,0.1080,1.0800,6.0000,0.0000,0.1094,1.1043,6.3579,3.8716,-3.1365},
				{0.0200,32.0080,-5.5406,0.1300,1.1668,5.5559,-4.3124,0.1320,1.2000,6.0000,0.0000,0.1340,1.2332,6.4441,4.3124,-3.1358},
				{0.0200,31.9816,-5.5407,0.1555,1.2760,5.4609,-4.7491,0.1584,1.3200,6.0000,0.0000,0.1613,1.3640,6.5391,4.7491,-3.1349},
				{0.0200,31.9528,-5.5410,0.1832,1.3832,5.3571,-5.1866,0.1872,1.4400,6.0000,0.0000,0.1912,1.4968,6.6429,5.1866,-3.1338},
				{0.0200,31.9216,-5.5412,0.2129,1.4881,5.2445,-5.6315,0.2184,1.5600,6.0000,0.0000,0.2239,1.6319,6.7555,5.6314,-3.1324},
				{0.0200,31.8880,-5.5416,0.2447,1.5905,5.1227,-6.0915,0.2520,1.6800,6.0000,0.0000,0.2593,1.7695,6.8773,6.0913,-3.1306},
				{0.0200,31.8520,-5.5420,0.2785,1.6904,4.9912,-6.5761,0.2880,1.8000,6.0000,0.0000,0.2975,1.9096,7.0088,6.5758,-3.1284},
				{0.0200,31.8136,-5.5426,0.3143,1.7873,4.8492,-7.0961,0.3264,1.9200,6.0000,0.0000,0.3385,2.0527,7.1507,7.0958,-3.1257},
				{0.0200,31.7728,-5.5433,0.3519,1.8813,4.6960,-7.6642,0.3672,2.0400,6.0000,0.0000,0.3825,2.1987,7.3040,7.6637,-3.1226},
				{0.0200,31.7296,-5.5442,0.3914,1.9719,4.5301,-8.2944,0.4104,2.1600,6.0000,0.0000,0.4294,2.3481,7.4699,8.2937,-3.1188},
				{0.0200,31.6840,-5.5453,0.4325,2.0589,4.3500,-9.0027,0.4560,2.2800,6.0000,0.0000,0.4795,2.5011,7.6499,9.0019,-3.1144},
				{0.0200,31.6361,-5.5467,0.4754,2.1419,4.1539,-9.8073,0.5040,2.4000,6.0000,0.0000,0.5326,2.6581,7.8461,9.8062,-3.1092},
				{0.0200,31.5857,-5.5485,0.5198,2.2207,3.9393,-10.7280,0.5544,2.5200,6.0000,0.0000,0.5890,2.8193,8.0606,10.7265,-3.1032},
				{0.0200,31.5329,-5.5507,0.5657,2.2948,3.7036,-11.7871,0.6072,2.6400,6.0000,0.0000,0.6487,2.9852,8.2963,11.7852,-3.0963},
				{0.0200,31.4778,-5.5534,0.6130,2.3637,3.4434,-13.0089,0.6624,2.7600,6.0000,0.0000,0.7118,3.1563,8.5564,13.0064,-3.0884},
				{0.0200,31.4203,-5.5567,0.6615,2.4268,3.1550,-14.4195,0.7200,2.8800,6.0000,0.0000,0.7785,3.3332,8.8447,14.4163,-3.0793},
				{0.0200,31.3604,-5.5608,0.7112,2.4834,2.8341,-16.0464,0.7800,3.0000,6.0000,0.0000,0.8488,3.5165,9.1656,16.0422,-3.0690},
				{0.0200,31.2982,-5.5657,0.7618,2.5330,2.4757,-17.9168,0.8424,3.1200,6.0000,0.0000,0.9230,3.7070,9.5238,17.9113,-3.0573},
				{0.0200,31.2337,-5.5715,0.8133,2.5745,2.0746,-20.0553,0.9072,3.2400,6.0000,0.0000,1.0011,3.9055,9.9248,20.0482,-3.0440},
				{0.0200,31.1669,-5.5786,0.8654,2.6070,1.6250,-22.4797,0.9744,3.3600,6.0000,0.0000,1.0834,4.1130,10.3742,22.4705,-3.0289},
				{0.0200,31.0978,-5.5870,0.9180,2.6294,1.1212,-25.1937,1.0440,3.4800,6.0000,0.0000,1.1700,4.3305,10.8778,25.1818,-3.0119},
				{0.0200,31.0265,-5.5970,0.9708,2.6405,0.5576,-28.1759,1.1160,3.6000,6.0000,0.0000,1.2611,4.5594,11.4410,28.1606,-2.9927},
				{0.0200,30.9530,-5.6088,1.0236,2.6391,-0.0696,-31.3617,1.1904,3.7200,6.0000,0.0000,1.3572,4.8007,12.0679,31.3421,-2.9711},
				{0.0200,30.8775,-5.6227,1.0761,2.6239,-0.7620,-34.6178,1.2672,3.8400,6.0000,0.0000,1.4583,5.0559,12.7597,34.5926,-2.9468},
				{0.0200,30.8000,-5.6391,1.1280,2.5936,-1.5160,-37.7034,1.3464,3.9600,6.0000,0.0000,1.5648,5.3262,13.5132,37.6716,-2.9194},
				{0.0200,30.7207,-5.6583,1.1789,2.5472,-2.3204,-40.2204,1.4280,4.0800,6.0000,0.0000,1.6771,5.6125,14.3168,40.1806,-2.8888},
				{0.0200,30.6397,-5.6807,1.2286,2.4841,-3.1514,-41.5500,1.5120,4.2000,6.0000,0.0000,1.7954,5.9154,15.1468,41.5011,-2.8545},
				{0.0200,30.5574,-5.7067,1.2767,2.4048,-3.9672,-40.7884,1.5984,4.3200,6.0000,0.0000,1.9201,6.2347,15.9614,40.7300,-2.8162},
				{0.0200,30.4738,-5.7369,1.3229,2.3108,-4.7013,-36.7070,1.6872,4.4400,6.0000,0.0000,2.0514,6.5686,16.6942,36.6400,-2.7736},
				{0.0200,30.3896,-5.7716,1.3670,2.2056,-5.2571,-27.7895,1.7784,4.5600,6.0000,0.0000,2.1897,6.9135,17.2485,27.7174,-2.7265},
				{0.0200,30.3049,-5.8116,1.4089,2.0955,-5.5057,-12.4301,1.8720,4.6800,6.0000,0.0000,2.3350,7.2634,17.4957,12.3603,-2.6748},
				{0.0200,30.2204,-5.8571,1.4487,1.9896,-5.2935,10.6107,1.9680,4.8000,6.0000,0.0000,2.4872,7.6091,17.2824,-10.6664,-2.6186},
				{0.0200,30.1367,-5.9088,1.4867,1.9004,-4.4644,41.4534,2.0664,4.9200,6.0000,0.0000,2.6459,7.9382,16.4528,-41.4787,-2.5582},
				{0.0200,30.0544,-5.9670,1.5236,1.8423,-2.9005,78.1958,2.1672,5.0400,6.0000,0.0000,2.8106,8.2359,14.8894,-78.1727,-2.4943},
				{0.0200,29.9742,-6.0319,1.5602,1.8309,-0.5743,116.3120,2.2704,5.1600,6.0000,0.0000,2.9804,8.4872,12.5648,-116.2271,-2.4277},
				{0.0200,29.8968,-6.1037,1.5978,1.8790,2.4063,149.0309,2.3760,5.2800,6.0000,0.0000,3.1540,8.6790,9.5872,-148.8829,-2.3597},
				{0.0200,29.8228,-6.1824,1.6377,1.9948,5.7887,169.1194,2.4840,5.4000,6.0000,0.0000,3.3300,8.8032,6.2087,-168.9238,-2.2916},
				{0.0200,29.7528,-6.2677,1.6813,2.1792,9.2207,171.5999,2.5944,5.5200,6.0000,0.0000,3.5072,8.8588,2.7810,-171.3869,-2.2248},
				{0.0200,29.6872,-6.3594,1.7298,2.4260,12.3397,155.9502,2.7072,5.6400,6.0000,0.0000,3.6842,8.8521,-0.3341,-155.7550,-2.1605},
				{0.0200,29.6261,-6.4571,1.7842,2.7233,14.8666,126.3426,2.8224,5.7600,6.0000,0.0000,3.8601,8.7949,-2.8580,-126.1931,-2.0998},
				{0.0200,29.5697,-6.5602,1.8454,3.0565,16.6617,89.7558,2.9400,5.8800,6.0000,0.0000,4.0342,8.7019,-4.6513,-89.6648,-2.0433},
				{0.0200,29.5179,-6.6685,1.9136,3.4111,17.7264,53.2333,3.0600,6.0000,6.0000,0.0000,4.2059,8.5876,-5.7153,-53.1988,-1.9915},
				{0.0200,29.4706,-6.7813,1.9891,3.7743,18.1632,21.8417,3.1824,6.1200,6.0000,0.0000,4.3752,8.4646,-6.1523,-21.8517,-1.9446},
				{0.0200,29.4275,-6.8985,2.0718,4.1368,18.1236,-1.9786,3.3072,6.2400,6.0000,0.0000,4.5421,8.3423,-6.1135,1.9392,-1.9026},
				{0.0200,29.3884,-7.0195,2.1617,4.4921,17.7644,-17.9610,3.4344,6.3600,6.0000,0.0000,4.7066,8.2272,-5.7554,17.9060,-1.8652},
				{0.0200,29.3529,-7.1441,2.2584,4.8365,17.2218,-27.1303,3.5640,6.4800,6.0000,0.0000,4.8691,8.1229,-5.2140,27.0700,-1.8324},
				{0.0200,29.3206,-7.2721,2.3618,5.1686,16.6017,-31.0038,3.6960,6.6000,6.0000,0.0000,5.0297,8.0310,-4.5951,30.9447,-1.8037},
				{0.0200,29.2913,-7.4033,2.4715,5.4882,15.9802,-31.0761,3.8304,6.7200,6.0000,0.0000,5.1887,7.9515,-3.9747,31.0219,-1.7791},
				{0.0200,29.2644,-7.5374,2.5874,5.7963,15.4087,-28.5748,3.9672,6.8400,6.0000,0.0000,5.3464,7.8834,-3.4041,28.5264,-1.7582},
				{0.0200,29.2397,-7.6744,2.7093,6.0947,14.9208,-24.3931,4.1064,6.9600,6.0000,0.0000,5.5029,7.8251,-2.9171,24.3509,-1.7409},
				{0.0200,29.2168,-7.8141,2.8371,6.3855,14.5385,-19.1149,4.2480,7.0800,6.0000,0.0000,5.6584,7.7744,-2.5356,19.0779,-1.7270},
				{0.0200,29.1951,-7.9565,2.9705,6.6711,14.2772,-13.0689,4.3920,7.2000,6.0000,0.0000,5.8129,7.7289,-2.2748,13.0360,-1.7165},
				{0.0200,29.1745,-8.1014,3.1096,6.9541,14.1495,-6.3848,4.5384,7.3200,6.0000,0.0000,5.9667,7.6859,-2.1477,6.3542,-1.7091},
				{0.0200,29.1543,-8.2488,3.2543,7.2374,14.1688,0.9649,4.6872,7.4400,6.0000,0.0000,6.1195,7.6426,-2.1676,-0.9948,-1.7051},
				{0.0200,29.1341,-8.3987,3.4048,7.5245,14.3515,9.1369,4.8384,7.5600,6.0000,0.0000,6.2714,7.5955,-2.3510,-9.1685,-1.7044},
				{0.0200,29.1135,-8.5509,3.5612,7.8188,14.7196,18.4061,4.9920,7.6800,6.0000,0.0000,6.4223,7.5411,-2.7199,-18.4422,-1.7072},
				{0.0200,29.0918,-8.7054,3.7237,8.1249,15.3029,29.1645,5.1480,7.8000,6.0000,0.0000,6.5718,7.4751,-3.3040,-29.2092,-1.7137},
				{0.0200,29.0685,-8.8621,3.8926,8.4477,16.1415,41.9271,5.3064,7.9200,6.0000,0.0000,6.7196,7.3922,-4.1438,-41.9860,-1.7242},
				{0.0200,29.0429,-9.0200,4.0676,8.7492,15.0720,-53.4718,5.4664,8.0000,6.0000,0.0000,6.8646,7.2507,-7.0758,-146.6033,-1.7392},
				{0.0200,29.0146,-9.1775,4.2473,8.9861,11.8476,-161.2212,5.6264,8.0000,6.0000,0.0000,7.0049,7.0136,-11.8531,-238.8625,-1.7589},
				{0.0200,28.9828,-9.3343,4.4323,9.2494,13.1629,65.7659,5.7864,8.0000,6.0000,0.0000,7.1399,6.7502,-13.1708,-65.8842,-1.7839},
				{0.0200,28.9467,-9.4901,4.6232,9.5460,14.8312,83.4150,5.9464,8.0000,6.0000,0.0000,7.2690,6.4534,-14.8423,-83.5755,-1.8148},
				{0.0200,28.9052,-9.6447,4.8209,9.8833,16.8628,101.5793,6.1064,8.0000,6.0000,0.0000,7.3913,6.1158,-16.8782,-101.7976,-1.8525},
				{0.0200,28.8573,-9.7973,5.0263,10.2677,19.2202,117.8686,6.2664,8.0000,6.0000,0.0000,7.5059,5.7310,-19.2415,-118.1618,-1.8979},
				{0.0200,28.8020,-9.9474,5.2403,10.7030,21.7648,127.2313,6.4264,8.0000,6.0000,0.0000,7.6118,5.2951,-21.7937,-127.6108,-1.9520},
				{0.0200,28.7379,-10.0940,5.4640,11.1865,24.1750,120.5109,6.5864,8.0000,6.0000,0.0000,7.7080,4.8108,-24.2130,-120.9684,-2.0157},
				{0.0200,28.6638,-10.2358,5.6981,11.7034,25.8482,83.6571,6.7464,8.0000,6.0000,0.0000,7.7939,4.2929,-25.8958,-84.1363,-2.0899},
				{0.0200,28.5788,-10.3713,5.9425,12.2205,25.8518,0.1801,6.9064,8.0000,6.0000,0.0000,7.8694,3.7748,-25.9066,-0.5415,-2.1743},
				{0.0200,28.4821,-10.4986,6.1962,12.6819,23.0696,-139.1075,7.0664,8.0000,6.0000,0.0000,7.9356,3.3123,-23.1247,139.0952,-2.2681},
				{0.0200,28.3734,-10.6160,6.4565,13.0159,16.7015,-318.4032,7.2264,8.0000,6.0000,0.0000,7.9952,2.9774,-16.7451,318.9804,-2.3685},
				{0.0200,28.2533,-10.7216,6.7196,13.1562,7.0157,-484.2925,7.3864,8.0000,6.0000,0.0000,8.0519,2.8367,-7.0349,485.5086,-2.4717},
				{0.0200,28.1230,-10.8144,6.9810,13.0710,-4.2592,-563.7425,7.5464,8.0000,6.0000,0.0000,8.1103,2.9221,4.2709,565.2900,-2.5733},
				{0.0200,27.9842,-10.8938,7.2366,12.7797,-14.5665,-515.3695,7.7064,8.0000,6.0000,0.0000,8.1746,3.2142,14.6051,516.7125,-2.6690},
				{0.0200,27.8387,-10.9602,7.4835,12.3422,-21.8740,-365.3714,7.8664,8.0000,6.0000,0.0000,8.2477,3.6528,21.9275,366.1191,-2.7559},
				{0.0200,27.6883,-11.0146,7.7201,11.8310,-25.5601,-184.3083,8.0264,8.0000,6.0000,0.0000,8.3310,4.1651,25.6161,184.4284,-2.8326},
				{0.0200,27.5343,-11.0580,7.9462,11.3063,-26.2337,-33.6776,8.1864,8.0000,6.0000,0.0000,8.4248,4.6907,26.2838,33.3837,-2.8987},
				{0.0200,27.3780,-11.0920,8.1623,10.8064,-24.9962,61.8759,8.3464,8.0000,6.0000,0.0000,8.5286,5.1915,25.0370,-62.3386,-2.9549},
				{0.0200,27.2201,-11.1179,8.3693,10.3493,-22.8546,107.0807,8.5064,8.0000,6.0000,0.0000,8.6416,5.6492,22.8860,-107.5488,-3.0019},
				{0.0200,27.0612,-11.1370,8.5681,9.9393,-20.5007,117.6911,8.6664,8.0000,6.0000,0.0000,8.7628,6.0597,20.5242,-118.0908,-3.0407},
				{0.0200,26.9018,-11.1505,8.7596,9.5727,-18.3301,108.5293,8.8264,8.0000,6.0000,0.0000,8.8913,6.4266,18.3473,-108.8438,-3.0722},
				{0.0200,26.7421,-11.1595,8.9444,9.2419,-16.5381,89.6019,8.9864,8.0000,6.0000,0.0000,9.0265,6.7576,16.5505,-89.8398,-3.0970},
				{0.0200,26.5822,-11.1651,9.1232,8.9377,-15.2110,66.3546,9.1464,8.0000,6.0000,0.0000,9.1677,7.0620,15.2199,-66.5332,-3.1158},
				{0.0200,26.4222,-11.1681,9.2962,8.6499,-14.3911,40.9967,9.3064,8.0000,6.0000,0.0000,9.3147,7.3500,14.3972,-41.1342,-3.1288},
				{0.0200,26.2622,-11.1695,9.4635,8.3675,-14.1190,13.6037,9.4664,8.0000,6.0000,0.0000,9.4674,7.6324,14.1228,-13.7168,-3.1361},
				{0.0200,26.1022,-11.1701,9.6252,8.0867,-14.0399,3.9568,9.6264,8.0000,6.0000,0.0000,9.6256,7.9133,14.0416,-4.0625,-3.1378},
				{0.0200,25.9422,-11.1707,9.7852,8.0001,-4.3334,485.3212,9.7864,8.0000,6.0000,0.0000,9.7856,7.9999,4.3336,-485.4016,-3.1378},
				{0.0200,25.7822,-11.1713,9.9452,8.0001,0.0032,216.8315,9.9464,8.0000,6.0000,0.0000,9.9456,7.9999,-0.0032,-216.8367,-3.1379},
				{0.0200,25.6222,-11.1719,10.1052,8.0002,0.0029,-0.0147,10.1064,8.0000,6.0000,0.0000,10.1056,7.9998,-0.0029,0.0147,-3.1379},
				{0.0200,25.4622,-11.1725,10.2652,8.0002,0.0026,-0.0143,10.2664,8.0000,6.0000,0.0000,10.2656,7.9998,-0.0026,0.0143,-3.1379},
				{0.0200,25.3022,-11.1731,10.4253,8.0003,0.0023,-0.0138,10.4264,8.0000,6.0000,0.0000,10.4256,7.9997,-0.0023,0.0138,-3.1379},
				{0.0200,25.1422,-11.1737,10.5853,8.0003,0.0021,-0.0134,10.5864,8.0000,6.0000,0.0000,10.5856,7.9997,-0.0021,0.0134,-3.1379},
				{0.0200,24.9822,-11.1743,10.7453,8.0003,0.0018,-0.0129,10.7464,8.0000,6.0000,0.0000,10.7456,7.9997,-0.0018,0.0129,-3.1379},
				{0.0200,24.8222,-11.1749,10.9053,8.0004,0.0015,-0.0125,10.9064,8.0000,6.0000,0.0000,10.9056,7.9996,-0.0015,0.0125,-3.1379},
				{0.0200,24.6622,-11.1755,11.0653,8.0004,0.0013,-0.0120,11.0664,8.0000,6.0000,0.0000,11.0656,7.9996,-0.0013,0.0120,-3.1379},
				{0.0200,24.5022,-11.1761,11.2253,8.0004,0.0011,-0.0116,11.2264,8.0000,6.0000,0.0000,11.2256,7.9996,-0.0011,0.0116,-3.1379},
				{0.0200,24.3422,-11.1767,11.3853,8.0004,0.0009,-0.0111,11.3864,8.0000,6.0000,0.0000,11.3856,7.9996,-0.0009,0.0111,-3.1379},
				{0.0200,24.1822,-11.1773,11.5453,8.0005,0.0006,-0.0107,11.5464,8.0000,6.0000,0.0000,11.5456,7.9995,-0.0006,0.0107,-3.1379},
				{0.0200,24.0222,-11.1779,11.7053,8.0005,0.0004,-0.0102,11.7064,8.0000,6.0000,0.0000,11.7056,7.9995,-0.0004,0.0102,-3.1379},
				{0.0200,23.8622,-11.1785,11.8653,8.0005,0.0002,-0.0098,11.8664,8.0000,6.0000,0.0000,11.8655,7.9995,-0.0002,0.0098,-3.1379},
				{0.0200,23.7022,-11.1790,12.0253,8.0005,0.0001,-0.0093,12.0264,8.0000,6.0000,0.0000,12.0255,7.9995,-0.0001,0.0093,-3.1379},
				{0.0200,23.5422,-11.1796,12.1853,8.0005,-0.0001,-0.0089,12.1864,8.0000,6.0000,0.0000,12.1855,7.9995,0.0001,0.0089,-3.1380},
				{0.0200,23.3822,-11.1802,12.3454,8.0005,-0.0003,-0.0084,12.3464,8.0000,6.0000,0.0000,12.3455,7.9995,0.0003,0.0084,-3.1380},
				{0.0200,23.2222,-11.1808,12.5054,8.0005,-0.0004,-0.0080,12.5064,8.0000,6.0000,0.0000,12.5055,7.9995,0.0004,0.0080,-3.1380},
				{0.0200,23.0622,-11.1814,12.6654,8.0004,-0.0006,-0.0075,12.6664,8.0000,6.0000,0.0000,12.6655,7.9996,0.0006,0.0075,-3.1380},
				{0.0200,22.9022,-11.1819,12.8254,8.0004,-0.0007,-0.0071,12.8264,8.0000,6.0000,0.0000,12.8255,7.9996,0.0007,0.0071,-3.1380},
				{0.0200,22.7422,-11.1825,12.9854,8.0004,-0.0009,-0.0066,12.9864,8.0000,6.0000,0.0000,12.9855,7.9996,0.0009,0.0066,-3.1380},
				{0.0200,22.5822,-11.1831,13.1454,8.0004,-0.0010,-0.0062,13.1464,8.0000,6.0000,0.0000,13.1455,7.9996,0.0010,0.0062,-3.1380},
				{0.0200,22.4222,-11.1837,13.3054,8.0004,-0.0011,-0.0057,13.3064,8.0000,6.0000,0.0000,13.3055,7.9996,0.0011,0.0057,-3.1380},
				{0.0200,22.2622,-11.1842,13.4654,8.0003,-0.0012,-0.0053,13.4664,8.0000,6.0000,0.0000,13.4655,7.9997,0.0012,0.0053,-3.1380},
				{0.0200,22.1022,-11.1848,13.6254,8.0003,-0.0013,-0.0048,13.6264,8.0000,6.0000,0.0000,13.6255,7.9997,0.0013,0.0048,-3.1380},
				{0.0200,21.9422,-11.1854,13.7854,8.0003,-0.0014,-0.0044,13.7864,8.0000,6.0000,0.0000,13.7854,7.9997,0.0014,0.0044,-3.1380},
				{0.0200,21.7822,-11.1859,13.9454,8.0003,-0.0015,-0.0039,13.9464,8.0000,6.0000,0.0000,13.9454,7.9997,0.0015,0.0039,-3.1380},
				{0.0200,21.6222,-11.1865,14.1054,8.0002,-0.0015,-0.0035,14.1064,8.0000,6.0000,0.0000,14.1054,7.9998,0.0015,0.0035,-3.1380},
				{0.0200,21.4622,-11.1871,14.2654,8.0002,-0.0016,-0.0030,14.2664,8.0000,6.0000,0.0000,14.2654,7.9998,0.0016,0.0030,-3.1380},
				{0.0200,21.3023,-11.1876,14.4254,8.0002,-0.0017,-0.0026,14.4264,8.0000,6.0000,0.0000,14.4254,7.9998,0.0017,0.0026,-3.1381},
				{0.0200,21.1423,-11.1882,14.5854,8.0001,-0.0017,-0.0021,14.5864,8.0000,6.0000,0.0000,14.5854,7.9999,0.0017,0.0021,-3.1381},
				{0.0200,20.9823,-11.1888,14.7454,8.0001,-0.0017,-0.0017,14.7464,8.0000,6.0000,0.0000,14.7454,7.9999,0.0017,0.0017,-3.1381},
				{0.0200,20.8223,-11.1893,14.9054,8.0001,-0.0018,-0.0012,14.9064,8.0000,6.0000,0.0000,14.9054,7.9999,0.0018,0.0012,-3.1381},
				{0.0200,20.6623,-11.1899,15.0654,8.0000,-0.0018,-0.0008,15.0664,8.0000,6.0000,0.0000,15.0654,8.0000,0.0018,0.0008,-3.1381},
				{0.0200,20.5023,-11.1905,15.2254,8.0000,-0.0018,-0.0003,15.2264,8.0000,6.0000,0.0000,15.2254,8.0000,0.0018,0.0003,-3.1381},
				{0.0200,20.3423,-11.1910,15.3854,8.0000,-0.0018,0.0001,15.3864,8.0000,6.0000,0.0000,15.3854,8.0000,0.0018,-0.0001,-3.1381},
				{0.0200,20.1847,-11.1916,15.5430,7.8799,-6.0017,-299.9957,15.5440,7.8800,-6.0000,0.0000,15.5430,7.8801,-5.9983,-300.0043,-3.1381},
				{0.0200,20.0295,-11.1921,15.6982,7.7599,-6.0016,0.0049,15.6992,7.7600,-6.0000,0.0000,15.6982,7.7601,-5.9984,-0.0049,-3.1381},
				{0.0200,19.8767,-11.1927,15.8510,7.6399,-6.0015,0.0051,15.8520,7.6400,-6.0000,0.0000,15.8510,7.6401,-5.9985,-0.0051,-3.1380},
				{0.0200,19.7263,-11.1932,16.0014,7.5198,-6.0014,0.0053,16.0024,7.5200,-6.0000,0.0000,16.0014,7.5202,-5.9986,-0.0053,-3.1380},
				{0.0200,19.5783,-11.1937,16.1494,7.3998,-6.0013,0.0054,16.1504,7.4000,-6.0000,0.0000,16.1494,7.4002,-5.9987,-0.0054,-3.1380},
				{0.0200,19.4327,-11.1943,16.2950,7.2798,-6.0012,0.0055,16.2960,7.2800,-6.0000,0.0000,16.2950,7.2802,-5.9988,-0.0055,-3.1380},
				{0.0200,19.2895,-11.1948,16.4382,7.1598,-6.0011,0.0056,16.4392,7.1600,-6.0000,0.0000,16.4382,7.1602,-5.9989,-0.0056,-3.1380},
				{0.0200,19.1487,-11.1953,16.5790,7.0397,-6.0009,0.0056,16.5800,7.0400,-6.0000,0.0000,16.5791,7.0403,-5.9991,-0.0056,-3.1380},
				{0.0200,19.0103,-11.1958,16.7174,6.9197,-6.0008,0.0055,16.7184,6.9200,-6.0000,0.0000,16.7175,6.9203,-5.9992,-0.0055,-3.1380},
				{0.0200,18.8743,-11.1962,16.8534,6.7997,-6.0007,0.0055,16.8544,6.8000,-6.0000,0.0000,16.8535,6.8003,-5.9993,-0.0055,-3.1380},
				{0.0200,18.7407,-11.1967,16.9870,6.6797,-6.0006,0.0054,16.9880,6.6800,-6.0000,0.0000,16.9871,6.6803,-5.9994,-0.0054,-3.1380},
				{0.0200,18.6095,-11.1972,17.1182,6.5597,-6.0005,0.0052,17.1192,6.5600,-6.0000,0.0000,17.1183,6.5603,-5.9995,-0.0052,-3.1380},
				{0.0200,18.4807,-11.1977,17.2470,6.4397,-6.0004,0.0051,17.2480,6.4400,-6.0000,0.0000,17.2471,6.4403,-5.9996,-0.0051,-3.1380},
				{0.0200,18.3543,-11.1981,17.3734,6.3197,-6.0003,0.0049,17.3744,6.3200,-6.0000,0.0000,17.3735,6.3203,-5.9997,-0.0049,-3.1380},
				{0.0200,18.2303,-11.1986,17.4974,6.1997,-6.0002,0.0047,17.4984,6.2000,-6.0000,0.0000,17.4975,6.2003,-5.9998,-0.0047,-3.1380},
				{0.0200,18.1087,-11.1990,17.6190,6.0797,-6.0001,0.0045,17.6200,6.0800,-6.0000,0.0000,17.6191,6.0803,-5.9999,-0.0045,-3.1380},
				{0.0200,17.9895,-11.1994,17.7382,5.9597,-6.0000,0.0043,17.7392,5.9600,-6.0000,0.0000,17.7383,5.9603,-6.0000,-0.0043,-3.1380},
				{0.0200,17.8727,-11.1999,17.8550,5.8397,-6.0000,0.0040,17.8560,5.8400,-6.0000,0.0000,17.8551,5.8403,-6.0000,-0.0040,-3.1380},
				{0.0200,17.7583,-11.2003,17.9693,5.7197,-5.9999,0.0038,17.9704,5.7200,-6.0000,0.0000,17.9695,5.7203,-6.0001,-0.0038,-3.1380},
				{0.0200,17.6463,-11.2007,18.0813,5.5997,-5.9998,0.0035,18.0824,5.6000,-6.0000,0.0000,18.0815,5.6003,-6.0002,-0.0035,-3.1380},
				{0.0200,17.5367,-11.2011,18.1909,5.4797,-5.9997,0.0032,18.1920,5.4800,-6.0000,0.0000,18.1911,5.4803,-6.0003,-0.0032,-3.1379},
				{0.0200,17.4295,-11.2015,18.2981,5.3597,-5.9997,0.0030,18.2992,5.3600,-6.0000,0.0000,18.2983,5.3603,-6.0003,-0.0030,-3.1379},
				{0.0200,17.3247,-11.2019,18.4029,5.2397,-5.9996,0.0027,18.4040,5.2400,-6.0000,0.0000,18.4031,5.2403,-6.0004,-0.0027,-3.1379},
				{0.0200,17.2223,-11.2022,18.5053,5.1197,-5.9996,0.0024,18.5064,5.1200,-6.0000,0.0000,18.5056,5.1203,-6.0004,-0.0024,-3.1379},
				{0.0200,17.1223,-11.2026,18.6053,4.9997,-5.9995,0.0022,18.6064,5.0000,-6.0000,0.0000,18.6056,5.0003,-6.0005,-0.0022,-3.1379},
				{0.0200,17.0247,-11.2030,18.7029,4.8797,-5.9995,0.0019,18.7040,4.8800,-6.0000,0.0000,18.7032,4.8803,-6.0005,-0.0019,-3.1379},
				{0.0200,16.9295,-11.2033,18.7981,4.7597,-5.9995,0.0017,18.7992,4.7600,-6.0000,0.0000,18.7984,4.7603,-6.0005,-0.0017,-3.1379},
				{0.0200,16.8367,-11.2036,18.8909,4.6397,-5.9994,0.0014,18.8920,4.6400,-6.0000,0.0000,18.8912,4.6403,-6.0006,-0.0014,-3.1379},
				{0.0200,16.7463,-11.2040,18.9813,4.5198,-5.9994,0.0011,18.9824,4.5200,-6.0000,0.0000,18.9816,4.5202,-6.0006,-0.0011,-3.1379},
				{0.0200,16.6583,-11.2043,19.0693,4.3998,-5.9994,0.0009,19.0704,4.4000,-6.0000,0.0000,19.0696,4.4002,-6.0006,-0.0009,-3.1379},
				{0.0200,16.5727,-11.2046,19.1549,4.2798,-5.9994,0.0007,19.1560,4.2800,-6.0000,0.0000,19.1552,4.2802,-6.0006,-0.0007,-3.1379},
				{0.0200,16.4895,-11.2049,19.2381,4.1598,-5.9994,0.0005,19.2392,4.1600,-6.0000,0.0000,19.2384,4.1602,-6.0006,-0.0005,-3.1379},
				{0.0200,16.4087,-11.2052,19.3189,4.0398,-5.9994,0.0002,19.3200,4.0400,-6.0000,0.0000,19.3192,4.0402,-6.0006,-0.0002,-3.1379},
				{0.0200,16.3303,-11.2055,19.3973,3.9198,-5.9994,0.0000,19.3984,3.9200,-6.0000,0.0000,19.3976,3.9202,-6.0006,-0.0000,-3.1379},
				{0.0200,16.2543,-11.2058,19.4733,3.7998,-5.9994,-0.0002,19.4744,3.8000,-6.0000,0.0000,19.4736,3.8002,-6.0006,0.0002,-3.1379},
				{0.0200,16.1807,-11.2061,19.5469,3.6798,-5.9994,-0.0003,19.5480,3.6800,-6.0000,0.0000,19.5472,3.6802,-6.0006,0.0003,-3.1379},
				{0.0200,16.1095,-11.2063,19.6181,3.5599,-5.9994,-0.0005,19.6192,3.5600,-6.0000,0.0000,19.6184,3.5601,-6.0006,0.0005,-3.1379},
				{0.0200,16.0407,-11.2066,19.6869,3.4399,-5.9994,-0.0007,19.6880,3.4400,-6.0000,0.0000,19.6872,3.4401,-6.0006,0.0007,-3.1379},
				{0.0200,15.9743,-11.2068,19.7533,3.3199,-5.9994,-0.0008,19.7544,3.3200,-6.0000,0.0000,19.7536,3.3201,-6.0006,0.0008,-3.1379},
				{0.0200,15.9103,-11.2071,19.8173,3.1999,-5.9994,-0.0009,19.8184,3.2000,-6.0000,0.0000,19.8176,3.2001,-6.0006,0.0009,-3.1379},
				{0.0200,15.8487,-11.2073,19.8789,3.0799,-5.9995,-0.0010,19.8800,3.0800,-6.0000,0.0000,19.8792,3.0801,-6.0005,0.0010,-3.1379},
				{0.0200,15.7895,-11.2075,19.9380,2.9599,-5.9995,-0.0011,19.9392,2.9600,-6.0000,0.0000,19.9384,2.9601,-6.0005,0.0011,-3.1379},
				{0.0200,15.7327,-11.2077,19.9948,2.8399,-5.9995,-0.0012,19.9960,2.8400,-6.0000,0.0000,19.9952,2.8401,-6.0005,0.0012,-3.1379},
				{0.0200,15.6783,-11.2079,20.0492,2.7199,-5.9995,-0.0013,20.0504,2.7200,-6.0000,0.0000,20.0496,2.7201,-6.0005,0.0013,-3.1379},
				{0.0200,15.6263,-11.2081,20.1012,2.5999,-5.9996,-0.0014,20.1024,2.6000,-6.0000,0.0000,20.1016,2.6001,-6.0004,0.0014,-3.1379},
				{0.0200,15.5767,-11.2083,20.1508,2.4799,-5.9996,-0.0014,20.1520,2.4800,-6.0000,0.0000,20.1512,2.4801,-6.0004,0.0014,-3.1379},
				{0.0200,15.5295,-11.2085,20.1980,2.3600,-5.9996,-0.0014,20.1992,2.3600,-6.0000,0.0000,20.1984,2.3600,-6.0004,0.0014,-3.1379},
				{0.0200,15.4847,-11.2087,20.2428,2.2400,-5.9996,-0.0015,20.2440,2.2400,-6.0000,0.0000,20.2432,2.2400,-6.0004,0.0015,-3.1379},
				{0.0200,15.4423,-11.2088,20.2852,2.1200,-5.9997,-0.0015,20.2864,2.1200,-6.0000,0.0000,20.2856,2.1200,-6.0003,0.0015,-3.1378},
				{0.0200,15.4023,-11.2090,20.3252,2.0000,-5.9997,-0.0015,20.3264,2.0000,-6.0000,0.0000,20.3256,2.0000,-6.0003,0.0015,-3.1378},
				{0.0200,15.3647,-11.2091,20.3628,1.8800,-5.9997,-0.0015,20.3640,1.8800,-6.0000,0.0000,20.3632,1.8800,-6.0003,0.0015,-3.1378},
				{0.0200,15.3295,-11.2093,20.3980,1.7600,-5.9998,-0.0014,20.3992,1.7600,-6.0000,0.0000,20.3984,1.7600,-6.0002,0.0014,-3.1378},
				{0.0200,15.2967,-11.2094,20.4308,1.6400,-5.9998,-0.0014,20.4320,1.6400,-6.0000,0.0000,20.4312,1.6400,-6.0002,0.0014,-3.1378},
				{0.0200,15.2663,-11.2095,20.4612,1.5200,-5.9998,-0.0013,20.4624,1.5200,-6.0000,0.0000,20.4616,1.5200,-6.0002,0.0013,-3.1378},
				{0.0200,15.2383,-11.2096,20.4892,1.4000,-5.9998,-0.0013,20.4904,1.4000,-6.0000,0.0000,20.4896,1.4000,-6.0002,0.0013,-3.1378},
				{0.0200,15.2127,-11.2097,20.5148,1.2800,-5.9999,-0.0012,20.5160,1.2800,-6.0000,0.0000,20.5152,1.2800,-6.0001,0.0012,-3.1378},
				{0.0200,15.1895,-11.2098,20.5380,1.1600,-5.9999,-0.0012,20.5392,1.1600,-6.0000,0.0000,20.5384,1.1600,-6.0001,0.0012,-3.1378},
				{0.0200,15.1687,-11.2099,20.5588,1.0400,-5.9999,-0.0011,20.5600,1.0400,-6.0000,0.0000,20.5592,1.0400,-6.0001,0.0011,-3.1378},
				{0.0200,15.1503,-11.2099,20.5772,0.9200,-5.9999,-0.0010,20.5784,0.9200,-6.0000,0.0000,20.5776,0.9200,-6.0001,0.0010,-3.1378},
				{0.0200,15.1343,-11.2100,20.5932,0.8000,-6.0000,-0.0009,20.5944,0.8000,-6.0000,0.0000,20.5936,0.8000,-6.0000,0.0009,-3.1378},
				{0.0200,15.1300,-11.2100,20.5975,0.2145,-29.2727,-1163.6372,20.5987,0.6800,-6.0000,0.0000,20.5979,0.2145,-29.2727,-1163.6350,-3.1378},
				{0.0200,15.1300,-11.2100,20.5975,0.0000,-10.7273,927.2710,20.5987,0.5600,-6.0000,0.0000,20.5979,0.0000,-10.7273,927.2734,-3.1378},
				{0.0200,15.1300,-11.2100,20.5975,0.0000,0.0000,536.3638,20.5987,0.4400,-6.0000,0.0000,20.5979,0.0000,0.0000,536.3640,-3.1378},
				{0.0200,15.1300,-11.2100,20.5975,0.0000,0.0000,0.0000,20.5987,0.3200,-6.0000,0.0000,20.5979,0.0000,0.0000,0.0000,-3.1378},
				{0.0200,15.1300,-11.2100,20.5975,0.0000,0.0000,0.0000,20.5987,0.2000,-6.0000,0.0000,20.5979,0.0000,0.0000,0.0000,-3.1378},
				{0.0200,15.1300,-11.2100,20.5975,0.0000,0.0000,0.0000,20.5987,0.0800,-6.0000,0.0000,20.5979,0.0000,0.0000,0.0000,-3.1378},
				{0.0200,15.1300,-11.2100,20.5975,0.0000,0.0000,0.0000,20.5987,-0.0400,-6.0000,0.0000,20.5979,0.0000,0.0000,0.0000,-3.1378},

	    };

	@Override
	public double[][] getPath() {
	    return points;
	}
}