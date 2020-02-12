package frc.paths;

import com.team319.trajectory.Path;

public class TowerComplex extends Path {
   // dt,x,y,left.pos,left.vel,left.acc,left.jerk,center.pos,center.vel,center.acc,center.jerk,right.pos,right.vel,right.acc,right.jerk,heading
	public static final double[][] points = {
				{0.0200,32.1776,-5.3900,0.0024,0.1200,6.0000,0.0000,0.0024,0.1200,6.0000,0.0000,0.0024,0.1200,6.0000,0.0000,3.1416},
				{0.0200,32.1728,-5.3900,0.0072,0.2398,5.9912,-0.4416,0.0072,0.2400,6.0000,0.0000,0.0072,0.2402,6.0088,0.4416,3.1416},
				{0.0200,32.1656,-5.3900,0.0144,0.3594,5.9791,-0.6036,0.0144,0.3600,6.0000,0.0000,0.0144,0.3606,6.0209,0.6036,3.1416},
				{0.0200,32.1560,-5.3900,0.0240,0.4786,5.9595,-0.9803,0.0240,0.4800,6.0000,0.0000,0.0240,0.4814,6.0405,0.9803,3.1416},
				{0.0200,32.1440,-5.3900,0.0359,0.5973,5.9336,-1.2922,0.0360,0.6000,6.0000,0.0000,0.0361,0.6027,6.0664,1.2922,3.1417},
				{0.0200,32.1296,-5.3900,0.0502,0.7153,5.9018,-1.5913,0.0504,0.7200,6.0000,0.0000,0.0506,0.7247,6.0982,1.5913,3.1418},
				{0.0200,32.1128,-5.3900,0.0669,0.8326,5.8643,-1.8746,0.0672,0.8400,6.0000,0.0000,0.0675,0.8474,6.1357,1.8746,3.1419},
				{0.0200,32.0936,-5.3900,0.0858,0.9490,5.8216,-2.1388,0.0864,0.9600,6.0000,0.0000,0.0870,0.9710,6.1784,2.1388,3.1422},
				{0.0200,32.0720,-5.3900,0.1071,1.0645,5.7739,-2.3810,0.1080,1.0800,6.0000,0.0000,0.1089,1.0955,6.2261,2.3810,3.1425},
				{0.0200,32.0480,-5.3901,0.1307,1.1789,5.7220,-2.5980,0.1320,1.2000,6.0000,0.0000,0.1333,1.2211,6.2780,2.5980,3.1429},
				{0.0200,32.0216,-5.3901,0.1566,1.2923,5.6662,-2.7869,0.1584,1.3200,6.0000,0.0000,0.1602,1.3477,6.3338,2.7869,3.1434},
				{0.0200,31.9928,-5.3902,0.1846,1.4044,5.6073,-2.9448,0.1872,1.4400,6.0000,0.0000,0.1898,1.4756,6.3927,2.9448,3.1442},
				{0.0200,31.9616,-5.3903,0.2149,1.5153,5.5460,-3.0689,0.2184,1.5600,6.0000,0.0000,0.2219,1.6047,6.4540,3.0689,3.1450},
				{0.0200,31.9280,-5.3904,0.2474,1.6250,5.4828,-3.1565,0.2520,1.6800,6.0000,0.0000,0.2566,1.7350,6.5172,3.1565,3.1461},
				{0.0200,31.8920,-5.3906,0.2821,1.7334,5.4187,-3.2051,0.2880,1.8000,6.0000,0.0000,0.2939,1.8666,6.5813,3.2050,3.1475},
				{0.0200,31.8536,-5.3908,0.3189,1.8405,5.3545,-3.2122,0.3264,1.9200,6.0000,0.0000,0.3339,1.9995,6.6455,3.2121,3.1491},
				{0.0200,31.8128,-5.3912,0.3579,1.9463,5.2910,-3.1756,0.3672,2.0400,6.0000,0.0000,0.3765,2.1337,6.7090,3.1754,3.1509},
				{0.0200,31.7696,-5.3916,0.3989,2.0509,5.2291,-3.0932,0.4104,2.1600,6.0000,0.0000,0.4219,2.2691,6.7709,3.0930,3.1531},
				{0.0200,31.7240,-5.3922,0.4420,2.1543,5.1698,-2.9633,0.4560,2.2800,6.0000,0.0000,0.4700,2.4057,6.8301,2.9630,3.1556},
				{0.0200,31.6760,-5.3930,0.4871,2.2565,5.1142,-2.7842,0.5040,2.4000,6.0000,0.0000,0.5209,2.5435,6.8858,2.7839,3.1585},
				{0.0200,31.6256,-5.3939,0.5342,2.3578,5.0631,-2.5548,0.5544,2.5200,6.0000,0.0000,0.5746,2.6822,6.9369,2.5545,3.1618},
				{0.0200,31.5728,-5.3950,0.5834,2.4581,5.0176,-2.2741,0.6072,2.6400,6.0000,0.0000,0.6310,2.8219,6.9824,2.2738,3.1654},
				{0.0200,31.5177,-5.3965,0.6346,2.5577,4.9787,-1.9419,0.6624,2.7600,6.0000,0.0000,0.6902,2.9623,7.0212,1.9415,3.1694},
				{0.0200,31.4601,-5.3982,0.6877,2.6567,4.9476,-1.5581,0.7200,2.8800,6.0000,0.0000,0.7523,3.1033,7.0524,1.5576,3.1739},
				{0.0200,31.4001,-5.4003,0.7428,2.7552,4.9251,-1.1234,0.7800,3.0000,6.0000,0.0000,0.8172,3.2448,7.0748,1.1230,3.1788},
				{0.0200,31.3378,-5.4028,0.7999,2.8534,4.9123,-0.6394,0.8424,3.1200,6.0000,0.0000,0.8849,3.3866,7.0876,0.6389,3.1841},
				{0.0200,31.2730,-5.4057,0.8589,2.9516,4.9102,-0.1082,0.9072,3.2400,6.0000,0.0000,0.9555,3.5284,7.0898,0.1077,3.1899},
				{0.0200,31.2059,-5.4092,0.9199,3.0500,4.9195,0.4670,0.9744,3.3600,6.0000,0.0000,1.0289,3.6700,7.0804,-0.4675,3.1961},
				{0.0200,31.1364,-5.4132,0.9829,3.1488,4.9411,1.0821,1.0440,3.4800,6.0000,0.0000,1.1051,3.8111,7.0588,-1.0826,3.2027},
				{0.0200,31.0646,-5.4178,1.0478,3.2484,4.9758,1.7319,1.1160,3.6000,6.0000,0.0000,1.1842,3.9516,7.0241,-1.7323,3.2098},
				{0.0200,30.9904,-5.4232,1.1148,3.3488,5.0240,2.4102,1.1904,3.7200,6.0000,0.0000,1.2660,4.0911,6.9759,-2.4105,3.2172},
				{0.0200,30.9138,-5.4293,1.1838,3.4506,5.0862,3.1097,1.2672,3.8400,6.0000,0.0000,1.3506,4.2294,6.9137,-3.1099,3.2250},
				{0.0200,30.8349,-5.4362,1.2549,3.5538,5.1626,3.8223,1.3464,3.9600,6.0000,0.0000,1.4379,4.3662,6.8373,-3.8224,3.2331},
				{0.0200,30.7537,-5.4440,1.3281,3.6589,5.2534,4.5390,1.4280,4.0800,6.0000,0.0000,1.5279,4.5011,6.7465,-4.5389,3.2415},
				{0.0200,30.6702,-5.4527,1.4034,3.7660,5.3584,5.2504,1.5120,4.2000,6.0000,0.0000,1.6206,4.6339,6.6415,-5.2502,3.2502},
				{0.0200,30.5843,-5.4625,1.4809,3.8756,5.4774,5.9470,1.5984,4.3200,6.0000,0.0000,1.7159,4.7644,6.5225,-5.9466,3.2591},
				{0.0200,30.4962,-5.4733,1.5607,3.9878,5.6097,6.6195,1.6872,4.4400,6.0000,0.0000,1.8137,4.8922,6.3902,-6.6189,3.2681},
				{0.0200,30.4058,-5.4852,1.6427,4.1029,5.7549,7.2592,1.7784,4.5600,6.0000,0.0000,1.9141,5.0171,6.2450,-7.2584,3.2773},
				{0.0200,30.3131,-5.4983,1.7271,4.2211,5.9121,7.8586,1.8720,4.6800,6.0000,0.0000,2.0168,5.1388,6.0878,-7.8576,3.2864},
				{0.0200,30.2181,-5.5126,1.8140,4.3427,6.0803,8.4118,1.9680,4.8000,6.0000,0.0000,2.1220,5.2572,5.9196,-8.4106,3.2956},
				{0.0200,30.1210,-5.5281,1.9034,4.4679,6.2586,8.9150,2.0664,4.9200,6.0000,0.0000,2.2294,5.3721,5.7414,-8.9137,3.3046},
				{0.0200,30.0216,-5.5449,1.9953,4.5968,6.4460,9.3668,2.1672,5.0400,6.0000,0.0000,2.3391,5.4831,5.5540,-9.3654,3.3135},
				{0.0200,29.9200,-5.5630,2.0899,4.7297,6.6413,9.7684,2.2704,5.1600,6.0000,0.0000,2.4509,5.5903,5.3587,-9.7669,3.3221},
				{0.0200,29.8162,-5.5824,2.1872,4.8665,6.8438,10.1238,2.3760,5.2800,6.0000,0.0000,2.5648,5.6934,5.1563,-10.1222,3.3304},
				{0.0200,29.7102,-5.6031,2.2874,5.0076,7.0526,10.4397,2.4840,5.4000,6.0000,0.0000,2.6806,5.7924,4.9475,-10.4382,3.3382},
				{0.0200,29.6020,-5.6251,2.3904,5.1529,7.2671,10.7256,2.5944,5.5200,6.0000,0.0000,2.7984,5.8870,4.7330,-10.7242,3.3456},
				{0.0200,29.4916,-5.6483,2.4965,5.3027,7.4870,10.9933,2.7072,5.6400,6.0000,0.0000,2.9179,5.9773,4.5132,-10.9921,3.3523},
				{0.0200,29.3790,-5.6727,2.6056,5.4569,7.7121,11.2566,2.8224,5.7600,6.0000,0.0000,3.0392,6.0631,4.2881,-11.2557,3.3584},
				{0.0200,29.2643,-5.6983,2.7179,5.6158,7.9427,11.5309,2.9400,5.8800,6.0000,0.0000,3.1620,6.1442,4.0575,-11.5304,3.3636},
				{0.0200,29.1473,-5.7250,2.8335,5.7794,8.1794,11.8324,3.0600,6.0000,6.0000,0.0000,3.2865,6.2206,3.8208,-11.8324,3.3681},
				{0.0200,29.0280,-5.7527,2.9525,5.9478,8.4229,12.1777,3.1824,6.1200,6.0000,0.0000,3.4123,6.2922,3.5772,-12.1784,3.3715},
				{0.0200,28.9066,-5.7813,3.0749,6.1213,8.6746,12.5830,3.3072,6.2400,6.0000,0.0000,3.5395,6.3587,3.3255,-12.5845,3.3739},
				{0.0200,28.7828,-5.8107,3.2009,6.3000,8.9359,13.0631,3.4344,6.3600,6.0000,0.0000,3.6679,6.4200,3.0642,-13.0655,3.3751},
				{0.0200,28.6567,-5.8407,3.3306,6.4842,9.2085,13.6302,3.5640,6.4800,6.0000,0.0000,3.7974,6.4758,2.7916,-13.6338,3.3750},
				{0.0200,28.5283,-5.8712,3.4641,6.6741,9.4943,14.2930,3.6960,6.6000,6.0000,0.0000,3.9279,6.5259,2.5056,-14.2979,3.3735},
				{0.0200,28.3974,-5.9019,3.6015,6.8700,9.7954,15.0541,3.8304,6.7200,6.0000,0.0000,4.0593,6.5700,2.2044,-15.0607,3.3705},
				{0.0200,28.2641,-5.9326,3.7429,7.0723,10.1136,15.9080,3.9672,6.8400,6.0000,0.0000,4.1915,6.6077,1.8861,-15.9166,3.3659},
				{0.0200,28.1283,-5.9632,3.8885,7.2813,10.4503,16.8373,4.1064,6.9600,6.0000,0.0000,4.3242,6.6387,1.5491,-16.8483,3.3594},
				{0.0200,27.9899,-5.9932,4.0385,7.4974,10.8065,17.8082,4.2480,7.0800,6.0000,0.0000,4.4575,6.6626,1.1927,-17.8220,3.3511},
				{0.0200,27.8489,-6.0224,4.1929,7.7210,11.1818,18.7643,4.3920,7.2000,6.0000,0.0000,4.5911,6.6789,0.8170,-18.7814,3.3407},
				{0.0200,27.7053,-6.0505,4.3520,7.9525,11.5741,19.6184,4.5384,7.3200,6.0000,0.0000,4.7248,6.6874,0.4242,-19.6394,3.3280},
				{0.0200,27.5588,-6.0770,4.5158,8.1921,11.9790,20.2434,4.6872,7.4400,6.0000,0.0000,4.8586,6.6878,0.0189,-20.2689,3.3130},
				{0.0200,27.4096,-6.1015,4.6846,8.4399,12.3882,20.4614,4.8384,7.5600,6.0000,0.0000,4.9922,6.6799,-0.3910,-20.4918,3.2954},
				{0.0200,27.2576,-6.1235,4.8585,8.6956,12.7889,20.0338,4.9920,7.6800,6.0000,0.0000,5.1255,6.6641,-0.7924,-20.0693,3.2751},
				{0.0200,27.1028,-6.1425,5.0377,8.9589,13.1620,18.6550,5.1480,7.8000,6.0000,0.0000,5.2583,6.6408,-1.1663,-18.6953,3.2519},
				{0.0200,26.9452,-6.1579,5.2223,9.2285,13.4811,15.9551,5.3064,7.9200,6.0000,0.0000,5.3905,6.6111,-1.4863,-15.9994,3.2257},
				{0.0200,26.7856,-6.1691,5.4114,9.4551,11.3313,-107.4885,5.4664,8.0000,6.0000,0.0000,5.5214,6.5443,-3.3370,-92.5361,3.1966},
				{0.0200,26.6257,-6.1754,5.6031,9.5853,6.5094,-241.0967,5.6264,8.0000,6.0000,0.0000,5.6497,6.4140,-6.5147,-158.8856,3.1649},
				{0.0200,26.4657,-6.1764,5.7972,9.7086,6.1627,-17.3352,5.7864,8.0000,6.0000,0.0000,5.7755,6.2907,-6.1681,17.3284,3.1307},
				{0.0200,26.3058,-6.1718,5.9937,9.8214,5.6425,-26.0119,5.9464,8.0000,6.0000,0.0000,5.8990,6.1777,-5.6478,26.0169,3.0943},
				{0.0200,26.1461,-6.1612,6.1921,9.9201,4.9361,-35.3207,6.1064,8.0000,6.0000,0.0000,6.0206,6.0789,-4.9410,35.3401,3.0558},
				{0.0200,25.9870,-6.1443,6.3921,10.0010,4.0448,-44.5610,6.2664,8.0000,6.0000,0.0000,6.1406,5.9979,-4.0491,44.5958,3.0158},
				{0.0200,25.8288,-6.1210,6.5933,10.0608,2.9876,-52.8605,6.4264,8.0000,6.0000,0.0000,6.2593,5.9381,-2.9909,52.9102,2.9746},
				{0.0200,25.6716,-6.0911,6.7952,10.0968,1.8016,-59.3033,6.5864,8.0000,6.0000,0.0000,6.3774,5.9020,-1.8036,59.3653,2.9326},
				{0.0200,25.5158,-6.0546,6.9974,10.1076,0.5395,-63.1029,6.7464,8.0000,6.0000,0.0000,6.4952,5.8912,-0.5401,63.1727,2.8905},
				{0.0200,25.3617,-6.0116,7.1993,10.0929,-0.7360,-63.7762,6.9064,8.0000,6.0000,0.0000,6.6133,5.9059,0.7369,63.8478,2.8486},
				{0.0200,25.2095,-5.9623,7.4003,10.0537,-1.9612,-61.2600,7.0664,8.0000,6.0000,0.0000,6.7322,5.9452,1.9634,61.3274,2.8075},
				{0.0200,25.0595,-5.9068,7.6002,9.9921,-3.0798,-55.9274,7.2264,8.0000,6.0000,0.0000,6.8523,6.0069,3.0831,55.9852,2.7677},
				{0.0200,24.9117,-5.8455,7.7984,9.9111,-4.0497,-48.4977,7.3864,8.0000,6.0000,0.0000,6.9741,6.0880,4.0540,48.5424,2.7294},
				{0.0200,24.7663,-5.7787,7.9947,9.8141,-4.8472,-39.8750,7.5464,8.0000,6.0000,0.0000,7.0978,6.1850,4.8521,39.9051,2.6931},
				{0.0200,24.6233,-5.7069,8.1888,9.7048,-5.4666,-30.9701,7.7064,8.0000,6.0000,0.0000,7.2237,6.2944,5.4718,30.9858,2.6590},
				{0.0200,24.4828,-5.6303,8.3805,9.5864,-5.9178,-22.5579,7.8664,8.0000,6.0000,0.0000,7.3520,6.4129,5.9230,22.5611,2.6273},
				{0.0200,24.3447,-5.5496,8.5697,9.4620,-6.2218,-15.1989,8.0264,8.0000,6.0000,0.0000,7.4827,6.5374,6.2268,15.1920,2.5980},
				{0.0200,24.2089,-5.4650,8.7564,9.3339,-6.4062,-9.2237,8.1864,8.0000,6.0000,0.0000,7.6160,6.6656,6.4110,9.2095,2.5714},
				{0.0200,24.0753,-5.3770,8.9405,9.2038,-6.5015,-4.7652,8.3464,8.0000,6.0000,0.0000,7.7519,6.7958,6.5060,4.7464,2.5473},
				{0.0200,23.9437,-5.2859,9.1220,9.0731,-6.5378,-1.8136,8.5064,8.0000,6.0000,0.0000,7.8905,6.9266,6.5418,1.7920,2.5258},
				{0.0200,23.8140,-5.1923,9.3008,8.9422,-6.5433,-0.2747,8.6664,8.0000,6.0000,0.0000,8.0316,7.0575,6.5468,0.2520,2.5070},
				{0.0200,23.6860,-5.0963,9.4770,8.8113,-6.5438,-0.0226,8.8264,8.0000,6.0000,0.0000,8.1754,7.1885,6.5468,-0.0003,2.4907},
				{0.0200,23.5594,-4.9985,9.6506,8.6801,-6.5625,-0.9379,8.9864,8.0000,6.0000,0.0000,8.3218,7.3198,6.5651,0.9155,2.4771},
				{0.0200,23.4340,-4.8991,9.8216,8.5477,-6.6213,-2.9371,9.1464,8.0000,6.0000,0.0000,8.4708,7.4522,6.6234,2.9150,2.4662},
				{0.0200,23.3095,-4.7985,9.9898,8.4129,-6.7411,-5.9910,9.3064,8.0000,6.0000,0.0000,8.6226,7.5871,6.7428,5.9690,2.4579},
				{0.0200,23.1858,-4.6971,10.1553,8.2740,-6.9439,-10.1414,9.4664,8.0000,6.0000,0.0000,8.7771,7.7260,6.9452,10.1186,2.4524},
				{0.0200,23.0625,-4.5952,10.3179,8.1289,-7.2542,-15.5156,9.6264,8.0000,6.0000,0.0000,8.9345,7.8711,7.2550,15.4910,2.4499},
				{0.0200,22.9394,-4.4930,10.4824,8.2250,4.8059,603.0058,9.7864,8.0000,6.0000,0.0000,9.0900,7.7750,-4.8063,-603.0654,2.4454},
				{0.0200,22.8176,-4.3892,10.6653,9.1444,45.9717,2058.2929,9.9464,8.0000,6.0000,0.0000,9.2271,6.8552,-45.9887,-2059.1211,2.4225},
				{0.0200,22.6994,-4.2814,10.8700,10.2336,54.4567,424.2471,10.1064,8.0000,6.0000,0.0000,9.3424,5.7651,-54.5055,-425.8383,2.3778},
				{0.0200,22.5877,-4.1669,11.1034,11.6719,71.9182,873.0771,10.2664,8.0000,6.0000,0.0000,9.4289,4.3245,-72.0305,-876.2502,2.3043},
				{0.0200,22.4872,-4.0425,11.3796,13.8089,106.8466,1746.4181,10.4264,8.0000,6.0000,0.0000,9.4725,2.1823,-107.1088,-1753.9161,2.1879},
				{0.0200,22.4060,-3.9049,11.7209,17.0686,162.9846,2806.8980,10.5864,8.0000,6.0000,0.0000,9.4944,1.0921,-54.5113,2629.8780,2.0061},
				{0.0200,22.3574,-3.7529,12.1447,21.1884,205.9909,2150.3179,10.7464,8.0000,6.0000,0.0000,9.5991,5.2360,207.1959,13085.3578,1.7411},
				{0.0200,22.3549,-3.5936,12.6113,23.3281,106.9835,-4950.3727,10.9064,8.0000,6.0000,0.0000,9.7470,7.3922,107.8092,-4969.3369,1.4327},
				{0.0200,22.3981,-3.4400,13.0276,20.8185,-125.4796,-11623.1529,11.0664,8.0000,6.0000,0.0000,9.8442,4.8636,-126.4308,-11711.9959,1.1751},
				{0.0200,22.4729,-3.2988,13.3568,16.4594,-217.9516,-4623.5981,11.2264,8.0000,6.0000,0.0000,9.8539,0.4820,-219.0787,-4632.3979,1.0056},
				{0.0200,22.5659,-3.1686,13.6170,13.0066,-172.6416,2265.4996,11.3864,8.0000,6.0000,0.0000,9.9136,2.9868,125.2420,17216.0352,0.9053},
				{0.0200,22.6684,-3.0458,13.8299,10.6482,-117.9173,2736.2120,11.5464,8.0000,6.0000,0.0000,10.0206,5.3499,118.1525,-354.4731,0.8523},
				{0.0200,22.7751,-2.9266,14.0084,8.9231,-86.2555,1583.0927,11.7064,8.0000,6.0000,0.0000,10.1621,7.0766,86.3369,-1590.7808,0.8339},
				{0.0200,22.8822,-2.8077,14.1574,7.4492,-73.6975,627.8991,11.8664,8.0000,6.0000,0.0000,10.3331,8.5507,73.7048,-631.6073,0.8449},
				{0.0200,22.9863,-2.6862,14.2762,5.9435,-75.2852,-79.3841,12.0264,8.0000,6.0000,0.0000,10.5343,10.0554,75.2332,76.4209,0.8860},
				{0.0200,23.0831,-2.5588,14.3595,4.1634,-89.0019,-685.8381,12.1864,8.0000,6.0000,0.0000,10.7709,11.8327,88.8635,681.5173,0.9627},
				{0.0200,23.1669,-2.4227,14.3981,1.9313,-111.6075,-1130.2779,12.3464,8.0000,6.0000,0.0000,11.0521,14.0591,111.3204,1122.8457,1.0841},
				{0.0200,23.2298,-2.2758,14.4098,0.5841,-67.3592,2212.4145,12.5064,8.0000,6.0000,0.0000,11.3834,16.5634,125.2170,694.8270,1.2557},
				{0.0200,23.2636,-2.1197,14.4554,2.2765,84.6207,7598.9945,12.6664,8.0000,6.0000,0.0000,11.7483,18.2481,84.2340,-2049.1499,1.4613},
				{0.0200,23.2653,-1.9599,14.4860,1.5344,-37.1042,-6086.2425,12.8264,8.0000,6.0000,0.0000,12.0985,17.5096,-36.9241,-6057.9050,1.6521},
				{0.0200,23.2412,-1.8019,14.5194,1.6695,6.7505,2192.7341,12.9864,8.0000,6.0000,0.0000,12.3849,14.3203,-159.4636,-6126.9743,1.7787},
				{0.0200,23.2041,-1.6462,14.6422,6.1400,223.5254,10838.7466,13.1464,8.0000,6.0000,0.0000,12.5821,9.8591,-223.0632,-3179.9815,1.8159},
				{0.0200,23.1650,-1.4911,14.7975,7.7650,81.2534,-7113.6003,13.3064,8.0000,6.0000,0.0000,12.7468,8.2350,-81.2056,7092.8834,1.8206},
				{0.0200,23.1247,-1.3363,14.9472,7.4847,-14.0156,-4763.4503,13.4664,8.0000,6.0000,0.0000,12.9171,8.5152,14.0128,4760.9164,1.8309},
				{0.0200,23.0825,-1.1819,15.0932,7.2996,-9.2584,237.8560,13.6264,8.0000,6.0000,0.0000,13.0911,8.7003,9.2554,-237.8659,1.8449},
				{0.0200,23.0380,-1.0282,15.2372,7.1992,-5.0190,211.9728,13.7864,8.0000,6.0000,0.0000,13.2671,8.8007,5.0170,-211.9232,1.8609},
				{0.0200,22.9909,-0.8753,15.3807,7.1733,-1.2946,186.2205,13.9464,8.0000,6.0000,0.0000,13.4437,8.8265,1.2940,-186.1481,1.8774},
				{0.0200,22.9414,-0.7232,15.5249,7.2111,1.8890,159.1806,14.1064,8.0000,6.0000,0.0000,13.6194,8.7888,-1.8882,-159.1119,1.8932},
				{0.0200,22.8896,-0.5718,15.6709,7.3011,4.5013,130.6121,14.2664,8.0000,6.0000,0.0000,13.7934,8.6988,-4.4995,-130.5635,1.9072},
				{0.0200,22.8359,-0.4211,15.8195,7.4315,6.5230,101.0884,14.4264,8.0000,6.0000,0.0000,13.9648,8.5684,-6.5208,-101.0675,1.9186},
				{0.0200,22.7807,-0.2709,15.9714,7.5906,7.9520,71.4459,14.5864,8.0000,6.0000,0.0000,14.1330,8.4094,-7.9499,-71.4524,1.9267},
				{0.0200,22.7246,-0.1211,16.1267,7.7666,8.7983,42.3183,14.7464,8.0000,6.0000,0.0000,14.2976,8.2334,-8.7968,-42.3466,1.9314},
				{0.0200,22.6680,0.0286,16.2856,7.9481,9.0764,13.9049,14.9064,8.0000,6.0000,0.0000,14.4587,8.0519,-9.0757,-13.9458,1.9324},
				{0.0200,22.6115,0.1783,16.4481,8.1240,8.7961,-14.0139,15.0664,8.0000,6.0000,0.0000,14.6162,7.8760,-8.7963,13.9708,1.9300},
				{0.0200,22.5557,0.3282,16.6138,8.2832,7.9584,-41.8869,15.2264,8.0000,6.0000,0.0000,14.7705,7.7168,-7.9593,41.8521,1.9243},
				{0.0200,22.5009,0.4786,16.7821,8.4143,6.5557,-70.1333,15.3864,8.0000,6.0000,0.0000,14.9222,7.5857,-6.5570,70.1155,1.9160},
				{0.0200,22.4475,0.6294,16.9522,8.5058,4.5773,-98.9203,15.5464,8.0000,6.0000,0.0000,15.0721,7.4941,-4.5785,98.9251,1.9059},
				{0.0200,22.3957,0.7808,17.1231,8.5462,2.0159,-128.0700,15.7064,8.0000,6.0000,0.0000,15.2212,7.4538,-2.0165,128.0978,1.8950},
				{0.0200,22.3455,0.9327,17.2936,8.5236,-1.1272,-157.1554,15.8664,8.0000,6.0000,0.0000,15.3707,7.4763,1.1275,157.1998,1.8845},
				{0.0200,22.2969,1.0851,17.4621,8.4268,-4.8428,-185.7832,16.0264,8.0000,6.0000,0.0000,15.5222,7.5732,4.8441,185.8285,1.8760},
				{0.0200,22.2492,1.2379,17.6270,8.2443,-9.1218,-213.9485,16.1864,8.0000,6.0000,0.0000,15.6773,7.7557,9.1234,213.9688,1.8711},
				{0.0200,22.2581,1.2093,19.6272,100.0106,4588.3138,229871.7798,16.3464,8.0000,6.0000,0.0000,17.6775,100.0118,4612.8059,230184.1238,-1.2705},
				{0.0200,22.3056,1.0565,19.7844,7.8572,-4607.6694,-459799.1613,16.5064,8.0000,6.0000,0.0000,17.8404,8.1428,-4593.4497,-460312.7819,-1.2676},
				{0.0200,22.3537,0.9039,19.9390,7.7313,-6.2975,230068.5955,16.6664,8.0000,6.0000,0.0000,18.0058,8.2687,6.2968,229987.3280,-1.2622},
				{0.0200,22.4028,0.7516,20.0911,7.6066,-6.2332,3.2188,16.8264,8.0000,6.0000,0.0000,18.1736,8.3934,6.2321,-3.2392,-1.2544},
				{0.0200,22.4534,0.5998,20.2407,7.4802,-6.3176,-4.2232,16.9864,8.0000,6.0000,0.0000,18.3440,8.5197,6.3161,4.2013,-1.2440},
				{0.0200,22.5057,0.4486,20.3877,7.3494,-6.5411,-11.1725,17.1464,8.0000,6.0000,0.0000,18.5170,8.6505,6.5390,11.1474,-1.2310},
				{0.0200,22.5601,0.2982,20.5319,7.2114,-6.9000,-17.9452,17.3064,8.0000,6.0000,0.0000,18.6928,8.7884,6.8973,17.9149,-1.2152},
				{0.0200,22.6172,0.1487,20.6732,7.0635,-7.3952,-24.7590,17.4664,8.0000,6.0000,0.0000,18.8715,8.9363,7.3918,24.7213,-1.1965},
				{0.0200,22.6773,0.0004,20.8113,6.9029,-8.0298,-31.7311,17.6264,8.0000,6.0000,0.0000,19.0535,9.0968,8.0254,31.6836,-1.1745},
				{0.0200,22.7409,-0.1464,20.9458,6.7268,-8.8067,-38.8484,17.7864,8.0000,6.0000,0.0000,19.2389,9.2728,8.8012,38.7878,-1.1491},
				{0.0200,22.8084,-0.2914,21.0764,6.5323,-9.7248,-45.9037,17.9464,8.0000,6.0000,0.0000,19.4283,9.4671,9.7177,45.8266,-1.1197},
				{0.0200,22.8805,-0.4343,21.2028,6.3168,-10.7726,-52.3877,18.1064,8.0000,6.0000,0.0000,19.6219,9.6824,10.7635,52.2908,-1.0861},
				{0.0200,22.9577,-0.5744,21.3244,6.0785,-11.9192,-57.3298,18.2664,8.0000,6.0000,0.0000,19.8203,9.9206,11.9077,57.2095,-1.0476},
				{0.0200,23.0406,-0.7113,21.4407,5.8164,-13.1010,-59.0914,18.4264,8.0000,6.0000,0.0000,20.0240,10.1823,13.0867,58.9473,-1.0040},
				{0.0200,23.1297,-0.8441,21.5513,5.5323,-14.2044,-55.1685,18.5864,8.0000,6.0000,0.0000,20.2333,10.4660,14.1868,55.0047,-0.9546},
				{0.0200,23.2257,-0.9721,21.6560,5.2314,-15.0473,-42.1454,18.7464,8.0000,6.0000,0.0000,20.4486,10.7666,15.0263,41.9755,-0.8993},
				{0.0200,23.3289,-1.0943,21.7544,4.9240,-15.3692,-16.0949,18.9064,8.0000,6.0000,0.0000,20.6701,11.0735,15.3452,15.9473,-0.8378},
				{0.0200,23.4398,-1.2096,21.8470,4.6271,-14.8460,26.1588,19.0664,8.0000,6.0000,0.0000,20.8975,11.3699,14.8205,-26.2382,-0.7703},
				{0.0200,23.5586,-1.3168,21.9343,4.3640,-13.1527,84.6626,19.2264,8.0000,6.0000,0.0000,21.1301,11.6324,13.1281,-84.6161,-0.6976},
				{0.0200,23.6850,-1.4148,22.0175,4.1624,-10.0843,153.4228,19.3864,8.0000,6.0000,0.0000,21.3668,11.8337,10.0641,-153.1990,-0.6209},
				{0.0200,23.8186,-1.5027,22.0985,4.0483,-5.7040,219.0168,19.5464,8.0000,6.0000,0.0000,21.6058,11.9476,5.6921,-218.6040,-0.5419},
				{0.0200,23.9588,-1.5797,22.1793,4.0396,-0.4333,263.5344,19.7064,8.0000,6.0000,0.0000,21.8449,11.9562,0.4323,-262.9865,-0.4627},
				{0.0200,24.1046,-1.6455,22.2621,4.1399,5.0137,272.3492,19.8664,8.0000,6.0000,0.0000,22.0820,11.8561,-5.0032,-271.7792,-0.3855},
				{0.0200,24.2550,-1.7001,22.3488,4.3371,9.8593,242.2796,20.0264,8.0000,6.0000,0.0000,22.3152,11.6594,-9.8395,-241.8127,-0.3123},
				{0.0200,24.4088,-1.7440,22.4410,4.6077,13.5304,183.5534,20.1864,8.0000,6.0000,0.0000,22.5430,11.3893,-13.5049,-183.2697,-0.2445},
				{0.0200,24.5652,-1.7779,22.5394,4.9238,15.8066,113.8118,20.3464,8.0000,6.0000,0.0000,22.7644,11.0737,-15.7793,-113.7220,-0.1829},
				{0.0200,24.7232,-1.8026,22.6446,5.2597,16.7927,49.3019,20.5064,8.0000,6.0000,0.0000,22.9792,10.7383,-16.7666,-49.3635,-0.1282},
				{0.0200,24.8800,-1.8189,22.7548,5.5090,12.4651,-216.3791,20.6640,7.8800,-6.0000,0.0000,23.1842,10.2496,-24.4388,-383.6092,-0.0807},
				{0.0200,25.0349,-1.8282,22.8694,5.7310,11.1040,-68.0561,20.8192,7.7600,-6.0000,0.0000,23.3800,9.7879,-23.0834,67.7708,-0.0402},
				{0.0200,25.1876,-1.8317,22.9878,5.9209,9.4912,-80.6363,20.9720,7.6400,-6.0000,0.0000,23.5671,9.3584,-21.4756,80.3873,-0.0058},
				{0.0200,25.3380,-1.8304,23.1094,6.0779,7.8510,-82.0122,21.1224,7.5200,-6.0000,0.0000,23.7464,8.9616,-19.8394,81.8102,0.0230},
				{0.0200,25.4859,-1.8251,23.2335,6.2041,6.3081,-77.1416,21.2704,7.4000,-6.0000,0.0000,23.9183,8.5956,-18.2997,76.9847,0.0470},
				{0.0200,25.6313,-1.8168,23.3595,6.3025,4.9208,-69.3693,21.4160,7.2800,-6.0000,0.0000,24.0834,8.2573,-16.9147,69.2504,0.0665},
				{0.0200,25.7741,-1.8062,23.4871,6.3766,3.7065,-60.7140,21.5592,7.1600,-6.0000,0.0000,24.2423,7.9433,-15.7022,60.6253,0.0822},
				{0.0200,25.9143,-1.7937,23.6157,6.4298,2.6609,-52.2796,21.7000,7.0400,-6.0000,0.0000,24.3953,7.6501,-14.6579,52.2139,0.0944},
				{0.0200,26.0520,-1.7800,23.7450,6.4652,1.7689,-44.6005,21.8384,6.9200,-6.0000,0.0000,24.5428,7.3748,-13.7669,44.5519,0.1035},
				{0.0200,26.1873,-1.7656,23.8747,6.4854,1.0112,-37.8833,21.9744,6.8000,-6.0000,0.0000,24.6851,7.1146,-13.0100,37.8474,0.1098},
				{0.0200,26.3200,-1.7507,24.0045,6.4928,0.3680,-32.1597,22.1080,6.6800,-6.0000,0.0000,24.8224,6.8672,-12.3673,32.1331,0.1135},
				{0.0200,26.4504,-1.7357,24.1343,6.4892,-0.1795,-27.3768,22.2392,6.5600,-6.0000,0.0000,24.9550,6.6308,-11.8201,27.3570,0.1149},
				{0.0200,26.5783,-1.7210,24.2638,6.4762,-0.6485,-23.4470,22.3680,6.4400,-6.0000,0.0000,25.0831,6.4038,-11.3515,23.4323,0.1142},
				{0.0200,26.7039,-1.7067,24.3929,6.4551,-1.0540,-20.2748,22.4944,6.3200,-6.0000,0.0000,25.2068,6.1849,-10.9462,20.2638,0.1115},
				{0.0200,26.8272,-1.6932,24.5215,6.4270,-1.4093,-17.7693,22.6184,6.2000,-6.0000,0.0000,25.3263,5.9730,-10.5910,17.7612,0.1070},
				{0.0200,26.9481,-1.6806,24.6493,6.3924,-1.7263,-15.8493,22.7400,6.0800,-6.0000,0.0000,25.4416,5.7676,-10.2741,15.8434,0.1007},
				{0.0200,27.0668,-1.6690,24.7764,6.3521,-2.0152,-14.4439,22.8592,5.9600,-6.0000,0.0000,25.5530,5.5678,-9.9853,14.4398,0.0929},
				{0.0200,27.1831,-1.6587,24.9025,6.3064,-2.2850,-13.4914,22.9760,5.8400,-6.0000,0.0000,25.6604,5.3735,-9.7156,13.4888,0.0835},
				{0.0200,27.2972,-1.6498,25.0276,6.2555,-2.5438,-12.9368,23.0904,5.7200,-6.0000,0.0000,25.7641,5.1844,-9.4569,12.9354,0.0728},
				{0.0200,27.4089,-1.6423,25.1516,6.1996,-2.7983,-12.7287,23.2024,5.6000,-6.0000,0.0000,25.8641,5.0004,-9.2023,12.7285,0.0608},
				{0.0200,27.5183,-1.6364,25.2744,6.1385,-3.0547,-12.8173,23.3120,5.4800,-6.0000,0.0000,25.9606,4.8214,-8.9459,12.8181,0.0477},
				{0.0200,27.6255,-1.6320,25.3958,6.0721,-3.3177,-13.1513,23.4192,5.3600,-6.0000,0.0000,26.0535,4.6478,-8.6829,13.1531,0.0334},
				{0.0200,27.7302,-1.6293,25.5158,6.0003,-3.5912,-13.6763,23.5240,5.2400,-6.0000,0.0000,26.1431,4.4796,-8.4093,13.6789,0.0182},
				{0.0200,27.8326,-1.6283,25.6343,5.9227,-3.8779,-14.3336,23.6264,5.1200,-6.0000,0.0000,26.2295,4.3171,-8.1225,14.3369,0.0022},
				{0.0200,27.9326,-1.6289,25.7511,5.8392,-4.1791,-15.0601,23.7264,5.0000,-6.0000,0.0000,26.3127,4.1607,-7.8213,15.0641,-0.0146},
				{0.0200,28.0302,-1.6312,25.8660,5.7493,-4.4949,-15.7895,23.8240,4.8800,-6.0000,0.0000,26.3929,4.0106,-7.5054,15.7941,-0.0320},
				{0.0200,28.1253,-1.6351,25.9791,5.6528,-4.8240,-16.4542,23.9192,4.7600,-6.0000,0.0000,26.4702,3.8671,-7.1762,16.4592,-0.0499},
				{0.0200,28.2179,-1.6405,26.0901,5.5495,-5.1638,-16.9885,24.0120,4.6400,-6.0000,0.0000,26.5448,3.7304,-6.8363,16.9937,-0.0681},
				{0.0200,28.3081,-1.6475,26.1989,5.4393,-5.5104,-17.3324,24.1024,4.5200,-6.0000,0.0000,26.6168,3.6006,-6.4896,17.3377,-0.0865},
				{0.0200,28.3957,-1.6559,26.3053,5.3221,-5.8591,-17.4359,24.1904,4.4000,-6.0000,0.0000,26.6864,3.4778,-6.1407,17.4409,-0.1049},
				{0.0200,28.4807,-1.6657,26.4093,5.1980,-6.2044,-17.2623,24.2760,4.2800,-6.0000,0.0000,26.7536,3.3618,-5.7954,17.2669,-0.1233},
				{0.0200,28.5632,-1.6767,26.5106,5.0672,-6.5402,-16.7911,24.3592,4.1600,-6.0000,0.0000,26.8187,3.2527,-5.4595,16.7952,-0.1414},
				{0.0200,28.6431,-1.6888,26.6092,4.9300,-6.8606,-16.0199,24.4400,4.0400,-6.0000,0.0000,26.8817,3.1499,-5.1390,16.0233,-0.1592},
				{0.0200,28.7204,-1.7019,26.7050,4.7868,-7.1599,-14.9636,24.5184,3.9200,-6.0000,0.0000,26.9428,3.0531,-4.8397,14.9662,-0.1765},
				{0.0200,28.7951,-1.7158,26.7977,4.6382,-7.4329,-13.6528,24.5944,3.8000,-6.0000,0.0000,27.0020,2.9617,-4.5666,13.6546,-0.1933},
				{0.0200,28.8672,-1.7306,26.8874,4.4847,-7.6755,-12.1308,24.6680,3.6800,-6.0000,0.0000,27.0595,2.8753,-4.3240,12.1317,-0.2094},
				{0.0200,28.9367,-1.7459,26.9740,4.3270,-7.8845,-10.4493,24.7392,3.5600,-6.0000,0.0000,27.1154,2.7930,-4.1150,10.4494,-0.2247},
				{0.0200,29.0037,-1.7617,27.0573,4.1658,-8.0578,-8.6640,24.8080,3.4400,-6.0000,0.0000,27.1696,2.7141,-3.9417,8.6635,-0.2393},
				{0.0200,29.0681,-1.7779,27.1373,4.0019,-8.1944,-6.8307,24.8744,3.3200,-6.0000,0.0000,27.2224,2.6380,-3.8051,6.8295,-0.2529},
				{0.0200,29.1299,-1.7943,27.2140,3.8360,-8.2944,-5.0011,24.9384,3.2000,-6.0000,0.0000,27.2737,2.5639,-3.7052,4.9995,-0.2656},
				{0.0200,29.1893,-1.8109,27.2874,3.6689,-8.3589,-3.2210,25.0000,3.0800,-6.0000,0.0000,27.3235,2.4911,-3.6408,3.2191,-0.2774},
				{0.0200,29.2461,-1.8274,27.3574,3.5011,-8.3894,-1.5281,25.0592,2.9600,-6.0000,0.0000,27.3719,2.4189,-3.6103,1.5260,-0.2882},
				{0.0200,29.3005,-1.8438,27.4241,3.3333,-8.3884,0.0484,25.1160,2.8400,-6.0000,0.0000,27.4188,2.3467,-3.6113,-0.0506,-0.2981},
				{0.0200,29.3524,-1.8600,27.4874,3.1661,-8.3587,1.4875,25.1704,2.7200,-6.0000,0.0000,27.4643,2.2739,-3.6411,-1.4896,-0.3070},
				{0.0200,29.4019,-1.8759,27.5474,3.0001,-8.3032,2.7757,25.2224,2.6000,-6.0000,0.0000,27.5083,2.1999,-3.6966,-2.7777,-0.3150},
				{0.0200,29.4490,-1.8915,27.6041,2.8356,-8.2251,3.9059,25.2720,2.4800,-6.0000,0.0000,27.5508,2.1244,-3.7748,-3.9078,-0.3221},
				{0.0200,29.4937,-1.9066,27.6576,2.6730,-8.1275,4.8762,25.3192,2.3600,-6.0000,0.0000,27.5917,2.0470,-3.8723,-4.8779,-0.3284},
				{0.0200,29.5361,-1.9211,27.7078,2.5127,-8.0138,5.6883,25.3640,2.2400,-6.0000,0.0000,27.6311,1.9673,-3.9861,-5.6898,-0.3338},
				{0.0200,29.5761,-1.9351,27.7549,2.3550,-7.8868,6.3467,25.4064,2.1200,-6.0000,0.0000,27.6688,1.8850,-4.1131,-6.3480,-0.3385},
				{0.0200,29.6138,-1.9485,27.7989,2.2000,-7.7497,6.8578,25.4464,2.0000,-6.0000,0.0000,27.7048,1.8000,-4.2503,-6.8588,-0.3425},
				{0.0200,29.6492,-1.9612,27.8399,2.0479,-7.6051,7.2287,25.4840,1.8800,-6.0000,0.0000,27.7390,1.7121,-4.3948,-7.2296,-0.3459},
				{0.0200,29.6823,-1.9732,27.8779,1.8988,-7.4558,7.4674,25.5192,1.7600,-6.0000,0.0000,27.7714,1.6212,-4.5442,-7.4681,-0.3487},
				{0.0200,29.7131,-1.9844,27.9129,1.7527,-7.3041,7.5818,25.5520,1.6400,-6.0000,0.0000,27.8020,1.5273,-4.6959,-7.5823,-0.3509},
				{0.0200,29.7417,-1.9949,27.9451,1.6097,-7.1525,7.5799,25.5824,1.5200,-6.0000,0.0000,27.8306,1.4303,-4.8475,-7.5803,-0.3527},
				{0.0200,29.7679,-2.0046,27.9745,1.4696,-7.0031,7.4697,25.6104,1.4000,-6.0000,0.0000,27.8572,1.3304,-4.9969,-7.4699,-0.3541},
				{0.0200,29.7919,-2.0135,28.0012,1.3324,-6.8580,7.2589,25.6360,1.2800,-6.0000,0.0000,27.8817,1.2276,-5.1420,-7.2591,-0.3552},
				{0.0200,29.8137,-2.0216,28.0251,1.1981,-6.7188,6.9553,25.6592,1.1600,-6.0000,0.0000,27.9042,1.1219,-5.2812,-6.9555,-0.3559},
				{0.0200,29.8332,-2.0288,28.0465,1.0663,-6.5875,6.5667,25.6800,1.0400,-6.0000,0.0000,27.9244,1.0137,-5.4125,-6.5668,-0.3564},
				{0.0200,29.8504,-2.0352,28.0652,0.9370,-6.4655,6.1008,25.6984,0.9200,-6.0000,0.0000,27.9425,0.9030,-5.5345,-6.1008,-0.3568},
				{0.0200,29.8654,-2.0408,28.0814,0.8099,-6.3542,5.5653,25.7144,0.8000,-6.0000,0.0000,27.9583,0.7901,-5.6458,-5.5653,-0.3570},
				{0.0200,29.8782,-2.0456,28.0951,0.6848,-6.2548,4.9681,25.7280,0.6800,-6.0000,0.0000,27.9718,0.6752,-5.7452,-4.9681,-0.3571},
				{0.0200,29.8886,-2.0495,28.1063,0.5614,-6.1685,4.3171,25.7392,0.5600,-6.0000,0.0000,27.9830,0.5586,-5.8315,-4.3171,-0.3571},
				{0.0200,29.8900,-2.0500,28.1078,0.0721,-24.4673,-914.9401,25.7406,0.4400,-6.0000,0.0000,27.9844,0.0721,-24.3249,-924.6711,-0.3571},
				{0.0200,29.8900,-2.0500,28.1078,0.0000,-3.6048,1043.1224,25.7406,0.3200,-6.0000,0.0000,27.9844,0.0000,-3.6029,1036.1000,-0.3571},
				{0.0200,29.8900,-2.0500,28.1078,0.0000,0.0000,180.2421,25.7406,0.2000,-6.0000,0.0000,27.9844,0.0000,0.0000,180.1467,-0.3571},
				{0.0200,29.8900,-2.0500,28.1078,0.0000,0.0000,0.0000,25.7406,0.0800,-6.0000,0.0000,27.9844,0.0000,0.0000,0.0000,-0.3571},
				{0.0200,29.8900,-2.0500,28.1078,0.0000,0.0000,0.0000,25.7406,-0.0400,-6.0000,0.0000,27.9844,0.0000,0.0000,0.0000,-0.3571},

	    };

	@Override
	public double[][] getPath() {
	    return points;
	}
}