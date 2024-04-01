package com.heyqing.psychology_back.utils.tool;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:TopicRepo
 * Package:com.heyqing.psychology_back.utils.tool
 * Description:
 * 暂时写成静态
 *
 * @Date:2024/3/20
 * @Author:Heyqing
 */
@Component
public class TopicRepo {

    //topic

    /**
     * PSTR
     *
     * @return
     */
    public List<String> getPSTRTopicList() {
        List<String> list = addTopicList();
        return list;
    }

    /**
     * CDI
     *
     * @return
     */
    public List<String> getCDITopicList() {
        List<String> list = addCDITopicList();
        return list;
    }


    /**
     * MSSMHS
     *
     * @return
     */
    public List<String> getMSSMHSTopicList() {
        List<String> list = addMSSMHSTopicList();
        return list;
    }


    /**
     * EIS
     *
     * @return
     */
    public List<String> getEISTopicList() {
        List<String> list = addEISTopicList();
        return list;
    }


    /**
     * 中学生人际关系综合诊断量表
     *
     * @return
     */
    public List<String> getPTopicList() {
        List<String> list = addPTopicList();
        return list;
    }


    /**
     * 中学生学习方面心理测试题
     *
     * @return
     */
    public List<String> getLTopicList() {
        List<String> list = addLTopicList();
        return list;
    }


    //option
    public List<Object> getPSTROptionList() {
        List<Object> list = addOptionList();
        return list;
    }

    public List<Object> getCDIOptionList() {
        List<Object> list = addCDIOptionList();
        return list;
    }

    public List<Object> getMSSMHSOptionList() {
        List<Object> list = addMSSMHSOptionList();
        return list;
    }


    public List<Object> getEISOptionList() {
        List<Object> list = addEISOptionList();
        return list;
    }


    public List<Object> getPOptionList() {
        List<Object> list = addPOptionList();
        return list;
    }


    public List<Object> getLOptionList() {
        List<Object> list = addLOptionList();
        return list;
    }


    //answer
    public Map<String, Object> getPSTRAnswer(Integer answer) {
        return getPSTRAnswerByAnswer(answer);
    }

    public Map<String, Object> getCDIAnswer(Integer answer) {
        return getCDIAnswerByAnswer(answer);
    }


    public Map<String, Object> getMSSMHSAnswer(Integer answer) {
        return getMSSMHSAnswerByAnswer(answer);
    }


    public Map<String, Object> getEISAnswer(Integer answer) {
        return getEISAnswerByAnswer(answer);
    }


    public Map<String, Object> getPAnswer(Integer answer) {
        return getPAnswerByAnswer(answer);
    }


    public Map<String, Object> getLAnswer(Integer answer) {
        return getLAnswerByAnswer(answer);
    }


    /*******************************************private***************************************/


    private Map<String, Object> getLAnswerByAnswer(Integer answer) {
        Map<String, Object> map = new HashMap<>();
        String result = null;
        String suggest = null;
        result = "总分111分，得分越高预示您学习压力越小";
        suggest = "祝您生活愉快";
        map.put("answer", result);
        map.put("suggest", suggest);
        return map;
    }

    private Map<String, Object> getPAnswerByAnswer(Integer answer) {
        Map<String, Object> map = new HashMap<>();
        String result = null;
        String suggest = null;
        if (answer >= 0 && answer <= 8) {
            result = "那么说明你在与朋友相处上的困扰较少。你善于交谈，性格比较开朗，主动，关心别人，你对周围的朋友都比较好，屈意和他们在一起，他们也都喜欢你，你们相处得不错，而且，你能够从与朋友相处中，得到乐趣。你的生活是比较充实而且丰富多彩的，你与异性所友也相处得比较好。一句话，你不存在或较少存在交友方面的困扰，你苦于与朋友相处，人缘很好，获得许多的好感与赞同。";
        }
        if (answer >= 9 && answer <= 14) {
            result = "那么，你与朋友相处存在一定程度的困扰。你的人缘很根一般，换句话说，你和阴友的关系并不牢固，时好时坏，经常处在一种起伏波动之中";
        }
        if (answer >= 15 && answer <= 28) {
            result = "你的人际关系困扰程度很严重，而且在心理上出现较为明显得障碍。你可能不善于交谈，也可能是一个性格孤僻的人，不开朗，或者有明显得白高白大、讨人概的行为";
        }
        if (answer > 20) {
            suggest = "你在同期友相处上的行为困扰较严重";
        }
        map.put("answer", result);
        map.put("suggest", suggest);
        return map;
    }

