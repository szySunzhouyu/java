<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<link rel="stylesheet" type="text/css" href="../css/styles.css">

	<script type="text/javascript" src="../assets/js/ajax.js"></script>
	<script type="text/javascript" src="http://d3js.org/d3.v3.min.js"></script>    
    <style type="text/css">   
        
       a:link {
               color: inherit;
			  text-decoration: none;
			  }
	   a:visited {
	            color: inherit;
			     text-decoration: none;
	             }
		a:hover {
		        color: inherit;
			    text-decoration: none;
		        }
		a:active {
		         color: inherit;
			    text-decoration: none;
		         } 
    </style>    
      
  </head>
  
  <body> 
	 							
<script type="text/javascript">    
//(1)链接数组  
var links = [{source:"乌梅", target:"蜀椒"}, {source:"乌梅", target:"干姜"}, {source:"乌梅", target:"黄连"}, {source:"乌梅", target:"当归"}, {source:"乌梅", target:"炮附子"}, {source:"乌梅", target:"桂枝"}, {source:"乌梅", target:"黄柏"}, {source:"乌梅", target:"清半夏"}, {source:"乌梅", target:"橘红"}, {source:"乌梅", target:"白茯苓"}, {source:"乌梅", target:"炙甘草"}, {source:"乌梅", target:"生姜"}, {source:"蜀椒", target:"乌梅"}, {source:"蜀椒", target:"干姜"}, {source:"蜀椒", target:"黄连"}, {source:"蜀椒", target:"当归"}, {source:"蜀椒", target:"炮附子"}, {source:"蜀椒", target:"桂枝"}, {source:"蜀椒", target:"黄柏"}, {source:"干姜", target:"乌梅"}, {source:"干姜", target:"蜀椒"}, {source:"干姜", target:"黄连"}, {source:"干姜", target:"当归"}, {source:"干姜", target:"炮附子"}, {source:"干姜", target:"桂枝"}, {source:"干姜", target:"黄柏"}, {source:"干姜", target:"大黄"}, {source:"干姜", target:"当归"}, {source:"干姜", target:"附子"}, {source:"干姜", target:"人参"}, {source:"干姜", target:"芒硝"}, {source:"干姜", target:"甘草"}, {source:"黄连", target:"乌梅"}, {source:"黄连", target:"蜀椒"}, {source:"黄连", target:"干姜"}, {source:"黄连", target:"当归"}, {source:"黄连", target:"炮附子"}, {source:"黄连", target:"桂枝"}, {source:"黄连", target:"黄柏"}, {source:"黄连", target:"炒神曲"}, {source:"黄连", target:"煨肉豆蔻"}, {source:"黄连", target:"使君子"}, {source:"黄连", target:"炒麦芽"}, {source:"黄连", target:"槟榔"}, {source:"黄连", target:"木香"}, {source:"黄连", target:"猪胆汁"}, {source:"黄连", target:"大黄"}, {source:"黄连", target:"神曲"}, {source:"黄连", target:"枳实"}, {source:"黄连", target:"茯苓"}, {source:"黄连", target:"白术"}, {source:"黄连", target:"泽泻"}, {source:"黄连", target:"炒白术"}, {source:"黄连", target:"木香"}, {source:"黄连", target:"酒炒黄连"}, {source:"黄连", target:"甘草"}, {source:"黄连", target:"白茯苓"}, {source:"黄连", target:"人参"}, {source:"黄连", target:"炒神曲"}, {source:"黄连", target:"陈皮"}, {source:"黄连", target:"砂仁"}, {source:"黄连", target:"炒麦芽"}, {source:"黄连", target:"山楂肉"}, {source:"黄连", target:"山药"}, {source:"黄连", target:"肉豆蔻"}, {source:"当归", target:"乌梅"}, {source:"当归", target:"蜀椒"}, {source:"当归", target:"干姜"}, {source:"当归", target:"黄连"}, {source:"当归", target:"炮附子"}, {source:"当归", target:"桂枝"}, {source:"当归", target:"黄柏"}, {source:"当归", target:"大黄"}, {source:"当归", target:"干姜"}, {source:"当归", target:"附子"}, {source:"当归", target:"人参"}, {source:"当归", target:"芒硝"}, {source:"当归", target:"甘草"}, {source:"炮附子", target:"乌梅"}, {source:"炮附子", target:"蜀椒"}, {source:"炮附子", target:"干姜"}, {source:"炮附子", target:"黄连"}, {source:"炮附子", target:"当归"}, {source:"炮附子", target:"桂枝"}, {source:"炮附子", target:"黄柏"}, {source:"桂枝", target:"乌梅"}, {source:"桂枝", target:"蜀椒"}, {source:"桂枝", target:"干姜"}, {source:"桂枝", target:"黄连"}, {source:"桂枝", target:"当归"}, {source:"桂枝", target:"炮附子"}, {source:"桂枝", target:"黄柏"}, {source:"桂枝", target:"麻黄"}, {source:"桂枝", target:"杏仁"}, {source:"桂枝", target:"炙甘草"}, {source:"桂枝", target:"猪苓"}, {source:"桂枝", target:"茯苓"}, {source:"桂枝", target:"白术"}, {source:"桂枝", target:"泽泻"}, {source:"桂枝", target:"茯苓"}, {source:"桂枝", target:"白术"}, {source:"桂枝", target:"甘草"}, {source:"黄柏", target:"乌梅"}, {source:"黄柏", target:"蜀椒"}, {source:"黄柏", target:"干姜"}, {source:"黄柏", target:"黄连"}, {source:"黄柏", target:"当归"}, {source:"黄柏", target:"炮附子"}, {source:"黄柏", target:"桂枝"}, {source:"麻黄", target:"桂枝"}, {source:"麻黄", target:"杏仁"}, {source:"麻黄", target:"炙甘草"}, {source:"麻黄", target:"杏仁"}, {source:"麻黄", target:"炙甘草"}, {source:"麻黄", target:"石膏"}, {source:"杏仁", target:"麻黄"}, {source:"杏仁", target:"桂枝"}, {source:"杏仁", target:"炙甘草"}, {source:"杏仁", target:"桑叶"}, {source:"杏仁", target:"苦桔梗"}, {source:"杏仁", target:"苇根"}, {source:"杏仁", target:"连翘"}, {source:"杏仁", target:"菊花"}, {source:"杏仁", target:"薄荷"}, {source:"杏仁", target:"生甘草"}, {source:"杏仁", target:"麻黄"}, {source:"杏仁", target:"炙甘草"}, {source:"杏仁", target:"石膏"}, {source:"杏仁", target:"陈皮"}, {source:"杏仁", target:"酒炒黄岑"}, {source:"杏仁", target:"麸炒枳实"}, {source:"杏仁", target:"瓜蒌仁"}, {source:"杏仁", target:"茯苓"}, {source:"杏仁", target:"胆南星"}, {source:"杏仁", target:"生姜"}, {source:"杏仁", target:"制半夏"}, {source:"杏仁", target:"半夏"}, {source:"杏仁", target:"生薏苡仁"}, {source:"杏仁", target:"飞滑石"}, {source:"杏仁", target:"白通草"}, {source:"杏仁", target:"白蔻仁"}, {source:"杏仁", target:"竹叶"}, {source:"杏仁", target:"厚朴"}, {source:"炙甘草", target:"麻黄"}, {source:"炙甘草", target:"桂枝"}, {source:"炙甘草", target:"杏仁"}, {source:"炙甘草", target:"麻黄"}, {source:"炙甘草", target:"杏仁"}, {source:"炙甘草", target:"石膏"}, {source:"炙甘草", target:"清半夏"}, {source:"炙甘草", target:"橘红"}, {source:"炙甘草", target:"白茯苓"}, {source:"炙甘草", target:"生姜"}, {source:"炙甘草", target:"乌梅"}, {source:"炙甘草", target:"陈皮"}, {source:"炙甘草", target:"清半夏"}, {source:"炙甘草", target:"竹茹"}, {source:"炙甘草", target:"麸炒枳实"}, {source:"炙甘草", target:"白茯苓"}, {source:"炙甘草", target:"生姜"}, {source:"炙甘草", target:"大枣"}, {source:"炙甘草", target:"藿香"}, {source:"炙甘草", target:"半夏曲"}, {source:"炙甘草", target:"白术"}, {source:"炙甘草", target:"陈皮"}, {source:"炙甘草", target:"姜炙厚朴"}, {source:"炙甘草", target:"苦桔梗"}, {source:"炙甘草", target:"大腹皮"}, {source:"炙甘草", target:"白芷"}, {source:"炙甘草", target:"紫苏"}, {source:"炙甘草", target:"茯苓"}, {source:"炙甘草", target:"生姜"}, {source:"炙甘草", target:"大枣"}, {source:"炙甘草", target:"苍术"}, {source:"炙甘草", target:"姜炙厚朴"}, {source:"炙甘草", target:"陈皮"}, {source:"炙甘草", target:"生姜"}, {source:"炙甘草", target:"大枣"}, {source:"炙甘草", target:"车前子"}, {source:"炙甘草", target:"瞿麦"}, {source:"炙甘草", target:"萹蓄"}, {source:"炙甘草", target:"滑石"}, {source:"炙甘草", target:"栀子"}, {source:"炙甘草", target:"木通"}, {source:"炙甘草", target:"煨大黄"}, {source:"炙甘草", target:"灯心草"}, {source:"炒神曲", target:"黄连"}, {source:"炒神曲", target:"煨肉豆蔻"}, {source:"炒神曲", target:"使君子"}, {source:"炒神曲", target:"炒麦芽"}, {source:"炒神曲", target:"槟榔"}, {source:"炒神曲", target:"木香"}, {source:"炒神曲", target:"猪胆汁"}, {source:"炒神曲", target:"炒白术"}, {source:"炒神曲", target:"木香"}, {source:"炒神曲", target:"酒炒黄连"}, {source:"炒神曲", target:"甘草"}, {source:"炒神曲", target:"白茯苓"}, {source:"炒神曲", target:"人参"}, {source:"炒神曲", target:"陈皮"}, {source:"炒神曲", target:"砂仁"}, {source:"炒神曲", target:"炒麦芽"}, {source:"炒神曲", target:"山楂肉"}, {source:"炒神曲", target:"山药"}, {source:"炒神曲", target:"肉豆蔻"}, {source:"煨肉豆蔻", target:"炒神曲"}, {source:"煨肉豆蔻", target:"黄连"}, {source:"煨肉豆蔻", target:"使君子"}, {source:"煨肉豆蔻", target:"炒麦芽"}, {source:"煨肉豆蔻", target:"槟榔"}, {source:"煨肉豆蔻", target:"木香"}, {source:"煨肉豆蔻", target:"猪胆汁"}, {source:"使君子", target:"炒神曲"}, {source:"使君子", target:"黄连"}, {source:"使君子", target:"煨肉豆蔻"}, {source:"使君子", target:"炒麦芽"}, {source:"使君子", target:"槟榔"}, {source:"使君子", target:"木香"}, {source:"使君子", target:"猪胆汁"}, {source:"炒麦芽", target:"炒神曲"}, {source:"炒麦芽", target:"黄连"}, {source:"炒麦芽", target:"煨肉豆蔻"}, {source:"炒麦芽", target:"使君子"}, {source:"炒麦芽", target:"槟榔"}, {source:"炒麦芽", target:"木香"}, {source:"炒麦芽", target:"猪胆汁"}, {source:"炒麦芽", target:"炒白术"}, {source:"炒麦芽", target:"木香"}, {source:"炒麦芽", target:"酒炒黄连"}, {source:"炒麦芽", target:"甘草"}, {source:"炒麦芽", target:"白茯苓"}, {source:"炒麦芽", target:"人参"}, {source:"炒麦芽", target:"炒神曲"}, {source:"炒麦芽", target:"陈皮"}, {source:"炒麦芽", target:"砂仁"}, {source:"炒麦芽", target:"山楂肉"}, {source:"炒麦芽", target:"山药"}, {source:"炒麦芽", target:"肉豆蔻"}, {source:"槟榔", target:"炒神曲"}, {source:"槟榔", target:"黄连"}, {source:"槟榔", target:"煨肉豆蔻"}, {source:"槟榔", target:"使君子"}, {source:"槟榔", target:"炒麦芽"}, {source:"槟榔", target:"木香"}, {source:"槟榔", target:"猪胆汁"}, {source:"木香", target:"炒神曲"}, {source:"木香", target:"黄连"}, {source:"木香", target:"煨肉豆蔻"}, {source:"木香", target:"使君子"}, {source:"木香", target:"炒麦芽"}, {source:"木香", target:"槟榔"}, {source:"木香", target:"猪胆汁"}, {source:"木香", target:"炒白术"}, {source:"木香", target:"酒炒黄连"}, {source:"木香", target:"甘草"}, {source:"木香", target:"白茯苓"}, {source:"木香", target:"人参"}, {source:"木香", target:"炒神曲"}, {source:"木香", target:"陈皮"}, {source:"木香", target:"砂仁"}, {source:"木香", target:"炒麦芽"}, {source:"木香", target:"山楂肉"}, {source:"木香", target:"山药"}, {source:"木香", target:"肉豆蔻"}, {source:"猪胆汁", target:"炒神曲"}, {source:"猪胆汁", target:"黄连"}, {source:"猪胆汁", target:"煨肉豆蔻"}, {source:"猪胆汁", target:"使君子"}, {source:"猪胆汁", target:"炒麦芽"}, {source:"猪胆汁", target:"槟榔"}, {source:"猪胆汁", target:"木香"}, {source:"羌活", target:"防风"}, {source:"羌活", target:"苍术"}, {source:"羌活", target:"细辛"}, {source:"羌活", target:"川芎"}, {source:"羌活", target:"白芷"}, {source:"羌活", target:"生地黄"}, {source:"防风", target:"羌活"}, {source:"防风", target:"苍术"}, {source:"防风", target:"细辛"}, {source:"防风", target:"川芎"}, {source:"防风", target:"白芷"}, {source:"防风", target:"生地黄"}, {source:"苍术", target:"羌活"}, {source:"苍术", target:"防风"}, {source:"苍术", target:"细辛"}, {source:"苍术", target:"川芎"}, {source:"苍术", target:"白芷"}, {source:"苍术", target:"生地黄"}, {source:"苍术", target:"姜炙厚朴"}, {source:"苍术", target:"陈皮"}, {source:"苍术", target:"炙甘草"}, {source:"苍术", target:"生姜"}, {source:"苍术", target:"大枣"}, {source:"细辛", target:"羌活"}, {source:"细辛", target:"防风"}, {source:"细辛", target:"苍术"}, {source:"细辛", target:"川芎"}, {source:"细辛", target:"白芷"}, {source:"细辛", target:"生地黄"}, {source:"川芎", target:"羌活"}, {source:"川芎", target:"防风"}, {source:"川芎", target:"苍术"}, {source:"川芎", target:"细辛"}, {source:"川芎", target:"白芷"}, {source:"川芎", target:"生地黄"}, {source:"白芷", target:"羌活"}, {source:"白芷", target:"防风"}, {source:"白芷", target:"苍术"}, {source:"白芷", target:"细辛"}, {source:"白芷", target:"川芎"}, {source:"白芷", target:"生地黄"}, {source:"白芷", target:"藿香"}, {source:"白芷", target:"半夏曲"}, {source:"白芷", target:"白术"}, {source:"白芷", target:"陈皮"}, {source:"白芷", target:"姜炙厚朴"}, {source:"白芷", target:"苦桔梗"}, {source:"白芷", target:"大腹皮"}, {source:"白芷", target:"紫苏"}, {source:"白芷", target:"茯苓"}, {source:"白芷", target:"炙甘草"}, {source:"白芷", target:"生姜"}, {source:"白芷", target:"大枣"}, {source:"生地黄", target:"羌活"}, {source:"生地黄", target:"防风"}, {source:"生地黄", target:"苍术"}, {source:"生地黄", target:"细辛"}, {source:"生地黄", target:"川芎"}, {source:"生地黄", target:"白芷"}, {source:"桑叶", target:"杏仁"}, {source:"桑叶", target:"苦桔梗"}, {source:"桑叶", target:"苇根"}, {source:"桑叶", target:"连翘"}, {source:"桑叶", target:"菊花"}, {source:"桑叶", target:"薄荷"}, {source:"桑叶", target:"生甘草"}, {source:"苦桔梗", target:"桑叶"}, {source:"苦桔梗", target:"杏仁"}, {source:"苦桔梗", target:"苇根"}, {source:"苦桔梗", target:"连翘"}, {source:"苦桔梗", target:"菊花"}, {source:"苦桔梗", target:"薄荷"}, {source:"苦桔梗", target:"生甘草"}, {source:"苦桔梗", target:"藿香"}, {source:"苦桔梗", target:"半夏曲"}, {source:"苦桔梗", target:"白术"}, {source:"苦桔梗", target:"陈皮"}, {source:"苦桔梗", target:"姜炙厚朴"}, {source:"苦桔梗", target:"大腹皮"}, {source:"苦桔梗", target:"白芷"}, {source:"苦桔梗", target:"紫苏"}, {source:"苦桔梗", target:"茯苓"}, {source:"苦桔梗", target:"炙甘草"}, {source:"苦桔梗", target:"生姜"}, {source:"苦桔梗", target:"大枣"}, {source:"苇根", target:"桑叶"}, {source:"苇根", target:"杏仁"}, {source:"苇根", target:"苦桔梗"}, {source:"苇根", target:"连翘"}, {source:"苇根", target:"菊花"}, {source:"苇根", target:"薄荷"}, {source:"苇根", target:"生甘草"}, {source:"连翘", target:"桑叶"}, {source:"连翘", target:"杏仁"}, {source:"连翘", target:"苦桔梗"}, {source:"连翘", target:"苇根"}, {source:"连翘", target:"菊花"}, {source:"连翘", target:"薄荷"}, {source:"连翘", target:"生甘草"}, {source:"连翘", target:"山楂"}, {source:"连翘", target:"神曲"}, {source:"连翘", target:"半夏"}, {source:"连翘", target:"茯苓"}, {source:"连翘", target:"陈皮"}, {source:"连翘", target:"莱菔子"}, {source:"菊花", target:"桑叶"}, {source:"菊花", target:"杏仁"}, {source:"菊花", target:"苦桔梗"}, {source:"菊花", target:"苇根"}, {source:"菊花", target:"连翘"}, {source:"菊花", target:"薄荷"}, {source:"菊花", target:"生甘草"}, {source:"薄荷", target:"桑叶"}, {source:"薄荷", target:"杏仁"}, {source:"薄荷", target:"苦桔梗"}, {source:"薄荷", target:"苇根"}, {source:"薄荷", target:"连翘"}, {source:"薄荷", target:"菊花"}, {source:"薄荷", target:"生甘草"}, {source:"生甘草", target:"桑叶"}, {source:"生甘草", target:"杏仁"}, {source:"生甘草", target:"苦桔梗"}, {source:"生甘草", target:"苇根"}, {source:"生甘草", target:"连翘"}, {source:"生甘草", target:"菊花"}, {source:"生甘草", target:"薄荷"}, {source:"山楂", target:"神曲"}, {source:"山楂", target:"半夏"}, {source:"山楂", target:"茯苓"}, {source:"山楂", target:"陈皮"}, {source:"山楂", target:"连翘"}, {source:"山楂", target:"莱菔子"}, {source:"山楂", target:"炒白术"}, {source:"山楂", target:"木香"}, {source:"山楂", target:"酒炒黄连"}, {source:"山楂", target:"甘草"}, {source:"山楂", target:"白茯苓"}, {source:"山楂", target:"人参"}, {source:"山楂", target:"炒神曲"}, {source:"山楂", target:"陈皮"}, {source:"山楂", target:"砂仁"}, {source:"山楂", target:"炒麦芽"}, {source:"山楂", target:"山楂肉"}, {source:"山楂", target:"山药"}, {source:"山楂", target:"肉豆蔻"}, {source:"半夏", target:"山楂"}, {source:"半夏", target:"神曲"}, {source:"半夏", target:"茯苓"}, {source:"半夏", target:"陈皮"}, {source:"半夏", target:"连翘"}, {source:"半夏", target:"莱菔子"}, {source:"半夏", target:"清半夏"}, {source:"半夏", target:"橘红"}, {source:"半夏", target:"白茯苓"}, {source:"半夏", target:"炙甘草"}, {source:"半夏", target:"生姜"}, {source:"半夏", target:"乌梅"}, {source:"半夏", target:"陈皮"}, {source:"半夏", target:"清半夏"}, {source:"半夏", target:"竹茹"}, {source:"半夏", target:"麸炒枳实"}, {source:"半夏", target:"白茯苓"}, {source:"半夏", target:"炙甘草"}, {source:"半夏", target:"生姜"}, {source:"半夏", target:"大枣"}, {source:"半夏", target:"陈皮"}, {source:"半夏", target:"杏仁"}, {source:"半夏", target:"酒炒黄岑"}, {source:"半夏", target:"麸炒枳实"}, {source:"半夏", target:"瓜蒌仁"}, {source:"半夏", target:"茯苓"}, {source:"半夏", target:"胆南星"}, {source:"半夏", target:"生姜"}, {source:"半夏", target:"制半夏"}, {source:"半夏", target:"天麻"}, {source:"半夏", target:"茯苓"}, {source:"半夏", target:"橘红"}, {source:"半夏", target:"白术"}, {source:"半夏", target:"甘草"}, {source:"半夏", target:"生姜"}, {source:"半夏", target:"大枣"}, {source:"半夏", target:"藿香"}, {source:"半夏", target:"半夏曲"}, {source:"半夏", target:"白术"}, {source:"半夏", target:"陈皮"}, {source:"半夏", target:"姜炙厚朴"}, {source:"半夏", target:"苦桔梗"}, {source:"半夏", target:"大腹皮"}, {source:"半夏", target:"白芷"}, {source:"半夏", target:"紫苏"}, {source:"半夏", target:"茯苓"}, {source:"半夏", target:"炙甘草"}, {source:"半夏", target:"生姜"}, {source:"半夏", target:"大枣"}, {source:"半夏", target:"杏仁"}, {source:"半夏", target:"生薏苡仁"}, {source:"半夏", target:"飞滑石"}, {source:"半夏", target:"白通草"}, {source:"半夏", target:"白蔻仁"}, {source:"半夏", target:"竹叶"}, {source:"半夏", target:"厚朴"}, {source:"茯苓", target:"山楂"}, {source:"茯苓", target:"神曲"}, {source:"茯苓", target:"半夏"}, {source:"茯苓", target:"陈皮"}, {source:"茯苓", target:"连翘"}, {source:"茯苓", target:"莱菔子"}, {source:"茯苓", target:"大黄"}, {source:"茯苓", target:"神曲"}, {source:"茯苓", target:"枳实"}, {source:"茯苓", target:"黄连"}, {source:"茯苓", target:"白术"}, {source:"茯苓", target:"泽泻"}, {source:"茯苓", target:"炒白术"}, {source:"茯苓", target:"木香"}, {source:"茯苓", target:"酒炒黄连"}, {source:"茯苓", target:"甘草"}, {source:"茯苓", target:"白茯苓"}, {source:"茯苓", target:"人参"}, {source:"茯苓", target:"炒神曲"}, {source:"茯苓", target:"陈皮"}, {source:"茯苓", target:"砂仁"}, {source:"茯苓", target:"炒麦芽"}, {source:"茯苓", target:"山楂肉"}, {source:"茯苓", target:"山药"}, {source:"茯苓", target:"肉豆蔻"}, {source:"茯苓", target:"清半夏"}, {source:"茯苓", target:"橘红"}, {source:"茯苓", target:"白茯苓"}, {source:"茯苓", target:"炙甘草"}, {source:"茯苓", target:"生姜"}, {source:"茯苓", target:"乌梅"}, {source:"茯苓", target:"陈皮"}, {source:"茯苓", target:"清半夏"}, {source:"茯苓", target:"竹茹"}, {source:"茯苓", target:"麸炒枳实"}, {source:"茯苓", target:"白茯苓"}, {source:"茯苓", target:"炙甘草"}, {source:"茯苓", target:"生姜"}, {source:"茯苓", target:"大枣"}, {source:"茯苓", target:"陈皮"}, {source:"茯苓", target:"杏仁"}, {source:"茯苓", target:"酒炒黄岑"}, {source:"茯苓", target:"麸炒枳实"}, {source:"茯苓", target:"瓜蒌仁"}, {source:"茯苓", target:"胆南星"}, {source:"茯苓", target:"生姜"}, {source:"茯苓", target:"制半夏"}, {source:"茯苓", target:"半夏"}, {source:"茯苓", target:"天麻"}, {source:"茯苓", target:"橘红"}, {source:"茯苓", target:"白术"}, {source:"茯苓", target:"甘草"}, {source:"茯苓", target:"生姜"}, {source:"茯苓", target:"大枣"}, {source:"茯苓", target:"藿香"}, {source:"茯苓", target:"半夏曲"}, {source:"茯苓", target:"白术"}, {source:"茯苓", target:"陈皮"}, {source:"茯苓", target:"姜炙厚朴"}, {source:"茯苓", target:"苦桔梗"}, {source:"茯苓", target:"大腹皮"}, {source:"茯苓", target:"白芷"}, {source:"茯苓", target:"紫苏"}, {source:"茯苓", target:"炙甘草"}, {source:"茯苓", target:"生姜"}, {source:"茯苓", target:"大枣"}, {source:"茯苓", target:"猪苓"}, {source:"茯苓", target:"白术"}, {source:"茯苓", target:"泽泻"}, {source:"茯苓", target:"桂枝"}, {source:"茯苓", target:"桂枝"}, {source:"茯苓", target:"白术"}, {source:"茯苓", target:"甘草"}, {source:"陈皮", target:"山楂"}, {source:"陈皮", target:"神曲"}, {source:"陈皮", target:"半夏"}, {source:"陈皮", target:"茯苓"}, {source:"陈皮", target:"连翘"}, {source:"陈皮", target:"莱菔子"}, {source:"陈皮", target:"炒白术"}, {source:"陈皮", target:"木香"}, {source:"陈皮", target:"酒炒黄连"}, {source:"陈皮", target:"甘草"}, {source:"陈皮", target:"白茯苓"}, {source:"陈皮", target:"人参"}, {source:"陈皮", target:"炒神曲"}, {source:"陈皮", target:"砂仁"}, {source:"陈皮", target:"炒麦芽"}, {source:"陈皮", target:"山楂肉"}, {source:"陈皮", target:"山药"}, {source:"陈皮", target:"肉豆蔻"}, {source:"陈皮", target:"清半夏"}, {source:"陈皮", target:"竹茹"}, {source:"陈皮", target:"麸炒枳实"}, {source:"陈皮", target:"白茯苓"}, {source:"陈皮", target:"炙甘草"}, {source:"陈皮", target:"生姜"}, {source:"陈皮", target:"大枣"}, {source:"陈皮", target:"杏仁"}, {source:"陈皮", target:"酒炒黄岑"}, {source:"陈皮", target:"麸炒枳实"}, {source:"陈皮", target:"瓜蒌仁"}, {source:"陈皮", target:"茯苓"}, {source:"陈皮", target:"胆南星"}, {source:"陈皮", target:"生姜"}, {source:"陈皮", target:"制半夏"}, {source:"陈皮", target:"藿香"}, {source:"陈皮", target:"半夏曲"}, {source:"陈皮", target:"白术"}, {source:"陈皮", target:"姜炙厚朴"}, {source:"陈皮", target:"苦桔梗"}, {source:"陈皮", target:"大腹皮"}, {source:"陈皮", target:"白芷"}, {source:"陈皮", target:"紫苏"}, {source:"陈皮", target:"茯苓"}, {source:"陈皮", target:"炙甘草"}, {source:"陈皮", target:"生姜"}, {source:"陈皮", target:"大枣"}, {source:"陈皮", target:"苍术"}, {source:"陈皮", target:"姜炙厚朴"}, {source:"陈皮", target:"炙甘草"}, {source:"陈皮", target:"生姜"}, {source:"陈皮", target:"大枣"}, {source:"莱菔子", target:"山楂"}, {source:"莱菔子", target:"神曲"}, {source:"莱菔子", target:"半夏"}, {source:"莱菔子", target:"茯苓"}, {source:"莱菔子", target:"陈皮"}, {source:"莱菔子", target:"连翘"}, {source:"大黄", target:"神曲"}, {source:"大黄", target:"枳实"}, {source:"大黄", target:"茯苓"}, {source:"大黄", target:"黄连"}, {source:"大黄", target:"白术"}, {source:"大黄", target:"泽泻"}, {source:"大黄", target:"桃仁"}, {source:"大黄", target:"冬瓜仁"}, {source:"大黄", target:"牡丹"}, {source:"大黄", target:"芒硝"}, {source:"大黄", target:"当归"}, {source:"大黄", target:"干姜"}, {source:"大黄", target:"附子"}, {source:"大黄", target:"人参"}, {source:"大黄", target:"芒硝"}, {source:"大黄", target:"甘草"}, {source:"大黄", target:"茵陈"}, {source:"大黄", target:"栀子"}, {source:"大黄", target:"车前子"}, {source:"大黄", target:"瞿麦"}, {source:"大黄", target:"萹蓄"}, {source:"大黄", target:"滑石"}, {source:"大黄", target:"栀子"}, {source:"大黄", target:"炙甘草"}, {source:"大黄", target:"木通"}, {source:"大黄", target:"煨大黄"}, {source:"大黄", target:"灯心草"}, {source:"枳实", target:"大黄"}, {source:"枳实", target:"神曲"}, {source:"枳实", target:"茯苓"}, {source:"枳实", target:"黄连"}, {source:"枳实", target:"白术"}, {source:"枳实", target:"泽泻"}, {source:"枳实", target:"陈皮"}, {source:"枳实", target:"清半夏"}, {source:"枳实", target:"竹茹"}, {source:"枳实", target:"麸炒枳实"}, {source:"枳实", target:"白茯苓"}, {source:"枳实", target:"炙甘草"}, {source:"枳实", target:"生姜"}, {source:"枳实", target:"大枣"}, {source:"枳实", target:"陈皮"}, {source:"枳实", target:"杏仁"}, {source:"枳实", target:"酒炒黄岑"}, {source:"枳实", target:"麸炒枳实"}, {source:"枳实", target:"瓜蒌仁"}, {source:"枳实", target:"茯苓"}, {source:"枳实", target:"胆南星"}, {source:"枳实", target:"生姜"}, {source:"枳实", target:"制半夏"}, {source:"白术", target:"大黄"}, {source:"白术", target:"神曲"}, {source:"白术", target:"枳实"}, {source:"白术", target:"茯苓"}, {source:"白术", target:"黄连"}, {source:"白术", target:"泽泻"}, {source:"白术", target:"炒白术"}, {source:"白术", target:"木香"}, {source:"白术", target:"酒炒黄连"}, {source:"白术", target:"甘草"}, {source:"白术", target:"白茯苓"}, {source:"白术", target:"人参"}, {source:"白术", target:"炒神曲"}, {source:"白术", target:"陈皮"}, {source:"白术", target:"砂仁"}, {source:"白术", target:"炒麦芽"}, {source:"白术", target:"山楂肉"}, {source:"白术", target:"山药"}, {source:"白术", target:"肉豆蔻"}, {source:"白术", target:"半夏"}, {source:"白术", target:"天麻"}, {source:"白术", target:"茯苓"}, {source:"白术", target:"橘红"}, {source:"白术", target:"甘草"}, {source:"白术", target:"生姜"}, {source:"白术", target:"大枣"}, {source:"白术", target:"藿香"}, {source:"白术", target:"半夏曲"}, {source:"白术", target:"陈皮"}, {source:"白术", target:"姜炙厚朴"}, {source:"白术", target:"苦桔梗"}, {source:"白术", target:"大腹皮"}, {source:"白术", target:"白芷"}, {source:"白术", target:"紫苏"}, {source:"白术", target:"茯苓"}, {source:"白术", target:"炙甘草"}, {source:"白术", target:"生姜"}, {source:"白术", target:"大枣"}, {source:"白术", target:"猪苓"}, {source:"白术", target:"茯苓"}, {source:"白术", target:"泽泻"}, {source:"白术", target:"桂枝"}, {source:"白术", target:"桂枝"}, {source:"白术", target:"茯苓"}, {source:"白术", target:"甘草"}, {source:"泽泻", target:"大黄"}, {source:"泽泻", target:"神曲"}, {source:"泽泻", target:"枳实"}, {source:"泽泻", target:"茯苓"}, {source:"泽泻", target:"黄连"}, {source:"泽泻", target:"白术"}, {source:"泽泻", target:"猪苓"}, {source:"泽泻", target:"茯苓"}, {source:"泽泻", target:"白术"}, {source:"泽泻", target:"桂枝"}, {source:"炒白术", target:"木香"}, {source:"炒白术", target:"酒炒黄连"}, {source:"炒白术", target:"甘草"}, {source:"炒白术", target:"白茯苓"}, {source:"炒白术", target:"人参"}, {source:"炒白术", target:"炒神曲"}, {source:"炒白术", target:"陈皮"}, {source:"炒白术", target:"砂仁"}, {source:"炒白术", target:"炒麦芽"}, {source:"炒白术", target:"山楂肉"}, {source:"炒白术", target:"山药"}, {source:"炒白术", target:"肉豆蔻"}, {source:"酒炒黄连", target:"炒白术"}, {source:"酒炒黄连", target:"木香"}, {source:"酒炒黄连", target:"甘草"}, {source:"酒炒黄连", target:"白茯苓"}, {source:"酒炒黄连", target:"人参"}, {source:"酒炒黄连", target:"炒神曲"}, {source:"酒炒黄连", target:"陈皮"}, {source:"酒炒黄连", target:"砂仁"}, {source:"酒炒黄连", target:"炒麦芽"}, {source:"酒炒黄连", target:"山楂肉"}, {source:"酒炒黄连", target:"山药"}, {source:"酒炒黄连", target:"肉豆蔻"}, {source:"白茯苓", target:"炒白术"}, {source:"白茯苓", target:"木香"}, {source:"白茯苓", target:"酒炒黄连"}, {source:"白茯苓", target:"甘草"}, {source:"白茯苓", target:"人参"}, {source:"白茯苓", target:"炒神曲"}, {source:"白茯苓", target:"陈皮"}, {source:"白茯苓", target:"砂仁"}, {source:"白茯苓", target:"炒麦芽"}, {source:"白茯苓", target:"山楂肉"}, {source:"白茯苓", target:"山药"}, {source:"白茯苓", target:"肉豆蔻"}, {source:"白茯苓", target:"清半夏"}, {source:"白茯苓", target:"橘红"}, {source:"白茯苓", target:"炙甘草"}, {source:"白茯苓", target:"生姜"}, {source:"白茯苓", target:"乌梅"}, {source:"白茯苓", target:"陈皮"}, {source:"白茯苓", target:"清半夏"}, {source:"白茯苓", target:"竹茹"}, {source:"白茯苓", target:"麸炒枳实"}, {source:"白茯苓", target:"炙甘草"}, {source:"白茯苓", target:"生姜"}, {source:"白茯苓", target:"大枣"}, {source:"人参", target:"炒白术"}, {source:"人参", target:"木香"}, {source:"人参", target:"酒炒黄连"}, {source:"人参", target:"甘草"}, {source:"人参", target:"白茯苓"}, {source:"人参", target:"炒神曲"}, {source:"人参", target:"陈皮"}, {source:"人参", target:"砂仁"}, {source:"人参", target:"炒麦芽"}, {source:"人参", target:"山楂肉"}, {source:"人参", target:"山药"}, {source:"人参", target:"肉豆蔻"}, {source:"人参", target:"大黄"}, {source:"人参", target:"当归"}, {source:"人参", target:"干姜"}, {source:"人参", target:"附子"}, {source:"人参", target:"芒硝"}, {source:"人参", target:"甘草"}, {source:"砂仁", target:"炒白术"}, {source:"砂仁", target:"木香"}, {source:"砂仁", target:"酒炒黄连"}, {source:"砂仁", target:"甘草"}, {source:"砂仁", target:"白茯苓"}, {source:"砂仁", target:"人参"}, {source:"砂仁", target:"炒神曲"}, {source:"砂仁", target:"陈皮"}, {source:"砂仁", target:"炒麦芽"}, {source:"砂仁", target:"山楂肉"}, {source:"砂仁", target:"山药"}, {source:"砂仁", target:"肉豆蔻"}, {source:"山楂肉", target:"炒白术"}, {source:"山楂肉", target:"木香"}, {source:"山楂肉", target:"酒炒黄连"}, {source:"山楂肉", target:"甘草"}, {source:"山楂肉", target:"白茯苓"}, {source:"山楂肉", target:"人参"}, {source:"山楂肉", target:"炒神曲"}, {source:"山楂肉", target:"陈皮"}, {source:"山楂肉", target:"砂仁"}, {source:"山楂肉", target:"炒麦芽"}, {source:"山楂肉", target:"山药"}, {source:"山楂肉", target:"肉豆蔻"}, {source:"山药", target:"炒白术"}, {source:"山药", target:"木香"}, {source:"山药", target:"酒炒黄连"}, {source:"山药", target:"甘草"}, {source:"山药", target:"白茯苓"}, {source:"山药", target:"人参"}, {source:"山药", target:"炒神曲"}, {source:"山药", target:"陈皮"}, {source:"山药", target:"砂仁"}, {source:"山药", target:"炒麦芽"}, {source:"山药", target:"山楂肉"}, {source:"山药", target:"肉豆蔻"}, {source:"石膏", target:"麻黄"}, {source:"石膏", target:"杏仁"}, {source:"石膏", target:"炙甘草"}, {source:"清半夏", target:"橘红"}, {source:"清半夏", target:"白茯苓"}, {source:"清半夏", target:"炙甘草"}, {source:"清半夏", target:"生姜"}, {source:"清半夏", target:"乌梅"}, {source:"清半夏", target:"陈皮"}, {source:"清半夏", target:"竹茹"}, {source:"清半夏", target:"麸炒枳实"}, {source:"清半夏", target:"白茯苓"}, {source:"清半夏", target:"炙甘草"}, {source:"清半夏", target:"生姜"}, {source:"清半夏", target:"大枣"}, {source:"橘红", target:"清半夏"}, {source:"橘红", target:"白茯苓"}, {source:"橘红", target:"炙甘草"}, {source:"橘红", target:"生姜"}, {source:"橘红", target:"乌梅"}, {source:"橘红", target:"半夏"}, {source:"橘红", target:"天麻"}, {source:"橘红", target:"茯苓"}, {source:"橘红", target:"白术"}, {source:"橘红", target:"甘草"}, {source:"橘红", target:"生姜"}, {source:"橘红", target:"大枣"}, {source:"生姜", target:"清半夏"}, {source:"生姜", target:"橘红"}, {source:"生姜", target:"白茯苓"}, {source:"生姜", target:"炙甘草"}, {source:"生姜", target:"乌梅"}, {source:"生姜", target:"陈皮"}, {source:"生姜", target:"清半夏"}, {source:"生姜", target:"竹茹"}, {source:"生姜", target:"麸炒枳实"}, {source:"生姜", target:"白茯苓"}, {source:"生姜", target:"炙甘草"}, {source:"生姜", target:"大枣"}, {source:"生姜", target:"陈皮"}, {source:"生姜", target:"杏仁"}, {source:"生姜", target:"酒炒黄岑"}, {source:"生姜", target:"麸炒枳实"}, {source:"生姜", target:"瓜蒌仁"}, {source:"生姜", target:"茯苓"}, {source:"生姜", target:"胆南星"}, {source:"生姜", target:"制半夏"}, {source:"生姜", target:"半夏"}, {source:"生姜", target:"天麻"}, {source:"生姜", target:"茯苓"}, {source:"生姜", target:"橘红"}, {source:"生姜", target:"白术"}, {source:"生姜", target:"甘草"}, {source:"生姜", target:"大枣"}, {source:"生姜", target:"藿香"}, {source:"生姜", target:"半夏曲"}, {source:"生姜", target:"白术"}, {source:"生姜", target:"陈皮"}, {source:"生姜", target:"姜炙厚朴"}, {source:"生姜", target:"苦桔梗"}, {source:"生姜", target:"大腹皮"}, {source:"生姜", target:"白芷"}, {source:"生姜", target:"紫苏"}, {source:"生姜", target:"茯苓"}, {source:"生姜", target:"炙甘草"}, {source:"生姜", target:"大枣"}, {source:"生姜", target:"苍术"}, {source:"生姜", target:"姜炙厚朴"}, {source:"生姜", target:"陈皮"}, {source:"生姜", target:"炙甘草"}, {source:"生姜", target:"大枣"}, {source:"桃仁", target:"大黄"}, {source:"桃仁", target:"冬瓜仁"}, {source:"桃仁", target:"牡丹"}, {source:"桃仁", target:"芒硝"}, {source:"冬瓜仁", target:"大黄"}, {source:"冬瓜仁", target:"桃仁"}, {source:"冬瓜仁", target:"牡丹"}, {source:"冬瓜仁", target:"芒硝"}, {source:"牡丹", target:"大黄"}, {source:"牡丹", target:"桃仁"}, {source:"牡丹", target:"冬瓜仁"}, {source:"牡丹", target:"芒硝"}, {source:"芒硝", target:"大黄"}, {source:"芒硝", target:"桃仁"}, {source:"芒硝", target:"冬瓜仁"}, {source:"芒硝", target:"牡丹"}, {source:"芒硝", target:"大黄"}, {source:"芒硝", target:"当归"}, {source:"芒硝", target:"干姜"}, {source:"芒硝", target:"附子"}, {source:"芒硝", target:"人参"}, {source:"芒硝", target:"甘草"}, {source:"竹茹", target:"陈皮"}, {source:"竹茹", target:"清半夏"}, {source:"竹茹", target:"麸炒枳实"}, {source:"竹茹", target:"白茯苓"}, {source:"竹茹", target:"炙甘草"}, {source:"竹茹", target:"生姜"}, {source:"竹茹", target:"大枣"}, {source:"麸炒枳实", target:"陈皮"}, {source:"麸炒枳实", target:"清半夏"}, {source:"麸炒枳实", target:"竹茹"}, {source:"麸炒枳实", target:"白茯苓"}, {source:"麸炒枳实", target:"炙甘草"}, {source:"麸炒枳实", target:"生姜"}, {source:"麸炒枳实", target:"大枣"}, {source:"麸炒枳实", target:"陈皮"}, {source:"麸炒枳实", target:"杏仁"}, {source:"麸炒枳实", target:"酒炒黄岑"}, {source:"麸炒枳实", target:"瓜蒌仁"}, {source:"麸炒枳实", target:"茯苓"}, {source:"麸炒枳实", target:"胆南星"}, {source:"麸炒枳实", target:"生姜"}, {source:"麸炒枳实", target:"制半夏"}, {source:"大枣", target:"陈皮"}, {source:"大枣", target:"清半夏"}, {source:"大枣", target:"竹茹"}, {source:"大枣", target:"麸炒枳实"}, {source:"大枣", target:"白茯苓"}, {source:"大枣", target:"炙甘草"}, {source:"大枣", target:"生姜"}, {source:"大枣", target:"半夏"}, {source:"大枣", target:"天麻"}, {source:"大枣", target:"茯苓"}, {source:"大枣", target:"橘红"}, {source:"大枣", target:"白术"}, {source:"大枣", target:"甘草"}, {source:"大枣", target:"生姜"}, {source:"大枣", target:"藿香"}, {source:"大枣", target:"半夏曲"}, {source:"大枣", target:"白术"}, {source:"大枣", target:"陈皮"}, {source:"大枣", target:"姜炙厚朴"}, {source:"大枣", target:"苦桔梗"}, {source:"大枣", target:"大腹皮"}, {source:"大枣", target:"白芷"}, {source:"大枣", target:"紫苏"}, {source:"大枣", target:"茯苓"}, {source:"大枣", target:"炙甘草"}, {source:"大枣", target:"生姜"}, {source:"大枣", target:"苍术"}, {source:"大枣", target:"姜炙厚朴"}, {source:"大枣", target:"陈皮"}, {source:"大枣", target:"炙甘草"}, {source:"大枣", target:"生姜"}, {source:"大枣", target:"芫花"}, {source:"大枣", target:"干遂"}, {source:"大枣", target:"大戟"}, {source:"大枣", target:"大枣肥者"}, {source:"酒炒黄岑", target:"陈皮"}, {source:"酒炒黄岑", target:"杏仁"}, {source:"酒炒黄岑", target:"麸炒枳实"}, {source:"酒炒黄岑", target:"瓜蒌仁"}, {source:"酒炒黄岑", target:"茯苓"}, {source:"酒炒黄岑", target:"胆南星"}, {source:"酒炒黄岑", target:"生姜"}, {source:"酒炒黄岑", target:"制半夏"}, {source:"瓜蒌仁", target:"陈皮"}, {source:"瓜蒌仁", target:"杏仁"}, {source:"瓜蒌仁", target:"酒炒黄岑"}, {source:"瓜蒌仁", target:"麸炒枳实"}, {source:"瓜蒌仁", target:"茯苓"}, {source:"瓜蒌仁", target:"胆南星"}, {source:"瓜蒌仁", target:"生姜"}, {source:"瓜蒌仁", target:"制半夏"}, {source:"胆南星", target:"陈皮"}, {source:"胆南星", target:"杏仁"}, {source:"胆南星", target:"酒炒黄岑"}, {source:"胆南星", target:"麸炒枳实"}, {source:"胆南星", target:"瓜蒌仁"}, {source:"胆南星", target:"茯苓"}, {source:"胆南星", target:"生姜"}, {source:"胆南星", target:"制半夏"}, {source:"制半夏", target:"陈皮"}, {source:"制半夏", target:"杏仁"}, {source:"制半夏", target:"酒炒黄岑"}, {source:"制半夏", target:"麸炒枳实"}, {source:"制半夏", target:"瓜蒌仁"}, {source:"制半夏", target:"茯苓"}, {source:"制半夏", target:"胆南星"}, {source:"制半夏", target:"生姜"}, {source:"天麻", target:"半夏"}, {source:"天麻", target:"茯苓"}, {source:"天麻", target:"橘红"}, {source:"天麻", target:"白术"}, {source:"天麻", target:"甘草"}, {source:"天麻", target:"生姜"}, {source:"天麻", target:"大枣"}, {source:"藿香", target:"半夏曲"}, {source:"藿香", target:"白术"}, {source:"藿香", target:"陈皮"}, {source:"藿香", target:"姜炙厚朴"}, {source:"藿香", target:"苦桔梗"}, {source:"藿香", target:"大腹皮"}, {source:"藿香", target:"白芷"}, {source:"藿香", target:"紫苏"}, {source:"藿香", target:"茯苓"}, {source:"藿香", target:"炙甘草"}, {source:"藿香", target:"生姜"}, {source:"藿香", target:"大枣"}, {source:"半夏曲", target:"藿香"}, {source:"半夏曲", target:"白术"}, {source:"半夏曲", target:"陈皮"}, {source:"半夏曲", target:"姜炙厚朴"}, {source:"半夏曲", target:"苦桔梗"}, {source:"半夏曲", target:"大腹皮"}, {source:"半夏曲", target:"白芷"}, {source:"半夏曲", target:"紫苏"}, {source:"半夏曲", target:"茯苓"}, {source:"半夏曲", target:"炙甘草"}, {source:"半夏曲", target:"生姜"}, {source:"半夏曲", target:"大枣"}, {source:"姜炙厚朴", target:"藿香"}, {source:"姜炙厚朴", target:"半夏曲"}, {source:"姜炙厚朴", target:"白术"}, {source:"姜炙厚朴", target:"陈皮"}, {source:"姜炙厚朴", target:"苦桔梗"}, {source:"姜炙厚朴", target:"大腹皮"}, {source:"姜炙厚朴", target:"白芷"}, {source:"姜炙厚朴", target:"紫苏"}, {source:"姜炙厚朴", target:"茯苓"}, {source:"姜炙厚朴", target:"炙甘草"}, {source:"姜炙厚朴", target:"生姜"}, {source:"姜炙厚朴", target:"大枣"}, {source:"姜炙厚朴", target:"苍术"}, {source:"姜炙厚朴", target:"陈皮"}, {source:"姜炙厚朴", target:"炙甘草"}, {source:"姜炙厚朴", target:"生姜"}, {source:"姜炙厚朴", target:"大枣"}, {source:"大腹皮", target:"藿香"}, {source:"大腹皮", target:"半夏曲"}, {source:"大腹皮", target:"白术"}, {source:"大腹皮", target:"陈皮"}, {source:"大腹皮", target:"姜炙厚朴"}, {source:"大腹皮", target:"苦桔梗"}, {source:"大腹皮", target:"白芷"}, {source:"大腹皮", target:"紫苏"}, {source:"大腹皮", target:"茯苓"}, {source:"大腹皮", target:"炙甘草"}, {source:"大腹皮", target:"生姜"}, {source:"大腹皮", target:"大枣"}, {source:"紫苏", target:"藿香"}, {source:"紫苏", target:"半夏曲"}, {source:"紫苏", target:"白术"}, {source:"紫苏", target:"陈皮"}, {source:"紫苏", target:"姜炙厚朴"}, {source:"紫苏", target:"苦桔梗"}, {source:"紫苏", target:"大腹皮"}, {source:"紫苏", target:"白芷"}, {source:"紫苏", target:"茯苓"}, {source:"紫苏", target:"炙甘草"}, {source:"紫苏", target:"生姜"}, {source:"紫苏", target:"大枣"}, {source:"芫花", target:"干遂"}, {source:"芫花", target:"大戟"}, {source:"芫花", target:"大枣肥者"}, {source:"干遂", target:"芫花"}, {source:"干遂", target:"大戟"}, {source:"干遂", target:"大枣肥者"}, {source:"大戟", target:"芫花"}, {source:"大戟", target:"干遂"}, {source:"大戟", target:"大枣肥者"}, {source:"大枣肥者", target:"芫花"}, {source:"大枣肥者", target:"干遂"}, {source:"大枣肥者", target:"大戟"}, {source:"茵陈", target:"栀子"}, {source:"茵陈", target:"大黄"}, {source:"栀子", target:"茵陈"}, {source:"栀子", target:"大黄"}, {source:"栀子", target:"车前子"}, {source:"栀子", target:"瞿麦"}, {source:"栀子", target:"萹蓄"}, {source:"栀子", target:"滑石"}, {source:"栀子", target:"炙甘草"}, {source:"栀子", target:"木通"}, {source:"栀子", target:"煨大黄"}, {source:"栀子", target:"灯心草"}, {source:"车前子", target:"瞿麦"}, {source:"车前子", target:"萹蓄"}, {source:"车前子", target:"滑石"}, {source:"车前子", target:"栀子"}, {source:"车前子", target:"炙甘草"}, {source:"车前子", target:"木通"}, {source:"车前子", target:"煨大黄"}, {source:"车前子", target:"灯心草"}, {source:"瞿麦", target:"车前子"}, {source:"瞿麦", target:"萹蓄"}, {source:"瞿麦", target:"滑石"}, {source:"瞿麦", target:"栀子"}, {source:"瞿麦", target:"炙甘草"}, {source:"瞿麦", target:"木通"}, {source:"瞿麦", target:"煨大黄"}, {source:"瞿麦", target:"灯心草"}, {source:"萹蓄", target:"车前子"}, {source:"萹蓄", target:"瞿麦"}, {source:"萹蓄", target:"滑石"}, {source:"萹蓄", target:"栀子"}, {source:"萹蓄", target:"炙甘草"}, {source:"萹蓄", target:"木通"}, {source:"萹蓄", target:"煨大黄"}, {source:"萹蓄", target:"灯心草"}, {source:"滑石", target:"车前子"}, {source:"滑石", target:"瞿麦"}, {source:"滑石", target:"萹蓄"}, {source:"滑石", target:"栀子"}, {source:"滑石", target:"炙甘草"}, {source:"滑石", target:"木通"}, {source:"滑石", target:"煨大黄"}, {source:"滑石", target:"灯心草"}, {source:"滑石", target:"杏仁"}, {source:"滑石", target:"半夏"}, {source:"滑石", target:"生薏苡仁"}, {source:"滑石", target:"飞滑石"}, {source:"滑石", target:"白通草"}, {source:"滑石", target:"白蔻仁"}, {source:"滑石", target:"竹叶"}, {source:"滑石", target:"厚朴"}, {source:"木通", target:"车前子"}, {source:"木通", target:"瞿麦"}, {source:"木通", target:"萹蓄"}, {source:"木通", target:"滑石"}, {source:"木通", target:"栀子"}, {source:"木通", target:"炙甘草"}, {source:"木通", target:"煨大黄"}, {source:"木通", target:"灯心草"}, {source:"煨大黄", target:"车前子"}, {source:"煨大黄", target:"瞿麦"}, {source:"煨大黄", target:"萹蓄"}, {source:"煨大黄", target:"滑石"}, {source:"煨大黄", target:"栀子"}, {source:"煨大黄", target:"炙甘草"}, {source:"煨大黄", target:"木通"}, {source:"煨大黄", target:"灯心草"}, {source:"灯心草", target:"车前子"}, {source:"灯心草", target:"瞿麦"}, {source:"灯心草", target:"萹蓄"}, {source:"灯心草", target:"滑石"}, {source:"灯心草", target:"栀子"}, {source:"灯心草", target:"炙甘草"}, {source:"灯心草", target:"木通"}, {source:"灯心草", target:"煨大黄"}, {source:"生薏苡仁", target:"杏仁"}, {source:"生薏苡仁", target:"半夏"}, {source:"生薏苡仁", target:"飞滑石"}, {source:"生薏苡仁", target:"白通草"}, {source:"生薏苡仁", target:"白蔻仁"}, {source:"生薏苡仁", target:"竹叶"}, {source:"生薏苡仁", target:"厚朴"}, {source:"飞滑石", target:"杏仁"}, {source:"飞滑石", target:"半夏"}, {source:"飞滑石", target:"生薏苡仁"}, {source:"飞滑石", target:"白通草"}, {source:"飞滑石", target:"白蔻仁"}, {source:"飞滑石", target:"竹叶"}, {source:"飞滑石", target:"厚朴"}, {source:"白通草", target:"杏仁"}, {source:"白通草", target:"半夏"}, {source:"白通草", target:"生薏苡仁"}, {source:"白通草", target:"飞滑石"}, {source:"白通草", target:"白蔻仁"}, {source:"白通草", target:"竹叶"}, {source:"白通草", target:"厚朴"}, {source:"白蔻仁", target:"杏仁"}, {source:"白蔻仁", target:"半夏"}, {source:"白蔻仁", target:"生薏苡仁"}, {source:"白蔻仁", target:"飞滑石"}, {source:"白蔻仁", target:"白通草"}, {source:"白蔻仁", target:"竹叶"}, {source:"白蔻仁", target:"厚朴"}, {source:"竹叶", target:"杏仁"}, {source:"竹叶", target:"半夏"}, {source:"竹叶", target:"生薏苡仁"}, {source:"竹叶", target:"飞滑石"}, {source:"竹叶", target:"白通草"}, {source:"竹叶", target:"白蔻仁"}, {source:"竹叶", target:"厚朴"}];
                                                                
