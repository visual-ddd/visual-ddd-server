package com.wakedt.visual.domain.common.util.version;

import com.github.zafarkhaja.semver.ParseException;
import com.github.zafarkhaja.semver.Version;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * 语义化版本号工具类
 *
 * @author shimmer
 */
@Slf4j
public class VersionSortUtil {

    /**
     * 按照语义化版本号进行排序，并返回最新版本信息
     *
     * @param map 需要排序的版本号，版本信息
     * @return 最新版本
     */
    public static <T> T getLatestVersionData(Map<String, T> map) {
        T latestVersionData = null;
        Version latestVersion = null;
        for (Map.Entry<String, T> entry : map.entrySet()) {
            String currentVersion = entry.getKey();
            T data = entry.getValue();
            Version version = null;
            try {
                version = Version.valueOf(currentVersion);
            } catch (ParseException e) {
                log.error("版本号{}命名不符合标准", currentVersion, e);
            }
            // 初始化
            if (latestVersion == null || version == null) {
                latestVersion = version;
                latestVersionData = data;
                continue;
            }
            // 更新最新版本号
            if (version.greaterThan(latestVersion)) {
                latestVersion = version;
                latestVersionData = data;
            }
        }
        return latestVersionData;
    }

    /**
     * 对版本号为key，值为value的Map进行排序
     *
     * @param map 待排序的Map，包含版本号和对象
     * @return 排序后的值的集合，按照版本号从小到大排序
     */
    public static <K, V> List<V> sortMap(Map<K, V> map) {
        // 创建解析后的版本号和对象的Map
        Map<Version, V> parsedMap = new TreeMap<>(new VersionComparator());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            Version version = Version.valueOf(entry.getKey().toString());
            parsedMap.put(version, entry.getValue());
        }

        // 构造一个新的List<V>对象，将排序后的value添加到集合中
        return new ArrayList<>(parsedMap.values());
    }

    // 定义VersionComparator类实现Comparator接口，用于对Version对象进行比较
    static class VersionComparator implements Comparator<Version> {
        @Override
        public int compare(Version o1, Version o2) {
            return o1.compareTo(o2);
        }
    }
}