    private List<Object> addPOptionList() {
        List<Object> list = new ArrayList<>();
        list.add("√");
        list.add("×");
        List<Object> ttList = new ArrayList<>();
        int score = 1;
        for (Object o : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("score", score--);
            map.put("option", o);
            ttList.add(map);
        }
        List<Object> resultList = new ArrayList<>();
        for (int i = 0; i < 28; i++) {
            resultList.add(ttList);
        }
        return resultList;
    }

    private List<Object> addEISOptionList() {
        List<Object> list = new ArrayList<>();
        list.add("很不符合");
        list.add("较不符合");
        list.add("不清楚");
        list.add("较符合");
        list.add("很符合");
        List<Object> ttList = new ArrayList<>();
        int score = 1;
        for (Object op : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("score", score++);
            map.put("option", op);
            ttList.add(map);
        }
        List<Object> tList = new ArrayList<>();
        int s = 5;
        for (Object o : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("score", s--);
            map.put("option", o);
            tList.add(map);
        }
        List<Object> resultList = new ArrayList<>();
        for (int i = 0; i < 33; i++) {
            if (i == 4 || i == 27 || i == 32) {
                resultList.add(tList);
            } else {
                resultList.add(ttList);
            }
        }

        return resultList;
    }

    private List<Object> addLOptionList() {
        List<Object> list = new ArrayList<>();
        list.add("较符合自己的情况");
        list.add("难回答");
        list.add("不符合自己的情况");
        List<Object> ttList = new ArrayList<>();
        int score = 3;
        for (Object op : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("score", score--);
            map.put("option", op);
            ttList.add(map);
        }
        List<Object> tList = new ArrayList<>();
        int s = 1;
        for (Object op : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("score", s++);
            map.put("option", op);
            tList.add(map);
        }

        List<Object> resultList = new ArrayList<>();
        for (int i = 0; i < 37; i++) {
            if (i >= 25) {
                resultList.add(tList);
            } else {
                resultList.add(ttList);
            }
        }
        return resultList;
    }

    private List<Object> addMSSMHSOptionList() {
        List<Object> list = new ArrayList<>();
        list.add("无");
        list.add("轻度");
        list.add("中度");
        list.add("偏重");
        list.add("严重");
        List<Object> ttList = new ArrayList<>();
        int score = 1;
        for (Object op : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("score", score++);
            map.put("option", op);
            ttList.add(map);
        }
        List<Object> resultList = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            resultList.add(ttList);
        }

