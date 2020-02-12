package frc.paths;

import com.team319.trajectory.Path;

public class TowerTrenchComplex extends Path {
   // dt,x,y,left.pos,left.vel,left.acc,left.jerk,center.pos,center.vel,center.acc,center.jerk,right.pos,right.vel,right.acc,right.jerk,heading
	public static final double[][] points = {
				{0.0200,32.1076,-5.5000,0.0024,0.1200,6.0000,0.0000,0.0024,0.1200,6.0000,0.0000,0.0024,0.1200,6.0000,0.0000,-3.1416},
				{0.0200,32.1028,-5.5000,0.0072,0.2397,5.9873,-0.6351,0.0072,0.2400,6.0000,0.0000,0.0072,0.2403,6.0127,0.6351,-3.1416},
				{0.0200,32.0956,-5.5000,0.0144,0.3591,5.9699,-0.8700,0.0144,0.3600,6.0000,0.0000,0.0144,0.3609,6.0301,0.8700,-3.1416},
				{0.0200,32.0860,-5.5000,0.0239,0.4780,5.9416,-1.4171,0.0240,0.4800,6.0000,0.0000,0.0241,0.4820,6.0584,1.4171,-3.1415},
				{0.0200,32.0740,-5.5000,0.0359,0.5961,5.9040,-1.8767,0.0360,0.6000,6.0000,0.0000,0.0361,0.6039,6.0960,1.8767,-3.1415},
				{0.0200,32.0596,-5.5000,0.0501,0.7132,5.8575,-2.3265,0.0504,0.7200,6.0000,0.0000,0.0507,0.7268,6.1425,2.3265,-3.1413},
				{0.0200,32.0428,-5.5000,0.0667,0.8292,5.8022,-2.7652,0.0672,0.8400,6.0000,0.0000,0.0677,0.8508,6.1978,2.7652,-3.1411},
				{0.0200,32.0236,-5.5000,0.0856,0.9440,5.7383,-3.1924,0.0864,0.9600,6.0000,0.0000,0.0872,0.9760,6.2617,3.1924,-3.1408},
				{0.0200,32.0020,-5.5000,0.1067,1.0573,5.6662,-3.6087,0.1080,1.0800,6.0000,0.0000,0.1093,1.1027,6.3338,3.6086,-3.1403},
				{0.0200,31.9780,-5.5001,0.1301,1.1691,5.5859,-4.0153,0.1320,1.2000,6.0000,0.0000,0.1339,1.2309,6.4141,4.0153,-3.1397},
				{0.0200,31.9516,-5.5001,0.1557,1.2790,5.4976,-4.4148,0.1584,1.3200,6.0000,0.0000,0.1611,1.3610,6.5024,4.4148,-3.1389},
				{0.0200,31.9228,-5.5002,0.1834,1.3870,5.4014,-4.8106,0.1872,1.4400,6.0000,0.0000,0.1910,1.4930,6.5986,4.8105,-3.1378},
				{0.0200,31.8916,-5.5004,0.2133,1.4930,5.2972,-5.2072,0.2184,1.5600,6.0000,0.0000,0.2235,1.6270,6.7028,5.2071,-3.1365},
				{0.0200,31.8580,-5.5006,0.2452,1.5967,5.1850,-5.6101,0.2520,1.6800,6.0000,0.0000,0.2588,1.7633,6.8150,5.6100,-3.1348},
				{0.0200,31.8220,-5.5009,0.2792,1.6980,5.0645,-6.0259,0.2880,1.8000,6.0000,0.0000,0.2968,1.9020,6.9355,6.0258,-3.1328},
				{0.0200,31.7836,-5.5012,0.3151,1.7967,4.9352,-6.4623,0.3264,1.9200,6.0000,0.0000,0.3377,2.0433,7.0647,6.4619,-3.1303},
				{0.0200,31.7428,-5.5018,0.3530,1.8926,4.7967,-6.9275,0.3672,2.0400,6.0000,0.0000,0.3814,2.1874,7.2033,6.9272,-3.1274},
				{0.0200,31.6996,-5.5024,0.3927,1.9856,4.6481,-7.4314,0.4104,2.1600,6.0000,0.0000,0.4281,2.3344,7.3519,7.4308,-3.1239},
				{0.0200,31.6540,-5.5033,0.4342,2.0753,4.4884,-7.9841,0.4560,2.2800,6.0000,0.0000,0.4778,2.4847,7.5116,7.9834,-3.1198},
				{0.0200,31.6060,-5.5045,0.4774,2.1617,4.3164,-8.5970,0.5040,2.4000,6.0000,0.0000,0.5306,2.6383,7.6835,8.5962,-3.1150},
				{0.0200,31.5557,-5.5060,0.5223,2.2443,4.1308,-9.2822,0.5544,2.5200,6.0000,0.0000,0.5865,2.7957,7.8691,9.2810,-3.1095},
				{0.0200,31.5029,-5.5078,0.5688,2.3229,3.9298,-10.0522,0.6072,2.6400,6.0000,0.0000,0.6456,2.9571,8.0701,10.0506,-3.1032},
				{0.0200,31.4477,-5.5102,0.6167,2.3971,3.7114,-10.9198,0.6624,2.7600,6.0000,0.0000,0.7081,3.1229,8.2885,10.9178,-3.0959},
				{0.0200,31.3902,-5.5130,0.6660,2.4666,3.4734,-11.8977,0.7200,2.8800,6.0000,0.0000,0.7740,3.2934,8.5264,11.8951,-3.0876},
				{0.0200,31.3303,-5.5165,0.7167,2.5308,3.2135,-12.9976,0.7800,3.0000,6.0000,0.0000,0.8433,3.4691,8.7863,12.9943,-3.0783},
				{0.0200,31.2681,-5.5208,0.7684,2.5894,2.9289,-14.2287,0.8424,3.1200,6.0000,0.0000,0.9163,3.6506,9.0708,14.2246,-3.0676},
				{0.0200,31.2035,-5.5260,0.8213,2.6418,2.6169,-15.5964,0.9072,3.2400,6.0000,0.0000,0.9931,3.8382,9.3826,15.5910,-3.0557},
				{0.0200,31.1366,-5.5322,0.8750,2.6873,2.2750,-17.0985,0.9744,3.3600,6.0000,0.0000,1.0738,4.0327,9.7244,17.0918,-3.0422},
				{0.0200,31.0674,-5.5396,0.9295,2.7253,1.9005,-18.7217,1.0440,3.4800,6.0000,0.0000,1.1585,4.2347,10.0987,18.7133,-3.0271},
				{0.0200,30.9959,-5.5484,0.9846,2.7551,1.4918,-20.4351,1.1160,3.6000,6.0000,0.0000,1.2474,4.4448,10.5072,20.4246,-3.0102},
				{0.0200,30.9222,-5.5589,1.0402,2.7761,1.0482,-22.1811,1.1904,3.7200,6.0000,0.0000,1.3406,4.6638,10.9505,22.1681,-2.9914},
				{0.0200,30.8464,-5.5711,1.0959,2.7875,0.5709,-23.8644,1.2672,3.8400,6.0000,0.0000,1.4385,4.8924,11.4275,23.8481,-2.9703},
				{0.0200,30.7685,-5.5855,1.1517,2.7888,0.0642,-25.3354,1.3464,3.9600,6.0000,0.0000,1.5411,5.1310,11.9338,25.3155,-2.9469},
				{0.0200,30.6887,-5.6024,1.2073,2.7795,-0.4632,-26.3727,1.4280,4.0800,6.0000,0.0000,1.6487,5.3803,12.4608,26.3486,-2.9209},
				{0.0200,30.6070,-5.6219,1.2625,2.7596,-0.9965,-26.6614,1.5120,4.2000,6.0000,0.0000,1.7615,5.6401,12.9934,26.6325,-2.8921},
				{0.0200,30.5236,-5.6446,1.3171,2.7293,-1.5120,-25.7758,1.5984,4.3200,6.0000,0.0000,1.8797,5.9103,13.5083,25.7423,-2.8603},
				{0.0200,30.4388,-5.6707,1.3708,2.6898,-1.9754,-23.1729,1.6872,4.4400,6.0000,0.0000,2.0035,6.1897,13.9710,23.1351,-2.8253},
				{0.0200,30.3527,-5.7007,1.4237,2.6430,-2.3397,-18.2117,1.7784,4.5600,6.0000,0.0000,2.1330,6.4764,14.3344,18.1711,-2.7869},
				{0.0200,30.2656,-5.7350,1.4756,2.5922,-2.5441,-10.2207,1.8720,4.6800,6.0000,0.0000,2.2684,6.7672,14.5380,10.1801,-2.7452},
				{0.0200,30.1779,-5.7740,1.5264,2.5418,-2.5168,1.3645,1.9680,4.8000,6.0000,0.0000,2.4095,7.0574,14.5100,-1.4006,-2.7000},
				{0.0200,30.0900,-5.8182,1.5764,2.4982,-2.1812,16.7802,2.0664,4.9200,6.0000,0.0000,2.5563,7.3408,14.1739,-16.8056,-2.6516},
				{0.0200,30.0023,-5.8679,1.6257,2.4688,-1.4681,35.6528,2.1672,5.0400,6.0000,0.0000,2.7085,7.6101,13.4607,-35.6598,-2.6002},
				{0.0200,29.9153,-5.9235,1.6750,2.4622,-0.3334,56.7375,2.2704,5.1600,6.0000,0.0000,2.8657,7.8566,12.3263,-56.7188,-2.5462},
				{0.0200,29.8296,-5.9851,1.7247,2.4866,1.2231,77.8252,2.3760,5.2800,6.0000,0.0000,3.0271,8.0720,10.7708,-77.7756,-2.4903},
				{0.0200,29.7456,-6.0530,1.7757,2.5495,3.1427,95.9801,2.4840,5.4000,6.0000,0.0000,3.1921,8.2491,8.8528,-95.8996,-2.4333},
				{0.0200,29.6639,-6.1272,1.8288,2.6556,5.3062,108.1723,2.5944,5.5200,6.0000,0.0000,3.3598,8.3829,6.6915,-108.0667,-2.3761},
				{0.0200,29.5848,-6.2076,1.8849,2.8066,7.5492,112.1522,2.7072,5.6400,6.0000,0.0000,3.5292,8.4719,4.4508,-112.0334,-2.3194},
				{0.0200,29.5088,-6.2941,1.9449,3.0005,9.6933,107.2063,2.8224,5.7600,6.0000,0.0000,3.6996,8.5181,2.3090,-107.0891,-2.2642},
				{0.0200,29.4361,-6.3865,2.0096,3.2321,11.5816,94.4116,2.9400,5.8800,6.0000,0.0000,3.8701,8.5265,0.4228,-94.3100,-2.2113},
				{0.0200,29.3668,-6.4845,2.0795,3.4942,13.1066,76.2515,3.0600,6.0000,6.0000,0.0000,4.0402,8.5045,-1.1007,-76.1751,-2.1612},
				{0.0200,29.3012,-6.5878,2.1550,3.7787,14.2226,55.8018,3.1824,6.1200,6.0000,0.0000,4.2094,8.4602,-2.2158,-55.7543,-2.1143},
				{0.0200,29.2390,-6.6960,2.2366,4.0775,14.9404,35.8859,3.3072,6.2400,6.0000,0.0000,4.3774,8.4015,-2.9331,-35.8658,-2.0711},
				{0.0200,29.1802,-6.8088,2.3243,4.3837,15.3109,18.5255,3.4344,6.3600,6.0000,0.0000,4.5441,8.3355,-3.3036,-18.5279,-2.0316},
				{0.0200,29.1247,-6.9259,2.4181,4.6918,15.4066,4.7857,3.5640,6.4800,6.0000,0.0000,4.7095,8.2675,-3.3997,-4.8040,-1.9958},
				{0.0200,29.0723,-7.0471,2.5181,4.9979,15.3049,-5.0836,3.6960,6.6000,6.0000,0.0000,4.8735,8.2015,-3.2986,5.0551,-1.9638},
				{0.0200,29.0226,-7.1719,2.6241,5.2995,15.0775,-11.3722,3.8304,6.7200,6.0000,0.0000,5.0363,8.1401,-3.0718,11.3390,-1.9354},
				{0.0200,28.9755,-7.3004,2.7360,5.5952,14.7847,-14.6395,3.9672,6.8400,6.0000,0.0000,5.1980,8.0845,-2.7797,14.6045,-1.9105},
				{0.0200,28.9306,-7.4321,2.8537,5.8847,14.4745,-15.5098,4.1064,6.9600,6.0000,0.0000,5.3587,8.0351,-2.4702,15.4757,-1.8890},
				{0.0200,28.8875,-7.5670,2.9770,6.1683,14.1835,-14.5515,4.2480,7.0800,6.0000,0.0000,5.5185,7.9915,-2.1798,14.5192,-1.8707},
				{0.0200,28.8461,-7.7049,3.1060,6.4471,13.9391,-12.2193,4.3920,7.2000,6.0000,0.0000,5.6776,7.9528,-1.9361,12.1893,-1.8557},
				{0.0200,28.8058,-7.8457,3.2404,6.7224,13.7623,-8.8385,4.5384,7.3200,6.0000,0.0000,5.8359,7.9176,-1.7599,8.8105,-1.8437},
				{0.0200,28.7664,-7.9891,3.3803,6.9958,13.6701,-4.6106,4.6872,7.4400,6.0000,0.0000,5.9936,7.8842,-1.6682,4.5839,-1.8348},
				{0.0200,28.7274,-8.1352,3.5257,7.2693,13.6775,0.3725,4.8384,7.5600,6.0000,0.0000,6.1506,7.8507,-1.6762,-0.3989,-1.8290},
				{0.0200,28.6884,-8.2838,3.6766,7.5453,13.7998,6.1141,4.9920,7.6800,6.0000,0.0000,6.3069,7.8147,-1.7990,-6.1416,-1.8263},
				{0.0200,28.6489,-8.4347,3.8331,7.8264,14.0538,12.7005,5.1480,7.8000,6.0000,0.0000,6.4624,7.7736,-2.0536,-12.7310,-1.8269},
				{0.0200,28.6086,-8.5879,3.9955,8.1156,14.4597,20.2919,5.3064,7.9200,6.0000,0.0000,6.6169,7.7244,-2.4602,-20.3279,-1.8308},
				{0.0200,28.5669,-8.7424,4.1629,8.3741,12.9256,-76.7043,5.4664,8.0000,6.0000,0.0000,6.7694,7.6259,-4.9269,-123.3389,-1.8383},
				{0.0200,28.5238,-8.8965,4.3341,8.5589,9.2420,-184.1783,5.6264,8.0000,6.0000,0.0000,6.9182,7.4410,-9.2443,-215.8686,-1.8494},
				{0.0200,28.4787,-9.0500,4.5092,8.7549,9.7972,27.7602,5.7864,8.0000,6.0000,0.0000,7.0631,7.2450,-9.8007,-27.8169,-1.8645},
				{0.0200,28.4309,-9.2027,4.6885,8.9658,10.5440,37.3376,5.9464,8.0000,6.0000,0.0000,7.2038,7.0340,-10.5488,-37.4078,-1.8839},
				{0.0200,28.3799,-9.3543,4.8724,9.1955,11.4877,47.1875,6.1064,8.0000,6.0000,0.0000,7.3399,6.8041,-11.4943,-47.2768,-1.9078},
				{0.0200,28.3249,-9.5045,5.0614,9.4480,12.6251,56.8665,6.2664,8.0000,6.0000,0.0000,7.4709,6.5514,-12.6340,-56.9805,-1.9367},
				{0.0200,28.2651,-9.6530,5.2559,9.7267,13.9329,65.3938,6.4264,8.0000,6.0000,0.0000,7.5964,6.2725,-13.9447,-65.5388,-1.9713},
				{0.0200,28.1999,-9.7990,5.4566,10.0337,15.3517,70.9396,6.5864,8.0000,6.0000,0.0000,7.7157,5.9652,-15.3671,-71.1198,-2.0120},
				{0.0200,28.1282,-9.9421,5.6640,10.3689,16.7608,70.4523,6.7464,8.0000,6.0000,0.0000,7.8283,5.6296,-16.7805,-70.6670,-2.0594},
				{0.0200,28.0494,-10.0813,5.8785,10.7279,17.9486,59.3932,6.9064,8.0000,6.0000,0.0000,7.9337,5.2701,-17.9731,-59.6299,-2.1140},
				{0.0200,27.9626,-10.2157,6.1005,11.0997,18.5885,31.9920,7.0664,8.0000,6.0000,0.0000,8.0316,4.8978,-18.6174,-32.2179,-2.1760},
				{0.0200,27.8672,-10.3440,6.3298,11.4645,18.2435,-17.2483,7.2264,8.0000,6.0000,0.0000,8.1223,4.5323,-18.2755,17.0942,-2.2453},
				{0.0200,27.7626,-10.4651,6.5657,11.7934,16.4416,-90.0932,7.3864,8.0000,6.0000,0.0000,8.2063,4.2028,-16.4736,90.0973,-2.3212},
				{0.0200,27.6489,-10.5777,6.8067,12.0503,12.8487,-179.6479,7.5464,8.0000,6.0000,0.0000,8.2852,3.9453,-12.8757,179.8947,-2.4023},
				{0.0200,27.5263,-10.6804,7.0507,12.2004,7.5046,-267.2051,7.7064,8.0000,6.0000,0.0000,8.3611,3.7949,-7.5212,267.7253,-2.4864},
				{0.0200,27.3955,-10.7724,7.2951,12.2200,0.9806,-326.2001,7.8664,8.0000,6.0000,0.0000,8.4366,3.7752,-0.9828,326.9199,-2.5709},
				{0.0200,27.2574,-10.8532,7.5372,12.1057,-5.7181,-334.9354,8.0264,8.0000,6.0000,0.0000,8.5144,3.8898,5.7309,335.6850,-2.6531},
				{0.0200,27.1134,-10.9226,7.7747,11.8753,-11.5210,-290.1452,8.1864,8.0000,6.0000,0.0000,8.5968,4.1207,11.5457,290.7392,-2.7306},
				{0.0200,26.9645,-10.9812,8.0059,11.5611,-15.7055,-209.2218,8.3464,8.0000,6.0000,0.0000,8.6855,4.4355,15.7368,209.5532,-2.8019},
				{0.0200,26.8120,-11.0295,8.2299,11.1995,-18.0837,-118.9139,8.5064,8.0000,6.0000,0.0000,8.7815,4.7978,18.1165,118.9854,-2.8659},
				{0.0200,26.6569,-11.0686,8.4464,10.8213,-18.9061,-41.1185,8.6664,8.0000,6.0000,0.0000,8.8850,5.1765,18.9366,41.0045,-2.9224},
				{0.0200,26.4999,-11.0995,8.6553,10.4488,-18.6294,13.8360,8.8264,8.0000,6.0000,0.0000,8.9960,5.5496,18.6556,-14.0462,-2.9714},
				{0.0200,26.3417,-11.1232,8.8572,10.0944,-17.7178,45.5809,8.9864,8.0000,6.0000,0.0000,9.1141,5.9044,17.7393,-45.8175,-3.0133},
				{0.0200,26.1826,-11.1408,9.0525,9.7636,-16.5415,58.8151,9.1464,8.0000,6.0000,0.0000,9.2388,6.2356,16.5585,-59.0383,-3.0486},
				{0.0200,26.0231,-11.1532,9.2416,9.4565,-15.3562,59.2621,9.3064,8.0000,6.0000,0.0000,9.3697,6.5430,15.3694,-59.4539,-3.0777},
				{0.0200,25.8634,-11.1615,9.4250,9.1700,-14.3239,51.6178,9.4664,8.0000,6.0000,0.0000,9.5063,6.8297,14.3339,-51.7758,-3.1011},
				{0.0200,25.7034,-11.1665,9.6030,8.8991,-13.5443,38.9802,9.6264,8.0000,6.0000,0.0000,9.6483,7.1007,13.5518,-39.1083,-3.1191},
				{0.0200,25.5435,-11.1690,9.7758,8.6374,-13.0852,22.9560,9.7864,8.0000,6.0000,0.0000,9.7955,7.3625,13.0905,-23.0616,-3.1318},
				{0.0200,25.3835,-11.1699,9.9433,8.3773,-13.0065,3.9309,9.9464,8.0000,6.0000,0.0000,9.9480,7.6227,13.0101,-4.0231,-3.1394},
				{0.0200,25.2235,-11.1700,10.1011,7.8889,-24.4197,-570.6587,10.1064,8.0000,6.0000,0.0000,10.1102,8.1111,24.4215,570.5696,-3.1371},
				{0.0200,25.0635,-11.1700,10.2611,8.0000,5.5571,1498.8391,10.2664,8.0000,6.0000,0.0000,10.2702,8.0000,-5.5569,-1498.9171,-3.1371},
				{0.0200,24.9035,-11.1700,10.4211,8.0000,-0.0000,-277.8534,10.4264,8.0000,6.0000,0.0000,10.4302,8.0000,-0.0000,277.8445,-3.1371},
				{0.0200,24.7435,-11.1700,10.5811,8.0000,-0.0000,-0.0000,10.5864,8.0000,6.0000,0.0000,10.5902,8.0000,-0.0000,-0.0000,-3.1371},
				{0.0200,24.5835,-11.1700,10.7411,8.0000,0.0000,0.0000,10.7464,8.0000,6.0000,0.0000,10.7502,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,24.4235,-11.1700,10.9011,8.0000,0.0000,0.0000,10.9064,8.0000,6.0000,0.0000,10.9102,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,24.2635,-11.1700,11.0611,8.0000,0.0000,-0.0000,11.0664,8.0000,6.0000,0.0000,11.0702,8.0000,0.0000,-0.0000,-3.1371},
				{0.0200,24.1035,-11.1700,11.2211,8.0000,-0.0000,-0.0000,11.2264,8.0000,6.0000,0.0000,11.2302,8.0000,-0.0000,-0.0000,-3.1371},
				{0.0200,23.9435,-11.1700,11.3811,8.0000,-0.0000,-0.0000,11.3864,8.0000,6.0000,0.0000,11.3902,8.0000,-0.0000,-0.0000,-3.1371},
				{0.0200,23.7835,-11.1700,11.5411,8.0000,-0.0000,0.0000,11.5464,8.0000,6.0000,0.0000,11.5502,8.0000,-0.0000,0.0000,-3.1371},
				{0.0200,23.6235,-11.1700,11.7011,8.0000,0.0000,0.0000,11.7064,8.0000,6.0000,0.0000,11.7102,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,23.4635,-11.1700,11.8611,8.0000,0.0000,0.0000,11.8664,8.0000,6.0000,0.0000,11.8702,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,23.3035,-11.1700,12.0211,8.0000,0.0000,0.0000,12.0264,8.0000,6.0000,0.0000,12.0302,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,23.1435,-11.1700,12.1811,8.0000,0.0000,0.0000,12.1864,8.0000,6.0000,0.0000,12.1902,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,22.9835,-11.1700,12.3411,8.0000,0.0000,0.0000,12.3464,8.0000,6.0000,0.0000,12.3502,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,22.8235,-11.1700,12.5011,8.0000,0.0000,0.0000,12.5064,8.0000,6.0000,0.0000,12.5102,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,22.6635,-11.1700,12.6611,8.0000,0.0000,0.0000,12.6664,8.0000,6.0000,0.0000,12.6702,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,22.5035,-11.1700,12.8211,8.0000,0.0000,0.0000,12.8264,8.0000,6.0000,0.0000,12.8302,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,22.3435,-11.1700,12.9811,8.0000,0.0000,0.0000,12.9864,8.0000,6.0000,0.0000,12.9902,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,22.1835,-11.1700,13.1411,8.0000,0.0000,0.0000,13.1464,8.0000,6.0000,0.0000,13.1502,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,22.0235,-11.1700,13.3011,8.0000,0.0000,0.0000,13.3064,8.0000,6.0000,0.0000,13.3102,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,21.8635,-11.1700,13.4611,8.0000,0.0000,0.0000,13.4664,8.0000,6.0000,0.0000,13.4702,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,21.7035,-11.1700,13.6211,8.0000,0.0000,0.0000,13.6264,8.0000,6.0000,0.0000,13.6302,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,21.5435,-11.1700,13.7811,8.0000,0.0000,0.0000,13.7864,8.0000,6.0000,0.0000,13.7902,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,21.3835,-11.1700,13.9411,8.0000,0.0000,0.0000,13.9464,8.0000,6.0000,0.0000,13.9502,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,21.2235,-11.1700,14.1011,8.0000,0.0000,0.0000,14.1064,8.0000,6.0000,0.0000,14.1102,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,21.0635,-11.1700,14.2611,8.0000,-0.0000,-0.0000,14.2664,8.0000,6.0000,0.0000,14.2702,8.0000,-0.0000,-0.0000,-3.1371},
				{0.0200,20.9035,-11.1700,14.4211,8.0000,0.0000,0.0000,14.4264,8.0000,6.0000,0.0000,14.4302,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,20.7435,-11.1700,14.5811,8.0000,0.0000,-0.0000,14.5864,8.0000,6.0000,0.0000,14.5902,8.0000,0.0000,-0.0000,-3.1371},
				{0.0200,20.5835,-11.1700,14.7411,8.0000,0.0000,0.0000,14.7464,8.0000,6.0000,0.0000,14.7502,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,20.4235,-11.1700,14.9011,8.0000,0.0000,0.0000,14.9064,8.0000,6.0000,0.0000,14.9102,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,20.2635,-11.1700,15.0611,8.0000,0.0000,-0.0000,15.0664,8.0000,6.0000,0.0000,15.0702,8.0000,0.0000,-0.0000,-3.1371},
				{0.0200,20.1035,-11.1700,15.2211,8.0000,0.0000,-0.0000,15.2264,8.0000,6.0000,0.0000,15.2302,8.0000,0.0000,-0.0000,-3.1371},
				{0.0200,19.9435,-11.1700,15.3811,8.0000,0.0000,0.0000,15.3864,8.0000,6.0000,0.0000,15.3902,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,19.7835,-11.1700,15.5411,8.0000,0.0000,0.0000,15.5464,8.0000,6.0000,0.0000,15.5502,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,19.6235,-11.1700,15.7011,8.0000,0.0000,0.0000,15.7064,8.0000,6.0000,0.0000,15.7102,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,19.4635,-11.1700,15.8611,8.0000,0.0000,0.0000,15.8664,8.0000,6.0000,0.0000,15.8702,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,19.3035,-11.1700,16.0211,8.0000,0.0000,0.0000,16.0264,8.0000,6.0000,0.0000,16.0302,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,19.1435,-11.1700,16.1811,8.0000,0.0000,0.0000,16.1864,8.0000,6.0000,0.0000,16.1902,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,18.9835,-11.1700,16.3411,8.0000,0.0000,0.0000,16.3464,8.0000,6.0000,0.0000,16.3502,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,18.8235,-11.1700,16.5011,8.0000,0.0000,0.0000,16.5064,8.0000,6.0000,0.0000,16.5102,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,18.6635,-11.1700,16.6611,8.0000,0.0000,0.0000,16.6664,8.0000,6.0000,0.0000,16.6702,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,18.5035,-11.1700,16.8211,8.0000,-0.0000,-0.0000,16.8264,8.0000,6.0000,0.0000,16.8302,8.0000,-0.0000,-0.0000,-3.1371},
				{0.0200,18.3435,-11.1700,16.9811,8.0000,0.0000,0.0000,16.9864,8.0000,6.0000,0.0000,16.9902,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,18.1835,-11.1700,17.1411,8.0000,0.0000,-0.0000,17.1464,8.0000,6.0000,0.0000,17.1502,8.0000,0.0000,-0.0000,-3.1371},
				{0.0200,18.0235,-11.1700,17.3011,8.0000,0.0000,0.0000,17.3064,8.0000,6.0000,0.0000,17.3102,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,17.8635,-11.1700,17.4611,8.0000,0.0000,0.0000,17.4664,8.0000,6.0000,0.0000,17.4702,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,17.7035,-11.1700,17.6211,8.0000,0.0000,0.0000,17.6264,8.0000,6.0000,0.0000,17.6302,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,17.5435,-11.1700,17.7811,8.0000,0.0000,0.0000,17.7864,8.0000,6.0000,0.0000,17.7902,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,17.3835,-11.1700,17.9411,8.0000,0.0000,0.0000,17.9464,8.0000,6.0000,0.0000,17.9502,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,17.2235,-11.1700,18.1011,8.0000,0.0000,0.0000,18.1064,8.0000,6.0000,0.0000,18.1102,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,17.0635,-11.1700,18.2611,8.0000,0.0000,0.0000,18.2664,8.0000,6.0000,0.0000,18.2702,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,16.9035,-11.1700,18.4211,8.0000,0.0000,0.0000,18.4264,8.0000,6.0000,0.0000,18.4302,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,16.7435,-11.1700,18.5811,8.0000,0.0000,0.0000,18.5864,8.0000,6.0000,0.0000,18.5902,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,16.5835,-11.1700,18.7411,8.0000,0.0000,0.0000,18.7464,8.0000,6.0000,0.0000,18.7502,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,16.4235,-11.1700,18.9011,8.0000,0.0000,0.0000,18.9064,8.0000,6.0000,0.0000,18.9102,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,16.2635,-11.1700,19.0611,8.0000,0.0000,0.0000,19.0664,8.0000,6.0000,0.0000,19.0702,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,16.1035,-11.1700,19.2211,8.0000,0.0000,0.0000,19.2264,8.0000,6.0000,0.0000,19.2302,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,15.9435,-11.1700,19.3811,8.0000,-0.0000,-0.0000,19.3864,8.0000,6.0000,0.0000,19.3902,8.0000,0.0000,0.0000,-3.1371},
				{0.0200,15.7835,-11.1692,19.5281,7.3525,-32.3763,-1618.8169,19.5464,8.0000,6.0000,0.0000,19.5632,8.6474,32.3694,1618.4723,-3.1242},
				{0.0200,15.6259,-11.1676,19.6695,7.0706,-14.0912,914.2588,19.7040,7.8800,-6.0000,0.0000,19.7369,8.6893,2.0931,-1513.8184,-3.1080},
				{0.0200,15.4708,-11.1740,19.7389,3.4685,-180.1064,-8300.7631,19.8592,7.7600,-6.0000,0.0000,19.9780,12.0509,168.0804,8299.3638,-3.0221},
				{0.0200,15.3197,-11.1957,19.7906,2.5824,-44.3054,6790.0495,20.0120,7.6400,-6.0000,0.0000,20.2319,12.6952,32.2159,-6793.2236,-2.9208},
				{0.0200,15.2500,-11.2100,19.8437,2.6565,3.7046,2400.5041,20.0831,7.5200,-6.0000,0.0000,20.3210,4.4560,-411.9576,-22208.6766,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,-132.8253,-6826.4970,20.0831,7.4000,-6.0000,0.0000,20.3210,0.0000,-222.8011,9457.8269,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,6641.2645,20.0831,7.2800,-6.0000,0.0000,20.3210,0.0000,0.0000,11140.0556,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,7.1600,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,7.0400,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,6.9200,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,6.8000,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,6.6800,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,6.5600,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,6.4400,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,6.3200,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,6.2000,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,6.0800,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,5.9600,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,5.8400,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,5.7200,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,5.6000,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,5.4800,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,5.3600,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,5.2400,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,5.1200,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,5.0000,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,4.8800,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,4.7600,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,4.6400,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,4.5200,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,4.4000,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,4.2800,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,4.1600,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,4.0400,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,3.9200,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,3.8000,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,3.6800,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,3.5600,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,3.4400,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,3.3200,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,3.2000,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,3.0800,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,2.9600,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,2.8400,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,2.7200,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,2.6000,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,2.4800,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,2.3600,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,2.2400,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,2.1200,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,2.0000,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,1.8800,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,1.7600,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,1.6400,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,1.5200,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,1.4000,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,1.2800,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,1.1600,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,1.0400,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,0.9200,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,0.8000,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,0.6800,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,0.5600,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,0.4400,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,0.3200,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,0.2000,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,0.0800,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},
				{0.0200,15.2500,-11.2100,19.8437,0.0000,0.0000,0.0000,20.0831,-0.0400,-6.0000,0.0000,20.3210,0.0000,0.0000,0.0000,-2.9028},

	    };

	@Override
	public double[][] getPath() {
	    return points;
	}
}