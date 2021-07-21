package pers.wk.test;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CrawlerStatistics {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/kewu/Downloads/娱乐中心抓取数据统计 - Sheet2 (3).csv");
        List<String> lines = IOUtils.readLines(new FileInputStream(file), Charset.forName("utf-8"));

        Map<String, Map<String, List<String>>> result = new HashMap<>();

//        lines.stream().forEach(line -> {
//            if (line.contains("orderType")) {
//                return;
//            }
//            System.out.println(line);
//            String[] arr = line.split(",");
//            String rankId = arr[1];
//            String rankName = arr[0];
//            String rankPerson = arr[2];
//
//            String detailPerson = null;
//            if (arr.length > 3) {
//                detailPerson = arr[3];
//            }
//
//            if (rankPerson.contains("&")) {
//                String[] people = rankPerson.split("&");
//                for (String person : people) {
//                    Map<String, List<String>> personInfo = result.get(person);
//                    if (personInfo == null) {
//                        personInfo = new HashMap<>();
//                        result.put(person, personInfo);
//                    }
//                    List<String> rankList = personInfo.get("rank");
//                    if (rankList == null) {
//                        rankList = new ArrayList<>();
//                        personInfo.put("rank", rankList);
//                    }
//                    rankList.add(rankName + "【参与者】");
//                }
//            } else {
//                Map<String, List<String>> personInfo = result.get(rankPerson);
//                if (personInfo == null) {
//                    personInfo = new HashMap<>();
//                    result.put(rankPerson, personInfo);
//                }
//                List<String> rankList = personInfo.get("rank");
//                if (rankList == null) {
//                    rankList = new ArrayList<>();
//                    personInfo.put("rank", rankList);
//                }
//                rankList.add(rankName);
//            }
//            if (StringUtils.isNotEmpty(detailPerson)) {
//                Map<String, List<String>> personInfo = result.get(detailPerson);
//                if (personInfo == null) {
//                    personInfo = new HashMap<>();
//                    result.put(rankPerson, personInfo);
//                }
//                List<String> rankList = personInfo.get("detail");
//                if (rankList == null) {
//                    rankList = new ArrayList<>();
//                    personInfo.put("detail", rankList);
//                }
//                rankList.add(rankName);
//            }
//        });
//
//        result.entrySet().stream().forEach(entry -> {
//            System.out.println(entry.getKey());
//            Map<String, List<String>> map = entry.getValue();
//            List<String> rankList = map.get("rank");
//            System.out.printf("    榜单%d个：\n", rankList.size());
//            rankList.forEach(rank -> {
//                System.out.println("        " + rank);
//            });
//            List<String> detailList = map.get("detail");
//            if (detailList != null) {
//                System.out.printf("    详情页%d个：\n", detailList.size());
//                detailList.forEach(rank -> {
//                    System.out.println("        " + rank);
//                });
//            }
//        });

        Map<String, Set<String>> nameToApp = new HashMap<>();
        Map<String, Integer> nameToRankNum = new HashMap<>();
        Map<String, Set<String>> nameToDetailApp = new HashMap<>();
        Map<String, Integer> nameToDetailNum = new HashMap<>();
        Map<String, Set<String>> typeToApp = new HashMap<>();
        Map<String, Integer> typeToRankNum = new HashMap<>();

        lines.forEach(line -> {
            if (line.contains("orderType")) {
                return;
            }
            String[] arr = line.split(",");
            String app = arr[0];
            String rankName = arr[1];
            String orderType = arr[2];
            String rankPerson = arr[3];
            String detailPerson = null;
            if (arr.length > 4) {
                detailPerson = arr[4];
            }

            if (rankPerson.contains("北京") && !rankPerson.contains("&")) {
                return;
            }

            if (orderType.contains("material")) {
                putApp(typeToApp, app, "material");

                increase(typeToRankNum, "material");
            } else {
                putApp(typeToApp, app, "rank");

                increase(typeToRankNum, "rank");
            }

            if (detailPerson != null) {
                putApp(typeToApp, app, "detail");
                increase(typeToRankNum, "detail");
            }

            if (rankPerson.contains("&")) {
                String[] people = rankPerson.split("&");
                for (String person : people) {
                    putApp(nameToApp, app, person);
                    increase(nameToRankNum, person);
                }
            } else {
                putApp(nameToApp, app, rankPerson);
                increase(nameToRankNum, rankPerson);
            }

            if (detailPerson != null) {
                putApp(nameToDetailApp, app, detailPerson);
                increase(nameToDetailNum, detailPerson);
            }

        });

        for (Map.Entry<String, Set<String>> entry : typeToApp.entrySet()) {
            String type = entry.getKey();
            System.out.printf("%s appNum=%d rankNum=%d\n", type, entry.getValue().size(), typeToRankNum.get(type));
        }

        for (Map.Entry<String, Set<String>> entry : nameToApp.entrySet()) {
            String name = entry.getKey();
            System.out.printf("%s appNum=%d rankNum=%d detailApp=%d detailNum=%d\n", name, entry.getValue().size(), nameToRankNum.get(name),
                    nameToDetailApp.get(name).size(), nameToDetailNum.get(name));
        }
    }

    private static void putApp(Map<String, Set<String>> typeToApp, String app, String type) {
        Set<String> appSet = typeToApp.get(type);
        if (appSet == null) {
            appSet = new HashSet<>();
            typeToApp.put(type, appSet);
        }
        appSet.add(app);
    }

    private static void increase(Map<String, Integer> map, String key) {
        Integer value = map.get(key);
        if (value == null) {
            map.put(key, 1);
        } else {
            map.put(key, value + 1);
        }
    }
}
