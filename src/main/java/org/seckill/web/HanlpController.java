package org.seckill.web;


import org.seckill.entity.baseResponse;
import org.seckill.service.impl.HanlpserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hanlp")
public class HanlpController {

    @Autowired
    private  HanlpserviceImpl hanlpservice;



    @RequestMapping(value = "/introduce", method = RequestMethod.GET)
    public String hanlp() {
        hanlpservice.writeLog() ;
        System.out.println();
        return "index";
    }


    @ResponseBody
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public String json() {
        hanlpservice.writeLog() ;
        System.out.println();
        return "json";
    }


    @ResponseBody
    @RequestMapping(value="/useHanLP",method = RequestMethod.POST)
    public baseResponse useHanLP(String text) {
        try {
            if (text == null) {
                return new baseResponse(0, "Input is null");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hanlpservice.useHanLP(text);
    }



    @ResponseBody
    @RequestMapping(value="/useNLPTokenizer",method = RequestMethod.POST)
    public baseResponse useNLPTokenizer(String text) {
        if (text != null) {
            return hanlpservice.useNLPTokenizer(text);
        }else {
            return new baseResponse(0, "Input is null");
        }

    }


    @ResponseBody
    @RequestMapping(value="/useStandardTokenizer",method = RequestMethod.POST)
    public baseResponse useStandardTokenizer(String text) {

        if (text != null) {
            return hanlpservice.useStandardTokenizer(text);

        }else {
            return new baseResponse(0, "Input is null");
        }
    }


    @ResponseBody
    @RequestMapping(value="/useIndexTokenizer",method = RequestMethod.POST)
    public baseResponse useIndexTokenizer(String text) {

        if (text != null) {
            return hanlpservice.useIndexTokenizer(text);

        }else {
            return new baseResponse(0, "Input is null");
        }
    }


    @ResponseBody
    @RequestMapping(value="/useShortestSegment",method = RequestMethod.POST)
    public baseResponse useShortestSegment(String text) {
        if (text != null) {
            return hanlpservice.useShortestSegment(text);

        }else {
            return new baseResponse(0, "Input is null");
        }
    }


    @ResponseBody
    @RequestMapping(value="/useNShortSegment",method = RequestMethod.POST)
    public baseResponse useNShortSegment(String text) {

        if (text != null) {
            return hanlpservice.useNShortSegment(text);

        }else {
            return new baseResponse(0, "Input is null");
        }
    }



    @ResponseBody
    @RequestMapping(value="/useCRFLexicalAnalyzer",method = RequestMethod.POST)
    public baseResponse useCRFLexicalAnalyzer(String text) {
        if (text != null) {
            return hanlpservice.useCRFLexicalAnalyzer(text);

        }else {
            return new baseResponse(0, "Input is null");
        }
    }



    @ResponseBody
    @RequestMapping(value="/useSpeedTokenizer",method = RequestMethod.POST)
    public baseResponse useSpeedTokenizer(String text) {

        if (text != null) {
            return hanlpservice.useSpeedTokenizer(text);
        }else {
            return new baseResponse(0, "Input is null");
        }
    }
}


