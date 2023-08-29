package com.itany.corejava.code09_集合.set;

import java.util.Comparator;

/**
 * @author 石小俊
 * @date 2023年08月29日 16:08
 */
public class UserComparator implements Comparator<User> {

    /**
     * 比较规则:根据年龄降序
     * @param u1
     * @param u2
     * @return
     */
    @Override
    public int compare(User u1, User u2) {
        if (u1.getAge() > u2.getAge()) {
            return -1;
        } else if (u1.getAge() < u2.getAge()) {
            return 1;
        } else {
            return 0;
        }
    }
}