var nodes = {};                                                     
                                                                    
//(2)从链接中分离出不同的节点        
//一个小问题：节点的weight属性怎么产生的？                 
links.forEach(function(link) {  //思路就是：在连接中遍历链接，节点数组有了这个链接的源节点就把链接指向这个节点。没有的话把链接上的节点加到链接数组指定名称name属性，并把链接指向这个节点  
console.log(nodes);                                    
  link.source = nodes[link.source] //link.sourc就是节点值比如Apple  
  || (nodes[link.source] = {name: link.source});//(填加节点数据)  
    
  link.target = nodes[link.target] || (nodes[link.target] = {name: link.target});  
});  
  
var width =1300,  
    height = 800;  
  
var force = d3.layout.force()  
    .nodes(d3.values(nodes))  
    .links(links)  
    .size([width, height])  
    .linkDistance(600)  
    .charge(-300)  
    .on("tick", tick)  
    .start();  
  
var svg = d3.select("body").append("svg")  
    .attr("width", width)  
    .attr("height", height);  
//(3)为链接添加线  
var link = svg.selectAll(".link")  
    .data(force.links())  
    .enter().append("line")  
    .attr("class", "link");  
  
var colors=d3.scale.category20();   
     
link.style("stroke",function(d){//  设置线的颜色    
    return colors(d.color);    
})    
.style("stroke-width",function(d,i){//设置线的宽度    
    return d.weight;    
});  
//(4)为链接添加节点  
var node = svg.selectAll(".node")  
    .data(force.nodes())  
  .enter().append("g")  
    .attr("class", "node")  
    .on("mouseover", mouseover)  
    .on("mouseout", mouseout)  
    .call(force.drag);  
  
                                             
