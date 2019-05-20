package org.seckill.service.impl;


import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.model.crf.CRFLexicalAnalyzer;
import com.hankcs.hanlp.seg.Dijkstra.DijkstraSegment;
import com.hankcs.hanlp.seg.NShort.NShortSegment;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.tokenizer.IndexTokenizer;

import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import com.hankcs.hanlp.tokenizer.SpeedTokenizer;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import org.seckill.entity.baseResponse;
import org.seckill.service.HanlpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class HanlpserviceImpl implements HanlpService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    private Segment shortestSegment = new DijkstraSegment().enableCustomDictionary(false).enablePlaceRecognize(true).enableOrganizationRecognize(true);
    private Segment nShortSegment = new NShortSegment().enableCustomDictionary(false).enablePlaceRecognize(true).enableOrganizationRecognize(true);

    private CRFLexicalAnalyzer crfLexicalAnalyzer = null;

    /**
     * w为了解决单例以及单例异常
     */

    public HanlpserviceImpl(){
        try {
             crfLexicalAnalyzer = new CRFLexicalAnalyzer();

        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
    }

    public void  writeLog() {
        logger.info("查询使用");
    }


    // 1. hanlp
    @Override
    public  baseResponse useHanLP(String str) {
        try {

            return new baseResponse(1, HanLP.segment(str).toString());
        } catch (Exception e) {
            logger.error(e.getMessage(),e);


        }
        return new baseResponse(0, "分词失败");
    }

//  2. 标准分词
    public  baseResponse useStandardTokenizer(String str) {
        try {
            return new baseResponse(1, StandardTokenizer.segment(str).toString());
        } catch (Exception e) {
            logger.error(e.getMessage(),e);

        }
        return new baseResponse(0, "分词失败");
    }

//    3. NLP分词
    public  baseResponse useNLPTokenizer(String str) {

        try {
            return new baseResponse(1, NLPTokenizer.segment(str).toString());
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return new baseResponse(0, "分词失败");
    }




//  4. 索引分词
     public  baseResponse useIndexTokenizer(String str) {
         try {
             return new baseResponse(1,IndexTokenizer.segment(str).toString());
         } catch (Exception e) {
             logger.error(e.getMessage(),e);
         }
         return new baseResponse(0, "分词失败");
    }



// 5.1 最短路径分词
    public  baseResponse useShortestSegment(String str) {

//        Segment shortestSegment = new DijkstraSegment().enableCustomDictionary(false).enablePlaceRecognize(true).enableOrganizationRecognize(true);
        try {
//            throw new Exception("系统错误，请重试");
            return new baseResponse(1,shortestSegment.seg(str).toString());

        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return new baseResponse(0, "分词失败");
    }

// 5.2 N-最短路径分词
    public  baseResponse useNShortSegment(String str) {

//        Segment nShortSegment = new NShortSegment().enableCustomDictionary(false).enablePlaceRecognize(true).enableOrganizationRecognize(true);
        try {
            return new baseResponse(1,nShortSegment.seg(str).toString());
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }

        return new baseResponse(0, "分词失败");
    }



//    6. CRF分词

    public  baseResponse useCRFLexicalAnalyzer(String str) {


        try {
//            CRFLexicalAnalyzer crfLexicalAnalyzer = new CRFLexicalAnalyzer();
            return new baseResponse(1,crfLexicalAnalyzer.analyze(str).toString());
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
     return new baseResponse(0, "分词失败");
    }

// 7. 极速词典分词

    public  baseResponse useSpeedTokenizer(String str) {
        try {
            return new baseResponse(1,SpeedTokenizer.segment(str).toString());
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return new baseResponse(0, "分词失败");
    }


    public static void main(String[] args) {
//        HanlpserviceImpl hanlpservice = new HanlpserviceImpl();
////        System.out.println(hanlpservice.useCRFLexicalAnalyzer("s的风格更"));
//        System.out.println(hanlpservice.useCRFLexicalAnalyzer("sghfgh三个半大会百度富爸爸的风格更"));
////
    }
}
