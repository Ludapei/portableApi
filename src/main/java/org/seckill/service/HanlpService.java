package org.seckill.service;

import org.seckill.entity.baseResponse;

import java.util.List;

public interface HanlpService {
//    得到分析结果


   baseResponse useHanLP(String string);

   baseResponse  useStandardTokenizer(String string);

   baseResponse  useNLPTokenizer(String string);

   baseResponse  useIndexTokenizer(String string);

   baseResponse  useShortestSegment(String string);

   baseResponse  useNShortSegment(String string);

   baseResponse  useCRFLexicalAnalyzer(String string);
   baseResponse useSpeedTokenizer(String str);
}
