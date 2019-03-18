/*
 Navicat Premium Data Transfer

 Source Server         : AO_pro
 Source Server Type    : MySQL
 Source Server Version : 50536
 Source Host           : 47.107.88.223   
 Source Database       : votesystem

 Target Server Type    : MySQL
 Target Server Version : 50536
 File Encoding         : utf-8

 Date: 01/31/2019 01:21:38 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `campaigner`
-- ----------------------------
DROP TABLE IF EXISTS `campaigner`;
CREATE TABLE `campaigner` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `campaigner`
-- ----------------------------
BEGIN;
INSERT INTO `campaigner` VALUES ('1', 'lisa'), ('2', 'lida'), ('3', 'marico'), ('4', 'json'), ('5', 'rose');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `pswd` varchar(10) DEFAULT NULL,
  `role` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '1'), ('2', 'user1', 'user1', '2'), ('3', 'user2', 'user2', '2'), ('4', 'user3', 'user3', '2'), ('5', 'user4', 'user4', '2'), ('6', 'user5', 'user5', '2');
COMMIT;

-- ----------------------------
--  Table structure for `vote`
-- ----------------------------
DROP TABLE IF EXISTS `vote`;
CREATE TABLE `vote` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `campaignerid` int(10) DEFAULT NULL,
  `voteUser` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `voteCiphertext` varchar(512) COLLATE utf8_bin DEFAULT NULL,
  `votePlaintext` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=211 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `vote`
-- ----------------------------
BEGIN;
INSERT INTO `vote` VALUES ('191', '1', 'user1', '12641214985568838783313084799493800176310837680251779905470632822658007760419433698555529831965907066942036559461165417350554535435601421079466541919331607706571351384995654385150011834894112230965862632026779622824518551911205653181117490247400877934671230007349087671142707095837073376985085063568699162106', '1'), ('192', '2', 'user1', '28059704948850014356684900420311626018505769736124410776524760536613915741619673160948559491924061884369083699201481317957339813909507541345765129986480234839041844435639518724802197823387491200276073941937253513896255563327040545699104153407476014790507399681430150764508480527936781420111411249384018123110', '0'), ('193', '3', 'user1', '23333593455855598541478139697312818345559714905444349405014301902626648827895933211188322300420849840507730744213054992366005895561865082413314056232846245392874478770814370000130340977357079280879415186234139522591231994897160819002002224027337795518870426018266777888190903062939974573232095772295164630114', '0'), ('194', '4', 'user1', '30761371806862926085603577004796180120638044746199534455497138328349460212458590862249458919196056469675145726049122474472380143597909088195100759170304421600186516592667902694846274548574473256446767168855572485545355266855704316696841648664014352057125248425301477568522963006639802730829406658788081780423', '0'), ('195', '5', 'user1', '7695324116886853466276678887105412089317283552073986415040114298377361452477076715987811838791570252043637058115764272561664790833571673955789630596984673808651235949393530320199292954545473381071527985982198965276859520917384487162936298605991740130285337768883689487251966225923672010005557380136979348375', '0'), ('196', '1', 'user1', '5674470439723730786131593426482867750216168510043286276955937716376291770198169319110086189827920455588083098417317524142490063824603357646433863993052049127948935059195849024126026773958190750146278308968580618825715256963365220485740779277895745578959829149985275531871490244650793069744334940199057732979', '1'), ('197', '2', 'user1', '28310638727187314565314111271792387451065599940398809899849630236098982662283327736660832713305408842735890602997112585590232905579826869536657162436400595218137304128947395535470871228799696748612451946160793317322266358164693755288397031489104730406412889709563799862762639182257078701087428912141980902059', '0'), ('198', '3', 'user1', '30973203859916778130526098104592541835035462571533871222773772431332148959901324810039559447369742237083519324048264328373261396780101006856139292724250257364215485729359358248614639671595132332705537231777646232895551248915005837028286001618655567859916458523640515372202455943657391630979870644495984102980', '0'), ('199', '4', 'user1', '16699081620480036002695689008676620514377058210231981284802870611778077767457673375556513956000051895943772509872199571755957390278426525619421581271860008293577276879103426761540030111152767458547823933425976211633218103118589275336361668728352765121741957756889208583717051890520752862256380285603931863316', '0'), ('200', '5', 'user1', '2533787980921290872117663891272101317140474681802883424678566483132735046194411096169930306075153412047011293744240011855934326372686137520959222812597655462862165337956166973217067044330609535035598948278708913317699866831077165892594162583017572080802286170800608768581804027894783343831477744166349120153', '0'), ('201', '1', 'user2', '514031991500934578596553878358588081593499073828602985835111017852138961938703296961603050933951552701993522001949586239051122384836227913700976502242633096362122999692197936026174292842485628268806226533435372433678415788748104424227280575225520449395825837624128689576596009801985115122359586605369199548', '0'), ('202', '2', 'user2', '31309821337506196247427442331468963109078381670591831857459372304779178617799683629748673377193988909137219446104354136154252321320727984610944320073368805663867462995848703603668767554280784728869780890583089248573514401730263937007329823592595383351024624310765276475274303911339163826792589319730354308595', '0'), ('203', '3', 'user2', '21751605230199974609873312446282204399345937245750426554906656387377671779193781713770700584248901782974369864716438238514472857768572530436574264504939279463923883029846818241190347552189165578391426458822646280173515465305423626800402293323663106127641182744466822864668569924772022600391059167969689999627', '0'), ('204', '4', 'user2', '17938344186641819704168212265866108328882801580672583736432738730660346091648918472364888005462274783147088475798232603733184854410617955780735422664357914466201594245372636417554259073029846700116773981789722236745190131865323226066274267564464878041714409566989851797633896426475963690667274408723011083176', '1'), ('205', '5', 'user2', '9331934919166538799093644647746386167876038116808159213120996863258134497603615297483173145715247067275479535430143536030805190643555464959636793258631206500216108898078383167719520805124279523518191177511603926642929303523724990624628328614200209440642341508355147085380443957790907244083267904529553836780', '0'), ('206', '1', 'user2', '15031024972444057496651113507546490684275198456013623645408835320806323175506722631188816714482548397033369096420357580064833862252457357453302686534978836294116343340683812136319205200902831378500070496187288799983360130097647699644111745004533816637829809598686491543017338110675558023761568929865131307328', '0'), ('207', '2', 'user2', '8535112067746612644450076522220391185075834107621325758926396899430436974429622223929835085298124624096549979532503303262723135967273433100387232608404192593095004792503529242905468807174737560288478827870980951312834843999024763402980871778365896178205456549828506446008031386871686145390575991710412631359', '1'), ('208', '3', 'user2', '20262174564701226428921153370024503053376101425802551985197958549508729396171959290402357068896144929815732716357014465172411112947709627433132064773098987818211162231918692096841972318961023323740944317560184998417251120072062013516507651321036633883517661957038390814806975150024168756254424582076046867735', '0'), ('209', '4', 'user2', '13894170462927253660450546896170593599661116391432268753542948142388897240153905518528043541476541225542828636117877879389447630904441910005606122480098572982373972598597746838058004415680194631114829163987175264883613934422816829472473937744663727129506292234980562825336084116654503519448501902657399861063', '0'), ('210', '5', 'user2', '3296040527063074224593584605224552672127456347922281649479954092483868643253934533839943844570192702986832715069448802848992644136879653665500995002402086781396506591478945432130859103717685944894434351227648847356239523211794626789542297494803847705802754903058794732717278803454296634670655978089030963167', '0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