//设置圆点的半径，圆点的度越大weight属性值越大，可以对其做一点数学变换                               
function  radius (d){   
if(!d.weight){//节点weight属性没有值初始化为1（一般就是叶子了）  
d.weight=1;  
}                                                
    return Math.log(d.weight)*10;                                     
}                                                                     
node.append("circle")  
    .attr("r",function(d){  //设置圆点半径                        
    return radius (d);                            
 })                                             
.style("fill",function(d){ //设置圆点的颜色            
    return colors(d.weight*d.weight*d.weight);  
}) ;  
  
node.append("text")  
    .attr("x", 12)  
    .attr("dy", ".35em")  
    .text(function(d) { return d.name; });  
  
function tick() {//打点更新坐标  
  link  
      .attr("x1", function(d) { return d.source.x; })  
      .attr("y1", function(d) { return d.source.y; })  
      .attr("x2", function(d) { return d.target.x; })  
      .attr("y2", function(d) { return d.target.y; });  
  
  node  
      .attr("transform", function(d) {   
            return "translate(" + d.x + "," + d.y + ")";   
      });  
}  
  
function mouseover() {  
  d3.select(this).select("circle").transition()  
      .duration(750)  
      .attr("r", function(d){  //设置圆点半径                        
    return radius (d)+10;                            
 }) ;  
}  
  
