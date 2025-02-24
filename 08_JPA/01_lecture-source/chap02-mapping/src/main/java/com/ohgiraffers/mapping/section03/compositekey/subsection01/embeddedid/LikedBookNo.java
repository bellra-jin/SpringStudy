package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedid;

import jakarta.persistence.Column;

public class LikedBookNo {

    @Column(name = "LIKED_BOOK_NO")
    private int likedBookNo;

    protected LikedBookNo() {}

    public LikedBookNo(int likedBookNo) {
        this.likedBookNo = likedBookNo;
    }

    public int getLikedBookNo() {
        return likedBookNo;
    }

    @Override
    public String toString() {
        return "LikedBookNo{" +
                "likedBookNo=" + likedBookNo +
                '}';
    }
}
