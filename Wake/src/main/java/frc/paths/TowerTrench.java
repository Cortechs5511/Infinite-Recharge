package frc.paths;

import com.team319.trajectory.Path;

public class TowerTrench extends Path {
   // dt,x,y,left.pos,left.vel,left.acc,left.jerk,center.pos,center.vel,center.acc,center.jerk,right.pos,right.vel,right.acc,right.jerk,heading
	private static final double[][] points = {
				{0.0200,32.2876,-5.3500,0.0024,0.1200,6.0000,0.0000,0.0024,0.1200,6.0000,0.0000,0.0024,0.1200,6.0000,0.0000,-3.1416},
				{0.0200,32.2828,-5.3500,0.0072,0.2398,5.9885,-0.5762,0.0072,0.2400,6.0000,0.0000,0.0072,0.2402,6.0115,0.5762,-3.1416},
				{0.0200,32.2756,-5.3500,0.0144,0.3592,5.9727,-0.7895,0.0144,0.3600,6.0000,0.0000,0.0144,0.3608,6.0273,0.7895,-3.1416},
				{0.0200,32.2660,-5.3500,0.0239,0.4782,5.9470,-1.2862,0.0240,0.4800,6.0000,0.0000,0.0241,0.4818,6.0530,1.2862,-3.1415},
				{0.0200,32.2540,-5.3500,0.0359,0.5964,5.9129,-1.7038,0.0360,0.6000,6.0000,0.0000,0.0361,0.6036,6.0871,1.7038,-3.1415},
				{0.0200,32.2396,-5.3500,0.0501,0.7138,5.8706,-2.1128,0.0504,0.7200,6.0000,0.0000,0.0507,0.7262,6.1294,2.1128,-3.1413},
				{0.0200,32.2228,-5.3500,0.0668,0.8302,5.8204,-2.5119,0.0672,0.8400,6.0000,0.0000,0.0676,0.8498,6.1796,2.5119,-3.1411},
				{0.0200,32.2036,-5.3500,0.0857,0.9455,5.7624,-2.9006,0.0864,0.9600,6.0000,0.0000,0.0871,0.9745,6.2376,2.9006,-3.1409},
				{0.0200,32.1820,-5.3500,0.1069,1.0594,5.6968,-3.2792,0.1080,1.0800,6.0000,0.0000,0.1091,1.1006,6.3032,3.2792,-3.1404},
				{0.0200,32.1580,-5.3501,0.1303,1.1719,5.6238,-3.6487,0.1320,1.2000,6.0000,0.0000,0.1337,1.2281,6.3762,3.6487,-3.1399},
				{0.0200,32.1316,-5.3501,0.1559,1.2828,5.5436,-4.0107,0.1584,1.3200,6.0000,0.0000,0.1609,1.3572,6.4564,4.0107,-3.1391},
				{0.0200,32.1028,-5.3502,0.1838,1.3919,5.4563,-4.3679,0.1872,1.4400,6.0000,0.0000,0.1906,1.4881,6.5437,4.3679,-3.1382},
				{0.0200,32.0716,-5.3503,0.2138,1.4991,5.3618,-4.7238,0.2184,1.5600,6.0000,0.0000,0.2230,1.6209,6.6382,4.7237,-3.1370},
				{0.0200,32.0380,-5.3505,0.2459,1.6043,5.2601,-5.0826,0.2520,1.6800,6.0000,0.0000,0.2581,1.7557,6.7399,5.0825,-3.1354},
				{0.0200,32.0020,-5.3508,0.2800,1.7074,5.1511,-5.4495,0.2880,1.8000,6.0000,0.0000,0.2960,1.8926,6.8489,5.4494,-3.1336},
				{0.0200,31.9636,-5.3511,0.3162,1.8080,5.0345,-5.8305,0.3264,1.9200,6.0000,0.0000,0.3366,2.0320,6.9655,5.8302,-3.1314},
				{0.0200,31.9228,-5.3516,0.3543,1.9062,4.9099,-6.2320,0.3672,2.0400,6.0000,0.0000,0.3801,2.1738,7.0901,6.2317,-3.1287},
				{0.0200,31.8796,-5.3522,0.3943,2.0018,4.7766,-6.6617,0.4104,2.1600,6.0000,0.0000,0.4265,2.3182,7.2233,6.6613,-3.1255},
				{0.0200,31.8340,-5.3530,0.4362,2.0945,4.6341,-7.1276,0.4560,2.2800,6.0000,0.0000,0.4758,2.4655,7.3659,7.1270,-3.1218},
				{0.0200,31.7860,-5.3541,0.4799,2.1841,4.4813,-7.6383,0.5040,2.4000,6.0000,0.0000,0.5281,2.6159,7.5186,7.6376,-3.1175},
				{0.0200,31.7356,-5.3554,0.5253,2.2704,4.3173,-8.2032,0.5544,2.5200,6.0000,0.0000,0.5835,2.7696,7.6827,8.2022,-3.1125},
				{0.0200,31.6829,-5.3571,0.5724,2.3532,4.1406,-8.8318,0.6072,2.6400,6.0000,0.0000,0.6420,2.9267,7.8593,8.8305,-3.1068},
				{0.0200,31.6277,-5.3592,0.6210,2.4322,3.9500,-9.5338,0.6624,2.7600,6.0000,0.0000,0.7038,3.0877,8.0499,9.5323,-3.1002},
				{0.0200,31.5702,-5.3618,0.6712,2.5071,3.7436,-10.3189,0.7200,2.8800,6.0000,0.0000,0.7688,3.2529,8.2562,10.3168,-3.0927},
				{0.0200,31.5103,-5.3650,0.7227,2.5775,3.5197,-11.1957,0.7800,3.0000,6.0000,0.0000,0.8373,3.4225,8.4801,11.1931,-3.0843},
				{0.0200,31.4480,-5.3689,0.7756,2.6430,3.2762,-12.1713,0.8424,3.1200,6.0000,0.0000,0.9092,3.5969,8.7235,12.1681,-3.0748},
				{0.0200,31.3833,-5.3735,0.8296,2.7033,3.0112,-13.2503,0.9072,3.2400,6.0000,0.0000,0.9848,3.7767,8.9884,13.2461,-3.0640},
				{0.0200,31.3164,-5.3791,0.8848,2.7577,2.7226,-14.4318,0.9744,3.3600,6.0000,0.0000,1.0640,3.9622,9.2769,14.4267,-3.0520},
				{0.0200,31.2471,-5.3858,0.9409,2.8059,2.4084,-15.7083,1.0440,3.4800,6.0000,0.0000,1.1471,4.1541,9.5910,15.7018,-3.0385},
				{0.0200,31.1755,-5.3938,0.9978,2.8472,2.0672,-17.0604,1.1160,3.6000,6.0000,0.0000,1.2341,4.3527,9.9320,17.0525,-3.0234},
				{0.0200,31.1017,-5.4031,1.0555,2.8812,1.6982,-18.4528,1.1904,3.7200,6.0000,0.0000,1.3253,4.5587,10.3009,18.4428,-3.0067},
				{0.0200,31.0257,-5.4142,1.1136,2.9072,1.3017,-19.8258,1.2672,3.8400,6.0000,0.0000,1.4208,4.7727,10.6971,19.8136,-2.9880},
				{0.0200,30.9476,-5.4271,1.1721,2.9248,0.8799,-21.0874,1.3464,3.9600,6.0000,0.0000,1.5207,4.9950,11.1186,21.0725,-2.9673},
				{0.0200,30.8674,-5.4421,1.2308,2.9336,0.4379,-22.1006,1.4280,4.0800,6.0000,0.0000,1.6252,5.2262,11.5602,22.0826,-2.9444},
				{0.0200,30.7852,-5.4596,1.2894,2.9333,-0.0155,-22.6712,1.5120,4.2000,6.0000,0.0000,1.7345,5.4665,12.0132,22.6497,-2.9190},
				{0.0200,30.7012,-5.4799,1.3479,2.9239,-0.4662,-22.5339,1.5984,4.3200,6.0000,0.0000,1.8488,5.7158,12.4634,22.5086,-2.8911},
				{0.0200,30.6156,-5.5032,1.4060,2.9061,-0.8931,-21.3435,1.6872,4.4400,6.0000,0.0000,1.9683,5.9736,12.8897,21.3145,-2.8605},
				{0.0200,30.5284,-5.5299,1.4637,2.8807,-1.2666,-18.6761,1.7784,4.5600,6.0000,0.0000,2.0931,6.2388,13.2626,18.6442,-2.8269},
				{0.0200,30.4399,-5.5605,1.5207,2.8498,-1.5476,-14.0516,1.8720,4.6800,6.0000,0.0000,2.2233,6.5097,13.5429,14.0177,-2.7903},
				{0.0200,30.3505,-5.5953,1.5770,2.8160,-1.6874,-6.9894,1.9680,4.8000,6.0000,0.0000,2.3590,6.7833,13.6821,6.9562,-2.7506},
				{0.0200,30.2603,-5.6347,1.6326,2.7835,-1.6297,2.8864,2.0664,4.9200,6.0000,0.0000,2.5001,7.0558,13.6237,-2.9156,-2.7079},
				{0.0200,30.1698,-5.6792,1.6878,2.7571,-1.3158,15.6928,2.1672,5.0400,6.0000,0.0000,2.6465,7.3220,13.3095,-15.7128,-2.6622},
				{0.0200,30.0794,-5.7289,1.7427,2.7433,-0.6939,31.0988,2.2704,5.1600,6.0000,0.0000,2.7980,7.5757,12.6874,-31.1042,-2.6139},
				{0.0200,29.9896,-5.7844,1.7976,2.7486,0.2693,48.1603,2.3760,5.2800,6.0000,0.0000,2.9542,7.8102,11.7245,-48.1456,-2.5633},
				{0.0200,29.9007,-5.8458,1.8532,2.7801,1.5747,65.2662,2.4840,5.4000,6.0000,0.0000,3.1146,8.0186,10.4199,-65.2275,-2.5109},
				{0.0200,29.8134,-5.9132,1.9101,2.8438,3.1806,80.2944,2.5944,5.5200,6.0000,0.0000,3.2785,8.1949,8.8153,-80.2311,-2.4574},
				{0.0200,29.7279,-5.9869,1.9690,2.9438,5.0009,91.0166,2.7072,5.6400,6.0000,0.0000,3.4452,8.3349,6.9967,-90.9326,-2.4034},
				{0.0200,29.6448,-6.0666,2.0306,3.0821,6.9143,95.6685,2.8224,5.7600,6.0000,0.0000,3.6139,8.4366,5.0852,-95.5718,-2.3499},
				{0.0200,29.5645,-6.1525,2.0958,3.2577,8.7838,93.4785,2.9400,5.8800,6.0000,0.0000,3.7840,8.5009,3.2176,-93.3800,-2.2974},
				{0.0200,29.4871,-6.2441,2.1651,3.4674,10.4822,84.9165,3.0600,6.0000,6.0000,0.0000,3.9546,8.5313,1.5211,-84.8271,-2.2468},
				{0.0200,29.4129,-6.3415,2.2392,3.7056,11.9130,71.5403,3.1824,6.1200,6.0000,0.0000,4.1252,8.5332,0.0917,-71.4684,-2.1985},
				{0.0200,29.3419,-6.4441,2.3186,3.9661,13.0233,55.5169,3.3072,6.2400,6.0000,0.0000,4.2955,8.5128,-1.0176,-55.4670,-2.1530},
				{0.0200,29.2743,-6.5518,2.4034,4.2422,13.8041,39.0421,3.4344,6.3600,6.0000,0.0000,4.4650,8.4769,-1.7979,-39.0148,-2.1107},
				{0.0200,29.2099,-6.6643,2.4940,4.5278,14.2818,23.8843,3.5640,6.4800,6.0000,0.0000,4.6337,8.4314,-2.2754,-23.8768,-2.0717},
				{0.0200,29.1486,-6.7812,2.5903,4.8179,14.5052,11.1683,3.6960,6.6000,6.0000,0.0000,4.8013,8.3814,-2.4990,-11.1763,-2.0360},
				{0.0200,29.0903,-6.9023,2.6925,5.1086,14.5329,1.3854,3.8304,6.7200,6.0000,0.0000,4.9679,8.3308,-2.5271,-1.4042,-2.0038},
				{0.0200,29.0347,-7.0273,2.8004,5.3971,14.4237,-5.4601,3.9672,6.8400,6.0000,0.0000,5.1336,8.2825,-2.4184,5.4350,-1.9749},
				{0.0200,28.9817,-7.1560,2.9141,5.6817,14.2304,-9.6629,4.1064,6.9600,6.0000,0.0000,5.2983,8.2380,-2.2257,9.6345,-1.9494},
				{0.0200,28.9309,-7.2881,3.0333,5.9616,13.9974,-11.6507,4.2480,7.0800,6.0000,0.0000,5.4623,8.1981,-1.9932,11.6215,-1.9270},
				{0.0200,28.8820,-7.4236,3.1580,6.2368,13.7601,-11.8673,4.3920,7.2000,6.0000,0.0000,5.6255,8.1630,-1.7565,11.8389,-1.9078},
				{0.0200,28.8347,-7.5622,3.2882,6.5077,13.5460,-10.7045,4.5384,7.3200,6.0000,0.0000,5.7882,8.1321,-1.5429,10.6773,-1.8915},
				{0.0200,28.7888,-7.7037,3.4237,6.7753,13.3766,-8.4698,4.6872,7.4400,6.0000,0.0000,5.9503,8.1046,-1.3740,8.4442,-1.8782},
				{0.0200,28.7438,-7.8481,3.5645,7.0406,13.2690,-5.3797,4.8384,7.5600,6.0000,0.0000,6.1119,8.0793,-1.2669,5.3552,-1.8678},
				{0.0200,28.6995,-7.9951,3.7106,7.3054,13.2378,-1.5626,4.9920,7.6800,6.0000,0.0000,6.2729,8.0546,-1.2361,1.5387,-1.8603},
				{0.0200,28.6553,-8.1447,3.8620,7.5713,13.2964,2.9317,5.1480,7.8000,6.0000,0.0000,6.4335,8.0287,-1.2953,-2.9560,-1.8558},
				{0.0200,28.6109,-8.2968,4.0188,7.8405,13.4588,8.1232,5.3064,7.9200,6.0000,0.0000,6.5935,7.9995,-1.4583,-8.1492,-1.8542},
				{0.0200,28.5661,-8.4504,4.1803,8.0746,11.7025,-87.8193,5.4664,8.0000,6.0000,0.0000,6.7520,7.9254,-3.7025,-112.2100,-1.8557},
				{0.0200,28.5208,-8.6038,4.3450,8.2315,7.8454,-192.8523,5.6264,8.0000,6.0000,0.0000,6.9074,7.7685,-7.8461,-207.1802,-1.8603},
				{0.0200,28.4746,-8.7570,4.5128,8.3923,8.0441,9.9320,5.7864,8.0000,6.0000,0.0000,7.0595,7.6076,-8.0454,-9.9669,-1.8681},
				{0.0200,28.4269,-8.9097,4.6840,8.5600,8.3806,16.8284,5.9464,8.0000,6.0000,0.0000,7.2083,7.4400,-8.3828,-16.8679,-1.8793},
				{0.0200,28.3773,-9.0618,4.8588,8.7371,8.8594,23.9403,6.1064,8.0000,6.0000,0.0000,7.3536,7.2627,-8.8625,-23.9871,-1.8941},
				{0.0200,28.3251,-9.2131,5.0373,8.9268,9.4845,31.2538,6.2664,8.0000,6.0000,0.0000,7.4951,7.0729,-9.4887,-31.3110,-1.9126},
				{0.0200,28.2698,-9.3632,5.2199,9.1320,10.2569,38.6186,6.4264,8.0000,6.0000,0.0000,7.6324,6.8677,-10.2625,-38.6897,-1.9353},
				{0.0200,28.2108,-9.5119,5.4070,9.3554,11.1700,45.6555,6.5864,8.0000,6.0000,0.0000,7.7653,6.6441,-11.1774,-45.7445,-1.9624},
				{0.0200,28.1474,-9.6589,5.5990,9.5994,12.2024,51.6212,6.7464,8.0000,6.0000,0.0000,7.8933,6.3999,-12.2120,-51.7317,-1.9944},
				{0.0200,28.0790,-9.8035,5.7963,9.8656,13.3070,55.2274,6.9064,8.0000,6.0000,0.0000,8.0160,6.1335,-13.3193,-55.3617,-2.0317},
				{0.0200,28.0049,-9.9453,5.9994,10.1535,14.3958,54.4420,7.0664,8.0000,6.0000,0.0000,8.1329,5.8453,-14.4112,-54.5989,-2.0748},
				{0.0200,27.9243,-10.0834,6.2086,10.4599,15.3231,46.3652,7.2264,8.0000,6.0000,0.0000,8.2436,5.5384,-15.3420,-46.5369,-2.1240},
				{0.0200,27.8365,-10.2172,6.4242,10.7774,15.8709,27.3907,7.3864,8.0000,6.0000,0.0000,8.3480,5.2206,-15.8931,-27.5572,-2.1796},
				{0.0200,27.7411,-10.3456,6.6460,11.0924,15.7508,-6.0039,7.5464,8.0000,6.0000,0.0000,8.4461,4.9051,-15.7756,5.8784,-2.2415},
				{0.0200,27.6375,-10.4675,6.8737,11.3852,14.6410,-55.4912,7.7064,8.0000,6.0000,0.0000,8.5384,4.6117,-14.6664,55.4584,-2.3092},
				{0.0200,27.5257,-10.5819,7.1063,11.6307,12.2756,-118.2702,7.8664,8.0000,6.0000,0.0000,8.6257,4.3658,-12.2987,118.3858,-2.3819},
				{0.0200,27.4056,-10.6876,7.3424,11.8023,8.5788,-184.8419,8.0264,8.0000,6.0000,0.0000,8.7096,4.1939,-8.5959,185.1406,-2.4580},
				{0.0200,27.2778,-10.7837,7.5799,11.8780,3.7858,-239.6504,8.1864,8.0000,6.0000,0.0000,8.7919,4.1180,-3.7936,240.1150,-2.5356},
				{0.0200,27.1429,-10.8697,7.8169,11.8471,-1.5425,-266.4115,8.3464,8.0000,6.0000,0.0000,8.8749,4.1489,1.5457,266.9611,-2.6126},
				{0.0200,27.0019,-10.9452,8.0511,11.7138,-6.6671,-256.2340,8.5064,8.0000,6.0000,0.0000,8.9606,4.2825,6.6807,256.7498,-2.6869},
				{0.0200,26.8557,-11.0103,8.2811,11.4953,-10.9228,-212.7852,8.6664,8.0000,6.0000,0.0000,9.0506,4.5014,10.9439,213.1643,-2.7569},
				{0.0200,26.7056,-11.0655,8.5054,11.2168,-13.9251,-150.1130,8.8264,8.0000,6.0000,0.0000,9.1462,4.7804,13.9501,150.3091,-2.8213},
				{0.0200,26.5523,-11.1113,8.7235,10.9043,-15.6257,-85.0287,8.9864,8.0000,6.0000,0.0000,9.2481,5.0934,15.6513,85.0569,-2.8794},
				{0.0200,26.3968,-11.1487,8.9351,10.5798,-16.2267,-30.0504,9.1464,8.0000,6.0000,0.0000,9.3564,5.4184,16.2505,29.9605,-2.9310},
				{0.0200,26.2396,-11.1785,9.1403,10.2589,-16.0425,9.2080,9.3064,8.0000,6.0000,0.0000,9.4712,5.7397,16.0633,-9.3605,-2.9762},
				{0.0200,26.0813,-11.2017,9.3393,9.9512,-15.3880,32.7255,9.4664,8.0000,6.0000,0.0000,9.5922,6.0478,15.4053,-32.8973,-3.0152},
				{0.0200,25.9222,-11.2192,9.5325,9.6608,-14.5204,43.3814,9.6264,8.0000,6.0000,0.0000,9.7190,6.3385,14.5344,-43.5464,-3.0485},
				{0.0200,25.7627,-11.2318,9.7203,9.3883,-13.6255,44.7432,9.7864,8.0000,6.0000,0.0000,9.8512,6.6112,13.6366,-44.8888,-3.0762},
				{0.0200,25.6030,-11.2403,9.9029,9.1317,-12.8282,39.8657,9.9464,8.0000,6.0000,0.0000,9.9885,6.8680,12.8368,-39.9889,-3.0989},
				{0.0200,25.4431,-11.2457,10.0806,8.8875,-12.2106,30.8800,10.1064,8.0000,6.0000,0.0000,10.1308,7.1123,12.2172,-30.9822,-3.1166},
				{0.0200,25.2831,-11.2486,10.2537,8.6509,-11.8309,18.9869,10.2664,8.0000,6.0000,0.0000,10.2778,7.3490,11.8357,-19.0730,-3.1296},
				{0.0200,25.1231,-11.2498,10.4220,8.4161,-11.7392,4.5814,10.4264,8.0000,6.0000,0.0000,10.4294,7.5839,11.7426,-4.6572,-3.1380},
				{0.0200,24.9631,-11.2500,10.5855,8.1762,-11.9922,-12.6480,10.5864,8.0000,6.0000,0.0000,10.5859,7.8237,11.9941,12.5758,-3.1415},
				{0.0200,24.8031,-11.2500,10.7452,7.9851,-9.5588,121.6728,10.7464,8.0000,6.0000,0.0000,10.7462,8.0149,9.5592,-121.7462,-3.1412},
				{0.0200,24.6431,-11.2499,10.9060,8.0372,2.6082,608.3463,10.9064,8.0000,6.0000,0.0000,10.9055,7.9628,-2.6082,-608.3685,-3.1419},
				{0.0200,24.4831,-11.2497,11.0672,8.0625,1.2649,-67.1613,11.0664,8.0000,6.0000,0.0000,11.0642,7.9375,-1.2650,67.1604,-3.1432},
				{0.0200,24.3231,-11.2492,11.2289,8.0848,1.1145,-7.5223,11.2264,8.0000,6.0000,0.0000,11.2225,7.9152,-1.1145,7.5218,-3.1449},
				{0.0200,24.1631,-11.2484,11.3910,8.1042,0.9699,-7.2317,11.3864,8.0000,6.0000,0.0000,11.3804,7.8958,-0.9699,7.2315,-3.1470},
				{0.0200,24.0031,-11.2473,11.5534,8.1208,0.8310,-6.9451,11.5464,8.0000,6.0000,0.0000,11.5380,7.8792,-0.8310,6.9450,-3.1494},
				{0.0200,23.8431,-11.2457,11.7161,8.1348,0.6977,-6.6611,11.7064,8.0000,6.0000,0.0000,11.6953,7.8652,-0.6978,6.6613,-3.1521},
				{0.0200,23.6831,-11.2437,11.8790,8.1462,0.5702,-6.3788,11.8664,8.0000,6.0000,0.0000,11.8524,7.8538,-0.5702,6.3790,-3.1550},
				{0.0200,23.5231,-11.2412,12.0421,8.1552,0.4482,-6.0968,12.0264,8.0000,6.0000,0.0000,12.0093,7.8448,-0.4483,6.0972,-3.1581},
				{0.0200,23.3632,-11.2382,12.2054,8.1618,0.3319,-5.8145,12.1864,8.0000,6.0000,0.0000,12.1661,7.8382,-0.3320,5.8149,-3.1613},
				{0.0200,23.2032,-11.2347,12.3687,8.1662,0.2213,-5.5309,12.3464,8.0000,6.0000,0.0000,12.3227,7.8338,-0.2213,5.5313,-3.1647},
				{0.0200,23.0433,-11.2306,12.5321,8.1686,0.1164,-5.2457,12.5064,8.0000,6.0000,0.0000,12.4794,7.8314,-0.1164,5.2461,-3.1680},
				{0.0200,22.8833,-11.2261,12.6954,8.1689,0.0172,-4.9586,12.6664,8.0000,6.0000,0.0000,12.6360,7.8311,-0.0172,4.9590,-3.1714},
				{0.0200,22.7234,-11.2209,12.8588,8.1674,-0.0761,-4.6695,12.8264,8.0000,6.0000,0.0000,12.7926,7.8326,0.0762,4.6699,-3.1748},
				{0.0200,22.5635,-11.2153,13.0221,8.1641,-0.1637,-4.3785,12.9864,8.0000,6.0000,0.0000,12.9494,7.8359,0.1637,4.3789,-3.1780},
				{0.0200,22.4036,-11.2091,13.1852,8.1592,-0.2454,-4.0859,13.1464,8.0000,6.0000,0.0000,13.1062,7.8408,0.2455,4.0862,-3.1812},
				{0.0200,22.2438,-11.2024,13.3483,8.1528,-0.3213,-3.7920,13.3064,8.0000,6.0000,0.0000,13.2631,7.8472,0.3213,3.7923,-3.1843},
				{0.0200,22.0839,-11.1952,13.5112,8.1449,-0.3912,-3.4973,13.4664,8.0000,6.0000,0.0000,13.4202,7.8551,0.3913,3.4975,-3.1872},
				{0.0200,21.9241,-11.1876,13.6739,8.1358,-0.4553,-3.2021,13.6264,8.0000,6.0000,0.0000,13.5775,7.8642,0.4553,3.2023,-3.1899},
				{0.0200,21.7643,-11.1796,13.8364,8.1256,-0.5134,-2.9070,13.7864,8.0000,6.0000,0.0000,13.7350,7.8744,0.5134,2.9071,-3.1924},
				{0.0200,21.6045,-11.1712,13.9987,8.1143,-0.5657,-2.6122,13.9464,8.0000,6.0000,0.0000,13.8927,7.8857,0.5657,2.6123,-3.1947},
				{0.0200,21.4448,-11.1624,14.1608,8.1020,-0.6120,-2.3182,14.1064,8.0000,6.0000,0.0000,14.0507,7.8980,0.6120,2.3182,-3.1967},
				{0.0200,21.2850,-11.1534,14.3225,8.0890,-0.6525,-2.0252,14.2664,8.0000,6.0000,0.0000,14.2089,7.9110,0.6526,2.0251,-3.1985},
				{0.0200,21.1253,-11.1441,14.4840,8.0752,-0.6872,-1.7332,14.4264,8.0000,6.0000,0.0000,14.3674,7.9248,0.6872,1.7331,-3.2000},
				{0.0200,20.9680,-11.1347,14.6428,7.9401,-6.7563,-303.4558,14.5840,7.8800,-6.0000,0.0000,14.5238,7.8199,-5.2437,-296.5443,-3.2012},
				{0.0200,20.8131,-11.1252,14.7989,7.8052,-6.7462,0.5057,14.7392,7.7600,-6.0000,0.0000,14.6781,7.7148,-5.2538,-0.5061,-3.2021},
				{0.0200,20.6606,-11.1159,14.9524,7.6706,-6.7295,0.8318,14.8920,7.6400,-6.0000,0.0000,14.8303,7.6094,-5.2704,-0.8321,-3.2027},
				{0.0200,20.5104,-11.1066,15.1031,7.5364,-6.7073,1.1148,15.0424,7.5200,-6.0000,0.0000,14.9803,7.5036,-5.2927,-1.1151,-3.2031},
				{0.0200,20.3627,-11.0974,15.2511,7.4028,-6.6801,1.3578,15.1904,7.4000,-6.0000,0.0000,15.1283,7.3972,-5.3199,-1.3581,-3.2031},
				{0.0200,20.2174,-11.0883,15.3965,7.2699,-6.6488,1.5638,15.3360,7.2800,-6.0000,0.0000,15.2741,7.2901,-5.3512,-1.5640,-3.2029},
				{0.0200,20.0745,-11.0795,15.5393,7.1376,-6.6141,1.7355,15.4792,7.1600,-6.0000,0.0000,15.4177,7.1824,-5.3859,-1.7356,-3.2025},
				{0.0200,19.9339,-11.0709,15.6794,7.0060,-6.5766,1.8755,15.6200,7.0400,-6.0000,0.0000,15.5592,7.0740,-5.4234,-1.8756,-3.2018},
				{0.0200,19.7958,-11.0626,15.8169,6.8753,-6.5369,1.9863,15.7584,6.9200,-6.0000,0.0000,15.6985,6.9647,-5.4631,-1.9864,-3.2009},
				{0.0200,19.6600,-11.0545,15.9518,6.7454,-6.4955,2.0702,15.8944,6.8000,-6.0000,0.0000,15.8356,6.8546,-5.5045,-2.0703,-3.1998},
				{0.0200,19.5267,-11.0467,16.0841,6.6163,-6.4529,2.1294,16.0280,6.6800,-6.0000,0.0000,15.9705,6.7437,-5.5471,-2.1295,-3.1985},
				{0.0200,19.3957,-11.0393,16.2139,6.4881,-6.4096,2.1660,16.1592,6.5600,-6.0000,0.0000,16.1031,6.6319,-5.5904,-2.1660,-3.1971},
				{0.0200,19.2671,-11.0321,16.3411,6.3608,-6.3659,2.1817,16.2880,6.4400,-6.0000,0.0000,16.2335,6.5192,-5.6341,-2.1817,-3.1955},
				{0.0200,19.1409,-11.0254,16.4658,6.2344,-6.3224,2.1786,16.4144,6.3200,-6.0000,0.0000,16.3616,6.4056,-5.6777,-2.1785,-3.1938},
				{0.0200,19.0170,-11.0189,16.5880,6.1088,-6.2792,2.1582,16.5384,6.2000,-6.0000,0.0000,16.4874,6.2912,-5.7208,-2.1581,-3.1920},
				{0.0200,18.8956,-11.0128,16.7077,5.9841,-6.2368,2.1222,16.6600,6.0800,-6.0000,0.0000,16.6109,6.1759,-5.7633,-2.1222,-3.1901},
				{0.0200,18.7765,-11.0071,16.8249,5.8602,-6.1953,2.0723,16.7792,5.9600,-6.0000,0.0000,16.7321,6.0598,-5.8047,-2.0722,-3.1881},
				{0.0200,18.6598,-11.0017,16.9396,5.7371,-6.1551,2.0099,16.8960,5.8400,-6.0000,0.0000,16.8510,5.9429,-5.8449,-2.0098,-3.1860},
				{0.0200,18.5455,-10.9967,17.0519,5.6147,-6.1164,1.9365,17.0104,5.7200,-6.0000,0.0000,16.9675,5.8253,-5.8836,-1.9364,-3.1839},
				{0.0200,18.4336,-10.9920,17.1618,5.4931,-6.0793,1.8534,17.1224,5.6000,-6.0000,0.0000,17.0816,5.7069,-5.9207,-1.8533,-3.1818},
				{0.0200,18.3241,-10.9877,17.2692,5.3723,-6.0441,1.7620,17.2320,5.4800,-6.0000,0.0000,17.1934,5.5877,-5.9559,-1.7619,-3.1796},
				{0.0200,18.2170,-10.9837,17.3743,5.2520,-6.0108,1.6636,17.3392,5.3600,-6.0000,0.0000,17.3028,5.4680,-5.9892,-1.6635,-3.1774},
				{0.0200,18.1123,-10.9800,17.4769,5.1325,-5.9796,1.5594,17.4440,5.2400,-6.0000,0.0000,17.4097,5.3475,-6.0204,-1.5594,-3.1753},
				{0.0200,18.0099,-10.9766,17.5772,5.0134,-5.9506,1.4507,17.5464,5.1200,-6.0000,0.0000,17.5142,5.2266,-6.0494,-1.4506,-3.1732},
				{0.0200,17.9100,-10.9734,17.6751,4.8950,-5.9238,1.3384,17.6464,5.0000,-6.0000,0.0000,17.6163,5.1050,-6.0762,-1.3383,-3.1711},
				{0.0200,17.8124,-10.9706,17.7706,4.7770,-5.8994,1.2237,17.7440,4.8800,-6.0000,0.0000,17.7160,4.9830,-6.1006,-1.2236,-3.1690},
				{0.0200,17.7173,-10.9680,17.8638,4.6594,-5.8772,1.1075,17.8392,4.7600,-6.0000,0.0000,17.8132,4.8606,-6.1228,-1.1075,-3.1670},
				{0.0200,17.6245,-10.9657,17.9547,4.5423,-5.8574,0.9909,17.9320,4.6400,-6.0000,0.0000,17.9080,4.7377,-6.1426,-0.9909,-3.1650},
				{0.0200,17.5341,-10.9636,18.0432,4.4255,-5.8399,0.8746,18.0224,4.5200,-6.0000,0.0000,18.0003,4.6145,-6.1601,-0.8746,-3.1631},
				{0.0200,17.4461,-10.9618,18.1293,4.3090,-5.8247,0.7596,18.1104,4.4000,-6.0000,0.0000,18.0901,4.4910,-6.1753,-0.7596,-3.1613},
				{0.0200,17.3605,-10.9601,18.2132,4.1928,-5.8118,0.6464,18.1960,4.2800,-6.0000,0.0000,18.1774,4.3672,-6.1882,-0.6464,-3.1596},
				{0.0200,17.2774,-10.9586,18.2947,4.0767,-5.8011,0.5359,18.2792,4.1600,-6.0000,0.0000,18.2623,4.2433,-6.1989,-0.5359,-3.1579},
				{0.0200,17.1966,-10.9573,18.3740,3.9609,-5.7925,0.4287,18.3600,4.0400,-6.0000,0.0000,18.3447,4.1191,-6.2075,-0.4287,-3.1563},
				{0.0200,17.1182,-10.9562,18.4509,3.8452,-5.7860,0.3252,18.4384,3.9200,-6.0000,0.0000,18.4246,3.9948,-6.2140,-0.3252,-3.1548},
				{0.0200,17.0422,-10.9552,18.5254,3.7295,-5.7815,0.2260,18.5144,3.8000,-6.0000,0.0000,18.5020,3.8705,-6.2185,-0.2261,-3.1534},
				{0.0200,16.9686,-10.9543,18.5977,3.6140,-5.7788,0.1316,18.5880,3.6800,-6.0000,0.0000,18.5769,3.7460,-6.2212,-0.1316,-3.1521},
				{0.0200,16.8974,-10.9536,18.6677,3.4984,-5.7780,0.0423,18.6592,3.5600,-6.0000,0.0000,18.6493,3.6216,-6.2220,-0.0423,-3.1509},
				{0.0200,16.8286,-10.9529,18.7353,3.3828,-5.7788,-0.0416,18.7280,3.4400,-6.0000,0.0000,18.7193,3.4972,-6.2212,0.0415,-3.1497},
				{0.0200,16.7622,-10.9524,18.8007,3.2672,-5.7812,-0.1197,18.7944,3.3200,-6.0000,0.0000,18.7867,3.3728,-6.2188,0.1197,-3.1487},
				{0.0200,16.6982,-10.9519,18.8637,3.1515,-5.7850,-0.1919,18.8584,3.2000,-6.0000,0.0000,18.8517,3.2485,-6.2150,0.1918,-3.1477},
				{0.0200,16.6366,-10.9515,18.9244,3.0357,-5.7902,-0.2579,18.9200,3.0800,-6.0000,0.0000,18.9142,3.1243,-6.2098,0.2579,-3.1468},
				{0.0200,16.5774,-10.9512,18.9828,2.9198,-5.7966,-0.3177,18.9792,2.9600,-6.0000,0.0000,18.9742,3.0002,-6.2034,0.3176,-3.1460},
				{0.0200,16.5206,-10.9510,19.0389,2.8037,-5.8040,-0.3710,19.0360,2.8400,-6.0000,0.0000,19.0317,2.8763,-6.1960,0.3710,-3.1453},
				{0.0200,16.4662,-10.9507,19.0927,2.6874,-5.8123,-0.4180,19.0904,2.7200,-6.0000,0.0000,19.0868,2.7526,-6.1877,0.4180,-3.1446},
				{0.0200,16.4142,-10.9506,19.1441,2.5710,-5.8215,-0.4585,19.1424,2.6000,-6.0000,0.0000,19.1393,2.6290,-6.1785,0.4585,-3.1441},
				{0.0200,16.3646,-10.9504,19.1932,2.4544,-5.8314,-0.4925,19.1920,2.4800,-6.0000,0.0000,19.1895,2.5056,-6.1686,0.4925,-3.1435},
				{0.0200,16.3174,-10.9503,19.2399,2.3375,-5.8418,-0.5202,19.2392,2.3600,-6.0000,0.0000,19.2371,2.3825,-6.1582,0.5202,-3.1431},
				{0.0200,16.2726,-10.9502,19.2843,2.2205,-5.8526,-0.5415,19.2840,2.2400,-6.0000,0.0000,19.2823,2.2595,-6.1474,0.5415,-3.1427},
				{0.0200,16.2302,-10.9502,19.3264,2.1032,-5.8637,-0.5567,19.3264,2.1200,-6.0000,0.0000,19.3250,2.1368,-6.1363,0.5567,-3.1424},
				{0.0200,16.1902,-10.9501,19.3661,1.9857,-5.8750,-0.5657,19.3664,2.0000,-6.0000,0.0000,19.3653,2.0143,-6.1250,0.5657,-3.1421},
				{0.0200,16.1526,-10.9501,19.4035,1.8680,-5.8864,-0.5689,19.4040,1.8800,-6.0000,0.0000,19.4032,1.8920,-6.1136,0.5689,-3.1418},
				{0.0200,16.1174,-10.9501,19.4385,1.7500,-5.8977,-0.5664,19.4392,1.7600,-6.0000,0.0000,19.4386,1.7700,-6.1023,0.5664,-3.1416},
				{0.0200,16.0846,-10.9500,19.4711,1.6319,-5.9089,-0.5583,19.4720,1.6400,-6.0000,0.0000,19.4715,1.6481,-6.0911,0.5583,-3.1415},
				{0.0200,16.0542,-10.9500,19.5014,1.5135,-5.9198,-0.5450,19.5024,1.5200,-6.0000,0.0000,19.5020,1.5265,-6.0802,0.5450,-3.1413},
				{0.0200,16.0262,-10.9500,19.5293,1.3949,-5.9303,-0.5267,19.5304,1.4000,-6.0000,0.0000,19.5302,1.4051,-6.0697,0.5267,-3.1412},
				{0.0200,16.0006,-10.9500,19.5548,1.2760,-5.9404,-0.5036,19.5560,1.2800,-6.0000,0.0000,19.5558,1.2840,-6.0596,0.5036,-3.1412},
				{0.0200,15.9774,-10.9500,19.5779,1.1570,-5.9499,-0.4762,19.5792,1.1600,-6.0000,0.0000,19.5791,1.1630,-6.0501,0.4762,-3.1411},
				{0.0200,15.9566,-10.9500,19.5987,1.0379,-5.9588,-0.4446,19.6000,1.0400,-6.0000,0.0000,19.5999,1.0421,-6.0412,0.4446,-3.1411},
				{0.0200,15.9382,-10.9500,19.6171,0.9185,-5.9670,-0.4093,19.6184,0.9200,-6.0000,0.0000,19.6184,0.9215,-6.0330,0.4093,-3.1410},
				{0.0200,15.9222,-10.9500,19.6330,0.7990,-5.9744,-0.3705,19.6344,0.8000,-6.0000,0.0000,19.6344,0.8010,-6.0256,0.3705,-3.1410},
				{0.0200,15.9086,-10.9500,19.6466,0.6794,-5.9810,-0.3286,19.6480,0.6800,-6.0000,0.0000,19.6480,0.6806,-6.0190,0.3286,-3.1410},
				{0.0200,15.8974,-10.9500,19.6578,0.5597,-5.9867,-0.2841,19.6592,0.5600,-6.0000,0.0000,19.6592,0.5603,-6.0133,0.2841,-3.1410},
				{0.0200,15.8886,-10.9500,19.6666,0.4399,-5.9914,-0.2373,19.6680,0.4400,-6.0000,0.0000,19.6680,0.4401,-6.0086,0.2373,-3.1410},
				{0.0200,15.8822,-10.9500,19.6730,0.3200,-5.9952,-0.1885,19.6744,0.3200,-6.0000,0.0000,19.6744,0.3200,-6.0048,0.1885,-3.1410},
				{0.0200,15.8800,-10.9500,19.6752,0.1100,-10.4973,-225.1063,19.6766,0.2000,-6.0000,0.0000,19.6766,0.1100,-10.5012,-224.8199,-3.1410},
				{0.0200,15.8800,-10.9500,19.6752,0.0000,-5.5006,249.8364,19.6766,0.0800,-6.0000,0.0000,19.6766,0.0000,-5.5009,250.0159,-3.1410},
				{0.0200,15.8800,-10.9500,19.6752,0.0000,0.0000,275.0296,19.6766,-0.0400,-6.0000,0.0000,19.6766,0.0000,0.0000,275.0442,-3.1410},

	    };

	@Override
	public double[][] getPath() {
	    return points;
	}
}