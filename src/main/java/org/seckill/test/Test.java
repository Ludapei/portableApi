package org.seckill.test;

import com.hankcs.hanlp.mining.word2vec.Word2VecTrainer;
import com.hankcs.hanlp.mining.word2vec.WordVectorModel;
import org.seckill.service.impl.HanlpserviceImpl;

public class Test {
    public static void main(String args[]) {
        HanlpserviceImpl hanlpservice = new HanlpserviceImpl();
        System.out.println(hanlpservice.useCRFLexicalAnalyzer("s的风格更"));
//        Long startTime = System.currentTimeMillis();
//        for (int i = 0; i < 100000; i++) {
//            hanlpservice.useCRFLexicalAnalyzer("sghfgh三个半大会百度富爸爸的风格更");
//        }
//        Long endIime = System.currentTimeMillis();
//        System.out.println((endIime-startTime)/1000);
//        Word2VecTrainer trainerBuilder = new Word2VecTrainer();
//        WordVectorModel wordVectorModel = trainerBuilder.train("data/msr_training.utf8.txt", "data/msr_vectors.txt");
//        wordVectorModel.nearest("中国");
//        System.out.println(docVectorModel.similarity("山西副省长贪污腐败开庭", "陕西村干部受贿违纪"));
//        System.out.println(docVectorModel.similarity("山西副省长贪污腐败开庭", "股票基金增长"));

//
    }

}