function mouseout() {  
  d3.select(this).select("circle").transition()  
      .duration(750)  
      .attr("r", function(d){  //恢复圆点半径                        
    return radius (d);                            
 }) ;  
}  
</script> 
  
<script type="text/javascript"> 
                                                        
function myclick(){
	
	var medname=document.getElementById("input2").value;
	if(medname!= null&&medname!=""){
		
		document.body.innerHTML=" <input type='text' name='medname' id='input2'><br/><input type='button' value='查看' onclick='myclick()' id='evtBtn'><a href='index.jsp'><input type='button' value='返回'></a>";

		//NO1)
		var ajax =createAJAX();
		//NO2)
		var method = "POST";
		var url = "${pageContext.request.contextPath}/showRelationAction?time="+new Date().getTime();
		
		ajax.open(method,url);
		//NO3)
		ajax.setRequestHeader("content-type","application/x-www-form-urlencoded")
		//NO4)
		var content = "medname=" + medname;
		ajax.send(content);
		//-------------------------------------------等待
		
		//NO5
		ajax.onreadystatechange = function changedata(){
			if(ajax.readyState == 4){
				if(ajax.status == 200){
					//NO6)返回JAVA格式的JSON文本
					var jsonJAVA = ajax.responseText;
					//p所代表的是java格式的json文本，是不能直接被js执行的
					//解决方案：将java格式的json文本，转成js格式的json文本
					//如何做：用js提供的一个函数搞定
					var jsonJS = eval("("+jsonJAVA+")");
					//输出错误信息
					if(jsonJS.msg!=null)
					{
						alert(jsonJS.msg);
					}
					var array = jsonJS.rels;
					
					
					 //(1)链接数组  
					var links = [{source:"乌梅", target:"蜀椒"}, {source:"乌梅", target:"干姜"}, {source:"乌梅", target:"黄连"}, {source:"乌梅", target:"当归"}, {source:"乌梅", target:"炮附子"}, {source:"乌梅", target:"桂枝"}];
					var nodes = {};  
					
					
					links= array;
			
					function tick() {//打点更新坐标  
						  link  
						      .attr("x1", function(d) { return d.source.x; })  
						      .attr("y1", function(d) { return d.source.y; })  
						      .attr("x2", function(d) { return d.target.x; })  
						      .attr("y2", function(d) { return d.target.y; });  
						  
						  node  
						      .attr("transform", function(d) {   
						            return "translate(" + d.x + "," + d.y + ")";   
						      });  
						}  
						  
						function mouseover() {  
						  d3.select(this).select("circle").transition()  
						      .duration(750)  
						      .attr("r", function(d){  //设置圆点半径                        
						    return radius (d)+10;                            
						 }) ;  
						}  
						  
						function mouseout() {  
						  d3.select(this).select("circle").transition()  
						      .duration(750)  
						      .attr("r", function(d){  //恢复圆点半径                        
						    return radius (d);                            
						 }) ;  
						}  
					

					links.forEach(function(link) {  //思路就是：在连接中遍历链接，节点数组有了这个链接的源节点就把链接指向这个节点。没有的话把链接上的节点加到链接数组指定名称name属性，并把链接指向这个节点  
						console.log(nodes);                                    
						  link.source = nodes[link.source] //link.sourc就是节点值比如Apple  
						  || (nodes[link.source] = {name: link.source});//(填加节点数据)  
						    
						  link.target = nodes[link.target] || (nodes[link.target] = {name: link.target});  
						});  
						  
						var width =1300,  
						    height = 600;  
						  
						var force = d3.layout.force()  
						    .nodes(d3.values(nodes))  
						    .links(links)  
						    .size([width, height])  
						    .linkDistance(400)  
						    .charge(-300)  
						    .on("tick", tick)  
						    .start();  
						  
						var svg = d3.select("body").append("svg")  
						    .attr("width", width)  
						    .attr("height", height);  
						//(3)为链接添加线  
						var link = svg.selectAll(".link")  
						    .data(force.links())  
						    .enter().append("line")  
						    .attr("class", "link");  
						  
						var colors=d3.scale.category20();   
						     
						link.style("stroke",function(d){//  设置线的颜色    
						    return colors(d.color);    
						})    
						.style("stroke-width",function(d,i){//设置线的宽度    
						    return d.weight;    
						});  
						//(4)为链接添加节点  
						var node = svg.selectAll(".node")  
						    .data(force.nodes())  
						  .enter().append("g")  
						    .attr("class", "node")  
						    .on("mouseover", mouseover)  
						    .on("mouseout", mouseout)  
						    .call(force.drag);  
						  
						                                             
						//设置圆点的半径，圆点的度越大weight属性值越大，可以对其做一点数学变换                               
						function  radius (d){   
						if(!d.weight){//节点weight属性没有值初始化为1（一般就是叶子了）  
						d.weight=1;  
						}                                                
						    return Math.log(d.weight)*10;                                     
						}                                                                     
						node.append("circle")  
						    .attr("r",function(d){  //设置圆点半径                        
						    return radius (d);                            
						 })                                             
						.style("fill",function(d){ //设置圆点的颜色            
						    return colors(d.weight*d.weight*d.weight);  
						}) ;  
						  
						node.append("text")  
						    .attr("x", 12)  
						    .attr("dy", ".35em")  
						    .text(function(d) { return d.name; });
						  
						
				}
			}			
		}
		
	}
	
	

}

//var area = links[1];
//document.write(area.source+" "+area.target);
//(2)从链接中分离出不同的节点        
//一个小问题：节点的weight属性怎么产生的？                 


</script> 
  

       
       
    
    </body>    
</html>