        return resultList;
    }

    private List<String> addEISTopicList() {
        List<String> list = new ArrayList<>();
        list.add("我知道什么时候该和别人谈论我的私人问题。");
        list.add("当我面对某种困难时，我能够回忆起面对同样困难并克服它们的时候。");
        list.add("我期望我能够做好我想做的大多数的事情");
        list.add("别人很容易信任我。");
        list.add("我觉得我很难理解别人的身体语言。");
        list.add("我生命中的一些重大事件让我重新评估了什么是重要的什么是不重要的。");
        list.add("心境好的时候我就能看到新的希望。");
        list.add("我的生活是否有意义，情绪是影响因素之一，");
        list.add("我能清楚意识到自己体验的情绪");
        list.add("我希望能够有好的事情发生。");
        list.add("我喜欢和别人分享自己的情感。");
        list.add("情绪好的时候，我知道如何把它延长。");
        list.add("安排有关事情，我尽可能使别人感到满意。");
        list.add("我会去找一些让我感到开心的活动。");
        list.add("我很清楚我传递给别人的非言语信息。");
        list.add("我尽量做的好一些，以给别人留下好的印象。");
        list.add("当我心情好的时候，解决问题对我来说很容易。");
        list.add("通过观察面部表情，我可以辨别别人的情绪。");
        list.add("我知道自己情绪变化的原因。");
        list.add("心情好的时候，新奇的想法就会多一些。");
        list.add("我能够控制自己的情绪。");
        list.add("我很清楚自己在某一刻的情绪。");
        list.add("学习时我会想象自己即将取得好成绩，以激励自己。");
        list.add("当别人在某个方面做的很好时，我会称赞他们。");
        list.add("我能够了解别人传递给我的非言语信息。");
        list.add("当别人告诉我他人生中的某件重大事件时，我几乎感觉到好象发生在自己身上一样。");
        list.add("当我感到情绪变化时，就会涌现一些新颖的想法。");
        list.add("遇到困难时，一想到可能会失败，我就会退却。");
        list.add("只要看一眼，我就知道别人的情绪怎样。");
        list.add("当别人消沉时我能够帮助他，使他感觉好一点。");
        list.add("在挫折面前，我让自己保持良好的情绪以应对挑战。");
        list.add("我能够通过别人讲话的语调判断他当时的情绪。");
        list.add("我很难理解别人的想法和感受。");
        return list;
    }

    private List<String> addPTopicList() {
        List<String> list = new ArrayList<>();
        list.add("关于自己的烦恼有口难言。");
        list.add("和生人见面感觉不自然。");
        list.add("过分地美慕和妒忌别人");
        list.add("与异性交往太少：");
        list.add("对连续不断的会谈感到困难。");
        list.add("在社交场合，感到困难");
        list.add("时常伤害别人。");
        list.add("与异性来往感觉不自然");
        list.add("与一群朋友在一起，常感到孤寂或失落。");
        list.add("极易受窘，");
        list.add("与别人不能和睦相处。");
        list.add("不知道与异性相处如何适可而止");
        list.add("当不熟悉的人对自己倾诉他的生平遭遇以求同情时，自己常感到不自在。");
        list.add("担心别人对自己有什么坏印象。");
        list.add("总是尽力使别人赏识自己。");
        list.add("暗自思慕异性。");
        list.add("时常避免表达自己的感受。");
        list.add("对自己的仪表（容貌）缺乏信心。");
        list.add("讨厌某人或被某人所讨厌。");
        list.add("瞧不起异性。");
        list.add("不能专注地倾听。");
        list.add("自己的烦恼无人可申诉。");
        list.add("受别人排斥与冷漠。");
        list.add("被异性瞧不起。");
        list.add("不能广泛地听取各种意见、看法。");
        list.add("自己常因受伤害而暗自伤心。");
        list.add("常被别人谈论、愚弄。");
        list.add("与异性交往不知如何更好地相处。");
        return list;
    }

    private List<String> addLTopicList() {
        List<String> answers = new ArrayList<>();
// 第一部分：学习习惯
        answers.add("喜欢用笔勾出过记下阅读中不懂的地方。");
        answers.add("经常阅读与自己学习无直接关系的书籍。");
        answers.add("在观察或思考时，重视自己的看法。而且在遇到问题时，对自己的看法很有信心。");
        answers.add("在对老师将要讲的课会做很充分的预习，并且会预先做一些练习。");
        answers.add("遇到问题，我喜欢和同学一起讨论。");
        answers.add("为更好地理解老师讲的课程，我会对笔记等内容归纳成图表。");
        answers.add("听老师讲解问题时，眼睛注视着老师。");
        answers.add("我喜欢利用参考书和习题集。");
        answers.add("对于学习中的要点，我会很注意归纳并写出来。");
        answers.add("我不经常查阅字典、手册等工具书。");
        answers.add("我对作业和考试中的错误会进行修改，并根据试卷分析自己错误的原因。");
        answers.add("我认为重要的内容，就格外注意听讲和理解。");
        answers.add("阅读中若有不懂的地方，非弄懂不可。");
        answers.add("在学习的时候会经常联系其他学科内容进行学习。");
        answers.add("在动笔解题以前，先做全面的审题，有了设想后，才去解题。");
        answers.add("阅读中认为重要的或需要记住的地方就划上线或做上记号。");
        answers.add("经常向老师或他人请教不懂的问题。");
        answers.add("喜欢讨论学习中遇到的问题。");
        answers.add("我很注意别人好的学习方法，并努力学会。");
        answers.add("对需要记牢的公式、定理等反复进行记忆。");
        answers.add("经常观察实物或参考有关资料对其进行学习。");
        answers.add("听课时做完整的笔记。");
        answers.add("我有专门的错题本。");
        answers.add("如果实在不能独立解出习题，就看了答案再做。");
        answers.add("我经常制定学习计划，但不一定按照计划来做。");

        // 第二部分：应试心理
        answers.add("在重要考试的前几天，我就坐立不安了。");
        answers.add("我每天早上都会吃饭而且早餐很有营养。");
        answers.add("在考试前，我总感到苦恼。");
        answers.add("在考试前，我感到烦躁，脾气变坏。");
        answers.add("在紧张的温课期间，常会想到:这次考试要是得到低分数怎么办?");
        answers.add("越临近考试，上课时我的注意力就越难集中。");
        answers.add("一想到马上就要考试了，参加任何文娱活动都感到没劲。");
        answers.add("在考试前，我常做关于考试的梦。");
        answers.add("到了考试那天，我就不安起来。");
        answers.add("当听到开始考试的铃声响了，我的心马上紧张地急跳起来。");
        answers.add("遇到重要考试，我的脑子就变得比平时迟钝。");
        answers.add("看到考试题目越多、越难，我就越感到不安。");

        return answers;
    }

    private List<String> addMSSMHSTopicList() {
        List<String> list = new ArrayList<>();
        list.add("我不喜欢参加学校的课外活动。");
        list.add("我心情时好时坏。");
        list.add("做作业必须反复检查。");
        list.add("感到人们对我不友好，不喜欢我。");
        list.add("我感到苦闷。");
        list.add("我感到紧张或容易紧张。");
        list.add("我学习劲头时高时低。");
        list.add("我对现在的学校生活感到不适应。");
        list.add("我看不惯现在的社会风气。");
        list.add("为保证正确，做事必须做得很慢。");
        list.add("我的想法总与别人不一样。");
        list.add("总担心自己的衣服是否整齐。");
        list.add("容易哭泣。");
        list.add("我感到前途没有希望。");
        list.add("我感到坐立不安，心神不定。");
        list.add("经常责怪自己。");
        list.add("当别人看着我或谈论我时，感到不自在。");
        list.add("感到别人不理解我，不同情我。");
        list.add("我常发脾气，想控制但控制不住");
        list.add("觉得别人想占我的便宜");
        list.add("大叫或摔东西。");
        list.add("总在想一些不必要的事情。");
        list.add("必须反复洗手或反复数数。");
        list.add("总感到有人在背后谈论我。");
        list.add("时常与人争论、抬杠。");
        list.add("我觉得对大多数人都不可信任。");
        list.add("我对做作业的热情忽高忽低");
        list.add("同学考试成绩比我高，我感到难过。");
        list.add("我不适应老师的教学方法。");
        list.add("老师对我不公平。");
        list.add("我感到学习负担很重。");
        list.add("我对同学忽冷忽热。");
        list.add("上课时，总担心老师会提问自己。");
        list.add("我无缘无故地突然感到害怕。");
        list.add("我对老师时而亲近，时而疏远。");
        list.add("一听说要考试，心里就感到紧张。");
        list.add("别的同学穿戴比我好，有钱，我感到不舒服。");
        list.add("我讨厌做作业。");
        list.add("家里环境干扰我的学习。");
        list.add("我讨厌上学。");
        list.add("我不喜欢班里的风气。");
        list.add("父母对我不公平。");
        list.add("感到心里烦躁。");
        list.add("我常常无精打采，提不起劲来。");
        list.add("我感情容易受到别人的伤害。");
        list.add("觉得心里不踏实。");
        list.add("别人对我的表现评价不恰当。");
        list.add("明知担心没有用，但总害怕考不好。");
        list.add("总觉得别人在跟我作对。");
        list.add("我容易激动和烦恼。");
        list.add("同异性在一起时，感到害羞不自在。");
        list.add("有想伤害他人或打人的冲动。");
        list.add("我对父母时而亲热，时而冷淡。");
        list.add("我对比我强的同学并不服气。");
        list.add("我讨厌考试。");
        list.add("心里总觉得有事。");
        list.add("经常有自杀的念头。");
        list.add("有想摔东西的冲动。");
        list.add("要求别人十全十美。");
        list.add("同学考试成绩比我高，但能力并不比我强。");
        return list;
    }

    private List<String> addCDITopicList() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 27; i++) {
            result.add("");
        }
        return result;
    }

    private List<Object> addCDIOptionList() {
        List<String> list = new ArrayList<>();
        list.add("我偶尔感到不高兴");
        list.add("我经常感到不高兴");
        list.add("我总是感到不高兴");

        list.add("我不能解决任何问题");
        list.add("我能解决遇到的部分问题");
        list.add("我能解决遇到的任何问题");

        list.add("我做任何事情都不会出错");
        list.add("我做事情偶尔出错");
        list.add("我做事情经常出错");

        list.add("我做许多事情都有乐趣");
        list.add("我做事情偶尔有乐趣");
        list.add("我做任何事情都没有乐趣");

        list.add("我的表现一直都像个坏孩子");
        list.add("我的表现经常像个坏孩子");
        list.add("我的表现偶尔像个坏孩子");

        list.add("我偶尔担心不好事情发生");
        list.add("我经常担心不好事情发生");
        list.add("我总是担心不好事情发生");

        list.add("我恨我自己");
        list.add("我不喜欢我自己");
        list.add("我喜欢我自己");

        list.add("所有不好事情都是我的错");
        list.add("许多不好的事情都是我的错");
        list.add("仅有少数不好的事情是我的错");

        list.add("我没有自杀想法");
        list.add("我想过自杀但我不会去做");
        list.add("我可能会自杀");

        list.add("我偶尔感觉想哭");
        list.add("我每大都感觉想哭");
        list.add("我经常感觉想哭");

        list.add("偶尔有事情干扰我");
        list.add("总是有事情干扰我");
        list.add("经常有事情干扰我");

        list.add("我喜欢和别人在一起");
        list.add("我经常不喜欢和别人在一起");
        list.add("我总是不喜欢和别人在一起");

        list.add("我遇到事情总是拿不定主意");
        list.add("我遇到事情经常拿不定主意");
        list.add("我遇到事情很容从拿定主意");

        list.add("我长得很好看");
        list.add("我在长相上有些不如意");
        list.add("我长得很丑");

        list.add("我总足强迫自己去做作业");
        list.add("我经常强迫自己去做作业");
        list.add("我很容易完成作业");

        list.add("我每天晚上很难睡着觉");
        list.add("我经常晚上睡不着觉");
        list.add("我睡觉很好");

        list.add("我偶尔感到疲倦");
        list.add("我经常感到疲倦");
        list.add("我总是感到疲倦");

        list.add("我总是感到不想吃东西");
        list.add("我经常感到不想吃东西");
        list.add("我胃口很好");

        list.add("我不担心身体会疼痛");
        list.add("我经常担心身体会疼痛");
        list.add("我总是担心身体会疼痛");

        list.add("我感到不孤独");
        list.add("我经常感到孤独");
        list.add("我总是感到孤独");

        list.add("我总足感到上学没有趣");
        list.add("我偶尔感到上学有趣");
        list.add("我经常感到上学有趣");

        list.add("我有许多朋友");
        list.add("我有一些朋友");
        list.add("我没有任何朋友但是我希望有更多朋友");

        list.add("我在学校的学习还不错");
        list.add("我的学习比以前稍差");
        list.add("我以前很好的功课现在很差");

        list.add("我永远也不会像其他孩子");
        list.add("如果我努力，我会像其他孩子一样棒");
        list.add("我像其他孩子一样棒");

        list.add("没有人真正地爰我");
        list.add("我不确定是否有人爱我");
        list.add("我确定有人爱我");

        list.add("别人要我做的事，我通常会做");
        list.add("别人要我做的事，我有时会做");
        list.add("别人要我做的事，我从不做");

        list.add("我和别人相处很好");
        list.add("我有时和别人发生矛盾");
        list.add("我经常和别人发生矛盾");

        List<Object> ttList = new ArrayList<>();
        int score = 0;
        for (String op : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("score", score++);
            map.put("option", op);
            ttList.add(map);
            if (score == 3) {
                score = 0;
            }
        }
        List<Object> resultList = new ArrayList<>();
        int chunkSize = 3;
        for (int i = 0; i < ttList.size(); i += chunkSize) {
            int end = Math.min(i + chunkSize, ttList.size());
            List<Object> chunk = ttList.subList(i, end);
            resultList.add(chunk);
        }
        return resultList;
    }


    private List<Object> addOptionList() {
        List<Object> list = new ArrayList<>();
        list.add("总是");
        list.add("经常");
        list.add("有时");
        list.add("很少");
        list.add("从未");
        List<Object> ttList = new ArrayList<>();
        int score = 4;
        for (Object op : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("score", score--);
            map.put("option", op);
            ttList.add(map);
        }
        List<Object> resultList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            resultList.add(ttList);
        }

        return resultList;
    }

    private Map<String, Object> getEISAnswerByAnswer(Integer answer) {
        Map<String, Object> map = new HashMap<>();
        String result = "满分165分，得分越高，表明情绪智力水平越高。";
        String suggest = "祝您生活愉快";
        map.put("answer", result);
        map.put("suggest", suggest);
        return map;
    }

    private Map<String, Object> getMSSMHSAnswerByAnswer(Integer answer) {
        Map<String, Object> map = new HashMap<>();
        String result = null;
        String suggest = "建议去医院就诊";

        double s = answer / 60;

        if (s == 5) {
            result = "存在非常严重的心理健康问题。";
        } else if (s >= 4.00) {
            result = "存在较严重心理健康问题。";
        } else if (s >= 3.00) {
            result = "存在中等程度心理健康问题。";
        } else if (s >= 2.00) {
            result = "存在轻度的心理健康问题。";
            suggest = "建议您可以多出门走走";
        } else {
            result = "一切正常";
            suggest = "祝您生活愉快";
        }
        map.put("answer", result);
        map.put("suggest", suggest);
        return map;
    }

    private Map<String, Object> getCDIAnswerByAnswer(Integer answer) {
        Map<String, Object> map = new HashMap<>();
        String result = null;
        String suggest = null;

        if (answer >= 19) {
            result = "正常";
            suggest = "祝您生活愉快";
        } else {
            result = "抑郁症状";
            suggest = "建议去医院检查";
        }
        map.put("answer", result);
        map.put("suggest", suggest);
        return map;
    }

    private Map<String, Object> getPSTRAnswerByAnswer(Integer answer) {
        Map<String, Object> map = new HashMap<>();
        String result = null;
        String suggest = null;
        if (answer >= 93) {
            result = "表示你确实正以极度的压力反应伤害你自己的健康,你需要专业心理治疗师给与一些忠告,它可以帮助你削减你对压力器的知觉,并帮助你改良生活的品质。";
        } else if (answer >= 82) {
            result = "这个分数表示是你正经历太多的压力,这正在损害你的健康,并令你的人际关系发生问题。你的行为会伤害自己,也会影响其他人。因此,对你来说,学会如何减除自己的压力反应是非常必要的。你可能必须花时间做练习,学习控制压力,也可以寻求专业的帮助。";
        } else if (answer >= 71) {
            result = "这个分数显示你的压力程度中等,可能正开始对健康不利。你可以仔细反省自己对压力如何作出反应,并学习在压力出现时,控制自己的肌肉紧张,以消除生理激活反应。";
        } else if (answer >= 60) {
            result = "这个分数指出你生活中的兴奋与压力也许是相当适中的。偶尔会有一段时间压力太大,但你也许有能力去享受压力,并且很快回到平衡状态,因此对你的健康不会造成威胁。做一些松弛训练仍是有益的。";
        } else if (answer >= 49) {
            result = "这个分数表示你能够控制你自己的压力反应,你是一个相当放松的人。也许你对于所遇到的各种压力器,并没有将他们解释为威胁,所以你很容易与人相处,可以毫无惧怕地担任工作,也没有失去信心。";
        } else if (answer >= 38) {
            result = "这个分数表示你对所遭遇的压力很不易为所动,甚至是不当一回事,好像并没有发生过一样。这对你的健康不会有什么负面影响,但你的生活缺乏适度的兴奋,因此趣味也就有限。";
        } else if (answer >= 27) {
            result = "这个分数表明你的生活可能是相当沉闷的,即使刺激或有趣的事情发生了,你也很少作反应。可能你必须参加更多的社会活动或娱乐活动,以增加你的压力激活反应。";
        } else if (answer >= 16) {
            result = "如果你的分数值落在这个范围内,也许意味着你在生活中所经历的压力经验不够,或是你没有正确地分析你自己。你最好更主动些,在工作、社交、娱乐等活动上多增加些刺激。做松弛训练对你没有什么用,但找一些辅导也许会有帮助。";
        } else {
            result = "如果你的分数值落在这个范围内,也许意味着你在生活中所经历的压力经验不够,或是你没有正确地分析你自己。你最好更主动些,在工作、社交、娱乐等活动上多增加些刺激。做松弛训练对你没有什么用,但找一些辅导也许会有帮助。";
        }
        if (answer >= 43 && answer <= 65) {
            suggest = "你的压力是适中的，不必寻求改变生活形态";
        } else {
            suggest = "你可能需要调整生活形态。";
        }
        map.put("answer", result);
        map.put("suggest", suggest);
        return map;
    }

    private List<String> addTopicList() {
        List<String> list = new ArrayList<>();
        list.add("我受背疼之苦");
        list.add("我的睡眠不足、且睡不安稳");
        list.add("我有头疼");
        list.add("我额部疼痛");
        list.add("若须等候，我会不安");
        list.add("我的后颈感到疼痛");
        list.add("我比多数人更神经紧张");
        list.add("我很难入睡");
        list.add("我的头感到紧或疼");
        list.add("我的胃有病");
        list.add("我对自己没有信心");
        list.add("我对自己说话");
        list.add("我忧虑财务问题");
        list.add("与人见面时，我会窘怯");
        list.add("我怕发生可怕的事");
        list.add("白天我觉得累");
        list.add("下午我感到喉咙痛，但并非由于染上感冒");
        list.add("我心情不安，无法静坐");
        list.add("我感到非常口干");
        list.add("我心脏有病");
        list.add("我觉得自己不是很有用");
        list.add("我吸烟");
        list.add("我肚子不舒服");
        list.add("我觉得不快乐");
        list.add("我流汗");
        list.add("我喝酒");
        list.add("我很自觉");
        list.add("我觉得自己像四分五裂");
        list.add("我的眼睛又酸又累");
        list.add("我的腿或脚抽筋");
        list.add("我的心跳过速");
        list.add("我怕结识人");
        list.add("我手脚冰冷");
        list.add("我患便秘");
        list.add("我未经医师指示使用各种药");
        list.add("我发现自己很容易哭");
        list.add("我消化不良");
        list.add("我咬指甲");
        list.add("我耳中有嗡嗡声");
        list.add("我小便频密");
        list.add("我有胃溃疡");
        list.add("我有皮肤方面的病");
        list.add("我的咽喉很紧");
        list.add("我有十二指肠溃疡病");
        list.add("我担心我的工作");
        list.add("我口腔溃烂");
        list.add("我为琐事忧虑");
        list.add("我呼吸浅促");
        list.add("我觉得胸部紧迫");
        list.add("我发现很难做决定");
        return list;
    }

}
