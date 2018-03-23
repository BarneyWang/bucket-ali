package me.heng.list;


import java.util.HashMap;
import java.util.HashSet;

/**
 * AUTHOR: wangdi
 * DATE: 2017/6/27
 * TIME: 下午1:55
 */
public class TestSet {


    public static void main(String[] args) {
//        HashSet<String> s = new HashSet<String>();
//        System.out.println(s.contains("1"));
//        System.out.println(s.contains("1"));
//        String str = "1";
//        String realUnitType = "CENTER_UNIT."
//                +((StringUtils.isNotBlank(str) ? str: "center"));
//        System.out.println(realUnitType);
//        HashMap map = new HashMap();
//        add(map);
//        System.out.println(map.size());
//        System.out.println(map.get("1"));

//        String str ="";
//        boolean isS=true;
//        if(StringUtils.isBlank(str)||false){
//            System.out.println(1);
//        }else{
//            System.out.println(2);
//        }

        String str="ak-code-phabricator,acc-acid-et2,acc-acs-et2,acc-asm-et2,acc-fs-et2,acc-fs-ivr-et2,acc-kaproxy-et2,acc-metaq,acc-rec-et2,acc-sipcap-et2,acc-statserver-et2,accs-dm,accs-sal,address-server,addresstokenizer,adp,air,aladdin,alc,ali360,alicarecore,alicom-recommend,alipay_notify,allcbu-notify,amdc,amp-message,anywhere,aqcenter,arcticmaster,arcticsmartisan,argus,artisan,authcenter,baoxianmisc,baoxianpricing,baoxianrecom,baoxianrisk,bbq,bicester,birdsnestcenter,buc-acl-hsf,buc-acl-hsf-dp,buc-authcenter,buc-sso,buc-uc-hsf,buy2,buycenter,cachechecker,capacitymanager,carcenter,carts,cartsapi,cartscache,cdc,cdc-dump,chanel,channelcenter,chongzhibiz,chongzhidata,chongzhidispatch,chongzhimisc,chongzhimobile,cnalgo,cncbf,cndps,cnortools-center,cnortools-task,coincore,collina,collinadecryptor,collinafacade,communityuis,connected,consign,consigncenter,corona-server,credit.center,crmcenter,crmroute,ctr,cuntaonetwork,customercenter.interface,cybertron,d4s,daa-traffic-hub,daa-traffic-op,delivery,detail,detailskip,diablo,diamond,dna,doraemon,dosa,durex,e56,easygocore,ecardcpgw,ecardmisccenter,falcon9r,fivemin,flow,fundgateway,fundplatform,geb,gebsupport,gemini,glaucus,globaladdressservice,gns,gsearch,guide,harbor,havanaauth,havanamlogin,headline,hlservice,iforest,industry-tagcenter,industry.center,inventoryhotel,inventoryplatform,iopen-core,itemcenter,itemtools,jiajucenter,jingweiconsole,ju,juathena,jucol,jucube,judetail,juhsf,juseller,langyan,lexus,liaoyuan,lightspeed,loc-vdump,login,logisticscenter,logisticsmarket-center,logisticsmarket-task,luna,macao,macross,malldetail,malldetailskip,mallitemcenter,marketing-center,maybach,mclaren,member-business-center,membercenter,memberplatform,metaq,metaq-ops,metaqtransfer,minerva-base,mix2notify,mix3notify,mix_notify,motormaster,mtask,mtee,mteemodel,mtop,mtopplatform,myju,namesrv,notify,offer_cbu,omni-industry-center,omni-sourcing,onepiece,onlinecs,openair,openbase,orderplatform,palisade,pamirsqogir,pamirssupport,pbservice,pesystem3,phenix-center,pointcenter,polaris,price-service,promotioncenter,promotiontag,protectcenter,qccenter,quicksilver,quotacenter,ratecenter,refundface,refundface2,refundplatform,refundplatform2,relationplatform,relationrecommend,renqun,resourcecenter,resourcecenterops,rmc,robot,robot-portal,s-account,saipan,saleenginesync,scskuconsole,seattle,security-tesla,securitymatrix,shellcenter,shopcenter,sic,sirius,site_service_center,sitesupport,smartisan,stationmobile,stationplatform,subaru,sync,taokeeper,tbusergw,tddl,tmallbuy,tmallequity,tmallincubator,tmallreport,top,topapi,toptim,track-service,trade_notify,trade_sub2_notify,trade_sub_notify,tradecenter,tradedata.center,trademanager,tradeplatform,trippe,trippeunit,triprule,tsplatform,ucc,uicfinal,uiclogin,uicplus,ultima,umid,ump,upp,usa,ussc,vipserver,volvo,wallet,warehouse-resource-center,warehouserouteservice,wdn,widgetpt,wormholesource,wsearch,wsm,wsnssync,wtt-channel-server,wtt-irs,wtt-trade-service,wtt-trade-web,wukong-amorite,wukong-fastproxy,wukong-file,wukong-im-processor,wukong-oauth,wukong-proxy,wukong-push-amorite,wukong-register,wukong-shaka,wukong-syncserver,xflush-cloud,xspace-account,xspace-bss,xspace-payment,xspace-scheduler,yosemite,hadesP0App";
        String str1="paycenter-ewallet,paycenter-schedule,paycenter-acl,passport-asyncservice,passport-userprofile,passport-schedule,passport-sdkservice,paycenter-risk,paycenter-signature,paycenter-gateway,passport-userservice,passport-login,ais-hades,aone-mix,aone-base,accountcenter,alp,alp.spp,alphabird,alphabird-rank,bearlake,bearlake-portal,bmsbase,bmscore,bmsgateway,bmsportal,bmsreverse,businesscenter,businessinventorysolution,cainiaowork,classifyplatform,cncbp,cndcp,cndcppacproxy,cndeliverybuilder,cndwckdb,cngfc,cngrc,cngsep,cnortools-jwserver,cnortools-task,cnuser,cnwireless,consignwork,cpsdklog,customsplatform,datastation,deliverydump,diccenter,dipan-engine,dispatchservice,division-service,dms-sorting,dorado,dps,dragonhorse,ecpgateway,ecphousekeeper,fcs,formula,global-division,guoguo,guoguowap,jingwei4lc,ld-data-service,link,locationservice,logisticsbeehive,logisticsbus,logisticsdetail,logisticsdetailoverseas,logisticsvsearch,nbantispam,nbbalance,nbbusiness,nbdispatchcenter,nblogisticdata,nbmarketcenter,nbnvwa,nbordercenter,nborderfront,nbpushcenter,nbreward,nearest-operators,octans,ofc,partneraccesscenter,poststation,pscm-asc,pscm-base,pscm-icp,pscm-lep,reachableservice,schedulecenter,scmcore,stationpicker,sugagent,tms-dataaccess,track,vsp,warehousecenter,waybill,waybill-face,waybill-partner,waybill-print,waybill-sequence,wh-platform,wlbaccountprod,wlbmywlb,workplatform,wuliumisc,wuliupingjia,yima,p1TestApp";
        System.out.println(str.split(",").length);
        System.out.println(str1.split(",").length);
    }


    public static void add(HashMap map){
        map.put("1", "2");
    }
}
